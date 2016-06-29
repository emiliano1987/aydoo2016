package ar.edu.untref.aydoo.modelo;

import java.util.Iterator;
import java.util.List;

public class FormatoPretty extends FormatoSalida{

	/**
	 * Metodo que genera el formato Pretty dado una lista de numeros ya descomprimidos y el numero que se descomprimio
	 */
	public String generoFormatoDeseado(List<Integer> factoresPrimosDescomprimidos, int numeroFactorPrimo) {

		String resultado = "";

		Iterator<Integer> numeroDescomprimidos = factoresPrimosDescomprimidos.iterator();
		while (numeroDescomprimidos.hasNext()) {
			Integer numeroActual = numeroDescomprimidos.next();
			String agregarNumero = String.valueOf(numeroActual);

			resultado += agregarNumero + " "; 
		}
		String salida = "Factores Primos " + numeroFactorPrimo + ": " + resultado;
		return salida;

	}
}