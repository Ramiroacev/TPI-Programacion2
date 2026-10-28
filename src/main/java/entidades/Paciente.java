
package entidades;

import enums.TipoSangre;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Paciente extends Persona {
    private HistoriaClinica historiaClinica;
    private String telefono;
    private String direccion;
    private Hospital hospital;
    private List<Cita> citas;

    public Paciente(String telefono, String direccion, String nombre, String apellido, String dni, LocalDate fechaNacimiento, TipoSangre tipoSangre) {
        super(nombre, apellido, dni, fechaNacimiento, tipoSangre);
        this.telefono = telefono;
        this.direccion = direccion;
        this.citas = new ArrayList<>();
        
        // instanciamos la historia clinica
        this.historiaClinica = new HistoriaClinica(this);
    }
    
    public String getDni(){
        return super.getDni();
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

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }   
    
    public List<Cita> getCitas() {
        return citas;
    }
    
    public void addCita(Cita cita){
        this.citas.add(cita);
    }

            
   
    
}
