package ar.edu.untref.aydoo;

public class Periodicidad {

	private String descripcion;
	private int frecuenciaDeEdicion;

	/**
	 * @Pre: descripcion es distinto de null y frecuenciaDeEdicion es un entero mayor a 0 (cero) medido en dias (Las entradas se suponen validas).
	 * @Post: Inicializa la Perodicidad con la descripcion y frecuenciaDeEdicion insertados.
	 */
	public Periodicidad(String descripcion, int frecuenciaDeEdicion){
		this.descripcion = descripcion;
		this.frecuenciaDeEdicion = frecuenciaDeEdicion;
	}

	/**
	 * @Pre: - 
	 * @Post: Devuelve la descripcion de la Periodicidad.
	 */
	public String getDescripcion(){
		return this.descripcion;
	}

	/**
	 * @Pre: - 
	 * @Post: Devuelve la frecuencia de edicion de la Periodicidad en dias.
	 */
	public int getFrecuenciaDeEdicion(){
		return this.frecuenciaDeEdicion;
	}

}