package unotempel.kartenspiel;

import unotempel.GUI;

/** Der Spieler, der diese Karte legt, entscheidet welche Farbe als nächstes gelegt werden soll.
 * Zudem muss der Gegenspieler vier Karten von dem Kartenstapel ziehen.
 */
public class PlusVierWunschKarte extends Karte{
    
    /**
     * Konstruktor mit default-Werten: Farbe schwarz und Nummer 14
     */
    public PlusVierWunschKarte(){
        super("schwarz", 14);
    }

    /**
     *
     * @param kartenart
     * @return
     */
    public boolean istWelcheKarte(String kartenart){
        if(kartenart.equals("PlusVierWunsch")){
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
        // 4 Karte Ziehen
    }

    /**
     * Prozedur zum Setzen der ausgewählten Farbe
     * @param farbe
     */
    private void setzeFarbe(String farbe) {
        this.farbe = farbe;
    }
    
    
}//end of PlusVierWunschKarte
