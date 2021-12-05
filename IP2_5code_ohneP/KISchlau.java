

/**
 * Klasse KIZufall stellt einen komplizierten KI-Gegner dar
 */
public class KISchlau extends Spieler{

    /**
     * Konstruktor ruft Superkonstruktor auf
     * @param _lebensenergie - Lebensenergie des Monsters
     */
    KISchlau(int _lebensenergie){
        super(_lebensenergie);
    }


    /**
     * Funktion zum Spielen einer Karte
     * @param aktuelleKarte - Aktuelle Karte im Spiel
     * @param kartenStapel - KartenStapel
     * @param karteGezogen - Karte wird schon gezogen
     * @return Karte zum Spielen
     */
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


    /**
     * Durchläuft die Hand und überprüft ob eine spielbare Karte einer bestimmt Art existiert
     * @param aktuelleKarte - Karte mit der verglichen wird, ob die Karte spielbar ist
     * @param kartenArt - String um die Art der Karte zu identifizieren ("PlusZwei","Aussetzen","Wunsch","PlusVierWunsch","Retour","Farb")
     * @return - boolean True: Spielbare Karte in der Hand | False: Keine spielbare Karte dieser Art auf der Hand
     */
    public boolean existiertKarte(Karte aktuelleKarte, String kartenArt){
        for(int i = 0; i < hand.length;i++){
            if(hand[i].istWelcheKarte(kartenArt)&&hand[i].istSpielbar(aktuelleKarte)){
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
    public Karte findKarte(Karte aktuelleKarte,String kartenArt){
        for(int i = 0; i < hand.length; i++){
            if(hand[i].istWelcheKarte(kartenArt)&&hand[i].istSpielbar(aktuelleKarte)){
                return hand[i];
            }
        }
        return null;
    }

} // Ende von KISchlau
