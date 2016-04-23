package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SuscripcionTest {

	@Test
	public void seCreaUnaSuscripcionNoAnualYSeVerificaSiSeGuardaronCorrectamenteLosDatos(){

		Cliente leonel = new Cliente("Leonel", "Irigoyen 150");
		Periodicidad semanal = new Periodicidad("Semanal", 7);
		Suscriptible revista = new Revista("Tecnologia", 10, semanal);
		boolean esAnual = false;
		Suscripcion suscripcion = new Suscripcion(leonel, revista, esAnual);

		Cliente clienteObtenido = suscripcion.getCliente();
		Suscriptible suscriptibleObtenido = suscripcion.getSuscriptible();
		boolean booleanObtenido = suscripcion.esAnual();

		Assert.assertTrue(clienteObtenido.getNombre().equals("Leonel"));
		Assert.assertTrue(((Producto)suscriptibleObtenido).getDescripcion().equals("Tecnologia"));
		Assert.assertFalse(booleanObtenido);

	}

	@Test
	public void seCreaUnaSuscripcionAnualYSeVerificaSiSeGuardaronCorrectamenteLosDatos(){

		Cliente gustavo = new Cliente("Gustavo", "Caferata 789");
		Periodicidad semanal = new Periodicidad("Semanal", 7);
		Suscriptible revista = new Revista("Politica", 10, semanal);
		boolean esAnual = true;
		Suscripcion suscripcion = new Suscripcion(gustavo, revista, esAnual);

		Cliente clienteObtenido = suscripcion.getCliente();
		Suscriptible suscriptibleObtenido = suscripcion.getSuscriptible();
		boolean booleanObtenido = suscripcion.esAnual();

		Assert.assertTrue(clienteObtenido.getNombre().equals("Gustavo"));
		Assert.assertTrue(((Producto)suscriptibleObtenido).getDescripcion().equals("Politica"));
		Assert.assertTrue(booleanObtenido);

	}

}