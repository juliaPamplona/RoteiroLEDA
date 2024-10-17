package conjuntoDinamico;

public class ConjuntoVazioException extends Exception {

public ConjuntoVazioException() {
	super("Conjunto vazio!");
};

public ConjuntoVazioException(java.lang.String message) {
	super(message);
}
}