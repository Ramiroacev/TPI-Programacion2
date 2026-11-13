
package entidades;

import enums.TipoSangre;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Paciente extends Persona {
    private HistoriaClinica historiaClinica;
    private String telefono;
    private String direccion;
    private Hospital hospital;
    private List<Cita> citas;

    public Paciente(String nombre, String apellido, String dni, LocalDate fechaNacimiento, TipoSangre tipoSangre, String telefono, String direccion) {
        super(nombre, apellido, dni, fechaNacimiento, tipoSangre);
        this.telefono = Validaciones.textoObligatorio(telefono, "El telefono no puede estar vacio");
        this.direccion = Validaciones.textoObligatorio(direccion, "La direccion no puede estar vacia");
        this.citas = new ArrayList<>();
        
        // instanciamos la historia clinica por composicion
        this.historiaClinica = new HistoriaClinica(this);
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public Hospital getHospital() {
        return hospital;
    }
    
    // mantenemos sincronizada la relacion bidireccional con hospital
    public void setHospital(Hospital hospital) {
        if(this.hospital != hospital){
            if(this.hospital != null){
                this.hospital.getInternalPacientes().remove(this);
            }
            this.hospital = hospital;
            if(hospital != null && !hospital.getInternalPacientes().contains(this)){
                hospital.getInternalPacientes().add(this);
            }
        }
    }   
    
    public void addCita(Cita cita){
        Validaciones.noNulo(cita, "La cita no puede estar vacia");
        if (cita.getPaciente() != this){
            throw new IllegalArgumentException("La cita ya pertenece a otro paciente");
        }
        if(!this.citas.contains(cita)) {
            this.citas.add(cita);           
        }
    }
    
    public List<Cita> getCitas() {
        return Collections.unmodifiableList(citas);
    }
    

            
   
    
}
