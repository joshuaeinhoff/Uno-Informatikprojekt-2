package kartenspiel;
public class KISchlau extends Spieler{
    

    KISchlau(int _lebensenergie){
        super(_lebensenergie);
    }

    public Karte karteSpielen(Karte aktuelleKarte, KartenStapel kartenStapel, boolean karteGezogen){
        //ist 2+ Spielbar?ist AussetzenKarte spielbar?ist RetourKarte spielbar?
        //ist Farbkarte Spielbar?
        //+4 Wunschkarte Spielbar?Wunschkarte Spielbar?
        int karteAnzahl = hand.length;
        if(karteGezogen != true){

        }
        return null;
    }

    public boolean existiertPlusZwei(Karte aktuelleKarte){
        for(int i = 0; i < hand.length;i++){
            if(hand[i].istPlusZweiKarte()&&hand[i].istSpielbar(aktuelleKarte)){
                return true;
            }
        }
        return false;
    }

    public boolean existiertAussetzen(Karte aktuelleKarte){
        for(int i = 0; i < hand.length;i++){
            if(hand[i].istAussetzenKarte()&&hand[i].istSpielbar(aktuelleKarte)){
                return true;
            }
        }
        return false;
    }

    public boolean existiertWunschKarte(Karte aktuelleKarte){
        for(int i = 0; i < hand.length;i++){
            if(hand[i].istWunschKarte()&&hand[i].istSpielbar(aktuelleKarte)){
                return true;
            }
        }
        return false;
    }

    public boolean existiertPlusVierWunschKarte(Karte aktuelleKarte){
        for(int i = 0; i < hand.length;i++){
            if(hand[i].istPlusVierWunschKarte()&&hand[i].istSpielbar(aktuelleKarte)){
                return true;
            }
        }
        return false;
    }

    public boolean existiertRetourKarte(Karte aktuelleKarte){
        for(int i = 0; i < hand.length;i++){
            if(hand[i].istRetourKarte()&&hand[i].istSpielbar(aktuelleKarte)){
                return true;
            }
        }
        return false;
    }

    public boolean existiertFarbKarte(Karte aktuelleKarte){
        for(int i = 0; i < hand.length;i++){
            if(hand[i].istFarbKarte()&&hand[i].istSpielbar(aktuelleKarte)){
                return true;
            }
        }
        return false;
    }

    public Karte findPlusZwei(Karte aktuelleKarte){
        for(int i = 0; i < hand.length; i++){
            if(hand[i].istPlusZweiKarte()&&hand[i].istSpielbar(aktuelleKarte)){
                return hand[i];
            }
        }
        return null;
    }


}//end of KISchlau
