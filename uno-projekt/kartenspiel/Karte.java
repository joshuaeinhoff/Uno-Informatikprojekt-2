package kartenspiel;

/**
 * 
 */
public abstract class Karte {

    private String farbe;
    private int nummer;

    /**
     * Kann später als Superkonstruktor aufgerufen werden
     * @param farbe
     */
    public Karte(String _farbe){
        this.farbe = _farbe;
    }
	
    void setzeAussehen(){
        //...
    }
    void setzePosition(){
        //...
    }

    /**
     * Prüft, ob eine Karte korrekt abgelegt wurde. 
     * Dies ist der Fall, wenn die Nummer und/oder Farbe der abgelegten Karte mit der Karte auf dem Kartenstapel übereinstimmt
     * oder wenn die abgelegte Karte die Farbe schwarz hat.
     * @param andereKarte
     * @return
     */
    public boolean istSpielbar(Karte andereKarte){
        if(this.nummer == andereKarte.nummer || this.farbe == andereKarte.farbe || andereKarte.farbe == "Schwarz"){
            return true;
        }
        return false;
    }

    public void clickAuf(){
        //code..
    }

    public abstract boolean istPlusZweiKarte();
    public abstract boolean istFarbKarte();
    public abstract boolean istPlusVierWunschKarte();
    public abstract boolean istWunschKarte();
    public abstract boolean istAussetzenKarte();
    public abstract boolean istRetourKarte();
    public abstract boolean istDummyKarte();


}//end of Karte