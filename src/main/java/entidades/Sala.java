
package entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Sala {
    private String numero;
    private String tipo;
    private Departamento departamento;
    private List<Cita> citas;

    Sala(String numero, String tipo, Departamento departamento) {
        this.numero = Validaciones.textoObligatorio(numero, "El numero de la sala no puede estar vacio");
        this.tipo = Validaciones.textoObligatorio(tipo, "El tipo de sala no pede estar vacio");
        Validaciones.noNulo(departamento, "El departamento de la sala no puede ser vacio");
        this.departamento = departamento;
        this.citas = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
    
    public void addCita (Cita cita){
        Validaciones.noNulo(cita, "La cita no puede estar vacia");
        if (cita.getSala() != this){
            throw new IllegalArgumentException("La cita ya pertenece a otra sala");
        }
        if(!this.citas.contains(cita)) {
            this.citas.add(cita);           
        }
    }

    public List<Cita> getCitas() {
        return Collections.unmodifiableList(citas);
    }
    
    
    
    
}
