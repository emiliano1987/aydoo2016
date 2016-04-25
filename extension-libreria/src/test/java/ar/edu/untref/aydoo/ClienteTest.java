package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {

	@Test
	public void seCreaUnClienteConUnNombreYUnaDireccionYSeVerificaQueSeHayanGuardadoCorrectamenteLosDatosInsertados(){

		Cliente nahuel = new Cliente("Nahuel", "Olavarria 5700");

		Assert.assertTrue(nahuel.obtenerNombre().equals("Nahuel"));
		Assert.assertTrue(nahuel.obtenerDireccion().equals("Olavarria 5700"));
	}

	@Test
	public void unClienteHaceUnaCompraYSeVerificaQueEsaCompraSeHayaGuardadoCorrectamente(){

		Cliente melisa = new Cliente("Melisa", "Bartolome Mitre 789");
		Mes marzo = new Mes("Marzo");
		Compra compra = new Compra(marzo);
		Producto cocina = new Libro("Cocina para principiantes", 100);

		compra.agregarProducto(cocina);
		melisa.agregarCompra(compra);

		Assert.assertEquals(1, melisa.obtenerCompras().size());
	}

	@Test
	public void clienteSeSuscribeARevistaYSeVerificaQueLaSuscripcionSeGuardaCorrectamente(){

		Cliente juan = new Cliente("Juan", "Pringles 541");
		Periodicidad quincenal = new Periodicidad("Quincenal", 15);
		Suscriptible dragonBallZ = new RevistaOPeriodico("Dragon Ball Z", 50, quincenal);

		juan.suscribirse(dragonBallZ);

		Assert.assertEquals(1, juan.obtenerSuscripciones().size());
	}

	@Test
	public void seSuscribeAlClienteAnualmenteAlMismoArticulo(){

		Cliente jose = new Cliente("Jose", "Hidalgo 1301");
		Periodicidad quincenal = new Periodicidad("Quincenal", 15);
		Suscriptible dragonBallZ = new RevistaOPeriodico("Dragon Ball Z", 50, quincenal);

		jose.suscribirseAnualmente(dragonBallZ);
		jose.suscribirseAnualmente(dragonBallZ);

		Assert.assertEquals(1, jose.obtenerSuscripciones().size());
	}

}