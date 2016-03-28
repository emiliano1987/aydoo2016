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
}
