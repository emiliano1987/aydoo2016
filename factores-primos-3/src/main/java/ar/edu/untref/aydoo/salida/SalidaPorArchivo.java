package ar.edu.untref.aydoo.salida;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SalidaPorArchivo {

	public void generaSalidaEnArchivo(String resultado, String ruta) throws IOException {
		File archivo = new File(ruta);
		BufferedWriter escribeEnArchivo = new BufferedWriter(new FileWriter(archivo));
		escribeEnArchivo.write(resultado);
		escribeEnArchivo.close();
	}

}
