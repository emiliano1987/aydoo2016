package ar.edu.untref.aydoo;

import java.io.IOException;

import org.junit.Test;

import ar.edu.untref.aydoo.Program;
import ar.edu.untref.aydoo.entrada.ParametrosIncorrectosException;
import ar.edu.untref.aydoo.modelo.NumeroIncorrectoException;

public class ProgramTest {

	@Test (expected=ParametrosIncorrectosException.class)
	public void verificaElFuncionamientoSinParametros() throws NumeroIncorrectoException, ParametrosIncorrectosException, IOException{
		String [] args = {};
		Program.main(args);
	}
	
	@Test (expected=NumeroIncorrectoException.class)
	public void verificaElFuncionamientoConNumerosNegativos() throws NumeroIncorrectoException, ParametrosIncorrectosException, IOException{
		String [] args = {"-10"};
		Program.main(args);
	}

}
