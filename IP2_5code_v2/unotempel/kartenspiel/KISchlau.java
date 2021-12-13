package unotempel.kartenspiel;

/**
 * Klasse KIZufall stellt einen komplizierten KI-Gegner dar
 */
public class KISchlau extends Spieler{

    /**
     * Konstruktor ruft Superkonstruktor auf
     * @param _lebensenergie - Lebensenergie des Monsters
     */
    public KISchlau(int _lebensenergie){
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
    public Karte karteSpielen(Karte aktuelleKarte, KartenStapel kartenStapel, boolean karteGezogen,Spielfeld spielfeld){

        if(existiertKarte(aktuelleKarte,"Aussetzen")){  
            return findKarte(aktuelleKarte,"Aussetzen",spielfeld);
        }else if(existiertKarte(aktuelleKarte, "Retour")){
            return findKarte(aktuelleKarte,"Retour",spielfeld);
        }else if(existiertKarte(aktuelleKarte,"PlusZwei")){
            return findKarte(aktuelleKarte,"PlusZwei",spielfeld);
        }else if(existiertKarte(aktuelleKarte,"Farb")){
            return findKarte(aktuelleKarte,"Farb",spielfeld);
        }else if(existiertKarte(aktuelleKarte,"PlusVierWunsch")){
            return findKarte(aktuelleKarte,"PlusVierWunsch",spielfeld);
        }else if(existiertKarte(aktuelleKarte,"Wunsch")){
            return findKarte(aktuelleKarte,"Wunsch",spielfeld);
        } else if(!karteGezogen){
        	System.out.println("KI zieht eine Karte ab.");
            karteZiehen(kartenStapel, aktuelleKarte,spielfeld);
            return karteSpielen(aktuelleKarte, kartenStapel, true,spielfeld);
        }else{
        	System.out.println("KI hat keine spielbare Karten.");
            return null;
        }
    }


    /**
     * Durchläuft die Hand und überprüft ob eine spielbare Karte einer bestimmt Art existiert
     * @param aktuelleKarte - Karte mit der verglichen wird, ob die Karte spielbar ist
     * @param kartenArt - String um die Art der Karte zu identifizieren ("PlusZwei","Aussetzen","Wunsch","PlusVierWunsch","Retour","Farb")
     * @return - boolean True: Spielbare Karte in der Hand | False: Keine spielbare Karte dieser Art auf der Hand
     */
    public boolean existiertKarte(Karte aktuelleKarte, String kartenArt){
        for(int i = 0; i < hand.length;i++){
            if(hand[i] != null && hand[i].istWelcheKarte(kartenArt) && hand[i].istSpielbar(aktuelleKarte)){
                return true;
            }
        }
        return false;
    }


    /**
     * Durchläuft die Hand und findet eine spielbare Karte einer bestimmten Art
     * @param aktuelleKarte - Karte mir der verglichen wird, ob die karte spielbar ist
     * @param kartenArt - String um die Art der Karte zu identifiezieren ("PlusZwei","Aussetzen","Wunsch","PlusVierWunsch","Retour","Farb")
     * @return - Karte: passende Karte | Null: falls doch keine Karte gefunden wird... dürfte eigentlich nicht passieren
     */
    public Karte findKarte(Karte aktuelleKarte,String kartenArt, Spielfeld spielfeld){
        for(int i = 0; i < hand.length; i++){
            if(hand[i] != null && hand[i].istWelcheKarte(kartenArt) && hand[i].istSpielbar(aktuelleKarte)){
            	Karte ausgewaehlteKarte = hand[i]; 
                // Karte auf der Hand auf null setzen
            	karteAufNullSetzen(i);
                // DummyKarte auf Spielfeld auf null setzen
                spielfeld.dummyKarteAufNullsetzen(i);
                // Ausgewählte Karte zurückgeben
                return ausgewaehlteKarte;
            }
        }
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
                return;
            }
        }
        // Falls die Hand schon voll ist
        System.out.println("Hand ist voll!");
    }
    
    
    /**
    *
    * @return maxZahl
    */
    public int neueFarbeAuswaehlen() {
    	String farbe = "";
    	int[] farben = new int[4];
    	for(Karte k : hand) {
        	if(k != null) {
            	farbe = k.getFarbe();
            }
            switch(farbe) {
            	case "blau":
                	farben[0] += 1;
                	break;
                case "gelb":
                	farben[1] += 1;
                	break;
                case "gruen":
                	farben[2] += 1;
                	break;
                case "rot":
                	farben[3] += 1;
                	break;
            }
        }
        // Index von der maximalen Anzahl von Karten
        int maxZahl = -1;
        int index = -1;
        for(int i = 0; i < farben.length; i++) {
        	if(farben[i] >= maxZahl) {
            	maxZahl = farben[i];
            }
        }
        for(int i = 0; i < farben.length; i++) {
        	if(farben[i] == maxZahl) {
            	index = i;
            }
        }
    	return index;
    }

} // Ende von KISchlau
