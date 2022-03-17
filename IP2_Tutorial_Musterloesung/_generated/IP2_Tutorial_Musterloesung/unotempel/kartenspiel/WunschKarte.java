package unotempel.kartenspiel;

import unotempel.grafikkonsole.*;
import unotempel.GUI;

/** 2.4 WunschKarte  <br>
 * Der Spieler, der diese Karte legt, entscheidet welche Farbe als n&auml;chstes gelegt werden soll. WunschKarten kann man immer legen, <br>
 * das hei&szlig;t man muss nicht auf die Farbe der vorherigen Karte achten. Wenn eine WunschKarte zu Beginn des Spiels gezogen wird,<br>
 * entscheidet der Spieler, der anfangen darf, welche Farbe als n&auml;chstes gelegt werden soll.<br>
 <br>*/
public class WunschKarte extends Karte{

    /** 2.4.1 Daten als Instanz-Variablen definieren   <br>*/
    Rechteck karteform;
    Rechteck rechteckBlau;
    Rechteck rechteckGelb;
    Rechteck rechteckGruen;
    Rechteck rechteckRot;


    /** 2.4.2 Konstruktor erstellen  <br>
     * Konstruktor erzeugt eine WunschKarte mit default-Werten: Farbe schwarz und Nummer 13<br>
     <br>*/
    public WunschKarte(){
        super("schwarz", 13);
    }


    /** 2.4.2 Konstruktor erstellen   <br>
     * Konstruktor zum Erzeugen einer Wunschkarte mit einer bestimmten Farbe und default-Wert: Nummer 13<br>
     * @param neueFarbe - Neue Farbe (nur nachdem eine WunschKarte gespielt wird)<br>
     <br>*/
    public WunschKarte(String neueFarbe) {
        super(neueFarbe, 13);
    }


    /**<br>
     * Funktion gibt zur&uuml;ck, ob die Karte eine WunschKarte ist<br>
     * @param kartenart - Art der Karte<br>
     * @return true - falls die KartenArt passt, false - sonst<br>
     <br>*/
    @Override
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Wunsch");
    }


	/**<br>
    * Prozedur erzeugt die visuelle Darstellung einer Karte und verteckt sie direkt danach<br>
    <br>*/ 
    @Override
	public void erzeugeVisuelleKarte(String farbe) {
    	// Variablen Werte zuweisen
    	this.karteform = new Rechteck(0, 0, 50, 100, GUI.FARBE_SCHWARZ, GUI.FARBE_WEISS, 2, 10, "");
        // Farbige Rechtecke
        this.rechteckGruen = new Rechteck(8, 33, 15, 15, GUI.FARBE_GRUEN, GUI.FARBE_WEISS, 0, 2, "");
        this.rechteckRot = new Rechteck(26, 35, 15, 15, GUI.FARBE_ROT, GUI.FARBE_WEISS, 0, 2, "");
        this.rechteckBlau = new Rechteck(10, 50, 15, 15, GUI.FARBE_BLAU, GUI.FARBE_WEISS, 0, 2, "");
        this.rechteckGelb = new Rechteck(28, 52, 15, 15, GUI.FARBE_GELB, GUI.FARBE_WEISS, 0, 2, "");       
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
            this.karteform.setCallback(spalte+"");
            this.rechteckBlau.setCallback(spalte+"");
            this.rechteckGelb.setCallback(spalte+"");
            this.rechteckGruen.setCallback(spalte+"");
            this.rechteckRot.setCallback(spalte+"");
        } else {
        	// Reaktion aussetzen
            this.karteform.setCallback("");
            this.rechteckBlau.setCallback("");
            this.rechteckGelb.setCallback("");
            this.rechteckGruen.setCallback("");
            this.rechteckRot.setCallback("");
        }
    }


    /**<br>
     * Prozedur versteckt eine Karte<br>
     <br>*/
    @Override
    public void versteckeKarte() {
        // Variablen verstecken
        this.karteform.hide();
        this.rechteckBlau.hide();
        this.rechteckGelb.hide();
        this.rechteckGruen.hide();
        this.rechteckRot.hide();
    }


    /**<br>
     * Funktion zum Durchf&uuml;hren der Aktion einer speziellen Karte, gibt den Code für die Aktion zurück<br>
     * @return int - Code f&uuml;r die Aktion<br>
     <br>*/
    @Override
    public int aktionDurchfuehren() {
        // Code 3: Eine neue Farbe auswählen
        return 3;
    }
    

    /**<br>
     * Funktion gibt die Karte als String zur&uuml;ck<br>
     * @return String - Karte<br>
     <br>*/
    @Override
    public String toString(){
    	return "WunschKarte";
    }

	
} // Ende von WunschKarte