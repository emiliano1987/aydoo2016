package ar.edu.untref.aydoo.modelo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.modelo.OrdenDescendente;

public class OrdenDescendenteTest {

	@Test
	public void verificaFuncionamientoOrdenDescendente(){
		OrdenDescendente orden = new OrdenDescendente();
		List<Integer> numerosAscendente = new LinkedList<Integer>();
		List<Integer> numerosDescendentes = new LinkedList<Integer>();
		
		numerosAscendente.add(2);
		numerosAscendente.add(4);
		numerosAscendente.add(5);
		
		numerosDescendentes.add(5);
		numerosDescendentes.add(4);
		numerosDescendentes.add(2);
		
		Assert.assertEquals(numerosDescendentes, orden.ordenSalidaDeNumeros(numerosAscendente));
	}
}
