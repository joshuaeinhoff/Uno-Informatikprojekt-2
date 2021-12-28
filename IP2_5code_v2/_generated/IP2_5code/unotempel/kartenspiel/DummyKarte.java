package unotempel.kartenspiel;

/**
 * Soll sp&auml;ter als Dummy genutzt werden um die Anzahl der gegnerischen Karten zu zeigen
 <br>*/
public class DummyKarte extends Karte{

    /**
     * Konstruktor erzeugt eine DummyKarte mit default-Werten: Farbe keine und Nummer -1
     <br>*/
    public DummyKarte(){
        super("keine", -1);
    }


    /**
     * Funktion gibt zur&uuml;ck, ob die Karte eine DummyKarte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     <br>*/
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Dummy");
    }


    /**
     * Funktion zum Durchf&uuml;hren der Aktion einer speziellen Karte
     * @return int - Code f&uuml;r die Aktion
     <br>*/
    @Override
    public int aktionDurchfuehren() {
        // Code 0: Nichts machen
        return 0;
    }
    
    public String toString(){
     return "DummyKarte";
    }


} // Ende von DummyKarte