package ar.edu.untref.aydoo;


/**
 * Clase HacedorDeCafeConLeche que extiende de Preparar Vaso y modifica su metodo abstracto
 *
 */
public class HacedorDeCafeConLeche extends PrepararVaso{
	Cafetero nuevoCafetero = new Cafetero();
	Lechero nuevoLechero = new Lechero();
	
	/**
 	 * Prepara el Vaso, solicitando Cafe y Leche
	 */
	@Override
	public Vaso prepararEnEsteVaso(Vaso nuevoVaso) {
		nuevoCafetero.prepararEnEsteVaso(nuevoVaso);
		nuevoLechero.prepararEnEsteVaso(nuevoVaso);
		return nuevoVaso;
	}
}
