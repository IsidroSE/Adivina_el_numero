package ensertarelnumero_isidro;

import java.util.ArrayList;
import java.util.Random;

/*@author Isidro*/

public class EnsertarElNumero_Isidro {
    

    public static void main(String[] args) {
        
        //Posarem el nombre de jugadors que jugaran al joc
        final int numJugadors = 4;
        //Variable on es guardará el temps que ha tardat el programa en ejecutarse
        long totalTemps;
        //Genera al arbit
        Arbit arbit = new Arbit(numJugadors);
        //Genera el grup de Jugadors
        ThreadGroup grupJugadors = new ThreadGroup("elsJugadors");
        //Crea la llista on es guardaran tots els jugadors
        ArrayList <Jugador> jugadors = new ArrayList();
        
        //Es generen els jugadors i es llançen
        for (int i=0 ; i<numJugadors ; i++) {
            jugadors.add(new Jugador(grupJugadors, i+1, arbit));
            jugadors.get(i).start();
        }
        
        //Mentre els jugadors seguixquen jugant, el main esperará
        while (grupJugadors.activeCount()>0);
        
        //Calcula el temps que ha durat la ejecució del programa i la mostra
        totalTemps = System.currentTimeMillis();
        System.out.println("Han tardat "+totalTemps+ " milisegons en encertar-ho");
        
        //El joc acaba
        System.out.println("El joc ha acabat!");
        
    }

}
