package ar.edu.untref.aydoo;

/**
 * Clase Abstracta para preparar Vaso
 *
 */
public abstract class PrepararVaso {
	/**
	 * Metodo Abstracto para utilizar polimorfismo con el resto de las clases que necesiten
	 * @param nuevoVaso
	 * @return
	 */
	public abstract Vaso prepararEnEsteVaso(Vaso nuevoVaso);
}
