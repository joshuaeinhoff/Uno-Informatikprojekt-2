package kartenspiel;

/**
 * Nachdem ein Spieler diese Karte gelegt hat, wird der Gegenspieler „übersprungen“ und derjenige, der die Karte gelegt hat, darf nochmal legen. 
 * Wenn diese Karte zu Beginn des Spiels gezogen wird, dann muss derjenige, der anfängt, aussetzen und der Gegenspieler darf beginnen.   
 */
public class AussetzenKarte extends Karte{

    public AussetzenKarte(String _farbe, int _id){
        super(_farbe, _id);
    }

    /**
     * Prüft, ob die Karte abgelegt werden kann. 
     * -> Die Karte kann nur auf eine andere mit entsprechender Farbe oder eine andere AussetzenKarte gelegt werden. 
     */
    public boolean istSpielbar(Karte andereKarte){
        // die Aussetzenkarte bekommt eine bestimmte id und ist somit einfacher zu identifizieren 
        if(this.farbe == andereKarte.farbe || this.id == andereKarte.id){
            return true;
        }
        return false;
    }

    
    public boolean istWelcheKarte(String kartenart){
        if(kartenart.equals("Aussetzen")){
            return true;
        }
        return false;
    }

}//end of AussetzenKarte
