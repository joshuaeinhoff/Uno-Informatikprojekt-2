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

<<<<<<< HEAD
    /** Prüft, ob eine Karte korrekt abgelegt wurde. 
     * Eine Karte wurde richtig abgelegt, wenn die Nummer und/oder Farbe der abgelegten Karte mit der Karte auf dem Kartenstapel übereinstimmt
     * oder wenn die abgelegte Karte die Farbe schwarz hat.
=======
    /** Prüft, ob eine Karte richtig abgelegt wurde, d.h. ob Nummer und/oder Farbe mit der Karte auf dem Kartenstapel
     * übereinstimmt
     * 
>>>>>>> 54d7a6e5d1f06f737c49c33209c859c0346854b8
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