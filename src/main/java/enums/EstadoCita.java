
package enums;


public enum EstadoCita {
    PROGRAMADA("Programada"),
    EN_CURSO("En Curso"),
    COMPLETADA("Completada"),
    CANCELADA("Cancelada"),
    NO_ASISTIO("No Asistio");
    
    private String descripcion;

    private EstadoCita(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
}
