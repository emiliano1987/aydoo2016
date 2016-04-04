package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Voto {
	
	Candidato candidatoVotado;
	Provincia provinciaDondeEmitioVoto;
	Partido obtengoPartido;
	List<Candidato> candidatos = new LinkedList<Candidato>();
	public Voto(Candidato nuevoCandidato, Provincia provinciaDondeVoto) {
		this.candidatoVotado = nuevoCandidato;
		this.provinciaDondeEmitioVoto = provinciaDondeVoto;
	}
	
	public Candidato obtenerCandidatoSegunVoto (){
		return this.candidatoVotado;
	}

	public Provincia obtenerProvinciaSegunVoto(){
		return this.provinciaDondeEmitioVoto;
	}
	
	public List<Candidato> obtenerListaCandidato (Partido partidoPolitico){
		Iterator<Candidato> iterarLista = candidatos.iterator();
		while(iterarLista.hasNext()){
			if(iterarLista.next().partidoPolitico.equals(partidoPolitico)){
				candidatos.add(iterarLista.next());
			}
		}
		return candidatos;
		
	}
}
