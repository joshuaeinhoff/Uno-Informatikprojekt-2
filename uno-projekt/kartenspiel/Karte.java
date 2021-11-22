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

    /** Prüft, ob eine Karte richtig abgelegt wurde, d.h. ob Nummer und/oder Farbe mit der Karte auf dem Kartenstapel
     * übereinstimmt
     * 
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

}//end of Karte