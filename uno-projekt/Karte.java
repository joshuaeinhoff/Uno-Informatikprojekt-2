/**
 * 
 */
abstract class Karte {

    private int zeile;
    private int spalte;
    private String farbe;
	
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

}