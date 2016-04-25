package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SuscripcionTest {

	@Test
	public void seVerificaSiSeCreaCorrectamenteElClienteEnLaSuscripcion(){

		Cliente jorge = new Cliente("Jorge", "Honorio Pueyrredon 150");
		Periodicidad semanal = new Periodicidad("Semanal", 7);
		Suscriptible revista = new RevistaOPeriodico("Tecnologia", 10, semanal);
		boolean esAnual = false;
		Suscripcion suscripcion = new Suscripcion(jorge, revista, esAnual);

		Cliente clienteObtenido = suscripcion.obtenerCliente();

		Assert.assertTrue(clienteObtenido.obtenerNombre().equals("Jorge"));

	}
	
	@Test
	public void seVerificaSiLaDescripcionDelSuscriptibleEsElCorrecto(){

		Cliente leonel = new Cliente("Leonel", "Irigoyen 150");
		Periodicidad semanal = new Periodicidad("Semanal", 7);
		Suscriptible revista = new RevistaOPeriodico("Tecnologia", 10, semanal);
		boolean esAnual = false;
		Suscripcion suscripcion = new Suscripcion(leonel, revista, esAnual);

		Suscriptible suscriptibleObtenido = suscripcion.obtenerSuscriptible();

		Assert.assertTrue(((Producto)suscriptibleObtenido).obtenerDescripcion().equals("Tecnologia"));
	}

	@Test
	public void seCreaUnaSuscripcionNoAnualYSeVerificaSiSeGuardaronCorrectamenteLosDatos(){

		Cliente leonel = new Cliente("Leonel", "Irigoyen 150");
		Periodicidad semanal = new Periodicidad("Semanal", 7);
		Suscriptible revista = new RevistaOPeriodico("Tecnologia", 10, semanal);
		boolean esAnual = false;
		Suscripcion suscripcion = new Suscripcion(leonel, revista, esAnual);

		boolean booleanObtenido = suscripcion.esAnual();

		Assert.assertFalse(booleanObtenido);
	}

	@Test
	public void seCreaUnaSuscripcionAnualYSeVerificaSiSeGuardaronCorrectamenteLosDatos(){

		Cliente gustavo = new Cliente("Gustavo", "Caferata 789");
		Periodicidad semanal = new Periodicidad("Semanal", 7);
		Suscriptible revista = new RevistaOPeriodico("Politica", 10, semanal);
		boolean esAnual = true;
		Suscripcion suscripcion = new Suscripcion(gustavo, revista, esAnual);

		boolean booleanObtenido = suscripcion.esAnual();

		Assert.assertTrue(booleanObtenido);
	}

	@Test
	public void seGeneraSuscripcionAnualYSeElimina(){

		Cliente carlos = new Cliente("Carlos", "Ramos 1709");
		Periodicidad semanal = new Periodicidad("Semanal", 7);
		Suscriptible revista = new RevistaOPeriodico("Sudestada", 10, semanal);
		boolean esAnual = true;
		Suscripcion suscripcion = new Suscripcion(carlos, revista, esAnual);

		carlos.eliminarSuscripcion(suscripcion);

		Assert.assertTrue(0 == carlos.obtenerSuscripciones().size());
	}

}