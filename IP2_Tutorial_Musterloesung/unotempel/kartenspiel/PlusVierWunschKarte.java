package unotempel.kartenspiel;

import unotempel.grafikkonsole.*;
import unotempel.GUI;

/** 2.5 PlusVierWunschKarte Δe_5pf25n Δ  
 * Der Spieler, der diese Karte legt, entscheidet welche Farbe als nächstes gelegt werden soll.
 * Zudem muss der Gegenspieler vier Karten von dem Kartenstapel ziehen.
 */
public class PlusVierWunschKarte extends Karte{

	/** 2.5.1 Daten als Instanz-Variablen definieren Δe_8vub3b Δ */
    Rechteck karteform;
    Rechteck rechteckBlau;
    Rechteck rechteckGelb;
    Rechteck rechteckGruen;
    Rechteck rechteckRot;
    Text zahlOben;
    Text zahlUnten;


    /** 2.5.2 Konstruktor erstellen  Δe_83cya8 Δ 
     * Konstruktor erzeugt einer PlusVierWunschKarte mit default-Werten: Farbe schwarz und Nummer 14
     */
    public PlusVierWunschKarte(){
        super("schwarz", 14);
    }


    /** 2.5.2 Konstruktor erstellen  Δe_wbdvmq Δ 
     * Konstruktor erzeugt einer PlusVierWunschKarte mit einer bestimmten Farbe
     * @param neueFarbe - Neue Farbe (nur nachdem eine PlusVierWunschKarte gespielt wird)
     */
    public PlusVierWunschKarte(String neueFarbe){
        super(neueFarbe, 14);
    }


    /**
     * Funktion gibt zurück, ob die Karte eine PlusVierWunschKarte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     */
    @Override
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("PlusVierWunsch");
    }

    
   /**
    * Prozedur erzeugt die visuelle Darstellung einer Karte und verteckt sie direkt danach
    */ 
    @Override
    public void erzeugeVisuelleKarte(String farbe) {
    	// Variablen Werte zuweisen
    	this.karteform = new Rechteck(0, 0, 50, 100, GUI.FARBE_SCHWARZ, GUI.FARBE_WEISS, 2, 10, "");
        // Farbige Rechtecke
        this.rechteckGruen = new Rechteck(8, 33, 15, 15, GUI.FARBE_GRUEN, GUI.FARBE_WEISS, 0, 2, "");
        this.rechteckRot = new Rechteck(26, 35, 15, 15, GUI.FARBE_ROT, GUI.FARBE_WEISS, 0, 2, "");
        this.rechteckBlau = new Rechteck(10, 50, 15, 15, GUI.FARBE_BLAU, GUI.FARBE_WEISS, 0, 2, "");
        this.rechteckGelb = new Rechteck(28, 52, 15, 15, GUI.FARBE_GELB, GUI.FARBE_WEISS, 0, 2, "");
        // Zahlen
        this.zahlOben = new Text(5, 0, "+4", GUI.FARBE_WEISS, 25, "");
        this.zahlUnten = new Text(15, 55, "+4", GUI.FARBE_WEISS, 25, "");
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
        this.rechteckGruen.moveTo(x+8,y+33);
        this.rechteckRot.moveTo(x+26,y+35);
        this.rechteckBlau.moveTo(x+10,y+50);
        this.rechteckGelb.moveTo(x+28,y+52);
        this.zahlOben.moveTo(x+5,y-5);
        this.zahlUnten.moveTo(x+15,y+55);
        // Variablen anzeigen
        this.karteform.show();
        this.rechteckBlau.show();
        this.rechteckGelb.show();
        this.rechteckGruen.show();
        this.rechteckRot.show();
        this.zahlOben.show();
        this.zahlUnten.show();
        // Prüfen, ob die Karte nicht die aktuelle Karte ist
        if(!istAktuelleKarte) {
            // Reaktion einsetzen
            this.karteform.setCallback(spalte+"");
            this.rechteckBlau.setCallback(spalte+"");
            this.rechteckGelb.setCallback(spalte+"");
            this.rechteckGruen.setCallback(spalte+"");
            this.rechteckRot.setCallback(spalte+"");
            this.zahlOben.setCallback(spalte+"");
            this.zahlUnten.setCallback(spalte+"");
        } else {
            // Reaktion aussetzen
            this.karteform.setCallback("");
            this.rechteckBlau.setCallback("");
            this.rechteckGelb.setCallback("");
            this.rechteckGruen.setCallback("");
            this.rechteckRot.setCallback("");
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
        this.rechteckBlau.hide();
        this.rechteckGelb.hide();
        this.rechteckGruen.hide();
        this.rechteckRot.hide();
        this.zahlOben.hide();
        this.zahlUnten.hide();
    }


    /**
     * Funktion zum Durchführen der Aktion einer speziellen Karte, gibt den Code für die Aktion zurück
     * @return int - Code für die Aktion
     */
    @Override
    public int aktionDurchfuehren() {
        // Code 4: Vier Karten Ziehen
        return 4;
    }
    
    
    /**
     * Funktion gibt die Karte als String zurück
     * @return String - Karte
     */
    @Override    
    public String toString(){
        return "PlusVierWunschKarte";
    }
    
	
} // Ende von PlusVierWunschKarte