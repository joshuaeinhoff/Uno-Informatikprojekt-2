package unotempel.kartenspiel;

/**
 * Wenn diese Karte gelegt wird, muss der Gegenspieler 2 Karten ziehen und darf in dieser Runde keine Karten ablegen.
 * Diese Karte kann nur auf eine Karte mit entsprechender Farbe oder andere ZiehZweiKarten gelegt werden.
 * Wenn sie zu Beginn des Spiels aufgedeckt wird, gelten dieselben Regeln.
 */
public class PlusZweiKarte extends Karte{
    
    /**
     * Konstruktor mit default-Wert: Nummer 12
     * @param farbe - Farbe der Karte: blau, gelb, grün oder rot
     */
    public PlusZweiKarte(String farbe){
        super(farbe, 12);
    }


    /**
     * Funktion gibt zurück, ob die Karte eine PlusZweiKarte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     */
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("PlusZwei");
    }


    /**
     * Funktion zum Durchführen der Aktion einer speziellen Karte
     * @return int - Code für die Aktion
     */
    @Override
    public int aktionDurchfuehren() {
        // Code 2: Zwei Karte ziehen
        return 2;
    }

} // Ende von PlusZweiKarte