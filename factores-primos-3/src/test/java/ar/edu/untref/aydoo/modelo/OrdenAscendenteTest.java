package ar.edu.untref.aydoo.modelo;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.modelo.OrdenAscendente;


public class OrdenAscendenteTest {
	
	@Test
	public void OrdenaAscendenteCorrectamente(){
		OrdenAscendente orden = new OrdenAscendente();
		List<Integer> numerosOrdenAscendente = new LinkedList<Integer>();
		
		numerosOrdenAscendente.add(2);
		numerosOrdenAscendente.add(4);
		numerosOrdenAscendente.add(5);
		
		Assert.assertEquals(numerosOrdenAscendente, orden.ordenSalidaDeNumeros(numerosOrdenAscendente));
	}

}