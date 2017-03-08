package ensertarelnumero_isidro;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*@author Isidro*/

public class Jugador extends Thread {
    
    Arbit arbit;
    private int numJugador;
    Random rand;
    int num;
    ArrayList <Integer> numDits;

    public Jugador (ThreadGroup gp, int numJugador, Arbit arbit) {
        //El jugador estará dins de un grup de threads per a que el main puga esperar a que acaben tots
        super(gp, "");
        //Genera el numero de jugador
        this.numJugador = numJugador;
        //Objecte que gastarem per traure els números aleatoris
        rand = new Random();
        //Arbit que moderará la partida
        this.arbit = arbit;
        //ArrayList on es guardaran tots el números que ha dit el jugador
        numDits = new ArrayList();
    }
    
    //Ejecució del fil del jugador
    @Override
    public void run(){
        
        //Comprobará si el joc ha acabat i si no es el cas seguirá jugant
        while (!arbit.isAcabat()) {
            /*Antes de jugar lipreguntará al arbit si es el seu torn, si no ho es dormirá durant 1 segon,
            i si si que es el seu torn jugará*/
            if (arbit.esElMeuTorn(numJugador)) {
                jugar();
            }
            else {
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
    //El jugador es guardará els números que ja ha dit per no dir dues vegades el mateix numero
    public void jugar () {
        do {
            num = rand.nextInt(10) + 1;
        } while (numDits.contains(num));
        System.out.println("Jugador "+numJugador+" diu: "+num);
        arbit.acertat(num, numJugador);
        numDits.add(num);
    }
    
}
