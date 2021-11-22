package kartenspiel;

/**
 *
 */
public class Spielfeld {

    private Karte[][] spielfeld;

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
    public void ersteFuelleSpielfeld(Spieler player, Karte aktuelleKarte){
        
        //Gegener Karten setzen
        for(int x = 0; x < spielfeld[0].length; x++){
            spielfeld[0][x] = new DummyKarte("Grau");
        }

        //Random Starterkarte die übergeben wird
        spielfeld[4][4] = aktuelleKarte;

        for(int x = 0; x < spielfeld[6].length; x++){
            spielfeld[6][x] = player.getKarte(x);
        }

    }
    
}//end of Spielfeld
