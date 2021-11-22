package kartenspiel;

/**
 *
 */
public class WunschKarte extends Karte{

    public WunschKarte(String _farbe){
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
