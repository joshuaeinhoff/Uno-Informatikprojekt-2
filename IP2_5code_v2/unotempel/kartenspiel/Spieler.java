package unotempel.kartenspiel;

/**
 * Abstrakte Superklasse für den menschlichen Spieler und die SpielerKIs(Schwierigkeiten)
 */
 public abstract class Spieler {

    //ArrayList<Karte> hand; //OOP2

    // Hand des Spielers mit Karten die max. 20 Karten beinhalten darf
    protected Karte[] hand; 

    //Jeder Spieler hat Lebensenergie die durch Kämpfe reduziert werden kann
    protected int lebensenergie;
    

    /**
     * Konstruktor
     * @param lebensenergie - int wird am Anfang für den menschlichen Spieler auf 100 gesetz
     */
    public Spieler(int lebensenergie){
        //hand = new ArrayList<>(); //OOP2
        this.lebensenergie = lebensenergie;
        this.hand = new Karte[20]; 
    }


    /**
     * Prozedur zum Ziehen sieben Karten aus dem Kartenstapel
     * @param kartenStapel
     * @param spielfeld
     */
    public void ersteHand(KartenStapel kartenStapel, Spielfeld spielfeld){
        for(int i = 0; i < 7; i++){
            // Karte aus Stapel ziehen, aktuelle Karte ist null am Spielanfang
            karteZiehen(kartenStapel, null,spielfeld);
        }
        System.out.println("Erste Hand des Spielers wurde erzeugt.");
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
     * Funktion gibt zurück, ob der Spieler spielbare Karten vorhanden hat
     * @param aktuelleKarte - Aktuelle Karte im Spiel
     * @return true, falls spielbare Karte auf der Hand vorhanden ist - false, sonst
     */
    public boolean spielbareKarteVorhanden(Karte aktuelleKarte){
        // Über die Karten auf der Hand des Spielers iterieren
        for(int i = 0; i < hand.length; i++){
            // Prüft, ob die Karte nicht null ist und spielbar ist
            if(hand[i] != null && hand[i].istSpielbar(aktuelleKarte)){
                return true;
            }
        }
        return false;
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
     * Methode zum reduzieren der Lebensenergie
     * @param schaden - int Schaden der abgezogen werden soll
     * @return lebensenergie - int
     */
    public void schadenZufuegen(int schaden){
        this.lebensenergie -= schaden;
    }
    
    
    public void lebenspunkteGewinnen(int punkte) {
    	this.lebensenergie += punkte;
    }
    
    public int getLebenspunkte() {
        return this.lebensenergie;
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


    /*** Abstrakte Prozeduren und Funktionen ***/

    /**
     * Prozedur zum Ziehen der Karten
     * @param kartenStapel
     * @param aktuelleKarte
     * @param spielfeld
     */
	public abstract void karteZiehen(KartenStapel kartenStapel, Karte aktuelleKarte, Spielfeld spielfeld);
    
    /**
     * Prozedur zum Spielen einer Karte
     * @param aktuelleKarte
     * @param karten
     * @param karteGezogen
     * @param spielfeld
     * @return ausgewählteKarte
     */
    public abstract Karte karteSpielen(Karte aktuelleKarte, KartenStapel karten, boolean karteGezogen, Spielfeld spielfeld);


	public abstract int neueFarbeAuswaehlen();


} // Ende von Spieler