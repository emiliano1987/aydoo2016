package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.Producto;

public class Suscripcion extends Producto{

	private Producto nuevoProducto;
	
	public Suscripcion (Producto nuevoProductoSuscripto){
		super(nuevoProductoSuscripto.obtenerPrecioDelProducto(),true);
		this.nuevoProducto = nuevoProductoSuscripto;
	}

	public Producto obtenerNuevoProducto() {
		return nuevoProducto;
	}
	


}