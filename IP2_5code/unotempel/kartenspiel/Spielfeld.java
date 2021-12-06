package unotempel.kartenspiel;

import unotempel.GUI;

/**
 *
 */
public class Spielfeld {

    private Karte[][] spielfeld;
    // Größe des Spielfelds
    private int groesseX;
   	private int groesseY;

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
     * @param y - Koordinate der Karte auf dem Spielfeld in int
     * @param x - Koordcinate der Karte auf dem Spielfeld in int
     * @param karte - Karte die übergeben wird
     */
    public void setzePosition(int y, int x, Karte karte){
        spielfeld[y][x] = karte;
    }

    /**
     * Methode die als erstes Aufgerufen wird um das Spielfeld initial zu füllen
     * ist noch sehr w.i.p.
     * @param player - Held damit die Karten die auf der Hand sind angzeigt werden können
     * @param aktuelleKarte - zufällige Karte die am Anfang vom Spiel generiert wird
     */
    public void ersteFuelleSpielfeld(Karte[] kartenMenschlichSpieler, Karte[] kartenSpielerKI, Karte aktuelleKarte){
        
        // Gegner Karten als DummyKarten setzen
        for(int x = 0; x < 7; x++){ // spielfeld[0].length ?
            spielfeld[0][x] = new DummyKarte();
        }
        
        

        // Random Starterkarte die übergeben wird
        spielfeld[2][2] = aktuelleKarte;

        for(int x = 0; x < 7; x++){ //spielfeld[6].length
            spielfeld[4][x] = kartenMenschlichSpieler[x];
        }
        // Spielfeld erstmal leer darstellen
        GUI.spielfeldLeerDarstellen(spielfeld, groesseX, groesseY);
        // Spielfeld mit Karten füllen
        //GUI.spielfeldDarstellen(spielfeld, groesseX, groesseY);

    }
    
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
        
        
        for(int x = 0; x < 10; x++){
        	if(x < kartenMenschlicherSpieler.anzahlKarteHand()){
            	spielfeld[4][x] = kartenMenschlicherSpieler.getKarte(x);
				GUI.karteDarstellen(spielfeld[0][x],heldKartenKoordinateY,heldKartenKoordinateX+x*kartenBreite);
                System.out.println("Debug: Render Karte: "+x);
            }else{
				GUI.karteDarstellen(spielfeld[0][x],heldKartenKoordinateY,heldKartenKoordinateX+x*kartenBreite);
                System.out.println("Debug: Render Karte: "+x);
            }
        }
        
        
    }
    
} // Ende von Spielfeld