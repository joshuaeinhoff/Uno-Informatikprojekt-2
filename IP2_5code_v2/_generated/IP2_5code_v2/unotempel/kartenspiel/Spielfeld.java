package unotempel.kartenspiel;

import unotempel.GUI;
import unotempel.konsole.*;

/**<br>
 *<br>
 <br>*/
public class Spielfeld {

    // Eigenschaften
    private Karte[][] spielfeld;
    // Größe des Spielfelds
    private int groesseX;
   	private int groesseY;
    // 
    private static int shiftInt = 0;


    /**<br>
     * Konstruktor erzeugt ein Spielfeld mit Platz f&uuml;r 5x10 Karten<br>
     <br>*/
    public Spielfeld(){
    	// ( Anzahl von Karten in Y-Richtung, Anzahl von Karten in X-Richtung)
        this.spielfeld = new Karte[5][10];
        this.groesseX = 660;
        this.groesseY = 450;
    }


    /**<br>
     * Methode um Karte auf dem Spielfeld zu Platzieren<br>
     * X-Y-Koordinaten mit [0,0] oben links<br>
     * @param karte - Karte die &uuml;bergeben wird<br>
     * @param y - Koordinate der Karte auf dem Spielfeld in int<br>
     * @param x - Koordinate der Karte auf dem Spielfeld in int<br>
     <br>*/
    public void setzeKartePosition(Karte karte, int y, int x) {
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
        	GUI.setzeKarteAufSpielfeld(karte,x,y);
    }
    
    public void setzeAktuelleKarte(Karte karte) {
        spielfeld[2][3] = karte;
        GUI.setzeKarteAufSpielfeld(karte,3,1); // 2 -> 1
    }


    /**<br>
     * Prozedur entfernt eine Karte aus dem Spielfeld<br>
     * @param karte<br>
     * @param y<br>
     * @param x<br>
     <br>*/
    public void karteEntfernen(Karte karte, int y, int x) {
        spielfeld[y][x] = null;
        karte.versteckeKarte();
    }
    

    /**<br>
     * Methode die als erstes Aufgerufen wird um das Spielfeld initial zu f&uuml;llen<br>
     * @param player - Held damit die Karten die auf der Hand sind angzeigt werden k&ouml;nnen<br>
     * @param aktuelleKarte - zuf&auml;llige Karte die am Anfang vom Spiel generiert wird<br>
     <br>*/
    public void ersteFuelleSpielfeld(Karte[] kartenMenschlichSpieler, Karte aktuelleKarte) {
        // Spielfeld erstmal leer darstellen
        GUI.stelleSpielfeldBereit(groesseX,groesseY);       

        // Karten vom KI Spieler auf das Spielfeld setzen
        for(int i = 0; i < 7; i++) {
            // Karte im entsprechenden Index speichern
            setzeKartePosition(new DummyKarte(),0,i);
        }

        // Random Starterkarte die übergeben wird
        setzeKartePosition(aktuelleKarte,1,3);

        // Karten vom menschlichen Spieler auf das Spielfeld setzen
        for(int i = 0; i < 7; i++) {
            setzeKartePosition(kartenMenschlichSpieler[i],3,i);
        }

    }
    
    
    /**<br>
     * <br>
     * @param kartenMenschlichSpieler<br>
     * @param kartenSpielerKI<br>
     * @param aktuelleKarte<br>
     <br>*/
    public void aktualisiereSpielfeld(Karte[] kartenMenschlichSpieler, Karte[] kartenSpielerKI, Karte aktuelleKarte) {
    
    	// Random Starterkarte die übergeben wird
        setzeKartePosition(aktuelleKarte,1,3);
    
    
    }
    
    /**<br>
     * Prozedur setzt eine DummyKarte in einem gegebenen Index auf null<br>
     * @param i<br>
     <br>*/
    public void dummyKarteAufNullsetzen(int i) {
    	int j = 0;
        if(i >= 10) {
        	j++;
            i %= 10;
    	}
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