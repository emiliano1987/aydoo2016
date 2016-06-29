package ar.edu.untref.aydoo.modelo;

import java.util.List;

public abstract class FormatoSalida {

	/**
	 * Metodo abstracto para generar salida dependiendo el formato ingresado
	 * @param numerosFactoresPrimosDescomprimidos
	 * @param numeroFactorPrimo
	 * @return
	 */
	public abstract String generoFormatoDeseado(List<Integer> numerosFactoresPrimosDescomprimidos, int numeroFactorPrimo);

}