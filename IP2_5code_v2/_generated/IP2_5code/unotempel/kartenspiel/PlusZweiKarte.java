package unotempel.kartenspiel;

/**<br>
 * Wenn diese Karte gelegt wird, muss der Gegenspieler 2 Karten ziehen und darf in dieser Runde keine Karten ablegen.<br>
 * Diese Karte kann nur auf eine Karte mit entsprechender Farbe oder andere ZiehZweiKarten gelegt werden.<br>
 * Wenn sie zu Beginn des Spiels aufgedeckt wird, gelten dieselben Regeln.<br>
 <br>*/
public class PlusZweiKarte extends Karte{
    
    /**<br>
     * Konstruktor mit default-Wert: Nummer 12<br>
     * @param farbe - Farbe der Karte: blau, gelb, gr&uuml;n oder rot<br>
     <br>*/
    public PlusZweiKarte(String farbe){
        super(farbe, 12);
    }


    /**<br>
     * Funktion gibt zur&uuml;ck, ob die Karte eine PlusZweiKarte ist<br>
     * @param kartenart - Art der Karte<br>
     * @return true - falls die KartenArt passt, false - sonst<br>
     <br>*/
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("PlusZwei");
    }


    /**<br>
     * Funktion zum Durchf&uuml;hren der Aktion einer speziellen Karte<br>
     * @return int - Code f&uuml;r die Aktion<br>
     <br>*/
    @Override
    public int aktionDurchfuehren() {
        // Code 2: Zwei Karte ziehen
        return 2;
    }
    
    public String toString(){
    	return "PlusZweiKarte " + this.farbe;
    }

} // Ende von PlusZweiKarte