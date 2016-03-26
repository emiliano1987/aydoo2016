package ar.edu.untref.aydoo;
import java.util.*;

public class FactoresPrimos {

	int valorDivisible =2;
	ArrayList<Integer> listaFactoresPrimos=new ArrayList<Integer> ();
	/**
	*	pre: ingreso un numero entero. Ademas indico si deseo imprimir sus valores y que formato se espera de salida
	*	post: generar toda la descomposicion en factores primos
	**/
	public ArrayList<Integer> factoresPrimos (int numeroPrimoADescomponer, boolean imprime, boolean format){
		if(numeroPrimoADescomponer>1){
			if(numeroPrimoADescomponer%valorDivisible==0){
				this.listaFactoresPrimos.add(valorDivisible);
				numeroPrimoADescomponer = numeroPrimoADescomponer/valorDivisible;
				this.factoresPrimos(numeroPrimoADescomponer,imprime,format);
				this.valorDivisible++;
			}else{
				this.valorDivisible++;
				this.factoresPrimos(numeroPrimoADescomponer,imprime,format);
			}
		}else if (imprime == true && format == true){
			this.imprimirDescomposicionFormatoPretty(listaFactoresPrimos);
		}else if (imprime == true && format == false){
			this.imprimirDescomposicionFormatoQuite(listaFactoresPrimos);
		}
		return listaFactoresPrimos;
	}
	/**
	 * pre: Indico una lista de factores primos de un numero entero para imprimir en un formato deseado
	 * post: Imprimo los numeros de la lista
	 * @param listaFactoresPrimos
	 */
	public void imprimirDescomposicionFormatoPretty(ArrayList<Integer> listaFactoresPrimos){
		Iterator<Integer> iterarListaFactoresPrimos = listaFactoresPrimos.iterator();
		while (iterarListaFactoresPrimos.hasNext()) {
			System.out.print(" ");
			Integer numeroDescomprimido = iterarListaFactoresPrimos.next();
			System.out.print(numeroDescomprimido);
		}
	}
	/**
	 * pre: Indico una lista de factores primos de un numero entero para imprimir en un formato deseado
	 * post: Imprimo los numeros de la lista
	 * @param listaFactoresPrimos
	 */
	public void imprimirDescomposicionFormatoQuite(ArrayList<Integer> listaFactoresPrimos){
		ListIterator<Integer> iterarListaFactoresPrimos = listaFactoresPrimos.listIterator(listaFactoresPrimos.size());
		while (iterarListaFactoresPrimos.hasPrevious()) {
			Integer numeroDescomprimido = iterarListaFactoresPrimos.previous();
			System.out.println(numeroDescomprimido);
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
