import java.util.*;
/**
 * 
 */
class Tempel {

    // Eigenschaften
    private String farbe;
    private Quizfrage[] fragenpoolOOP1;
    private Quizfrage[] fragenpoolOOP2;
    private Kartenspiel kartenspiel;

    /**
     * Konstruktor zum Erzeugen einer Instanz der Klasse Tempel
     * @param farbe
     */
    public Tempel(String farbe) {
        this.farbe = farbe;
        this.kartenspiel = new Kartenspiel();
    }

    public Quizfrage[] getFragenpoolOOP1() {
        return fragenpoolOOP1;
    }

    public Quizfrage[] getFragenpoolOOP2() {
        return fragenpoolOOP2;
    }

    public void setFragenpoolOOP1(Quizfrage[] fragenpoolOOP1) {
        this.fragenpoolOOP1 = fragenpoolOOP1;
    }

    public void setFragenpoolOOP2(Quizfrage[] fragenpoolOOP2) {
        this.fragenpoolOOP2 = fragenpoolOOP2;
    }

    
    // Rätsel -> Quizz
    public void betreten(Spieler spieler, int niveau) {
        // while keine richtige Antwort
            Random rand = new Random(); //instance of random class
            int random = rand.nextInt(5);
            if(niveau == 1) {
                // Select question from fragenpoolOOP1
            } else {
                // Select question from fragenpoolOOP2
            }



    }
    
    // Boss -> Uno Spiel
    public void monsterKaempfen() {
        // -> UNO
        // unoKartenspiel -> spielen



    }
    
	
}