package ar.edu.untref.aydoo;

public abstract class Producto {

	protected String descripcion;
	protected double precioUnitario;

	/**
	 * @Pre: descripcion es distinto de null, y precioUnitario es un decimal mayor a 0 (Cero) (Las entradas se suponen validas).
	 * @Post: Inicializa el Producto con la descripcion y el precioUnitario insertados.
	 */
	public Producto(String descripcion, double precioUnitario){

		this.modificarDescripcion(descripcion);
		this.modificarPrecioUnitario(precioUnitario);
	}

	/**
	 * @Pre: - 
	 * @Post: Devuelve la descripcion del Producto.
	 */
	public String obtenerDescripcion(){
		return this.descripcion;
	}

	/**
	 * @Pre: nuevaDescripcion es distinta de null (La entrada se supone valida).
	 * @Post: Cambia la descripcion actual del Producto por la nueva descripcion insertada.
	 */
	public void modificarDescripcion(String nuevaDescripcion){
		this.descripcion = nuevaDescripcion;
	}

	/**
	 * @Pre: - 
	 * @Post: Devuelve el precio a pagar por el Producto en base al precio unitario.
	 */
	public double obtenerPrecioAPagar(){
		return this.precioUnitario;
	}

	/**
	 * @Pre: precioNuevo es un decimal mayor que 0 (Cero) (La entrada se supone valida).
	 * @Post: Cambia el precio unitario actual del Producto por el nuevo precio insertado.
	 */
	public void modificarPrecioUnitario(double precioNuevo){
		this.precioUnitario = precioNuevo;
	}

}