package unotempel.kartenspiel;

/**
 * 
 */
public class KISchlau extends Spieler{
    

    KISchlau(int _lebensenergie){
        super(_lebensenergie);
    }

    public Karte karteSpielen(Karte aktuelleKarte, KartenStapel kartenStapel, boolean karteGezogen){
        //ist AussetzenKarte spielbar?ist RetourKarte spielbar?
        //ist 2+ Spielbar?
        //ist Farbkarte Spielbar?
        //+4 Wunschkarte Spielbar?
        //Wunschkarte Spielbar?
        //sonst karte ziehen
        if(existiertAussetzen(aktuelleKarte)){
            return findAussetzenKarte(aktuelleKarte);
        }else if(existiertRetourKarte(aktuelleKarte)){
            return findRetourKarte(aktuelleKarte);
        }else if(existiertPlusZwei(aktuelleKarte)){
            return findPlusZwei(aktuelleKarte);
        }else if(existiertFarbKarte(aktuelleKarte)){
            return findFarbKarte(aktuelleKarte);
        }else if(existiertPlusVierWunschKarte(aktuelleKarte)){
            return findPlusVierWunschKarte(aktuelleKarte);
        }else if(existiertWunschKarte(aktuelleKarte)){
            return findWunschKarte(aktuelleKarte);
        } else if(karteGezogen != true){
            karteZiehen(kartenStapel);
            return karteSpielen(aktuelleKarte, kartenStapel, true);
        }else{
            return null;
        }
        
    }

    public boolean existiertPlusZwei(Karte aktuelleKarte){
        for(int i = 0; i < hand.length;i++){
            if(hand[i].istWelcheKarte("PlusZwei")&&hand[i].istSpielbar(aktuelleKarte)){
                return true;
            }
        }
        return false;
    }

    public boolean existiertAussetzen(Karte aktuelleKarte){
        for(int i = 0; i < hand.length;i++){
            if(hand[i].istWelcheKarte("Aussetzen")&&hand[i].istSpielbar(aktuelleKarte)){
                return true;
            }
        }
        return false;
    }

    public boolean existiertWunschKarte(Karte aktuelleKarte){
        for(int i = 0; i < hand.length;i++){
            if(hand[i].istWelcheKarte("Wunsch")&&hand[i].istSpielbar(aktuelleKarte)){
                return true;
            }
        }
        return false;
    }

    public boolean existiertPlusVierWunschKarte(Karte aktuelleKarte){
        for(int i = 0; i < hand.length;i++){
            if(hand[i].istWelcheKarte("PlusVierWunsch")&&hand[i].istSpielbar(aktuelleKarte)){
                return true;
            }
        }
        return false;
    }

    public boolean existiertRetourKarte(Karte aktuelleKarte){
        for(int i = 0; i < hand.length;i++){
            if(hand[i].istWelcheKarte("Retour")&&hand[i].istSpielbar(aktuelleKarte)){
                return true;
            }
        }
        return false;
    }

    public boolean existiertFarbKarte(Karte aktuelleKarte){
        for(int i = 0; i < hand.length;i++){
            if(hand[i].istWelcheKarte("Farb")&&hand[i].istSpielbar(aktuelleKarte)){
                return true;
            }
        }
        return false;
    }

    public Karte findPlusZwei(Karte aktuelleKarte){
        for(int i = 0; i < hand.length; i++){
            if(hand[i].istWelcheKarte("PlusZwei")&&hand[i].istSpielbar(aktuelleKarte)){
                return hand[i];
            }
        }
        return null;
    }
    public Karte findAussetzenKarte(Karte aktuelleKarte){
        for(int i = 0; i < hand.length; i++){
            if(hand[i].istWelcheKarte("Aussetzen")&&hand[i].istSpielbar(aktuelleKarte)){
                return hand[i];
            }
        }
        return null;
    }

    public Karte findRetourKarte(Karte aktuelleKarte){
        for(int i = 0; i < hand.length; i++){
            if(hand[i].istWelcheKarte("Retour")&hand[i].istSpielbar(aktuelleKarte)){
                return hand[i];
            }
        }
        return null;
    }

    public Karte findFarbKarte(Karte aktuelleKarte){
        for(int i = 0; i < hand.length; i++){
            if(hand[i].istWelcheKarte("Farb")&&hand[i].istSpielbar(aktuelleKarte)){
                return hand[i];
            }
        }
        return null;
    }
    public Karte findPlusVierWunschKarte(Karte aktuelleKarte){
        for(int i = 0; i < hand.length; i++){
            if(hand[i].istWelcheKarte("PlusVierWunsch")&&hand[i].istSpielbar(aktuelleKarte)){
                return hand[i];
            }
        }
        return null;
    }

    public Karte findWunschKarte(Karte aktuelleKarte){
        for(int i = 0; i < hand.length; i++){
            if(hand[i].istWelcheKarte("Wunsch")&&hand[i].istSpielbar(aktuelleKarte)){
                return hand[i];
            }
        }
        return null;
    }


}//end of KISchlau
