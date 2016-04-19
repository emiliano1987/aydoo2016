package ar.edu.untref.aydoo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.*;

public class FactoresPrimosTest {
	
	FileWriter nuevoArchivoGenerado;

	@Before
	public void inicializa() throws IOException{
		nuevoArchivoGenerado = new FileWriter("textoPrueba.txt");
	}
	
	@Test
	public void descomprimeFactoresPrimosSoloValo1() throws IOException{
		FactoresPrimos factorPrimoADescomprimir = new FactoresPrimos();
		int valorDescomprimir = 1;
		factorPrimoADescomprimir.factoresPrimos(valorDescomprimir, true, true, true, nuevoArchivoGenerado);
		Assert.assertTrue(1 == factorPrimoADescomprimir.obtenerNumeroDeDescomposicion(0));

	}
	@Test
	public void pruebaFactoresPrimosDelNumero90() throws IOException{
		FactoresPrimos factorPrimoADescomprimir = new FactoresPrimos();
		int valorDescomprimir = 90;
		factorPrimoADescomprimir.factoresPrimos(valorDescomprimir, false, true, false, nuevoArchivoGenerado);
		Assert.assertTrue(3 == factorPrimoADescomprimir.obtenerNumeroDeDescomposicion(2));

	}
	@Test
	public void pruebaParametrosFactoresPrimosNumero10FormatoPretty()throws IOException{
		FactoresPrimos factorPrimoADescomprimir = new FactoresPrimos();
		int valorDescomprimir = 10;
		ArrayList<Integer> listaDeValoresDescomprimidos =  new ArrayList<Integer>();
		listaDeValoresDescomprimidos.add(2);
		listaDeValoresDescomprimidos.add(5);
		Assert.assertTrue(listaDeValoresDescomprimidos.equals(factorPrimoADescomprimir.factoresPrimos(valorDescomprimir,false,true,false,nuevoArchivoGenerado)));
	}
	@Test
	public void parametrosFactoresPrimosNumero10FormatoQuite() throws IOException{
		FactoresPrimos factorPrimoADescomprimir = new FactoresPrimos();
		int valorDescomprimir = 8;
		ArrayList<Integer> listaDeValoresDescomprimidos =  new ArrayList<Integer>();
		listaDeValoresDescomprimidos.add(2);
		listaDeValoresDescomprimidos.add(2);
		listaDeValoresDescomprimidos.add(2);
		Assert.assertTrue(listaDeValoresDescomprimidos.equals(factorPrimoADescomprimir.factoresPrimos(valorDescomprimir,false,false,false,nuevoArchivoGenerado)));
	}
	@Test
	public void imprimeEnFormatoQuiteValor16() throws IOException{
		FactoresPrimos factorPrimoADescomprimir = new FactoresPrimos();
		int valorDescomprimir = 16;
		factorPrimoADescomprimir.factoresPrimos(valorDescomprimir,false,false,false,nuevoArchivoGenerado);
		Assert.assertTrue(2 == factorPrimoADescomprimir.obtenerNumeroDeDescomposicion(2));
	}
	@Test
	public void noImprimeEnOrdenEnFormatoQuiteValor18() throws IOException{
		FactoresPrimos factorPrimoADescomprimir = new FactoresPrimos();
		int valorDescomprimir = 18;
		factorPrimoADescomprimir.factoresPrimos(valorDescomprimir,false,true,true,nuevoArchivoGenerado);
		Assert.assertTrue(3 == factorPrimoADescomprimir.obtenerNumeroDeDescomposicion(2));
	}
	@Test
	public void imprimeEnFormatoQuiteValor30() throws IOException{
		FactoresPrimos factorPrimoADescomprimir = new FactoresPrimos();
		int valorDescomprimir = 30;
		factorPrimoADescomprimir.factoresPrimos(valorDescomprimir,false,false,true,nuevoArchivoGenerado);
		Assert.assertTrue(3 == factorPrimoADescomprimir.obtenerNumeroDeDescomposicion(1));
	}
	@Test
	public void imprimeEnFormatoQuiteValor8() throws IOException{
		FactoresPrimos factorPrimoADescomprimir = new FactoresPrimos();
		int valorDescomprimir = 8;
		factorPrimoADescomprimir.factoresPrimos(valorDescomprimir,true,false,false,nuevoArchivoGenerado);
		Assert.assertTrue(2 == factorPrimoADescomprimir.obtenerNumeroDeDescomposicion(1));
	}
	@Test
	public void imprimeEnFormatoQuite() throws IOException{
		FactoresPrimos factorPrimoADescomprimir = new FactoresPrimos();
		int valorDescomprimir = 6;
		factorPrimoADescomprimir.factoresPrimos(valorDescomprimir,true,true,false,nuevoArchivoGenerado);
		Assert.assertTrue(2 == factorPrimoADescomprimir.obtenerNumeroDeDescomposicion(0));
	}
	@Test
	public void imprimeEnArchivoFormatoQuiteValor22() throws IOException{
		FactoresPrimos factorPrimoADescomprimir = new FactoresPrimos();
		int valorDescomprimir = 22;
		factorPrimoADescomprimir.factoresPrimos(valorDescomprimir,true,false,true,nuevoArchivoGenerado);
		Assert.assertTrue(11 == factorPrimoADescomprimir.obtenerNumeroDeDescomposicion(1));
	}
}
