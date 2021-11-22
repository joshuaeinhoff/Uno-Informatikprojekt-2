package kartenspiel;

/**
 * Nachdem ein Spieler diese Karte gelegt hat, wird der Gegenspieler „übersprungen“ und derjenige, der die Karte gelegt hat, darf nochmal legen. 
 * Wenn diese Karte zu Beginn des Spiels gezogen wird, dann muss derjenige, der anfängt, aussetzen und der Gegenspieler darf beginnen.   
 */
public class AussetzenKarte extends Karte{

    public AussetzenKarte(String _farbe, int id){
        super(_farbe, id);
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
