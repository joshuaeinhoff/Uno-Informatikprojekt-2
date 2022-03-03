package unotempel.kartenspiel;

import unotempel.konsole.Konsole;
import unotempel.GUI;

/**<br>
 * Klasse Held stellt einen menschlichen Spieler dar<br>
 <br>*/
public class Held extends Spieler {

	// Variable für die Darstellung der Karten
	int kartenVerschiebungsWert;


    /**<br>
     * Konstruktor ruft Superkonstruktor auf und erzeugt einen menschlichen Spieler mit 100 Punkten Lebensenergie<br>
     <br>*/
    public Held(){
        super(100);
        kartenVerschiebungsWert = 0;
    }


    /**<br>
     * Funktion zum Spielen einer Karte<br>
     * @param aktuelleKarte - Aktuelle Karte im Spiel<br>
     * @param kartenStapel - KartenStapel<br>
     * @param karteGezogen - Karte wird schon gezogen<br>
     * @param spielfeld<br>
     * @return Karte zum Spielen<br>
     <br>*/
    public Karte karteSpielen(Karte aktuelleKarte, KartenStapel kartenStapel, boolean karteGezogen,Spielfeld spielfeld){
        // Variable den Index der ausgewählte Karte zuweisen   
        int indexKarte;
       	//String verschieben;
        // Solange der Spieler noch spielbare Karten hat
        
		while(spielbareKarteVorhanden(aktuelleKarte)) {       
        	
            this.handVerschieben(spielfeld);
            // Karte durch die Grafik Konsole auswählen
        	indexKarte = Konsole.eingabeZahl();
            
            //
           	if(indexKarte != -1){
                // Prüfen, ob die ausgewählte Karte gespielt werden kann
                if(getKarte(indexKarte+kartenVerschiebungsWert) != null && getKarte(indexKarte+kartenVerschiebungsWert).istSpielbar(aktuelleKarte)) {
                    // Ja, ausgewählte Karte als Variable speichern
                    Karte ausgewaehlteKarte = getKarte(indexKarte+kartenVerschiebungsWert);
                    // Karte auf der Hand auf null setzen
                    karteAufNullSetzen(indexKarte+kartenVerschiebungsWert);
                    // Ausgewählte Karte wird zurückgegeben
                    return ausgewaehlteKarte;
                } else {
                    // Nein, Fehlermeldung auf die Konsole ausgeben
                    System.out.println("Wähle bitte eine geeignete Karte!");
                }
            }
        }
        
        // Solange der Spieler noch keine Karte gezogen hat
        while(!karteGezogen) {
        	this.handVerschieben(spielfeld);
        	System.out.println("Held hat keine spielbare Karten und muss daher eine Karte ziehen.");
        	String eingabe = Konsole.eingabeString();
            // Prüfen, ob der Spieler auf den KartenStapel geklickt hat
            
        	if(eingabe.equals("karteZiehen")) {
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
    
    
    /*
    * Prozedur zum Verschieben der Karten auf der Kand
    * @param spielfeld
    */
    public void handVerschieben(Spielfeld spielfeld){
    	// Variable für das Verschieben
    	String verschieben;
        // Prüfen, ob der Held Karten auf der Hand hat
    	if(anzahlKarteHand() > 0){
        	// Eingabe durch die Konsole lesen
        	verschieben = Konsole.eingabeString();
            // 
            if(verschieben.equals("links") && kartenVerschiebungsWert > 0){
            	kartenVerschiebungsWert--;
                spielfeld.kartenVerschobenDarstellen(kartenVerschiebungsWert,this);
            }
        	// 
            if(verschieben.equals("rechts") && kartenVerschiebungsWert < 10){
            	kartenVerschiebungsWert++;
            	spielfeld.kartenVerschobenDarstellen(kartenVerschiebungsWert,this);
            }
        } // end of while
    } // end of handVerschieben
    
    
    /**<br>
     * Prozedur zum Ziehen der Karten<br>
     * @param kartenStapel<br>
     * @param aktuelleKarte<br>
     * @param spielfeld<br>
     <br>*/
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
    
    
    public int neueFarbeAuswaehlen() {
    	// Mithilfe der Grafik_Konsole eine neue Farbe auswählen
    	return GUI.farbeAuswaehlen();
    }

} // Ende von Held