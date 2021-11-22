package kartenspiel;

/**
 * Soll später als Dummy genutzt werden um die Anzahl der gegnerischen Karten zu zeigen
 */
public class DummyKarte extends Karte{

    public DummyKarte(String _farbe, int _id){
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
        return false;
    }
    public boolean istAussetzenKarte(){
        return false;
    }
    public boolean istRetourKarte(){
        return false;
    }
    public boolean istDummyKarte(){
        return true;
    }
    

}//end of DummyKarte
