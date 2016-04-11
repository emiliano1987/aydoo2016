package ar.edu.untref.aydoo;

public class Periodico extends Producto {

	private String nombrePerodico;
	private int periodicidadPeriodico;

	public Periodico (String nombre, double precioPeriodico, int periodoSalidaDelPeriodicoMensual,boolean tieneSuscripcionAnual){
		super(precioPeriodico*periodoSalidaDelPeriodicoMensual,tieneSuscripcionAnual);
		this.nombrePerodico = nombre;
		this.periodicidadPeriodico = periodoSalidaDelPeriodicoMensual;
	}
	
	public int obtenerperiodicidadDelPeriodico(){
		return periodicidadPeriodico;
	}
	
	public String obtenerNombrePerodico() {
		return nombrePerodico;
	}

}