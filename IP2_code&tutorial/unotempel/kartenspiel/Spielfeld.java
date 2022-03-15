package unotempel.kartenspiel;

import unotempel.GUI;
import unotempel.konsole.*;

/**
 *
 */
public class Spielfeld {

    /** 2.1 Daten als Instanz-Variablen implementieren Δe_hh5mj9 Δ */
    private Karte[][] spielfeld;
    
    /** 2.1 Daten als Instanz-Variablen implementieren Δe_2gefui Δ */
    // Größe des Spielfelds
    private int breite;
   	private int hoehe;

	/** 2.2 Konstruktor der Klasse Spielfeld definieren Δe_6jqqga Δ 
     * Konstruktor erzeugt ein Spielfeld mit Platz für 5x10 Karten
     */
    public Spielfeld(){
    	// ( Anzahl von Karten in Y-Richtung, Anzahl von Karten in X-Richtung)
        this.spielfeld = new Karte[5][10];
        this.breite = 660;
        this.hoehe = 450;
    }


    /**
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
    

    /**
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
    
    
    /**
     * Prozedur zum Platzieren und Darstellen der aktuellen Karte
     * @param karte - Aktuelle Karte
     * @param gui - Graphical User Interface
     */
    public void setzeAktuelleKarte(Karte karte,GUI gui) {
        spielfeld[2][3] = karte;
        gui.setzeKarteAufSpielfeld(karte,3,1); // Für die Darstellung 2 -> 1
    }


    /**
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
    

	/**
     * Prozedur stellt das Spielfeld leer dar
     * @param gui - Graphical User Interface
     */
    public void stelleSpielfeldLeerDar(GUI gui) {
        // Spielfeld erstmal leer darstellen
        gui.stelleSpielfeldBereit(breite,hoehe);
    }


    /**
     * Prozedur zum Füllen des Spielfelds mit Karten
     * @param kartenMenschlichSpieler - Karten von Spieler Held
     * @param aktuelleKarte - zufällige Karte die am Anfang vom Spiel generiert wird
     * @param gui - Graphical User Interface
     */
    public void ersteFuelleSpielfeld(Karte[] kartenMenschlichSpieler, Karte aktuelleKarte,GUI gui) {
        // Karten vom KI Spieler auf das Spielfeld setzen
        /*
        for(int i = 0; i < 7; i++) {
            // Karte im entsprechenden Index speichern
            setzeKartePosition(new DummyKarte(),0,i,gui);
        }
        */
        // Zufällige Karte die übergeben wird
        setzeKartePosition(aktuelleKarte,1,3,gui);
        /*
        // Karten vom menschlichen Spieler auf das Spielfeld setzen
        for(int i = 0; i < 7; i++) {
            setzeKartePosition(kartenMenschlichSpieler[i],3,i,gui);
        }
		*/
    }
    
    
    /**
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
    

    /**
     * Prozedur setzt eine Beliebige Dummykarte auf Null
     * @param spalte
     */
    public void dummyKarteAufNullsetzen(int spalte) {
        if(spalte >= 10) return;
        
        if(spielfeld[0][spalte]!=null){
            spielfeld[0][spalte].versteckeKarte();
            spielfeld[0][spalte] = null;
        }//end if
    }//end procedure
    
    

/*
    public void aktuallisiereSpielfeld(Spieler kartenMenschlicherSpieler, Spieler kartenSpielerKI, Karte aktuelleKarte){
    
    GUI.darstellungSpielfeldTest(groesseX,groesseY);
    
    int gegnerKartenKoordinateX = 15;
    int gegnerKartenKoordinateY = 15;
    int kartenBreite = 60;
    
    int heldKartenKoordinateX = 15;
    int heldKartenKoordinateY = 345;
    	
        for(int x = 0; x < 10; x++){ // spielfeld[0].length ?
        	if(x < kartenSpielerKI.anzahlKarteHand()){
            	spielfeld[0][x] = new DummyKarte();
                GUI.karteDarstellen(spielfeld[0][x],gegnerKartenKoordinateY,gegnerKartenKoordinateX+x*kartenBreite);
                System.out.println("Debug: Render Karte: "+x);
            }else{
            	System.out.println("Debug: Render Karte: "+x);
            	GUI.karteDarstellen(spielfeld[0][x],gegnerKartenKoordinateY,gegnerKartenKoordinateX+x*kartenBreite);
            }
        }//end of for loop
        
        spielfeld[2][2] = aktuelleKarte;
        GUI.karteDarstellen(aktuelleKarte, groesseY/2 - 50, groesseX/2 - 50);
        
        
        for(int i = 0; i < 10; i++){
        	if(i < kartenMenschlicherSpieler.anzahlKarteHand()){
            	spielfeld[4][i] = kartenMenschlicherSpieler.getKarte(i);
                System.out.println(spielfeld[4][i].toString());
				GUI.karteDarstellen(spielfeld[4][i],heldKartenKoordinateY,heldKartenKoordinateX+i*kartenBreite);
            }else{
				GUI.karteDarstellen(spielfeld[4][i],heldKartenKoordinateY,heldKartenKoordinateX+i*kartenBreite);
                System.out.println("Debug: Render Karte: "+i);
            }
        }
    }//end of aktuali
 */   
    

    /**
     * Prozedur
     * @param held
     * @param computerGegener
     * @param aktuelleKarte
     */
    public void spielfeldErneuern(Spieler held, Spieler computerGegener, Karte aktuelleKarte){
    
    	int gegnerKartenKoordinateX = 15;
    	int gegnerKartenKoordinateY = 15;
        
    	int kartenBreite = 60;
    
    	int heldKartenKoordinateX = 15;
    	int heldKartenKoordinateY = 345;
  
    }
    
	
	
} // Ende von Spielfeld