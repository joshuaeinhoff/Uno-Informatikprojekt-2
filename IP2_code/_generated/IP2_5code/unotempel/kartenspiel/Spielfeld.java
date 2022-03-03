package unotempel.kartenspiel;

import unotempel.GUI;
import unotempel.konsole.*;

/**<br>
 *<br>
 <br>*/
public class Spielfeld {

    private Karte[][] spielfeld;
    // Größe des Spielfelds
    private int groesseX;
   	private int groesseY;
    
    private static int shiftInt = 0;

    /**<br>
     * Konstruktor erzeugt ein Spielfeld mit Platz f&uuml;r 5x10 Karten<br>
     <br>*/
    public Spielfeld(){
    	// ( Anzahl von Karten in Y-Richtung, Anzahl von Karten in X-Richtung)
        this.spielfeld = new Karte[5][10];
        this.groesseX = 660;
        this.groesseY = 450;
    }

    /**<br>
     * Methode um Karte auf dem Spielfeld zu Platzieren<br>
     * X-Y-Koordinaten mit [0,0] oben links<br>
     * @param y - Koordinate der Karte auf dem Spielfeld in int<br>
     * @param x - Koordcinate der Karte auf dem Spielfeld in int<br>
     * @param karte - Karte die &uuml;bergeben wird<br>
     <br>*/
    public void setzePosition(int y, int x, Karte karte){
        spielfeld[y][x] = karte;
    }

    /**<br>
     * Methode die als erstes Aufgerufen wird um das Spielfeld initial zu f&uuml;llen<br>
     * ist noch sehr w.i.p.<br>
     * @param player - Held damit die Karten die auf der Hand sind angzeigt werden k&ouml;nnen<br>
     * @param aktuelleKarte - zuf&auml;llige Karte die am Anfang vom Spiel generiert wird<br>
     <br>*/
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
    
    
    public void sichtbareKarten(){
    	
        if(Konsole.eingabeString().equals("rechts")&& shiftInt < 20){
        	shiftInt++;
        }
        if(Konsole.eingabeString().equals("links") && shiftInt > 0){
        	shiftInt--;
        }
        
    }
    
    public void spielfeldErneuern(Spieler held, Spieler computerGegener, Karte aktuelleKarte){
    
    	int gegnerKartenKoordinateX = 15;
    	int gegnerKartenKoordinateY = 15;
        
    	int kartenBreite = 60;
    
    	int heldKartenKoordinateX = 15;
    	int heldKartenKoordinateY = 345;
        
        
        
    }
    
} // Ende von Spielfeld