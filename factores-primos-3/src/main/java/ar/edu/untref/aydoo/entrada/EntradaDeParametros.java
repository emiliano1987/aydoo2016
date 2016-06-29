package ar.edu.untref.aydoo.entrada;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import ar.edu.untref.aydoo.modelo.NumeroIncorrectoException;
import ar.edu.untref.aydoo.modelo.ObtenerFactoresPrimos;
import ar.edu.untref.aydoo.modelo.VerificaFormato;
import ar.edu.untref.aydoo.modelo.VerificaOrden;
import ar.edu.untref.aydoo.modelo.VerificadorDeParametros;
import ar.edu.untref.aydoo.salida.SalidaPorArchivo;
import ar.edu.untref.aydoo.salida.SalidaPorPantalla;

public class EntradaDeParametros {

	private List<Integer> numerosFactoresPrimos;
	private VerificadorDeParametros verificaParametrosIngresados;
	private ObtenerFactoresPrimos calcularFactoresPrimos;
	private VerificaOrden ordenador;
	private VerificaFormato formateador;

	public EntradaDeParametros() {
		this.numerosFactoresPrimos = new LinkedList<>();
		this.verificaParametrosIngresados = new VerificadorDeParametros();
		this.calcularFactoresPrimos = new ObtenerFactoresPrimos();
		this.ordenador = new VerificaOrden();
		this.formateador = new VerificaFormato();
	}
	/**
	 * Metodo que ordena los parametros ingresados por consola
	 * @param parametros
	 * @throws NumeroIncorrectoException
	 * @throws ParametrosIncorrectosException
	 * @throws IOException
	 */
	public void ordenaParametros(String[] parametros) throws NumeroIncorrectoException, ParametrosIncorrectosException, IOException {

		String resultado = "";
		List<Integer> numerosOrdenados;

		verificaParametrosIngresados.verificarParametros(parametros);

		int numero = this.verificaParametrosIngresados.obtenerNumeroADescomprimir();
		String orden = this.verificaParametrosIngresados.obtenerOrden();
		String formato = this.verificaParametrosIngresados.obtenerFormato();
		String ruta = this.verificaParametrosIngresados.obtenerRuta();

		numerosFactoresPrimos = this.calcularFactoresPrimos.calcularFactoresPrimos(numero);

		numerosOrdenados = this.ordenador.generaOrdenSalida(orden, numerosFactoresPrimos);
		resultado = this.formateador.generaFormatoSalida(formato, numerosOrdenados,numero);

		if (!verificaParametrosIngresados.imprimeArchivo()) {
			SalidaPorPantalla salidaPorPantalla = new SalidaPorPantalla();
			salidaPorPantalla.generaSalidaPorPantalla(resultado);
		} else {
			SalidaPorArchivo nuevaSalida = new SalidaPorArchivo();
			nuevaSalida.generaSalidaEnArchivo(resultado, ruta);
		}

	}

}