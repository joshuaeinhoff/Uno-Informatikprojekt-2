package unotempel.kartenspiel;

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
     * @return Karte zum Spielen
     */
    public Karte karteSpielen(Karte aktuelleKarte, KartenStapel kartenStapel, boolean karteGezogen){
        return null;
    }

}//end of Held
