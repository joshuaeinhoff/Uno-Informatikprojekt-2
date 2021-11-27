package unotempel.kartenspiel;

/**
 * 
 */
public class Kartenspiel {

    // Eigenschaften
    private KartenStapel kartenStapel;
    //private String[] spielstand; // Spielstand?
    private Spielfeld spielfeld;
    // oder Map<K,V> -> Spieler, Punkte
    private int naechsterSpieler; // 0 ist Held, 1 ist KI
    private Spieler[] spieler;
    private Karte aktuelleKarte;

    
    /**
     * Konstruktor zum Erzeugen eines Kartenspiels für 2 Spieler
     * @param spielfeldGroesseY -
     * @param spielfeldGroesseX -
     */
    public Kartenspiel(int spielfeldGroesseY, int spielfeldGroesseX) {
        this.kartenStapel = new KartenStapel();
        this.spielfeld = new Spielfeld(spielfeldGroesseY,spielfeldGroesseX);
        
    }

    
    /**
     * Prozedur zum zufällig Auswählen des ersten Spielers
     */
    public void setzeErsterSpieler() {
        naechsterSpieler = (int) Math.round(Math.random());
    }


    /**
     * Prozedur zum Setzen der aktuellen Karte im Spiel und ggf. die Aktion durchführen
     * @param karte
     */
    public void setzeAktuelleKarte(Karte karte) {
        aktuelleKarte = karte;
        aktuelleKarte.aktionDurchfuehren();
    }


    /**
     * Prozedur zum Vorbereiten des Kartenspiels
     * @param sp - Spieler (Held)
     * @param tempelNiveau - Niveau des Tempels
     */
    public void spielVorbereiten(Spieler sp, int tempelNiveau) {
        // KartenStapel mit Karten füllen
        kartenStapel.fuelleMitKarten();
        // Erster Spieler auswählen
        setzeErsterSpieler();
        // Spieler vorbereiten und KI erzeugen
        spieler[0] = sp;
        if(tempelNiveau == 1)
            spieler[1] = new KIZufall(50);
        if(tempelNiveau == 2)
            spieler[1] = new KIZufall(80);
        if(tempelNiveau == 3)
            spieler[1] = new KISchlau(50);
        if(tempelNiveau == 4)
            spieler[1] = new KISchlau(50);
        // Karten verteilen
        spieler[naechsterSpieler].ersteHand(kartenStapel);
        spieler[(naechsterSpieler+1)%2].ersteHand(kartenStapel);
        // Erste Karte auf den Spielfeld legen und ggf. Aktion durchführen
        setzeAktuelleKarte(kartenStapel.karteZiehen());
    }


    /**
     * Prozedur zum Spielen
     */
    public void spielen(){

        // Während einer der Spieler noch Karten hat
        while(spieler[0].hand.length != 0 && spieler[1].hand.length != 0) {
            Karte karte = spieler[naechsterSpieler].karteSpielen(aktuelleKarte, kartenStapel, false);
            naechsterSpieler = (naechsterSpieler+1)%2;
            if(karte != null)
                setzeAktuelleKarte(karte);
        }
        //...
    }
    
    /*
    private void karteSpielen(Spieler _spieler){
        aktuelleKarte = _spieler.karteSpielen();
    }
	*/
}//end of Kartenspiel