package unotempel.kartenspiel;

/**<br>
 * Der Spieler, der diese Karte legt, entscheidet welche Farbe als n&auml;chstes gelegt werden soll. WunschKarten kann man immer legen, <br>
 * das hei&szlig;t man muss nicht auf die Farbe der vorherigen Karte achten. Wenn eine WunschKarte zu Beginn des Spiels gezogen wird,<br>
 * entscheidet der Spieler, der anfangen darf, welche Farbe als n&auml;chstes gelegt werden soll.<br>
 <br>*/
public class WunschKarte extends Karte{

    /**<br>
     * Konstruktor mit default-Werten: Farbe schwarz und Nummer 13<br>
     <br>*/
    public WunschKarte(){
        super("schwarz", 13);
    }


    /**<br>
     * Konstruktor zum Erzeugen einer Wunschkarte mit einer bestimmten Farbe<br>
     * @param neueFarbe - Neue Farbe (nur nachdem eine WunschKarte gespielt wird)<br>
     <br>*/
    public WunschKarte(String neueFarbe) {
        super(neueFarbe, 13);
    }


    /**<br>
     * Funktion gibt zur&uuml;ck, ob die Karte eine WunschKarte ist<br>
     * @param kartenart - Art der Karte<br>
     * @return true - falls die KartenArt passt, false - sonst<br>
     <br>*/
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Wunsch");
    }


    /**<br>
     * Funktion zum Durchf&uuml;hren der Aktion einer speziellen Karte<br>
     * @return int - Code f&uuml;r die Aktion<br>
     <br>*/
    @Override
    public int aktionDurchfuehren() {
        // Code 3: Eine neue Farbe auswählen
        return 3;
    }
    
    public String toString(){
    	return "WunschKarte";
    }

} // Ende von WunschKarte