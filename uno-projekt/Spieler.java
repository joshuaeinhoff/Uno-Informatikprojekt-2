import java.util.*;
/**
 * Abstrakte Superklasse für den menschlichen Spieler und die SpielerKIs(Schwierigkeiten)
 */

 abstract class Spieler {

    //Jeder Spieler hat eine gewisse Anzahl an Karten auf der Hand, die hier in einem Array gespeichert werden.
    //Liste ist vielleicht doch ein wenig besser, da der Spieler immer unterschiedlich viele Karten auf der Hand
    //hat - muss dann immer ein neues Array gemacht werden? z. B. 10 Karten auf der Hand

	private ArrayList<Karte> hand; //OOP2

    //private Karte[] hand; //OOP1?

    //Jeder Spieler hat Lebensenergie die durch Kämpfe reduziert werden kann
    private int lebensenergie;
    
    /**
     * Konstruktor
     * setzt die Arraygröße "hand" am Anfang auf 7
     * @param _lebensenergie - int wird am Anfang z. B. für den menschlichen Spieler auf 100 gesetz
     */
    public Spieler(int _lebensenergie){
        hand = new ArrayList<>(); //OOP2
        lebensenergie = _lebensenergie;
        //hand = new Karte[20]; //OOP1?
    }

    /**
     * zieht sieben Karten aus dem Kartenstapel
     * @param kartenStapel
     */
    public void ersteHand(KartenStapel kartenStapel){
        for(int i = 0; i < 7; i++){
            karteZiehen(kartenStapel);
        }
    }

    /**
     * Methode zum ziehen der Karten
     */
    public void karteZiehen(KartenStapel kartenStapel){
        //fügt die aus dem Stapel gezogene Karte der Hand hinzu
        hand.add(kartenStapel.karteZiehen());
    }


    
    public Karte karteSpielen(Karte geclickteKarte){
        Karte temp = geclickteKarte;
        hand.remove(geclickteKarte);
        return temp;
    }
    
    /**
     * get methoden sind eigentlich eher doof aber muss erstmal so 
     * @param index
     * @return
     */
    public Karte getKarte(int index){
        return hand.get(index);
    }
}