package unotempel.kartenspiel;

import unotempel.grafikkonsole.*;
import unotempel.GUI;

/**
 * Nachdem ein Spieler diese Karte gelegt hat, wird der Gegenspieler „übersprungen“ und derjenige, der die Karte gelegt hat, darf nochmal legen.
 * Wenn diese Karte zu Beginn des Spiels gezogen wird, dann muss derjenige, der anfängt, aussetzen und der Gegenspieler darf beginnen.
 */
public class AussetzenKarte extends Karte {

    // Variablen für die Darstellung einer AussetzenKarte
    Rechteck karteform;
    Kreis kreis;
    Linie linie;


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
    * Prozedur erzeugt die visuelle Darstellung einer Karte und verteckt sie direkt danach
    * @param farbe - Farbe der Karte
    */  
	public void erzeugeVisuelleKarte(String farbe) {
    	// Fallunterscheidung
    	switch(farbe) {
    		case "gruen":
        		farbe = GUI.farbeGruen;
        		break;
    		case "blau":
        		farbe = GUI.farbeBlau;
        		break;
            case "gelb":
                farbe = GUI.farbeGelb;
                break;
            case "rot":
                farbe = GUI.farbeRot;
                break;
		}
    	// Variablen Werte zuweisen
    	this.karteform = new Rechteck(0, 0, 50, 100, farbe, GUI.farbeWeiss, 2, 10, "");
        this.kreis = new Kreis(10, 35, 30, 30, farbe, GUI.farbeWeiss, 3, "");
        this.linie = new Linie(5, 35, 45, 65, GUI.farbeWeiss, 3, "");
        // Karte verstecken
        versteckeKarte();
    }
    

    /**
     * Prozedur setzt die Karte auf die gegebene Position und macht diese sichtbar
     * @param j - Koordinate auf der X-Achse im Spielfeld (2x2-KarteArray)
     * @param i - Koordinate auf der Y-Achse im Spielfeld (2x2-KarteArray)
     * @param x - Koordinate auf der X-Achse für die Darstellung
     * @param y - Koordinate auf der Y-Achse für die Darstellung
     * @param istAktuelleKarte - true, wenn die Karte die aktuelle Karte im Spiel entspricht - false, sonst
     */
    public void setzeKarteAuf(int j, int i, int x, int y, boolean istAktuelleKarte) {
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
            this.karteform.setCallback(j+"");
            this.kreis.setCallback(j+"");
            this.linie.setCallback(j+"");
        } else {
        	// Reaktion aussetzen
            this.karteform.setCallback("");
            this.kreis.setCallback("");
            this.linie.setCallback("");
        }  	
    }


    /**
     * Prozedur versteckt eine Karte
     */
    public void versteckeKarte() {
        // Variablen verstecken
        this.karteform.hide();
        this.kreis.hide();
        this.linie.hide();
    }


    /**
     * Funktion zum Durchführen der Aktion einer speziellen Karte, gibt den Code für die Aktion zurück
     * @return int - Code für die Aktion
     */
    @Override
    public int aktionDurchfuehren() {
        // Code 1: Nächster Spieler überspringen
        return 1;
    }
    
    
    /**
     * Funktion gibt die Karte als String zurück
     * @return String - Karte und Farbe
     */
    public String toString(){
    	return "AussetzenKarte "+ this.farbe;
    }
    
} // End von AussetzenKarte