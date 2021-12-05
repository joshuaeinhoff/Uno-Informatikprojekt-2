package unotempel.kartenspiel;

/**<br>
 * Abstrakte Superklasse f&uuml;r den menschlichen Spieler und die SpielerKIs(Schwierigkeiten)<br>
 <br>*/
 public abstract class Spieler {

    //Jeder Spieler hat eine gewisse Anzahl an Karten auf der Hand, die hier in einem Array gespeichert werden.
    //Liste ist vielleicht doch ein wenig besser, da der Spieler immer unterschiedlich viele Karten auf der Hand
    //hat - muss dann immer ein neues Array gemacht werden? z. B. 10 Karten auf der Hand

	//ArrayList<Karte> hand; //OOP2


    // Hand des Spielers mit Karten die max. 20 Karten beinhalten darf
    protected Karte[] hand; 

    //Jeder Spieler hat Lebensenergie die durch Kämpfe reduziert werden kann
    protected int lebensenergie;
    
    /**<br>
     * Konstruktor<br>
     * @param _lebensenergie - int wird am Anfang z. B. f&uuml;r den menschlichen Spieler auf 100 gesetz<br>
     <br>*/
    public Spieler(int _lebensenergie){
        //hand = new ArrayList<>(); //OOP2
        lebensenergie = _lebensenergie;
        hand = new Karte[20]; 
    }

    /**<br>
     * zieht sieben Karten aus dem Kartenstapel<br>
     * @param kartenStapel<br>
     <br>*/
    public void ersteHand(KartenStapel kartenStapel){
        for(int i = 0; i < 7; i++){
            // Karte aus Stapel ziehen, aktuelle Karte ist null am Spielanfang
            karteZiehen(kartenStapel, null);
        }
    }

    /**<br>
     * Methode zum ziehen der Karten<br>
     <br>*/
    public void karteZiehen(KartenStapel kartenstapel, Karte aktuelleKarte){
        //OOP2
        //hand.get(kartenstapel.karteZiehen());
        //fügt die aus dem Stapel gezogene Karte der Hand hinzu
        for(int i = 0; i < hand.length; i++){
            if(hand[i] == null){
                hand[i] = kartenstapel.karteZiehen(aktuelleKarte);
                return;
            }else{
                System.out.println("Hand ist voll!");
            }
        }
    }


    
    public abstract Karte karteSpielen(Karte aktuelleKarte, KartenStapel karten, boolean karteGezogen);

    
    /**<br>
     * get methoden sind eigentlich eher doof aber muss erstmal so <br>
     * @param index<br>
     * @return<br>
     <br>*/
    public Karte getKarte(int index){
        return hand[index];
    }

    /**<br>
     * ist glaube doch eine doofe Methode muss noch gucken wo ich die hin packe<br>
     * @param aktuelleKarte - Aktuelle Karte im Spiel<br>
     * @return true - falls spielbare Karte auf der Hand vorhanden ist, false - sonst<br>
     <br>*/
    public boolean spielbareKarteVorhanden(Karte aktuelleKarte){
        for(int i = 0; i < hand.length; i++){
            if(hand[i].istSpielbar(aktuelleKarte)){
                return true;
            }
        }
        return false;
    }


    /**<br>
     * Methode zum reduzieren der Lebensenergie<br>
     * @param schaden - int Schaden der abgezogen werden soll<br>
     <br>*/
    public void schadenZufuegen(int schaden){
        lebensenergie = lebensenergie-schaden;
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

} // Ende von Spieler