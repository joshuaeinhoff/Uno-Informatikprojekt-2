package kartenspiel;

/*
*
*/
public class FarbKarte extends Karte{

    public FarbKarte(String _farbe, int _id){
        super(_farbe, _id);
    }

    public boolean istPlusZweiKarte(){
        return false;
    }
    public boolean istFarbKarte(){
        return true;
    }
    public boolean istPlusVierWunschKarte(){
        return false;
    }
    public boolean istWunschKarte(){
        return false;
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

}//end of FarbKarte