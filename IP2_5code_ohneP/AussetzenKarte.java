

/**
 * Nachdem ein Spieler diese Karte gelegt hat, wird der Gegenspieler „übersprungen“ und derjenige, der die Karte gelegt hat, darf nochmal legen.
 * Wenn diese Karte zu Beginn des Spiels gezogen wird, dann muss derjenige, der anfängt, aussetzen und der Gegenspieler darf beginnen.
 */
public class AussetzenKarte extends Karte {

    /**
     * Konstruktor mit default-Wert: Nummer 10
     * @param farbe - Farbe der Karte: Blau, gelb, grün oder rot
     */
    public AussetzenKarte(String farbe){
        super(farbe, 10);
    }


    /**
     * Funktion gibt zurück, ob die Karte eine AussetzenKarte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     */
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Aussetzen");
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
    
} // End von AussetzenKarte