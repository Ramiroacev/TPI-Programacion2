
package entidades;

import java.util.List;


public class Sala {
    private String numero;
    private String tipo;
    private Departamento departamento;
    private List<Cita> citas;

    Sala(String numero, String tipo, Departamento departamento) {
        this.numero = numero;
        this.tipo = tipo;
        this.departamento = departamento;
    }
    
    
}
