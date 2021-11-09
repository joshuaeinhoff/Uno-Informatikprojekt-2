/**
 * 
 */
class UnoKartenspiel {

    // Eigenschaften: Kartenstapel
    private UnoKartenStapel kartenStapel;
    private String[] spielstand; // Spielstand?
    // oder Map<K,V> -> Spieler, Punkte
    private int ersterSpieler; // z.B. 0 ist KI, 1 ist Spieler || verstehe ich nicht.. ^_^ Warum als int?

    //Karte die zuletzt gespielt wurde
    private UnoKarte aktuelleKarte;
    
    // Konstruktor
    public UnoKartenspiel() {
        this.kartenStapel = UnoKartenStapel.kartenStapelErzeugen();
    }

    private void karteSpielen(Spieler _spieler){
        aktuelleKarte = _spieler.karteSpielen();
    }
	
}