package ar.edu.untref.aydoo;

public class Program 
{
    public static final void main(String arg[])
    {
        FactoresPrimos imprimirFactoresPrimos = new FactoresPrimos();
        int numeroADescomprimir = Integer.parseInt(arg[0]);
		System.out.print ("Factores primos "+ numeroADescomprimir +" :");
        imprimirFactoresPrimos.factoresPrimos(numeroADescomprimir,true);
        System.out.println();
    }
}
