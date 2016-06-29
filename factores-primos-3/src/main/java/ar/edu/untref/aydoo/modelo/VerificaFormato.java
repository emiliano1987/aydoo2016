package ar.edu.untref.aydoo.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerificaFormato {

	Map <String, FormatoSalida> formatos;

	public VerificaFormato() {
		this.formatos = new HashMap<String, FormatoSalida>();
		this.formatos.put("", new FormatoPretty());
		this.formatos.put("--format=pretty", new FormatoPretty());
		this.formatos.put("--format=quiet", new FormatoQuiet());
	}

	public String generaFormatoSalida(String formato, List<Integer> numerosOrdenados,int numero) {

		String formatoSalida = this.formatos.get("--format=pretty").generoFormatoDeseado(numerosOrdenados,numero);

		if (formato.startsWith("--format")) {
			formatoSalida = formatos.get(formato).generoFormatoDeseado(numerosOrdenados,numero);
			return formatoSalida;
		}
		return formatoSalida;
	}
}