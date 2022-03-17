package unotempel.kartenspiel;

import unotempel.GUI;
import unotempel.konsole.*;

/**
 * Die Klasse Spielfeld stellt das Spielbrett für das Kartenspiel dar
 */
public class Spielfeld {

	/** 4.1 Daten als Instanz-Variablen definieren Δe_bplt91 Δ */
	// Spielfeld
    private Karte[][] spielfeld;
    // Größe des Spielfelds
    private int breite;
   	private int hoehe;


	/** 4.2 Konstruktor erstellen Δe_0i2j07 Δ 
     * Konstruktor erzeugt ein Spielfeld mit Platz für 5x10 Karten
     */
    public Spielfeld(){
    	// ( Anzahl von Karten in Y-Richtung, Anzahl von Karten in X-Richtung)
        this.spielfeld = new Karte[5][10];
        this.breite = 660;
        this.hoehe = 450;
    }


    /** 4.3 Setzen einer Karte auf eine Position Δe_gbfi99 Δ 
     * Prozedur um Karte auf dem Spielfeld zu Platzieren
     * X-Y-Koordinaten mit [0,0] oben links
     * @param karte - Karte die übergeben wird
     * @param zeile - Y-Koordinate der Karte auf dem Spielfeld in int
     * @param spalte - X-Koordinate der Karte auf dem Spielfeld in int
     * @param gui - Graphical User Interface
     */
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
    

    /** 4.4 Darstellen der Verschiebung von Karten Δe_b3plup Δ 
     * Prozedur zum Darstellen einer verschobenen Karte
     * @param kartenVerschiebung
     * @param held
     * @param gui - Graphical User Interface
     */
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
    
    	
	/** 4.5 Setzen der aktuellen Karte Δe_3hit6h Δ
     * Prozedur zum Platzieren und Darstellen der aktuellen Karte
     * @param karte - Aktuelle Karte
     * @param gui - Graphical User Interface
     */
    public void setzeAktuelleKarte(Karte karte,GUI gui) {
        spielfeld[2][3] = karte;
        gui.setzeKarteAufSpielfeld(karte,3,1); // Für die Darstellung 2 -> 1
    }

	
	/** 4.6 Entfernen einer Karte Δe_c5o28y Δ
     * Prozedur entfernt eine Karte aus dem Spielfeld
     * @param karte - Karte
     * @param zeile - Y-Koordinate im Spielfeld
     * @param spalte - X-Koordinate im Spielfeld
     */
    public void karteEntfernen(Karte karte, int zeile, int spalte) {
        // Karte im Spielfeld auf null setzen
        spielfeld[zeile][spalte] = null;
        // Karte verstecken
        karte.versteckeKarte();
    }
    
    
	/** 4.7 Spielfeld leer darstellen Δe_4vofdb Δ 
     * Prozedur stellt das Spielfeld leer dar
     * @param gui - Graphical User Interface
     */
    public void stelleSpielfeldLeerDar(GUI gui) {
        // Spielfeld erstmal leer darstellen
        gui.stelleSpielfeldBereit(breite,hoehe);
    }
    

    /** 4.8 Spielfeld aktualisieren Δe_kbiidc Δ 
     * Prozedur zum aktualisieren des Spielfelds
     * @param kartenMenschlichSpieler - Karten von Spieler Held
     * @param kartenSpielerKI - Karten von Spieler KI
     * @param aktuelleKarte - zufällige Karte die am Anfang vom Spiel generiert wird
     * @param gui - Graphical User Interface
     */
    public void aktualisiereSpielfeld(Karte[] kartenMenschlichSpieler, Karte[] kartenSpielerKI, Karte aktuelleKarte,GUI gui) {
    	// Random Starterkarte die übergeben wird
        setzeKartePosition(aktuelleKarte,1,3,gui);
    }
    

    /** 4.9 DummyKarten auf null setzen Δe_o3veza Δ
     * Prozedur setzt eine DummyKarte in einem gegebenen Index auf null
     * @param spalte
     */
    public void dummyKarteAufNullsetzen(int spalte) {
    	int zeile = 0;
        if(spalte >= 10) return;
        
        spielfeld[zeile][spalte].versteckeKarte();
    	spielfeld[zeile][spalte] = null;
    }
	
} // Ende von Spielfeld