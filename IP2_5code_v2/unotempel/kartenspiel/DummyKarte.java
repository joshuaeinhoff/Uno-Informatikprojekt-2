package unotempel.kartenspiel;

import unotempel.grafikkonsole.*;
import unotempel.GUI;

/**
 * DummyKarte stellt die Karten des Gegners im Spiel dar
 */
public class DummyKarte extends Karte{

    // Variablen für die Darstellung einer DummyKarte
    Rechteck karteform;


    /**
     * Konstruktor erzeugt eine DummyKarte mit default-Werten: Farbe keine und Nummer -1
     */
    public DummyKarte(){
        super("keine", -1);
    }


    /**
     * Funktion gibt zurück, ob die Karte eine DummyKarte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     */
    @Override
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Dummy");
    }


	/**
    * Prozedur erzeugt die visuelle Darstellung einer Karte
    * @param farbe - Farbe der Karte
    */
    @Override  
	public void erzeugeVisuelleKarte(String farbe) {
    	// Variable initialisieren
    	this.karteform = new Rechteck(0, 0, 50, 100, GUI.farbeGrau, GUI.farbeWeiss, 2, 10, "");
        // Variable verstecken
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
    	// Visuelle Darstellung der Karte erstellen
        erzeugeVisuelleKarte("grau");
        // Warte 2 Sekunden darauf
        this.karteform.waitFor(200);
        // Variablen verschieben
        this.karteform.moveTo(x,y);
        // Variablen anzeigen
        this.karteform.show();
    }


    /**
     * Prozedur versteckt eine Karte
     */
    @Override
    public void versteckeKarte() {
        // Prüfen, ob die DummyKarte eine Form hat
        if(this.karteform != null) {
            // Variablen verstecken
            this.karteform.hide();
        }
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
     * @return String - Karte
     */
    @Override
    public String toString(){
     return "DummyKarte";
    }

} // Ende von DummyKarte