package ar.edu.untref.aydoo.modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class OrdenDescendente extends OrdenSalida {

	/**
	 * Metodo para ordenar la salida de los numeros descomprimidos con anterioridad
	 */
	public List<Integer> ordenSalidaDeNumeros(List<Integer> numerosDescomprimidos) {

		List<Integer> generarNumerosEnSentidoReverso = new LinkedList<Integer>();
		ListIterator<Integer> iterarLista = numerosDescomprimidos.listIterator(numerosDescomprimidos.size());

		while(iterarLista.hasPrevious()){
			int numero = iterarLista.previous();
			generarNumerosEnSentidoReverso.add(numero);
		}

		return generarNumerosEnSentidoReverso;
	}
}