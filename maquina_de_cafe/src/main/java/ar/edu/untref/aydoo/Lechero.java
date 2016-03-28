package ar.edu.untref.aydoo;

/**
 * Clase Lechero que extiende de Preparar Vaso y modifica su metodo abstracto
 *
 */
public class Lechero extends PrepararVaso{

	/**
	 * Agrega Leche al Vaso
	 */
	@Override
	public Vaso prepararEnEsteVaso(Vaso nuevoVaso) {
		nuevoVaso.setSegundaBebida(Bebidas.Leche);
		return nuevoVaso;
	}
}
