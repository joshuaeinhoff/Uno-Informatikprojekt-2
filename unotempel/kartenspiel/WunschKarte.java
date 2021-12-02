package unotempel.kartenspiel;

/**
 * Der Spieler, der diese Karte legt, entscheidet welche Farbe als nächstes gelegt werden soll. WunschKarten kann man immer legen, 
 * das heißt man muss nicht auf die Farbe der vorherigen Karte achten. Wenn eine WunschKarte zu Beginn des Spiels gezogen wird,
 * entscheidet der Spieler, der anfangen darf, welche Farbe als nächstes gelegt werden soll.
 */
public class WunschKarte extends Karte{

    /**
     * Konstruktor mit default-Werten: Farbe schwarz und Nummer 13
     */
    public WunschKarte(){
        super("schwarz", 13);
    }


    /**
     * Konstruktor zum Erzeugen einer Wunschkarte mit einer bestimmten Farbe
     * @param neueFarbe - Neue Farbe (nur nachdem eine WunschKarte gespielt wird)
     */
    public WunschKarte(String neueFarbe) {
        super(neueFarbe, 13);
    }


    /**
     * Funktion gibt zurück, ob die Karte eine WunschKarte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     */
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Wunsch");
    }


    /**
     * Funktion zum Durchführen der Aktion einer speziellen Karte
     * @return int - Code für die Aktion
     */
    @Override
    public int aktionDurchfuehren() {
        // Code 3: Eine neue Farbe auswählen
        return 3;
    }

} // Ende von WunschKarte