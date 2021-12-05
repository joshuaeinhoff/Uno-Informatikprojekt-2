

/**
 *
 */
public class Spielfeld {

    private Karte[][] spielfeld;

    /**
     * Konstruktor der KLasse Spielfeld
     * @param y - Spielfeld größe in Y Richtung
     * @param x - Spielfeld größe in X Richtung
     */
    public Spielfeld(int y, int x){
        spielfeld = new Karte[y][x];
    }

    /**
     * Methode um Karte auf dem Spielfeld zu Platzieren
     * X-Y-Koordinaten mit [0,0] oben links
     * @param y - Koordinate der Karte auf dem Spielfeld in int
     * @param x - Koordcinate der Karte auf dem Spielfeld in int
     * @param karte - Karte die übergeben wird
     */
    public void setzePosition(int y, int x, Karte karte){
        spielfeld[y][x] = karte;
    }

    /**
     * Methode die als erstes Aufgerufen wird um das Spielfeld initial zu füllen
     * ist noch sehr w.i.p.
     * @param player - Held damit die Karten die auf der Hand sind angzeigt werden können
     * @param aktuelleKarte - zufällige Karte die am Anfang vom Spiel generiert wird
     */
    public void ersteFuelleSpielfeld(Karte[] kartenMenschlichSpieler, Karte[] kartenSpielerKI, Karte aktuelleKarte){
        
        // Gegner Karten als DummyKarten setzen
        for(int x = 0; x < 7; x++){ // spielfeld[0].length ?
            spielfeld[0][x] = new DummyKarte();
        }

        // Random Starterkarte die übergeben wird
        spielfeld[4][4] = aktuelleKarte;

        for(int x = 0; x < 7; x++){ //spielfeld[6].length
            spielfeld[6][x] = kartenMenschlichSpieler[x];
        }
        // Spielfeld erstmal leer darstellen
        GUI.spielfeldLeerDarstellen(this, spielfeld.length, spielfeld[0].length);
        // Spielfeld mit Karten füllen
        //GUI.spielfeldDarstellen(this, spielfeld.length, spielfeld[0].length);

    }
    
} // Ende von Spielfeld