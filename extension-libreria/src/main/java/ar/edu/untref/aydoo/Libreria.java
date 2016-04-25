package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase que genera una Libreria utilizando el patron <Singleton>
 */
public class Libreria {

	private static Libreria instance;
	private List<Producto> productos;
	private List<Cliente> clientes;

	private Libreria(){
		this.productos = new LinkedList<Producto>();
		this.clientes = new LinkedList<Cliente>();
	}

	/**
	 * @Pre: -
	 * @Post: Devuelve la unica instancia de la clase.
	 * @return
	 */
	public static Libreria getInstance() {

		if(instance == null){
			instance = new Libreria();
		}
		return instance;
	}

	/**
	 * @Pre: producto es distinto de null (La entrada se supone valida).
	 * @Post: Agrega el producto a la lista de productos de la Libreria.
	 */
	public void agregarProducto(Producto producto){
		this.productos.add(producto);
	}

	/**
	 * @Pre: - 
	 * @Post: Devuelve la lista de productos que tiene la Libreria.
	 */
	public List<Producto> obtieneProductosDeLiberia(){
		return this.productos;
	}

	/**
	 * @Pre: - 
	 * @Post: Vacia la lista de productos que tiene registrado la Libreria.
	 */
	public void vaciarListaDeProductoDeLibreria(){
		this.productos.clear();
	}

	/**
	 * @Pre: cliente es distinto de null (La entrada se supone valida). 
	 * @Post: Agrega el cliente a la lista de clientes de la Libreria.
	 */
	public void agregarCliente(Cliente cliente){
		this.clientes.add(cliente);
	}

	/**
	 * @Pre: - 
	 * @Post: Devuelve la lista de clientes que tiene la Libreria.
	 */
	public List<Cliente> obtenerClientes(){
		return this.clientes;
	}

	/**
	 * @Pre: - 
	 * @Post: Vacia la lista de clientes que tiene la Libreria.
	 */
	public void vaciarListaDeClientesDeLibreria(){
		this.clientes.clear();
	}

	/**
	 * @Pre: mes y cliente son distintos de null (La entrada se supone valida), y cliente existe dentro de la lista de la Libreria.
	 * @Post: Devuelve un decimal que representa la cantidad de dinero a cobrarle al cliente en el mes ingresado previamente.
	 */
	public double calcularMontoACobrar(Mes mes, Cliente cliente){
		double montoTotalACobrar = 0;

		if(this.clienteExiste(cliente)){
			List<Compra> comprasDelMes = this.obtenerComprasEnElMesDelCliente(mes, cliente);
			List<Alquiler> alquilerDelMes = this.obtenerAlquilerEnElMesDelCliente(mes, cliente);
			for(int i = 0 ; i < comprasDelMes.size() ; i++){
				Compra compraActual = comprasDelMes.get(i);
				montoTotalACobrar += this.calcularMontoACobrarDeLaCompra(compraActual); 
			}
			for(int i = 0 ; i < alquilerDelMes.size() ; i++){
				Alquiler alquilerEnElMes= alquilerDelMes.get(i);
				montoTotalACobrar += this.calcularMontoACobrarDelAlquiler(alquilerEnElMes); 
			}
			montoTotalACobrar += calcularMontoACobrarPorSuscripciones(cliente);
		}
		return montoTotalACobrar;
	}

	/**
	 * @Pre: mes y cliente son distintos de null (La entrada se supone valida), y cliente existe dentro de la lista de la Libreria.
	 * @Post: Devuelve un numero que representa la cantidad de alquileres en el mes que tiene el cliente en el mes indicado.
	 */
	private List<Alquiler> obtenerAlquilerEnElMesDelCliente(Mes mes, Cliente cliente) {
		List<Alquiler> alquileresEnElMes= new LinkedList<Alquiler>();

		for(int i = 0 ; i < cliente.obtenerAlquilerDeLibros().size() ; i++){
			Alquiler alquilerActual = cliente.obtenerAlquilerDeLibros().get(i);
			if(alquilerActual.obtenerMes() == mes){				
				alquileresEnElMes.add(alquilerActual);
			}
		}
		return alquileresEnElMes;
	}

	/**
	 * @Pre: cliente es distintos de null (La entrada se supone valida), y existe dentro de la lista de la Libreria.
	 * @Post: Devuelve si el cliente existe o no dentro de esa lista de Libreria.
	 */
	private boolean clienteExiste(Cliente cliente){
		boolean clienteExiste = false;

		for(int i = 0 ; i < this.clientes.size() ; i++){
			if(this.clientes.get(i) == cliente){
				clienteExiste = true;
			}
		}
		return clienteExiste;
	}

	/**
	 * @Pre: mes y cliente son distintos de null (La entrada se supone valida), y cliente existe dentro de la lista de la Libreria.
	 * @Post: Devuelve un valor que representa la cantidad de compras realizadas en el mes indicado por el cliente.
	 */
	private List<Compra> obtenerComprasEnElMesDelCliente(Mes mes, Cliente cliente) {
		List<Compra> comprasDelMesPedido = new LinkedList<Compra>();

		for(int i = 0 ; i < cliente.obtenerCompras().size() ; i++){
			Compra compraActual = cliente.obtenerCompras().get(i);
			if(compraActual.obtenerMes() == mes){				
				comprasDelMesPedido.add(compraActual);
			}
		}
		return comprasDelMesPedido;
	}

	/**
	 * @Pre: compra es distinto de null (La entrada se supone valida), y existe dentro de la lista de la Libreria.
	 * @Post: Devuelve un valor que representa la cantidad de compras realizadas.
	 */
	private double calcularMontoACobrarDeLaCompra(Compra compra){
		double montoDeLaCompra = 0;

		for(int i = 0 ; i < compra.obtenerProductos().size() ; i++){
			Producto productoActual = compra.obtenerProductos().get(i);
			montoDeLaCompra += productoActual.obtenerPrecioAPagar();
		}
		return montoDeLaCompra;
	}

	/**
	 * @Pre: alquilerLibro existe dentro de la lista de la Libreria y no es null.
	 * @Post: Devuelve un decimal que representa la cantidad de dinero a cobrar por el alquiler.
	 */
	private double calcularMontoACobrarDelAlquiler(Alquiler alquilerLibro){
		double montoDelAlquiler = 0;

		for(int i = 0 ; i < alquilerLibro.obtenerProductosEnAlquiler().size() ; i++){
			Libro nuevoLibro = (Libro) alquilerLibro.obtenerProductosEnAlquiler().get(i);
			montoDelAlquiler += nuevoLibro.obtenerPrecioDeAlquiler();
		}
		return montoDelAlquiler;
	}

	/**
	 * @Pre: cliente existe dentro de la lista de la Libreria y no es null.
	 * @Post: Devuelve un decimal que representa la cantidad de dinero a cobrarle al cliente en el mes ingresado previamente.
	 */
	private double calcularMontoACobrarPorSuscripciones(Cliente cliente) {
		double montoPorSuscripciones = 0;

		for(int i = 0 ; i < cliente.obtenerSuscripciones().size() ; i++){
			Suscripcion suscripcionActual = cliente.obtenerSuscripciones().get(i);
			int ejemplaresRecibidosDelMes = suscripcionActual.obtenerSuscriptible().ejemplaresPorMes();
			double precioUnitario = ((Producto)suscripcionActual.obtenerSuscriptible()).obtenerPrecioAPagar();
			double descuento = 0;
			if(suscripcionActual.esAnual()){
				descuento = (ejemplaresRecibidosDelMes * precioUnitario) * 0.2;
			}
			montoPorSuscripciones += (ejemplaresRecibidosDelMes * precioUnitario) - descuento;
		}
		return montoPorSuscripciones;
	}

}