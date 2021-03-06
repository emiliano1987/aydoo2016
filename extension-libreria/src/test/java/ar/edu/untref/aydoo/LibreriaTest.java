package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LibreriaTest {

	@Before
	public void vaciarProductosDeLaLibreria(){

		Libreria libreria = Libreria.getInstance();
		libreria.vaciarListaDeProductoDeLibreria();
		libreria.vaciarListaDeClientesDeLibreria();
	}

	@Test
	public void seAgreganClientesYSeVerificanSiExisten(){
		Libreria libreria = Libreria.getInstance();
		Cliente juan = new Cliente("Juan", "Juan Manuel de Rosas 4578");
		Cliente gonzalo = new Cliente("Gonzalo", "Avenida San Martin 504");
		Cliente maria = new Cliente("Maria", "Olvarria 4500");

		libreria.agregarCliente(juan);
		libreria.agregarCliente(gonzalo);
		libreria.agregarCliente(maria);

		Assert.assertTrue(3 == libreria.obtenerClientes().size());
	}

	@Test
	public void seCreanTresProductosYSeVerificaSiExisten(){

		Libreria libreria = Libreria.getInstance();
		Producto libro = new Libro("Analisis y Disenio Orientado a Objetos", 500);
		Producto cuaderno = new ArticuloDeLibreria("Cuaderno rallado", 20);
		Periodicidad semanal = new Periodicidad("Semanal", 7);
		Producto revista = new RevistaOPeriodico("Anteojitos", 40, semanal);

		libro.obtenerDescripcion();
		cuaderno.obtenerDescripcion();
		revista.obtenerDescripcion();

		Assert.assertEquals(3, libreria.obtieneProductosDeLiberia().size());
	}

	@Test
	public void unClienteCompraArticulosEnAgostoYNoEstaSuscripto(){

		Libreria libreria = Libreria.getInstance();
		Cliente juan = new Cliente("Juan", "Juan Manuel de Rosas 4578");
		Mes agosto = new Mes("Agosto");
		Compra compra = new Compra(agosto);
		Producto elHobbit = new Libro("El Hobbit", 50);
		Producto lapicera1 = new ArticuloDeLibreria("Lapicera BIC", 5);
		Producto lapicera2 = new ArticuloDeLibreria("Lapicera BIC", 5);
		Periodicidad mensual = new Periodicidad("Mensual", 30);
		Producto elGrafico = new RevistaOPeriodico("El Grafico", 30, mensual);

		libreria.agregarCliente(juan);
		compra.agregarProducto(elHobbit);
		compra.agregarProducto(lapicera1);
		compra.agregarProducto(lapicera2);
		compra.agregarProducto(elGrafico);
		juan.agregarCompra(compra);

		Assert.assertEquals(92.1, libreria.calcularMontoACobrar(agosto, juan), 0.0);
	}

	@Test
	public void unClienteCompraEnEneroYRecibeDosEjemplaresDeUnaRevistaPorSuscripcionAnual(){

		Libreria libreria = Libreria.getInstance();
		Cliente maria = new Cliente("Maria", "Olvarria 4500");
		Mes enero = new Mes("Enero");
		Compra compra = new Compra(enero);
		Periodicidad quincenal = new Periodicidad("Quincenal", 15);
		Suscriptible barcelona = new RevistaOPeriodico("Barcelona", 20, quincenal);
		Periodicidad diaria = new Periodicidad("Diaria", 1);
		Producto pagina12 = new RevistaOPeriodico("Pagina 12", 12, diaria);

		libreria.agregarCliente(maria);
		maria.suscribirseAnualmente(barcelona);
		compra.agregarProducto(pagina12);
		maria.agregarCompra(compra);

		Assert.assertEquals(44.0, libreria.calcularMontoACobrar(enero, maria), 0.0);
	}

	@Test
	public void unClienteHaceComprasDuranteUnMesYSeSuscribeAUnDiarioDeEdicionDiaria(){

		Libreria libreria = Libreria.getInstance();
		Cliente gonzalo = new Cliente("Gonzalo", "Avenida San Martin 504");
		Mes junio = new Mes("Junio");
		Compra primeraCompra = new Compra(junio);
		Compra segundaCompra = new Compra(junio);
		Periodicidad diaria = new Periodicidad("Diaria", 1);
		Suscriptible clarin = new RevistaOPeriodico("Clarin", 10, diaria);
		Producto harryPotter = new Libro("Harry Potter y La Piedra Filosofal", 100);
		Producto lapicera = new ArticuloDeLibreria("Lapicera BIC", 5);
		Producto cuadernoCuadriculado = new ArticuloDeLibreria("Cuaderno cuadriculado AVON", 15);
		Periodicidad quincenal = new Periodicidad("Quincenal", 15);
		Producto realMadrid = new RevistaOPeriodico("Real Madrid", 20, quincenal);
		Producto manchesterUnited = new RevistaOPeriodico("Manchester United", 20, quincenal);
		Producto fibron = new ArticuloDeLibreria("Fibron negro", 25);

		libreria.agregarCliente(gonzalo);
		gonzalo.suscribirse(clarin);
		primeraCompra.agregarProducto(harryPotter);
		primeraCompra.agregarProducto(lapicera);
		primeraCompra.agregarProducto(cuadernoCuadriculado);
		gonzalo.agregarCompra(primeraCompra);
		segundaCompra.agregarProducto(realMadrid);
		segundaCompra.agregarProducto(manchesterUnited);
		segundaCompra.agregarProducto(fibron);
		gonzalo.agregarCompra(segundaCompra);

		//Suscripcion NO ANUAL a Diario "Clarin" (Edicion diaria) ==> 10 . 30 = $300
		//Primera Compra ==> 100 + 6,05 [5] + 18,15 [15] = $124,2
		//Segunda Compra ==> 20 + 20 + 30,25 [25] = $70,25
		//Total: 300 + 124,2 + 70,25 = $494,45
		Assert.assertEquals(494.45, libreria.calcularMontoACobrar(junio, gonzalo), 0.00);
	}

	@Test
	public void clienteSuscriptoAnualmenteAUnaRevistaYUnPeriodicoYSuscripcionNoAnualAOtraRevista(){

		Libreria libreria = Libreria.getInstance();
		Cliente florencia = new Cliente("Florencia", "Bartolome Mitre 520");
		Mes diciembre = new Mes("Diciembre");
		Periodicidad quincenal = new Periodicidad("Quincenal", 15);
		Suscriptible paraTi = new RevistaOPeriodico("Para Ti", 30, quincenal);
		Periodicidad diaria = new Periodicidad("Diaria", 1);
		Suscriptible laNacion = new RevistaOPeriodico("La Nacion", 10, diaria);
		Suscriptible billiken = new RevistaOPeriodico("Billiken", 40, quincenal);

		libreria.agregarCliente(florencia);
		florencia.suscribirseAnualmente(paraTi);
		florencia.suscribirseAnualmente(laNacion);
		florencia.suscribirse(billiken);

		//Suscripcion ANUAL a la Revista "Para Ti" (Edicion quincenal) ==> $48 [60] (20% de descuento)
		//Suscripcion ANUAL al Diario "La Nacion" (Edicion diaria) ==> $240 [300] (20% de descuento)
		//Suscripcion NO ANUAL a la Revista "Billiken" (Edicion quincenal) ==> $80
		//Total: 48 + 240 + 80 = $368
		Assert.assertEquals(368.0, libreria.calcularMontoACobrar(diciembre, florencia), 0.0);
	}

	@Test
	public void queComproElMesDeJulioUnClienteQueTieneDiarioConSuscripcionAnual(){

		Libreria libreria = Libreria.getInstance();
		Cliente martin = new Cliente("Martin", "Manuel Belgrano 1005");
		Mes junio = new Mes("Junio");
		Compra compraDeJunio = new Compra(junio);
		Mes julio = new Mes("Julio");
		Compra compraDeJulio = new Compra(julio);
		Periodicidad diaria = new Periodicidad("Diaria", 1);
		Suscriptible diario26 = new RevistaOPeriodico("Diario 26", 8, diaria);
		Producto liquidPaper = new ArticuloDeLibreria("Liquid Paper", 30);
		Producto uml = new Libro("UML", 150);
		Producto inteligenciaArtificial = new Libro("Inteligencia Artificial", 780);

		libreria.agregarCliente(martin);
		martin.suscribirseAnualmente(diario26);
		compraDeJunio.agregarProducto(uml);
		martin.agregarCompra(compraDeJunio);
		compraDeJulio.agregarProducto(liquidPaper);
		compraDeJulio.agregarProducto(inteligenciaArtificial);
		martin.agregarCompra(compraDeJulio);

		//Suscripcion ANUAL al Diario "Diario 26" (Edicion diaria) ==> $192 [240] (20% de descuento)
		//Compra de Julio ==> 36,3 [30] + 780 = $816,3
		//Total: 192 + 816,3 = $1008,3
		Assert.assertEquals(1008.3, libreria.calcularMontoACobrar(julio, martin), 0.0);
	}

	@Test
	public void seVerificaQueClienteCompreYAlquile()throws elProductoNoEsUnLibroException{

		Libreria libreria = Libreria.getInstance();
		Cliente martin = new Cliente("Martin", "Manuel Belgrano 1005");
		Mes julio = new Mes("Julio");
		Compra compraDeJulio = new Compra(julio);
		Alquiler nuevoAlquiler = new Alquiler(julio);
		Producto liquidPaper = new ArticuloDeLibreria("Liquid Paper", 30);
		Producto inteligenciaArtificial = new Libro("Inteligencia Artificial", 780);
		Producto uml = new Libro("UML para Dummies", 100);

		libreria.agregarCliente(martin);
		compraDeJulio.agregarProducto(liquidPaper);
		compraDeJulio.agregarProducto(inteligenciaArtificial);
		nuevoAlquiler.agregarProducto(uml, 30);
		martin.agregaAlquiler(nuevoAlquiler);
		martin.agregarCompra(compraDeJulio);

		Assert.assertEquals(1016.30, libreria.calcularMontoACobrar(julio, martin), 0.0);
	}

	@Test
	public void seVerificaQueClienteAlquileDiario()throws elProductoNoEsUnLibroException{

		Libreria libreria = Libreria.getInstance();
		Cliente martin = new Cliente("Martin", "Manuel Belgrano 1005");
		Mes julio = new Mes("Julio");
		Compra compraDeJulio = new Compra(julio);
		Alquiler alquilerDeJulio = new Alquiler(julio);
		Producto liquidPaper = new ArticuloDeLibreria("Liquid Paper", 30);
		Producto inteligenciaArtificial = new Libro("Inteligencia Artificial", 250);
		Producto elTunel = new Libro("El Tunel", 300);
		Producto antesDelFin = new Libro("Antes del Fin", 316);

		libreria.agregarCliente(martin);
		compraDeJulio.agregarProducto(liquidPaper);
		compraDeJulio.agregarProducto(inteligenciaArtificial);
		alquilerDeJulio.agregarProducto(elTunel, 30);
		alquilerDeJulio.agregarProducto(antesDelFin, 130);
		martin.agregarCompra(compraDeJulio);
		martin.agregaAlquiler(alquilerDeJulio);

		Assert.assertEquals(766.30, libreria.calcularMontoACobrar(julio, martin), 0.0);
	}
}