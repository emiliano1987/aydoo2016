package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.aydoo.ArticuloLibreria;

public class ArticuloDeLibreriaTest {

	ArticuloLibreria fibron;

	@Before
	public void inicializar(){
		fibron  = new ArticuloLibreria ("Fibron", 10);
	}

	@Test
	public void obtenerPrecio(){
		double valor = 12.1;
		//10*21/100=2.1 (IVA) + 10 (valor)
		Assert.assertTrue(valor == fibron.obtenerPrecioDelProducto());
	}

	@Test
	public void obtenerValorIvaAplicado(){
		double valorIva = 21.00;
		Assert.assertTrue(valorIva == ArticuloLibreria.obtenerPorcentajeIVA());
	}
}
