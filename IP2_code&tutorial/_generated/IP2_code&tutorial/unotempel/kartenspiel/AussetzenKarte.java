package unotempel.kartenspiel;

import unotempel.grafikkonsole.*;
import unotempel.GUI;

/**<br>
 * Nachdem ein Spieler diese Karte gelegt hat, wird der Gegenspieler „&uuml;bersprungen“ und derjenige, der die Karte gelegt hat, darf nochmal legen.<br>
 * Wenn diese Karte zu Beginn des Spiels gezogen wird, dann muss derjenige, der anf&auml;ngt, aussetzen und der Gegenspieler darf beginnen.<br>
 <br>*/
public class AussetzenKarte extends Karte {

    // Variablen für die Darstellung einer AussetzenKarte
    Rechteck karteform;
    Kreis kreis;
    Linie linie;


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
    @Override
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Aussetzen");
    }


	/**<br>
    * Prozedur erzeugt die visuelle Darstellung einer Karte und verteckt sie direkt danach<br>
    * @param farbe - Farbe der Karte<br>
    <br>*/
    @Override  
	public void erzeugeVisuelleKarte(String farbe) {
    	// Fallunterscheidung
    	switch(farbe) {
    		case "gruen":
        		farbe = GUI.FARBE_GRUEN;
        		break;
    		case "blau":
        		farbe = GUI.FARBE_BLAU;
        		break;
            case "gelb":
                farbe = GUI.FARBE_GELB;
                break;
            case "rot":
                farbe = GUI.FARBE_ROT;
                break;
		}
    	// Variablen Werte zuweisen
    	this.karteform = new Rechteck(0, 0, 50, 100, farbe, GUI.FARBE_WEISS, 2, 10, "");
        this.kreis = new Kreis(10, 35, 30, 30, farbe, GUI.FARBE_WEISS, 3, "");
        this.linie = new Linie(5, 35, 45, 65, GUI.FARBE_WEISS, 3, "");
        // Karte verstecken
        versteckeKarte();
    }
    

    /**<br>
     * Prozedur setzt die Karte auf die gegebene Position und macht diese sichtbar<br>
     * @param spalte - Koordinate auf der X-Achse im Spielfeld (2x2-KarteArray)<br>
     * @param zeile - Koordinate auf der Y-Achse im Spielfeld (2x2-KarteArray)<br>
     * @param x - Koordinate auf der X-Achse f&uuml;r die Darstellung<br>
     * @param y - Koordinate auf der Y-Achse f&uuml;r die Darstellung<br>
     * @param istAktuelleKarte - true, wenn die Karte die aktuelle Karte im Spiel entspricht - false, sonst<br>
     <br>*/
    @Override
    public void setzeKarteAuf(int spalte, int zeile, int x, int y, boolean istAktuelleKarte) {
        /* // Warte 2 Sekunden darauf
        this.karteform.waitFor(200);
        this.kreis.waitFor(200);
        this.linie.waitFor(200); */
        // Variablen verschieben
        this.karteform.moveTo(x,y);
        this.kreis.moveTo(x+10,y+35); 
        this.linie.moveTo(x+5,y+35);
        // Variablen anzeigen
        this.karteform.show();
        this.kreis.show();
        this.linie.show();
        // Prüfen, ob die Karte nicht die aktuelle Karte ist
        if(!istAktuelleKarte) {
        	// Reaktion einsetzen
            this.karteform.setCallback(spalte+"");
            this.kreis.setCallback(spalte+"");
            this.linie.setCallback(spalte+"");
        } else {
        	// Reaktion aussetzen
            this.karteform.setCallback("");
            this.kreis.setCallback("");
            this.linie.setCallback("");
        }  	
    }


    /**<br>
     * Prozedur versteckt eine Karte<br>
     <br>*/
    @Override
    public void versteckeKarte() {
        // Variablen verstecken
        this.karteform.hide();
        this.kreis.hide();
        this.linie.hide();
    }


    /**<br>
     * Funktion zum Durchf&uuml;hren der Aktion einer speziellen Karte, gibt den Code für die Aktion zurück<br>
     * @return int - Code f&uuml;r die Aktion<br>
     <br>*/
    @Override
    public int aktionDurchfuehren() {
        // Code 1: Nächster Spieler überspringen
        return 1;
    }
    
    
    /**<br>
     * Funktion gibt die Karte als String zur&uuml;ck<br>
     * @return String - Karte und Farbe<br>
     <br>*/
    @Override
    public String toString(){
    	return "AussetzenKarte "+ this.farbe;
    }
    
} // End von AussetzenKarte