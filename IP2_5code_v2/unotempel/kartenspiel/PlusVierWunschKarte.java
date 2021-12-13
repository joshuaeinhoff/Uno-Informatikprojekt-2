package unotempel.kartenspiel;

import unotempel.grafikkonsole.*;
import unotempel.GUI;

/** Der Spieler, der diese Karte legt, entscheidet welche Farbe als nächstes gelegt werden soll.
 * Zudem muss der Gegenspieler vier Karten von dem Kartenstapel ziehen.
 */
public class PlusVierWunschKarte extends Karte{
        
    // Variablen für die Darstellung einer PlusVierWunschKarte
    Rechteck karteform;
    Rechteck rechteckBlau;
    Rechteck rechteckGelb;
    Rechteck rechteckGruen;
    Rechteck rechteckRot;
    Text zahlOben;
    Text zahlUnten;


    /**
     * Konstruktor mit default-Werten: Farbe schwarz und Nummer 14
     */
    public PlusVierWunschKarte(){
        super("schwarz", 14);
    }


    /**
     * Konstruktor zum Erzeugen einer PlusVierWunschKarte mit einer bestimmten Farbe
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
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("PlusVierWunsch");
    }

    
   /**
    * Prozedur erzeugt die visuelle Darstellung einer Karte und verteckt sie direkt danach
    */ 
    public void erzeugeVisuelleKarte(String farbe) {
    	// Variablen Werte zuweisen
    	this.karteform = new Rechteck(0, 0, 50, 100, GUI.farbeSchwarz, Grafik.WHITE, 2, 10, "");
        //------------------------------------------------------------------------------------------
        this.rechteckGruen = new Rechteck(8, 33, 15, 15, GUI.farbeGruen, GUI.farbeWeiss, 0, 2, "");
        this.rechteckRot = new Rechteck(26, 35, 15, 15, GUI.farbeRot, GUI.farbeWeiss, 0, 2, "");
        this.rechteckBlau = new Rechteck(10, 50, 15, 15, GUI.farbeBlau, GUI.farbeWeiss, 0, 2, "");
        this.rechteckGelb = new Rechteck(28, 52, 15, 15, GUI.farbeGelb, GUI.farbeWeiss, 0, 2, "");
        //Text--------------------------------------------------------------------------------------
    	this.zahlOben = new Text(5, 0, "+4", GUI.farbeWeiss, 25, "");
        this.zahlUnten = new Text(15, 55, "+4", GUI.farbeWeiss, 25, "");
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
        this.rechteckGruen.waitFor(200);
        this.rechteckRot.waitFor(200);
        this.rechteckBlau.waitFor(200);
        this.rechteckGelb.waitFor(200);
        this.zahlOben.waitFor(200);
        this.zahlUnten.waitFor(200); */
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
            this.karteform.setCallback(j+"");
            this.rechteckBlau.setCallback(j+"");
            this.rechteckGelb.setCallback(j+"");
            this.rechteckGruen.setCallback(j+"");
            this.rechteckRot.setCallback(j+"");
            this.zahlOben.setCallback(j+"");
            this.zahlUnten.setCallback(j+"");
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
        // Code 4: Vier Karte Ziehen
        return 4;
    }
    
    
    /**
     * Funktion gibt die Karte als String zurück
     * @return String - Karte
     */    
    public String toString(){
        return "PlusVierWunschKarte";
    }
    
} // Ende von PlusVierWunschKarte