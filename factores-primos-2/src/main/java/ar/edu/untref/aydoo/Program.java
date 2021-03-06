package ar.edu.untref.aydoo;

public class Program 
{
    public static final void main(String arg[])
    {
    	try{
        FactoresPrimos imprimirFactoresPrimos = new FactoresPrimos();

        switch (arg[1].toLowerCase()){
        	case "--format=pretty":
                int numeroADescomprimirFormatoPretty = Integer.parseInt(arg[0]);
        		System.out.print ("Factores primos "+ numeroADescomprimirFormatoPretty +" :");
                imprimirFactoresPrimos.factoresPrimos(numeroADescomprimirFormatoPretty,true,true);
                System.out.println("");
        break;
        	case "--format=quite":
                int numeroADescomprimirFormatoQuite = Integer.parseInt(arg[0]);
        		imprimirFactoresPrimos.factoresPrimos(numeroADescomprimirFormatoQuite,true,false);
            break;
        		default: 
                    System.out.println("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
            break;
        }
    	}catch(ArrayIndexOutOfBoundsException e){
            FactoresPrimos imprimirFactoresPrimos2 = new FactoresPrimos();

    		int numeroADescomprimirFormatoDefault = Integer.parseInt(arg[0]);
    		System.out.print ("Factores primos "+ numeroADescomprimirFormatoDefault +" :");
            imprimirFactoresPrimos2.factoresPrimos(numeroADescomprimirFormatoDefault,true,true);
            System.out.println("");
        }
        
    }
}
