package unotempel.kartenspiel;

import unotempel.GUI;

/**
 * Klasse für das Kartenspiel
 */
public class Kartenspiel {

    // Eigenschaften einer Instanz von Kartenspiel
    private KartenStapel kartenStapel; // Stapel von Karten
    private Spielfeld spielfeld; // Spielfeld auf dem gespielt wird
    private int naechsterSpieler; // Nächster Spieler (0-1): 0 ist Held, 1 ist KI
    private Spieler[] spieler; // Array von Spielern: Held in Pos 0, KI in Pos 1
    private Karte aktuelleKarte; // Aktuelle Karte im Spiel, auf dem Spielfeld
    // Farben der Karten im Spiel 
    private String[] farben = { "blau", "gelb", "gruen", "rot" }; 


    /**
     * Konstruktor zum Erzeugen eines Kartenspiels für 2 Spieler
     */
    public Kartenspiel() {
        this.kartenStapel = new KartenStapel();
        this.spielfeld = new Spielfeld();
        this.spieler = new Spieler[2];
        this.naechsterSpieler = 1; // default
    }


    /**
     * Private Prozedur zum zufällig Auswählen des ersten Spielers
     * Held ist 0, KI ist 1
     */
    private void setzeErsterSpieler() {
        naechsterSpieler = (int) Math.round(Math.random());
    }


    /**
     * Private Prozedur zum Setzen der aktuellen Karte im Spiel und ggf. die Aktion durchführen
     * Code je Aktion:
     *  0 -> nichts machen
     *  1 -> nächster Spieler überspringen
     *  2 -> 2 Karten ziehen
     *  3 -> Farbe auswählen
     *  4 -> Farbe auswöhlen und 4 Karten ziehen
     * @param karte - Karte zum Ablegen
     * @param gui - Graphical User Interface
     */
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
    

    /**
     * Private Prozedur zum Auswählen einer neuen Farbe
     * Nur für WunschKarte und PlusVierWunschKarte
     * @param gui - Graphical User Interface
     */
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


    /**
     * Prozedur zum Vorbereiten des Kartenspiels
     * @param held - Spieler Held
     * @param monster - Spieler KI
     * @param gui - Graphical User Interface
     */
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
    }


    /**
     * Prozedur zum Spielen
     * @param held - Spieler Held
     * @param monster - Spieler KI
     * @param gui - Graphical User Interface
     */
    public void spielen(Spieler held, Spieler monster, GUI gui) {
    
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
                // sonst bekommt er noch Karten jede X Sekunden ?? --> ??
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
        // Held hat keine Karte mehr, dann hat der Held gewonnen 
        if(spieler[0].anzahlKarteHand() == 0) {
        	// Meldung auf die Konsole ausgeben
            System.out.println("Held hat das Kartenspiel gewonnen!");
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

		// Spieler KI hat keine Karte mehr, dann hat der Held verloren
        } else if(spieler[1].anzahlKarteHand() == 0) {
        	// Meldung auf die Konsole ausgeben
            System.out.println("Monster hat das Kartenspiel gewonnen...");
            // Schaden für den menschlichen Spieler zufügen
            int punkte = spieler[0].schadenZufuegen();
            // Lebenspunkte für den Spieler KI inkrementieren
            spieler[1].lebenspunkteGewinnen(punkte);
            // Darstellung der Lebenspunkte aktualisieren
            gui.aktualisiereLebenspunkte(spieler[0]);
            System.out.println("Held hat " + spieler[0].getLebenspunkte() + " Lebenspunkte.");
            System.out.println("Monster hat " + spieler[1].getLebenspunkte() + " Lebenspunkte.");
            // Spieler müssen ihre Hände entleeren
            spieler[0].handEntleeren();
            spieler[1].handEntleeren();
        } 

    }

} // Ende von Kartenspiel