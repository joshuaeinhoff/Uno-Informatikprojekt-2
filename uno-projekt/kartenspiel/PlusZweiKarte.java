package kartenspiel;

/**
 * Wenn diese Karte gelegt wird, muss der Gegenspieler 2 Karten ziehen und darf in dieser Runde keine Karten ablegen. 
 * Diese Karte kann nur auf eine Karte mit entsprechender Farbe oder andere ZiehZweiKarten gelegt werden. 
 * Wenn sie zu Beginn des Spiels aufgedeckt wird, gelten dieselben Regeln.  
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
