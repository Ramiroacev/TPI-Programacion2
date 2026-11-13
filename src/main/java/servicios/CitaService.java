
package servicios;

import entidades.Cita;
import entidades.Medico;
import entidades.Paciente;
import entidades.Sala;
import excepciones.CitaException;
import java.time.LocalDateTime;
import java.util.List;


public interface CitaService {
    Cita programarCita (Paciente paciente, Medico medico, Sala sala, LocalDateTime fechaHora, double costo) throws CitaException;
    
    List<Cita> getCitasPorPaciente(Paciente paciente);
    
    List<Cita> getCitasPorMedico(Medico medico);
    
    List<Cita> getCitasPorSala(Sala sala);
}
