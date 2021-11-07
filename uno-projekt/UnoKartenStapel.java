/**
 * 
 */
class UnoKartenStapel {

    // Eigenschaften: Uno-Karten und Anzahl der Karten
    private UnoKarte[] karten;
    private int anzahlUnoKarten;
    
    // Konstruktor -> Erzeugt einen Array mit 108 Karten 
    // bis jetzt nur einen Array der Platz für 108 Karten hat
    private UnoKartenStapel() {
        karten = new UnoKarte[108];
    }
	
    // factory method -> ??
    public static UnoKartenStapel kartenStapelErzeugen() {
        return new UnoKartenStapel();
    }
    
    
}