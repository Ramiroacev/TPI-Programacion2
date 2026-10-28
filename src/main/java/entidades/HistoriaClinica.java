
package entidades;

import java.time.LocalDate;


public class HistoriaClinica {
    private final int anioCreacion = LocalDate.now().getYear();
    private String diagnostico;
    private String Tratamiento;
    private String alergia;
    private Paciente paciente;
    
    // Creamos el constructor sin modificador de acceso para que solo
    // las clases del paquete puedan acceder a el y que no sea publico.
     HistoriaClinica(Paciente paciente) {
        this.paciente = paciente;
    }

    public Paciente getPaciente (){
        return paciente;
    }
    
    public String getNumeroHistoria() {
        return "HC-" + paciente.getDni() + "-" + anioCreacion;
    }
    
    public void agregarDiagnostico (String nuevoDiagnostico) {
        this.diagnostico = nuevoDiagnostico;
    }
    
    public void agregarTratamiento (String nuevoTratamiento) {
        this.Tratamiento = nuevoTratamiento;
    }
    
    public void agregarAlergia (String nuevaAlergia) {
        this.alergia = nuevaAlergia;
    }
    
    
}
