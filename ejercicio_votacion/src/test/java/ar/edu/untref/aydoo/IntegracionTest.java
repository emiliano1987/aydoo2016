package ar.edu.untref.aydoo;

import org.junit.*;

public class IntegracionTest {
	Candidato mauricioMacri;
	Candidato danielScioli;
	Candidato sergioMassa;
	Candidato margaritaStolbizer;
	Candidato ernestoSanz;
	Candidato elisaCarrio;
	Candidato joseDeLaSota;
	Candidato nicolasDelCano;
	Candidato jorgeAltamira;
	Candidato adolfoRodriguezSaa;
	Candidato victorDeGennaro;
	Candidato manuelaCastineira;
	Candidato alejandroBodart;
	Candidato mauricioYattah;
	Candidato raulAlbarracin;
	Candidato enBlanco;
	
	@Before
	public void incializar(){
		mauricioMacri = new Candidato (Partido.Cambiemos,"Mauricio Macri");
		danielScioli = new Candidato (Partido.FrenteParaLaVictoria,"Daniel Scioli");
		sergioMassa = new Candidato (Partido.UnidosPorUnaNuevaAlternativa,"Sergio Massa");
		margaritaStolbizer = new Candidato (Partido.Progresistas,"Margarita Stolbizer");
		ernestoSanz = new Candidato (Partido.Cambiemos,"Ernesto Sanz");
		elisaCarrio = new Candidato (Partido.Cambiemos,"Elisa Carrio");
		joseDeLaSota = new Candidato (Partido.UnidosPorUnaNuevaAlternativa,"Jose De La Sota");
		nicolasDelCano = new Candidato (Partido.FIT,"Nicolas Del Cano");
		jorgeAltamira = new Candidato (Partido.FIT,"Jorge Altamira");
		adolfoRodriguezSaa = new Candidato (Partido.CompromisoFederal,"Adolfo Rodriguez Saa");
		victorDeGennaro = new Candidato (Partido.FrentePopular,"Victor De Gennaro");
		manuelaCastineira = new Candidato (Partido.NuevoMas,"Manuela Castineira");
		alejandroBodart = new Candidato (Partido.Mst,"Alejandro Bodart");
		mauricioYattah = new Candidato (Partido.PartidoPopular,"Mauricio Yattah");
		raulAlbarracin = new Candidato (Partido.MovimientodeAccionVecinal,"Raul Albarracin");
		enBlanco = new Candidato(Partido.enBlanco, "");
	}
	
	@Test
	public void emitirVoto(){
		Voto primerEmisionDeVoto = new Voto(mauricioYattah, Provincia.Cordoba);
		
		Assert.assertEquals(Provincia.Cordoba, primerEmisionDeVoto.obtenerProvinciaSegunVoto());
	}
	
	@Test
	public void pruebaGanadorANivelNacionalDelMismoPartido(){
		CentralDeComputo centralDeComputosVotosANivelNacional = new CentralDeComputo();
		
		Voto PrimerVotoSecreto = new Voto (elisaCarrio,Provincia.BuenosAires);
		Voto SegundoVotoSecreto = new Voto (ernestoSanz,Provincia.BuenosAires);
		Voto TercerVotoSecreto = new Voto (enBlanco,Provincia.BuenosAires);
		Voto CuartoVotoSecreto = new Voto (elisaCarrio,Provincia.BuenosAires);
		Voto QuintoVotoSecreto = new Voto (mauricioMacri,Provincia.BuenosAires);
		
		centralDeComputosVotosANivelNacional.agregarVoto(PrimerVotoSecreto);
		centralDeComputosVotosANivelNacional.agregarVoto(SegundoVotoSecreto);
		centralDeComputosVotosANivelNacional.agregarVoto(TercerVotoSecreto);
		centralDeComputosVotosANivelNacional.agregarVoto(CuartoVotoSecreto);
		centralDeComputosVotosANivelNacional.agregarVoto(QuintoVotoSecreto);
		
		Assert.assertEquals("Elisa Carrio", centralDeComputosVotosANivelNacional.obtenerResultadoEnPais());

	}
	
	@Test
	public void pruebaGanadorSegunProvinciaDelChaco(){
		CentralDeComputo centralDeComputosProvinciaDelChaco = new CentralDeComputo();
	
		Voto PrimerVotoSecreto = new Voto (sergioMassa,Provincia.Chaco);
		Voto SegundoVotoSecreto = new Voto (margaritaStolbizer,Provincia.Chaco);
		Voto TercerVotoSecreto = new Voto (mauricioMacri,Provincia.Chaco);
		Voto CuartoVotoSecreto = new Voto (mauricioMacri,Provincia.Chaco);
		Voto QuintoVotoSecreto = new Voto (mauricioMacri,Provincia.Chaco);
		Voto SextoVotoSecreto = new Voto (danielScioli,Provincia.Chaco);
		Voto SeptimoVotoSecreto = new Voto (danielScioli,Provincia.Chaco);
		Voto OctavoVotoSecreto = new Voto (danielScioli,Provincia.Chaco);
		Voto NovenoVotoSecreto = new Voto (mauricioMacri,Provincia.Chaco);
		Voto DecimoVotoSecreto = new Voto (enBlanco,Provincia.Chaco);

		centralDeComputosProvinciaDelChaco.agregarVoto(PrimerVotoSecreto);
		centralDeComputosProvinciaDelChaco.agregarVoto(SegundoVotoSecreto);
		centralDeComputosProvinciaDelChaco.agregarVoto(TercerVotoSecreto);
		centralDeComputosProvinciaDelChaco.agregarVoto(CuartoVotoSecreto);
		centralDeComputosProvinciaDelChaco.agregarVoto(QuintoVotoSecreto);
		centralDeComputosProvinciaDelChaco.agregarVoto(SextoVotoSecreto);
		centralDeComputosProvinciaDelChaco.agregarVoto(SeptimoVotoSecreto);
		centralDeComputosProvinciaDelChaco.agregarVoto(OctavoVotoSecreto);
		centralDeComputosProvinciaDelChaco.agregarVoto(NovenoVotoSecreto);
		centralDeComputosProvinciaDelChaco.agregarVoto(DecimoVotoSecreto);
		
		Assert.assertEquals(Partido.Cambiemos, centralDeComputosProvinciaDelChaco.obtenerMayorVotosEnProvinciaPorPartido(Provincia.Chaco));
	}
	
	@Test
	public void pruebaGanadorANivelNacional(){
		CentralDeComputo centralDeComputosANivelNacional = new CentralDeComputo();
		
		Voto PrimerVotoSecreto = new Voto (sergioMassa,Provincia.BuenosAires);
		Voto SegundoVotoSecreto = new Voto (margaritaStolbizer,Provincia.Catamarca);
		Voto TercerVotoSecreto = new Voto (mauricioMacri,Provincia.Jujuy);
		Voto CuartoVotoSecreto = new Voto (mauricioMacri,Provincia.Jujuy);
		Voto QuintoVotoSecreto = new Voto (mauricioMacri,Provincia.Salta);
		Voto SextoVotoSecreto = new Voto (danielScioli,Provincia.TierraDelFuego);
		Voto SeptimoVotoSecreto = new Voto (danielScioli,Provincia.Catamarca);
		Voto OctavoVotoSecreto = new Voto (danielScioli,Provincia.SantiagoDelEstero);
		Voto NovenoVotoSecreto = new Voto (mauricioMacri,Provincia.Chubut);
		Voto DecimoVotoSecreto = new Voto (enBlanco,Provincia.Chaco);
	
		centralDeComputosANivelNacional.agregarVoto(PrimerVotoSecreto);
		centralDeComputosANivelNacional.agregarVoto(SegundoVotoSecreto);
		centralDeComputosANivelNacional.agregarVoto(TercerVotoSecreto);
		centralDeComputosANivelNacional.agregarVoto(CuartoVotoSecreto);
		centralDeComputosANivelNacional.agregarVoto(QuintoVotoSecreto);
		centralDeComputosANivelNacional.agregarVoto(SextoVotoSecreto);
		centralDeComputosANivelNacional.agregarVoto(SeptimoVotoSecreto);
		centralDeComputosANivelNacional.agregarVoto(OctavoVotoSecreto);
		centralDeComputosANivelNacional.agregarVoto(NovenoVotoSecreto);
		centralDeComputosANivelNacional.agregarVoto(DecimoVotoSecreto);
		
		Assert.assertEquals("Mauricio Macri", centralDeComputosANivelNacional.obtenerResultadoEnPais());
	}
}
