package unotempel.kartenspiel;

import unotempel.grafikkonsole.*;
import unotempel.GUI;

/** 2.6 FarbKarte   <br>
 * FarbKarte stellt eine Karte mit einer bestimmten Farbe und einer bestimmten Nummer dar<br>
 <br>*/
public class FarbKarte extends Karte{

	/** 2.6.1 Daten als Instanz-Variablen definieren   <br>*/
    Rechteck karteform;
    Text zahl;


    /** 2.6.2 Konstruktor erstellen   <br>
     * Konstruktor erzeugt einer Farbkarte mit den folgenden Eigenschaften<br>
     * @param farbe - Farbe: blau, gelb, gr&uuml;n oder rot<br>
     * @param nummer - Nummer: Zahl von 0 bis 9<br>
     <br>*/
    public FarbKarte(String farbe, int nummer){
        super(farbe, nummer);
    }


    /**<br>
     * Funktion gibt zur&uuml;ck, ob die Karte eine FarbKarte ist<br>
     * @param kartenart - Art der Karte<br>
     * @return true - falls die KartenArt passt, false - sonst<br>
     <br>*/
    @Override
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("Farb");
    }


	/**<br>
    * Prozedur erzeugt die visuelle Darstellung einer Karte und verteckt sie direkt danach<br>
    <br>*/
    @Override 
	public void erzeugeVisuelleKarte(String farbe) {
    	// Fallunterscheidung
    	switch(farbe) {
    		case "gruen":
        		farbe = GUI.FARBE_GRUEN;
        		break;
    		case "blau":
        		farbe = GUI.FARBE_BLAU;
        		break;
            case "gelb":
                farbe = GUI.FARBE_GELB;
                break;
            case "rot":
                farbe = GUI.FARBE_ROT;
                break;
		}
    	// Variablen Werte zuweisen
    	this.karteform = new Rechteck(0, 0, 50, 100, farbe, GUI.FARBE_WEISS, 2, 10, "");
        this.zahl = new Text(10, 2, nummer+"", GUI.FARBE_WEISS, 50, "");
        // Karte verstecken
        versteckeKarte();
    }


    /**<br>
     * Prozedur setzt die Karte auf die gegebene Position und macht diese sichtbar<br>
     * @param spalte - Koordinate auf der X-Achse im Spielfeld (2x2-KarteArray)<br>
     * @param zeile - Koordinate auf der Y-Achse im Spielfeld (2x2-KarteArray)<br>
     * @param x - Koordinate auf der X-Achse f&uuml;r die Darstellung<br>
     * @param y - Koordinate auf der Y-Achse f&uuml;r die Darstellung<br>
     * @param istAktuelleKarte - true, wenn die Karte die aktuelle Karte im Spiel entspricht - false, sonst<br>
     <br>*/
    @Override
    public void setzeKarteAuf(int spalte, int zeile, int x, int y, boolean istAktuelleKarte) {
        // Variablen verschieben
        this.karteform.moveTo(x,y);
        this.zahl.moveTo(x+10,y+2);
        // Variablen anzeigen
        this.karteform.show();
        this.zahl.show();
        // Pr??fen, ob die Karte nicht die aktuelle Karte ist
        if(!istAktuelleKarte) {
            // Reaktion einsetzen
            this.karteform.setCallback(spalte+"");
            this.zahl.setCallback(spalte+"");
        } else {
        	// Reaktion aussetzen
            this.karteform.setCallback("");
            this.zahl.setCallback("");
        }
    }


    /**<br>
     * Prozedur versteckt eine Karte<br>
     <br>*/
    @Override
    public void versteckeKarte() {
        // Variablen verstecken
        this.karteform.hide();
        this.zahl.hide();
    }


    /**<br>
     * Funktion zum Durchf&uuml;hren der Aktion einer speziellen Karte, gibt den Code f??r die Aktion zur??ck<br>
     * @return int - Code f&uuml;r die Aktion<br>
     <br>*/
    @Override
    public int aktionDurchfuehren() {
        // Code 0: Nichts machen
        return 0;
    }
    

    /**<br>
     * Funktion gibt die Karte als String zur&uuml;ck<br>
     * @return String - Karte, Farbe und Nummer<br>
     <br>*/
    @Override
    public String toString(){
    	return "FarbKarte in der Farbe "+this.farbe+" und der Nummer "+this.nummer;
    }
    
	
} // Ende von FarbKarte