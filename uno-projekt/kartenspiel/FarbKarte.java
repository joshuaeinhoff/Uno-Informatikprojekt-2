package kartenspiel;

/*
*
*/
public class FarbKarte extends Karte{

    public FarbKarte(String _farbe, int _id){
        super(_farbe, _id);
    }

    public boolean istWelcheKarte(String kartenart){
        if(kartenart.equals("Farb")){
            return true;
        }
        return false;
    }

}//end of FarbKarte