package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Alquiler {

	private List<Producto> librosEnAlquiler;
	private final double alquilerDiario = 10;
	private final double alquilerMeses = 200;
	private Mes mes;
	private int cantidadDiasAlquiler;

	/**
	 * @Pre: mes es distinto de null (La entrada se supone valida).
	 * @Post: Inicializa el Alquiler con el mes insertado.
	 */
	public Alquiler(Mes mes){
		this.mes = mes;
		this.librosEnAlquiler = new LinkedList<Producto>();
	}
	/**
	 * @Pre: cantidadDeDias es distinto de null (La entrada se supone valida). El valor debe ser mayor o igual a 5.
	 * @Post: Inicializa el Alquiler con el mes insertado.
	 */
	private double generarMontoSegunAlquiler(int cantidadDeDias){
		double valorAlquilerSegunDias = 0;
		int restarCantidadDias = cantidadDeDias;
		while (restarCantidadDias >= 5){
			if(restarCantidadDias>=5 && restarCantidadDias<=25){
				valorAlquilerSegunDias += (alquilerDiario*restarCantidadDias);
				restarCantidadDias -= restarCantidadDias;
			}else if(restarCantidadDias>=30 && restarCantidadDias <60) {
				valorAlquilerSegunDias += alquilerMeses;
				restarCantidadDias -= 30;
			}else if(restarCantidadDias >=60 && restarCantidadDias <90){
				valorAlquilerSegunDias += alquilerMeses*2;
				restarCantidadDias -= 60;
			}else if(restarCantidadDias >=90 && restarCantidadDias <120){
				valorAlquilerSegunDias += alquilerMeses*3;
				restarCantidadDias -= 90;
			}else if(restarCantidadDias>=120 && restarCantidadDias < 240){
				valorAlquilerSegunDias += (alquilerMeses-(alquilerMeses*(10)/100));
				restarCantidadDias -= 120;
			}else if(restarCantidadDias == 240){
				valorAlquilerSegunDias += (alquilerMeses-(alquilerMeses*(10)/100));
				restarCantidadDias -= 240;
			}
		}
		return valorAlquilerSegunDias;
	}

	/**
	 * @Pre: - .
	 * @Post: Se obtiene el mes donde se alquila el producto (Libro).
	 */
	public Mes obtenerMes(){
		return this.mes;
	}

	/**
	 * @Pre: - .
	 * @Post: se obtiene la cantidad de Dias de alquiler del producto (Libro).
	 */
	public int obtenerCantidadDiasAlquiler(){
		return this.cantidadDiasAlquiler;
	}

	/**
	 * @Pre: producto es distinto de null (La entrada se supone valida) y cantidadDeDiasAlquiler tiene que ser mayor o igual a 5.
	 * @Post: Agrega el producto a la lista de productos que tiene el Alquiler.
	 * @throws elProductoNoEsUnLibroException: Excepcion que se ejecuta si el producto ingresado no es un Libro. 
	 */
	public void agregarProducto(Producto producto, int cantidadDeDiasAlquiler) throws elProductoNoEsUnLibroException{
		if(producto instanceof Libro){
			this.cantidadDiasAlquiler = cantidadDeDiasAlquiler;
			((Libro) producto).modificarPrecioDeAlquiler(this.generarMontoSegunAlquiler(cantidadDeDiasAlquiler));
			this.librosEnAlquiler.add(producto);
		}else{
			throw new elProductoNoEsUnLibroException();
		}
	}

	/**
	 * @Pre: - 
	 * @Post: Devuelve la lista de productos que tiene el Alquiler.
	 */
	public List<Producto> obtenerProductosEnAlquiler(){
		return this.librosEnAlquiler;
	}

}