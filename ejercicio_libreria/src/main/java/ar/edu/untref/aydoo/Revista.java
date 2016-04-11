package ar.edu.untref.aydoo;

public class Revista extends Producto {

	private String nombreRevista;
	private double periodicidadRevista;

	public Revista (String nombre, double precioRevista, int periodoSalidaDelaRevistaMensual,boolean tieneSuscripcionAnual){
		super(precioRevista*periodoSalidaDelaRevistaMensual,tieneSuscripcionAnual);
		this.nombreRevista = nombre;
		this.periodicidadRevista = periodoSalidaDelaRevistaMensual;

	}

	public double obtenerperiodicidadDeLaRevista(){
		return periodicidadRevista;
	}

	public String obtenerNombreRevista() {
		return nombreRevista;
	}

}