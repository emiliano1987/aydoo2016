package ar.edu.untref.aydoo;

public class RevistaOPeriodico extends Producto implements Suscriptible{

	private Periodicidad periodicidad;

	/**
	 * @Pre: descripcion es distnto de null, precioUnitario es un decimal mayor que 0 (Cero), y periodicidad es distinto de null 
	 * 		 (Las entradas se suponen validas).
	 * @Post: Inicializa el Periodico con la descripcion, el precio unitario, y la periodicidad insertados.
	 */
	public RevistaOPeriodico(String descripcion, double precioUnitario, Periodicidad periodicidad){
		super(descripcion, precioUnitario);
		this.periodicidad = periodicidad;
		Libreria.getInstance().agregarProducto(this);
	}

	/**
	 * @Pre: - 
	 * @Post: Devuelve la cantidad de ejemplares que recibiria un cliente por mes basandose en la periodicidad del Periodico.
	 */
	@Override
	public int ejemplaresPorMes() {
		int ejemplaresPorMes = (int) (30 / this.periodicidad.obtenerFrecuenciaDeEdicion());
		return ejemplaresPorMes;
	}

}