package unotempel.kartenspiel;

import unotempel.GUI;
import unotempel.konsole.*;

/**
 *
 */
public class Spielfeld {

    // Eigenschaften
    private Karte[][] spielfeld;
    // Größe des Spielfelds
    private int groesseX;
   	private int groesseY;
    // 


    /**
     * Konstruktor erzeugt ein Spielfeld mit Platz für 5x10 Karten
     */
    public Spielfeld(){
    	// ( Anzahl von Karten in Y-Richtung, Anzahl von Karten in X-Richtung)
        this.spielfeld = new Karte[5][10];
        this.groesseX = 660;
        this.groesseY = 450;
    }


    /**
     * Methode um Karte auf dem Spielfeld zu Platzieren
     * X-Y-Koordinaten mit [0,0] oben links
     * @param karte - Karte die übergeben wird
     * @param y - Koordinate der Karte auf dem Spielfeld in int
     * @param x - Koordinate der Karte auf dem Spielfeld in int
     */
    public void setzeKartePosition(Karte karte, int y, int x,GUI gui) {
        int j = x;
        int i = y;
        if(x > 9) {
        	i += 1;
            j %= 10;
        }
        	      	
        spielfeld[i][j] = karte; // problem lsen
        
        if(y > 2)
        	y = 2;
        if(x < 10)
        	gui.setzeKarteAufSpielfeld(karte,x,y);
    }
    
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
    
    
    
    public void setzeAktuelleKarte(Karte karte,GUI gui) {
        spielfeld[2][3] = karte;
        gui.setzeKarteAufSpielfeld(karte,3,1); // 2 -> 1
    }


    /**
     * Prozedur entfernt eine Karte aus dem Spielfeld
     * @param karte
     * @param y
     * @param x
     */
    public void karteEntfernen(Karte karte, int y, int x) {
        spielfeld[y][x] = null;
        karte.versteckeKarte();
    }
    

	/**
     * Methode die als erstes Aufgerufen wird um das Spielfeld initial zu füllen
     */
    public void stelleSpielfeldLeerDar(GUI gui) {
        // Spielfeld erstmal leer darstellen
        gui.stelleSpielfeldBereit(groesseX,groesseY);
    }


    /**
     * Methode die als erstes Aufgerufen wird um das Spielfeld initial zu füllen
     * @param aktuelleKarte - zufällige Karte die am Anfang vom Spiel generiert wird
     */
    public void ersteFuelleSpielfeld(Karte[] kartenMenschlichSpieler, Karte aktuelleKarte,GUI gui) {
        // Karten vom KI Spieler auf das Spielfeld setzen
        for(int i = 0; i < 7; i++) {
            // Karte im entsprechenden Index speichern
            setzeKartePosition(new DummyKarte(),0,i,gui);
        }

        // Random Starterkarte die übergeben wird
        setzeKartePosition(aktuelleKarte,1,3,gui);

        // Karten vom menschlichen Spieler auf das Spielfeld setzen
        for(int i = 0; i < 7; i++) {
            setzeKartePosition(kartenMenschlichSpieler[i],3,i,gui);
        }

    }
    
    
    /**
     * 
     * @param kartenMenschlichSpieler
     * @param kartenSpielerKI
     * @param aktuelleKarte
     */
    public void aktualisiereSpielfeld(Karte[] kartenMenschlichSpieler, Karte[] kartenSpielerKI, Karte aktuelleKarte,GUI gui) {
    
    	// Random Starterkarte die übergeben wird
        setzeKartePosition(aktuelleKarte,1,3,gui);
    
    
    }
    
    /**
     * Prozedur setzt eine DummyKarte in einem gegebenen Index auf null
     * @param i
     */
    public void dummyKarteAufNullsetzen(int i) {
    	int j = 0;
        if(i >= 10) {
        	j++;
            i %= 10;
    	}
        spielfeld[j][i].versteckeKarte();
    	spielfeld[j][i] = null;
    }
    
    

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
    
    
    
    
    
    
    
    

    public void spielfeldErneuern(Spieler held, Spieler computerGegener, Karte aktuelleKarte){
    
    	int gegnerKartenKoordinateX = 15;
    	int gegnerKartenKoordinateY = 15;
        
    	int kartenBreite = 60;
    
    	int heldKartenKoordinateX = 15;
    	int heldKartenKoordinateY = 345;
  
    }
    
} // Ende von Spielfeld