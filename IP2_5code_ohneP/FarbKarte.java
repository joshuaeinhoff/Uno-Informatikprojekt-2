

/**
 *
 */
public class FarbKarte extends Karte{

    /**
     * Konstruktor erzeugt einer Farbkarte mit den folgenden Eigenschaften
     * @param farbe - Farbe: blau, gelb, grün oder rot
     * @param nummer - Nummer: Zahl von 0 bis 9
     */
    public FarbKarte(String farbe, int nummer){
        super(farbe, nummer);
    }


    /**
     * Funktion gibt zurück, ob die Karte eine FarbKarte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     */
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Farb");
    }


    /**
     * Funktion zum Durchführen der Aktion einer speziellen Karte
     * @return int - Code für die Aktion
     */
    @Override
    public int aktionDurchfuehren() {
        // Code 0: Nichts machen
        return 0;
    }

} // Ende von FarbKarte