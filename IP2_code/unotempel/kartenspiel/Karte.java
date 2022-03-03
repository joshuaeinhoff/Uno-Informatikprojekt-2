package unotempel.kartenspiel;

import unotempel.GUI;

/**
 * Die abstrakte Klasse Karte beinhaltet allgemeine Eigenschaften (z.B. Farbe) und Funktionen einer Karte.
 * Die speziellen Karten erben von dieser Klasse.
 */
public abstract class Karte {

    // Eigenschaften einer Karte
    String farbe;
    int nummer;


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
    public boolean istSpielbar(Karte aktuelleKarte) {
        if(this.nummer == aktuelleKarte.nummer || this.farbe.equals(aktuelleKarte.farbe) || this.farbe.equals("schwarz")) {
            return true;
        }
        return false;
    }


    /**
     * Prozedur zum Setzen einer neuen Farbe für die Karte
     * Nur für WunschKarte und PlusVierWunschKarte -> Überlegen ob hier oder in den Subklassen
     * @param neueFarbe
     */
   	/*public void setzeFarbe(String neueFarbe) {
   		this.farbe = neueFarbe;
        System.out.println("Die neue Farbe der Karte ist " + this.farbe + ".");
    } */


    /*** Abstrakte Prozeduren und Funktionen ***/

    /**
     * Abstrakte Funktion gibt zurück, ob die Karte eine bestimmte Karte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     */
    public abstract boolean istWelcheKarte(String kartenart);

	/**
    * Abstrakte Prozedur erzeugt die visuelle Darstellung einer Karte und verteckt sie direkt danach
    * @param farbe - Farbe einer Karte
    */  
	public abstract void erzeugeVisuelleKarte(String farbe);
    
    /**
     * Abstrakte Prozedur setzt die Karte auf die gegebene Position und macht diese sichtbar
     * @param spalte - Koordinate auf der X-Achse im Spielfeld (2x2-KarteArray)
     * @param zeile - Koordinate auf der Y-Achse im Spielfeld (2x2-KarteArray)
     * @param x - Koordinate auf der X-Achse für die Darstellung
     * @param y - Koordinate auf der Y-Achse für die Darstellung
     * @param istAktuelleKarte - true, wenn die Karte die aktuelle Karte im Spiel entspricht - false, sonst
     */
    public abstract void setzeKarteAuf(int spalte, int zeile, int x, int y, boolean istAktuelleKarte);
    
    /**
     * Abstrakte Prozedur versteckt eine Karte
     */
    public abstract void versteckeKarte();

    /**
     * Abstrakte Funktion zum Durchführen der Aktion einer speziellen Karte
     * @return int - Code für die Aktion
     * 0: Nichts machen
     * 1: Nächster Spieler überspringen
     * 2: Zwei Karte ziehen
     * 3: Eine neue Farbe auswählen
     * 4: Vier Karten ziehen
     */
    public abstract int aktionDurchfuehren();

    /**
     * Abstrakte Funktion gibt die Karte als String zurück
     * @return String
     */
    public abstract String toString();

} // Ende von Karte