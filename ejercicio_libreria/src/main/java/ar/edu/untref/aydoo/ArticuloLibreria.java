package ar.edu.untref.aydoo;

public class ArticuloLibreria extends Producto{

	private String nombreArticulo;
	private static double porcentajeIVA = 21.00;

	public ArticuloLibreria (String nombre, double precioArticulo){
		super(precioArticulo+=(precioArticulo*porcentajeIVA/100),false);
		this.nombreArticulo = nombre;
	}

	public String obtenerNombreArticulo(){
		return this.nombreArticulo;
	}

	public static double obtenerPorcentajeIVA() {
		return porcentajeIVA;
	}

	public static void modificarPorcentajeIVA(double porcentajeIVA) {
		ArticuloLibreria.porcentajeIVA = porcentajeIVA;
	}

}