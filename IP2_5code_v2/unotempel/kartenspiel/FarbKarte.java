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
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Farb");
    }


	/**
    * Prozedur erzeugt die visuelle Darstellung einer Karte und verteckt sie direkt danach
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
        this.zahl = new Text(10, 2, nummer+"", GUI.farbeWeiss, 50, "");
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
        this.zahl.waitFor(200); */
        // Variablen verschieben
        this.karteform.moveTo(x,y);
        this.zahl.moveTo(x+10,y+2);
        // Variablen anzeigen
        this.karteform.show();
        this.zahl.show();
        // Prüfen, ob die Karte nicht die aktuelle Karte ist
        if(!istAktuelleKarte) {
            // Reaktion einsetzen
            this.karteform.setCallback(j+"");
            this.zahl.setCallback(j+"");
        } else {
        	// Reaktion aussetzen
            this.karteform.setCallback("");
            this.zahl.setCallback("");
        }
    }


    /**
     * Prozedur versteckt eine Karte
     */
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
    public String toString(){
    	return "FarbKarte in der Farbe "+this.farbe+" und der Nummer "+this.nummer;
    }

} // Ende von FarbKarte