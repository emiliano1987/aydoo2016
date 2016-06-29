package ar.edu.untref.aydoo.modelo;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.modelo.NumeroIncorrectoException;
import ar.edu.untref.aydoo.modelo.ObtenerFactoresPrimos;


public class ObtenerFactoresPrimosTest {

	@Test(expected = NumeroIncorrectoException.class)
	public void SeEsperaNumeroNegativoException() throws NumeroIncorrectoException{
		ObtenerFactoresPrimos factorPrimo = new ObtenerFactoresPrimos();
		factorPrimo.calcularFactoresPrimos(-1);
	}

	@Test
	public void calcularFactoresPrimosDe10() throws NumeroIncorrectoException{
		ObtenerFactoresPrimos factorPrimo = new ObtenerFactoresPrimos();

		List<Integer> listaDeValores= new LinkedList<Integer>();

		listaDeValores.add(2);
		listaDeValores.add(5);
		
		Assert.assertEquals(listaDeValores, factorPrimo.calcularFactoresPrimos(10));
	}

	@Test
	public void calculaFactorPrimo50() throws NumeroIncorrectoException{
		ObtenerFactoresPrimos factorPrimo = new ObtenerFactoresPrimos();

		List<Integer> listaDeValores= new LinkedList<Integer>();

		listaDeValores.add(2);
		listaDeValores.add(5);
		listaDeValores.add(5);

		Assert.assertEquals(listaDeValores, factorPrimo.calcularFactoresPrimos(50));
	}

}