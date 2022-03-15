package unotempel.kartenspiel;

/**
 * Bei dieser Karte &auml;ndert sich die Spielrichtung. Wenn diese Karte zu Beginn des Spiels gezogen wird, muss der Spieler, der
 * anfangen darf, aussetzten und sein Gegenspieler darf anfangen.
 <br>*/
public class RetourKarte extends Karte{

    /**
     * Konstruktor mit default-Wert: Nummer 11
     * @param farbe - Farbe der Karte: Blau, gelb, gr&uuml;n oder rot
     <br>*/
    public RetourKarte(String farbe){
        super(farbe, 11);
    }


    /**
     * Funktion gibt zur&uuml;ck, ob die Karte eine RetourKarte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     <br>*/
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Retour");
    }

    
    /**
     * Funktion zum Durchf&uuml;hren der Aktion einer speziellen Karte
     * @return int - Code f&uuml;r die Aktion
     <br>*/
    @Override
    public int aktionDurchfuehren() {
        // Code 1: Nächster Spieler überspringen
        return 1;
    }
    
    public String toString(){
    	return "RetourKarte " + this.farbe;
    }
    
} // Ende von RetourKarte