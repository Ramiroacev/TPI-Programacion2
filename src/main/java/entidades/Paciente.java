
package entidades;

import enums.TipoSangre;
import java.time.LocalDate;


public class Paciente extends Persona {
    private String telefono;
    private String direccion;
    private HistoriaClinica historiaClinica;

    public Paciente(String telefono, String direccion, String nombre, String apellido, String dni, LocalDate fechaNacimiento, TipoSangre tipoSangre) {
        super(nombre, apellido, dni, fechaNacimiento, tipoSangre);
        this.telefono = telefono;
        this.direccion = direccion;
        this.historiaClinica = new HistoriaClinica(this);
    }
    
    
    
    
               
   
    
}
