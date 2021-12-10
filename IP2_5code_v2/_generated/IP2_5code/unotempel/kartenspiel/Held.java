package unotempel.kartenspiel;

/**<br>
 * Klasse Held stellt einen menschlichen Spieler dar<br>
 <br>*/
public class Held extends Spieler {

    /**<br>
     * Konstruktor ruft Superkonstruktor auf und erzeugt einen menschlichen Spieler mit 100 Punkten Lebensenergie<br>
     <br>*/
    public Held(){
        super(100);
    }

    /**<br>
     * Funktion zum Spielen einer Karte<br>
     * @param aktuelleKarte - Aktuelle Karte im Spiel<br>
     * @param kartenStapel - KartenStapel<br>
     * @param karteGezogen - Karte wird schon gezogen<br>
     * @return Karte zum Spielen<br>
     <br>*/
    public Karte karteSpielen(Karte aktuelleKarte, KartenStapel kartenStapel, boolean karteGezogen){
        return null;
    }

} // Ende von Held