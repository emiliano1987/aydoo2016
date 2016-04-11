package ar.edu.untref.aydoo;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.aydoo.Revista;

public class PruebaRevista {

	Revista nuevaRevista ;
	
	@Before
	public void inicializar(){
		nuevaRevista = new Revista("Caras y Caretas",25.2,4,false);
	}
	
	@Test
	public void compraMensualDeRevista(){
		Assert.assertTrue(100.8 == nuevaRevista.obtenerPrecioDelProducto());
	}
	
	@Test
	public void cualEsLaPeriodicidadDeRevista(){
		Assert.assertEquals(4, nuevaRevista.obtenerperiodicidadDeLaRevista(),0);
	}
	
	@Test
	public void laSuscripcionNoEsAnual(){
		Assert.assertTrue(nuevaRevista.tieneSuscripcionAnual() == false);
	}
}
