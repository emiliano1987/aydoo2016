package ar.edu.untref.aydoo;

public class Revista extends Producto implements Suscriptible{

	private Periodicidad periodicidad;

	/**
	 * @Pre: descripcion es distinto de null, precioUnitario es un decimal mayor que 0 (cero), y periodicidad es distinto de null 
	 * 		 (Las entradas se suponen validas).
	 * @Post: Inicializa la Revista con la descripcion, el precio unitario, y la periodicidad insertados.
	 */
	public Revista(String descripcion, double precioUnitario, Periodicidad periodicidad){
		super(descripcion, precioUnitario);
		this.periodicidad = periodicidad;
		Libreria.getInstance().agregarProducto(this);
	}

	/**
	 * @Pre: - 
	 * @Post: Devuelve la cantidad de ejemplares que recibiria un cliente por mes basandose en la periodicidad que tiene dicha Revista.
	 */
	@Override
	public int ejemplaresPorMes() {
		int ejemplaresPorMes = (int) (30 / this.periodicidad.getFrecuenciaDeEdicion());
		return ejemplaresPorMes;
	}

}