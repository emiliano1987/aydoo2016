package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import ar.edu.untref.aydoo.ArticuloLibreria;
import ar.edu.untref.aydoo.Cliente;
import ar.edu.untref.aydoo.Compra;
import ar.edu.untref.aydoo.Kiosco;
import ar.edu.untref.aydoo.Libro;
import ar.edu.untref.aydoo.Meses;
import ar.edu.untref.aydoo.Periodico;
import ar.edu.untref.aydoo.Revista;

import org.junit.Test;


public class LibreriaTest {

	@Test
	public void primerCompra(){
		Cliente Jose = new Cliente(1, "Jose Fernandez", "Avenida Siempre Viva 444");
		Revista revistaElGrafico = new Revista("El Grafico", 30, 1, false);
		Libro elHobbit = new Libro("El Hobbit", 50);
		ArticuloLibreria lapicera = new ArticuloLibreria("Lapicera", 5);

		Map<Compra, Cliente> nuevaCantidadDeCompras = new HashMap<Compra, Cliente>();

		Compra nuevaCompra = new Compra(Meses.Agosto, elHobbit);
		Compra nuevaCompra2 = new Compra(Meses.Agosto, lapicera);
		Compra nuevaCompra3 = new Compra(Meses.Agosto, revistaElGrafico);
		Compra nuevaCompra4 = new Compra(Meses.Agosto, lapicera);

		nuevaCantidadDeCompras.put(nuevaCompra, Jose);
		nuevaCantidadDeCompras.put(nuevaCompra2, Jose);
		nuevaCantidadDeCompras.put(nuevaCompra3, Jose);
		nuevaCantidadDeCompras.put(nuevaCompra4, Jose);

		Kiosco nuevoKiosco = new Kiosco(nuevaCantidadDeCompras);

		Assert.assertTrue(92.1 == (nuevoKiosco.calcularMontoACobrar(Meses.Agosto, Jose)));
	}

	@Test
	public void compraConSuscripcionAnual(){
		Cliente Maria = new Cliente(1, "Maria", "Direccion Sin Nombre 213");
		Revista revistaBarcelona = new Revista("Barcelona", 20.0, 2, true);
		Periodico pagina12 = new Periodico("Pagina 12", 12.0, 1, false);

		Map<Compra, Cliente> nuevasCompras = new HashMap<Compra, Cliente>();

		Compra nuevaCompra = new Compra(Meses.Enero, revistaBarcelona);
		Compra segundaCompra = new Compra(Meses.Enero, pagina12);

		nuevasCompras.put(nuevaCompra,Maria);
		nuevasCompras.put(segundaCompra, Maria);

		Kiosco nuevoKiosco = new Kiosco(nuevasCompras);

		Assert.assertTrue(44 == (nuevoKiosco.calcularMontoACobrar(Meses.Enero, Maria)));

	}

	@Test
	public void terceraCompra(){
		Cliente JuanCarlos = new Cliente(1, "Juan Carlos", "Direccion Sin Nombre 213");
		Cliente JosePablo = new Cliente (2, "Jose Pablo", "Nueva Direccion 600");
		Revista genios = new Revista("Genios", 40.0, 1, false);
		Periodico pagina12 = new Periodico("Pagina 12", 12.0, 1, false);
		Revista parati = new Revista("Para TI", 30.0, 1, false);

		Map<Compra, Cliente> nuevasCompras = new HashMap<Compra, Cliente>();

		Compra nuevaCompra = new Compra(Meses.Febrero, genios);
		Compra segundaCompra = new Compra(Meses.Febrero, pagina12);
		Compra tercerCompra = new Compra(Meses.Febrero, parati);

		nuevasCompras.put(nuevaCompra,JuanCarlos);
		nuevasCompras.put(segundaCompra, JosePablo);
		nuevasCompras.put(tercerCompra, JosePablo);

		Kiosco nuevoKiosco = new Kiosco(nuevasCompras);

		Assert.assertTrue(42 == (nuevoKiosco.calcularMontoACobrar(Meses.Febrero, JosePablo)));

	}

	@Test
	public void compraDeLibrosSolamente(){
		Cliente JuanCarlos = new Cliente(1, "Juan Carlos", "Direccion Sin Nombre 213");
		Libro elSeniorDeLosAnillos = new Libro("El Senior de los Anillos", 200);
		Libro elSeniorDeLosAnillos2 = new Libro("El Senior de los Anillos II", 230.5);
		Libro elSeniorDeLosAnillos3 = new Libro("El Senior de los Anillos III", 290.9);

		Map<Compra, Cliente> nuevasCompras = new HashMap<Compra, Cliente>();

		Compra nuevaCompra = new Compra(Meses.Marzo, elSeniorDeLosAnillos);
		Compra segundaCompra = new Compra(Meses.Marzo, elSeniorDeLosAnillos2);
		Compra tercerCompra = new Compra(Meses.Marzo, elSeniorDeLosAnillos3);

		nuevasCompras.put(nuevaCompra,JuanCarlos);
		nuevasCompras.put(segundaCompra, JuanCarlos);
		nuevasCompras.put(tercerCompra, JuanCarlos);

		Kiosco nuevoKiosco = new Kiosco(nuevasCompras);

		Assert.assertTrue(721.4 == (nuevoKiosco.calcularMontoACobrar(Meses.Marzo, JuanCarlos)));

	}

	@Test
	public void compraEnArticulosDeLibreriaQueContienenIVA(){
		Cliente pabloLopez = new Cliente (1, "Pablo Lopez", "Avenida Corrientes 12345");

		ArticuloLibreria LapiceraFaberCastell = new ArticuloLibreria ("Lapicera Faber Castell",25);
		ArticuloLibreria hojasRespuestoX48Exito = new ArticuloLibreria ("Hojas Respuesto X48 Exito",100);
		ArticuloLibreria hojasRespuestoX48Gloria = new ArticuloLibreria ("Hojas Respuesto X48 Gloria",88);

		Map<Compra, Cliente> nuevasCompras = new HashMap<Compra, Cliente>();

		Compra nuevaCompra = new Compra(Meses.Julio, LapiceraFaberCastell);
		Compra segundaCompra = new Compra(Meses.Julio, hojasRespuestoX48Exito);
		Compra tercerCompra = new Compra(Meses.Julio, hojasRespuestoX48Gloria);

		nuevasCompras.put(nuevaCompra,pabloLopez);
		nuevasCompras.put(segundaCompra, pabloLopez);
		nuevasCompras.put(tercerCompra, pabloLopez);

		Kiosco nuevoKiosco = new Kiosco(nuevasCompras);

		double valor = nuevoKiosco.calcularMontoACobrar(Meses.Julio, pabloLopez);

		Assert.assertEquals(257.73 ,valor,0.1);

	}

}
