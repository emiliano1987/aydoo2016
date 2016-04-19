package ar.edu.untref.aydoo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class FactoresPrimos {

	boolean imprime = false;
	boolean orden = false;
	int valorDivisible =2;
	FileWriter nuevoArchivo = null;
	ArrayList<Integer> listaFactoresPrimos=new ArrayList<Integer> ();

	/**
	 *	pre: ingreso un numero entero. Ademas indico si deseo imprimir sus valores y que formato se espera de salida
	 *	post: generar toda la descomposicion en factores primos
	 * @throws IOException 
	 **/
	public void factoresPrimosDescomprime (int numeroPrimoADescomponer){
		if(numeroPrimoADescomponer>1){
			if(numeroPrimoADescomponer%valorDivisible==0){
				this.listaFactoresPrimos.add(valorDivisible);
				numeroPrimoADescomponer = numeroPrimoADescomponer/valorDivisible;
				this.factoresPrimosDescomprime(numeroPrimoADescomponer);
				this.valorDivisible++;
			}else{
				this.valorDivisible++;	
				this.factoresPrimosDescomprime(numeroPrimoADescomponer);
			}
		}
	}
	/**
	 * Metodo general que llama al resto de las clases dependiendo el numero a descomprimir. Si el mismo se imprime por consola o Archivo y si
	 * @throws IOException
	 **/
	public ArrayList<Integer> factoresPrimos (int numeroPrimoADescomponer, boolean imprime, boolean format,boolean orden,FileWriter nuevoArchivo) throws IOException{
		this.imprime = imprime;
		this.orden = orden;
		this.nuevoArchivo = nuevoArchivo;
		// Valida que el numero sea 1
		if(numeroPrimoADescomponer == 1){
			this.listaFactoresPrimos.add(numeroPrimoADescomponer);
		}else{
			this.factoresPrimosDescomprime(numeroPrimoADescomponer);
		}
		if(this.imprime == true){
			this.nuevoArchivo.write("Factores primos "+ numeroPrimoADescomponer +" :");
		}
		if (format == true){
			this.imprimirDescomposicionFormatoPretty(listaFactoresPrimos);
		}else if (format == false){
			this.imprimirDescomposicionFormatoQuite(listaFactoresPrimos);
		}
		return listaFactoresPrimos;
	}
	/**
	 * pre: Indico una lista de factores primos de un numero entero para imprimir en un formato deseado
	 * post: Imprimo los numeros de la lista
	 * @param listaFactoresPrimos
	 * @throws IOException 
	 */
	public void imprimirDescomposicionFormatoPretty(ArrayList<Integer> listaFactoresPrimos) throws IOException{
		Iterator<Integer> iterarListaFactoresPrimos = listaFactoresPrimos.iterator();
		while (iterarListaFactoresPrimos.hasNext()) {
			if (this.imprime == false){
				System.out.print(" ");
				Integer numeroDescomprimido = iterarListaFactoresPrimos.next();
				System.out.print(numeroDescomprimido);
			}else{
				this.nuevoArchivo.write(" ");
				Integer numeroDescomprimido = iterarListaFactoresPrimos.next();
				this.nuevoArchivo.write(numeroDescomprimido.toString());
			}

		}
		if (this.imprime == true){
			this.nuevoArchivo.close();
		}
	}
	/**
	 * pre: Indico una lista de factores primos de un numero entero para imprimir en un formato deseado
	 * post: Imprimo los numeros de la lista
	 * @param listaFactoresPrimos
	 */
	public void imprimirDescomposicionFormatoQuite(ArrayList<Integer> listaFactoresPrimos)throws IOException{
		if(this.orden == false){
			ListIterator<Integer> iterarListaFactoresPrimos = listaFactoresPrimos.listIterator(listaFactoresPrimos.size());
			while (iterarListaFactoresPrimos.hasPrevious()) {
				if (this.imprime == false){
					System.out.println("");
					Integer numeroDescomprimido = iterarListaFactoresPrimos.previous();
					System.out.print(numeroDescomprimido);
				}else{
					this.nuevoArchivo.write("\n");
					Integer numeroDescomprimido = iterarListaFactoresPrimos.previous();
					this.nuevoArchivo.write(numeroDescomprimido.toString());
				}
			}
		}else if(this.orden == true){
			Iterator<Integer> iterarListaFactoresPrimos = listaFactoresPrimos.iterator();
			while (iterarListaFactoresPrimos.hasNext()) {
				if (this.imprime == false){
					System.out.println("");
					Integer numeroDescomprimido = iterarListaFactoresPrimos.next();
					System.out.print(numeroDescomprimido);
				}else{
					this.nuevoArchivo.write("\n");
					Integer numeroDescomprimido = iterarListaFactoresPrimos.next();
					this.nuevoArchivo.write(numeroDescomprimido.toString());
				}

			}	
		}
		if (this.imprime == true){
			this.nuevoArchivo.close();
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