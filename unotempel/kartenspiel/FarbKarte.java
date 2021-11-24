package kartenspiel;

/*
*
*/
public class FarbKarte extends Karte{

    /**
     * Konstruktor erzeugt einer Farbkarte mit den folgenden Eigenschaften
     * @param farbe - Farbe: blau, gelb, grün, rot
     * @param nummer - Nummer von 0 bis 9
     */
    public FarbKarte(String farbe, int nummer){
        super(farbe, nummer);
    }

    /**
     *
     * @param kartenart
     * @return
     */
    public boolean istWelcheKarte(String kartenart){
        if(kartenart.equals("Farb")){
            return true;
        }
        return false;
    }

    /**
     * Diese Prozedur soll nichts machen, da Farbkarten keine spezielle Aktion durchführen
     */
    @Override
    public void aktionDurchfuehren() {
        // Nichts machen
    }

}//end of FarbKarte