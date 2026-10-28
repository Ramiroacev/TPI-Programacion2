
package entidades;

import java.util.ArrayList;
import java.util.List;


public class Hospital {
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Departamento> departamentos;
    private List<Paciente> pacientes;

    public Hospital(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.departamentos = new ArrayList<>();
        this.pacientes = new ArrayList<>();
    }
    
    public void agregarDepartamento (Departamento departamento) {
        this.departamentos.add(departamento);
    }
    
    public void agregarPaciente (Paciente paciente) {
        this.pacientes.add(paciente);
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }
    
    List<Departamento> getInternalDepartamentos () {
        return departamentos;
    }
    
    List<Paciente> getInternalPacientes () {
        return pacientes;
    }
}
