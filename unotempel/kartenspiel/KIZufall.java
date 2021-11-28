package unotempel.kartenspiel;

/**
 * Klasse KIZufall stellt einen einfachen KI-Gegner dar
 */
public class KIZufall extends Spieler{

    /**
     * Konstruktor ruft Superkonstruktor auf
     * @param _lebensenergie - Lebensenergie des Monsters
     */
    KIZufall(int _lebensenergie){
        super(_lebensenergie);
    }


    /**
     * Funktion zum Spielen einer Karte
     * @param aktuelleKarte - Aktuelle Karte im Spiel
     * @param kartenStapel - KartenStapel
     * @param karteGezogen - Karte wird schon gezogen
     * @return Karte zum Spielen
     */
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
