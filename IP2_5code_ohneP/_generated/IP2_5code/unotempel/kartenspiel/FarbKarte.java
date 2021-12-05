package unotempel.kartenspiel;

/**<br>
 *<br>
 <br>*/
public class FarbKarte extends Karte{

    /**<br>
     * Konstruktor erzeugt einer Farbkarte mit den folgenden Eigenschaften<br>
     * @param farbe - Farbe: blau, gelb, gr&uuml;n oder rot<br>
     * @param nummer - Nummer: Zahl von 0 bis 9<br>
     <br>*/
    public FarbKarte(String farbe, int nummer){
        super(farbe, nummer);
    }


    /**<br>
     * Funktion gibt zur&uuml;ck, ob die Karte eine FarbKarte ist<br>
     * @param kartenart - Art der Karte<br>
     * @return true - falls die KartenArt passt, false - sonst<br>
     <br>*/
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Farb");
    }


    /**<br>
     * Funktion zum Durchf&uuml;hren der Aktion einer speziellen Karte<br>
     * @return int - Code f&uuml;r die Aktion<br>
     <br>*/
    @Override
    public int aktionDurchfuehren() {
        // Code 0: Nichts machen
        return 0;
    }

} // Ende von FarbKarte