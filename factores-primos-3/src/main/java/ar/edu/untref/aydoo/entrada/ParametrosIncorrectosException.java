package ar.edu.untref.aydoo.entrada;

@SuppressWarnings("serial")
public class ParametrosIncorrectosException extends Exception {

	public ParametrosIncorrectosException() {
		super("El ingreso de parametros es incorrecto. Por favor vuelva a ingresarlo");
	}

}
