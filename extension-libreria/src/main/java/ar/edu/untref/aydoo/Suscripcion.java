package ar.edu.untref.aydoo;

public class Suscripcion {

	private Cliente cliente;
	private Suscriptible suscriptible;
	private boolean esAnual;

	/**
	 * @Pre: cliente y suscriptible son distintos de null.
	 * @Post: Se crea la Suscripcion con el cliente, el suscriptible indicados, y el boolean que indica si se refiere a una suscripcion anual o no.
	 */
	public Suscripcion(Cliente cliente, Suscriptible suscriptible, boolean esAnual){

		this.cliente = cliente;
		this.suscriptible = suscriptible;
		this.esAnual = esAnual;

	}

	/**
	 * @Pre: - 
	 * @Post: Devuelve el Cliente al que pertenece la Suscripcion.
	 */
	public Cliente getCliente(){
		return this.cliente;
	}

	/**
	 * @Pre: - 
	 * @Post: Devuelve el suscriptible al que esta sujeto la Suscripcion.
	 */
	public Suscriptible getSuscriptible(){
		return this.suscriptible;
	}

	/**
	 * @Pre: - 
	 * @Post: Devuelve un boolean que indica si la Suscripcion es anual o no.
	 */
	public boolean esAnual(){
		return this.esAnual;
	}

}