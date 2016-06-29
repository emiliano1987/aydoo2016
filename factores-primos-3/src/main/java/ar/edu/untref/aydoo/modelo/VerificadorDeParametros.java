package ar.edu.untref.aydoo.modelo;

import ar.edu.untref.aydoo.entrada.ParametrosIncorrectosException;

public class VerificadorDeParametros {

	private int numero;
	private String formato = "pretty";
	private String orden = "asc";
	private String nombreDeArchivo = "";
	private boolean imprimeArchivo = false;

	public void verificarParametros(String args[]) throws ParametrosIncorrectosException{

		if(args.length == 0 || args.length > 4){
			throw new ParametrosIncorrectosException();
		}

		for (String datos : args) {
			if (datos.contains("--format=")) {
				this.formato = datos.toLowerCase();
			} else if (datos.contains("--sort:")) {
				this.orden = datos.toLowerCase();
			} else if (datos.contains("--output-file=")) {
				String[] ruta = datos.split("=");
				this.nombreDeArchivo = ruta[1].toLowerCase();
				this.imprimeArchivo = true;
			}else{
				numero = Integer.parseInt(datos);
			}
		}
	}

	public String obtenerOrden() {
		return this.orden;
	}

	public String obtenerFormato() {
		return this.formato;
	}

	public String obtenerRuta() {
		return this.nombreDeArchivo;
	}

	public boolean imprimeArchivo() {
		return this.imprimeArchivo;
	}

	public int obtenerNumeroADescomprimir(){
		return this.numero;
	}

}


