/**
 * 
 */
class UnoKartenspiel {

    // Eigenschaften: Kartenstapel
    private UnoKartenStapel kartenStapel;
    private String[] spielstand;
    // oder Map<K,V> -> Spieler, Punkte
    private int ersterSpieler; // z.B. 0 ist KI, 1 ist Spieler || verstehe ich nicht.. ^_^ Warum als int?
    
    // Konstruktor
    public UnoKartenspiel() {
        this.kartenStapel = UnoKartenStapel.kartenStapelErzeugen();
    }
	
}