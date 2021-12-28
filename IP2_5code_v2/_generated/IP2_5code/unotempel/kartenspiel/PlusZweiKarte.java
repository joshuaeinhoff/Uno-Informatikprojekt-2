package unotempel.kartenspiel;

/**
 * Wenn diese Karte gelegt wird, muss der Gegenspieler 2 Karten ziehen und darf in dieser Runde keine Karten ablegen.
 * Diese Karte kann nur auf eine Karte mit entsprechender Farbe oder andere ZiehZweiKarten gelegt werden.
 * Wenn sie zu Beginn des Spiels aufgedeckt wird, gelten dieselben Regeln.
 <br>*/
public class PlusZweiKarte extends Karte{
    
    /**
     * Konstruktor mit default-Wert: Nummer 12
     * @param farbe - Farbe der Karte: blau, gelb, gr&uuml;n oder rot
     <br>*/
    public PlusZweiKarte(String farbe){
        super(farbe, 12);
    }


    /**
     * Funktion gibt zur&uuml;ck, ob die Karte eine PlusZweiKarte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     <br>*/
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("PlusZwei");
    }


    /**
     * Funktion zum Durchf&uuml;hren der Aktion einer speziellen Karte
     * @return int - Code f&uuml;r die Aktion
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