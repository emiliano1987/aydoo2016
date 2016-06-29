package ar.edu.untref.aydoo.modelo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.modelo.VerificaOrden;

public class VerificaOrdenTest {

	@Test
	public void verificaSiFuncionaOrdenDes(){

		VerificaOrden ordenSeteado = new VerificaOrden();
		List<Integer> numeros = new LinkedList<Integer>();
		List<Integer> formatoAsc = new LinkedList<Integer>();

		String orden = "--sort:des";
		numeros.add(1);
		numeros.add(2);

		formatoAsc.add(2);
		formatoAsc.add(1);

		Assert.assertEquals(formatoAsc, ordenSeteado.generaOrdenSalida(orden, numeros));
	}
}
