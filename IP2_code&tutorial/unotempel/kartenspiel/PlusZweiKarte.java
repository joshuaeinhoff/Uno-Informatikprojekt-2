package unotempel.kartenspiel;

import unotempel.grafikkonsole.*;
import unotempel.GUI;

/**
 * Wenn diese Karte gelegt wird, muss der Gegenspieler 2 Karten ziehen und darf in dieser Runde keine Karten ablegen.
 * Diese Karte kann nur auf eine Karte mit entsprechender Farbe oder andere ZiehZweiKarten gelegt werden.
 * Wenn sie zu Beginn des Spiels aufgedeckt wird, gelten dieselben Regeln.
 */
public class PlusZweiKarte extends Karte{
   
    // Variablen für die Darstellung einer PlusZweiKarte
    Rechteck karteform;
    Text zahlOben;
    Text zahlUnten;

	/**
     * Konstruktor erzeugt eine PlusZweiKarte einer bestimmten Farbe mit default-Wert: Nummer 12
     * @param farbe - Farbe der Karte: blau, gelb, grün oder rot
     */
    public PlusZweiKarte(String farbe){
        super(farbe, 12);
    }


    /**
     * Funktion gibt zurück, ob die Karte eine PlusZweiKarte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     */
    @Override
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("PlusZwei");
    }
    
    
    /**
    * Prozedur erzeugt die visuelle Darstellung einer Karte und verteckt sie direkt danach
    */
    @Override
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
        this.zahlOben = new Text(2, -5, "+2", GUI.farbeWeiss, 25, "");
        this.zahlUnten = new Text(15, 55, "+2", GUI.farbeWeiss, 25, "");
        // Karte verstecken
        versteckeKarte();
    }


    /**
     * Prozedur setzt die Karte auf die gegebene Position und macht diese sichtbar
     * @param spalte - Koordinate auf der X-Achse im Spielfeld (2x2-KarteArray)
     * @param zeile - Koordinate auf der Y-Achse im Spielfeld (2x2-KarteArray)
     * @param x - Koordinate auf der X-Achse für die Darstellung
     * @param y - Koordinate auf der Y-Achse für die Darstellung
     * @param istAktuelleKarte - true, wenn die Karte die aktuelle Karte im Spiel entspricht - false, sonst
     */
    @Override
    public void setzeKarteAuf(int spalte, int zeile, int x, int y, boolean istAktuelleKarte) {
        /* // Warte 2 Sekunden darauf
        this.karteform.waitFor(200);
        this.zahlOben.waitFor(200);
        this.zahlUnten.waitFor(200); */
        // Variablen verschieben
        this.karteform.moveTo(x,y);
        this.zahlOben.moveTo(x+5,y-5);
        this.zahlUnten.moveTo(x+15,y+55);
        // Variablen anzeigen
        this.karteform.show();
        this.zahlOben.show();
        this.zahlUnten.show();
        // Prüfen, ob die Karte nicht die aktuelle Karte ist
        if(!istAktuelleKarte) {
            // Reaktion einsetzen
            this.karteform.setCallback(spalte+"");
            this.zahlOben.setCallback(spalte+"");
            this.zahlUnten.setCallback(spalte+"");
         } else {
         	// Reaktion aussetzen
            this.karteform.setCallback("");
            this.zahlOben.setCallback("");
            this.zahlUnten.setCallback("");
         }
    }


    /**
     * Prozedur versteckt eine Karte
     */
    @Override
    public void versteckeKarte() {
        this.karteform.hide();
        this.zahlOben.hide();
        this.zahlUnten.hide();
    }


    /**
     * Funktion zum Durchführen der Aktion einer speziellen Karte, gibt den Code für die Aktion zurück
     * @return int - Code für die Aktion
     */
    @Override
    public int aktionDurchfuehren() {
        // Code 2: Zwei Karte ziehen
        return 2;
    }
    

    /**
     * Funktion gibt die Karte als String zurück
     * @return String - Karte, Farbe und Nummer
     */
    @Override
    public String toString(){
    	return "PlusZweiKarte " + this.farbe;
    }
	
} // Ende von PlusZweiKarte