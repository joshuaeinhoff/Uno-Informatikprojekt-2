package unotempel.kartenspiel;



/**
 * Abstrakte Superklasse für den menschlichen Spieler und die SpielerKIs(Schwierigkeiten)
 */
 public abstract class Spieler {

    //Jeder Spieler hat eine gewisse Anzahl an Karten auf der Hand, die hier in einem Array gespeichert werden.
    //Liste ist vielleicht doch ein wenig besser, da der Spieler immer unterschiedlich viele Karten auf der Hand
    //hat - muss dann immer ein neues Array gemacht werden? z. B. 10 Karten auf der Hand

	//ArrayList<Karte> hand; //OOP2


    // Hand des Spielers mit Karten die max. 20 Karten beinhalten darf
    protected Karte[] hand; 

    //Jeder Spieler hat Lebensenergie die durch Kämpfe reduziert werden kann
    protected int lebensenergie;
    
    /**
     * Konstruktor
     * @param _lebensenergie - int wird am Anfang z. B. für den menschlichen Spieler auf 100 gesetz
     */
    public Spieler(int _lebensenergie){
        //hand = new ArrayList<>(); //OOP2
        lebensenergie = _lebensenergie;
        hand = new Karte[20]; 
    }

    /**
     * zieht sieben Karten aus dem Kartenstapel
     * @param kartenStapel
     */
    public void ersteHand(KartenStapel kartenStapel){
        for(int i = 0; i < 7; i++){
            // Karte aus Stapel ziehen, aktuelle Karte ist null am Spielanfang
            karteZiehen(kartenStapel, null);
        }
        System.out.println("Erste Hand des Spielers erzeugt \n(angenommen echte Karten abgezogen)");
    }


    /**
     * Methode zum ziehen der Karten
     */
    public void karteZiehen(KartenStapel kartenStapel, Karte aktuelleKarte){
        //OOP2
        //hand.get(kartenStapel.karteZiehen());
        
        // Solange der Spieler noch Platz für Karten in der Hand hat, d.h. die Hand ist nicht voll
        for(int i = 0; i < hand.length; i++){
        	// Bedingung überprüft, ob die Karte in der Hand null ist, d.h. keine echte Karte an dieser Stelle
            if(hand[i] == null){
            	// Gezogene Karte aus dem Stapel in der Hand hinzufügen
                hand[i] = kartenStapel.karteZiehen(aktuelleKarte);
                return;
            }
        }
        // Falls die Hand schon voll ist
        System.out.println("Hand ist voll!");
    }


    
    public abstract Karte karteSpielen(Karte aktuelleKarte, KartenStapel karten, boolean karteGezogen);

    
    /**
     * get methoden sind eigentlich eher doof aber muss erstmal so 
     * @param index
     * @return
     */
    public Karte getKarte(int index){
        return hand[index];
    }

    /**
     * ist glaube doch eine doofe Methode muss noch gucken wo ich die hin packe
     * @param aktuelleKarte - Aktuelle Karte im Spiel
     * @return true - falls spielbare Karte auf der Hand vorhanden ist, false - sonst
     */
    public boolean spielbareKarteVorhanden(Karte aktuelleKarte){
        for(int i = 0; i < hand.length; i++){
            if(hand[i].istSpielbar(aktuelleKarte)){
                return true;
            }
        }
        return false;
    }


    /**
     * Methode zum reduzieren der Lebensenergie
     * @param schaden - int Schaden der abgezogen werden soll
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

} // Ende von Spieler