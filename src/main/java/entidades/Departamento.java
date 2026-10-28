
package entidades;

import enums.EspecialidadMedica;
import java.util.ArrayList;
import java.util.List;


public class Departamento {
    private String nombre;
    private EspecialidadMedica especialidad;
    private Hospital hospital;
    private List<Medico> medicos;
    private List<Sala> salas;

    public Departamento(String nombre, EspecialidadMedica especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.medicos = new ArrayList<>();
        this.salas = new ArrayList<>();
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
    
    public void agregarMedico (Medico medico) {
        this.medicos.add(medico);
    }
    
    public Sala crearSala (String numero, String tipo) {
        Sala sala = new Sala(numero, tipo, this);
        
        this.salas.add(sala);
        
        return sala;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public List<Sala> getSalas() {
        return salas;
    }
    
    List<Medico> getInternalMedicos () {
        return medicos;
    }
    
}
