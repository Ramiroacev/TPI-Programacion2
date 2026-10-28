
package entidades;

import enums.TipoSangre;
import java.time.LocalDate;
import java.time.Period;


public abstract class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaNacimiento;
    private TipoSangre tipoSangre;

    public Persona(String nombre, String apellido, String dni, LocalDate fechaNacimiento, TipoSangre tipoSangre) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public TipoSangre getTipoSangre() {
        return tipoSangre;
    }
    
    public String getNombreCompleto(){
        return nombre + ", " + apellido;
    }
    
    public int getEdad (){
        // Obtenemos la fecha actual
        LocalDate fechaActual = LocalDate.now();
        
        // Calculamos la edad
        int edad = Period.between(fechaNacimiento, fechaActual).getYears();
        
        return edad;
    }
    
}
