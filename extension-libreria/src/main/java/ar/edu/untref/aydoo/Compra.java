package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Compra {

	private Mes mes;
	private List<Producto> productos;

	/**
	 * @Pre: mes es distinto de null (La entrada se supone valida).
	 * @Post: Inicializa la Compra con el mes insertado.
	 */
	public Compra(Mes mes){
		this.mes = mes;
		this.productos = new LinkedList<Producto>();
	}

	/**
	 * @Pre: - 
	 * @Post: Devuelve el mes en el que se hizo la Compra.
	 */
	public Mes obtenerMes(){
		return this.mes;
	}

	/**
	 * @Pre: producto es distinto de null (La entrada se supone valida).
	 * @Post: Agrega el producto a la lista de productos que tiene la Compra.
	 */
	public void agregarProducto(Producto producto){
		this.productos.add(producto);
	}

	/**
	 * @Pre: - 
	 * @Post: Devuelve la lista de productos que tiene la Compra.
	 */
	public List<Producto> obtenerProductos(){
		return this.productos;
	}

}