

/**<br>
 * Nachdem ein Spieler diese Karte gelegt hat, wird der Gegenspieler „&uuml;bersprungen“ und derjenige, der die Karte gelegt hat, darf nochmal legen.<br>
 * Wenn diese Karte zu Beginn des Spiels gezogen wird, dann muss derjenige, der anf&auml;ngt, aussetzen und der Gegenspieler darf beginnen.<br>
 <br>*/
public class AussetzenKarte extends Karte {

    /**<br>
     * Konstruktor mit default-Wert: Nummer 10<br>
     * @param farbe - Farbe der Karte: Blau, gelb, gr&uuml;n oder rot<br>
     <br>*/
    public AussetzenKarte(String farbe){
        super(farbe, 10);
    }


    /**<br>
     * Funktion gibt zur&uuml;ck, ob die Karte eine AussetzenKarte ist<br>
     * @param kartenart - Art der Karte<br>
     * @return true - falls die KartenArt passt, false - sonst<br>
     <br>*/
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Aussetzen");
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
    
} // End von AussetzenKarte