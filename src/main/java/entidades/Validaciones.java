
package entidades;


public class Validaciones {
    private Validaciones() {
        
    }
    
    static String textoObligatorio (String valor, String mensajeError){
        if(valor == null || valor.trim().isEmpty()){
            throw new IllegalArgumentException(mensajeError);
        }
        return valor;
    }
    
    static void noNulo (Object valor, String mensajeError){
        if (valor == null){
            throw new IllegalArgumentException(mensajeError);
        }
    }
    
    static boolean sonDigitos (String texto){
        if (texto == null || texto.isEmpty()) {
            return false;
        }
        for (int i = 0; i < texto.length(); i++) {
           if(!Character.isDigit(texto.charAt(i))){
               return false;
           }            
        }
        return true;
    }
}
