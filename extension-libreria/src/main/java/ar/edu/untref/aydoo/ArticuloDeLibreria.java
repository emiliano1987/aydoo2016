package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto{

	/**
	 * @Pre: descripcion es distinto de null, y precioUnitario es un decimal mayor que 0 (Cero) (Las entradas se suponen validas).
	 * @Post: Inicializa el Articulo de Libreria con la descripcion y el precio unitario insertados.
	 */
	public ArticuloDeLibreria(String descripcion, double precioUnitario){
		super(descripcion, precioUnitario);
		Libreria.getInstance().agregarProducto(this);
	}

	/**
	 * @Pre: - 
	 * @Post: Devuelve el precio a pagar, con IVA incluido, por el Articulo de Libreria en base al precio unitario.
	 */
	@Override
	public double obtenerPrecioAPagar() {
		double montoTotal = this.precioUnitario * 1.21;		
		return montoTotal;
	}

}