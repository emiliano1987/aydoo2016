package ar.edu.untref.aydoo.modelo;

import java.util.Iterator;
import java.util.List;

public class FormatoQuiet extends FormatoSalida {

	/**
	 * Metodo que genera el formato Quiet dado una lista de numeros ya descomprimidos y el numero que se descomprimio
	 */
	public String generoFormatoDeseado(List<Integer> numerosDescomprimidos, int numeroFactorPrimo) {

		String resultado = "";
		String salidaResultadoFinal = "";
		Iterator<Integer> numeroDescomprimidos = numerosDescomprimidos.iterator();

		while (numeroDescomprimidos.hasNext()) {
			Integer numeroActual = numeroDescomprimidos.next();
			String agregarNumero = String.valueOf(numeroActual);
			resultado += ("\n") + agregarNumero; 
		}
		salidaResultadoFinal = "Factores Primos " + numeroFactorPrimo + ": " + resultado;

		return salidaResultadoFinal;
	}
}