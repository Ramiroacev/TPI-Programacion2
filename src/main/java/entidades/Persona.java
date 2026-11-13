
package entidades;

import enums.TipoSangre;
import java.time.LocalDate;

// Persona es una clase abstracta lo cual no se puede instanciar directamente
public abstract class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaNacimiento;
    private TipoSangre tipoSangre;

    public Persona(String nombre, String apellido, String dni, LocalDate fechaNacimiento, TipoSangre tipoSangre) {
        this.nombre = Validaciones.textoObligatorio(nombre, "El nombre es obligatorio");
        this.apellido = Validaciones.textoObligatorio(apellido, "El apellido es obligatorio");
        this.dni = validarDni(dni);
        Validaciones.noNulo(fechaNacimiento, "La fecha de nacimiento es obligatoria");
        Validaciones.noNulo(tipoSangre, "El tipo de sangre es obligatorio");
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
        return nombre + " " + apellido;
    }
    
    public int getEdad (){        
        LocalDate hoy = LocalDate.now();
        int edad = hoy.getYear() - fechaNacimiento.getYear();

        if (fechaNacimiento.plusYears(edad).isAfter(hoy)) {
            edad--;
        }

        return edad;
    }
    
    private String validarDni(String dni){
        if(dni == null || dni.length() < 7 || dni.length() > 8 || !Validaciones.sonDigitos(dni)){
            throw new IllegalArgumentException("El DNI debe tener 7 u 8 digitos");
        }
        return dni;
    }
    
}
