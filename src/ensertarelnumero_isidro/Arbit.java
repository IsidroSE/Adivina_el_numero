package ensertarelnumero_isidro;

import java.util.Random;

/*@author Isidro*/

public class Arbit {

    private boolean acabat;
    private Random rand;
    private int numAleatori;
    private int torn;
    private int numJugadors;
    
    public Arbit (int numJugadors) {
        //Variable que dirá si ha acabat el joc
        acabat = false;
        //Genera el número aleatori que tindran que acertar els jugadors
        rand = new Random();
        numAleatori = rand.nextInt(10) + 1;
        System.out.print("Tots a buscar el <"+numAleatori+">. ");
        //Genera el número de jugador el cual començara el joc
        torn = rand.nextInt(numJugadors) + 1;
        System.out.println("Comença a jugar ["+torn+"]");
        //Agafa el número de jugadors
        this.numJugadors = numJugadors;
    }
    
    
    //Es cridat per els jugadors per a saber si ja es el seu torn
    public boolean esElMeuTorn (int numJugador) {
        boolean meuTorn = false;
        
        if (numJugador == torn) {
            meuTorn = true;
        }
        
        return meuTorn;
    }
    
    //Jugar, el jugador li pasa un número i el arbit el dirá si l'has acertat o no
    public synchronized void acertat (int num, int numJugador) {
        
        if (num == numAleatori) {
            acabat = true;
            System.out.println("Jugador "+numJugador+" guanya!!!");
        }
        else {
            if (torn+1 <= numJugadors) {
                torn++;
            }
            else {
                torn = 1;
            }
        }
        
    }

    //Retorna un boolea dient si ha acabat ja o no
    public boolean isAcabat() {
        return acabat;
    }
    
    
    
}
