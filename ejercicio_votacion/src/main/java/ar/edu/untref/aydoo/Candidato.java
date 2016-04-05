package ar.edu.untref.aydoo;

/**
 * Clase que modela un Candidato segun un Partido y un Nombre
 * @author root
 *
 */
public class Candidato {

	private Partido partidoPolitico;
	private String nombreYApellidoDelCandidato;
	
	/**
	 * Constructor de la clase que permite el ingreso de un Partido y un nombre al Candidato elegido
	 * @param partidoSegunCandidato
	 * @param nombreYApellidoCandidato
	 */
	public Candidato(Partido partidoSegunCandidato, String nombreYApellidoCandidato) {
		this.partidoPolitico = partidoSegunCandidato;
		this.nombreYApellidoDelCandidato = nombreYApellidoCandidato;
	}
	
	/**
	 * Metodo que retorna el Partido al cual pertenece el candidato
	 * @return
	 */
	public Partido obtenerPartidoPorCandidato(){
		return this.partidoPolitico;
	}
	
	/**
	 * Metodo que retorna el nombre del Candidato
	 * @return
	 */
	public String obtenerNombreCandidato(){
		return this.nombreYApellidoDelCandidato;
	}

}