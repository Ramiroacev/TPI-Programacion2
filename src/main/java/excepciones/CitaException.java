
package excepciones;


public class CitaException extends Exception {
    
    private static final long serialVersionUID = 1L;
   
    public CitaException (String mensaje) {
        super(mensaje);
    }
    
    public CitaException (String mensaje, Throwable cause) {
        super(mensaje, cause);
    }
}
