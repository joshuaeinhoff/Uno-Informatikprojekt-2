package unotempel.kartenspiel;

import unotempel.GUI;

/**<br>
 * Klasse KIZufall stellt einen komplizierten KI-Gegner dar<br>
 <br>*/
public class KISchlau extends Spieler{

    /**<br>
     * Konstruktor ruft Superkonstruktor auf<br>
     * @param _lebensenergie - Lebensenergie des Monsters<br>
     <br>*/
    public KISchlau(int _lebensenergie){
        super(_lebensenergie);
    }


    /**<br>
     * Prozedur zum Ziehen der Karten<br>
     * @param kartenStapel<br>
     * @param aktuelleKarte<br>
     * @param spielfeld<br>
     <br>*/
    @Override
    public void karteZiehen(KartenStapel kartenStapel, Karte aktuelleKarte, Spielfeld spielfeld, GUI gui){
        // Solange der Spieler noch Platz für Karten in der Hand hat, d.h. die Hand ist nicht voll
        for(int i = 0; i < hand.length; i++){
        	// Bedingung überprüft, ob die Karte in der Hand null ist, d.h. keine echte Karte an dieser Stelle
            if(hand[i] == null){
            	// Gezogene Karte aus dem Stapel in der Hand hinzufügen
                hand[i] = kartenStapel.karteZiehen(aktuelleKarte);
                // Aktualisiere Karte auf Spielfeld
                spielfeld.setzeKartePosition(new DummyKarte(),0,i,gui);
                return;
            }
        }
        // Falls die Hand schon voll ist
        System.out.println("Hand ist voll!");
    }


    /**<br>
     * Funktion zum Spielen einer Karte<br>
     * @param aktuelleKarte - Aktuelle Karte im Spiel<br>
     * @param kartenStapel - KartenStapel<br>
     * @param karteGezogen - Karte wird schon gezogen<br>
     * @param spielfeld<br>
     * @return Karte zum Spielen<br>
     <br>*/
    @Override
    public Karte karteSpielen(Karte aktuelleKarte, KartenStapel kartenStapel, boolean karteGezogen, Spielfeld spielfeld, GUI gui){
        // Fallunterscheidung
        // Prüfen, ob Spieler KI eine AussetzenKarte hat
        if(existiertKarte(aktuelleKarte,"Aussetzen"))
            // Karte suchen und zurückgeben  
            return findKarte(aktuelleKarte,"Aussetzen",spielfeld);
        // Prüfen, ob Spieler KI eine RetourKarte hat
        if(existiertKarte(aktuelleKarte, "Retour"))
            // Karte suchen und zurückgeben
            return findKarte(aktuelleKarte,"Retour",spielfeld);
        // Prüfen, ob Spieler KI eine PlusZweiKarte hat
        if(existiertKarte(aktuelleKarte,"PlusZwei"))
            // Karte suchen und zurückgeben
            return findKarte(aktuelleKarte,"PlusZwei",spielfeld);
            // Prüfen, ob Spieler KI eine FarbKarte hat
        if(existiertKarte(aktuelleKarte,"Farb"))
            // Karte suchen und zurückgeben
            return findKarte(aktuelleKarte,"Farb",spielfeld);
            // Prüfen, ob Spieler KI eine PlusVierWunschKarte hat
        if(existiertKarte(aktuelleKarte,"PlusVierWunsch"))
            // Karte suchen und zurückgeben
            return findKarte(aktuelleKarte,"PlusVierWunsch",spielfeld);
            // Prüfen, ob Spieler KI eine WunschKarte hat
        if(existiertKarte(aktuelleKarte,"Wunsch"))
            // Karte suchen und zurückgeben
            return findKarte(aktuelleKarte,"Wunsch",spielfeld);
        // Prüfen, ob Spieler KI keine Karte abgezogen hat
        if(!karteGezogen) {
        	System.out.println("KI zieht eine Karte ab.");
            // Karte ziehen
            karteZiehen(kartenStapel, aktuelleKarte,spielfeld,gui);
            // Karte Spielen Funktion rekursiv aufrufen mit true als Parameter da abgezogene Karte
            return karteSpielen(aktuelleKarte, kartenStapel, true, spielfeld,gui);
        }
        // Spieler KI hat keine spielbare Karten auf der Hand
        System.out.println("KI hat keine spielbare Karten.");
        return null;
        
    }


    /**<br>
     * Abstrakte Funktion zur Auswahl einer neuen Farben<br>
     * @param gui - Graphical User Interface<br>
     * @return int - Code der ausgew&auml;hlten Farbe<br>
     <br>*/
    @Override
    public int neueFarbeAuswaehlen(GUI gui) {
        // Farbe String
    	String farbe = "";
        // Array von Integer für die Farben
    	int[] farben = new int[4];
        // Über die Karten auf der Hand iterieren
    	for(Karte k : hand) {
            // Prüfen, ob die Karte eine echte Karte ist
        	if(k != null) {
                // Farbe speichern
            	farbe = k.farbe;
            }
            // Fallunterscheidung: Index auf Int-Array je nach Farbe inkrementieren
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
        // Variablen für die höchsten Anzahl von Karten und den Index
        int hoechsteAnzahl = -1;
        int indexAufArray = -1;
        // Suchen Index mit der höchsten Anzahl von Karten
        for(int i = 0; i < farben.length; i++) {
            // Prüfen, ob die gespeicherte Zahl an dieser Stelle größer oder gleich als die höchste Anzahl ist
        	if(farben[i] >= hoechsteAnzahl) {
            	hoechsteAnzahl = farben[i];
                indexAufArray = i;
            }
        }
        
        // Index auf dem Farben(String)-Array von maximalen Anzahl an Karten zurückgeben
    	return indexAufArray;
    }


    /**<br>
     * Durchl&auml;uft die Hand und &uuml;berprüft ob eine spielbare Karte einer bestimmt Art existiert<br>
     * @param aktuelleKarte - Karte mit der verglichen wird, ob die Karte spielbar ist<br>
     * @param kartenArt - String um die Art der Karte zu identifizieren ("PlusZwei","Aussetzen","Wunsch","PlusVierWunsch","Retour","Farb")<br>
     * @return - boolean True: Spielbare Karte in der Hand | False: Keine spielbare Karte dieser Art auf der Hand<br>
     <br>*/
    public boolean existiertKarte(Karte aktuelleKarte, String kartenArt) {
        for(int i = 0; i < hand.length;i++){
            if(hand[i] != null && hand[i].istWelcheKarte(kartenArt) && hand[i].istSpielbar(aktuelleKarte)){
                return true;
            }
        }
        return false;
    }


    /**<br>
     * Durchl&auml;uft die Hand und findet eine spielbare Karte einer bestimmten Art<br>
     * @param aktuelleKarte - Karte mir der verglichen wird, ob die karte spielbar ist<br>
     * @param kartenArt - String um die Art der Karte zu identifiezieren ("PlusZwei","Aussetzen","Wunsch","PlusVierWunsch","Retour","Farb")<br>
     * @return - Karte: passende Karte | Null: falls doch keine Karte gefunden wird... d&uuml;rfte eigentlich nicht passieren<br>
     <br>*/
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
    

} // Ende von KISchlau
