package unotempel.kartenspiel;

import unotempel.GUI;


/**<br>
 * Klasse<br>
 <br>*/
public class Kartenspiel {

    // Eigenschaften einer Instanz von Kartenspiel
    private KartenStapel kartenStapel; // Stapel von Karten
    private Spielfeld spielfeld; // Spielfeld auf dem gespielt wird
    // oder Map<K,V> -> Spieler, Punkte (OOP2)
    private int naechsterSpieler; // Nächster Spieler (0-1): 0 ist Held, 1 ist KI
    private Spieler[] spieler; // Array von Spielern: Held in Pos 0, KI in Pos 1
    private Karte aktuelleKarte; // Aktuelle Karte im Spiel, auf dem Spielfeld


    /**<br>
     * Konstruktor zum Erzeugen eines Kartenspiels f&uuml;r 2 Spieler<br>
     * @param spielfeldGroesseY -<br>
     * @param spielfeldGroesseX -<br>
     <br>*/
    public Kartenspiel() {
        this.kartenStapel = new KartenStapel();
        this.spielfeld = new Spielfeld();
        this.spieler = new Spieler[2];
    }


    /**<br>
     * Prozedur zum zuf&auml;llig Auswählen des ersten Spielers<br>
     * Held ist 0, KI ist 1<br>
     <br>*/
    private void setzeErsterSpieler() {
        naechsterSpieler = (int) Math.round(Math.random());
    }


    /**<br>
     * Prozedur zum Setzen der aktuellen Karte im Spiel und ggf. die Aktion durchf&uuml;hren<br>
     * Code je Aktion:<br>
     *  0 -&gt; nichts machen<br>
     *  1 -&gt; n&auml;chster Spieler &uuml;berspringen<br>
     *  2 -&gt; 2 Karten ziehen<br>
     *  3 -&gt; Farbe ausw&auml;hlen<br>
     *  4 -&gt; Farbe ausw&ouml;hlen und 4 Karten ziehen<br>
     * @param karte - Karte zum Ablegen<br>
     <br>*/
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


    /**<br>
     * Prozedur zum Ausw&auml;hlen einer neuen Farbe<br>
     * Nur f&uuml;r WunschKarte und PlusVierWunschKarte<br>
     <br>*/
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


    /**<br>
     * Prozedur zum Vorbereiten des Kartenspiels<br>
     * @param sp - Spieler (Held)<br>
     * @param tempelNiveau - Niveau des Tempels<br>
     <br>*/
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


    /**<br>
     * Prozedur zum Spielen<br>
     <br>*/
    public void spielen(){
    	System.out.println(naechsterSpieler);
    
    
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