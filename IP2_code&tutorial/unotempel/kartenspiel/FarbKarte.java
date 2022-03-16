package unotempel.kartenspiel;

import unotempel.grafikkonsole.*;
import unotempel.GUI;

/**
 * FarbKarte stellt eine Karte mit einer bestimmten Farbe und einer bestimmten Nummer dar
 */
public class FarbKarte extends Karte{
  
    // Variablen für die Darstellung einer FarbKarte
    Rechteck karteform;
    Text zahl;


    /**
     * Konstruktor erzeugt einer Farbkarte mit den folgenden Eigenschaften
     * @param farbe - Farbe: blau, gelb, grün oder rot
     * @param nummer - Nummer: Zahl von 0 bis 9
     */
    public FarbKarte(String farbe, int nummer){
        super(farbe, nummer);
    }


    /**
     * Funktion gibt zurück, ob die Karte eine FarbKarte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     */
    @Override
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Farb");
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
        this.zahl = new Text(10, 2, nummer+"", GUI.FARBE_WEISS, 50, "");
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
        this.zahl.moveTo(x+10,y+2);
        // Variablen anzeigen
        this.karteform.show();
        this.zahl.show();
        // Prüfen, ob die Karte nicht die aktuelle Karte ist
        if(!istAktuelleKarte) {
            // Reaktion einsetzen
            this.karteform.setCallback(spalte+"");
            this.zahl.setCallback(spalte+"");
        } else {
        	// Reaktion aussetzen
            this.karteform.setCallback("");
            this.zahl.setCallback("");
        }
    }


    /**
     * Prozedur versteckt eine Karte
     */
    @Override
    public void versteckeKarte() {
        // Variablen verstecken
        this.karteform.hide();
        this.zahl.hide();
    }


    /**
     * Funktion zum Durchführen der Aktion einer speziellen Karte, gibt den Code für die Aktion zurück
     * @return int - Code für die Aktion
     */
    @Override
    public int aktionDurchfuehren() {
        // Code 0: Nichts machen
        return 0;
    }
    

    /**
     * Funktion gibt die Karte als String zurück
     * @return String - Karte, Farbe und Nummer
     */
    @Override
    public String toString(){
    	return "FarbKarte in der Farbe "+this.farbe+" und der Nummer "+this.nummer;
    }

} // Ende von FarbKarte