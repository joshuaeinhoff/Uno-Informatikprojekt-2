package unotempel.kartenspiel;

import unotempel.GUI;

/**<br>
 * Klasse f&uuml;r das Kartenspiel<br>
 <br>*/
public class Kartenspiel {

    // Eigenschaften einer Instanz von Kartenspiel
    private KartenStapel kartenStapel; // Stapel von Karten
    private Spielfeld spielfeld; // Spielfeld auf dem gespielt wird
    private int naechsterSpieler; // Nächster Spieler (0-1): 0 ist Held, 1 ist KI
    private Spieler[] spieler; // Array von Spielern: Held in Pos 0, KI in Pos 1
    private Karte aktuelleKarte; // Aktuelle Karte im Spiel, auf dem Spielfeld
    // Farben der Karten im Spiel 
    private String[] farben = { "blau", "gelb", "gruen", "rot" }; 


    /**<br>
     * Konstruktor zum Erzeugen eines Kartenspiels f&uuml;r 2 Spieler<br>
     <br>*/
    public Kartenspiel() {
        this.kartenStapel = new KartenStapel();
        this.spielfeld = new Spielfeld();
        this.spieler = new Spieler[2];
        this.naechsterSpieler = 1; // default
    }


    /**<br>
     * Private Prozedur zum zuf&auml;llig Auswählen des ersten Spielers<br>
     * Held ist 0, KI ist 1<br>
     <br>*/
    private void setzeErsterSpieler() {
        naechsterSpieler = (int) Math.round(Math.random());
    }


    /**<br>
     * Private Prozedur zum Setzen der aktuellen Karte im Spiel und ggf. die Aktion durchf&uuml;hren<br>
     * Code je Aktion:<br>
     *  0 -&gt; nichts machen<br>
     *  1 -&gt; n&auml;chster Spieler &uuml;berspringen<br>
     *  2 -&gt; 2 Karten ziehen<br>
     *  3 -&gt; Farbe ausw&auml;hlen<br>
     *  4 -&gt; Farbe ausw&ouml;hlen und 4 Karten ziehen<br>
     * @param karte - Karte zum Ablegen<br>
     * @param gui - Graphical User Interface<br>
     <br>*/
    private void setzeAktuelleKarte(Karte karte, GUI gui) {
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
        spielfeld.setzeAktuelleKarte(aktuelleKarte,gui);
        // Funktion aufrufen, die einen int-Wert mit dem Code zurückgibt
        int code = aktuelleKarte.aktionDurchfuehren();
                
        // Fallunterscheidung für Code
        switch (code) {
            case 0:
                // Nichts machen
                break;
            case 1:
                // Nächster Spieler überspringen
                System.out.println("Aktion der Karte: Spieler " + naechsterSpieler + " wird übersprungen!");
                naechsterSpieler = (naechsterSpieler+1)%2;
                break;
            case 2:
                // Nächster Spieler zieht 2 Karten (naechsterSpieler ist der aktuelle Spieler)
                System.out.println("Aktion der Karte: Spieler " + (naechsterSpieler+1)%2 + " muss 2 Karten ziehen!");
                for(int i = 0; i < 2; i++) {
                    spieler[(naechsterSpieler+1)%2].karteZiehen(kartenStapel, aktuelleKarte,spielfeld,gui);
                }
                //naechsterSpieler = (naechsterSpieler+1)%2;
                break;
            case 3:
                // Neue Farbe auswählen
                farbeAuswaehlen(gui);
                break;
            case 4:
                // Neue Farbe auswählen
                farbeAuswaehlen(gui);
                // Nächster Spieler zieht 4 Karten
                System.out.println("Aktion der Karte: Spieler " + (naechsterSpieler+1)%2 + " muss 4 Karten ziehen!");
                for(int i = 0; i < 4; i++) {
                    spieler[(naechsterSpieler+1)%2].karteZiehen(kartenStapel, aktuelleKarte,spielfeld,gui);
                }
                //naechsterSpieler = (naechsterSpieler+1)%2;
                break;
        }
    }
    

    /**<br>
     * Private Prozedur zum Ausw&auml;hlen einer neuen Farbe<br>
     * Nur f&uuml;r WunschKarte und PlusVierWunschKarte<br>
     * @param gui - Graphical User Interface<br>
     <br>*/
    private void farbeAuswaehlen(GUI gui) {
    	int index = 0;
    	// Prüfen, ob der menschliche Spieler eine neue Farbe auswählen muss
    	if(naechsterSpieler == 0) {
        	// Menschlicher Spieler wählt eine neue Farbe aus
        	index = spieler[0].neueFarbeAuswaehlen(gui);
        } else {
        	// Spieler KI wählt eine neue Farbe aus
            index = spieler[1].neueFarbeAuswaehlen(gui);
        }
        // Neue Farbe einsetzen
        aktuelleKarte.farbe = farben[index];
        System.out.println("Neue Farbe ausgewählt ist " + farben[index]);
    }


    /**<br>
     * Prozedur zum Vorbereiten des Kartenspiels<br>
     * @param held - Spieler Held<br>
     * @param monster - Spieler KI<br>
     * @param gui - Graphical User Interface<br>
     <br>*/
    public void spielVorbereiten(Spieler held, Spieler monster, GUI gui) {
        // Spielfeld leer darstellen
        spielfeld.stelleSpielfeldLeerDar(gui);
        // KartenStapel mit Karten füllen
        kartenStapel.fuelleMitKarten();
        // Spieler vorbereiten und KI je nach Tempel-Niveau 
        spieler[0] = held;
        spieler[1] = monster;       
        // Erster Spieler auswählen
        setzeErsterSpieler();
        System.out.println("Spieler " + naechsterSpieler + " fängt an.");
        // Karten verteilen
        spieler[naechsterSpieler].ersteHand(kartenStapel,spielfeld,gui);
        spieler[(naechsterSpieler+1)%2].ersteHand(kartenStapel,spielfeld,gui);
        // Erste Karte auf das Spielfeld legen und ggf. Aktion durchführen
        setzeAktuelleKarte(kartenStapel.karteZiehen(aktuelleKarte),gui);
        // Spielfeld erstellen und füllen
        spielfeld.ersteFuelleSpielfeld(spieler[0].hand, aktuelleKarte,gui);
    }


    /**<br>
     * Funktion zum Spielen<br>
     * @param held - Spieler Held<br>
     * @param monster - Spieler KI<br>
     * @param gui - Graphical User Interface<br>
     <br>*/
    public boolean spielen(Spieler held, Spieler monster, GUI gui) {
    
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
            Karte ausgewaehlteKarte = spieler[naechsterSpieler].karteSpielen(aktuelleKarte, kartenStapel, false, spielfeld,gui);
            
            // Wenn die Methode karteSpielen() nicht null zurückgibt, wird die Karte abgelegt
            if(ausgewaehlteKarte != null) {
                // Ausgewählte Karte als aktuelle Karte einsetzen
                setzeAktuelleKarte(ausgewaehlteKarte,gui);
            }
            
            // Prüfen, ob einer der Spieler nur noch eine Karte hat
            if(naechsterSpieler == 0 && spieler[0].anzahlKarteHand() == 1) {
                String uno = gui.unoKlicken(660,450);
                // sonst bekommt er noch Karten jede X Sekunden ??
                System.out.println(uno + " wurde darauf geklickt!");
            }
            if(naechsterSpieler == 1 && spieler[1].anzahlKarteHand() == 1) {
                // warten X sekunden
                // wird UNO gerufen
                System.out.println("Gegner hat auf UNO geklickt!");
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
        	// Meldung auf die Konsole ausgeben
            System.out.println("Held hat gewonnen!");
            // Schaden für den Spieler KI zufügen
            int punkte = spieler[1].schadenZufuegen(); 
            // Lebenspunkte für den menschlichen Spieler inkrementieren
            spieler[0].lebenspunkteGewinnen(punkte);
            // Darstellung der Lebenspunkte aktualisieren
            gui.aktualisiereLebenspunkte(spieler[0]);
            System.out.println("Held hat " + spieler[0].getLebenspunkte() + " Lebenspunkte.");
            System.out.println("Monster hat " + spieler[1].getLebenspunkte() + " Lebenspunkte.\n");
            // Spieler müssen ihre Hände entleeren
            spieler[0].handEntleeren();
            spieler[1].handEntleeren();
            // Gibt true zurück, falls der Held gewonnen hat
            return true;
        } else if(spieler[1].anzahlKarteHand() == 0) {
        	// Meldung auf die Konsole ausgeben
            System.out.println("Monster hat gewonnen... Spieler wurde besiegt.");
            // Schaden für den menschlichen Spieler zufügen
            int punkte = spieler[0].schadenZufuegen();
            // Lebenspunkte für den Spieler KI inkrementieren
            spieler[1].lebenspunkteGewinnen(punkte);
            // Darstellung der Lebenspunkte aktualisieren
            gui.aktualisiereLebenspunkte(spieler[0]);
            System.out.println("Held hat " + spieler[0].getLebenspunkte() + " Lebenspunkte.");
            System.out.println("Monster hat " + spieler[1].getLebenspunkte() + " Lebenspunkte.");
        } 
        // Gibt false zurück, wenn der Held das Monster nicht besiegt hat
        return false;
    }

} // Ende von Kartenspiel