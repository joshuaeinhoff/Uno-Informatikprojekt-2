import java.util.*;
/**
 *
 */
public class Tempel2 {

    // Eigenschaften
    private String farbe;
    private Map<Integer,Quizfrage> fragenpoolOOP1;
    private Map<Integer,Quizfrage> fragenpoolOOP2;
    private Kartenspiel kartenspiel;

    /**
     * Konstruktor zum Erzeugen einer Instanz der Klasse Tempel
     * @param farbe
     */
    public Tempel2(String farbe) {
        this.farbe = farbe;
        this.fragenpoolOOP1 = new TreeMap<>();
        this.fragenpoolOOP2 = new TreeMap<>();
        this.kartenspiel = new Kartenspiel();
    }

    public Map<Integer,Quizfrage> getFragenpoolOOP1() {
        return fragenpoolOOP1;
    }

    public Map<Integer,Quizfrage> getFragenpoolOOP2() {
        return fragenpoolOOP2;
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
