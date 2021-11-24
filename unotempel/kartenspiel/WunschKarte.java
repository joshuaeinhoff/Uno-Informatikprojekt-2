package unotempel.kartenspiel;

import unotempel.GUI;

/**
 * Der Spieler, der diese Karte legt, entscheidet welche Farbe als nächstes gelegt werden soll. WunschKarten kann man immer legen, 
 * das heißt man muss nicht auf die Farbe der vorherigen Karte achten. Wenn eine WunschKarte zu Beginn des Spiels gezogen wird, 
 * entscheidet der Spieler, der anfangen darf, welche Farbe als nächstes gelegt werden soll.
 */
public class WunschKarte extends Karte{

    /**
     * Konstruktor mit default-Werten: Farbe schwarz und Nummer 13
     */
    public WunschKarte(){
        super("schwarz", 13);
    }
    
    /**
     *
     * @param kartenart
     * @return
     */
    public boolean istWelcheKarte(String kartenart){
        if(kartenart.equals("")){
            return true;
        }
        return false;
    }


    /**
     * Prozedur zum Durchführen der Aktion einer speziellen Karte
     */
    @Override
    public void aktionDurchfuehren() {
        // Mithilfe der Grafik_Konsole eine neue Farbe auswählen
        String neueFarbe = GUI.farbeAuswaehlen();
        // noch überlegen
        setzeFarbe(farbe);
    }

    /**
     * Prozedur zum Setzen der ausgewählten Farbe
     * @param farbe
     */
    private void setzeFarbe(String farbe) {
        this.farbe = farbe;
    }
    
    
}//end of WunschKarte
