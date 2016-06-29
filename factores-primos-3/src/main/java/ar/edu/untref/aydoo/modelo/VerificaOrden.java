package ar.edu.untref.aydoo.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerificaOrden {

	Map<String, OrdenSalida> ordenes;

	public VerificaOrden() {
		this.ordenes = new HashMap<String, OrdenSalida>();
		this.ordenes.put("", new OrdenAscendente());
		this.ordenes.put("--sort:asc", new OrdenAscendente());
		this.ordenes.put("--sort:des", new OrdenDescendente());
	}

	public List<Integer> generaOrdenSalida(String orden, List<Integer> numeros) {

		List<Integer> ordenDeSalida = this.ordenes.get("--sort:asc").ordenSalidaDeNumeros(numeros);

		if (orden.startsWith("--sort")) {
			ordenDeSalida = ordenes.get(orden).ordenSalidaDeNumeros(numeros);
			return ordenDeSalida;
		}

		return ordenDeSalida;
	}
}