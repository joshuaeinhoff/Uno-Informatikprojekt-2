package unotempel.kartenspiel;

/**
 * Bei dieser Karte ändert sich die Spielrichtung. Wenn diese Karte zu Beginn des Spiels gezogen wird, muss der Spieler, der
 * anfangen darf, aussetzten und sein Gegenspieler darf anfangen.
 */
public class RetourKarte extends Karte{

    /**
     * Konstruktor mit default-Wert: Nummer 11
     * @param farbe - Farbe der Karte: Blau, gelb, grün oder rot
     */
    public RetourKarte(String farbe){
        super(farbe, 11);
    }


    /**
     * Funktion gibt zurück, ob die Karte eine RetourKarte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     */
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Retour");
    }

    
    /**
     * Funktion zum Durchführen der Aktion einer speziellen Karte
     * @return int - Code für die Aktion
     */
    @Override
    public int aktionDurchfuehren() {
        // Code 1: Nächster Spieler überspringen
        return 1;
    }
    
    
} // Ende von RetourKarte
