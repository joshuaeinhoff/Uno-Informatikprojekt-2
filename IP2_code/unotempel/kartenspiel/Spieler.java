package unotempel.kartenspiel;

import unotempel.GUI;

/**
 * Abstrakte Superklasse für den menschlichen Spieler und die SpielerKIs(Schwierigkeiten)
 */
 public abstract class Spieler {

    // Hand des Spielers mit Karten die max. 20 Karten beinhalten darf
    protected Karte[] hand; //ArrayList<Karte> hand; //OOP2

    //Jeder Spieler hat Lebensenergie die durch Kämpfe reduziert werden kann
    protected int lebensenergie;
    

    /**
     * Konstruktor
     * @param lebensenergie - int wird am Anfang für den menschlichen Spieler auf 100 gesetz
     */
    public Spieler(int lebensenergie){
        this.lebensenergie = lebensenergie;
        // Hand hat immer die Länge 20, unabhängig von der Anzahl von aktuellen Karten
        this.hand = new Karte[20]; //hand = new ArrayList<>(); //OOP2
    }


    /**
     * Prozedur zum Ziehen sieben Karten aus dem Kartenstapel
     * @param kartenStapel
     * @param spielfeld
     * @param gui - Graphical User Interface
     */
    public void ersteHand(KartenStapel kartenStapel, Spielfeld spielfeld, GUI gui){
        // Spieler fängt mit 7 Karten an
        for(int i = 0; i < 7; i++){
            // Karte aus Stapel ziehen, aktuelle Karte ist null am Spielanfang
            karteZiehen(kartenStapel, null, spielfeld, gui);
        }
        System.out.println("Erste Hand des Spielers wurde erzeugt.");
    }
    
    
    /**
    * Prozedur zum Entleeren der Hand von Karten, falls Karten noch aus vorherigen Spiel übrig bleiben
    */
    public void handEntleeren() {
    	// Solange der Spieler Karten auf der Hand hat
    	for(int i = 0; i < hand.length; i++) {
            // Karte auf null setzen aufrufen
        	karteAufNullSetzen(i);
        }
    }


    /**
    * Prozedur setzt Karte in einem gegebenen Index auf null,
    * Platz für neue Karten auf der Hand wird freigegeben
    * @param index
    */
    public void karteAufNullSetzen(int index) {
    	hand[index] = null;
    }


    /**
     * Funktion gibt die in einem gegebenen Index gespeicherte Karte zurück
     * @param index
     * @return karte
     */
    public Karte getKarte(int index){
        return hand[index];
    }


    /**
     * Funktion gibt die Anzahl der Karten in der Hand des Spielers zurück
     * @return int - Anzahl von Karten
     */
    public int anzahlKarteHand() {
        // Zähler auf 0 setzen
        int zaehler = 0;
        // Über die Karten in der Hand iterieren
        for(Karte karte : hand) {
            // Wenn die Karte nicht null ist, d.h. noch eine Karte vorhanden ist
            if(karte != null)
                // Zähler inkrementieren
                zaehler++;
        }
        // Anzahl der Karten zurückgeben
        return zaehler;
    }


    /**
     * Funktion gibt zurück, ob der Spieler spielbare Karten vorhanden hat
     * @param aktuelleKarte - Aktuelle Karte im Spiel
     * @return true, falls spielbare Karte auf der Hand vorhanden ist - false, sonst
     */
    public boolean spielbareKarteVorhanden(Karte aktuelleKarte) {
        // Über die Karten auf der Hand des Spielers iterieren
        for(int i = 0; i < hand.length; i++) {
            // Prüft, ob die Karte nicht null ist und spielbar ist
            if(hand[i] != null && hand[i].istSpielbar(aktuelleKarte)) {
                return true;
            }
        }
        return false;
    }
    

    /**
     * Funktion zum Reduzieren der Lebensenergie
     * @return aktualisierte Lebensenergie
     */
    public int schadenZufuegen(){
        // Variable für Schaden
        int schaden = 0;
        // Schaden für das Kartenspiel berechnen
        for(Karte karte : hand) {
            if(karte != null) {
                if(karte.istWelcheKarte("PlusVierWunsch")) {
                    schaden += 5;
                } else if(karte.istWelcheKarte("Wunsch")) {
                    schaden += 4;
                } else {
                    schaden += 2;
                }
            }
        }
        // Schaden für das Quiz berechnen
        if(schaden == 0)
            schaden += 10;
        // Schaden zufügen 
        lebensenergie -= schaden;
        // Prüfen, ob Lebensenergie negativ ist
        if(lebensenergie < 0)
        	// Lebensenergie darf nicht weniger als 0 sein
            lebensenergie = 0;
        // Lebensenergie zurückgeben
        return lebensenergie;
    }
    
    
    /**
     * Prozedur zum Gewinnen von Lebensenergie
     * @param punkte
     */
    public void lebenspunkteGewinnen(int punkte) {
        lebensenergie += punkte;
    }
    

    /**
     * Funktion gibt Lebenspunkte zurück
     * @return lebensenergie
     */
    public int getLebenspunkte() {
        return lebensenergie;
    }


    /*** Abstrakte Prozeduren und Funktionen ***/

    /**
     * Prozedur zum Ziehen der Karten
     * @param kartenStapel
     * @param aktuelleKarte
     * @param spielfeld
     */
	public abstract void karteZiehen(KartenStapel kartenStapel, Karte aktuelleKarte, Spielfeld spielfeld, GUI gui);
    
    /**
     * Funktion zum Spielen einer Karte
     * @param aktuelleKarte
     * @param karten
     * @param karteGezogen
     * @param spielfeld
     * @return ausgewählteKarte
     */
    public abstract Karte karteSpielen(Karte aktuelleKarte, KartenStapel karten, boolean karteGezogen, Spielfeld spielfeld,GUI gui);

    /**
     * Abstrakte Funktion zur Auswahl einer neuen Farben
     * @param gui - Graphical User Interface
     * @return int - Code der ausgewählten Farbe
     */
	public abstract int neueFarbeAuswaehlen(GUI gui);


} // Ende von Spieler