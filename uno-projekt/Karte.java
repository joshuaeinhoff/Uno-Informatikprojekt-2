/**
 * 
 */
abstract class Karte {

    private String farbe;

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

    boolean isPlayable(){
        //...
        return false;
    }

    public void clickAuf(){
        //code..
    }

}//end of Karte