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
  
    private String farben[] = { "blau", "gelb", "gruen", "rot" }; // mögliche Farben der Karten im Spiel 


    /**
     * Konstruktor zum Erzeugen eines Kartenspiels für 2 Spieler
     * @param spielfeldGroesseY 
     * @param spielfeldGroesseX 
     */
    public Kartenspiel() {
        this.kartenStapel = new KartenStapel();
        this.spielfeld = new Spielfeld();
        this.spieler = new Spieler[2];
        this.naechsterSpieler = 1; // default
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
                System.out.println("Aktion der Karte: Spieler " + naechsterSpieler + " wird übersprungen!");
                naechsterSpieler = (naechsterSpieler+1)%2;
                break;
            case 2:
                // Nächster Spieler zieht 2 Karten (naechsterSpieler ist der aktuelle Spieler)
                System.out.println("Aktion der Karte: Spieler " + (naechsterSpieler+1)%2 + " muss 2 Karten ziehen!");
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
                System.out.println("Aktion der Karte: Spieler " + (naechsterSpieler+1)%2 + " muss 4 Karten ziehen!");
                for(int i = 0; i < 4; i++) {
                    spieler[(naechsterSpieler+1)%2].karteZiehen(kartenStapel, aktuelleKarte,spielfeld);
                }
                naechsterSpieler = (naechsterSpieler+1)%2;
                break;
        }
    }
    
    


    /**
     * Private Prozedur zum Auswählen einer neuen Farbe
     * Nur für WunschKarte und PlusVierWunschKarte
     */
    private void farbeAuswaehlen() {
    	int index = 0;
    	// Prüfen, ob der menschliche Spieler eine neue Farbe auswählen muss
    	if(naechsterSpieler == 0) {
        	// Menschlicher Spieler wählt eine neue Farbe aus
        	index = spieler[0].neueFarbeAuswaehlen();
        } else {
        	// Spieler KI wählt eine neue Farbe aus
            index = spieler[1].neueFarbeAuswaehlen();
        }
        // Neue Farbe einsetzen
        aktuelleKarte.setzeFarbe(farben[index]);
    }


    /**
     * Prozedur zum Vorbereiten des Kartenspiels
     * @param held
     * @param monster
     */
    public void spielVorbereiten(Spieler held, Spieler monster) {
        // Spielfeld leer darstellen
        spielfeld.stelleSpielfeldLeerDar();
        // KartenStapel mit Karten füllen
        kartenStapel.fuelleMitKarten();
        // Spieler vorbereiten und KI je nach Tempel-Niveau 
        spieler[0] = held;
        spieler[1] = monster;       
        
        // Erster Spieler auswählen
        setzeErsterSpieler();
        System.out.println("Spieler " + naechsterSpieler + " fängt an.");
        
        // Karten verteilen
        spieler[naechsterSpieler].ersteHand(kartenStapel,spielfeld);
        spieler[(naechsterSpieler+1)%2].ersteHand(kartenStapel,spielfeld);      
        
        // Erste Karte auf das Spielfeld legen und ggf. Aktion durchführen
        setzeAktuelleKarte(kartenStapel.karteZiehen(aktuelleKarte));

        // Spielfeld erstellen und füllen
        spielfeld.ersteFuelleSpielfeld(spieler[0].hand, aktuelleKarte);
    }


    /**
     * Prozedur zum Spielen
     */
    public boolean spielen(Spieler held, Spieler monster) {   
    
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
        	// Meldung auf die Konsole ausgeben
            System.out.println("Held hat gewonnen!");
            // Lebenspunkte für den menschlichen Spieler inkrementieren
            spieler[0].lebenspunkteGewinnen(spieler[1].anzahlKarteHand() * 4);
            // Darstellung der Lebenspunkte aktualisieren
            GUI.zeigeAktualisierteLebenspunkte(spieler[0]);
            System.out.println("Held hat " + spieler[0].getLebenspunkte() + " Lebenspunkte.");
            // Schaden für den Spieler KI zufügen
            //spieler[1].schadenZufuegen(spieler[1].anzahlKartenHand()*10);
            
            // Gibt true zurück, falls der Held das Monster besiegt hat
            return true;
        } else if(spieler[1].anzahlKarteHand() == 0) {
        	// Meldung auf die Konsole ausgeben
            System.out.println("Monster hat gewonnen... Spieler wurde besiegt.");

            // Schaden für den menschlichen Spieler zufügen
            spieler[0].schadenZufuegen(spieler[1].anzahlKarteHand()*4);
            // Darstellung der Lebenspunkte aktualisieren
            GUI.zeigeAktualisierteLebenspunkte(spieler[0]);
            System.out.println("Held hat " + spieler[0].getLebenspunkte() + " Lebenspunkte.");
        } 
        // Gibt false zurück, wenn der Held das Monster nicht besiegt hat
        return false;
    }

} // Ende von Kartenspiel