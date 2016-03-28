package ar.edu.untref.aydoo;

/**
 * Clase que va a crear el Vaso para luego modificarlo segun solicite
 *
 */
public class Vaso {
	Bebidas nuevaBebida;
	Bebidas segundaBebida;
	int cantidadAzucar;
	/**
	 * Constructor de la clase Vaso
	 */
	public Vaso (){
		this.setNuevaBebida(nuevaBebida);
		this.setSegundaBebida(segundaBebida);
		setCantidadAzucar(cantidadAzucar);
	}
	/**
	 * Modifica la cantidad de Azucar en el Vaso
	 * @param cantidadAzucar
	 */
	public void setCantidadAzucar(int cantidadAzucar) {
		this.cantidadAzucar = cantidadAzucar;
	}
	/**
	 * Modifica el primer liquido ingresado en el Vaso
	 * @param nuevaBebida
	 */
	public void setNuevaBebida(Bebidas nuevaBebida) {
		this.nuevaBebida = nuevaBebida;
	}
	/**
	 * Retorna el segundo liquido ingresado en el Vaso
	 * @return
	 */
	public Bebidas getSegundaBebida() {
		return segundaBebida;
	}
	/**
	 * Modifica el segundo liquido ingresado en el Vaso
	 * @param segundaBebida
	 */
	public void setSegundaBebida(Bebidas segundaBebida) {
		this.segundaBebida = segundaBebida;
	}
	/**
	 * Retorna la cantidad de azucar en el Vaso
	 * @return
	 */
	public int getCantidadAzucar() {
		return cantidadAzucar;
	}
	/**
	 * Retorna el primer liquido ingresado en el Vaso
	 * @return
	 */
	public Bebidas getNuevaBebida() {
		return nuevaBebida;
	}
}
