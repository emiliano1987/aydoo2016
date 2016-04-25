package ar.edu.untref.aydoo;

public class Libro extends Producto{

	private double precioDeAlquiler;

	/**
	 * @Pre: descripcion es distinto de null, y precioUnitario es un decimal mayor que 0 (cero) (Las entradas se suponen validas).
	 * @Post: Inicializa el Libro con la descripcion y el precio unitario insertados.
	 */
	public Libro(String descripcion, double precioUnitario){
		super(descripcion, precioUnitario);
		Libreria.getInstance().agregarProducto(this);
	}

	/**
	 * @Pre: - .
	 * @Post: Se obtiene el precio del alquiler de un producto.
	 */
	public double obtenerPrecioDeAlquiler() {
		return precioDeAlquiler;
	}

	/**
	 * @Pre: precioDeAlquiler es un decimal mayor que 0 (cero) (Las entradas se suponen validas)
	 * @Post: Se modifica el precio del alquiler de un producto.
	 */
	public void modificarPrecioDeAlquiler(double precioDeAlquiler) {
		this.precioDeAlquiler = precioDeAlquiler;
	}


}