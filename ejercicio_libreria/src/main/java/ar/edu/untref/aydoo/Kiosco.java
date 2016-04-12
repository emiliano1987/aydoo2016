package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Kiosco {

	private List <Double> listaDeProductosDeClientes;
	private Map<Compra, Cliente> comprasMensuales = new HashMap <Compra, Cliente> ();
	private double sumarPrecio=0;
	private double precioTotal;

	public Kiosco (Map <Compra, Cliente> comprasMensuales){
		this.comprasMensuales = comprasMensuales;
	}

	public double calcularMontoACobrar(Meses nuevoMes, Cliente clienteNuevo){
		aplicoDescuentoAClientes (nuevoMes,clienteNuevo,comprasMensuales);
		double precioCliente = precioFinalDelCliente(listaDeProductosDeClientes);
		return precioCliente;
	}

	private void aplicoDescuentoAClientes(Meses nuevoMes,Cliente clienteConDescuento, Map <Compra, Cliente> comprasMensuales){
		listaDeProductosDeClientes = new LinkedList<Double>();
		Iterator<Map.Entry<Compra, Cliente> > entries = comprasMensuales.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<Compra, Cliente> entry = entries.next();
			if (entry.getValue().obtenerIdCliente() == clienteConDescuento.obtenerIdCliente()){
				if (entry.getKey().obtenerProductoAComprar().tieneSuscripcionAnual() == true && entry.getKey().obtenerMes() == nuevoMes){
					double restoTotal;
					restoTotal = entry.getKey().obtenerProductoAComprar().obtenerPrecioDelProducto();
					sumarPrecio = ((entry.getKey().obtenerProductoAComprar().obtenerPrecioDelProducto()*20)/100);
					listaDeProductosDeClientes.add(restoTotal-sumarPrecio);
				}else{
					listaDeProductosDeClientes.add(entry.getKey().obtenerProductoAComprar().obtenerPrecioDelProducto());
				}
			}
		}
	}

	private double precioFinalDelCliente (List <Double> nuevaListaAIterar){
		Iterator<Double> iterarPrecioDeCliente = nuevaListaAIterar.iterator();
		Double sumarValores = 0.0;
		precioTotal=0.0;
		while(iterarPrecioDeCliente.hasNext()){
			sumarValores = iterarPrecioDeCliente.next();
			precioTotal += sumarValores;
		}
		return precioTotal;
	}

}

