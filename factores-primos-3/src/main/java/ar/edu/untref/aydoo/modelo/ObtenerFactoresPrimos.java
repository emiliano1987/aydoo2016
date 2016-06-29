package ar.edu.untref.aydoo.modelo;

import java.util.ArrayList;
import java.util.List;

public class ObtenerFactoresPrimos {

	List<Integer> descomposicionNumeros = new ArrayList<Integer>();

	/**
	 * Calcula los factores primos dado un numero entero a descomprimir
	 * @param numeroADescomprimir
	 * @return
	 * @throws NumeroIncorrectoException el numero no puede ser un valor negativo
	 */
	public List<Integer> calcularFactoresPrimos(int numeroADescomprimir) throws NumeroIncorrectoException{

		if(numeroADescomprimir < 0){
			throw new NumeroIncorrectoException();
		}
		if(numeroADescomprimir==1){
			descomposicionNumeros.add(numeroADescomprimir);
		}
		for (int contador = 2; contador <= numeroADescomprimir; contador++) {
			while (numeroADescomprimir % contador == 0) {
				numeroADescomprimir = numeroADescomprimir / contador;
				descomposicionNumeros.add(contador);
			}
		}
		return descomposicionNumeros;
	}

}