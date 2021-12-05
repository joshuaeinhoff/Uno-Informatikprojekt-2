

/**<br>
 * Bei dieser Karte &auml;ndert sich die Spielrichtung. Wenn diese Karte zu Beginn des Spiels gezogen wird, muss der Spieler, der<br>
 * anfangen darf, aussetzten und sein Gegenspieler darf anfangen.<br>
 <br>*/
public class RetourKarte extends Karte{

    /**<br>
     * Konstruktor mit default-Wert: Nummer 11<br>
     * @param farbe - Farbe der Karte: Blau, gelb, gr&uuml;n oder rot<br>
     <br>*/
    public RetourKarte(String farbe){
        super(farbe, 11);
    }


    /**<br>
     * Funktion gibt zur&uuml;ck, ob die Karte eine RetourKarte ist<br>
     * @param kartenart - Art der Karte<br>
     * @return true - falls die KartenArt passt, false - sonst<br>
     <br>*/
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Retour");
    }

    
    /**<br>
     * Funktion zum Durchf&uuml;hren der Aktion einer speziellen Karte<br>
     * @return int - Code f&uuml;r die Aktion<br>
     <br>*/
    @Override
    public int aktionDurchfuehren() {
        // Code 1: Nächster Spieler überspringen
        return 1;
    }
    
} // Ende von RetourKarte