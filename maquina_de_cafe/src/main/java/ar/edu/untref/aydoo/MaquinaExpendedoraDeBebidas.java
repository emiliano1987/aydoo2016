package ar.edu.untref.aydoo;

/**
 * Clase MaquinaExpendedoraDeBebidas que se encargara de agregar lo solicitado al Vaso
 *
 */
public class MaquinaExpendedoraDeBebidas {

	HacedorDeCafeConLeche nuevoHacedorDeCafe = new HacedorDeCafeConLeche();
	HacedorDeTeConLeche nuevoHacedorDeTe = new HacedorDeTeConLeche();
	Azucarero agregarAzucar;
	
	/**
	 * Constructor de la Clase
	 * @param agregarAzucarAMaquina
	 */
	public MaquinaExpendedoraDeBebidas(int agregarAzucarAMaquina){
		this.agregarAzucar = new Azucarero(agregarAzucarAMaquina);
	}
	/**
	 * Metodo que retorna la cantidad de Azucar ingresada en la Maquina al crearla
	 * @return
	 */
	public Azucarero getAgregarAzucar() {
		return agregarAzucar;
	}
	
	/**
	 * Metodo para realizar un Cafe con Leche con Azucar. La cantidad que se solicita de azucar debe ser inferior a la que posee la maquina.
	 * (si no, informa el suceso). Si respeta lo anteriormente ingresado debe ingresar un vaso y modificar su contenido
	 * @param nCantidad
	 * @param vasoACompletar
	 * @return
	 */
	public Vaso hacerCafeConLecheConNDeAzucar(int nCantidad, Vaso vasoACompletar){
		if (nCantidad<agregarAzucar.getTopeAzucar()){
			nuevoHacedorDeCafe.prepararEnEsteVaso(vasoACompletar);
			agregarAzucar.ponerNEnEsteVaso(nCantidad, vasoACompletar);
		}else{
			try {
				throw new AzucarInsuficiente("Azucar insuficiente para generar Bebida");
			} catch (AzucarInsuficiente e) {
				System.out.println(e);
			}
			
		}
		return vasoACompletar;
	}
	
	/**
	 * Metodo para realizar un Te con Leche con Azucar. La cantidad que se solicita de azucar debe ser inferior a la que posee la maquina.
	 * (si no, informa el suceso). Si respeta lo anteriormente ingresado debe ingresar un vaso y modificar su contenido
	 * @param nCantidad
	 * @param nuevoVasoACompletar
	 * @return
	 */
	public Vaso hacerTeConLecheConNDeAzucar(int nCantidad, Vaso nuevoVasoACompletar){
		if (nCantidad<agregarAzucar.getTopeAzucar()){
		nuevoHacedorDeTe.prepararEnEsteVaso(nuevoVasoACompletar);
		agregarAzucar.ponerNEnEsteVaso(nCantidad, nuevoVasoACompletar);
		}else{
			try {
				throw new AzucarInsuficiente("Azucar insuficiente para generar Bebida");
			} catch (AzucarInsuficiente e) {
				System.out.println(e);
			}
			
		}
		return nuevoVasoACompletar;
	}
}
