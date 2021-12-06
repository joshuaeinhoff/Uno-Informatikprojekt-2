package unotempel.kartenspiel;

import unotempel.GUI;

/**
 * Klasse
 */
public class Kartenspiel {

    // Eigenschaften einer Instanz von Kartenspiel
    private KartenStapel kartenStapel; // Stapel von Karten
    private Spielfeld spielfeld; // Spielfeld auf dem gespielt wird
    // oder Map<K,V> -> Spieler, Punkte (OOP2)
    private int naechsterSpieler; // Nächster Spieler (0-1): 0 ist Held, 1 ist KI
    private Spieler[] spieler; // Array von Spielern: Held in Pos 0, KI in Pos 1
    private Karte aktuelleKarte; // Aktuelle Karte im Spiel, auf dem Spielfeld


    /**
     * Konstruktor zum Erzeugen eines Kartenspiels für 2 Spieler
     * @param spielfeldGroesseY -
     * @param spielfeldGroesseX -
     */
    public Kartenspiel() {
        this.kartenStapel = new KartenStapel();
        this.spielfeld = new Spielfeld();
        this.spieler = new Spieler[2];
    }


    /**
     * Prozedur zum zufällig Auswählen des ersten Spielers
     * Held ist 0, KI ist 1
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
        // AblageStapel aktualisieren
        kartenStapel.setzeKarteAblageStapel(aktuelleKarte);
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
                break;
            case 2:
                // Nächster Spieler zieht 2 Karten
                for(int i = 0; i < 2; i++) {
                    spieler[naechsterSpieler].karteZiehen(kartenStapel, aktuelleKarte);
                }
                break;
            case 3:
                // Neue Farbe auswählen
                farbeAuswaehlen();
                break;
            case 4:
                // Neue Farbe auswählen
                farbeAuswaehlen();
                // Nächster Spieler zieht 4 Karten
                for(int i = 0; i < 4; i++) {
                    spieler[naechsterSpieler].karteZiehen(kartenStapel, aktuelleKarte);
                }
                break;
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
        // Spieler vorbereiten und KI je nach Tempel-Niveau erzeugen
        spieler[0] = sp;
        if(tempelNiveau == 1)
            spieler[1] = new KIZufall(50);
        if(tempelNiveau == 2)
            spieler[1] = new KIZufall(80);
        if(tempelNiveau == 3)
            spieler[1] = new KISchlau(50);
        if(tempelNiveau == 4)
            spieler[1] = new KISchlau(50);
        // Erster Spieler auswählen
        setzeErsterSpieler();
        // Karten verteilen
        spieler[naechsterSpieler].ersteHand(kartenStapel);
        spieler[(naechsterSpieler+1)%2].ersteHand(kartenStapel);
        // Spielfeld erstellen, erstmal leer dann mit Karten
        //spielfeld.ersteFuelleSpielfeld(spieler[0].hand, spieler[1].hand, null);
        
        // Erste Karte auf das Spielfeld legen und ggf. Aktion durchführen
        setzeAktuelleKarte(kartenStapel.karteZiehen(aktuelleKarte));
        spielfeld.aktuallisiereSpielfeld(spieler[0], spieler[1], this.aktuelleKarte);
    }


    /**
     * Prozedur zum Spielen
     */
    public void spielen(){
        // Während einer der Spieler noch Karten hat
        while(spieler[0].anzahlKarteHand() > 0 && spieler[1].anzahlKarteHand() > 0) {
            // Spieler spielt seinem Zug, indem er eine Karte zum Ablegen aus seiner Hand nimmt
            // karteSpielen() gibt eine Karte zurück oder gar keine, karteGezogen ist erstmal falsch
            Karte karte = spieler[naechsterSpieler].karteSpielen(aktuelleKarte, kartenStapel, false);
            // Nächster Spieler ist dran (modulo 2, da nur 2 Spieler)
            naechsterSpieler = (naechsterSpieler+1)%2;
            // Wenn die Methode karteSpielen() nicht null zurückgibt, wird die Karte abgelegt
            if(karte != null)
                setzeAktuelleKarte(karte);
            // Zug ist zu Ende

            // Prüfen, ob einer der Spieler nur noch eine Karte hat
            // -> noch zu tun
            if(spieler[0].anzahlKarteHand() == 1) {
                GUI.unoKlicken();
                // sonst bekommt er noch Karten jede X Sekunden
            }
            if(spieler[1].anzahlKarteHand() == 1) {
                // warten X sekunden
                // wird UNO gerufen
            }


        }

        // Spiel ist zu Ende, falls einer der Spieler keine Karte mehr hat
        if(spieler[0].anzahlKarteHand() == 0) {
            System.out.println("Held hat gewonnen!");
            //zeiht Schaden von der Lebensenergie des gegners ab
            //spieler[1].schadenZufuegen(spieler[1].anzahlKartenHand()*10);
        } else if(spieler[1].anzahlKarteHand() == 0) {
            System.out.println("Monster hat gewonnen...");
            //spieler[0].schadenZufuegen(spieler[1].anzahlKartenHand()*4);
        } else {
            System.out.println("Fehler");
        }
    }

} // Ende von Kartenspiel