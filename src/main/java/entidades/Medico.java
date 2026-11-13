
package entidades;

import enums.EspecialidadMedica;
import enums.TipoSangre;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Medico extends Persona {
    private Matricula matricula;
    private EspecialidadMedica especialidad;
    private Departamento departamento;
    private List<Cita> citas;

    public Medico(String nombre, String apellido, String dni, LocalDate fechaNacimiento, TipoSangre tipoSangre, String numeroMatricula, EspecialidadMedica especialidad) {
        super(nombre, apellido, dni, fechaNacimiento, tipoSangre);
        Validaciones.noNulo(especialidad, "El medico debe tener una especialidad, la misma no puede estar vacia");
        this.especialidad = especialidad;
        this.citas = new ArrayList<>();
        // Instanciamos una nueva matricula por composicion
        this.matricula = new Matricula(numeroMatricula);
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public EspecialidadMedica getEspecialidad() {
        return especialidad;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
    
    // Relacion bidireccional con Departamento y solo se acepta un departamento
    // de la misma especialidad
    public void setDepartamento(Departamento departamento) {
        if(departamento != null && departamento.getEspecialidad() != especialidad){
            throw new IllegalArgumentException("El medico con especialidad " + especialidad.getDescripcion() 
                    + " no puede trabajar en el departamento con especialidad " + departamento.getEspecialidad().getDescripcion() );
        }
        if (this.departamento  != departamento) {
            if(this.departamento != null){
                this.departamento.getInternalMedicos().remove(this);
            }
            this.departamento = departamento;
            if (departamento != null && !departamento.getInternalMedicos().contains(this)){
                departamento.getInternalMedicos().add(this);
            }
        }
    }
    
    public void addCita (Cita cita){
        Validaciones.noNulo(cita, "La cita no puede estar vacia");
        if (cita.getMedico() != this){
            throw new IllegalArgumentException("La cita pertenece a otro medico");
        }
        if(!this.citas.contains(cita)){
            this.citas.add(cita);
        }
    }

    public List<Cita> getCitas() {
        return Collections.unmodifiableList(citas);
    }   
    
}
