package ar.edu.untref.aydoo;

/**
 * Clase Cafetero que extiende de Preparar Vaso y modifica su metodo abstracto
 *
 */
public class Cafetero extends PrepararVaso{

	/**
	 * Agrega Cafe al Vaso
	 */
	@Override
	public Vaso prepararEnEsteVaso(Vaso nuevoVaso) {
		nuevoVaso.setNuevaBebida(Bebidas.Cafe);
		return nuevoVaso;
	}

}
