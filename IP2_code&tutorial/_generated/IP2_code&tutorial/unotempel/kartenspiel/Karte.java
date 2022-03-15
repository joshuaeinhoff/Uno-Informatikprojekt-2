package unotempel.kartenspiel;

import unotempel.GUI;

/**<br>
 * Die abstrakte Klasse Karte beinhaltet allgemeine Eigenschaften (z.B. Farbe) und Funktionen einer Karte.<br>
 * Die speziellen Karten erben von dieser Klasse.<br>
 <br>*/
public abstract class Karte {

    // Eigenschaften einer Karte
    String farbe;
    int nummer;


    /**<br>
     * Superkonstruktor f&uuml;r alle Subklassen<br>
     * @param farbe - Farbe der Karte<br>
     * @param nummer - Nummer der Karte<br>
     <br>*/
    public Karte(String farbe, int nummer) {
        this.farbe = farbe;
        this.nummer = nummer;
    }


    /**<br>
     * Funktion pr&uuml;ft, ob eine Karte korrekt abgelegt werden kann.<br>
     * Dies ist der Fall, wenn die Nummer und/oder Farbe der ausgew&auml;hlten Karte mit der Karte auf dem AblageStapel &uuml;bereinstimmt<br>
     * oder wenn die ausgew&auml;hlte Karte die Farbe schwarz hat<br>
     * @param aktuelleKarte - Aktuelle Karte im Spiel<br>
     * @return true, falls die Karte gespielt werden kann - false, sonst<br>
     <br>*/
    public boolean istSpielbar(Karte aktuelleKarte) {
        if(this.nummer == aktuelleKarte.nummer || this.farbe.equals(aktuelleKarte.farbe) || this.farbe.equals("schwarz")) {
            return true;
        }
        return false;
    }


    /**<br>
     * Prozedur zum Setzen einer neuen Farbe f&uuml;r die Karte<br>
     * Nur f&uuml;r WunschKarte und PlusVierWunschKarte -&gt; &Uuml;berlegen ob hier oder in den Subklassen<br>
     * @param neueFarbe<br>
     <br>*/
   	/*public void setzeFarbe(String neueFarbe) {
   		this.farbe = neueFarbe;
        System.out.println("Die neue Farbe der Karte ist " + this.farbe + ".");
    } */


    /*** Abstrakte Prozeduren und Funktionen **<br>*/

    /**<br>
     * Abstrakte Funktion gibt zur&uuml;ck, ob die Karte eine bestimmte Karte ist<br>
     * @param kartenart - Art der Karte<br>
     * @return true - falls die KartenArt passt, false - sonst<br>
     <br>*/
    public abstract boolean istWelcheKarte(String kartenart);

	/**<br>
    * Abstrakte Prozedur erzeugt die visuelle Darstellung einer Karte und versteckt sie direkt danach<br>
    * @param farbe - Farbe einer Karte<br>
    <br>*/  
	public abstract void erzeugeVisuelleKarte(String farbe);
    
    /**<br>
     * Abstrakte Prozedur setzt die Karte auf die gegebene Position und macht diese sichtbar<br>
     * @param spalte - Koordinate auf der X-Achse im Spielfeld (2x2-KarteArray)<br>
     * @param zeile - Koordinate auf der Y-Achse im Spielfeld (2x2-KarteArray)<br>
     * @param x - Koordinate auf der X-Achse f&uuml;r die Darstellung<br>
     * @param y - Koordinate auf der Y-Achse f&uuml;r die Darstellung<br>
     * @param istAktuelleKarte - true, wenn die Karte die aktuelle Karte im Spiel entspricht - false, sonst<br>
     <br>*/
    public abstract void setzeKarteAuf(int spalte, int zeile, int x, int y, boolean istAktuelleKarte);
    
    /**<br>
     * Abstrakte Prozedur versteckt eine Karte<br>
     <br>*/
    public abstract void versteckeKarte();

    /**<br>
     * Abstrakte Funktion zum Durchf&uuml;hren der Aktion einer speziellen Karte<br>
     * @return int - Code f&uuml;r die Aktion<br>
     * 0: Nichts machen<br>
     * 1: N&auml;chster Spieler &uuml;berspringen<br>
     * 2: Zwei Karte ziehen<br>
     * 3: Eine neue Farbe ausw&auml;hlen<br>
     * 4: Vier Karten ziehen<br>
     <br>*/
    public abstract int aktionDurchfuehren();

    /**<br>
     * Abstrakte Funktion gibt die Karte als String zur&uuml;ck<br>
     * @return String<br>
     <br>*/
    public abstract String toString();

} // Ende von Karte