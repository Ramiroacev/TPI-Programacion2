
package entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class HistoriaClinica {
    private String numeroHistoria; 
    private Paciente paciente;
    private LocalDateTime fechaCreacion;
    private List<String> diagnosticos;
    private List<String> tratamientos;
    private List<String> alergias;
    
        
    // Creamos el constructor sin modificador de acceso para que solo
    // las clases del paquete puedan acceder a el y que no sea publico.
     HistoriaClinica(Paciente paciente) {
        this.paciente = paciente;
        this.fechaCreacion = LocalDateTime.now();        
        this.numeroHistoria = this.generarNumeroHistoria();
        this.diagnosticos = new ArrayList<>();
        this.tratamientos = new ArrayList<>();
        this.alergias = new ArrayList<>();
    }
     
     private String generarNumeroHistoria() {
         return "HC-" + this.paciente.getDni() + "-" + this.fechaCreacion.getYear();
     }

    public String getNumeroHistoria() {
        return numeroHistoria;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    
    public void agregarDiagnostico(String diagnostico) {
        this.diagnosticos.add(diagnostico);
    }
    
     public void agregarTratamiento(String tratamiento) {
        this.tratamientos.add(tratamiento);
    }
     
     public void agregarAlergia(String alergia) {
        this.alergias.add(alergia);
    }

    public List<String> getDiagnosticos() {
        return diagnosticos;
    }

    public List<String> getTratamientos() {
        return tratamientos;
    }

    public List<String> getAlergias() {
        return alergias;
    }   
    
}
