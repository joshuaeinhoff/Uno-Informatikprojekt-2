package kartenspiel;
public class KIZufall extends Spieler{
    
    KIZufall(int _lebensenergie){
        super(_lebensenergie);
    }

    /**
     * Spielt eine zufällige Karten
     * @return zufällige Karte aus der "Hand" des Computergegners
     */
    public Karte karteSpielen(Karte aktuelleKarte, KartenStapel kartenStapel,boolean karteGezogen){
        int kartenAnzahl = hand.length;
        if(karteGezogen != true){
            if(spielbareKarteVorhanden(aktuelleKarte)){
                int randomInteger = KartenStapel.getRandomInt(0, kartenAnzahl);
                Karte temp = hand[randomInteger];
                if(temp.istSpielbar(aktuelleKarte)){
                    return temp;
                }else{
                    karteSpielen(aktuelleKarte, kartenStapel,false);
                }
            }else{
                //keine Karte auf der Hand die gezogen werden kann
                karteZiehen(kartenStapel);
                //karteSpielen aufgerufen
                karteSpielen(aktuelleKarte, kartenStapel,true);
            }
        }else{
            //gezogene Karte ist spielbar
            if(spielbareKarteVorhanden(aktuelleKarte)){
                //suchvorgang nach der Karte
                int randomInteger = KartenStapel.getRandomInt(0, kartenAnzahl);
                Karte temp = hand[randomInteger];
                if(temp.istSpielbar(aktuelleKarte)){
                    return temp;
                }else{
                    karteSpielen(aktuelleKarte, kartenStapel,true);
                }
            }else{
                //gezogene Karte ist nicht spielbar
                return null;
                //ende des Zuges
            }
        }
        return null;
    }
}//end of KIZufall
