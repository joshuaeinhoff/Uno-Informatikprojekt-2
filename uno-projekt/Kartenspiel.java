/**
 * 
 */
class Kartenspiel {

    // Eigenschaften: Kartenstapel
    private KartenStapel kartenStapel;
    private String[] spielstand; // Spielstand?
    // oder Map<K,V> -> Spieler, Punkte
    private int ersterSpieler; // z.B. 0 ist KI, 1 ist Spieler || verstehe ich nicht.. ^_^ Warum als int?

    //Karte die zuletzt gespielt wurde
    private Karte aktuelleKarte;
    
    // Konstruktor
    public Kartenspiel() {
        this.kartenStapel = new KartenStapel();
        
    }

    /*
    private void karteSpielen(Spieler _spieler){
        aktuelleKarte = _spieler.karteSpielen();
    }
	*/
}