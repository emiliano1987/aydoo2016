package ar.edu.untref.aydoo.modelo;

@SuppressWarnings("serial")
public class NumeroIncorrectoException extends Exception {

	public NumeroIncorrectoException(){
		super("Se ha ingresado un valor incorrecto. Por favor verifique que el mismo no sea menor a 0");
	}

}
