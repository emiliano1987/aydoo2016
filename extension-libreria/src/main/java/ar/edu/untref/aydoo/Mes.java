package ar.edu.untref.aydoo;

public class Mes {

	private String nombre;

	/**
	 * @Pre: nombre es distinto de null (La entrada se supone valida).
	 * @Post: Inicializa el Mes con el nombre insertado.
	 */
	public Mes(String nombre){
		this.nombre = nombre;
	}

	/**
	 * @Pre: - 
	 * @Post: Devuelve el nombre del Mes.
	 */
	public String obtenerNombre(){
		return this.nombre;
	}

}