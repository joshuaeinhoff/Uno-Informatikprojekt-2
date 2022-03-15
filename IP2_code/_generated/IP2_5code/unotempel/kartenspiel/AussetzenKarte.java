package unotempel.kartenspiel;

/**
 * Nachdem ein Spieler diese Karte gelegt hat, wird der Gegenspieler „&uuml;bersprungen“ und derjenige, der die Karte gelegt hat, darf nochmal legen.
 * Wenn diese Karte zu Beginn des Spiels gezogen wird, dann muss derjenige, der anf&auml;ngt, aussetzen und der Gegenspieler darf beginnen.
 <br>*/
public class AussetzenKarte extends Karte {

    /**
     * Konstruktor mit default-Wert: Nummer 10
     * @param farbe - Farbe der Karte: Blau, gelb, gr&uuml;n oder rot
     <br>*/
    public AussetzenKarte(String farbe){
        super(farbe, 10);
    }


    /**
     * Funktion gibt zur&uuml;ck, ob die Karte eine AussetzenKarte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     <br>*/
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Aussetzen");
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
    	return "AussetzenKarte "+ this.farbe;
    }
    
} // End von AussetzenKarte