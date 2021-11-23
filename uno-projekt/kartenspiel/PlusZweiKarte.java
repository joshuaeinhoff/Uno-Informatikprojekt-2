package kartenspiel;

/**
 * Wenn diese Karte gelegt wird, muss der Gegenspieler 2 Karten ziehen und darf in dieser Runde keine Karten ablegen. 
 * Diese Karte kann nur auf eine Karte mit entsprechender Farbe oder andere ZiehZweiKarten gelegt werden. 
 * Wenn sie zu Beginn des Spiels aufgedeckt wird, gelten dieselben Regeln.  
 */
public class PlusZweiKarte extends Karte{
    
    public PlusZweiKarte(String _farbe, int _id){
        super(_farbe, _id);
    }

    
    public boolean istWelcheKarte(String kartenart){
        if(kartenart.equals("PlusZwei")){
            return true;
        }
        return false;
    }

}//end of PlusZweiKarte
