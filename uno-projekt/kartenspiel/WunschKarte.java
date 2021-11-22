package kartenspiel;

/**
 * Der Spieler, der diese Karte legt, entscheidet welche Farbe als nächstes gelegt werden soll. WunschKarten kann man immer legen, 
 * das heißt man muss nicht auf die Farbe der vorherigen Karte achten. Wenn eine WunschKarte zu Beginn des Spiels gezogen wird, 
 * entscheidet der Spieler, der anfangen darf, welche Farbe als nächstes gelegt werden soll.
 */
public class WunschKarte extends Karte{

    public WunschKarte(String _farbe, int _id){
        super(_farbe, _id);
    }
    public boolean istPlusZweiKarte(){
        return false;
    }
    public boolean istFarbKarte(){
        return false;
    }
    public boolean istPlusVierWunschKarte(){
        return false;
    }
    public boolean istWunschKarte(){
        return true;
    }
    public boolean istAussetzenKarte(){
        return false;
    }
    public boolean istRetourKarte(){
        return false;
    }
    public boolean istDummyKarte(){
        return false;
    }
    
    
}//end of WunschKarte
