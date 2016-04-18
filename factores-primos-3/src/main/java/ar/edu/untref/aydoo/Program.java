package ar.edu.untref.aydoo;

import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static final void main(String arg[]) throws IOException{
		String arreglo = new String();
		boolean prueba = false;
		boolean prueba2 = false;
		boolean respeta = false;
		boolean formatoValido=false;
		boolean formatoEsInvalido=false;
		String formato = new String();
		FactoresPrimos imprimirFactoresPrimos = new FactoresPrimos();
		FileWriter generarArchivo =null;

		for (int contadorParametros=1;contadorParametros<arg.length;contadorParametros++){
			respeta = arg[contadorParametros].toLowerCase().length()>14;
			switch (arg[contadorParametros].toLowerCase()){
			case "--format=pretty":
				formatoValido=true;
				break;
			case "--format=quite":
				formatoValido=true;
				break;
			case "--sort:asc":
				formatoValido=true;
				prueba2=true;
				break;
			case "--sort:des":
				formatoValido=true;
				break;
			default: 			
				if (respeta == true){
					if (arg[contadorParametros].toLowerCase().substring(0, 14).equals("--output-file=") ){
						formato = arg[contadorParametros].substring(14);
						arreglo = arg[contadorParametros].toLowerCase();
						prueba = true;
						formatoValido=true;
					}
				}else{
				formatoValido=false;}
				break;
			}
			if (formatoValido == false){
				formatoEsInvalido = true;
			}
		}



		if (prueba == true && formatoEsInvalido == false){
			generarArchivo = new FileWriter(formato);
			for (int nuevoContador=1;nuevoContador<arg.length;nuevoContador++){

				switch (arg[nuevoContador].toLowerCase()){
				case "--format=pretty":
					int numeroADescomprimirFormatoPretty = Integer.parseInt(arg[0]);
					imprimirFactoresPrimos.factoresPrimos(numeroADescomprimirFormatoPretty,true,true,prueba2,generarArchivo);
					break;
				case "--format=quite":
					int numeroADescomprimirFormatoQuite = Integer.parseInt(arg[0]);
					imprimirFactoresPrimos.factoresPrimos(numeroADescomprimirFormatoQuite,true,false,prueba2,generarArchivo);
					break;
				default: 
					if(!(arreglo.equals(arg[nuevoContador].toLowerCase())||!(arg[nuevoContador].toLowerCase().equals("--sort:des"))||(!(arg[nuevoContador].toLowerCase().equals("--sort:asc"))))){
						System.out.println("Formato no aceptado. Por favor indicar el formato o el tipo de salida.");
						System.out.println("Para formato: --format=pretty o --format=quite");
						System.out.println("Para orden: --sort:des o --sort:asc");
					}
					break;
				}       
			}
		}else if (prueba == false && formatoEsInvalido == false){
			for (int nuevoContadorEnElse=1;nuevoContadorEnElse<arg.length;nuevoContadorEnElse++){

				switch (arg[nuevoContadorEnElse].toLowerCase()){
				case "--format=pretty":
					int numeroADescomprimirFormatoPretty = Integer.parseInt(arg[0]);
					System.out.print ("Factores primos "+ numeroADescomprimirFormatoPretty +" :");
					imprimirFactoresPrimos.factoresPrimos(numeroADescomprimirFormatoPretty, false, true,prueba2, generarArchivo);
					System.out.println("");
					break;
				case "--format=quite":
					int numeroADescomprimirFormatoQuite = Integer.parseInt(arg[0]);
					System.out.print ("Factores primos "+ numeroADescomprimirFormatoQuite +" :");
					imprimirFactoresPrimos.factoresPrimos(numeroADescomprimirFormatoQuite,false,false,prueba2,generarArchivo);
					System.out.println("");
					break;
				default: 
					if(!(arg[nuevoContadorEnElse].toLowerCase().equals("--sort:des")||arg[nuevoContadorEnElse].toLowerCase().equals("--sort:asc"))){
						System.out.println("Formato no aceptado. Por favor indicar el formato o el tipo de salida.");
						System.out.println("Para formato: --format=pretty o --format=quite");
						System.out.println("Para orden: --sort:des o --sort:asc");
					}
					break;
				}       
			}
		}else{
			System.out.println("Formato no aceptado.");
			System.out.println("Para formato: --format=pretty o --format=quite");
			System.out.println("Para orden: --sort:des o --sort:asc");
		}
	}
}