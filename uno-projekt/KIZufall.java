public class KIZufall extends Spieler{
    
    KIZufall(int _lebensenergie){
        super(_lebensenergie);
    }

    /**
     * Spielt eine zufällige Karten
     * @return zufällige Karte aus der "Hand" des Computergegners
     */
    public Karte karteSpielen(Karte aktuelleKarte, KartenStapel kartenStapel){
        int kartenAnzahl = hand.size();
        if(spielbareKarteVorhanden(aktuelleKarte)){
            int randomInteger = KartenStapel.getRandomInt(0, kartenAnzahl);
            Karte temp = hand.get(randomInteger);
            if(temp.istSpielbar(aktuelleKarte)){
                return temp;
            }else{
                karteSpielen(aktuelleKarte, kartenStapel);
            }
        }else{
            karteZiehen(kartenStapel);
            karteSpielen(aktuelleKarte, kartenStapel);
            //Karte die gezogen wird darf noch gelegt werden sonst ende des Zugs
            
        }
        return null;
    }
}//end of KIZufall
