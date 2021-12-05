

/**<br>
 * Soll sp&auml;ter als Dummy genutzt werden um die Anzahl der gegnerischen Karten zu zeigen<br>
 <br>*/
public class DummyKarte extends Karte{

    /**<br>
     * Konstruktor erzeugt eine DummyKarte mit default-Werten: Farbe keine und Nummer -1<br>
     <br>*/
    public DummyKarte(){
        super("keine", -1);
    }


    /**<br>
     * Funktion gibt zur&uuml;ck, ob die Karte eine DummyKarte ist<br>
     * @param kartenart - Art der Karte<br>
     * @return true - falls die KartenArt passt, false - sonst<br>
     <br>*/
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Dummy");
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


} // Ende von DummyKarte