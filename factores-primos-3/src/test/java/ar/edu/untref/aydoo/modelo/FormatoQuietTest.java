package ar.edu.untref.aydoo.modelo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.modelo.FormatoQuiet;


public class FormatoQuietTest {
	
	@Test
	public void seAplicaFormatoAlNumero10(){
		FormatoQuiet formato = new FormatoQuiet();
		List<Integer> numeros = new LinkedList<Integer>();
		
		numeros.add(2);
		numeros.add(5);
		
		Assert.assertEquals("Factores Primos 10: \n2\n5", formato.generoFormatoDeseado(numeros,10));
	}
}















