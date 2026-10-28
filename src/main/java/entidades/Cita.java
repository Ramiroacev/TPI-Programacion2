
package entidades;

import enums.EstadoCita;
import java.time.LocalDateTime;


public class Cita {
    private Paciente paciente;
    private Medico medico;
    private Sala sala;
    private LocalDateTime fechaHora;
    private double costo;
    private EstadoCita estado;
    private String observaciones;
    
}
