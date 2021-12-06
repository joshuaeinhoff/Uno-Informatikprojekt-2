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
    
    public String getFarbe(){
    	return farbe;
    }
    
    public int getNummer(){
    	return nummer;
    }

} // Ende von Karte