package unotempel.kartenspiel;

/**
 *
 <br>*/
public class FarbKarte extends Karte{

    /**
     * Konstruktor erzeugt einer Farbkarte mit den folgenden Eigenschaften
     * @param farbe - Farbe: blau, gelb, gr&uuml;n oder rot
     * @param nummer - Nummer: Zahl von 0 bis 9
     <br>*/
    public FarbKarte(String farbe, int nummer){
        super(farbe, nummer);
    }


    /**
     * Funktion gibt zur&uuml;ck, ob die Karte eine FarbKarte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     <br>*/
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Farb");
    }


    /**
     * Funktion zum Durchf&uuml;hren der Aktion einer speziellen Karte
     * @return int - Code f&uuml;r die Aktion
     <br>*/
    @Override
    public int aktionDurchfuehren() {
        // Code 0: Nichts machen
        return 0;
    }
    
    public String toString(){
    	return "FarbKarte in der Farbe "+this.farbe+" und der Nummer "+this.nummer;
    }

} // Ende von FarbKarte