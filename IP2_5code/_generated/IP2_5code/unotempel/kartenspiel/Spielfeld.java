package unotempel.kartenspiel;

import unotempel.GUI;

/**<br>
 *<br>
 <br>*/
public class Spielfeld {

    private Karte[][] spielfeld;
    // Größe des Spielfelds
    private int groesseX;
   	private int groesseY;

    /**<br>
     * Konstruktor erzeugt ein Spielfeld mit Platz f&uuml;r 5x10 Karten<br>
     <br>*/
    public Spielfeld(){
    	// ( Anzahl von Karten in Y-Richtung, Anzahl von Karten in X-Richtung)
        this.spielfeld = new Karte[5][10];
        this.groesseX = 660;
        this.groesseY = 450;
    }

    /**<br>
     * Methode um Karte auf dem Spielfeld zu Platzieren<br>
     * X-Y-Koordinaten mit [0,0] oben links<br>
     * @param y - Koordinate der Karte auf dem Spielfeld in int<br>
     * @param x - Koordcinate der Karte auf dem Spielfeld in int<br>
     * @param karte - Karte die &uuml;bergeben wird<br>
     <br>*/
    public void setzePosition(int y, int x, Karte karte){
        spielfeld[y][x] = karte;
    }

    /**<br>
     * Methode die als erstes Aufgerufen wird um das Spielfeld initial zu f&uuml;llen<br>
     * ist noch sehr w.i.p.<br>
     * @param player - Held damit die Karten die auf der Hand sind angzeigt werden k&ouml;nnen<br>
     * @param aktuelleKarte - zuf&auml;llige Karte die am Anfang vom Spiel generiert wird<br>
     <br>*/
    public void ersteFuelleSpielfeld(Karte[] kartenMenschlichSpieler, Karte[] kartenSpielerKI, Karte aktuelleKarte){
        
        // Gegner Karten als DummyKarten setzen
        for(int x = 0; x < 7; x++){ // spielfeld[0].length ?
            spielfeld[0][x] = new DummyKarte();
        }

        // Random Starterkarte die übergeben wird
        spielfeld[2][2] = aktuelleKarte;

        for(int x = 0; x < 7; x++){ //spielfeld[6].length
            spielfeld[4][x] = kartenMenschlichSpieler[x];
        }
        // Spielfeld erstmal leer darstellen
        GUI.spielfeldLeerDarstellen(spielfeld, groesseX, groesseY);
        // Spielfeld mit Karten füllen
        //GUI.spielfeldDarstellen(this, spielfeld.length, spielfeld[0].length);

    }
    
} // Ende von Spielfeld