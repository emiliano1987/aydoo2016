package ar.edu.untref.aydoo;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.aydoo.Compra;
import ar.edu.untref.aydoo.Libro;
import ar.edu.untref.aydoo.Meses;

public class PruebaCompra {

	Compra nuevaCompra;
	Libro nuevoLibro;

	@Before
	public void inicializar(){
		nuevoLibro = new Libro("Recordando",50.0);
		nuevaCompra = new Compra (Meses.Abril,nuevoLibro);
	}

	@Test
	public void elMesDeCompraEsAbril(){
		Assert.assertTrue(Meses.Abril == nuevaCompra.obtenerMes());
	}

	@Test
	public void estaSuscripto(){
		Assert.assertTrue(nuevaCompra.obtenerProductoAComprar() == nuevoLibro);
	}
}
