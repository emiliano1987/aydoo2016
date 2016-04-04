package ar.edu.untref.aydoo;

import java.util.*;

public class CentralDeComputo {

	Candidato candidatoGanador;
	Partido partidoGanadorEnProvincia = null;
	Map<Integer, Voto> registroVotantes = new TreeMap<Integer, Voto>();
    int [] losValores =  new int[11];
    int votosCambiemos=0;
    int votosCompromisoFederal=0;
    int votosFpv=0;
    int votosFit=0;
    int votosFrentePopular=0;
    int votosMovimientodeAccionVecinal=0;
    int votosMst=0;
    int votosNuevoMas=0;
    int votosProgresistas=0;
    int votosPartidoPopular=0;
    int votosUnidosPorUnaNuevaAlternativa=0;

	public String obtenerResultadoEnPais() {
		
		
		return "";
	}
	public Partido obtenerMayorVotosEnProvinciaPorPartido (Provincia nuevaProvincia){
		iterarMapaSegunProvincia(registroVotantes, nuevaProvincia);
		return partidoGanadorEnProvincia;
	}

	public void iterarMapaSegunProvincia(Map <Integer, Voto> mapa, Provincia provinciaABuscar){
		Iterator<Voto> it = mapa.values().iterator();
		List<Voto> listaDeVotos = new LinkedList<Voto>();
		while (it.hasNext()){
			Voto nuevoVoto = it.next();
			if (provinciaABuscar.equals(nuevoVoto.provinciaDondeEmitioVoto)){
				listaDeVotos.add(nuevoVoto);
				}
		}
		partidoGanadorEnProvincia = obtenerPartidoGanador(listaDeVotos);
		
	}
	public Partido obtenerPartidoGanador (List<Voto> listaVotos){
		Iterator <Voto> itera = listaVotos.listIterator();
		Partido partidoGanador=null;
		Voto comparador;
		while(itera.hasNext()){
			comparador=itera.next();
		switch (comparador.obtenerCandidatoSegunVoto().obtenerPartidoPorCandidato()){
		case Cambiemos:
			this.votosCambiemos++;
			break;
		case CompromisoFederal:
			this.votosCompromisoFederal++;
			break;
		case FIT:
			this.votosFit++;
			break;
		case FrenteParaLaVictoria:
			this.votosFpv++;
			break;
		case FrentePopular:
			this.votosFrentePopular++;
			break;
		case MovimientodeAccionVecinal:
			this.votosMovimientodeAccionVecinal++;
			break;
		case Mst:
			this.votosMst++;
			break;
		case NuevoMas:
			this.votosNuevoMas++;
			break;
		case PartidoPopular:
			this.votosPartidoPopular++;
			break;
		case Progresistas:
			this.votosProgresistas++;
			break;
		case UnidosPorUnaNuevaAlternativa:
			this.votosUnidosPorUnaNuevaAlternativa++;
			break;
		default:
			break;
		}
		}
		losValores[0]=votosCambiemos;
		losValores[1]=this.votosCompromisoFederal;
		losValores[2]=this.votosFit;
		losValores[3]=this.votosFpv;
		losValores[4]=this.votosFrentePopular;
		losValores[5]=this.votosMovimientodeAccionVecinal;
		losValores[6]=this.votosMst;
		losValores[7]=this.votosNuevoMas;
		losValores[8]=this.votosPartidoPopular;
		losValores[9]=this.votosProgresistas;
		losValores[10]=this.votosUnidosPorUnaNuevaAlternativa;
		partidoGanador = consultarMayorResultado(losValores);
		return partidoGanador;
	}
	private Partido consultarMayorResultado(int[] listaDePartidos) {
		int resultado=0;
		int partido=0;
		Partido nuevoPartido = Partido.FIT;
		for(int i=0;i<listaDePartidos.length;i++){
			if(resultado>listaDePartidos[i]){
				resultado = listaDePartidos[i];
				partido = i;
			}
		}
		switch (partido){
		case 0: 
			nuevoPartido = Partido.Cambiemos;
			break;
		case 1: 
			nuevoPartido = Partido.CompromisoFederal;
			break;
		case 2: 
			nuevoPartido = Partido.FIT;
			break;
		case 3: 
			nuevoPartido = Partido.FrenteParaLaVictoria;
			break;
		case 4: 
			nuevoPartido = Partido.FrentePopular;
			break;
		case 5: 
			nuevoPartido = Partido.MovimientodeAccionVecinal;
			break;
		case 6: 
			nuevoPartido = Partido.Mst;
			break;
		case 7: 
			nuevoPartido = Partido.NuevoMas;
			break;
		case 8: 
			nuevoPartido = Partido.PartidoPopular;
			break;
		case 9: 
			nuevoPartido = Partido.Progresistas;
			break;
		case 10: 
			nuevoPartido = Partido.UnidosPorUnaNuevaAlternativa;
			break;
		}
		return nuevoPartido;
		
	}
	public void agregarVoto(Voto nuevoVoto) {
		switch (nuevoVoto.candidatoVotado.partidoPolitico){
		case Cambiemos:
			registroVotantes.put(0, nuevoVoto);
			break;
		case CompromisoFederal:
			registroVotantes.put(1, nuevoVoto);
			break;
		case FIT:
			registroVotantes.put(2, nuevoVoto);
			break;
		case FrenteParaLaVictoria:
			registroVotantes.put(3, nuevoVoto);
			break;
		case FrentePopular:
			registroVotantes.put(4, nuevoVoto);
			break;
		case MovimientodeAccionVecinal:
			registroVotantes.put(5, nuevoVoto);
			break;
		case Mst:
			registroVotantes.put(6, nuevoVoto);
			break;
		case NuevoMas:
			registroVotantes.put(7, nuevoVoto);
			break;
		case PartidoPopular:
			registroVotantes.put(8, nuevoVoto);
			break;
		case Progresistas:
			registroVotantes.put(9, nuevoVoto);
			break;
		case UnidosPorUnaNuevaAlternativa:
			registroVotantes.put(10, nuevoVoto);
			break;
		default:
			break;
		}
	}
}