package unotempel.kartenspiel;

import unotempel.GUI;

/**<br>
 * Klasse f&uuml;r das Kartenspiel<br>
 <br>*/
public class Kartenspiel {

    // Eigenschaften einer Instanz von Kartenspiel
    private KartenStapel kartenStapel; // Stapel von Karten
    private Spielfeld spielfeld; // Spielfeld auf dem gespielt wird
    // oder Map<K,V> -> Spieler, Punkte (OOP2)
    private int naechsterSpieler; // Nächster Spieler (0-1): 0 ist Held, 1 ist KI
    private Spieler[] spieler; // Array von Spielern: Held in Pos 0, KI in Pos 1
    private Karte aktuelleKarte; // Aktuelle Karte im Spiel, auf dem Spielfeld
    
    private String farben[] = { "blau", "gelb", "gruen", "rot" }; // mögliche Farben der Karten im Spiel 


    /**<br>
     * Konstruktor zum Erzeugen eines Kartenspiels f&uuml;r 2 Spieler<br>
     * @param spielfeldGroesseY <br>
     * @param spielfeldGroesseX <br>
     <br>*/
    public Kartenspiel() {
        this.kartenStapel = new KartenStapel();
        this.spielfeld = new Spielfeld();
        this.spieler = new Spieler[2];
        this.naechsterSpieler = 1; // default
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
        if(aktuelleKarte != null) {
            // Aktuelle Karte verstecken
            aktuelleKarte.versteckeKarte();
        }
        // Aktuelle Karte im Spiel durch neue Karte ersetzen
        aktuelleKarte = karte;
        System.out.println("Die aktuelle Karte ist " + aktuelleKarte);
        // AblageStapel aktualisieren
        kartenStapel.setzeKarteAblageStapel(aktuelleKarte);
        // Aktuelle Karte visuell darstellen
        spielfeld.setzeAktuelleKarte(aktuelleKarte);
        // Funktion aufrufen, die einen int-Wert mit dem Code zurückgibt
        int code = aktuelleKarte.aktionDurchfuehren();
                
        // Fallunterscheidung für Code
        switch (code) {
            case 0:
                // Nichts machen
                break;
            case 1:
                // Nächster Spieler überspringen
                System.out.println("Aktion der Karte: \nSpieler " + (naechsterSpieler+1)%2 + " wird übersprungen!");
                naechsterSpieler = (naechsterSpieler+1)%2;
                break;
            case 2:
                // Nächster Spieler zieht 2 Karten (naechsterSpieler ist der aktuelle Spieler)
                System.out.println("Aktion der Karte: \nSpieler " + (naechsterSpieler+1)%2 + " muss 2 Karten ziehen!");
                for(int i = 0; i < 2; i++) {
                    spieler[(naechsterSpieler+1)%2].karteZiehen(kartenStapel, aktuelleKarte,spielfeld);
                }
                naechsterSpieler = (naechsterSpieler+1)%2;
                break;
            case 3:
                // Neue Farbe auswählen
                farbeAuswaehlen();
                break;
            case 4:
                // Neue Farbe auswählen
                farbeAuswaehlen();
                // Nächster Spieler zieht 4 Karten
                System.out.println("Aktion der Karte: \nSpieler " + (naechsterSpieler+1)%2 + " muss 4 Karten ziehen!");
                for(int i = 0; i < 4; i++) {
                    spieler[(naechsterSpieler+1)%2].karteZiehen(kartenStapel, aktuelleKarte,spielfeld);
                }
                naechsterSpieler = (naechsterSpieler+1)%2;
                break;
        }
    }
    
    


    /**<br>
     * Private Prozedur zum Ausw&auml;hlen einer neuen Farbe<br>
     * Nur f&uuml;r WunschKarte und PlusVierWunschKarte<br>
     <br>*/
    private void farbeAuswaehlen() {
    	String neueFarbe = "";
    	// Prüfen, ob der menschliche Spieler eine neue Farbe auswählen muss
    	if(naechsterSpieler == 0) {
        	// Mithilfe der Grafik_Konsole eine neue Farbe auswählen
        	neueFarbe = GUI.farbeAuswaehlen();
        } else {
        	// Zufälliger Wert wird ausgewählt
            int zufallszahl = (int)(Math.random() * 4);
            // Neue Farbe aus dem String-Array zufällig einsetzen
            neueFarbe = farben[zufallszahl];
        }
        // Neue Farbe einsetzen
        aktuelleKarte.setzeFarbe(neueFarbe);
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
        
        // Karten verteilen
        spieler[naechsterSpieler].ersteHand(kartenStapel,spielfeld);
        spieler[(naechsterSpieler+1)%2].ersteHand(kartenStapel,spielfeld);
        
        // Erster Spieler auswählen
        setzeErsterSpieler();
        System.out.println("Spieler " + naechsterSpieler + " fängt an.");
        
        // Erste Karte auf das Spielfeld legen und ggf. Aktion durchführen
        setzeAktuelleKarte(kartenStapel.karteZiehen(aktuelleKarte));

        // Spielfeld erstellen und füllen
        spielfeld.ersteFuelleSpielfeld(spieler[0].hand, aktuelleKarte);
    }


    /**<br>
     * Prozedur zum Spielen<br>
     <br>*/
    public void spielen() {   
    
        // Während einer der Spieler noch Karten hat
        while(spieler[0].anzahlKarteHand() > 0 && spieler[1].anzahlKarteHand() > 0) {
            // Auf die Konsole ausgeben, welcher Spieler dran ist
            if(naechsterSpieler == 0) 
            	System.out.print("Held ");
            else 
            	System.out.print("KI ");
            System.out.println("ist dran!");
            
            // Spieler spielt seinem Zug, indem er eine Karte zum Ablegen aus seiner Hand nimmt
            // karteSpielen() gibt eine Karte zurück oder gar keine, karteGezogen ist erstmal falsch
            Karte ausgewaehlteKarte = spieler[naechsterSpieler].karteSpielen(aktuelleKarte, kartenStapel, false, spielfeld);            
            
            // Wenn die Methode karteSpielen() nicht null zurückgibt, wird die Karte abgelegt
            if(ausgewaehlteKarte != null) {
                System.out.println("Spieler " + naechsterSpieler + " Karte " + ausgewaehlteKarte.toString());
                // Ausgewählte Karte als aktuelle Karte einsetzen
                setzeAktuelleKarte(ausgewaehlteKarte);
            }
            
            // Prüfen, ob einer der Spieler nur noch eine Karte hat
            // -> noch zu tun
            if(naechsterSpieler == 0 && spieler[0].anzahlKarteHand() == 1) {
                String uno = GUI.unoKlicken(660,450);
                // sonst bekommt er noch Karten jede X Sekunden
                System.out.println(uno + " wurde darauf geklickt!");
            }
            if(naechsterSpieler == 1 && spieler[1].anzahlKarteHand() == 1) {
                // warten X sekunden
                // wird UNO gerufen
            }
            
            // Nächster Spieler ist dran (modulo 2, da nur 2 Spieler)
            naechsterSpieler = (naechsterSpieler+1)%2;
            
            
            
            // Aktualisiere Spielfeld (erstmal nur Held und aktuelle Karte, KI kommt noch...)
            //spielfeld.aktualisiereSpielfeld(spieler[0].hand, spieler[1].hand, aktuelleKarte);    
            
            // Zug ist zu Ende

            

			System.out.println();
        }

        // Spiel ist zu Ende, falls einer der Spieler keine Karte mehr hat
        if(spieler[0].anzahlKarteHand() == 0) {
            System.out.println("Held hat gewonnen!");
            //zeiht Schaden von der Lebensenergie des gegners ab
            //spieler[1].schadenZufuegen(spieler[1].anzahlKartenHand()*10);
        } else if(spieler[1].anzahlKarteHand() == 0) {
            System.out.println("Monster hat gewonnen... Spieler wurde besiegt.");
            //spieler[0].schadenZufuegen(spieler[1].anzahlKartenHand()*4);
            // Schaden für den Spieler
        } else {
            System.out.println("Fehler");
        }
    }

} // Ende von Kartenspiel