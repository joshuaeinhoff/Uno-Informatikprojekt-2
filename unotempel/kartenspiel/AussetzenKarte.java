package unotempel.kartenspiel;

/**
 * Nachdem ein Spieler diese Karte gelegt hat, wird der Gegenspieler „übersprungen“ und derjenige, der die Karte gelegt hat, darf nochmal legen. 
 * Wenn diese Karte zu Beginn des Spiels gezogen wird, dann muss derjenige, der anfängt, aussetzen und der Gegenspieler darf beginnen.   
 */
public class AussetzenKarte extends Karte {

    /**
     * Konstruktor mit default-Wert: Nummer 10
     * @param farbe - Farbe der Karte: Blau, gelb, grün oder rot
     */
    public AussetzenKarte(String farbe){
        super(farbe, 10);
    }

    /**
     * Prüft, ob die Karte abgelegt werden kann. 
     * -> Die Karte kann nur auf eine andere mit entsprechender Farbe oder eine andere AussetzenKarte gelegt werden. 
     */
    public boolean istSpielbar(Karte andereKarte){
        // die Aussetzenkarte bekommt eine bestimmte id und ist somit einfacher zu identifizieren 
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
        if(kartenart.equals("Aussetzen")){
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

} // End von AussetzenKarte
