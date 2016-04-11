package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import ar.edu.untref.aydoo.ArticuloLibreria;
import ar.edu.untref.aydoo.Cliente;
import ar.edu.untref.aydoo.Compra;
import ar.edu.untref.aydoo.Kiosco;
import ar.edu.untref.aydoo.Libro;
import ar.edu.untref.aydoo.Meses;
import ar.edu.untref.aydoo.Periodico;
import ar.edu.untref.aydoo.Revista;

import org.junit.Test;


public class PruebaDeLibreria {

	
	@Test
	public void primerCompra(){
		Cliente Jose = new Cliente(1, "Jose Fernandez", "Avenida Siempre Viva 444");
		Revista revistaElGrafico = new Revista("El Grafico", 30, 1, false);
		Libro elHobbit = new Libro("El Hobbit", 50);
		ArticuloLibreria lapicera = new ArticuloLibreria("Lapicera", 10);
		Map<Compra, Cliente> nuevaCantidadDeCompras = new HashMap<Compra, Cliente>();
		
		Compra nuevaCompra = new Compra(Meses.Agosto, elHobbit);
		Compra nuevaCompra2 = new Compra(Meses.Agosto, lapicera);
		Compra nuevaCompra3 = new Compra(Meses.Agosto, revistaElGrafico);
		
		nuevaCantidadDeCompras.put(nuevaCompra, Jose);
		nuevaCantidadDeCompras.put(nuevaCompra2, Jose);
		nuevaCantidadDeCompras.put(nuevaCompra3, Jose);
		
		Kiosco nuevoKiosco = new Kiosco(nuevaCantidadDeCompras);
		
		Assert.assertTrue(92.1 == (nuevoKiosco.calcularMontoACobrar(Meses.Agosto, Jose)));
	}
	
	@Test
	public void compraConSuscripcionAnual(){
		Cliente Maria = new Cliente(1, "Maria", "Direccion Sin Nombre 213");
		Revista revistaBarcelona = new Revista("Barcelona", 20.0, 2, true);
		Periodico pagina12 = new Periodico("Pagina 12", 12.0, 1, false);
		Map<Compra, Cliente> nuevasCompras = new HashMap<Compra, Cliente>();
		
		Compra nuevaCompra = new Compra(Meses.Enero, revistaBarcelona);
		Compra segundaCompra = new Compra(Meses.Enero, pagina12);

		nuevasCompras.put(nuevaCompra,Maria);
		nuevasCompras.put(segundaCompra, Maria);
		
		Kiosco nuevoKiosco = new Kiosco(nuevasCompras);
		Assert.assertTrue(44 == (nuevoKiosco.calcularMontoACobrar(Meses.Enero, Maria)));

	}
}
