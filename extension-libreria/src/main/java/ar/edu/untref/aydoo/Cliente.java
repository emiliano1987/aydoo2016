package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Cliente {

	private String nombre;
	private String direccion;
	private List<Compra> compras;
	private List<Alquiler> alquiler;
	private List<Suscripcion> suscripciones;

	/**
	 * @Pre: nombre y direccion son distintos de null (Las entradas se suponen validas).
	 * @Post: Se Inicializa el Cliente con el nombre y la direccion insertados.
	 */
	public Cliente(String nombre, String direccion){

		this.nombre = nombre;
		this.direccion = direccion;
		this.compras = new LinkedList<Compra>();
		this.alquiler = new LinkedList<Alquiler>();
		this.suscripciones = new LinkedList<Suscripcion>();
	}

	/**
	 * @Pre: - 
	 * @Post: Devuelve el nombre del Cliente.
	 */
	public String obtenerNombre(){
		return this.nombre;
	}

	/**
	 * @Pre: - 
	 * @Post: Devuelve la direccion del Cliente.
	 */
	public String obtenerDireccion(){
		return this.direccion;
	}

	/**
	 * @Pre: nuevaCompra es distinto de null (La entrada se supone valida).
	 * @Post: Agrega la compra a la lista de compras que hizo el Cliente.
	 */
	public void agregarCompra(Compra nuevaCompra){
		this.compras.add(nuevaCompra);
	}

	/**
	 * 
	 */
	public void agregaAlquiler (Alquiler nuevoAlquiler){
		this.alquiler.add(nuevoAlquiler);
	}

	public List<Alquiler> obtenerAlquilerDeLibros(){
		return this.alquiler;
	}

	/**
	 * @Pre: - 
	 * @Post: Devuelve la lista de compras que hizo el Cliente.
	 */
	public List<Compra> obtenerCompras(){
		return this.compras;
	}

	/**
	 * @throws SuscripcionExistente 
	 * @Pre: suscriptible es distinto de null y no hay una suscripcion previa a el (La entrada se supone valida).
	 * @Post: El Cliente queda suscripto al suscriptible indicado y se agrega a la lista de suscripciones.
	 */
	public void suscribirse(Suscriptible suscriptible){

		boolean esAnual = false;
		this.crearSuscripcion(suscriptible, esAnual);

	}

	/**
	 * @throws SuscripcionExistente 
	 * @Pre: suscriptible es distinto de null y no hay una suscripcion previa a el (La entrada se supone valida).
	 * @Post: El Cliente queda suscripto anualmente al suscriptible indicado y se agrega a la lista de suscripciones.
	 */
	public void suscribirseAnualmente(Suscriptible suscriptible){

		boolean esAnual = true;
		this.crearSuscripcion(suscriptible, esAnual);

	}

	/**
	 * @Pre: suscripcion es distinto de null (La entrada se supone valida).
	 * @Post: Elimina de la lista de suscripciones (Sea anual o no) a la inscripcion insertada.
	 */
	public void eliminarSuscripcion(Suscripcion suscripcion){
		this.suscripciones.remove(suscripcion);
	}

	/**
	 * @Pre: - 
	 * @Post: Devuelve la lista de suscripciones a suscriptibles del Cliente.
	 */
	public List<Suscripcion> obtenerSuscripciones(){
		return this.suscripciones;
	}

	/**
	 * @Pre: suscriptible es distinto de null (La entrada se supone valida).
	 * @Post: Devuelve si el suscriptible existe en la lista.
	 */
	private boolean suscriptibleExiste(Suscriptible suscriptible){

		boolean suscriptibleExiste = false;

		for(int i = 0 ; i < this.suscripciones. size() ; i++){
			if(this.suscripciones.get(i).obtenerSuscriptible() == suscriptible){
				suscriptibleExiste = true;
			}
		}
		return suscriptibleExiste;
	}

	/**
	 * @Pre: suscriptible y esAnual es distinto de null (La entrada se supone valida).
	 * @Post: si el suscriptible no existe en la lista se agrega un nuevo suscriptible en la lista.
	 */
	private void crearSuscripcion(Suscriptible suscriptible, boolean esAnual){

		if(!this.suscriptibleExiste(suscriptible)){
			Suscripcion suscripcion = new Suscripcion(this, suscriptible, esAnual);
			this.suscripciones.add(suscripcion);
		}
	}

}