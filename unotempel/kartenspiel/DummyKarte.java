package unotempel.kartenspiel;

/**
 * Soll später als Dummy genutzt werden um die Anzahl der gegnerischen Karten zu zeigen
 */
public class DummyKarte extends Karte{

    /**
     * Konstruktor erzeugt eine DummyKarte mit default-Werten: Farbe keine und Nummer -1
     */
    public DummyKarte(){
        super("keine", -1);
    }
    

    /**
     *
     * @param kartenart
     * @return
     */
    public boolean istWelcheKarte(String kartenart){
        if(kartenart.equals("Dummy")){
            return true;
        }
        return false;
    }


    /**
     * Diese Prozedur soll nichts machen, da DummyKarten keine spezielle Aktion durchführen
     */
    @Override
    public void aktionDurchfuehren() {
        // Nichts machen
    }


}//end of DummyKarte
