package unotempel.kartenspiel;

import unotempel.*;

/**
 * Die abstrakte Klasse Karte beinhaltet allgemeine Eigenschaften (z.B. Farbe) und Funktionen einer Karte.
 * Die speziellen Karten erben von dieser Klasse.
 */
public abstract class Karte {

    // Eigenschaften einer Karte
    protected String farbe;
    protected int nummer;


    /**
     * Superkonstruktor für alle Subklassen
     * @param farbe - Farbe der Karte
     * @param nummer - Nummer der Karte
     */
    public Karte(String farbe, int nummer) {
        this.farbe = farbe;
        this.nummer = nummer;
    }


    /**
     * Funktion prüft, ob eine Karte korrekt abgelegt werden kann.
     * Dies ist der Fall, wenn die Nummer und/oder Farbe der ausgewählten Karte mit der Karte auf dem AblageStapel übereinstimmt
     * oder wenn die ausgewählte Karte die Farbe schwarz hat
     * @param aktuelleKarte - Aktuelle Karte im Spiel
     * @return true, falls die Karte gespielt werden kann - false, sonst
     */
    public boolean istSpielbar(Karte aktuelleKarte){
        if(this.nummer == aktuelleKarte.nummer || this.farbe.equals(aktuelleKarte.farbe) || this.farbe.equals("schwarz")){
            return true;
        }
        return false;
    }


    /**
     * Prozedur zum Setzen einer neuen Farbe für die Karte
     * Nur für WunschKarte und PlusVierWunschKarte -> Überlegen ob hier oder in den Subklassen
     * @param neueFarbe
     */
   	public void setzeFarbe(String neueFarbe) {
   		this.farbe = neueFarbe;
        System.out.println("Die neue Farbe der Karte ist " + this.farbe);
    }


    /**
     * Funktion gibt die Farbe einer Karte zurück
     * @return farbe als String
     */
    public String getFarbe(){
    	return farbe;
    }
    

    /**
     * Funktion gibt die Nummer einer Karte zurück
     * @return nummer als int
     */
    public int getNummer(){
    	return nummer;
    }
    

    /**
     * ????
     */
    public void clickAuf(){
        //code..
    }


    /*** Abstrakte Prozeduren und Funktionen ***/

    /**
     * Abstrakte Funktion gibt zurück, ob die Karte eine bestimmte Karte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     */
    public abstract boolean istWelcheKarte(String kartenart);

	/**
    * Abstrakte Prozedur erzeugt die visuelle Darstellung einer Karte und verteckt sie direkt danach
    */  
	public abstract void erzeugeVisuelleKarte(String farbe);
    /**
     * Abstrakte Prozedur setzt die Karte auf die gegebene Position und macht diese sichtbar
     */
    public abstract void setzeKarteAuf(int j, int i, int x, int y, boolean istAktuelleKarte);
    /**
     * Abstrakte Prozedur versteckt eine Karte
     */
    public abstract void versteckeKarte();

    /**
     * Abstrakte Funktion zum Durchführen der Aktion einer speziellen Karte
     * @return int - Code für die Aktion
     */
    public abstract int aktionDurchfuehren();

    /**
     * Abstrakte Funktion gibt die Karte als String zurück
     */
    public abstract String toString();

} // Ende von Karte