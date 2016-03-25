package ar.edu.untref.aydoo;
import java.util.*;

public class FactoresPrimos {

	int valorDivisible =2;
	ArrayList<Integer> listaFactoresPrimos=new ArrayList<Integer> ();
	/**
	*	pre: ingreso un numero entero. Ademas indico si deseo imprimir sus valores
	*	post: generar toda la descomposicion en factores primos
	**/
	public void factoresPrimos (int numeroPrimoADescomponer, boolean imprime){
		if(numeroPrimoADescomponer>1){
			if(numeroPrimoADescomponer%valorDivisible==0){
				this.listaFactoresPrimos.add(valorDivisible);
				numeroPrimoADescomponer = numeroPrimoADescomponer/valorDivisible;
				this.factoresPrimos(numeroPrimoADescomponer,imprime);
				this.valorDivisible++;
			}else{
				this.valorDivisible++;
				this.factoresPrimos(numeroPrimoADescomponer,imprime);
			}
		}else if (imprime == true){
			this.imprimirDescomposicion(listaFactoresPrimos);
		}
	}
	/**
	 * pre: Indico una lista de factores primos de un numero entero
	 * post: Imprimo los numeros de la lista
	 * @param listaFactoresPrimos
	 */
	public void imprimirDescomposicion(ArrayList<Integer> listaFactoresPrimos){
		Iterator<Integer> iterarListaFactoresPrimos = listaFactoresPrimos.iterator();
		while (iterarListaFactoresPrimos.hasNext()) {
			System.out.print(" ");
			Integer numeroDescomprimido = iterarListaFactoresPrimos.next();
			System.out.print(numeroDescomprimido);
		}
	}
	/**
	 * pre: indico la posicion de la lista a buscar
	 * post: retorno el valor de la posicion ingresada
	 * @param posicion
	 * @return valorEnPosicion
	 */
	public int obtenerNumeroDeDescomposicion(int posicion){
		int valorEnPosicion = this.listaFactoresPrimos.get(posicion);
		return valorEnPosicion;
	}
	
	
}
