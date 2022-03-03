package unotempel.kartenspiel;

import unotempel.grafikkonsole.*;
import unotempel.GUI;

/**<br>
 * DummyKarte stellt die Karten des Gegners im Spiel dar<br>
 <br>*/
public class DummyKarte extends Karte{

    // Variablen für die Darstellung einer DummyKarte
    Rechteck karteform;


    /**<br>
     * Konstruktor erzeugt eine DummyKarte mit default-Werten: Farbe keine und Nummer -1<br>
     <br>*/
    public DummyKarte(){
        super("keine", -1);
    }


    /**<br>
     * Funktion gibt zur&uuml;ck, ob die Karte eine DummyKarte ist<br>
     * @param kartenart - Art der Karte<br>
     * @return true - falls die KartenArt passt, false - sonst<br>
     <br>*/
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Dummy");
    }


	/**<br>
    * Prozedur erzeugt die visuelle Darstellung einer Karte<br>
    * @param farbe - Farbe der Karte<br>
    <br>*/  
	public void erzeugeVisuelleKarte(String farbe) {
    	this.karteform = new Rechteck(0, 0, 50, 100, GUI.farbeGrau, GUI.farbeWeiss, 2, 10, ""); 
    }
    

    /**<br>
     * Prozedur setzt die Karte auf die gegebene Position und macht diese sichtbar<br>
     * @param j - Koordinate auf der X-Achse im Spielfeld (2x2-KarteArray)<br>
     * @param i - Koordinate auf der Y-Achse im Spielfeld (2x2-KarteArray)<br>
     * @param x - Koordinate auf der X-Achse f&uuml;r die Darstellung<br>
     * @param y - Koordinate auf der Y-Achse f&uuml;r die Darstellung<br>
     * @param istAktuelleKarte - true, wenn die Karte die aktuelle Karte im Spiel entspricht - false, sonst<br>
     <br>*/
    public void setzeKarteAuf(int j, int i, int x, int y, boolean istAktuelleKarte) {
    	erzeugeVisuelleKarte("grau");
        // Variablen verschieben
        this.karteform.moveTo(x,y);
        // Variablen anzeigen
        this.karteform.show();
    }


    /**<br>
     * Prozedur versteckt eine Karte<br>
     <br>*/
    public void versteckeKarte() {
        // Variablen verstecken
        this.karteform.hide();
    }


    /**<br>
     * Funktion zum Durchf&uuml;hren der Aktion einer speziellen Karte, gibt den Code für die Aktion zurück<br>
     * @return int - Code f&uuml;r die Aktion<br>
     <br>*/
    @Override
    public int aktionDurchfuehren() {
        // Code 0: Nichts machen
        return 0;
    }
    

    /**<br>
     * Funktion gibt die Karte als String zur&uuml;ck<br>
     * @return String - Karte<br>
     <br>*/
    public String toString(){
     return "DummyKarte";
    }

} // Ende von DummyKarte