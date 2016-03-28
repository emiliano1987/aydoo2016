package ar.edu.untref.aydoo;

/**
 * Clase HacedorDeTe que extiende de Preparar Vaso y modifica su metodo abstracto
 *
 */
public class HacedorDeTe extends PrepararVaso{

	/**
	 * Prepara el Vaso agregandole Te
	 */
	@Override
	public Vaso prepararEnEsteVaso(Vaso nuevoVaso) {
		nuevoVaso.setNuevaBebida(Bebidas.Te);
		return nuevoVaso;
	}
}
