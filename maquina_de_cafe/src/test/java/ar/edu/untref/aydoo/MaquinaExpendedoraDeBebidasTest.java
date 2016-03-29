package ar.edu.untref.aydoo;

import org.junit.*;
public class MaquinaExpendedoraDeBebidasTest {

	
	@Test
	public void pruebaDeVasoDeCafeConLecheYVerificaAzucarEnMaquina(){
		MaquinaExpendedoraDeBebidas nuevaMaquina = new MaquinaExpendedoraDeBebidas(3);
		Vaso nuevoVaso = new Vaso();
		nuevaMaquina.hacerCafeConLecheConNDeAzucar(1, nuevoVaso);
		Assert.assertTrue(nuevaMaquina.getAgregarAzucar().getTopeAzucar() == 2);
	}
	@Test (expected = Error.class)
	public void pruebaAzucarInsuficienteEnMaquina(){
		MaquinaExpendedoraDeBebidas maquinaSinAzucar = new MaquinaExpendedoraDeBebidas(1);
		Vaso nuevoVaso = new Vaso ();
		Assert.assertEquals(maquinaSinAzucar.getAgregarAzucar().getTopeAzucar(), maquinaSinAzucar.hacerCafeConLecheConNDeAzucar(2, nuevoVaso).getCantidadAzucar());
	}
	@Test 
	public void pruebaDeVasoDeTeConLecheYVerificarDisminucionAzucar(){
		MaquinaExpendedoraDeBebidas maquinaGeneraTe = new MaquinaExpendedoraDeBebidas(5);
		Vaso vasoDeTe = new Vaso();
		maquinaGeneraTe.hacerTeConLecheConNDeAzucar(2, vasoDeTe);
		Assert.assertEquals(3, maquinaGeneraTe.getAgregarAzucar().getTopeAzucar());
	}
	@Test
	public void generarTeSinAzucarYVerificarElTopeDeAzucar(){
		MaquinaExpendedoraDeBebidas maquinaExpendedoraDeTe = new MaquinaExpendedoraDeBebidas(10);
		Vaso primerVasoDeTe = new Vaso ();
		maquinaExpendedoraDeTe.hacerTeConLecheConNDeAzucar(0, primerVasoDeTe);
		Vaso segundoVasoDeTe = new Vaso ();
		maquinaExpendedoraDeTe.hacerTeConLecheConNDeAzucar(0, segundoVasoDeTe);
		Vaso tercerVasoDeTe = new Vaso ();
		maquinaExpendedoraDeTe.hacerTeConLecheConNDeAzucar(0, tercerVasoDeTe);
		Vaso cuartoVasoDeTe = new Vaso ();
		maquinaExpendedoraDeTe.hacerTeConLecheConNDeAzucar(0, cuartoVasoDeTe);
		Assert.assertEquals(10, maquinaExpendedoraDeTe.getAgregarAzucar().getTopeAzucar());
	}
	@Test
	public void preparaCafeEnElVaso(){
		Cafetero cafeEnSaquito = new Cafetero();
		Vaso nuevoVaso = new Vaso();
		cafeEnSaquito.prepararEnEsteVaso(nuevoVaso);
		Assert.assertEquals(Bebidas.Cafe, nuevoVaso.getNuevaBebida());
	}
	@Test
	public void preparaCafeConLecheEnElVaso(){
		Cafetero nuevoCafe = new Cafetero();
		Lechero lecheDescremada = new Lechero();
		Vaso nuevoVaso = new Vaso();
		nuevoCafe.prepararEnEsteVaso(nuevoVaso);
		lecheDescremada.prepararEnEsteVaso(nuevoVaso);
		Assert.assertEquals(Bebidas.Cafe, nuevoVaso.getNuevaBebida());
		Assert.assertEquals(Bebidas.Leche, nuevoVaso.getSegundaBebida());
	}
	@Test
	public void preparaSolamenteLecheEnElVaso(){
		Lechero lecheDescremadaSola = new Lechero();
		Vaso nuevoVaso = new Vaso();
		lecheDescremadaSola.prepararEnEsteVaso(nuevoVaso);
		Assert.assertEquals(Bebidas.Leche, nuevoVaso.getSegundaBebida());
	}
	@Test
	public void pruebaHacedorDeTe(){
		HacedorDeTe nuevoTe = new HacedorDeTe();
		Vaso nuevoVasoParaTe = new Vaso();
		nuevoTe.prepararEnEsteVaso(nuevoVasoParaTe);
		Assert.assertEquals(Bebidas.Te, nuevoVasoParaTe.getNuevaBebida());
	}
	@Test
	public void pruebaHacedorDeCafe(){
		HacedorDeCafeConLeche nuevoCafe = new HacedorDeCafeConLeche();
		Vaso nuevoVasoParaCafeConLeche = new Vaso();
		nuevoCafe.prepararEnEsteVaso(nuevoVasoParaCafeConLeche);
		Assert.assertEquals(Bebidas.Cafe, nuevoVasoParaCafeConLeche.getNuevaBebida());
		Assert.assertEquals(Bebidas.Leche, nuevoVasoParaCafeConLeche.getSegundaBebida());

	}
	@Test
	public void pruebaAzucareri(){
		Azucarero nuevoAzucar = new Azucarero(10);
		nuevoAzucar.setTopeAzucar(50);
		Vaso nuevoVasoSoloIngresaAzucar = new Vaso();
		nuevoAzucar.ponerNEnEsteVaso(10, nuevoVasoSoloIngresaAzucar);
		Assert.assertEquals(40, nuevoAzucar.getTopeAzucar());

	}	
}
