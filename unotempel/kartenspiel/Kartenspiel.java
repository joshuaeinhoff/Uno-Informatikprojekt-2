package unotempel.kartenspiel;

import unotempel.GUI;

/**
 * Klasse Kartenspiel
 */
public class Kartenspiel {

    // Eigenschaften
    private KartenStapel kartenStapel;
    //private String[] spielstand; // Spielstand?
    private Spielfeld spielfeld;
    // oder Map<K,V> -> Spieler, Punkte
    private int naechsterSpieler; // 0 ist Held, 1 ist KI
    private Spieler[] spieler;
    private Karte aktuelleKarte;

    
    /**
     * Konstruktor zum Erzeugen eines Kartenspiels für 2 Spieler
     * @param spielfeldGroesseY -
     * @param spielfeldGroesseX -
     */
    public Kartenspiel(int spielfeldGroesseY, int spielfeldGroesseX) {
        this.kartenStapel = new KartenStapel();
        this.spielfeld = new Spielfeld(spielfeldGroesseY,spielfeldGroesseX);
        
    }

    
    /**
     * Prozedur zum zufällig Auswählen des ersten Spielers
     */
    private void setzeErsterSpieler() {
        naechsterSpieler = (int) Math.round(Math.random());
    }


    /**
     * Prozedur zum Setzen der aktuellen Karte im Spiel und ggf. die Aktion durchführen
     * Code je Aktion:
     *  0 -> nichts machen
     *  1 -> nächster Spieler überspringen
     *  2 -> 2 Karten ziehen
     *  3 -> Farbe auswählen
     *  4 -> Farbe auswöhlen und 4 Karten ziehen
     * @param karte - Karte zum Ablegen
     */
    private void setzeAktuelleKarte(Karte karte) {
        // Aktuelle Karte im Spiel durch neue Karte ersetzen
        aktuelleKarte = karte;
        // Funktion aufrufen, die einen int-Wert mit dem Code zurückgibt
        int code = aktuelleKarte.aktionDurchfuehren();
        // Fallunterscheidung für Code
        switch (code) {
            case 0:
                // Nichts machen
                break;
            case 1:
                // Nächster Spieler überspringen
                naechsterSpieler = (naechsterSpieler+1)%2;
            case 2:
                // Nächster Spieler zieht 2 Karten
                for(int i = 0; i < 2; i++) {
                    spieler[naechsterSpieler].karteZiehen(kartenStapel);
                }
            case 3:
                // Neue Farbe auswählen
                farbeAuswaehlen();
            case 4:
                // Neue Farbe auswählen
                farbeAuswaehlen();
                // Nächster Spieler zieht 4 Karten
                for(int i = 0; i < 4; i++) {
                    spieler[naechsterSpieler].karteZiehen(kartenStapel);
                }

        }
    }


    /**
     * Prozedur zum Auswählen einer neuen Farbe
     * Nur für WunschKarte und PlusVierWunschKarte
     */
    private void farbeAuswaehlen() {
        // Mithilfe der Grafik_Konsole eine neue Farbe auswählen
        String neueFarbe = GUI.farbeAuswaehlen();
        // Fallunterscheidung: Wunschkarte oder PlusVierWunschkarte
        if(aktuelleKarte.istWelcheKarte("Wunsch"))
            // WunschKarte erzeugen und als aktuelle Karte einsetzen, da Wunschkarte einer Farbe im KartenStapel nicht vorhanden sein kann
            setzeAktuelleKarte(new WunschKarte(neueFarbe));
        if(aktuelleKarte.istWelcheKarte("PlusVierWunsch"))
            // PlusVierWunschKarte erzeugen und als aktuelle Karte einsetzen, da PlusVierWunschKarte einer Farbe im KartenStapel nicht vorhanden sein kann
            setzeAktuelleKarte(new PlusVierWunschKarte(neueFarbe));
    }


    /**
     * Prozedur zum Vorbereiten des Kartenspiels
     * @param sp - Spieler (Held)
     * @param tempelNiveau - Niveau des Tempels
     */
    public void spielVorbereiten(Spieler sp, int tempelNiveau) {
        // KartenStapel mit Karten füllen
        kartenStapel.fuelleMitKarten();
        // Erster Spieler auswählen
        setzeErsterSpieler();
        // Spieler vorbereiten und KI erzeugen
        spieler[0] = sp;
        if(tempelNiveau == 1)
            spieler[1] = new KIZufall(50);
        if(tempelNiveau == 2)
            spieler[1] = new KIZufall(80);
        if(tempelNiveau == 3)
            spieler[1] = new KISchlau(50);
        if(tempelNiveau == 4)
            spieler[1] = new KISchlau(50);
        // Karten verteilen
        spieler[naechsterSpieler].ersteHand(kartenStapel);
        spieler[(naechsterSpieler+1)%2].ersteHand(kartenStapel);
        // Erste Karte auf den Spielfeld legen und ggf. Aktion durchführen
        setzeAktuelleKarte(kartenStapel.karteZiehen());
    }


    /**
     * Prozedur zum Spielen
     */
    public void spielen(){
        // Während einer der Spieler noch Karten hat
        while(spieler[0].hand.length != 0 && spieler[1].hand.length != 0) {
            // Spieler spielt seinem Zug, indem er eine Karte zum Ablegen aus seiner Hand nimmt
            Karte karte = spieler[naechsterSpieler].karteSpielen(aktuelleKarte, kartenStapel, false);
            // Nächster Spieler ist dran (modulo 2, da nur 2 Spieler)
            naechsterSpieler = (naechsterSpieler+1)%2;
            // Wenn die Methode karteSpielen() nicht null zurückgibt wird die Karte abgelegt
            if(karte != null)
                setzeAktuelleKarte(karte);
            // Zug ist zu Ende

            // noch zu machen
            

        }

        // Spiel ist zu Ende
    }

    
    /*
    private void karteSpielen(Spieler _spieler){
        aktuelleKarte = _spieler.karteSpielen();
    }
	*/
}//end of Kartenspiel