package ar.edu.untref.aydoo;

public class Cliente{

	private int idCliente;
	private String nombreCliente;
	private String direccionCliente;

	public Cliente (int idCliente, String ingresoNombre, String ingresoDireccion){
		this.idCliente = idCliente;
		this.nombreCliente = ingresoNombre;
		this.direccionCliente = ingresoDireccion;
	}

	public String obtenerNombreCliente() {
		return nombreCliente;
	}

	public int obtenerIdCliente() {
		return idCliente;
	}

	public void ModificarDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String obtenerDireccionCliente() {
		return direccionCliente;
	}

}