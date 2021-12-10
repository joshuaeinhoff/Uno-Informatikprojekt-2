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
     * Methode zum ziehen der Karten
     */
/*    public void karteZiehen(KartenStapel kartenStapel, Karte aktuelleKarte, Spielfeld spielfeld){
        //OOP2
        //hand.get(kartenStapel.karteZiehen());
        
        // Solange der Spieler noch Platz für Karten in der Hand hat, d.h. die Hand ist nicht voll
        for(int i = 0; i < hand.length; i++){
        	// Bedingung überprüft, ob die Karte in der Hand null ist, d.h. keine echte Karte an dieser Stelle
            if(hand[i] == null){
            	// Gezogene Karte aus dem Stapel in der Hand hinzufügen
                hand[i] = kartenStapel.karteZiehen(aktuelleKarte);
                // Aktualisiere Karte auf Spielfeld
                spielfeld.setzeKartePosition(hand[i],2,i);
                return;
            }
        }
        // Falls die Hand schon voll ist
        System.out.println("Hand ist voll!");
    }
    */


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
    public int schadenZufuegen(int schaden){
        lebensenergie = lebensenergie-schaden;
        return lebensenergie;
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


} // Ende von Spieler