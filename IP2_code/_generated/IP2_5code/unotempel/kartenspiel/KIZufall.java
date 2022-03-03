package unotempel.kartenspiel;

/**<br>
 * Klasse KIZufall stellt einen einfachen KI-Gegner dar<br>
 <br>*/
public class KIZufall extends Spieler{

    /**<br>
     * Konstruktor ruft Superkonstruktor auf<br>
     * @param _lebensenergie - Lebensenergie des Monsters<br>
     <br>*/
    KIZufall(int _lebensenergie){
        super(_lebensenergie);
    }


    /**<br>
     * Funktion zum Spielen einer Karte<br>
     * @param aktuelleKarte - Aktuelle Karte im Spiel<br>
     * @param kartenStapel - KartenStapel<br>
     * @param karteGezogen - Karte wird schon gezogen<br>
     * @return Karte zum Spielen<br>
     <br>*/
    public Karte karteSpielen(Karte aktuelleKarte, KartenStapel kartenStapel,boolean karteGezogen){
        //int kartenAnzahl = hand.length;

        // Wenn der Spieler noch spielbare Karten auf der Hand hat
        if(spielbareKarteVorhanden(aktuelleKarte)){
            //int randomInteger = KartenStapel.getRandomInt(0, kartenAnzahl);
            // ich finde folgendes besser, weil Karten in der Hand mit KartenStapel nichts zu tun haben
            // --> (int)(Math.random() * (max - min + 1)) + min;
            int zufallszahl = (int) (Math.random() * (hand.length + 1));
            Karte temp = hand[zufallszahl];
            //Karte temp = hand[randomInteger];
            // Wenn eine Karte zufällig ausgewählt wird und die Karte gespielt werden kann
            if(temp != null && temp.istSpielbar(aktuelleKarte)){
                // Karte zurückgeben
                return temp;
            }else{
                // Rekursiver Aufruf der Funktion karteSpielen()
                karteSpielen(aktuelleKarte, kartenStapel,false);
            }
        // Wenn der Spieler keine spielbare Karte hat und in seinem Zug noch keine Karte gezogen hat
        }else if(!karteGezogen){
            // Karte ziehen
            karteZiehen(kartenStapel, aktuelleKarte);
            // Versuch Karte zu spielen, diesmal karteGezogen wird auf true gesetzt
            karteSpielen(aktuelleKarte, kartenStapel,true);
        // Wenn der Spieler keine spielbare Karte hat und schon eine Karte gezogen hat
        }else{
            // Null zurückgeben
            return null;
        }
        return null;
    }

} // Ende von KIZufall