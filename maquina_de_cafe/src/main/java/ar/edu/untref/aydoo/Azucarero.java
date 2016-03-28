package ar.edu.untref.aydoo;

/**
 * Clase Azucarero para agregar Azucar a la Maquina y al Vaso
 *
 */
public class Azucarero {
	private int topeAzucar;
	
	/**
	 * Constructor de la Clase
	 * @param cantidadAzucar
	 */
	public Azucarero(int cantidadAzucar) {
		this.topeAzucar = cantidadAzucar;
	}
	/**
	 * Devuelve la cantidad de Azucar en la maquina
	 * @return
	 */
	public int getTopeAzucar() {
		return topeAzucar;
	}
	/**
	 * Modifica la cantidad de Azucar en la maquina
	 * @param topeAzucar
	 */
	public void setTopeAzucar(int topeAzucar) {
		this.topeAzucar = topeAzucar;
	}
	/**
	 * Agrega Azucar al Vaso
	 * Ademas, disminuye la cantidad de Azucar en la maquina
	 * @param nCantidad
	 * @param ingresarAzucarEnVaso
	 * @return
	 */
	public Vaso ponerNEnEsteVaso (int nCantidad, Vaso ingresarAzucarEnVaso){
		ingresarAzucarEnVaso.setCantidadAzucar(nCantidad);
		this.topeAzucar -= nCantidad;
		return ingresarAzucarEnVaso;
	}
	
}
