package ar.edu.untref.aydoo;

public class Libro extends Producto{

	/**
	 * @Pre: descripcion es distinto de null, y precioUnitario es un decimal mayor que 0 (cero) (Las entradas se suponen validas).
	 * @Post: Inicializa el Libro con la descripcion y el precio unitario insertados.
	 */
	public Libro(String descripcion, double precioUnitario){
		super(descripcion, precioUnitario);
		Libreria.getInstance().agregarProducto(this);
	}

}