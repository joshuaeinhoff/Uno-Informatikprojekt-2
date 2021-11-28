package unotempel.kartenspiel;

/**
 * Die abstrakte Klasse Karte beinhaltet allgemeine Eigenschaften (z.B. Farbe) und Funktionen einer Karte.
 * Die speziellen Karten erben von dieser Klasse.
 */
public abstract class Karte {

    // Eigenschaften: Eine Karte hat eine bestimmte Farbe und eine Nummer
    public String farbe;
    public int nummer;


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
     * Dies ist der Fall, wenn die Nummer und/oder Farbe der abgelegten Karte mit der Karte auf dem Kartenstapel übereinstimmt
     * (oder wenn die abgelegte Karte die Farbe schwarz hat) -> das kann nicht passieren da vorher eine Farbe ausgewählt werden muss
     * @param aktuelleKarte - Aktuelle Karte im Spiel
     * @return true - falls die Karte gespielt werden kann, false - sonst
     */
    public boolean istSpielbar(Karte aktuelleKarte){
        if(this.nummer == aktuelleKarte.nummer || this.farbe.equals(aktuelleKarte.farbe) || aktuelleKarte.farbe.equals("schwarz")){ // ich glaube die 3. Bedingung kann nie passieren
            return true;
        }
        return false;
    }


    /**
     * Funktion gibt zurück, ob die Karte eine bestimmte Karte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     */
    public abstract boolean istWelcheKarte(String kartenart);


    /**
     * Funktion zum Durchführen der Aktion einer speziellen Karte
     * @return int - Code für die Aktion
     */
    public abstract int aktionDurchfuehren();


    public void clickAuf(){
        //code..
    }


//    String[] unoFarben = {"rot", "blau", "gelb", "gruen", "schwarz"};
//
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



} // Ende von Karte