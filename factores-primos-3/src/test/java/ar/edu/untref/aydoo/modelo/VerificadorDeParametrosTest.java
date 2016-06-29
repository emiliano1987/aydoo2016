package ar.edu.untref.aydoo.modelo;
import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.entrada.ParametrosIncorrectosException;
import ar.edu.untref.aydoo.modelo.NumeroIncorrectoException;
import ar.edu.untref.aydoo.modelo.VerificadorDeParametros;


public class VerificadorDeParametrosTest {

	@Test(expected = ParametrosIncorrectosException.class)
	public void noSeIngresanParametros() throws NumeroIncorrectoException, ParametrosIncorrectosException{
		VerificadorDeParametros ingresoParametros = new VerificadorDeParametros();
		String[] argumentos = {};		

		ingresoParametros.verificarParametros(argumentos);
	}

	@Test
	public void seVerificaSiElNumeroSeGuardaCorrectamente() throws NumeroIncorrectoException, ParametrosIncorrectosException{
		VerificadorDeParametros ingresoParametros = new VerificadorDeParametros();
		String[] argumentos = {"--format=quiet", "--sort:des","100"};		

		ingresoParametros.verificarParametros(argumentos);

		Assert.assertEquals(100, ingresoParametros.obtenerNumeroADescomprimir());
	}

	@Test
	public void seVerificaSiElFormatoSeGuardaCorrectamente() throws NumeroIncorrectoException, ParametrosIncorrectosException{
		VerificadorDeParametros ingresoParametros = new VerificadorDeParametros();
		String[] argumentos = {"100", "--sort:des", "--format=quiet"};		

		ingresoParametros.verificarParametros(argumentos);

		Assert.assertEquals("--format=quiet", ingresoParametros.obtenerFormato());
	}

	@Test
	public void seVerificaSiLaRutaSeGuardaCorrectamente() throws NumeroIncorrectoException, ParametrosIncorrectosException{
		VerificadorDeParametros ingresoParametros = new VerificadorDeParametros();
		String[] argumentos = {"88", "--format=quiet", "--output-file=prueba"};		

		ingresoParametros.verificarParametros(argumentos);

		Assert.assertEquals("prueba", ingresoParametros.obtenerRuta());
	}

	@Test
	public void seVerificaSiElOrdenSeGuardaCorrectamente() throws NumeroIncorrectoException, ParametrosIncorrectosException{
		VerificadorDeParametros ingresoParametros = new VerificadorDeParametros();
		String[] argumentos = {"330", "--sort:des"};		

		ingresoParametros.verificarParametros(argumentos);

		Assert.assertEquals("--sort:des", ingresoParametros.obtenerOrden());
	}
}