package ar.edu.untref.aydoo.modelo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.modelo.FormatoPretty;
import ar.edu.untref.aydoo.modelo.FormatoSalida;

public class VerificaFormatoTest {

	@Test
	public void verificaSiFuncionaFormatoPretty(){
		FormatoSalida formateador = new FormatoPretty();
		List<Integer> numeros = new LinkedList<Integer>();
		
		numeros.add(2);
		numeros.add(5);
		
		Assert.assertEquals("Factores Primos 10: 2 5 ", formateador.generoFormatoDeseado(numeros,10));
	}
}
