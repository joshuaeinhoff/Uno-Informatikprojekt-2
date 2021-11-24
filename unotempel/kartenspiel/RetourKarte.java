package unotempel.kartenspiel;

/**
 * Bei dieser Karte ändert sich die Spielrichtung. Wenn diese Karte zu Beginn des Spiels gezogen wird, muss der Spieler, der 
 * anfangen darf, aussetzten und sein Gegenspieler darf anfangen.   
 */
public class RetourKarte extends Karte{

    /**
     * Konstruktor mit default-Wert: Nummer 11
     * @param _farbe
     */
    public RetourKarte(String _farbe){
        super(_farbe, 11);
    }


    /**
     * Prüft, ob die Karte gelegt werden darf.
     * -> Die Karte kann nur auf eine entsprechende Farbe oder eine andere RetourKarte gelegt werden.
     */
    public boolean istSpielbar(Karte andereKarte){
        // die Retourkarte bekommt eine bestimmte id und ist somit einfacher zu identifizieren 
        if(this.farbe == andereKarte.farbe || this.nummer == andereKarte.nummer){
            return true;
        }
        return false;
    }

    /**
     *
     * @param kartenart
     * @return
     */
    public boolean istWelcheKarte(String kartenart){
        if(kartenart.equals("Retour")){
            return true;
        }
        return false;
    }

    
    /**
     * Prozedur zum Durchführen der Aktion einer speziellen Karte
     */
    @Override
    public void aktionDurchfuehren() {
        // Nächster Spieler überspringen
        
    }
    
    
}//end of RetourKarte
