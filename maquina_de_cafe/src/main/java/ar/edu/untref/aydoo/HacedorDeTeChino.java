package ar.edu.untref.aydoo;

/**
 * Clase HacedorDeTeChino que extiende de Preparar Vaso y modifica su metodo abstracto
 *
 */
public class HacedorDeTeChino extends PrepararVaso{

	/**
	 * Prepara el Vaso agregandole Te
	 */
	@Override
	public Vaso prepararEnEsteVaso(Vaso nuevoVaso) {
		nuevoVaso.setNuevaBebida(Bebidas.Te_Amarillo);
		return nuevoVaso;
	}
}
