package ar.edu.untref.aydoo;

/**
 * Clase Voto la cual contiene un Candidato y una provincia donde se emite el voto
 * @author root
 *
 */
public class Voto {
	
	private Candidato candidatoVotado;
	public Provincia provinciaDondeEmitioVoto;
	private int votoPorCandidato;
	
	/**
	 * Constructor de la clase 
	 * @param nuevoCandidato: admite un candidato nuevo de la clase Candidato
	 * @param provinciaDondeVoto: admite una provincia de la clase Provincia
	 */
	public Voto(Candidato nuevoCandidato, Provincia provinciaDondeVoto) {
			this.candidatoVotado = nuevoCandidato;
			this.provinciaDondeEmitioVoto = provinciaDondeVoto;
	}
		
	/**
	 *  Metodo que devuelve el candidato segun el voto emitido
	 * @return
	 */
	public Candidato obtenerCandidatoSegunVoto (){
		return this.candidatoVotado;
	}
	
	/**
	 * Modifica la cantidad de votos que recibe un Candidato
	 * @param votosCantidad
	 */
	public void modificaCantidadDeVotos(int votosCantidad){
		this.votoPorCandidato = votosCantidad;
	}
	
	/**
	 * Obtiene la cantidad total de votos que tiene un candidato
	 * @return
	 */
	public int obtenerCantidadDeVotos(){
		return this.votoPorCandidato;
	}
	
	/**
	 *  Metodo que devuelve una Provincia donde se emitio el voto
	 * @return
	 */
	public Provincia obtenerProvinciaSegunVoto(){
		return this.provinciaDondeEmitioVoto;
	}
}