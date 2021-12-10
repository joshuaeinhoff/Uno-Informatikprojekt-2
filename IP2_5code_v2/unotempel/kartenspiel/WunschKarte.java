package unotempel.kartenspiel;

import unotempel.grafikkonsole.*;
import unotempel.GUI;

/**
 * Der Spieler, der diese Karte legt, entscheidet welche Farbe als nächstes gelegt werden soll. WunschKarten kann man immer legen, 
 * das heißt man muss nicht auf die Farbe der vorherigen Karte achten. Wenn eine WunschKarte zu Beginn des Spiels gezogen wird,
 * entscheidet der Spieler, der anfangen darf, welche Farbe als nächstes gelegt werden soll.
 */
public class WunschKarte extends Karte{

    // Variablen für die Darstellung einer WunschKarte
    Rechteck karteform;
    Rechteck rechteckBlau;
    Rechteck rechteckGelb;
    Rechteck rechteckGruen;
    Rechteck rechteckRot;


    /**
     * Konstruktor mit default-Werten: Farbe schwarz und Nummer 13
     */
    public WunschKarte(){
        super("schwarz", 13);
    }


    /**
     * Konstruktor zum Erzeugen einer Wunschkarte mit einer bestimmten Farbe
     * @param neueFarbe - Neue Farbe (nur nachdem eine WunschKarte gespielt wird)
     */
    public WunschKarte(String neueFarbe) {
        super(neueFarbe, 13);
    }


    /**
     * Funktion gibt zurück, ob die Karte eine WunschKarte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     */
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Wunsch");
    }


	/**
    * Prozedur erzeugt die visuelle Darstellung einer Karte und verteckt sie direkt danach
    */ 
	public void erzeugeVisuelleKarte(String farbe) {
    	// Variablen Werte zuweisen
    	this.karteform = new Rechteck(0, 0, 50, 100, GUI.farbeSchwarz, GUI.farbeWeiss, 2, 10, "");
        //------------------------------------------------------------------------------------------
        this.rechteckGruen = new Rechteck(8, 33, 15, 15, GUI.farbeGruen, GUI.farbeWeiss, 0, 2, "");
        this.rechteckRot = new Rechteck(26, 35, 15, 15, GUI.farbeRot, GUI.farbeWeiss, 0, 2, "");
        this.rechteckBlau = new Rechteck(10, 50, 15, 15, GUI.farbeBlau, GUI.farbeWeiss, 0, 2, "");
        this.rechteckGelb = new Rechteck(28, 52, 15, 15, GUI.farbeGelb, GUI.farbeWeiss, 0, 2, "");       
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
        // Variablen verschieben
        this.karteform.moveTo(x,y);
        this.rechteckGruen.moveTo(x+8,y+33);
        this.rechteckRot.moveTo(x+26,y+35);
        this.rechteckBlau.moveTo(x+10,y+50);
        this.rechteckGelb.moveTo(x+28,y+52);
        // Variablen anzeigen
        this.karteform.show();
        this.rechteckBlau.show();
        this.rechteckGelb.show();
        this.rechteckGruen.show();
        this.rechteckRot.show();
        // Prüfen, ob die Karte nicht die aktuelle Karte ist
        if(!istAktuelleKarte) {
            // Reaktion einsetzen
            this.karteform.setCallback(j+"");
            this.rechteckBlau.setCallback(j+"");
            this.rechteckGelb.setCallback(j+"");
            this.rechteckGruen.setCallback(j+"");
            this.rechteckRot.setCallback(j+"");
        } else {
        	// Reaktion aussetzen
            this.karteform.setCallback("");
            this.rechteckBlau.setCallback("");
            this.rechteckGelb.setCallback("");
            this.rechteckGruen.setCallback("");
            this.rechteckRot.setCallback("");
        }
    }


    /**
     * Prozedur versteckt eine Karte
     */
    public void versteckeKarte() {
        // Variablen verstecken
        this.karteform.hide();
        this.rechteckBlau.hide();
        this.rechteckGelb.hide();
        this.rechteckGruen.hide();
        this.rechteckRot.hide();
    }


    /**
     * Funktion zum Durchführen der Aktion einer speziellen Karte, gibt den Code für die Aktion zurück
     * @return int - Code für die Aktion
     */
    @Override
    public int aktionDurchfuehren() {
        // Code 3: Eine neue Farbe auswählen
        return 3;
    }
    

    /**
     * Funktion gibt die Karte als String zurück
     * @return String - Karte
     */
    public String toString(){
    	return "WunschKarte";
    }

} // Ende von WunschKarte