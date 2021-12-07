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
     * Funktion gibt zurück, ob die Karte eine DummyKarte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     */
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Dummy");
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
    
    public String toString(){
     return "DummyKarte";
    }


} // Ende von DummyKarte