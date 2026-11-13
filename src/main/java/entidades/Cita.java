
package entidades;

import enums.EstadoCita;
import java.time.LocalDateTime;


public class Cita {
    private Paciente paciente;
    private Medico medico;
    private Sala sala;
    private LocalDateTime fechaHora;
    private double costo;
    private EstadoCita estado;
    private String observaciones;

    public Cita(Paciente paciente, Medico medico, Sala sala, LocalDateTime fechaHora, double costo) {
        Validaciones.noNulo(paciente, "Para crear una nueva cita se necesita un paciente");
        Validaciones.noNulo(medico, "Para crear una nueva cita se necesita un medico");
        Validaciones.noNulo(sala, "Para crear una nueva cita se necesita una sala");
        Validaciones.noNulo(fechaHora, "Para crear una nueva cita se necesita una fecha y hora");
        this.paciente = paciente;
        this.medico = medico;
        this.sala = sala;
        this.fechaHora = fechaHora;
        this.costo = costo;
        this.estado = EstadoCita.PROGRAMADA;
        this.observaciones = "";
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public Sala getSala() {
        return sala;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public double getCosto() {
        return costo;
    }

    public EstadoCita getEstado() {
        return estado;
    }
    
    // Si se quiere cambiar el estado y el mismo es nulo se lanza una excepcion 
    // y el estado no cambia
    public void setEstado(EstadoCita estado) {
        Validaciones.noNulo(estado, "El estado de la cita no puede ser nulo");
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = (observaciones == null) ? "" : observaciones;
    }    
    
}
