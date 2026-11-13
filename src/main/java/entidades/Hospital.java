
package entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Hospital {
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Departamento> departamentos;
    private List<Paciente> pacientes;

    public Hospital(String nombre, String direccion, String telefono) {
        this.nombre = Validaciones.textoObligatorio(nombre, "El nombre del hospital no puede estar vacio");
        this.direccion = Validaciones.textoObligatorio(direccion, "La direccion del hospital no puede estar vacia");;
        this.telefono = Validaciones.textoObligatorio(telefono, "El nombre del hospital no puede estar vacio");;
        this.departamentos = new ArrayList<>();
        this.pacientes = new ArrayList<>();
    }
    
    // Delegamos a departamento la responsabilidad, para mantener la relacion bidireccional
    public void agregarDepartamento (Departamento departamento) {
        Validaciones.noNulo(departamento, "El departamento no puede estar vacio");
        departamento.setHospital(this);
    }
    
    // Delegamos a paciente la responsabilidad, para mantener la relacion bidireccional
    public void agregarPaciente (Paciente paciente) {
        Validaciones.noNulo(paciente, "El departamento no puede estar vacio");
        paciente.setHospital(this);
    }
    
    // devolvemos una copia de la lista para protegerla y que la misma no sea modificada
    public List<Departamento> getDepartamentos() {
        return Collections.unmodifiableList(departamentos);
    }

    public List<Paciente> getPacientes() {
        return Collections.unmodifiableList(pacientes);
    }
    
    // sin modificador de acceso para que solo el paquete pueda acceder
    List<Departamento> getInternalDepartamentos () {
        return departamentos;
    }
    // sin modificador de acceso para que solo el paquete pueda acceder
    List<Paciente> getInternalPacientes () {
        return pacientes;
    }
}
