package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

/**
 * <Singleton>
 * @author Gonzalo Nahuel - Entregado el 11/04/2016
 *
 */
public class Libreria {

	private static Libreria instance = new Libreria();
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
	public List<Producto> getProductos(){
		return this.productos;
	}

	/**
	 * @Pre: - 
	 * @Post: Vacia la lista de productos que tiene registrado la Libreria.
	 */
	public void vaciarListaDeProducto(){
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
	public List<Cliente> getClientes(){
		return this.clientes;
	}

	/**
	 * @Pre: mes y cliente son distintos de null (La entrada se supone valida), y cliente existe dentro de la lista de la Libreria.
	 * @Post: Devuelve un decimal que representa la cantidad de dinero a cobrarle al cliente en el mes ingresado previamente.
	 */
	public double calcularMontoACobrar(Mes mes, Cliente cliente){

		double montoTotalACobrar = 0;

		if(this.clienteExiste(cliente)){

			List<Compra> comprasDelMes = this.obtenerComprasEnElMesDelCliente(mes, cliente);

			for(int i = 0 ; i < comprasDelMes.size() ; i++){

				Compra compraActual = comprasDelMes.get(i);
				montoTotalACobrar += this.calcularMontoACobrarDeLaCompra(compraActual); 

			}

			montoTotalACobrar += calcularMontoACobrarPorSuscripciones(cliente);

		}

		return montoTotalACobrar;

	}

	private boolean clienteExiste(Cliente cliente){

		boolean clienteExiste = false;

		for(int i = 0 ; i < this.clientes.size() ; i++){

			if(this.clientes.get(i) == cliente){
				clienteExiste = true;
			}

		}

		return clienteExiste;

	}

	private List<Compra> obtenerComprasEnElMesDelCliente(Mes mes, Cliente cliente) {

		List<Compra> comprasDelMesPedido = new LinkedList<Compra>();

		for(int i = 0 ; i < cliente.getCompras().size() ; i++){

			Compra compraActual = cliente.getCompras().get(i);

			if(compraActual.getMes() == mes){				
				comprasDelMesPedido.add(compraActual);
			}

		}

		return comprasDelMesPedido;

	}

	private double calcularMontoACobrarDeLaCompra(Compra compra){

		double montoDeLaCompra = 0;

		for(int i = 0 ; i < compra.getProductos().size() ; i++){

			Producto productoActual = compra.getProductos().get(i);
			montoDeLaCompra += productoActual.getPrecioAPagar();

		}

		return montoDeLaCompra;

	}

	private double calcularMontoACobrarPorSuscripciones(Cliente cliente) {

		double montoPorSuscripciones = 0;

		for(int i = 0 ; i < cliente.getSuscripciones().size() ; i++){

			Suscripcion suscripcionActual = cliente.getSuscripciones().get(i);

			int ejemplaresRecibidosDelMes = suscripcionActual.getSuscriptible().ejemplaresPorMes();
			double precioUnitario = ((Producto)suscripcionActual.getSuscriptible()).getPrecioAPagar();

			double descuento = 0;

			if(suscripcionActual.esAnual()){
				descuento = (ejemplaresRecibidosDelMes * precioUnitario) * 0.2;
			}

			montoPorSuscripciones += (ejemplaresRecibidosDelMes * precioUnitario) - descuento;

		}

		return montoPorSuscripciones;

	}

}