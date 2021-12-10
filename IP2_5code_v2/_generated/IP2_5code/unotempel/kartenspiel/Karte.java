package unotempel.kartenspiel;

/**<br>
 * Die abstrakte Klasse Karte beinhaltet allgemeine Eigenschaften (z.B. Farbe) und Funktionen einer Karte.<br>
 * Die speziellen Karten erben von dieser Klasse.<br>
 <br>*/
public abstract class Karte {

    // Eigenschaften: Eine Karte hat eine bestimmte Farbe und eine Nummer
    protected String farbe;
    protected int nummer;


    /**<br>
     * Superkonstruktor f&uuml;r alle Subklassen<br>
     * @param farbe - Farbe der Karte<br>
     * @param nummer - Nummer der Karte<br>
     <br>*/
    public Karte(String farbe, int nummer) {
        this.farbe = farbe;
        this.nummer = nummer;
    }


    /**<br>
     * Funktion pr&uuml;ft, ob eine Karte korrekt abgelegt werden kann.<br>
     * Dies ist der Fall, wenn die Nummer und/oder Farbe der abgelegten Karte mit der Karte auf dem Kartenstapel &uuml;bereinstimmt<br>
     * (oder wenn die abgelegte Karte die Farbe schwarz hat) -&gt; das kann nicht passieren da vorher eine Farbe ausgew&auml;hlt werden muss<br>
     * @param aktuelleKarte - Aktuelle Karte im Spiel<br>
     * @return true - falls die Karte gespielt werden kann, false - sonst<br>
     <br>*/
    public boolean istSpielbar(Karte aktuelleKarte){
        if(this.nummer == aktuelleKarte.nummer || this.farbe.equals(aktuelleKarte.farbe) || aktuelleKarte.farbe.equals("schwarz")){ // ich glaube die 3. Bedingung kann nie passieren
            return true;
        }
        return false;
    }


    /**<br>
     * Funktion gibt zur&uuml;ck, ob die Karte eine bestimmte Karte ist<br>
     * @param kartenart - Art der Karte<br>
     * @return true - falls die KartenArt passt, false - sonst<br>
     <br>*/
    public abstract boolean istWelcheKarte(String kartenart);


    /**<br>
     * Funktion zum Durchf&uuml;hren der Aktion einer speziellen Karte<br>
     * @return int - Code f&uuml;r die Aktion<br>
     <br>*/
    public abstract int aktionDurchfuehren();


    public void clickAuf(){
        //code..
    }
    
    public String getFarbe(){
    	return farbe;
    }
    
    public int getNummer(){
    	return nummer;
    }
    
    public abstract String toString();

} // Ende von Karte