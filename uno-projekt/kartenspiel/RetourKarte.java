package kartenspiel;

/**
 *
 */
public class RetourKarte extends Karte{

    public RetourKarte(String _farbe){
        super(_farbe);
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
        return false;
    }
    public boolean istAussetzenKarte(){
        return false;
    }
    public boolean istRetourKarte(){
        return true;
    }
    public boolean istDummyKarte(){
        return false;
    }
    
    
}//end of RetourKarte
