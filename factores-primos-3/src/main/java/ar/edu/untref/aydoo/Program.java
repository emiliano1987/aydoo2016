package ar.edu.untref.aydoo;

import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static final void main(String arg[]) throws IOException{

		// Genero los atributos. Los mismos permiten que no se lea dos veces los argumentos
		String parametroDeArchivo = new String();
		boolean generaElArchivo = false;
		boolean ordenAscendente = false;
		// El atributo contabilizarTamanioDelParametro es para verificar que se haya indicado correctamente la ruta para crear el archivo
		boolean formatoValido=false;
		String rutaArchivo = new String();
		FactoresPrimos imprimirFactoresPrimos = new FactoresPrimos();
		FileWriter generarArchivo =null;

		// Lee todos los argumentos ingresados por consola. En caso de encontrar un formato no esperado retorna error
		for (int contadorParametros=1;contadorParametros<arg.length;contadorParametros++){
			switch (arg[contadorParametros].toLowerCase()){
			case "--format=pretty":
				formatoValido=true;
				break;
			case "--format=quite":
				formatoValido=true;
				break;
			case "--sort:asc":
				ordenAscendente=true;
				break;
			case "--sort:des":
				ordenAscendente=false;
				break;
			default: 	
				if (arg[contadorParametros].toLowerCase().length()>14){
					if (arg[contadorParametros].toLowerCase().substring(0, 14).equals("--output-file=") ){
						rutaArchivo = arg[contadorParametros].substring(14);
						parametroDeArchivo = arg[contadorParametros].toLowerCase();
						generaElArchivo = true;
					}
				}else{
					formatoValido=false;
				}
				break;
			}
		}
		if (generaElArchivo == true && formatoValido == true){
			// Si hay una barra, lo genera en el lugar indicado, sino lo envia a la carpeta target donde se guardan los jar
			if(rutaArchivo.contains("/")){
				generarArchivo = new FileWriter(rutaArchivo);	
			}else{
				generarArchivo = new FileWriter("target/" + rutaArchivo);			
			}

			for (int nuevoContador=1;nuevoContador<arg.length;nuevoContador++){

				switch (arg[nuevoContador].toLowerCase()){
				case "--format=pretty":
					int numeroADescomprimirFormatoPretty = Integer.parseInt(arg[0]);
					imprimirFactoresPrimos.factoresPrimos(numeroADescomprimirFormatoPretty,true,true,ordenAscendente,generarArchivo);
					break;
				case "--format=quite":
					int numeroADescomprimirFormatoQuite = Integer.parseInt(arg[0]);
					imprimirFactoresPrimos.factoresPrimos(numeroADescomprimirFormatoQuite,true,false,ordenAscendente,generarArchivo);
					break;
				default: 
					if(!(parametroDeArchivo.equals(arg[nuevoContador].toLowerCase())||!(arg[nuevoContador].toLowerCase().equals("--sort:des"))||(!(arg[nuevoContador].toLowerCase().equals("--sort:asc"))))){
						System.out.println("Formato no aceptado. Por favor indicar el formato o el tipo de salida.");
						System.out.println("Para formato: --format=pretty o --format=quite");
						System.out.println("Para orden: --sort:des o --sort:asc");
					}
					break;
				}       
			}
		}else if (generaElArchivo == false && formatoValido == true){
			for (int nuevoContadorEnElse=1;nuevoContadorEnElse<arg.length;nuevoContadorEnElse++){

				switch (arg[nuevoContadorEnElse].toLowerCase()){
				case "--format=pretty":
					int numeroADescomprimirFormatoPretty = Integer.parseInt(arg[0]);
					System.out.print ("Factores primos "+ numeroADescomprimirFormatoPretty +" :");
					imprimirFactoresPrimos.factoresPrimos(numeroADescomprimirFormatoPretty, false, true,ordenAscendente, generarArchivo);
					System.out.println("");
					break;
				case "--format=quite":
					int numeroADescomprimirFormatoQuite = Integer.parseInt(arg[0]);
					System.out.print ("Factores primos "+ numeroADescomprimirFormatoQuite +" :");
					imprimirFactoresPrimos.factoresPrimos(numeroADescomprimirFormatoQuite,false,false,ordenAscendente,generarArchivo);
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