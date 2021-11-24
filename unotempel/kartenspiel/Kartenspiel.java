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
    private int naechsterSpieler; // 0 ist KI, 1 ist Held


    //Karte die zuletzt gespielt wurde
    private Karte aktuelleKarte;
    
    // Konstruktor
    public Kartenspiel(int spielfeldGroesseY, int spielfeldGroesseX) {
        this.kartenStapel = new KartenStapel();
        this.spielfeld = new Spielfeld(spielfeldGroesseY,spielfeldGroesseX);
        
    }

    /**
     * Prozedur zum zufällig Auswählen des ersten Spielers
     */
    public void setzeErsterSpieler() {
        naechsterSpieler = (int) Math.round(Math.random());
    }


    // wenn die karteSpielen methode null zurück gibt ende der Spielzug des Spielers
    
    public void spielen(){
        //...
    }
    
    /*
    private void karteSpielen(Spieler _spieler){
        aktuelleKarte = _spieler.karteSpielen();
    }
	*/
}//end of Kartenspiel