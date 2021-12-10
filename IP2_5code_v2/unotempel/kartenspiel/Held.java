package unotempel.kartenspiel;

import unotempel.konsole.Konsole;
import unotempel.GUI;

/**
 * Klasse Held stellt einen menschlichen Spieler dar
 */
public class Held extends Spieler {

    /**
     * Konstruktor ruft Superkonstruktor auf und erzeugt einen menschlichen Spieler mit 100 Punkten Lebensenergie
     */
    public Held(){
        super(100);
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
        // Variable den Index der ausgewählte Karte zuweisen   
        int indexKarte;
       	String verschieben;                
        // Solange der Spieler noch spielbare Karten hat
		while(spielbareKarteVorhanden(aktuelleKarte)) {       
        	/*
            verschieben = Konsole.eingabeString();
            System.out.println(verschieben);
            while(verschieben.compareTo("links") == 0 || verschieben.compareTo("rechts") == 0) {

				if(verschieben.compareTo("links") == 0) {
                    for(int j = 0; j < 10; j++) {
                        if(hand[j] != null) {
                            spielfeld.setzeKartePosition(hand[j],j,3);
                        } else {
                        	System.out.println("Du hast links keine Karten mehr!");
                        }
                    }
                }    
                if(verschieben.compareTo("rechts") == 0) {
                    for(int j = 10; j < 20; j++) {
                        if(hand[j] != null) {
                            spielfeld.setzeKartePosition(hand[j],j,4);
                        } else {
                        	System.out.println("Du hast rechts keine Karten mehr!");
                            break;
                        }
                    }
                }
            }
            */
            // Karte durch die Grafik Konsole auswählen
        	indexKarte = Konsole.eingabeZahl();
            //
           
			// Prüfen, ob die ausgewählte Karte gespielt werden kann
            if(getKarte(indexKarte).istSpielbar(aktuelleKarte)) {
            	// Ja, ausgewählte Karte als Variable speichern
            	Karte ausgewaehlteKarte = getKarte(indexKarte);
            	// Karte auf der Hand auf null setzen
                karteAufNullSetzen(indexKarte);
                // Ausgewählte Karte wird zurückgegeben
                System.out.println("Held hat " + ausgewaehlteKarte.toString() + " ausgewählt!");
                return ausgewaehlteKarte;
            } else {
            	// Nein, Fehlermeldung auf die Konsole ausgeben
                System.out.println("Wähle bitte eine geeignete Karte!");
            }
        }
        
        // Solange der Spieler noch keine Karte gezogen hat
        while(!karteGezogen) {
        	System.out.println("Held hat keine spielbare Karten und muss daher eine Karte ziehen.");
        	String eingabe = Konsole.eingabeString();
            // Prüfen, ob der Spieler auf den KartenStapel geklickt hat
            
        	if(eingabe.compareTo("karteZiehen") == 0) {
            	// Karte ziehen
                karteZiehen(kartenStapel, aktuelleKarte,spielfeld);
                
                // Versuch Karte zu spielen, diesmal karteGezogen wird auf true gesetzt
                karteGezogen = true;
                return karteSpielen(aktuelleKarte,kartenStapel,karteGezogen,spielfeld);
            } else {
            	// Nein, Fehlermeldung auf die Konsole ausgeben
                System.out.println("Ziehe bitte eine Karte ab.");
            }
        
        }
        System.out.println("Held hat keine spielbare Karten.");
        // Null zurückgeben, falls keine spielbare Karte vorhanden
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
                spielfeld.setzeKartePosition(hand[i],3,i);
                return;
            }       
        }
        // Meldung auf die Konsol, falls die Hand schon voll ist
        System.out.println("Hand ist voll!");
    }

} // Ende von Held