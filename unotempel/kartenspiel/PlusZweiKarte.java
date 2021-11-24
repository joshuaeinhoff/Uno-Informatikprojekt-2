package unotempel.kartenspiel;

/**
 * Wenn diese Karte gelegt wird, muss der Gegenspieler 2 Karten ziehen und darf in dieser Runde keine Karten ablegen. 
 * Diese Karte kann nur auf eine Karte mit entsprechender Farbe oder andere ZiehZweiKarten gelegt werden. 
 * Wenn sie zu Beginn des Spiels aufgedeckt wird, gelten dieselben Regeln.  
 */
public class PlusZweiKarte extends Karte{
    
    /**
     * Konstruktor mit default-Wert: Nummer 12
     * @param farbe - Farbe der Karte: Blau, gelb, grün oder rot
     */
    public PlusZweiKarte(String farbe){
        super(farbe, 12);
    }


    /**
     *
     * @param kartenart
     * @return
     */
    public boolean istWelcheKarte(String kartenart){
        if(kartenart.equals("PlusZwei")){
            return true;
        }
        return false;
    }


    /**
     * Prozedur zum Durchführen der Aktion einer speziellen Karte
     */
    @Override
    public void aktionDurchfuehren() {
        // 2 Karte ziehen
        
    }

}//end of PlusZweiKarte
