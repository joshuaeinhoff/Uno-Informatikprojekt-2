package unotempel.kartenspiel;

import unotempel.GUI;

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
     * Prozedur zum Ziehen der Karten
     * @param kartenStapel
     * @param aktuelleKarte
     * @param spielfeld
     */
    @Override
    public void karteZiehen(KartenStapel kartenStapel, Karte aktuelleKarte, Spielfeld spielfeld, GUI gui){
        // Solange der Spieler noch Platz für Karten in der Hand hat, d.h. die Hand ist nicht voll
        for(int i = 0; i < hand.length; i++){
        	// Bedingung überprüft, ob die Karte in der Hand null ist, d.h. keine echte Karte an dieser Stelle
            if(hand[i] == null){
            	// Gezogene Karte aus dem Stapel in der Hand hinzufügen
                hand[i] = kartenStapel.karteZiehen(aktuelleKarte);
                // Aktualisiere Karte auf Spielfeld
                spielfeld.setzeKartePosition(new DummyKarte(),0,anzahlKarteHand()-1,gui);
                return;
            }
        }
        // Falls die Hand schon voll ist
        System.out.println("Hand ist voll!");
    }


    /**
     * Funktion zum Spielen einer Karte
     * @param aktuelleKarte - Aktuelle Karte im Spiel
     * @param kartenStapel - KartenStapel
     * @param karteGezogen - Karte wird schon gezogen
     * @param spielfeld
     * @return Karte zum Spielen
     */
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


    /**
     * Abstrakte Funktion zur Auswahl einer neuen Farben
     * @param gui - Graphical User Interface
     * @return int - Code der ausgewählten Farbe
     */
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


    /**
     * Durchläuft die Hand und überprüft ob eine spielbare Karte einer bestimmt Art existiert
     * @param aktuelleKarte - Karte mit der verglichen wird, ob die Karte spielbar ist
     * @param kartenArt - String um die Art der Karte zu identifizieren ("PlusZwei","Aussetzen","Wunsch","PlusVierWunsch","Retour","Farb")
     * @return - boolean True: Spielbare Karte in der Hand | False: Keine spielbare Karte dieser Art auf der Hand
     */
    public boolean existiertKarte(Karte aktuelleKarte, String kartenArt) {
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
                spielfeld.dummyKarteAufNullsetzen(anzahlKarteHand());
                // Ausgewählte Karte zurückgeben
                return ausgewaehlteKarte;
            }
        }
        return null;
    }   
    

} // Ende von KISchlau
