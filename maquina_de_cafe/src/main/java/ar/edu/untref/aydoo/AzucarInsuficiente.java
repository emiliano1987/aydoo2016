package ar.edu.untref.aydoo;

/**
 * Clase para utilizar de Excepcion cuando el Azucar en la Maquina sea menor al solicitado
 * @author emiliano
 *
 */
public class AzucarInsuficiente extends Exception {
	public AzucarInsuficiente(String msg) {
	        super(msg);
	 }
}
