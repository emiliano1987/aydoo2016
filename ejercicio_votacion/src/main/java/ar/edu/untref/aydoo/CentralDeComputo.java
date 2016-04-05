package ar.edu.untref.aydoo;

import java.util.*;

/**
 * Clase que modela el Centro de Computos donde se contaran los votos emitidos y los ganadores segun Provincia o Nacion
 * @author root
 *
 */
public class CentralDeComputo {

	private Partido partidoGanadorEnProvincia = null;
	private Map<Integer,Voto> registroVotantes = new HashMap<Integer,Voto>();
	private List<Voto> listadeCandidatosVotados = new LinkedList<Voto>();
	private List<Voto> listaDeProvinciasDondeSeEmitioElVoto = new LinkedList<Voto>();;
	private int numerador=0;

	/**
	 * Metodo que obtiene el nombre del Candidato ganador a nivel nacional
	 * @return
	 */
	public String obtenerResultadoEnPais() {
		String candidatoGanador;
		candidatoGanador = obtenerCandidatoConMayorRegistroDeVotos(registroVotantes);
		return candidatoGanador;
	}
	
	/**
	 * Clase privada que obtiene el candidato con mayor cantidad de votos a nivel nacional
	 * @param registroVotantes2
	 * @return
	 */
	private String obtenerCandidatoConMayorRegistroDeVotos(Map<Integer,Voto> votacionGeneral){
		Voto nuevoVoto = null;
		
		int cantidadDeVotos=0;
		
		Collection<Voto> cantidadGeneralDeVotos = votacionGeneral.values();

		for (Voto votoEmitido : cantidadGeneralDeVotos) {
        	if (noExisteEnLista(listadeCandidatosVotados, votoEmitido)){
        		nuevoVoto = votoEmitido;
        		cantidadDeVotos = 1;
        		nuevoVoto.modificaCantidadDeVotos(cantidadDeVotos);
        		listadeCandidatosVotados.add(nuevoVoto);
        	}else{
        		nuevoVoto = votoEmitido;
        		cantidadDeVotos = obtenerVotosTotalesYAgregar(listadeCandidatosVotados, nuevoVoto);
        		cantidadDeVotos++;
        		nuevoVoto.modificaCantidadDeVotos(cantidadDeVotos);
        		listadeCandidatosVotados.add(nuevoVoto);
        	}
        }
        String prueba = obtenerCandidatoGanador(listadeCandidatosVotados);
		
		return prueba;
		
	}
	
	/**
	 * Metodo que recuenta la cantidad de votos dependiendo un candidato y retorna la cantidad de Votos
	 * @param votos
	 * @param nuevoVoto
	 * @return
	 */
	public int obtenerVotosTotalesYAgregar(List<Voto> votos,Voto nuevoVoto){
		int cantidadTotalDeVotos=0;
		Voto totalVotos=null;
		Iterator<Voto> iterarVotosSiExisteCandidato= votos.listIterator();
		while(iterarVotosSiExisteCandidato.hasNext()){
			totalVotos = iterarVotosSiExisteCandidato.next();
			if(totalVotos.obtenerCandidatoSegunVoto().obtenerNombreCandidato() == nuevoVoto.obtenerCandidatoSegunVoto().obtenerNombreCandidato()){
				cantidadTotalDeVotos = totalVotos.obtenerCantidadDeVotos();
			}
		}
		return cantidadTotalDeVotos;
	}
	
	/**
	 * Metodo que retorna si el registro si existe o no en la lista de votos emitidos
	 * @param votos
	 * @param nuevoVoto
	 * @return
	 */
	private boolean noExisteEnLista(List<Voto> votos,Voto nuevoVoto){
		boolean noExisteEnLista=true;
		Iterator<Voto> iterarVotosSiExisteCandidato= votos.listIterator();
		while(iterarVotosSiExisteCandidato.hasNext()){
			if(iterarVotosSiExisteCandidato.next().obtenerCandidatoSegunVoto().obtenerNombreCandidato() == nuevoVoto.obtenerCandidatoSegunVoto().obtenerNombreCandidato()){
				noExisteEnLista = false;
			}
		}
		return noExisteEnLista;
	}
	
	/**
	 * Clase que retorna el nombre del candidato ganador segun la lista de votos a nivel nacionalingresada
	 * @param votos
	 * @return
	 */
	private String obtenerCandidatoGanador(List<Voto> votos){
		Voto nuevoVoto;
		int cantidadDeVotos=0;
		Candidato nuevoCandidato=null;
		Iterator<Voto> votosTotales = votos.listIterator();
		while(votosTotales.hasNext()){
			nuevoVoto = votosTotales.next();
			if(nuevoVoto.obtenerCantidadDeVotos() > cantidadDeVotos){
				nuevoCandidato = nuevoVoto.obtenerCandidatoSegunVoto();
				cantidadDeVotos = nuevoVoto.obtenerCantidadDeVotos();
			}
		}
		return nuevoCandidato.obtenerNombreCandidato();
	}
	
	/**
	 * Metodo que retorna un partido ganador en la Provincia indicada
	 * @param nuevaProvincia
	 * @return
	 */
	public Partido obtenerMayorVotosEnProvinciaPorPartido (Provincia nuevaProvincia){
		iterarMapaSegunProvincia(registroVotantes, nuevaProvincia);
		return partidoGanadorEnProvincia;
	}

	/**
	 * Metodo que itera el voto segun la provincia indicada y lo guarda en una lista especifica
	 * @param mapa
	 * @param provinciaABuscar
	 */
	private void iterarMapaSegunProvincia(Map <Integer, Voto> mapaDeVotos, Provincia provinciaABuscar){
		Iterator<Voto> iterarVotos = mapaDeVotos.values().iterator();
		List<Voto> listaDeVotos = new LinkedList<Voto>();
		while (iterarVotos.hasNext()){
			Voto nuevoVoto = iterarVotos.next();
			if (provinciaABuscar.equals(nuevoVoto.provinciaDondeEmitioVoto)){
				listaDeVotos.add(nuevoVoto);
				}
		}
		partidoGanadorEnProvincia = obtenerPartidoConMayorRegistroDeVotos(listaDeVotos);
		
	}
	
	/**
	 * Metodo que retorna un Partido dada una lista de votos emitidos
	 * @param listaDeVotos
	 * @return
	 */
	public Partido obtenerPartidoConMayorRegistroDeVotos(List<Voto> listaDeVotos){
		Voto nuevoVoto = null;
		
		int cantidadDeVotos=0;
		
		Iterator<Voto> iterarVotos = listaDeVotos.listIterator();
		while(iterarVotos.hasNext()){
			nuevoVoto = iterarVotos.next();
        	if (noExisteEnLista(listaDeProvinciasDondeSeEmitioElVoto, nuevoVoto)){
        		cantidadDeVotos = 1;
        		nuevoVoto.modificaCantidadDeVotos(cantidadDeVotos);
        		listaDeProvinciasDondeSeEmitioElVoto.add(nuevoVoto);
        	}else{
        		cantidadDeVotos = obtenerVotosTotalesYAgregar(listaDeProvinciasDondeSeEmitioElVoto, nuevoVoto);
        		cantidadDeVotos++;
        		nuevoVoto.modificaCantidadDeVotos(cantidadDeVotos);
        		listaDeProvinciasDondeSeEmitioElVoto.add(nuevoVoto);
        	}
        }
        Partido prueba = obtenerPartidoGanador(listaDeProvinciasDondeSeEmitioElVoto);
		
		return prueba;
		
	}
	
	/**
	 * Metodo que obtiene el Partido ganador segun una lista de votos emitidos
	 * @param votos
	 * @return
	 */
	private Partido obtenerPartidoGanador(List<Voto> votos){
		Voto nuevoVoto;
		int cantidadDeVotos=0;
		Candidato nuevoCandidato=null;
		Iterator<Voto> votosTotales = votos.listIterator();
		while(votosTotales.hasNext()){
			nuevoVoto = votosTotales.next();
			if(nuevoVoto.obtenerCantidadDeVotos() > cantidadDeVotos){
				nuevoCandidato = nuevoVoto.obtenerCandidatoSegunVoto();
				cantidadDeVotos = nuevoVoto.obtenerCantidadDeVotos();
			}
		}
		
		return nuevoCandidato.obtenerPartidoPorCandidato();
	}
	
	/**
	 * Se agrega un voto a un Diccionario o Mapa donde la clave varia y el valor es el nuevo voto emitido
	 * @param nuevoVoto
	 */
	public void agregarVoto(Voto nuevoVoto) {
		registroVotantes.put(numerador,nuevoVoto);
		numerador++;

	}
}