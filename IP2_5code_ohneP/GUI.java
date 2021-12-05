



/**
 * Vielleicht ist es sinnvoll eine Klasse zu erstellen die allgemeine Dinge anzeigt wie zum Beispiel Lebensenergie
 * in welchem Tempel man sich befindet 
 * Hier könnte man vllt auch den UnoKnopf einbauen k.p. ist nur so eine Idee
 */
public class GUI {
    //code...
    // Farbe des Spielfelds
    public final static String farbeGruenSpielfeld = "#9CAF88";
    
    
    /****************** Einführung ******************/
    
    /**
	* Prozedur zur Darstellung des Einführungsmenüs
    */
    public static void menueGrafischErzeugen() {
    	optionEinsGrafischErzeugen();
        optionZweiGrafischErzeugen();
        okButtonGrafischErzeugen();
    }
    
    
    /**
	* Prozedur zur Darstellung der OOP1 Option
    */
    public static void optionEinsGrafischErzeugen() {
    	Rechteck rechteckOOP1 = new Rechteck(50, 50, 200, 100, Grafik.GREEN, Grafik.BLACK, 2, 20, "oop1");
    	Text textOOP1 = new Text(40+50, 2+50, "OOP1", Grafik.BLACK, 50, "oop1");
    }
    
    
    /**
	* Prozedur zur Darstellung der OOP2 Option
    */
    public static void optionZweiGrafischErzeugen() { 
        Rechteck rechteckOOP2 = new Rechteck(300, 50, 200, 100, Grafik.BLUE, Grafik.BLACK, 2, 20, "oop2");
    	Text textOOP2 = new Text(40+300, 2+50, "OOP2", Grafik.BLACK, 50, "oop2");
    }
    
    
    /**
	* Prozedur zur Darstellung der OOP1 Auswahl
    */
    public static void optionEinsGrafischAuswaehlen() {
    	Rechteck rechteckOOP1 = new Rechteck(50, 50, 200, 100, Grafik.GREEN, Grafik.YELLOW, 3, 20, "oop1");
        Text textOOP1 = new Text(40+50, 2+50, "OOP1", Grafik.YELLOW, 50, "oop1");
    }
    
    
    /**
	* Prozedur zur Darstellung der OOP2 Auswahl
    */
    public static void optionZweiGrafischAuswaehlen() {
    	Rechteck rechteckOOP2 = new Rechteck(300, 50, 200, 100, Grafik.BLUE, Grafik.YELLOW, 3, 20, "oop2");
    	Text textOOP2 = new Text(40+300, 2+50, "OOP2", Grafik.YELLOW, 50, "oop2");
    }
    
    
    /**
	* Prozedur zur Darstellung des Buttons, noch nicht bereit darauf geklickt zu werden
    */
    public static void okButtonGrafischErzeugen() {
    	Button okButton = new Button(230, 200, 100, 70, Grafik.GREY, "OK", Grafik.WHITE, 30, 5, "");
    }
    
    
    /**
	* Prozedur zur Darstellung des Buttons, bereit darauf geklickt zu werden
    */
    public static void okButtonGrafischZeigen() {
    	Button okButton = new Button(230, 200, 100, 70, Grafik.BLACK, "OK", Grafik.WHITE, 30, 5, "auswaehlen");
    }
    
    
    /**
	* Prozedur zur Darstellung des Buttons, bereits geklickt
    */
    public static void okButtonGrafischKlicken() {
    	Button okButton = new Button(230, 200, 100, 70, Grafik.YELLOW, "OK", Grafik.BLACK, 30, 5, "auswaehlen");
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
                okButtonGrafischZeigen();
            }
            // Bedingung überprüuft, ob die ausgewählte Option OOP2 ist
            if(spielNiveau.compareTo("oop2") == 0) {
            	// Darstellung der ausgewählte Option ändern und ggf. die gerade nicht ausgewählte Option wiederherzustellen
				optionZweiGrafischAuswaehlen();       
                optionEinsGrafischErzeugen();
                // Button grafisch anzeigen, bereit darauf geklickt zu werden
                okButtonGrafischZeigen();   
            } 
        }
        // Button grafisch darauf klicken (ist momentan nicht wichtig)
        okButtonGrafischKlicken();
        // Spielniveau als int zurückgeben
        return Character.getNumericValue(spielNiveau.charAt(3));
    }
    
    /****************** Tempel ******************/

	/**
	* Prozedur zur Darstellung des Begrüßungsnachricht in jedem Tempel
    */
	public static void begruessungsnachrichtDarstellen(String[] nachricht) {
        Text textTempelEinfuehrungZeile1 = new Text(50, 60, nachricht[0] +"", Grafik.BLACK, 20, "");
        Text textTempelEinfuehrungZeile2 = new Text(120, 100, nachricht[1] +"", Grafik.BLACK, 20, "");
        Text textTempelEinfuehrungZeile3 = new Text(150, 140, nachricht[2] +"", Grafik.BLACK, 20, "");
        // Button grafisch anzeigen, bereit darauf geklickt zu werden
        okButtonGrafischZeigen();
        if(Konsole.eingabeString().compareTo("auswaehlen") == 0) {
        	// Button grafisch darauf klicken (ist momentan nicht wichtig)
        	okButtonGrafischKlicken();
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
        // Titel als Text darstellen
		Text frageText = new Text(10, 10, "Frage", Grafik.BLACK, 20, "keineAktion");
        // Aktuelle Frage darstellen
        Text aktuelleFrageText = new Text(10, 50, frage+"", Grafik.BLACK, 15, "keineAktion");
        
        // Antwortmöglichkeiten darstellen
        // Antwort 1
        Rechteck grafikRechteckAnt1 = new Rechteck(10, 160, 800, 80, Grafik.WHITE, Grafik.BLACK, 1, "a");
        Text grafikTextAnt1 = new Text(20, 170, antwortmoeglichkeiten[0] +"", Grafik.BLACK, 18, "a");
		// Antwort 2
        Rechteck grafikRechteckAnt2 = new Rechteck(10, 250, 800, 80, Grafik.WHITE, Grafik.BLACK, 1, "b");
        Text grafikTextAnt2 = new Text(20, 260, antwortmoeglichkeiten[1] +"", Grafik.BLACK, 18, "b");
        // Bedingung prüft, ob es mehr als zwei Antwortmöglichkeiten gibt
        if(antwortmoeglichkeiten.length > 2) {
        	// Antwort 3
            Rechteck grafikRechteckAnt3 = new Rechteck(10, 340, 800, 80, Grafik.WHITE, Grafik.BLACK, 1, "c");
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
    public static void spielfeldLeerDarstellen(Spielfeld spielfeld, int y, int x) {
          
        // Spielfeld Größe bestimmen
        int groesseY = y*45;
        int groesseX = x*73;
        // Spielfeld leer darstellen    
    	Rechteck spielfeldRechteck = new Rechteck(0, 0, groesseX, groesseY, farbeGruenSpielfeld, Grafik.BLACK, 1, "");
        
        // Leere Plätze für die Karten erzeugen
    	for(int i = 10; i < groesseY-100; i = i + 320) {
        	for(int j = 10; j < groesseX; j = j + 60) {
            	KartenDesign.leereKarte(j, i);
            }
    	}
        
        // Platz für gespielte Karten und den Kartenstapel
        KartenDesign.leereKarte(groesseX/2 - 50, groesseY/2 - 50);
        KartenDesign.stapelDarstellen(groesseX/2 + 50, groesseY/2 - 50);
        // Uno-Button erzeugen
        unoButtonErzeugen();
                
        
    }
    
    
    
    
    
    /**
    * Prozedur zum Darstellen des Spielfelds, ausgefühlt mit Karten
    */
    public static void spielfeldDarstellen(Spielfeld spielfeld, int y, int x) {
    
    // noch zu machen
    
    /*
    	for(int i = 0, i < y; i++) {
        	for(int j = 0; j < x; j++) {
            	
            }
    	}
    */    
    
    }
    

	/**
	* Prozedur zur Darstellung des Buttons, noch nicht bereit darauf geklickt zu werden
    */
    public static void unoButtonErzeugen() {
    	int groesseX = 730;
        int groesseY = 450;
    	Button unoButton = new Button(groesseX + 50, groesseY/2 + 120, 130, 70, Grafik.GREY, "UNO", Grafik.WHITE, 30, 5, "");
    }


    /**
     * Die vier Farben zur Auswahl werden angezeigt: Blau, gelb, grün, rot
     */
    public static String farbeAuswaehlen() {
    	int groesseX = 730;
        int groesseY = 450;
        // Farbe auswählen
        Rechteck rechteckFarbAuswahl = new Rechteck(groesseX + 50, groesseY/2 - 100, 130, 130, Grafik.WHITE, Grafik.BLACK, 1, 10, "");
        Rechteck rechteckBlau = new Rechteck(groesseX + 60, groesseY/2 - 90, 50, 50, Grafik.BLUE, Grafik.BLACK, 1, 10, "blauWählen");
        Rechteck rechteckGelb = new Rechteck(groesseX + 120, groesseY/2 - 90, 50, 50, Grafik.YELLOW, Grafik.BLACK, 1, 10, "gelbWählen");
        Rechteck rechteckGruen = new Rechteck(groesseX + 60, groesseY/2 - 30, 50, 50, Grafik.GREEN, Grafik.BLACK, 1, 10, "grünWählen");
        Rechteck rechteckRot = new Rechteck(groesseX + 120, groesseY/2 - 30, 50, 50, Grafik.RED, Grafik.BLACK, 1, 10, "rotWählen");
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