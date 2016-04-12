package ar.edu.untref.aydoo;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.aydoo.Cliente;

public class ClienteTest {

	Cliente nuevoCliente;

	@Before
	public void inicializar(){
		nuevoCliente = new Cliente (1, "Gonzalo Ramirez", "Casa Vacia 1234");
	}
	
	@Test
	public void esCorrectoElNombre(){
		String nombrePrueba = new String ("Gonzalo Ramirez");
		Assert.assertEquals(nombrePrueba, nuevoCliente.obtenerNombreCliente());
	}
	
	@Test
	public void esCorrectoElId(){
		Assert.assertEquals(1, nuevoCliente.obtenerIdCliente());
	}
	
	@Test
	public void verificarDireccionCliente(){
		Assert.assertEquals("Casa Vacia 1234", nuevoCliente.obtenerDireccionCliente());
	}
	
}
