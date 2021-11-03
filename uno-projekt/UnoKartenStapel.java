/**
 * 
 */
class UnoKartenStapel {

    // Eigenschaften: Uno-Karten und Anzahl der Karten
    private UnoKarte[] karten;
    private int anzahlUnoKarten;
    
    // Konstruktor -> Erzeugt einen Array mit 108 Karten
    private UnoKartenStapel() {
        karten = new UnoKarte[108];
    }
	
    // factory method -> ??
    public static UnoKartenStapel kartenStapelErzeugen() {
        return new UnoKartenStapel();
    }
    
    
}