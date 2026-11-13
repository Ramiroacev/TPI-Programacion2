
package servicios;

import entidades.Cita;
import entidades.Medico;
import entidades.Paciente;
import entidades.Sala;
import excepciones.CitaException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CitaManager implements CitaService {
    private final int HORAS_ENTRE_CITAS = 2;
    private List<Cita> citas = new ArrayList<>();

    @Override
    public Cita programarCita(Paciente paciente, Medico medico, Sala sala, LocalDateTime fechaHora, double costo) throws CitaException {
        if (paciente == null || medico == null || sala == null) {
            throw new CitaException("El paciente, el medico y la sala son obligatorios");
        }
        validarCita(fechaHora, costo);
        if(medico.getEspecialidad() != sala.getDepartamento().getEspecialidad()) {
            throw new CitaException("La especialidad del medico: " + medico.getEspecialidad().getDescripcion() 
                    + ", no coincide con la especialidad de la sala que es: " + sala.getDepartamento().getEspecialidad().getDescripcion());
        }
        if(!esMedicoDisponible(medico, fechaHora)){
            throw new CitaException("El medico ya tiene una cita programada a menos de " + HORAS_ENTRE_CITAS + " horas.");
        }
        if(!esSalaDisponible(sala, fechaHora)){
            throw new CitaException("La sala ya tiene una cita programada a menos de " + HORAS_ENTRE_CITAS + " horas.");
        }
                
        Cita cita = new Cita(paciente, medico, sala, fechaHora, costo);
        citas.add(cita);
        paciente.addCita(cita);
        medico.addCita(cita);
        sala.addCita(cita);
        
        return cita;
    }

    @Override
    public List<Cita> getCitasPorPaciente(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("Se debe indicar un paciente");
        }
        List<Cita> resultado = new ArrayList<>();
        
        for (Cita cita : citas) {
            if(cita.getPaciente() == paciente){
                resultado.add(cita);
            }
        }
        return Collections.unmodifiableList(resultado);
    }

    @Override
    public List<Cita> getCitasPorMedico(Medico medico) {
        if (medico == null) {
            throw new IllegalArgumentException("Se debe indicar un medico");
        }
        List<Cita> resultado = new ArrayList<>();
        
        for (Cita cita : citas) {
            if(cita.getMedico() == medico){
                resultado.add(cita);
            }
        }
        return Collections.unmodifiableList(resultado);
    }

    @Override
    public List<Cita> getCitasPorSala(Sala sala) {
        if (sala == null) {
            throw new IllegalArgumentException("Se debe indicar una sala");
        }
        List<Cita> resultado = new ArrayList<>();
        
        for (Cita cita : citas) {
            if(cita.getSala() == sala){
                resultado.add(cita);
            }
        }
        return Collections.unmodifiableList(resultado);
    }
    
    private void validarCita (LocalDateTime fechaHora, double costo) throws CitaException {
        if (fechaHora == null ) {
            throw new CitaException("La fecha y hora de la cita es obligatoria");
        }
        if (fechaHora.isBefore(LocalDateTime.now())) {
            throw new CitaException("La fecha de la cita no puede ser una fecha anterior a hoy");
        }
        if (costo <= 0) {
            throw new CitaException("El costo debe ser un valor mayor a 0");
        }
    }
    
    private boolean esMedicoDisponible (Medico medico, LocalDateTime fechaHora) {
        for (Cita cita : citas) {
            if (cita.getMedico() == medico && seSuperponen(cita.getFechaHora(), fechaHora)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean esSalaDisponible(Sala sala, LocalDateTime fechaHora){
        for (Cita cita : citas) {
            if (cita.getSala() == sala && seSuperponen(cita.getFechaHora(), fechaHora)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean seSuperponen (LocalDateTime fechaHrExistente, LocalDateTime fechaHrNueva) {
        return fechaHrNueva.isAfter(fechaHrExistente.minusHours(HORAS_ENTRE_CITAS)) &&
           fechaHrNueva.isBefore(fechaHrExistente.plusHours(HORAS_ENTRE_CITAS));
    }
}
