package unotempel.kartenspiel;

/**<br>
 * Klasse KIZufall stellt einen komplizierten KI-Gegner dar<br>
 <br>*/
public class KISchlau extends Spieler{

    /**<br>
     * Konstruktor ruft Superkonstruktor auf<br>
     * @param _lebensenergie - Lebensenergie des Monsters<br>
     <br>*/
    KISchlau(int _lebensenergie){
        super(_lebensenergie);
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
        if(existiertKarte(aktuelleKarte,"Aussetzen")){  
            return findKarte(aktuelleKarte,"Aussetzen");
        }else if(existiertKarte(aktuelleKarte, "Retour")){
            return findKarte(aktuelleKarte,"Retour");
        }else if(existiertKarte(aktuelleKarte,"PlusZwei")){
            return findKarte(aktuelleKarte,"PlusZwei");
        }else if(existiertKarte(aktuelleKarte,"Farb")){
            return findKarte(aktuelleKarte,"Farb");
        }else if(existiertKarte(aktuelleKarte,"PlusVierWunsch")){
            return findKarte(aktuelleKarte,"PlusVierWunsch");
        }else if(existiertKarte(aktuelleKarte,"Wunsch")){
            return findKarte(aktuelleKarte,"Wunsch");
        } else if(!karteGezogen){
            karteZiehen(kartenStapel, aktuelleKarte,spielfeld);
            return karteSpielen(aktuelleKarte, kartenStapel, true,spielfeld);
        }else{
            return null;
        }
    }


    /**<br>
     * Durchl&auml;uft die Hand und &uuml;berprüft ob eine spielbare Karte einer bestimmt Art existiert<br>
     * @param aktuelleKarte - Karte mit der verglichen wird, ob die Karte spielbar ist<br>
     * @param kartenArt - String um die Art der Karte zu identifizieren ("PlusZwei","Aussetzen","Wunsch","PlusVierWunsch","Retour","Farb")<br>
     * @return - boolean True: Spielbare Karte in der Hand | False: Keine spielbare Karte dieser Art auf der Hand<br>
     <br>*/
    public boolean existiertKarte(Karte aktuelleKarte, String kartenArt){
        for(int i = 0; i < hand.length;i++){
            if(hand[i].istWelcheKarte(kartenArt)&&hand[i].istSpielbar(aktuelleKarte)){
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
    public Karte findKarte(Karte aktuelleKarte,String kartenArt){
        for(int i = 0; i < anzahlKarteHand(); i++){
            if(hand[i].istWelcheKarte(kartenArt)&&hand[i].istSpielbar(aktuelleKarte)){
            	// Karte auf der Hand auf null setzen
            	karteAufNullSetzen(i);
                return hand[i];
            }
        }
        return null;
    }
    

    /**<br>
     * Prozedur zum Ziehen der Karten<br>
     * @param kartenStapel<br>
     * @param aktuelleKarte<br>
     * @param spielfeld<br>
     <br>*/
    public void karteZiehen(KartenStapel kartenStapel, Karte aktuelleKarte, Spielfeld spielfeld){
        //OOP2
        //hand.get(kartenStapel.karteZiehen());
        
        // Solange der Spieler noch Platz für Karten in der Hand hat, d.h. die Hand ist nicht voll
        for(int i = 0; i < hand.length; i++){
        	// Bedingung überprüft, ob die Karte in der Hand null ist, d.h. keine echte Karte an dieser Stelle
            if(hand[i] == null){
            	// Gezogene Karte aus dem Stapel in der Hand hinzufügen
                hand[i] = kartenStapel.karteZiehen(aktuelleKarte);
                // Aktualisiere Karte auf Spielfeld
                spielfeld.setzeKartePosition(hand[i],0,i);
                return;
            }
        }
        // Falls die Hand schon voll ist
        System.out.println("Hand ist voll!");
    }

} // Ende von KISchlau
