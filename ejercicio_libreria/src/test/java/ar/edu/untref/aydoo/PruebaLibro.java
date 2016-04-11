package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.Libro;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PruebaLibro {

	Libro nuevoLibro;

	@Before
	public void inicializar(){
		nuevoLibro = new Libro("Recordando",50.0);
	}

	@Test
	public void comprobarNombreDelLibro(){
		Assert.assertEquals("Recordando", nuevoLibro.obtenerNombreLibro(),0);
	}

	@Test
	public void comprobarPrecioDelLibro(){
		Assert.assertEquals(50.0, nuevoLibro.obtenerPrecioDelProducto(),0);
	}

}
