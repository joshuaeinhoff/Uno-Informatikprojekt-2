package kartenspiel;

/**
 *
 */
public class AussetzenKarte extends Karte{

    public AussetzenKarte(String _farbe){
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
        return true;
    }
    public boolean istRetourKarte(){
        return false;
    }
    public boolean istDummyKarte(){
        return false;
    }
    
}//end of AussetzenKarte
