package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class PeriodicidadTest {

	@Test
	public void seGeneraUnaPeriodicidadYVerificaDescripcion(){
		Periodicidad nuevaPeriodicidad = new Periodicidad("Mensual", 7);
		
		Assert.assertTrue("Mensual" == nuevaPeriodicidad.obtenerDescripcion());
	}
	
	@Test
	public void seGeneraUnaPeriodicidadYVerificaFrecuenciaDeEdicion(){
		Periodicidad nuevaPeriodicidad = new Periodicidad("Diaria", 1);
		
		Assert.assertTrue(1 == nuevaPeriodicidad.obtenerFrecuenciaDeEdicion());
	}
}
