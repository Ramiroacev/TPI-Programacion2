
package entidades;

import enums.EspecialidadMedica;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Departamento {
    private String nombre;
    private EspecialidadMedica especialidad;
    private Hospital hospital;
    private List<Medico> medicos;
    private List<Sala> salas;

    public Departamento(String nombre, EspecialidadMedica especialidad) {
        this.nombre = Validaciones.textoObligatorio(nombre, "El nombre del departamento no puede estar vacio");
        Validaciones.noNulo(especialidad, "La especialidad del departamento no puede estar vacia");
        this.especialidad = especialidad;
        this.medicos = new ArrayList<>();
        this.salas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public EspecialidadMedica getEspecialidad() {
        return especialidad;
    }

    public Hospital getHospital() {
        return hospital;
    }  
    
    // Relacion bidireccional con hospital
    public void setHospital(Hospital hospital) {
        if (this.hospital != hospital){
            if(this.hospital != null){
                this.hospital.getInternalDepartamentos().remove(this);
            }
            this.hospital = hospital;
            if(hospital != null && !hospital.getInternalDepartamentos().contains(this)){
                hospital.getInternalDepartamentos().add(this);
            }
        }
    }
    
    // se delega la responsabilidad a medico.setDepartamento para sincronizar las dos puntas
    // por ser una relacion bidireccional
    public void agregarMedico (Medico medico) {
        Validaciones.noNulo(medico, "El medico no puede ser nulo");
        medico.setDepartamento(this);
    }
    
    // relacion de composicion un departemento crea la sala
    public Sala crearSala (String numero, String tipo) {
        Sala sala = new Sala(numero, tipo, this);        
        this.salas.add(sala);        
        return sala;
    }

    public List<Medico> getMedicos() {
        return Collections.unmodifiableList(medicos);
    }

    public List<Sala> getSalas() {
        return Collections.unmodifiableList(salas);
    }
    
    // Sin modificador para que solo el paquete pueda acceder
    List<Medico> getInternalMedicos () {
        return medicos;
    }
    
}
