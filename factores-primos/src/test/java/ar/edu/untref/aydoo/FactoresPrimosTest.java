package ar.edu.untref.aydoo;

import org.junit.*;

public class FactoresPrimosTest {

	@Test
	public void PruebaFactoresPrimosDelNumero360(){
		FactoresPrimos factorPrimoADescomprimir = new FactoresPrimos();
		int valorDescomprimir = 360;
		factorPrimoADescomprimir.factoresPrimos(valorDescomprimir,false);
		Assert.assertTrue(2 == factorPrimoADescomprimir.obtenerNumeroDeDescomposicion(1));
	}
	@Test
	public void PruebaFactoresPrimosDelNumero90(){
		FactoresPrimos factorPrimoADescomprimir = new FactoresPrimos();
		int valorDescomprimir = 90;
		factorPrimoADescomprimir.factoresPrimos(valorDescomprimir,false);
		Assert.assertTrue(3 == factorPrimoADescomprimir.obtenerNumeroDeDescomposicion(2));
	
	}

}
