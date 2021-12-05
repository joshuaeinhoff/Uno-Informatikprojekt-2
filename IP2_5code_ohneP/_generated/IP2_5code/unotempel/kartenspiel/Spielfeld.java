package unotempel.kartenspiel;

/**
 *
 <br>*/
public class Spielfeld {

    private Karte[][] spielfeld;

    /**
     * Konstruktor der KLasse Spielfeld
     * @param y - Spielfeld gr&ouml;&szlig;e in Y Richtung
     * @param x - Spielfeld gr&ouml;&szlig;e in X Richtung
     <br>*/
    public Spielfeld(int y, int x){
        spielfeld = new Karte[y][x];
    }

    /**
     * Methode um Karte auf dem Spielfeld zu Platzieren
     * X-Y-Koordinaten mit [0,0] oben links
     * @param y - Koordinate der Karte auf dem Spielfeld in int
     * @param x - Koordcinate der Karte auf dem Spielfeld in int
     * @param karte - Karte die &uuml;bergeben wird
     <br>*/
    public void setzePosition(int y, int x, Karte karte){
        spielfeld[y][x] = karte;
    }

    /**
     * Methode die als erstes Aufgerufen wird um das Spielfeld initial zu f&uuml;llen
     * ist noch sehr w.i.p.
     * @param player - Held damit die Karten die auf der Hand sind angzeigt werden k&ouml;nnen
     * @param aktuelleKarte - zuf&auml;llige Karte die am Anfang vom Spiel generiert wird
     <br>*/
    public void ersteFuelleSpielfeld(Spieler menschlichSpieler, Spieler spielerKI,Karte aktuelleKarte){
        
        //Gegener Karten setzen
        for(int x = 0; x < spielfeld[0].length; x++){
            spielfeld[0][x] = new DummyKarte();
        }

        //Random Starterkarte die übergeben wird
        spielfeld[4][4] = aktuelleKarte;

        for(int x = 0; x < spielfeld[6].length; x++){
            spielfeld[6][x] = menschlichSpieler.getKarte(x);
        }

    }
    
} // Ende von Spielfeld