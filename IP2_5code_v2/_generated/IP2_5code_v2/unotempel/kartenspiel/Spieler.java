package unotempel.kartenspiel;

/**<br>
 * Abstrakte Superklasse f&uuml;r den menschlichen Spieler und die SpielerKIs(Schwierigkeiten)<br>
 <br>*/
 public abstract class Spieler {

    //ArrayList<Karte> hand; //OOP2

    // Hand des Spielers mit Karten die max. 20 Karten beinhalten darf
    protected Karte[] hand; 

    //Jeder Spieler hat Lebensenergie die durch Kämpfe reduziert werden kann
    protected int lebensenergie;
    

    /**<br>
     * Konstruktor<br>
     * @param lebensenergie - int wird am Anfang f&uuml;r den menschlichen Spieler auf 100 gesetz<br>
     <br>*/
    public Spieler(int lebensenergie){
        //hand = new ArrayList<>(); //OOP2
        this.lebensenergie = lebensenergie;
        this.hand = new Karte[20]; 
    }


    /**<br>
     * Prozedur zum Ziehen sieben Karten aus dem Kartenstapel<br>
     * @param kartenStapel<br>
     * @param spielfeld<br>
     <br>*/
    public void ersteHand(KartenStapel kartenStapel, Spielfeld spielfeld){
        for(int i = 0; i < 7; i++){
            // Karte aus Stapel ziehen, aktuelle Karte ist null am Spielanfang
            karteZiehen(kartenStapel, null,spielfeld);
        }
        System.out.println("Erste Hand des Spielers wurde erzeugt.");
    }


    /**<br>
     * Methode zum ziehen der Karten<br>
     <br>*/
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


    /**<br>
     * Funktion gibt die in einem gegebenen Index gespeicherte Karte zur&uuml;ck<br>
     * @param index<br>
     * @return karte<br>
     <br>*/
    public Karte getKarte(int index){
        return hand[index];
    }


    /**<br>
     * Funktion gibt zur&uuml;ck, ob der Spieler spielbare Karten vorhanden hat<br>
     * @param aktuelleKarte - Aktuelle Karte im Spiel<br>
     * @return true, falls spielbare Karte auf der Hand vorhanden ist - false, sonst<br>
     <br>*/
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
    

    /**<br>
    * Prozedur setzt Karte in einem gegebenen Index auf null,<br>
    * Platz f&uuml;r neue Karten auf der Hand wird freigegeben<br>
    * @param index<br>
    <br>*/
    public void karteAufNullSetzen(int index) {
    	hand[index] = null;
    }


    /**<br>
     * Methode zum reduzieren der Lebensenergie<br>
     * @param schaden - int Schaden der abgezogen werden soll<br>
     * @return lebensenergie - int<br>
     <br>*/
    public int schadenZufuegen(int schaden){
        lebensenergie = lebensenergie-schaden;
        return lebensenergie;
    }


    /**<br>
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


    /*** Abstrakte Prozeduren und Funktionen **<br>*/

    /**<br>
     * Prozedur zum Ziehen der Karten<br>
     * @param kartenStapel<br>
     * @param aktuelleKarte<br>
     * @param spielfeld<br>
     <br>*/
	public abstract void karteZiehen(KartenStapel kartenStapel, Karte aktuelleKarte, Spielfeld spielfeld);
    
    /**<br>
     * Prozedur zum Spielen einer Karte<br>
     * @param aktuelleKarte<br>
     * @param karten<br>
     * @param karteGezogen<br>
     * @param spielfeld<br>
     * @return ausgew&auml;hlteKarte<br>
     <br>*/
    public abstract Karte karteSpielen(Karte aktuelleKarte, KartenStapel karten, boolean karteGezogen, Spielfeld spielfeld);


} // Ende von Spieler