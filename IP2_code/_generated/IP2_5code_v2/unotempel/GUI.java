package unotempel;

import unotempel.grafikkonsole.*;
import unotempel.konsole.*;
import unotempel.kartenspiel.*;
import unotempel.*;

/**<br>
 * Klasse zur Darstellung und Interaktion mit einem aktuellen Spieler<br>
 <br>*/
public class GUI {
        
    // Farbe des Spielfelds
    public final static String farbeSpielfeld = "#9CAF88";
    public final static int groesseX = 850;
    public final static int groesseY = 470;
    
    public final static String farbeGruen = "#465726";
    public final static String farbeRot = "#F57461";
    public final static String farbeBlau = "#64A5BB";
    public final static String farbeSchwarz = "#232B2B";
    public final static String farbeGelb = "#FDD782";
    public final static String farbeWeiss = "#F7F9EF";
    public final static String farbeGrau = "#3B444B";
    
    /**<br>
    * Prozedur stellt einen leeren Canvas als Hintergrund dar<br>
    <br>*/ 
    public static void leererCanvasDarstellen() {
    	Rechteck spielfeldRechteck = new Rechteck(0, 0, groesseX, groesseY, Grafik.WHITE, Grafik.BLACK, 1, "keineAktion");
    }

    
    /**<strong></strong><strong></strong><strong></strong><strong></strong> Einf&uuml;hrung <strong></strong><strong></strong><strong></strong><strong></strong>*<br>*/
    
    /**<br>
	* Prozedur zur Darstellung des Einf&uuml;hrungsmenüs<br>
    <br>*/
    public static void menueGrafischErzeugen() {
    	optionEinsGrafischErzeugen();
        optionZweiGrafischErzeugen();
        goButtonGrafischErzeugen();
    }
    
    /**<br>
	* Prozedur zur Darstellung der Option OOP1<br>
    <br>*/
    public static void optionEinsGrafischErzeugen() {
    	Rechteck rechteckOOP1 = new Rechteck(groesseX/2-250, groesseY/2-100, 200, 100, Grafik.GREEN, Grafik.BLACK, 1, 20, "oop1");
    	Text textOOP1 = new Text(groesseX/2-250+50, groesseY/2-100+10, "OOP1", Grafik.BLACK, 40, "oop1");
    }
    
    /**<br>
	* Prozedur zur Darstellung der Option OOP2<br>
    <br>*/
    public static void optionZweiGrafischErzeugen() { 
        Rechteck rechteckOOP2 = new Rechteck(groesseX/2+50, groesseY/2-100, 200, 100, Grafik.BLUE, Grafik.BLACK, 1, 20, "oop2");
    	Text textOOP2 = new Text(groesseX/2+50+50, groesseY/2-100+10, "OOP2", Grafik.BLACK, 40, "oop2");
    }
    
    /**<br>
	* Prozedur zur Darstellung der Auswahl OOP1<br>
    <br>*/
    public static void optionEinsGrafischAuswaehlen() {
    	Rechteck rechteckOOP1 = new Rechteck(groesseX/2-250, groesseY/2-100, 200, 100, Grafik.GREEN, Grafik.YELLOW, 2, 20, "oop1");
        Text textOOP1 = new Text(groesseX/2-250+40, groesseY/2-100, "OOP1", Grafik.YELLOW, 50, "oop1");
    }
    
    /**<br>
	* Prozedur zur Darstellung der Auswahl OOP2<br>
    <br>*/
    public static void optionZweiGrafischAuswaehlen() {
    	Rechteck rechteckOOP2 = new Rechteck(groesseX/2+50, groesseY/2-100, 200, 100, Grafik.BLUE, Grafik.YELLOW, 2, 20, "oop2");
    	Text textOOP2 = new Text(groesseX/2+50+40, groesseY/2-100, "OOP2", Grafik.YELLOW, 50, "oop2");
    }
    
    /**<br>
	* Prozedur zur Darstellung des Buttons, noch nicht bereit darauf geklickt zu werden<br>
    <br>*/
    public static void goButtonGrafischErzeugen() {
    	Button okButton = new Button(groesseX/2-50, groesseY/2+50, 100, 70, Grafik.GREY, "GO", Grafik.WHITE, 30, 5, "");
    }
    
    /**<br>
	* Prozedur zur Darstellung des Buttons, bereit darauf geklickt zu werden<br>
    <br>*/
    public static void goButtonGrafischZeigen() {
    	Button okButton = new Button(groesseX/2-50, groesseY/2+50, 100, 70, Grafik.BLACK, "GO", Grafik.WHITE, 30, 5, "auswaehlen");
    }
    
    /**<br>
	* Prozedur zur Darstellung des Buttons, bereits geklickt<br>
    <br>*/
    public static void goButtonGrafischKlicken() {
    	Button okButton = new Button(groesseX/2-50, groesseY/2+50, 100, 70, Grafik.YELLOW, "GO", Grafik.BLACK, 30, 5, "auswaehlen");
    }
 
    /**<br>
     * Funktion zum Darstellen eines grafischen Men&uuml;s zur Auswahl des Spielniveaus<br>
     * @return ausgew&auml;hltes Spielniveau<br>
     <br>*/
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

    
    /**<strong></strong><strong></strong><strong></strong><strong></strong> Tempel <strong></strong><strong></strong><strong></strong><strong></strong>*<br>*/

	/**<br>
    * Funktion f&uuml;r die Darstellung der Tempel gibt die Zahl des ausgew&auml;hlten Tempels zurück<br>
    * @return zahl, die einem Tempel entspricht (1,2,3 oder 4 - je nach Schritt)<br>
    <br>*/
    public static int tempelSymbolZeigen() {
    	Rechteck wasserTempel = new Rechteck(groesseX/2-330, groesseY/2-75, 150, 150, Grafik.BLUE, Grafik.BLACK, 1, 10, "1");
        Rechteck luftTempel = new Rechteck(groesseX/2-160, groesseY/2-75, 150, 150, Grafik.YELLOW, Grafik.BLACK, 1, 10, "2");
        Rechteck erdeTempel = new Rechteck(groesseX/2+10, groesseY/2-75, 150, 150, Grafik.GREEN, Grafik.BLACK, 1, 10, "3");
        Rechteck feuerTempel = new Rechteck(groesseX/2+180, groesseY/2-75, 150, 150, Grafik.RED, Grafik.BLACK, 1, 10, "4");
        // Auswahl zurückgeben
        return Konsole.eingabeZahl();
    }

	/**<br>
	* Prozedur zur Darstellung des Begr&uuml;&szlig;ungsnachricht in jedem Tempel<br>
    <br>*/
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


	/**<strong></strong><strong></strong><strong></strong><strong></strong> Quiz <strong></strong><strong></strong><strong></strong><strong></strong>*<br>*/

    /**<br>
    * Funktion stellt eine Quizfrage dar und gibt die ausgew&auml;hlte Antwort zur&uuml;ck<br>
    * @param frage<br>
    * @param antwortmoeglichkeiten<br>
    <br>*/
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
    
    
    /**<strong></strong><strong></strong><strong></strong><strong></strong> Spiel <strong></strong><strong></strong><strong></strong><strong></strong>*<br>*/
    
    /**<br>
    * Prozedur zur Darstellung der Pl&auml;tze f&uuml;r Karten in (j,i)<br>
    * @param j - Stelle auf der X-Achse<br>
    * @param i - Stelle auf der Y-Achse<br>
    <br>*/
    public static void platzFuerKarten(int j, int i) {
        Rechteck platzFuerKarte = new Rechteck(j, i, 50, 100, farbeSpielfeld, Grafik.GREY, 1, 10, "");
    }

    /**<br>
	* Prozedur zur Darstellung des Buttons, in Abh&auml;ngigkeit von der Gr&ouml;&szlig;e des Spielfels, noch nicht bereit darauf geklickt zu werden.<br>
    * @param x - Gr&ouml;&szlig;e X des Spielfelds<br>
    * @param y - Gr&ouml;&szlig;e Y des Spielfelds<br>
    <br>*/
    public static void unoButtonErzeugen(int x, int y) {
    	Button unoButton = new Button(x+40, y/2 + 135, 130, 70, Grafik.GREY, "UNO", Grafik.WHITE, 30, 5, "");
    }
    
    /**<br>
	* Prozedur zur Darstellung der Buttons, in Abh&auml;ngigkeit von der Gr&ouml;&szlig;e des Spielfels.<br>
    * @param x - Gr&ouml;&szlig;e X des Spielfelds<br>
    * @param y - Gr&ouml;&szlig;e Y des Spielfelds<br>
    <br>*/
    public static void linksRechtsButtonsErzeugen(int x, int y) {
    	Button linksButton = new Button(x-45, y/2 + 135, 30, 30, Grafik.WHITE, "<", Grafik.BLACK, 30, 5, "links");
        Button rechtsButton = new Button(x-45, y/2 + 175, 30, 30, Grafik.WHITE, ">", Grafik.BLACK, 30, 5, "rechts"); 
    }

    /**<br>
    * Prozedur zum Darstellen eines leeren Spielfelds<br>
    * @param x - Gr&ouml;&szlig;e X des Spielfelds<br>
    * @param y - Gr&ouml;&szlig;e Y des Spielfelds<br>
    <br>*/
    public static void stelleSpielfeldBereit(int x, int y) {
    	// Rand vom Spielbrett
     	int rand = 5;
     
        // Spielfeld leer als Rechteck darstellen    
    	Rechteck spielfeldRechteck = new Rechteck(0+rand, 0+rand, x+rand, y+rand, farbeSpielfeld, Grafik.BLACK, 1, "");
        
        // Leere Plätze für die Karten erzeugen
    	for(int i = 10+rand; i < y-100; i = i + 330) {
        	for(int j = 10+rand; j < x-100; j = j + 60) {
                platzFuerKarten(j,i);
            }
    	}
        
        // Platz für gespielte Karten und den Kartenstapel
        platzFuerKarten(15+60*3, y/2-50);
        platzFuerKarten(15+60*6, y/2-50);
        // KartenStapel darstellen
        stapelDarstellen(15+60*6, y/2-50);
        
        // Buttons zum Zeigen der Karten oben oder unten
        linksRechtsButtonsErzeugen(x,y);
        // Uno-Button erzeugen
        unoButtonErzeugen(x,y);
    }
    
    /**<br>
     * Prozedur setzt Karte an die gegebene Position auf dem Spielfeld<br>
     * @param karte - zu platzierende Karte<br>
     * @param j - Koordinate in X-Achse<br>
     * @param i - Koordinate in Y-Achse<br>
     <br>*/
    public static void setzeKarteAufSpielfeld(Karte karte, int j, int i) {
        // Spielfeldrand auf 5 setzen
        int rand = 5;
        // Variablen für die Darstellung berechnen
        int x = rand + 10 + 60*j;
        int y = rand + 10 + 165*i;
        // Fallunterscheidung prüfen
        if(i == 0) {
            // DummyKarte für den Gegner einsetzen
            karte.setzeKarteAuf(j,i,x,y,false);
        } else if(i == 1) {
            // Karte auf den Ablagenstapel setzen
        	karte.setzeKarteAuf(j,i,x,y-4,true);
        } else if(i == 2) {
            // Karte für den menschlichen Spieler auf Position (x,y) setzen
            karte.setzeKarteAuf(j,i,x,y,false);
        }

    }

    /**<br>
     * Prozedur zum Darstellen des KartenStapels<br>
     * @param positionX - Koordinate auf X-Achse<br>
     * @param positionY - Koordinate auf Y-Achse<br>
     <br>*/
    public static void stapelDarstellen(int positionX, int positionY) {
    	Rechteck grafikRechteckMitRundung = new Rechteck(positionX, positionY, 50, 100, Grafik.BLACK, Grafik.WHITE, 2, 10, "karteZiehen");
        Text uStapelText = new Text(positionX+20, positionY+10, "U", Grafik.WHITE, 20,"karteZiehen");
        Text nStapelText = new Text(positionX+20, positionY+30, "N", Grafik.WHITE, 20,"karteZiehen");
    	Text oStapelText = new Text(positionX+20, positionY+50, "O", Grafik.WHITE, 20,"karteZiehen");
    }
    
    /**<br>
     * Funktion stellt eine Men&uuml; zur Auswahl der neuen Farbe und gibt diese zurück<br>
     * @return farbe - String mit der ausgew&auml;hlte Farbe<br>
     <br>*/
    public static String farbeAuswaehlen() {
    	// Meldung auf die Konsole ausgeben
        System.out.println("Wähle bitte eine neue Farbe");
		// Variablen für die Größe des Spielfelds
    	int groesseX = 660;
        int groesseY = 450;
        // Menü zur Auswahl darstellen
        Rechteck rechteckFarbAuswahl = new Rechteck(groesseX + 40, groesseY/2 - 100, 130, 130, Grafik.WHITE, Grafik.BLACK, 1, 10, "");
        Rechteck rechteckBlau = new Rechteck(groesseX + 50, groesseY/2 - 90, 50, 50, Grafik.BLUE, Grafik.BLACK, 1, 10, "blau");
        Rechteck rechteckGelb = new Rechteck(groesseX + 110, groesseY/2 - 90, 50, 50, Grafik.YELLOW, Grafik.BLACK, 1, 10, "gelb");
        Rechteck rechteckGruen = new Rechteck(groesseX + 50, groesseY/2 - 30, 50, 50, Grafik.GREEN, Grafik.BLACK, 1, 10, "gruen");
        Rechteck rechteckRot = new Rechteck(groesseX + 110, groesseY/2 - 30, 50, 50, Grafik.RED, Grafik.BLACK, 1, 10, "rot");
        // Farbe auswählen
        String farbe = "";
        while(farbe.compareTo("blau") != 0 && farbe.compareTo("gelb") != 0 && farbe.compareTo("gruen") != 0 && farbe.compareTo("rot") != 0) {
        	farbe = Konsole.eingabeString();
        }
        // Menü zur Auswahl entfernen
        rechteckFarbAuswahl.delete();
        rechteckBlau.delete();
        rechteckGelb.delete();
        rechteckGruen.delete();
        rechteckRot.delete();
        // Reaktion zurückgeben
        System.out.println("Ausgewählte Farbe ist " + farbe);
        return farbe;
    }
    
    /**<br>
     * Funktion zum Darstellen des UNO-Buttons zum Klicken<br>
     * @return durch die Grafik Konsole gelesene String<br>
     <br>*/
    public static String unoKlicken(int x, int y) {
        Button unoButton = new Button(x+40, y/2 + 135, 130, 70, Grafik.BLACK, "UNO", Grafik.WHITE, 30, 5, "UNO");
        String uno = "";
        while(uno.compareTo("UNO") != 0) {
        	uno = Konsole.eingabeString();
        }
        unoButton.delete();
        return uno;
    }

	
    

    
    /**<br>
    * Prozedur zum Darstellen einer Karte<br>
    <br>*/
/*    public static void karteDarstellen(Karte uebergebeneKarte, int y, int x){
    
    	if(uebergebeneKarte != null){
        
        	if(uebergebeneKarte.istWelcheKarte("Farb")){
				KartenDesign.farbKarte(x,y,GUI.setKartenFarbe(uebergebeneKarte.getFarbe()),Integer.toString(uebergebeneKarte.getNummer()));
        	}
            
        	if(uebergebeneKarte.istWelcheKarte("Wunsch")){
        		KartenDesign.wunschKarte(x,y);
        	}
        	if(uebergebeneKarte.istWelcheKarte("PlusVierWunsch")){
        		KartenDesign.plusVierWunschKarte(x,y);
        	}
        	if(uebergebeneKarte.istWelcheKarte("PlusZwei")){
        		KartenDesign.plusZweiKarte(x,y,GUI.setKartenFarbe(uebergebeneKarte.getFarbe()));
        	}
        	if(uebergebeneKarte.istWelcheKarte("Aussetzen")){
        		KartenDesign.aussetzenKarte(x,y,GUI.setKartenFarbe(uebergebeneKarte.getFarbe()));
        	}
       	 	if(uebergebeneKarte.istWelcheKarte("Retour")){
       	 		KartenDesign.retourKarte(x,y,GUI.setKartenFarbe(uebergebeneKarte.getFarbe()));
        	}
        	if(uebergebeneKarte.istWelcheKarte("Dummy")){
        		KartenDesign.dummyKarte(x,y);
      	  	}
        }else{
        	KartenDesign.leereKarte(x,y);
        }
            
	}*/
    

} // Ende von GUI