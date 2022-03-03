package unotempel.kartenspiel;

import unotempel.*;

/**<br>
 * Die abstrakte Klasse Karte beinhaltet allgemeine Eigenschaften (z.B. Farbe) und Funktionen einer Karte.<br>
 * Die speziellen Karten erben von dieser Klasse.<br>
 <br>*/
public abstract class Karte {

    // Eigenschaften einer Karte
    protected String farbe;
    protected int nummer;


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
    public boolean istSpielbar(Karte aktuelleKarte){
        if(this.nummer == aktuelleKarte.nummer || this.farbe.equals(aktuelleKarte.farbe) || this.farbe.equals("schwarz")){
            return true;
        }
        return false;
    }


    /**<br>
     * Prozedur zum Setzen einer neuen Farbe f&uuml;r die Karte<br>
     * Nur f&uuml;r WunschKarte und PlusVierWunschKarte -&gt; &Uuml;berlegen ob hier oder in den Subklassen<br>
     * @param neueFarbe<br>
     <br>*/
   	public void setzeFarbe(String neueFarbe) {
   		this.farbe = neueFarbe;
        System.out.println("Die neue Farbe der Karte ist " + this.farbe);
    }


    /**<br>
     * Funktion gibt die Farbe einer Karte zur&uuml;ck<br>
     * @return farbe als String<br>
     <br>*/
    public String getFarbe(){
    	return farbe;
    }
    

    /**<br>
     * Funktion gibt die Nummer einer Karte zur&uuml;ck<br>
     * @return nummer als int<br>
     <br>*/
    public int getNummer(){
    	return nummer;
    }
    

    /**<br>
     * ????<br>
     <br>*/
    public void clickAuf(){
        //code..
    }


    /*** Abstrakte Prozeduren und Funktionen **<br>*/

    /**<br>
     * Abstrakte Funktion gibt zur&uuml;ck, ob die Karte eine bestimmte Karte ist<br>
     * @param kartenart - Art der Karte<br>
     * @return true - falls die KartenArt passt, false - sonst<br>
     <br>*/
    public abstract boolean istWelcheKarte(String kartenart);

	/**<br>
    * Abstrakte Prozedur erzeugt die visuelle Darstellung einer Karte und verteckt sie direkt danach<br>
    <br>*/  
	public abstract void erzeugeVisuelleKarte(String farbe);
    /**<br>
     * Abstrakte Prozedur setzt die Karte auf die gegebene Position und macht diese sichtbar<br>
     <br>*/
    public abstract void setzeKarteAuf(int j, int i, int x, int y, boolean istAktuelleKarte);
    /**<br>
     * Abstrakte Prozedur versteckt eine Karte<br>
     <br>*/
    public abstract void versteckeKarte();

    /**<br>
     * Abstrakte Funktion zum Durchf&uuml;hren der Aktion einer speziellen Karte<br>
     * @return int - Code f&uuml;r die Aktion<br>
     <br>*/
    public abstract int aktionDurchfuehren();

    /**<br>
     * Abstrakte Funktion gibt die Karte als String zur&uuml;ck<br>
     <br>*/
    public abstract String toString();

} // Ende von Karte