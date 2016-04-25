package ar.edu.untref.aydoo;

@SuppressWarnings("serial")
public class elProductoNoEsUnLibroException extends Exception {

	public elProductoNoEsUnLibroException(){
		super ("El producto que se desea ingresar no es un libro");
	}
}
