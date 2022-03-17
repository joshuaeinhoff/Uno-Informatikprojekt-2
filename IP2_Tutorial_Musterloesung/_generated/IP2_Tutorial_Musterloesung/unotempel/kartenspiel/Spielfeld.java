package unotempel.kartenspiel;

import unotempel.GUI;
import unotempel.konsole.*;

/**<br>
 * Die Klasse Spielfeld stellt das Spielbrett f&uuml;r das Kartenspiel dar<br>
 <br>*/
public class Spielfeld {

	/** 4.1 Daten als Instanz-Variablen definieren  <br>*/
	// Spielfeld
    private Karte[][] spielfeld;
    // Größe des Spielfelds
    private int breite;
   	private int hoehe;


	/** 4.2 Konstruktor erstellen  <br>
     * Konstruktor erzeugt ein Spielfeld mit Platz f&uuml;r 5x10 Karten<br>
     <br>*/
    public Spielfeld(){
    	// ( Anzahl von Karten in Y-Richtung, Anzahl von Karten in X-Richtung)
        this.spielfeld = new Karte[5][10];
        this.breite = 660;
        this.hoehe = 450;
    }


    /** 4.3 Setzen einer Karte auf eine Position  <br>
     * Prozedur um Karte auf dem Spielfeld zu Platzieren<br>
     * X-Y-Koordinaten mit [0,0] oben links<br>
     * @param karte - Karte die &uuml;bergeben wird<br>
     * @param zeile - Y-Koordinate der Karte auf dem Spielfeld in int<br>
     * @param spalte - X-Koordinate der Karte auf dem Spielfeld in int<br>
     * @param gui - Graphical User Interface<br>
     <br>*/
    public void setzeKartePosition(Karte karte, int zeile, int spalte, GUI gui) {
        int neuSpalte = spalte;
        int neuZeile = zeile;
        if(spalte > 9) {
        	neuZeile += 1;
            neuSpalte %= 10;
        }
        // Karte auf das Spielfeld platzieren	      	
        spielfeld[neuZeile][neuSpalte] = karte; 
        // Variablen für die Darstellung berechnen
        if(zeile > 2)
        	zeile = 2;
        // Prüfen, ob die Karte dargestellt werden soll
        if(spalte < 10)
            // Darstellung der Karte auf dem Spielfeld
        	gui.setzeKarteAufSpielfeld(karte,spalte,zeile);
    }
    

    /** 4.4 Darstellen der Verschiebung von Karten  <br>
     * Prozedur zum Darstellen einer verschobenen Karte<br>
     * @param kartenVerschiebung<br>
     * @param held<br>
     * @param gui - Graphical User Interface<br>
     <br>*/
    public void kartenVerschobenDarstellen(int kartenVerschiebung,Spieler held,GUI gui){
    	
		if(kartenVerschiebung >= 0 && kartenVerschiebung < 10){
        	for(int i = 0; i < 10; i++){
            	if(spielfeld[3][i] != null){
                    spielfeld[3][i].versteckeKarte();
                    spielfeld[3][i] = null;
                }
            }
            
            for(int i = kartenVerschiebung; i < 10+kartenVerschiebung; i++){
            	if(held.getKarte(i) != null){
            		this.setzeKartePosition(held.getKarte(i),3,i-kartenVerschiebung,gui);
                }
            }
            
        }//ende if  
    }
    
    	
	/** 4.5 Setzen der aktuellen Karte <br>
     * Prozedur zum Platzieren und Darstellen der aktuellen Karte<br>
     * @param karte - Aktuelle Karte<br>
     * @param gui - Graphical User Interface<br>
     <br>*/
    public void setzeAktuelleKarte(Karte karte,GUI gui) {
        spielfeld[2][3] = karte;
        gui.setzeKarteAufSpielfeld(karte,3,1); // Für die Darstellung 2 -> 1
    }

	
	/** 4.6 Entfernen einer Karte <br>
     * Prozedur entfernt eine Karte aus dem Spielfeld<br>
     * @param karte - Karte<br>
     * @param zeile - Y-Koordinate im Spielfeld<br>
     * @param spalte - X-Koordinate im Spielfeld<br>
     <br>*/
    public void karteEntfernen(Karte karte, int zeile, int spalte) {
        // Karte im Spielfeld auf null setzen
        spielfeld[zeile][spalte] = null;
        // Karte verstecken
        karte.versteckeKarte();
    }
    
    
	/** 4.7 Spielfeld leer darstellen  <br>
     * Prozedur stellt das Spielfeld leer dar<br>
     * @param gui - Graphical User Interface<br>
     <br>*/
    public void stelleSpielfeldLeerDar(GUI gui) {
        // Spielfeld erstmal leer darstellen
        gui.stelleSpielfeldBereit(breite,hoehe);
    }
    

    /** 4.8 Spielfeld aktualisieren  <br>
     * Prozedur zum aktualisieren des Spielfelds<br>
     * @param kartenMenschlichSpieler - Karten von Spieler Held<br>
     * @param kartenSpielerKI - Karten von Spieler KI<br>
     * @param aktuelleKarte - zuf&auml;llige Karte die am Anfang vom Spiel generiert wird<br>
     * @param gui - Graphical User Interface<br>
     <br>*/
    public void aktualisiereSpielfeld(Karte[] kartenMenschlichSpieler, Karte[] kartenSpielerKI, Karte aktuelleKarte,GUI gui) {
    	// Random Starterkarte die übergeben wird
        setzeKartePosition(aktuelleKarte,1,3,gui);
    }
    

    /** 4.9 DummyKarten auf null setzen <br>
     * Prozedur setzt eine DummyKarte in einem gegebenen Index auf null<br>
     * @param spalte<br>
     <br>*/
    public void dummyKarteAufNullsetzen(int spalte) {
    	int zeile = 0;
        if(spalte >= 10) return;
        
        spielfeld[zeile][spalte].versteckeKarte();
    	spielfeld[zeile][spalte] = null;
    }
	
} // Ende von Spielfeld