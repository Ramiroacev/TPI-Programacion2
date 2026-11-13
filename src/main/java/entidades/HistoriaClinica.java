
package entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
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
        Validaciones.noNulo(paciente, "Para poder dar de alta la historia clinica el paciente no puede ser nulo");
        this.paciente = paciente;
        this.fechaCreacion = LocalDateTime.now();        
        this.numeroHistoria = this.generarNumeroHistoria();
        this.diagnosticos = new ArrayList<>();
        this.tratamientos = new ArrayList<>();
        this.alergias = new ArrayList<>();
    }
     
    public String getNumeroHistoria() {
        return numeroHistoria;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    
    public void agregarDiagnostico(String diagnostico) {
        agregarSiNoEstaVacio(diagnosticos, diagnostico);
    }
    
     public void agregarTratamiento(String tratamiento) {
        agregarSiNoEstaVacio(tratamientos, tratamiento);
    }
     
     public void agregarAlergia(String alergia) {
        agregarSiNoEstaVacio(alergias, alergia);
    }

    public List<String> getDiagnosticos() {
        return Collections.unmodifiableList(diagnosticos);
    }

    public List<String> getTratamientos() {
        return Collections.unmodifiableList(tratamientos);
    }

    public List<String> getAlergias() {
        return Collections.unmodifiableList(alergias);
    }   
    
     private String generarNumeroHistoria() {
         return "HC-" + this.paciente.getDni() + "-" + this.fechaCreacion.getYear();
     }
     
     private void agregarSiNoEstaVacio(List<String> lista, String texto){
         if(texto != null && !texto.trim().isEmpty()){
             lista.add(texto);
         }
     }
}
