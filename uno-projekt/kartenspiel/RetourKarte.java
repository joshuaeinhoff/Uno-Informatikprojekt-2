package kartenspiel;

/**
 * Bei dieser Karte ändert sich die Spielrichtung. Wenn diese Karte zu Beginn des Spiels gezogen wird, muss der Spieler, der 
 * anfangen darf, aussetzten und sein Gegenspieler darf anfangen.   
 */
public class RetourKarte extends Karte{

    public RetourKarte(String _farbe, int _id){
        super(_farbe, _id);
    }

    /**
     * Prüft, ob die Karte gelegt werden darf.
     * -> Die Karte kann nur auf eine entsprechende Farbe oder eine andere RetourKarte gelegt werden.
     */
    public boolean istSpielbar(Karte andereKarte){
        // die Retourkarte bekommt eine bestimmte id und ist somit einfacher zu identifizieren 
        if(this.farbe == andereKarte.farbe || this.id == andereKarte.id){
            return true;
        }
        return false;
    }

    public boolean istWelcheKarte(String kartenart){
        if(kartenart.equals("Retour")){
            return true;
        }
        return false;
    }
    
    
}//end of RetourKarte
