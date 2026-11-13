
package entidades;


public class Matricula {
    private static final String PREFIJO = "MP-";
    private static final int MIN_DIGITOS = 4;
    private static final int MAX_DIGITOS = 6;
    
    private String numero;

    public Matricula(String numero) {
        this.numero = this.validarMatricula(numero);
    }

    public String getNumero() {
        return numero;
    }
    
    private String validarMatricula(String numero){
        if (numero == null || !numero.startsWith(PREFIJO)){
            throw new IllegalArgumentException("La matricula debe empezar con " + PREFIJO);
        }
        String digitos = numero.substring(PREFIJO.length());
        if (digitos.length() < MIN_DIGITOS || digitos.length() > MAX_DIGITOS || !Validaciones.sonDigitos(digitos)) {
            throw new IllegalArgumentException("La matricula debe tener entre " + MIN_DIGITOS
                    + " y " + MAX_DIGITOS + " digitos despues de " + PREFIJO);
        }
        return numero;
    }
}
