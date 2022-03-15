package unotempel.kartenspiel;

import unotempel.GUI;

/**<br>
 * Abstrakte Superklasse f&uuml;r den menschlichen Spieler und die SpielerKIs(Schwierigkeiten)<br>
 <br>*/
 public abstract class Spieler {

	/** 1.2 Daten als IV implementieren   <br>*/
    
    // Hand des Spielers mit Karten die max. 20 Karten beinhalten darf
    protected Karte[] hand; //ArrayList<Karte> hand; //OOP2

    //Jeder Spieler hat Lebensenergie die durch Kämpfe reduziert werden kann
    protected int lebensenergie;
    

	/** 1.3 Superkonstrukor definieren  <br>
     * Konstruktor<br>
     * @param lebensenergie - int wird am Anfang f&uuml;r den menschlichen Spieler auf 100 gesetz<br>
     <br>*/
    public Spieler(int lebensenergie){
        this.lebensenergie = lebensenergie;
        // Hand hat immer die Länge 20, unabhängig von der Anzahl von aktuellen Karten
        this.hand = new Karte[20]; 
        // this.hand = new ArrayList<>(); // Für OOP2
    }


	/** 1.3 Erste Hand des Spielers  <br>
     * Prozedur zum Ziehen sieben Karten aus dem Kartenstapel<br>
     * @param kartenStapel<br>
     * @param spielfeld<br>
     * @param gui - Graphical User Interface<br>
     <br>*/
    public void ersteHand(KartenStapel kartenStapel, Spielfeld spielfeld, GUI gui){
        // Spieler fängt mit 7 Karten an
        for(int i = 0; i < 7; i++){
            // Karte aus Stapel ziehen, aktuelle Karte ist null am Spielanfang
            karteZiehen(kartenStapel, null, spielfeld, gui);
        }
        System.out.println("Erste Hand des Spielers wurde erzeugt.");
    }
    
    /** 1.4 Hand des Spielers entleeren  <br>
    * Prozedur zum Entleeren der Hand von Karten, falls Karten noch aus vorherigen Spiel &uuml;brig bleiben<br>
    <br>*/
    public void handEntleeren() {
    	// Solange der Spieler Karten auf der Hand hat
    	for(int i = 0; i < hand.length; i++) {
            // Karte auf null setzen aufrufen
        	karteAufNullSetzen(i);
        }
    }


    /**<br>
    * Prozedur setzt Karte in einem gegebenen Index auf null,<br>
    * Platz f&uuml;r neue Karten auf der Hand wird freigegeben<br>
    * @param index<br>
    <br>*/
    public void karteAufNullSetzen(int index) {
    	hand[index] = null;
    }


    /**<br>
     * Funktion gibt die in einem gegebenen Index gespeicherte Karte zur&uuml;ck<br>
     * @param index<br>
     * @return karte<br>
     <br>*/
    public Karte getKarte(int index){
        return hand[index];
    }


	/** 1.5 Anzahl der Karten in der Hand zur&uuml;ckgeben  <br>
     * Funktion gibt die Anzahl der Karten in der Hand des Spielers zur&uuml;ck<br>
     * @return int - Anzahl von Karten<br>
     <br>*/
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


    /** 1.6 Sind spielbare Karten vorhanden?  <br>
     * Funktion gibt zur&uuml;ck, ob der Spieler spielbare Karten vorhanden hat<br>
     * @param aktuelleKarte - Aktuelle Karte im Spiel<br>
     * @return true, falls spielbare Karte auf der Hand vorhanden ist - false, sonst<br>
     <br>*/
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
    

	
	/** 1.7 Schaden zuf&uuml;gen  <br>
     * Funktion zum Reduzieren der Lebensenergie<br>
     * @return aktualisierte Lebensenergie<br>
     <br>*/
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
    
    
    /**<br>
     * Prozedur zum Gewinnen von Lebensenergie<br>
     * @param punkte<br>
     <br>*/
    public void lebenspunkteGewinnen(int punkte) {
        lebensenergie += punkte;
    }
    

    /**<br>
     * Funktion gibt Lebenspunkte zur&uuml;ck<br>
     * @return lebensenergie<br>
     <br>*/
    public int getLebenspunkte() {
        return lebensenergie;
    }


    /*** Abstrakte Prozeduren und Funktionen **<br>*/

	//Deklaration der abstrakten Methoden, macht die Methoden für Subklassen bekannt
	//implementiert die Methoden aber nicht, dies muss noch in den Subklassen erfolgen
    
    /**<br>
     * Prozedur zum Ziehen der Karten<br>
     * @param kartenStapel<br>
     * @param aktuelleKarte<br>
     * @param spielfeld<br>
     <br>*/
	public abstract void karteZiehen(KartenStapel kartenStapel, Karte aktuelleKarte, Spielfeld spielfeld, GUI gui);
    
    /**<br>
     * Funktion zum Spielen einer Karte<br>
     * @param aktuelleKarte<br>
     * @param karten<br>
     * @param karteGezogen<br>
     * @param spielfeld<br>
     * @return ausgew&auml;hlteKarte<br>
     <br>*/
    public abstract Karte karteSpielen(Karte aktuelleKarte, KartenStapel karten, boolean karteGezogen, Spielfeld spielfeld,GUI gui);

    /**<br>
     * Abstrakte Funktion zur Auswahl einer neuen Farben<br>
     * @param gui - Graphical User Interface<br>
     * @return int - Code der ausgew&auml;hlten Farbe<br>
     <br>*/
	public abstract int neueFarbeAuswaehlen(GUI gui);
	
	
} // Ende von Spieler