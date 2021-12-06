package unotempel;

import unotempel.grafikkonsole.*;
import unotempel.konsole.*;
import unotempel.kartenspiel.*;
import unotempel.*;

/**
 * Vielleicht ist es sinnvoll eine Klasse zu erstellen die allgemeine Dinge anzeigt wie zum Beispiel Lebensenergie
 * in welchem Tempel man sich befindet 
 * Hier könnte man vllt auch den UnoKnopf einbauen k.p. ist nur so eine Idee
 */
public class GUI {
    //code...
    
    // Farbe des Spielfelds
    public final static String farbeGruenSpielfeld = "#9CAF88";
    public final static int groesseX = 850;
    public final static int groesseY = 470;
    
    
    /**
    * Prozedur stellt einen leeren Canvas als Hintergrund dar
    */ 
    public static void leererCanvasDarstellen() {
    	Rechteck spielfeldRechteck = new Rechteck(0, 0, groesseX, groesseY, Grafik.WHITE, Grafik.BLACK, 1, "keineAktion");
    }
    
    
    /****************** Einführung ******************/
    
    /**
	* Prozedur zur Darstellung des Einführungsmenüs
    */
    public static void menueGrafischErzeugen() {
    	optionEinsGrafischErzeugen();
        optionZweiGrafischErzeugen();
        goButtonGrafischErzeugen();
    }
    
    
    /**
	* Prozedur zur Darstellung der OOP1 Option
    */
    public static void optionEinsGrafischErzeugen() {
    	Rechteck rechteckOOP1 = new Rechteck(groesseX/2-250, groesseY/2-100, 200, 100, Grafik.GREEN, Grafik.BLACK, 1, 20, "oop1");
    	Text textOOP1 = new Text(groesseX/2-250+50, groesseY/2-100+10, "OOP1", Grafik.BLACK, 40, "oop1");
    }
    
    
    /**
	* Prozedur zur Darstellung der OOP2 Option
    */
    public static void optionZweiGrafischErzeugen() { 
        Rechteck rechteckOOP2 = new Rechteck(groesseX/2+50, groesseY/2-100, 200, 100, Grafik.BLUE, Grafik.BLACK, 1, 20, "oop2");
    	Text textOOP2 = new Text(groesseX/2+50+50, groesseY/2-100+10, "OOP2", Grafik.BLACK, 40, "oop2");
    }
    
    
    /**
	* Prozedur zur Darstellung der OOP1 Auswahl
    */
    public static void optionEinsGrafischAuswaehlen() {
    	Rechteck rechteckOOP1 = new Rechteck(groesseX/2-250, groesseY/2-100, 200, 100, Grafik.GREEN, Grafik.YELLOW, 2, 20, "oop1");
        Text textOOP1 = new Text(groesseX/2-250+40, groesseY/2-100, "OOP1", Grafik.YELLOW, 50, "oop1");
    }
    
    
    /**
	* Prozedur zur Darstellung der OOP2 Auswahl
    */
    public static void optionZweiGrafischAuswaehlen() {
    	Rechteck rechteckOOP2 = new Rechteck(groesseX/2+50, groesseY/2-100, 200, 100, Grafik.BLUE, Grafik.YELLOW, 2, 20, "oop2");
    	Text textOOP2 = new Text(groesseX/2+50+40, groesseY/2-100, "OOP2", Grafik.YELLOW, 50, "oop2");
    }
    
    
    /**
	* Prozedur zur Darstellung des Buttons, noch nicht bereit darauf geklickt zu werden
    */
    public static void goButtonGrafischErzeugen() {
    	Button okButton = new Button(groesseX/2-50, groesseY/2+50, 100, 70, Grafik.GREY, "GO", Grafik.WHITE, 30, 5, "");
    }
    
    
    /**
	* Prozedur zur Darstellung des Buttons, bereit darauf geklickt zu werden
    */
    public static void goButtonGrafischZeigen() {
    	Button okButton = new Button(groesseX/2-50, groesseY/2+50, 100, 70, Grafik.BLACK, "GO", Grafik.WHITE, 30, 5, "auswaehlen");
    }
    
    
    /**
	* Prozedur zur Darstellung des Buttons, bereits geklickt
    */
    public static void goButtonGrafischKlicken() {
    	Button okButton = new Button(groesseX/2-50, groesseY/2+50, 100, 70, Grafik.YELLOW, "GO", Grafik.BLACK, 30, 5, "auswaehlen");
    }
    
 
    /**
	* Prozedur zur Darstellung des Menüs zum Auswählen
    */
    public static int menueGrafischAuswaehlen() {
    	// SpielNiveau als leerer String erzeugen
    	String spielNiveau = "";
        // Solange den OK-Button nicht darauf geklickt wird
        while(Konsole.eingabeString().compareTo("auswaehlen") != 0) {
        	// SpielNiveau als Reaktion einlesen
        	spielNiveau = Konsole.eingabeString();
        	// Bedingung überprüuft, ob die ausgewählte Option OOP1 ist
            if(spielNiveau.compareTo("oop1") == 0) {
            	// Darstellung der ausgewählte Option ändern und ggf. die gerade nicht ausgewählte Option wiederherzustellen
                optionEinsGrafischAuswaehlen();       
                optionZweiGrafischErzeugen();
                // Button grafisch anzeigen, bereit darauf geklickt zu werden
                goButtonGrafischZeigen();
            }
            // Bedingung überprüuft, ob die ausgewählte Option OOP2 ist
            if(spielNiveau.compareTo("oop2") == 0) {
            	// Darstellung der ausgewählte Option ändern und ggf. die gerade nicht ausgewählte Option wiederherzustellen
				optionZweiGrafischAuswaehlen();       
                optionEinsGrafischErzeugen();
                // Button grafisch anzeigen, bereit darauf geklickt zu werden
                goButtonGrafischZeigen();   
            } 
        }
        // Button grafisch darauf klicken (ist momentan nicht wichtig)
        goButtonGrafischKlicken();
        // Spielniveau als int zurückgeben
        return Character.getNumericValue(spielNiveau.charAt(3));
    }
    

    
    /****************** Tempel ******************/

	/**
    * Funktion für die Darstellung der Tempel gibt die Zahl des ausgewählten Tempels zurück
    */
    public static int tempelSymbolZeigen() {
    	Rechteck wasserTempel = new Rechteck(groesseX/2-330, groesseY/2-75, 150, 150, Grafik.BLUE, Grafik.BLACK, 1, 10, "1");
        Rechteck luftTempel = new Rechteck(groesseX/2-160, groesseY/2-75, 150, 150, Grafik.YELLOW, Grafik.BLACK, 1, 10, "2");
        Rechteck erdeTempel = new Rechteck(groesseX/2+10, groesseY/2-75, 150, 150, Grafik.GREEN, Grafik.BLACK, 1, 10, "3");
        Rechteck feuerTempel = new Rechteck(groesseX/2+180, groesseY/2-75, 150, 150, Grafik.RED, Grafik.BLACK, 1, 10, "4");
        // Auswahl zurückgeben
        return Konsole.eingabeZahl();
    }


	/**
	* Prozedur zur Darstellung des Begrüßungsnachricht in jedem Tempel
    */
	public static void begruessungsnachrichtDarstellen(String[] nachricht) {
        Text textTempelEinfuehrungZeile1 = new Text(groesseX/2-250, groesseY/2-150, nachricht[0] +"", Grafik.BLACK, 20, "");
        Text textTempelEinfuehrungZeile2 = new Text(groesseX/2-180, groesseY/2-120, nachricht[1] +"", Grafik.BLACK, 20, "");
        Text textTempelEinfuehrungZeile3 = new Text(groesseX/2-150, groesseY/2-90, nachricht[2] +"", Grafik.BLACK, 20, "");
        // Button grafisch anzeigen, bereit darauf geklickt zu werden
        goButtonGrafischZeigen();
        if(Konsole.eingabeString().compareTo("auswaehlen") == 0) {
        	// Button grafisch darauf klicken (ist momentan nicht wichtig)
        	goButtonGrafischKlicken();
        }
    }

	/****************** Quiz ******************/

    /**
    * Funktion stellt eine Quizfrage dar und gibt die ausgewählte Antwort zurück
    * @param frage
    * @param antwortmoeglichkeiten
    * @param richtigeAntwort
    */
    public static char quizDarstellen(String frage, String[] antwortmoeglichkeiten) {
		// Ausgewählte Antwort erstmal leer erzeugen
        char ausgewaehlteAntwort = ' ';
        // Grafik-Konsole einmal initialisieren
        GrafikKonsole.clearGrafik();
        // Leerer Canvas darstellen
        GUI.leererCanvasDarstellen();
        // Titel als Text darstellen
		Text frageText = new Text(10, 10, "Frage", Grafik.BLACK, 20, "keineAktion");
        // Aktuelle Frage darstellen
        Text aktuelleFrageText = new Text(10, 50, frage+"", Grafik.BLACK, 15, "keineAktion");
        
        // Antwortmöglichkeiten darstellen
        // Antwort 1
        Rechteck grafikRechteckAnt1 = new Rechteck(10, 170, 800, 80, Grafik.WHITE, Grafik.GREY, 1, "a");
        Text grafikTextAnt1 = new Text(20, 170, antwortmoeglichkeiten[0] +"", Grafik.BLACK, 18, "a");
		// Antwort 2
        Rechteck grafikRechteckAnt2 = new Rechteck(10, 260, 800, 80, Grafik.WHITE, Grafik.GREY, 1, "b");
        Text grafikTextAnt2 = new Text(20, 260, antwortmoeglichkeiten[1] +"", Grafik.BLACK, 18, "b");
        // Bedingung prüft, ob es mehr als zwei Antwortmöglichkeiten gibt
        if(antwortmoeglichkeiten.length > 2) {
        	// Antwort 3
            Rechteck grafikRechteckAnt3 = new Rechteck(10, 350, 800, 80, Grafik.WHITE, Grafik.GREY, 1, "c");
            Text grafikTextAnt3 = new Text(20, 350, antwortmoeglichkeiten[2] +"", Grafik.BLACK, 18, "c");
        }
        // Bedingung prüft, ob eine ungültige Antwort ausgewählt wurde
        if(Konsole.eingabeString().compareTo("keineAktion") == 0) {
        	// Meldung auf die Konsole ausgeben
        	System.out.println("Wähle bitte eine gültige Antwort");
            // Funktion rekursiv aufrufen 
            quizDarstellen(frage, antwortmoeglichkeiten);
        // Ist die ausgewählte Antwort gültig (kann aber muss nicht richtig sein)
        } else {
            // Ausgewählte Antwort in char umwandeln
            ausgewaehlteAntwort = Konsole.eingabeString().charAt(0);
    	}
        // Ausgewählte Antwort zurückgeben
        return ausgewaehlteAntwort;
    }
    
    
    /****************** Spiel ******************/
    
    /**
    * Prozedur zum Darstellen eines leeren Spielfelds
    */
    public static void spielfeldLeerDarstellen(Karte[][] spielfeld, int x, int y) {
     
    	// Rand
     	int rand = 5;
     
        // Spielfeld leer als Rechteck darstellen    
    	Rechteck spielfeldRechteck = new Rechteck(0+rand, 0+rand, x+rand, y+rand, farbeGruenSpielfeld, Grafik.BLACK, 1, "");
        
        // Leere Plätze für die Karten erzeugen
    	for(int i = 10+rand; i < y-100; i = i + 330) {
        	for(int j = 10+rand; j < x-100; j = j + 60) {
            	KartenDesign.leereKarte(j, i);
            }
    	}
        
        // Platz für gespielte Karten und den Kartenstapel
        KartenDesign.leereKarte(x/2 - 50, y/2 - 50);
        KartenDesign.stapelDarstellen(x/2 + 50, y/2 - 50);
        
        // Buttons zum Zeigen der Karten oben oder unten
        linksRechtsButtonsErzeugen(x,y);
        // Uno-Button erzeugen
        unoButtonErzeugen(x,y);
                
        
    }
    
    
    
    
    
    /**
    * Prozedur zum Darstellen des Spielfelds, ausgefühlt mit Karten
    */
    public static void spielfeldDarstellen(Karte[][] spielfeld, int y, int x) {
    
    	// Nicht optimal...
    	int rand = 5;
        // noch zu machen
        int zaehler = 0;
        // Gegner Karten darstellen
        for(int j = 10+rand; j < x; j = j + 60) {
        	KartenDesign.dummyKarte(j, 15);
            zaehler++;
            if(zaehler == 7)
            	break;
        }
        
        // Es wäre besser, wenn man wissen könnte, welche Karten genau auf dem Spielfeld sind.
        
        
        
        
            
    }
    
    /**
    * Prozedur zum Darstellen einer Karte
    */
    public static void karteDarstellen(Karte uebergebeneKarte, int y, int x){
    
    	if(uebergebeneKarte != null){
        
        	if(uebergebeneKarte.istWelcheKarte("Farb")){
				KartenDesign.farbKarte(x,y,uebergebeneKarte.getFarbe(),Integer.toString(uebergebeneKarte.getNummer()));
        	}
            
        	if(uebergebeneKarte.istWelcheKarte("Wunsch")){
        		KartenDesign.wunschKarte(x,y);
        	}
        	if(uebergebeneKarte.istWelcheKarte("PlusVierWunsch")){
        		KartenDesign.plusVierWunschKarte(x,y);
        	}
        	if(uebergebeneKarte.istWelcheKarte("PlusZwei")){
        		KartenDesign.plusZweiKarte(x,y,uebergebeneKarte.getFarbe());
        	}
        	if(uebergebeneKarte.istWelcheKarte("Aussetzen")){
        		KartenDesign.aussetzenKarte(x,y,uebergebeneKarte.getFarbe());
        	}
       	 	if(uebergebeneKarte.istWelcheKarte("Retour")){
       	 		KartenDesign.retourKarte(x,y,uebergebeneKarte.getFarbe());
        	}
        	if(uebergebeneKarte.istWelcheKarte("Dummy")){
        		KartenDesign.dummyKarte(x,y);
      	  	}
        }else{
        	KartenDesign.leereKarte(x,y);
        }
            
	}
    
    public static void darstellungSpielfeldTest(int x ,int y){
    
    	int rand = 5;
    
    	// Spielfeld leer als Rechteck darstellen    
    	Rechteck spielfeldRechteck = new Rechteck(rand, rand, x+rand, y+rand, farbeGruenSpielfeld, Grafik.BLACK, 1, "");
        
        KartenDesign.stapelDarstellen(x/2 + 50, y/2 - 50);
        
        // Buttons zum Zeigen der Karten oben oder unten
        linksRechtsButtonsErzeugen(x,y);
        // Uno-Button erzeugen
        unoButtonErzeugen(x,y);
                
    	
        
    }
    

	/**
	* Prozedur zur Darstellung des Buttons, noch nicht bereit darauf geklickt zu werden
    */
    public static void unoButtonErzeugen(int x, int y) {
    	Button unoButton = new Button(x+40, y/2 + 135, 130, 70, Grafik.GREY, "UNO", Grafik.WHITE, 30, 5, "");
    }
    
    
    public static void linksRechtsButtonsErzeugen(int x, int y) {
    	Button linksButton = new Button(x-45, y/2 + 135, 30, 30, Grafik.WHITE, "<", Grafik.BLACK, 30, 5, "links");
        Button rechtsButton = new Button(x-45, y/2 + 175, 30, 30, Grafik.WHITE, ">", Grafik.BLACK, 30, 5, "rechts");
    }


    /**
     * Die vier Farben zur Auswahl werden angezeigt: Blau, gelb, grün, rot
     */
    public static String farbeAuswaehlen() {
    	int groesseX = 660;
        int groesseY = 450;
        // Farbe auswählen
        Rechteck rechteckFarbAuswahl = new Rechteck(groesseX + 40, groesseY/2 - 100, 130, 130, Grafik.WHITE, Grafik.BLACK, 1, 10, "");
        Rechteck rechteckBlau = new Rechteck(groesseX + 50, groesseY/2 - 90, 50, 50, Grafik.BLUE, Grafik.BLACK, 1, 10, "blauWählen");
        Rechteck rechteckGelb = new Rechteck(groesseX + 110, groesseY/2 - 90, 50, 50, Grafik.YELLOW, Grafik.BLACK, 1, 10, "gelbWählen");
        Rechteck rechteckGruen = new Rechteck(groesseX + 50, groesseY/2 - 30, 50, 50, Grafik.GREEN, Grafik.BLACK, 1, 10, "grünWählen");
        Rechteck rechteckRot = new Rechteck(groesseX + 110, groesseY/2 - 30, 50, 50, Grafik.RED, Grafik.BLACK, 1, 10, "rotWählen");
        // Reaktion zurückgeben
        return Konsole.eingabeString();
    }
    
    
    
    


    /**
     * 
     * @return
     */
    public static String unoKlicken() {
        //Button unoButton = new Button(..., "uno");
        return "";
    }

} // Ende von GUI