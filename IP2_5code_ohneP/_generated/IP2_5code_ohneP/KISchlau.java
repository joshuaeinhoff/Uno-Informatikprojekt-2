

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
     * @return Karte zum Spielen<br>
     <br>*/
    public Karte karteSpielen(Karte aktuelleKarte, KartenStapel kartenStapel, boolean karteGezogen){
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
            karteZiehen(kartenStapel, aktuelleKarte);
            return karteSpielen(aktuelleKarte, kartenStapel, true);
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
        for(int i = 0; i < hand.length; i++){
            if(hand[i].istWelcheKarte(kartenArt)&&hand[i].istSpielbar(aktuelleKarte)){
                return hand[i];
            }
        }
        return null;
    }

} // Ende von KISchlau
