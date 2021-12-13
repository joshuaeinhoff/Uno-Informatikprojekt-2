package unotempel;

import unotempel.grafikkonsole.*;
import unotempel.konsole.*;
import unotempel.kartenspiel.*;
import unotempel.*;

/**
 * Klasse zur Darstellung und Interaktion mit einem aktuellen Spieler
 */
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
    
    public static Rechteck lebenspunkteHeld;
    
    /**
    * Prozedur stellt einen leeren Canvas als Hintergrund dar
    */ 
    public static void leererCanvasDarstellen() {
    	Rechteck spielfeldRechteck = new Rechteck(0, 0, groesseX, groesseY, Grafik.WHITE, Grafik.BLACK, 1, "");
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
	* Prozedur zur Darstellung der Option OOP1
    */
    public static void optionEinsGrafischErzeugen() {
    	Rechteck rechteckOOP1 = new Rechteck(groesseX/2-250, groesseY/2-100, 200, 100, Grafik.GREEN, Grafik.BLACK, 1, 20, "oop1");
    	Text textOOP1 = new Text(groesseX/2-250+50, groesseY/2-100+10, "OOP1", Grafik.BLACK, 40, "oop1");
    }
    
    /**
	* Prozedur zur Darstellung der Option OOP2
    */
    public static void optionZweiGrafischErzeugen() { 
        Rechteck rechteckOOP2 = new Rechteck(groesseX/2+50, groesseY/2-100, 200, 100, Grafik.BLUE, Grafik.BLACK, 1, 20, "oop2");
    	Text textOOP2 = new Text(groesseX/2+50+50, groesseY/2-100+10, "OOP2", Grafik.BLACK, 40, "oop2");
    }
    
    /**
	* Prozedur zur Darstellung der Auswahl OOP1
    */
    public static void optionEinsGrafischAuswaehlen() {
    	Rechteck rechteckOOP1 = new Rechteck(groesseX/2-250, groesseY/2-100, 200, 100, Grafik.GREEN, Grafik.YELLOW, 2, 20, "oop1");
        Text textOOP1 = new Text(groesseX/2-250+40, groesseY/2-100, "OOP1", Grafik.YELLOW, 50, "oop1");
    }
    
    /**
	* Prozedur zur Darstellung der Auswahl OOP2
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
        // Warte 5 Sekunden darauf
        okButton.waitFor(500);
    }
 
    /**
     * Funktion zum Darstellen eines grafischen Menüs zur Auswahl des Spielniveaus
     * @return ausgewähltes Spielniveau
     */
    public static int menueGrafischAuswaehlen() {
    	// SpielNiveau als leerer String erzeugen
    	String spielNiveau = "";
        // Solange den OK-Button nicht darauf geklickt wird
        while(!Konsole.eingabeString().equals("auswaehlen")) {
        	// SpielNiveau als Reaktion einlesen
        	spielNiveau = Konsole.eingabeString();
        	// Bedingung überprüuft, ob die ausgewählte Option OOP1 ist
            if(spielNiveau.equals("oop1")) {
            	// Darstellung der ausgewählte Option ändern und ggf. die gerade nicht ausgewählte Option wiederherzustellen
                optionEinsGrafischAuswaehlen();       
                optionZweiGrafischErzeugen();
                // Button grafisch anzeigen, bereit darauf geklickt zu werden
                goButtonGrafischZeigen();
            }
            // Bedingung überprüuft, ob die ausgewählte Option OOP2 ist
            if(spielNiveau.equals("oop2")) {
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
    * @return zahl, die einem Tempel entspricht (1,2,3 oder 4 - je nach Schritt)
    */
    public static int tempelSymbolZeigen() {
    	Rechteck wasserTempel = new Rechteck(groesseX/2-330, groesseY/2-75, 150, 150, Grafik.BLUE, Grafik.BLACK, 1, 10, "1");
        wasserTempel.hide();
        wasserTempel.waitFor(300);
        wasserTempel.show();
        Rechteck luftTempel = new Rechteck(groesseX/2-160, groesseY/2-75, 150, 150, Grafik.YELLOW, Grafik.BLACK, 1, 10, "2");
        luftTempel.hide();
        luftTempel.waitFor(300);
        luftTempel.show();
        Rechteck erdeTempel = new Rechteck(groesseX/2+10, groesseY/2-75, 150, 150, Grafik.GREEN, Grafik.BLACK, 1, 10, "3");
        erdeTempel.hide();
        erdeTempel.waitFor(300);
        erdeTempel.show();
        Rechteck feuerTempel = new Rechteck(groesseX/2+180, groesseY/2-75, 150, 150, Grafik.RED, Grafik.BLACK, 1, 10, "4");
        feuerTempel.hide();
        feuerTempel.waitFor(300);
        feuerTempel.show();
        // Auswahl zurückgeben
        int eingabe = 0;
        while(eingabe == 0 || Konsole.eingabeString().equals("")) {
        	eingabe = Konsole.eingabeZahl();
        }
        return eingabe;
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
        if(Konsole.eingabeString().equals("auswaehlen")) {
        	// Button grafisch darauf klicken (ist momentan nicht wichtig)
        	goButtonGrafischKlicken();
        }
    }


	/****************** Quiz ******************/

    /**
    * Funktion stellt eine Quizfrage dar und gibt die ausgewählte Antwort zurück
    * @param frage
    * @param antwortmoeglichkeiten
    */
    public static char quizDarstellen(String frage, String[] antwortmoeglichkeiten) {
		// Ausgewählte Antwort erstmal leer erzeugen
        char ausgewaehlteAntwort = ' ';
        // Grafik-Konsole einmal initialisieren
        GrafikKonsole.clearGrafik();
        // Leerer Canvas darstellen
        GUI.leererCanvasDarstellen();
        // Titel als Text darstellen
		Text frageText = new Text(10, 10, "Frage", Grafik.BLACK, 20, "");
        // Aktuelle Frage darstellen
        Text aktuelleFrageText = new Text(10, 50, frage+"", Grafik.BLACK, 15, "");
        
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
        // Variable für die Eingabe aus der Konsole erstmal definieren und initialisieren
        String eingabe = Konsole.eingabeString();
        // Solange keine gültige Antwort ausgewählt wird
        while(eingabe.equals("")) {
        	// Meldung auf die Konsole ausgeben
        	System.out.println("Wähle bitte eine gültige Antwort");
			// Wert durch die Konsole einlesen
        	eingabe = Konsole.eingabeString();   
    	}
        // Ausgewählte Antwort in char umwandeln
        ausgewaehlteAntwort = Konsole.eingabeString().charAt(0);
        // Ausgewählte Antwort zurückgeben
        return ausgewaehlteAntwort;
    }
    
    
    /****************** Spiel ******************/
    
    /**
    * Prozedur zur Darstellung der Plätze für Karten in (j,i)
    * @param j - Stelle auf der X-Achse
    * @param i - Stelle auf der Y-Achse
    */
    public static void platzFuerKarten(int j, int i) {
        Rechteck platzFuerKarte = new Rechteck(j, i, 50, 100, farbeSpielfeld, Grafik.GREY, 1, 10, "");
        // Warte 2 Sekunden darauf
        platzFuerKarte.hide();
        platzFuerKarte.waitFor(200);
        platzFuerKarte.show();
    }

    /**
	* Prozedur zur Darstellung des Buttons, in Abhängigkeit von der Größe des Spielfels, noch nicht bereit darauf geklickt zu werden.
    * @param x - Größe X des Spielfelds
    * @param y - Größe Y des Spielfelds
    */
    public static void unoButtonErzeugen(int x, int y) {
    	Button unoButton = new Button(x+40, y/2 + 135, 130, 70, Grafik.GREY, "UNO", Grafik.WHITE, 30, 5, "");
        // Warte 2 Sekunden darauf
        unoButton.hide();
        unoButton.waitFor(200);
        unoButton.show();
    }
    
    /**
	* Prozedur zur Darstellung der Buttons, in Abhängigkeit von der Größe des Spielfels.
    * @param x - Größe X des Spielfelds
    * @param y - Größe Y des Spielfelds
    */
    public static void linksRechtsButtonsErzeugen(int x, int y) {
    	Button linksButton = new Button(x-45, y/2 + 135, 30, 30, Grafik.WHITE, "<", Grafik.BLACK, 30, 5, "links");
        Button rechtsButton = new Button(x-45, y/2 + 175, 30, 30, Grafik.WHITE, ">", Grafik.BLACK, 30, 5, "rechts");
        // Warte 2 Sekunden darauf
        linksButton.hide();
        rechtsButton.hide();
        linksButton.waitFor(200);
        rechtsButton.waitFor(200);
        linksButton.show();
        rechtsButton.show();   
    }

    /**
    * Prozedur zum Darstellen eines leeren Spielfelds
    * @param x - Größe X des Spielfelds
    * @param y - Größe Y des Spielfelds
    */
    public static void stelleSpielfeldBereit(int x, int y) {
    	// Rand vom Spielbrett
     	int rand = 5;
     	
        // Spielfeld leer als Rechteck darstellen    
    	Rechteck spielfeldRechteck = new Rechteck(0+rand, 0+rand, x+rand, y+rand, farbeSpielfeld, Grafik.BLACK, 1, "");
        // Warte 3 Sekunden darauf
        spielfeldRechteck.hide();
        spielfeldRechteck.waitFor(300);
        spielfeldRechteck.show();
        
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
    
    /**
     * Prozedur setzt Karte an die gegebene Position auf dem Spielfeld
     * @param karte - zu platzierende Karte
     * @param j - Koordinate in X-Achse
     * @param i - Koordinate in Y-Achse
     */
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

    /**
     * Prozedur zum Darstellen des KartenStapels
     * @param positionX - Koordinate auf X-Achse
     * @param positionY - Koordinate auf Y-Achse
     */
    public static void stapelDarstellen(int positionX, int positionY) {
    	Rechteck grafikRechteckMitRundung = new Rechteck(positionX, positionY, 50, 100, farbeGrau, Grafik.WHITE, 2, 10, "karteZiehen");
        Text uStapelText = new Text(positionX+20, positionY+10, "U", Grafik.WHITE, 20,"karteZiehen");
        Text nStapelText = new Text(positionX+20, positionY+30, "N", Grafik.WHITE, 20,"karteZiehen");
    	Text oStapelText = new Text(positionX+20, positionY+50, "O", Grafik.WHITE, 20,"karteZiehen");
        // Warte 2 Sekunden darauf
        grafikRechteckMitRundung.hide();
        uStapelText.hide();
        nStapelText.hide();
        oStapelText.hide();
        grafikRechteckMitRundung.waitFor(200);
        uStapelText.waitFor(200);
        nStapelText.waitFor(200);
        oStapelText.waitFor(200);
        grafikRechteckMitRundung.show();
        uStapelText.show();
        nStapelText.show();
        oStapelText.show();
    }
    
    /**
     * Funktion stellt eine Menü zur Auswahl der neuen Farbe und gibt diese zurück
     * @return farbe - String mit der ausgewählte Farbe
     */
    public static int farbeAuswaehlen() {
    	// Meldung auf die Konsole ausgeben
        System.out.println("Wähle bitte eine neue Farbe");
		// Variablen für die Größe des Spielfelds
    	int groesseX = 660;
        int groesseY = 450;
        // Menü zur Auswahl darstellen
        Rechteck rechteckFarbAuswahl = new Rechteck(groesseX + 40, groesseY/2 - 100, 130, 130, Grafik.WHITE, Grafik.BLACK, 1, 10, "");
        Rechteck rechteckBlau = new Rechteck(groesseX + 50, groesseY/2 - 90, 50, 50, Grafik.BLUE, Grafik.BLACK, 1, 10, "0");
        Rechteck rechteckGelb = new Rechteck(groesseX + 110, groesseY/2 - 90, 50, 50, Grafik.YELLOW, Grafik.BLACK, 1, 10, "1");
        Rechteck rechteckGruen = new Rechteck(groesseX + 50, groesseY/2 - 30, 50, 50, Grafik.GREEN, Grafik.BLACK, 1, 10, "2");
        Rechteck rechteckRot = new Rechteck(groesseX + 110, groesseY/2 - 30, 50, 50, Grafik.RED, Grafik.BLACK, 1, 10, "3");
        // Farbe auswählen, Variable farbe definieren
        int farbe = -1;
        // Solange die Farbe keine der Farben entspricht
        while(farbe < 0 || farbe > 3) {
            // Eingabe durch die Konsole lesen und Wert in der Variable speichern
        	farbe = Konsole.eingabeZahl();
        }
        // Menü zur Auswahl entfernen
        rechteckFarbAuswahl.delete();
        rechteckBlau.delete();
        rechteckGelb.delete();
        rechteckGruen.delete();
        rechteckRot.delete();
        // Reaktion zurückgeben
        return farbe;
    }
    
    
    /**
     * Funktion zum Darstellen des UNO-Buttons zum Klicken
     * @return durch die Grafik Konsole gelesene String
     */
    public static String unoKlicken(int x, int y) {
        Button unoButton = new Button(x+40, y/2 + 135, 130, 70, Grafik.BLACK, "UNO", Grafik.WHITE, 30, 5, "UNO");
        String uno = "";
        while(!uno.equals("UNO")) {
        	uno = Konsole.eingabeString();
        }
        unoButton.delete();
        return uno;
    }

	/**
    *
    * @param spieler
    */
    public static void stelleLebenspunkteDar(Spieler spieler) {
    	// Variable für die Lebenspunkte des Spielers
        int aktuellePunkte = spieler.getLebenspunkte();
        // Lebenspunkte für die grafische Darstellung berechnen
        // 848 = 150 Punkte
        int punkte = (int)(aktuellePunkte * 848 / 150);
        // Lebenspunkte zeigen
    	Text lebensanzeige = new Text(0, 475, "Lebenspunkte", Grafik.BLACK, 15, "");
        Rechteck platzLebenspunkte = new Rechteck(0, 500, 850, 20, Grafik.WHITE, Grafik.BLACK, 1, "");
        lebenspunkteHeld = new Rechteck(1, 501, punkte, 18, Grafik.GREEN, Grafik.BLACK, 0, "");
    }
    
    public static void zeigeAktualisierteLebenspunkte(Spieler spieler) {
        // Variable für die Lebenspunkte des Spielers
        int aktuellePunkte = spieler.getLebenspunkte();
        // Lebenspunkte für die grafische Darstellung berechnen
        // 848 = 150 Punkte
        int punkte = (int)(aktuellePunkte * 848 / 150);
        if(punkte > 848)
        	punkte = 848;
        lebenspunkteHeld.setWidth(punkte);
    }
    

} // Ende von GUI