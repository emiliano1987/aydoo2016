package ar.edu.untref.aydoo;

public class Libro extends Producto{

	private String nombreLibro;
	
	public Libro (String nombre, double precioLibro){
		super(precioLibro,false);

		this.nombreLibro = nombre;
	}

	public String obtenerNombreLibro(){
		return nombreLibro;
	}

}