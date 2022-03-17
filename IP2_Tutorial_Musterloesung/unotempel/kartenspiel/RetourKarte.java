package unotempel.kartenspiel;

import unotempel.grafikkonsole.*;
import unotempel.GUI;

/** 2.2 RetourKarte Δe_kkaknu Δ
 * Bei dieser Karte ändert sich die Spielrichtung. Wenn diese Karte zu Beginn des Spiels gezogen wird, muss der Spieler, der
 * anfangen darf, aussetzten und sein Gegenspieler darf anfangen.
 */
public class RetourKarte extends Karte{

    /** 2.2.1 Daten als Instanz-Variablen definieren  Δe_ed5nj9 Δ */
    Rechteck karteform;
    Kreis kreis;
    Linie linie;
    Linie liniePfeil1;
    Linie liniePfeil2;
    Linie liniePfeil3;
    Linie liniePfeil4;

	
	/** 2.2.1 Definition des Konstruktors Δe_23ik9q Δ 
     * Konstruktor erzeugt eine RetourKarte einer bestimmten Farbe mit default-Wert: Nummer 11
     * @param farbe - Farbe der Karte: Blau, gelb, grün oder rot
     */
    public RetourKarte(String farbe){
        super(farbe, 11);
    }


    /**
     * Funktion gibt zurück, ob die Karte eine RetourKarte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     */
    @Override
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Retour");
    }


	/**
    * Prozedur erzeugt die visuelle Darstellung einer Karte und verteckt sie direkt danach
    */
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
        this.linie = new Linie(5, 50, 45, 50, farbe, 10, "");
        // Pfeil 1
        this.liniePfeil1 = new Linie(5, 35, 11, 45, GUI.FARBE_WEISS, 3, "");
        this.liniePfeil2 = new Linie(10, 45, 22, 42, GUI.FARBE_WEISS, 3, "");
        // Pfeil 2
        this.liniePfeil3 = new Linie(40, 55, 28, 58, GUI.FARBE_WEISS, 3, "");
        this.liniePfeil4 = new Linie(45, 65, 39, 55, GUI.FARBE_WEISS, 3, "");
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
        // Variablen verschieben
        this.karteform.moveTo(x,y);
        this.kreis.moveTo(x+10,y+35);
        this.linie.moveTo(x+5,y+50);
        this.liniePfeil1.moveTo(x+5,y+35);
        this.liniePfeil2.moveTo(x+10,y+45);
        this.liniePfeil3.moveTo(x+40,y+55);
        this.liniePfeil4.moveTo(x+45,y+65);
        // Variablen anzeigen
        this.karteform.show();
        this.kreis.show();
        this.linie.show();
        this.liniePfeil1.show();
        this.liniePfeil2.show();
        this.liniePfeil3.show();
        this.liniePfeil4.show();
        // Prüfen, ob die Karte nicht die aktuelle Karte ist
        if(!istAktuelleKarte) {
            // Reaktion einsetzen
            this.karteform.setCallback(spalte+"");
            this.kreis.setCallback(spalte+"");
            this.linie.setCallback(spalte+"");
            this.liniePfeil1.setCallback(spalte+"");
            this.liniePfeil2.setCallback(spalte+"");
            this.liniePfeil3.setCallback(spalte+"");
            this.liniePfeil4.setCallback(spalte+"");
        } else {
        	// Reaktion aussetzen
            this.karteform.setCallback("");
            this.kreis.setCallback("");
            this.linie.setCallback("");
            this.liniePfeil1.setCallback("");
            this.liniePfeil2.setCallback("");
            this.liniePfeil3.setCallback("");
            this.liniePfeil4.setCallback("");
        }
    }


    /**
     * Prozedur versteckt eine Karte
     */
    @Override
    public void versteckeKarte() {
        this.karteform.hide();
        this.kreis.hide();
        this.linie.hide();
        this.liniePfeil1.hide();
        this.liniePfeil2.hide();
        this.liniePfeil3.hide();
        this.liniePfeil4.hide();
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
     * @return String - Karte, Farbe und Nummer
     */
    @Override
    public String toString(){
    	return "RetourKarte " + this.farbe;
    }
 
	
} // Ende von RetourKarte