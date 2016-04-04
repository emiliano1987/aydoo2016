package ar.edu.untref.aydoo;

public class Candidato {

	Partido partidoPolitico;
	String nombreYApellidoDelCandidato;
	public Candidato(Partido partidoSegunCandidato, String nombreYApellidoCandidato) {
		this.partidoPolitico = partidoSegunCandidato;
		this.nombreYApellidoDelCandidato = nombreYApellidoCandidato;
	}
	
	public Partido obtenerPartidoPorCandidato(){
		return this.partidoPolitico;
	}
	
	public String obtenerNombreCandidato(){
		return this.nombreYApellidoDelCandidato;
	}

}
