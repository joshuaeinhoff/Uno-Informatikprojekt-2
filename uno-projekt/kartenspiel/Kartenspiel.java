package kartenspiel;

/**
 * 
 */
public class Kartenspiel {

    // Eigenschaften: Kartenstapel
    private KartenStapel kartenStapel;
    private String[] spielstand; // Spielstand?
    private Spielfeld spielfeld;
    // oder Map<K,V> -> Spieler, Punkte
    private int ersterSpieler; // z.B. 0 ist KI, 1 ist Spieler || verstehe ich nicht.. ^_^ Warum als int?


    //Karte die zuletzt gespielt wurde
    private Karte aktuelleKarte;
    
    // Konstruktor
    public Kartenspiel(int spielfeldGroesseY, int spielfeldGroesseX) {
        this.kartenStapel = new KartenStapel();
        this.spielfeld = new Spielfeld(spielfeldGroesseY,spielfeldGroesseX);
        
    }

    // wenn die karteSpielen methode null zurück gibt ende der Spielzug des Spielers
    
    
    /*
    private void karteSpielen(Spieler _spieler){
        aktuelleKarte = _spieler.karteSpielen();
    }
	*/
}//end of Kartenspiel