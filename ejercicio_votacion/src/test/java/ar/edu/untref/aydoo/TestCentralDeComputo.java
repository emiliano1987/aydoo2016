package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TestCentralDeComputo {
	@Test
	public void ejemplo(){
		
	CentralDeComputo centralDeComputosArgentina = new CentralDeComputo();
	Candidato DarioGonzalez = new Candidato (Partido.Cambiemos,"Dario Gonzalez");
	Voto nuevoVoto = new Voto (DarioGonzalez,Provincia.BuenosAires);
	centralDeComputosArgentina.agregarVoto(nuevoVoto);
	
	Assert.assertEquals(Partido.Cambiemos, centralDeComputosArgentina.obtenerMayorVotosEnProvinciaPorPartido(Provincia.BuenosAires));
	}
}
