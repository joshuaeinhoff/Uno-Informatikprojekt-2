package kartenspiel;

/**
 *
 */
public class PlusZweiKarte extends Karte{
    
    public PlusZweiKarte(String _farbe){
        super(_farbe);
    }

    public boolean istPlusZweiKarte(){
        return true;
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
        return false;
    }
    public boolean istDummyKarte(){
        return false;
    }
    

}//end of PlusZweiKarte
