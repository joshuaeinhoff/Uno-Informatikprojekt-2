package unotempel.kartenspiel;

import unotempel.grafikkonsole.*;
import unotempel.GUI;

/** 2.3 PlusZweiKarte  <br>
 * Wenn diese Karte gelegt wird, muss der Gegenspieler 2 Karten ziehen und darf in dieser Runde keine Karten ablegen.<br>
 * Diese Karte kann nur auf eine Karte mit entsprechender Farbe oder andere ZiehZweiKarten gelegt werden.<br>
 * Wenn sie zu Beginn des Spiels aufgedeckt wird, gelten dieselben Regeln.<br>
 <br>*/
public class PlusZweiKarte extends Karte{
   
    /** 2.3.1 Daten als Instanz-Variablen definieren   <br>*/
    Rechteck karteform;
    Text zahlOben;
    Text zahlUnten;
    

	/** 2.3.2 Konstruktor erstellen  <br>
     * Konstruktor erzeugt eine PlusZweiKarte einer bestimmten Farbe mit default-Wert: Nummer 12<br>
     * @param farbe - Farbe der Karte: blau, gelb, gr&uuml;n oder rot<br>
     <br>*/
    public PlusZweiKarte(String farbe){
        super(farbe, 12);
    }


    /**<br>
     * Funktion gibt zur&uuml;ck, ob die Karte eine PlusZweiKarte ist<br>
     * @param kartenart - Art der Karte<br>
     * @return true - falls die KartenArt passt, false - sonst<br>
     <br>*/
    @Override
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("PlusZwei");
    }
    
    
    /**<br>
    * Prozedur erzeugt die visuelle Darstellung einer Karte und verteckt sie direkt danach<br>
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
        this.zahlOben = new Text(2, -5, "+2", GUI.FARBE_WEISS, 25, "");
        this.zahlUnten = new Text(15, 55, "+2", GUI.FARBE_WEISS, 25, "");
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


    /**<br>
     * Prozedur versteckt eine Karte<br>
     <br>*/
    @Override
    public void versteckeKarte() {
        this.karteform.hide();
        this.zahlOben.hide();
        this.zahlUnten.hide();
    }


    /**<br>
     * Funktion zum Durchf&uuml;hren der Aktion einer speziellen Karte, gibt den Code für die Aktion zurück<br>
     * @return int - Code f&uuml;r die Aktion<br>
     <br>*/
    @Override
    public int aktionDurchfuehren() {
        // Code 2: Zwei Karte ziehen
        return 2;
    }
    

    /**<br>
     * Funktion gibt die Karte als String zur&uuml;ck<br>
     * @return String - Karte, Farbe und Nummer<br>
     <br>*/
    @Override
    public String toString(){
    	return "PlusZweiKarte " + this.farbe;
    }

	
} // Ende von PlusZweiKarte