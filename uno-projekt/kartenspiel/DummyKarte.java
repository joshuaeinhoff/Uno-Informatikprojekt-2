package kartenspiel;

/**
 * Soll später als Dummy genutzt werden um die Anzahl der gegnerischen Karten zu zeigen
 */
public class DummyKarte extends Karte{

    public DummyKarte(String _farbe, int _id){
        super(_farbe, _id);
    }
    
    
    
    public boolean istWelcheKarte(String kartenart){
        if(kartenart.equals("Dummy")){
            return true;
        }
        return false;
    }


}//end of DummyKarte
