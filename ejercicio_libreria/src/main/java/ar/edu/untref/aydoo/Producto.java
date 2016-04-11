package ar.edu.untref.aydoo;

public abstract class Producto {

	private double precioDelProducto;
	private boolean tieneSuscripcionAnual;
	public Producto (double productoAsignaPrecio, boolean suscripcionAnual){

		this.precioDelProducto = productoAsignaPrecio;
		this.tieneSuscripcionAnual = suscripcionAnual;
	}

	public double obtenerPrecioDelProducto (){
		return this.precioDelProducto;
	}

	public void modificarPrecioDelProducto(double nuevoPrecioDelProducto){
		this.precioDelProducto = nuevoPrecioDelProducto;
	}

	public boolean tieneSuscripcionAnual() {
		return this.tieneSuscripcionAnual;
	}

}