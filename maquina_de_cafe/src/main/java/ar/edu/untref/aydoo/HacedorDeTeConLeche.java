package ar.edu.untref.aydoo;

/**
 * Clase HacedorDeTeConLeche que extiende de Preparar Vaso y modifica su metodo abstracto
 *
 */
public class HacedorDeTeConLeche extends PrepararVaso{
	
	HacedorDeTe hacerTe = new HacedorDeTe();
	Lechero agregarLeche = new Lechero();
	
	/**
	 * Prepara el Vaso, solicitando Te y Leche
	 */
	@Override
	public Vaso prepararEnEsteVaso(Vaso nuevoVaso) {
		hacerTe.prepararEnEsteVaso(nuevoVaso);
		agregarLeche.prepararEnEsteVaso(nuevoVaso);
		return nuevoVaso;
	}

}
