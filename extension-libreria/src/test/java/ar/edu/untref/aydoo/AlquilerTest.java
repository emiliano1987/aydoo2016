package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class AlquilerTest {

	@Test
	public void seCreaUnaAlquilerConUnMesYSeVerificaSiEsElMesIndicado(){

		Mes marzo = new Mes("Marzo");
		Alquiler alquilerLibro = new Alquiler (marzo);

		Assert.assertTrue(alquilerLibro.obtenerMes().obtenerNombre().equals("Marzo"));
	}

	@Test
	public void seAgregaUnProductoAlAquilerYSeCompruebaQueSeHayaAgregado() throws elProductoNoEsUnLibroException{

		Mes febrero = new Mes("Febrero");
		Alquiler alquiler = new Alquiler(febrero);
		Producto bodasDeSangre = new Libro("Bodas de Sangre", 10);

		alquiler.agregarProducto(bodasDeSangre,120);
		Libro nuevoLibro =	(Libro) bodasDeSangre;

		Assert.assertEquals(180, nuevoLibro.obtenerPrecioDeAlquiler(),0.0);
	}

	@Test
	public void seAgregaUnProductoDeAlquilerDiarioYSeVerificaPrecio() throws elProductoNoEsUnLibroException{

		Mes febrero = new Mes("Febrero");
		Alquiler alquiler = new Alquiler(febrero);
		Producto bodasDeSangre = new Libro("Bodas de Sangre", 10);

		alquiler.agregarProducto(bodasDeSangre,5);
		Libro nuevoLibro =	(Libro) bodasDeSangre;

		Assert.assertEquals(50, nuevoLibro.obtenerPrecioDeAlquiler(),0.0);
	}

	@Test
	public void seAgregaUnProductoDeAlquilerMensualYSeVerificaPrecio() throws elProductoNoEsUnLibroException{

		Mes febrero = new Mes("Febrero");
		Alquiler alquiler = new Alquiler(febrero);
		Producto bodasDeSangre = new Libro("Bodas de Sangre", 10);

		alquiler.agregarProducto(bodasDeSangre,45);
		Libro nuevoLibro =	(Libro) bodasDeSangre;

		Assert.assertEquals(350, nuevoLibro.obtenerPrecioDeAlquiler(),0.0);
	}

	@Test
	public void seAgreganProductoYSeVerificanCantidad() throws elProductoNoEsUnLibroException{
		Mes abril = new Mes("Abril");
		Alquiler alquiler = new Alquiler(abril);
		Producto modeloparaarmar = new Libro("62 Modelos para Armar", 200);
		Producto divertimento = new Libro("Divertimento", 200);
		Producto rayuela = new Libro("Rayuela", 100);

		alquiler.agregarProducto(modeloparaarmar,45);
		alquiler.agregarProducto(divertimento,120);
		alquiler.agregarProducto(rayuela,30);

		Assert.assertTrue(3 == alquiler.obtenerProductosEnAlquiler().size());	
	}

	@Test
	public void seAgregaProductoYVerificanDiasAlquilados() throws elProductoNoEsUnLibroException{
		Mes abril = new Mes("Abril");
		Alquiler alquiler = new Alquiler(abril);
		Producto losPremios = new Libro("Los Premios", 200);

		alquiler.agregarProducto(losPremios,45);

		Assert.assertTrue(45 == alquiler.obtenerCantidadDiasAlquiler());	
	}

	@Test (expected = elProductoNoEsUnLibroException.class)
	public void seIntentaAlquilarUnProductoQueNoEsLibro() throws elProductoNoEsUnLibroException{
		Mes abril = new Mes("Abril");
		Alquiler alquiler = new Alquiler(abril);
		Producto billiken = new ArticuloDeLibreria("Billiken", 30);

		alquiler.agregarProducto(billiken,45);

		Assert.assertTrue(45 == alquiler.obtenerCantidadDiasAlquiler());
	}

	@Test
	public void seAlquilaUnLibroPorDosCuatrimestres() throws elProductoNoEsUnLibroException{
		Mes julio = new Mes("Julio");
		Alquiler alquiler = new Alquiler(julio);
		Producto deshoras = new Libro("Deshoras", 30);

		alquiler.agregarProducto(deshoras,240);
		Libro nuevoLibro =	(Libro) deshoras;

		Assert.assertEquals(180, nuevoLibro.obtenerPrecioDeAlquiler(),0.0);
	}

	@Test
	public void seAlquilaUnLibroPorDosMeses() throws elProductoNoEsUnLibroException{
		Mes agosto = new Mes("Agosto");
		Alquiler alquiler = new Alquiler(agosto);
		Producto uvasDeLaIra = new Libro("Las Uvas de La Ira", 300);

		alquiler.agregarProducto(uvasDeLaIra,60);
		Libro nuevoLibro =	(Libro) uvasDeLaIra;

		Assert.assertEquals(400, nuevoLibro.obtenerPrecioDeAlquiler(),0.0);
	}

	@Test
	public void seAlquilaUnLibroPorTresMeses() throws elProductoNoEsUnLibroException{
		Mes noviembre = new Mes("Noviembre");
		Alquiler alquiler = new Alquiler(noviembre);
		Producto laNaranjaMecaninca = new Libro("La Naranja Mecánica", 90);

		alquiler.agregarProducto(laNaranjaMecaninca,90);
		Libro nuevoLibro =	(Libro) laNaranjaMecaninca;

		Assert.assertEquals(600, nuevoLibro.obtenerPrecioDeAlquiler(),0.0);
	}
}
