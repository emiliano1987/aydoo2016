package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CompraTest {

	@Test
	public void seCreaUnaCompraConUnMesYSeVerificaSiSeCreoConElMesIndicado(){

		Mes enero = new Mes("Enero");
		Compra compra = new Compra(enero);

		Assert.assertTrue(compra.getMes().getNombre().equals("Enero"));

	}

	@Test
	public void seAgregaUnProductoALaCompraYSeCompruebaQueSeHayaAgregado(){

		Mes febrero = new Mes("Febrero");
		Compra compra = new Compra(febrero);
		Producto lapicera = new ArticuloDeLibreria("Lapicera BIC", 10);

		compra.agregarProducto(lapicera);

		Assert.assertEquals(1, compra.getProductos().size());

	}

}