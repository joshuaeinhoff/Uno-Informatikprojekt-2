package unotempel.kartenspiel;

/**
 * Die abstrakte Klasse Karte beinhaltet allgemeine Eigenschaften (z.B. Farbe) und Funktionen einer Karte.
 * Die speziellen Karten erben von dieser Klasse.
 */
public abstract class Karte {

    // Eigenschaften: Eine Karte hat eine bestimmte Farbe und einer Nummer
    public String farbe;
    public int nummer;

//    String[] unoFarben = {"rot", "blau", "gelb", "gruen", "schwarz"};

    /**
     * Kann später als Superkonstruktor aufgerufen werden
     * @param farbe
     */
    public Karte(String _farbe, int nummer) {
        this.farbe = _farbe;
        this.nummer = nummer;
    }
	

//    /** Aussehen der Karte setzen mit einer zufälligen Farbe */
//    void setzeAussehen(String _farbe) {
//        // wenn "zufall" als Farbe angegeben wird, soll die Methode zufallsFarbe aufgerufen werden
//        if(_farbe.equals("zufall")) {
//            _farbe = zufallsFarbe(); // Zufallsfarbe
//         }
//
//         for(int i = 0; i < unoFarben.length; i++) {
//             if(_farbe.equals(unoFarben[i])) {
//                 this.farbe = _farbe;
//             }
//        }
//    }
//
//    /** Füllen des Arrays mit Karten zufälliger Farbe */
//    public String zufallsFarbe() {
//        // das sind die Uno-Farben, die wird haben
//        String[] unoFarben = {"rot", "blau", "gruen", "gelb", "schwarz"};
//        // aus dem oben definierten Array soll jetzt zufällg eine Farbe zurückgegeben werden
//        int zufall = zufallsZahl(unoFarben.length);
//        return unoFarben[zufall-1];
//    }
//
//    /** Gibt eine Zufallszahl zwischen 1 und max zurück. Dies brauchen wir, um eine zufällige Farbe zurückzubekommen.
//	* Im Fehlerfall gibt sie eine 1 zurück.
//	* @param max maximaler Wert der Zufallszahl, muss grösser als 1 sein
//	*/
//    public int zufallsZahl(int max) {
//        if(max > 1) {
//        	return 1+((int)(Math.random()*max));
//        } else {
//        	return 1;
//        }
//
//    }


    /**
     * Prüft, ob eine Karte korrekt abgelegt wurde. 
     * Dies ist der Fall, wenn die Id und/oder Farbe der abgelegten Karte mit der Karte auf dem Kartenstapel übereinstimmt
     * oder wenn die abgelegte Karte die Farbe schwarz hat.
     * 
     * @param andereKarte
     * @return
     */
    public boolean istSpielbar(Karte andereKarte){
        if(this.nummer == andereKarte.nummer || this.farbe == andereKarte.farbe || andereKarte.farbe == "schwarz"){
            return true;
        }
        return false;
    }

    public void clickAuf(){
        //code..
    }

    public abstract boolean istWelcheKarte(String kartenart);

    public abstract void aktionDurchfuehren();


}//end of Karte