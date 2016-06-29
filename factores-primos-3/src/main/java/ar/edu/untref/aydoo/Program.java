package ar.edu.untref.aydoo;

import java.io.IOException;

import ar.edu.untref.aydoo.entrada.EntradaDeParametros;
import ar.edu.untref.aydoo.entrada.ParametrosIncorrectosException;
import ar.edu.untref.aydoo.modelo.NumeroIncorrectoException;

public class Program {

	public static void main(String[] args) throws NumeroIncorrectoException, ParametrosIncorrectosException, IOException{
		EntradaDeParametros entradaPorParametros = new EntradaDeParametros();
		entradaPorParametros.ordenaParametros(args);
	}

}
