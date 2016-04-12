package ar.edu.untref.aydoo;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.aydoo.Cliente;
import ar.edu.untref.aydoo.Compra;
import ar.edu.untref.aydoo.Meses;
import ar.edu.untref.aydoo.Revista;

public class SuscripcionTest {

	Cliente nuevoCliente;
	Revista nuevaRevistaASuscribir;
	Compra nuevaCompra;
	
	@Before
	public void inicializar(){
		nuevoCliente = new Cliente (1,"Diego Armando Maradona", "Segurola y Habana");
		nuevaRevistaASuscribir = new Revista("El Grafico", 30.2, 1, true);
		nuevaCompra = new Compra (Meses.Enero,nuevaRevistaASuscribir);
	}
	
	@Test
	public void tieneSuscripcionAnual(){
		Revista nuevaRevista = new Revista("El Grafico", 30.2, 1, true);
		Assert.assertEquals(nuevaRevista.tieneSuscripcionAnual(),nuevaCompra.obtenerSuscripcion().tieneSuscripcionAnual());
	}
	
	@Test
	public void elProductoEsElMismo(){
		Assert.assertEquals(nuevaRevistaASuscribir,nuevaCompra.obtenerSuscripcion());
	}
}
