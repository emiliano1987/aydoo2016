package ar.edu.untref.aydoo.modelo;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.modelo.FormatoPretty;


public class FormatoPrettyTest {
	
	@Test
	public void seAplicaFormatoAlNumero12(){
		FormatoPretty nuevoFormato = new FormatoPretty();
		List<Integer> numerosAComprobar = new LinkedList<Integer>();
		
		numerosAComprobar.add(2);
		numerosAComprobar.add(2);
		numerosAComprobar.add(3);
		
		Assert.assertEquals("Factores Primos 12: 2 2 3 ", nuevoFormato.generoFormatoDeseado(numerosAComprobar,12));
	}
	
	@Test
	public void seAplicaFormatoAlNumero10(){
		FormatoPretty formato = new FormatoPretty();
		List<Integer> numeros = new LinkedList<Integer>();
		
		numeros.add(2);
		numeros.add(5);
		
		Assert.assertEquals("Factores Primos 10: 2 5 ", formato.generoFormatoDeseado(numeros,10));
	}

}