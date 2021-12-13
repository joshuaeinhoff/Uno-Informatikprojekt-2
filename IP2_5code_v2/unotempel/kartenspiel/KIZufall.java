package unotempel.kartenspiel;

/**
 * Klasse KIZufall stellt einen einfachen KI-Gegner dar
 */
public class KIZufall extends Spieler{

    /**
     * Konstruktor ruft Superkonstruktor auf
     * @param _lebensenergie - Lebensenergie des Monsters
     */
    public KIZufall(int _lebensenergie){
        super(_lebensenergie);
    }


    /**
     * Funktion zum Spielen einer Karte
     * @param aktuelleKarte - Aktuelle Karte im Spiel
     * @param kartenStapel - KartenStapel
     * @param karteGezogen - Karte wird schon gezogen
     * @param spielfeld
     * @return Karte zum Spielen
     */
    public Karte karteSpielen(Karte aktuelleKarte, KartenStapel kartenStapel, boolean karteGezogen, Spielfeld spielfeld){
        // Wenn der Spieler noch spielbare Karten auf der Hand hat
        while(spielbareKarteVorhanden(aktuelleKarte)){
            // Zufällige Zahl zwischen 0 und hand.length-1
            int zufallszahl = (int) (Math.random() * hand.length);

            // Wenn eine Karte zufällig ausgewählt wird und die Karte gespielt werden kann
            if(hand[zufallszahl] != null && hand[zufallszahl].istSpielbar(aktuelleKarte)) {
            	Karte ausgewaehlteKarte = hand[zufallszahl];
            	// Karte auf der Hand auf null setzen
                karteAufNullSetzen(zufallszahl);
                // DummyKarte auf Spielfeld auf null setzen
                spielfeld.dummyKarteAufNullsetzen(zufallszahl);
                // Ausgewählte Karte zurückgeben
                return ausgewaehlteKarte;
            }
        }
        // Solange der Spieler keine spielbare Karte hat und in seinem Zug noch keine Karte gezogen hat
        while(!karteGezogen) {
            // Karte ziehen
            karteZiehen(kartenStapel,aktuelleKarte,spielfeld);
            karteGezogen = true;
            System.out.println("KI zieht eine Karte ab.");
            // Versuch Karte zu spielen, diesmal karteGezogen wird auf true gesetzt
            return karteSpielen(aktuelleKarte, kartenStapel,true,spielfeld);
        }
        // Wenn der Spieler keine spielbare Karte hat und schon eine Karte gezogen hat
        System.out.println("KI hat keine spielbare Karten.");
        // null zurückgeben
        return null;
    }
    

    /**
     * Prozedur zum Ziehen der Karten
     * @param kartenStapel
     * @param aktuelleKarte
     * @param spielfeld
     */
    public void karteZiehen(KartenStapel kartenStapel, Karte aktuelleKarte, Spielfeld spielfeld){
        // Solange der Spieler noch Platz für Karten in der Hand hat, d.h. die Hand ist nicht voll
        for(int i = 0; i < hand.length; i++){
        	// Bedingung überprüft, ob die Karte in der Hand null ist, d.h. keine echte Karte an dieser Stelle
            if(hand[i] == null){
            	// Gezogene Karte aus dem Stapel in der Hand hinzufügen
                hand[i] = kartenStapel.karteZiehen(aktuelleKarte);
                // Aktualisiere Karte auf Spielfeld
                spielfeld.setzeKartePosition(new DummyKarte(),0,i);
                // Schleife unterbrechen
                return;
            }
        }
        // Meldung auf die Konsole ausgeben, falls die Hand schon voll ist
        System.out.println("Hand ist voll!");
    }
    
    
    public int neueFarbeAuswaehlen() {
    	return (int)(Math.random() * 4);
    }

} // Ende von KIZufall