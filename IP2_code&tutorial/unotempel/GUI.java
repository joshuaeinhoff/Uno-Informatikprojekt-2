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
    public final static String FARBE_SPIELFELD = "#9CAF88";
    // Maße des Spielfelds
    public final static int BREITE = 850;
    public final static int HOEHE = 470;
    // Farben für die Darstellung der Karten
    public final static String FARBE_WEISS = "#F7F9EF";
    public final static String FARBE_SCHWARZ = "#232B2B";
    public final static String FARBE_GRAU = "#3B444B";
    public final static String FARBE_GRUEN = "#465726";
    public final static String FARBE_ROT = "#F57461";
    public final static String FARBE_BLAU = "#64A5BB";
    public final static String FARBE_GELB = "#FDD782";
    // Rechteck für die Darstellung der Lebenspunkte vom Held
    public static Rechteck lebenspunkteHeld;
    

    /**
    * Prozedur stellt einen leeren Spielbrett mit den Lebenspunkte von Spieler dar
    * @param spieler - Spieler Held
    */ 
    public void spielbrettDarstellen(Spieler spieler) {
    	// Grafik-Konsole einmal initialisieren
        GrafikKonsole.clearGrafik();
        // Rechteck als leerer Canvas darstellen
    	Rechteck spielfeldRechteck = new Rechteck(0, 0, BREITE, HOEHE, Grafik.WHITE, Grafik.BLACK, 1, "");
        // Lebenspunkte vom Spieler darstellen
        stelleLebenspunkteDar(spieler);
    }
    
    
    /**
    * Private Prozedur stellt Lebenspunkte vom Spieler dar
    * @param spieler - Spieler Held
    */
    private void stelleLebenspunkteDar(Spieler spieler) {
    	// Variable für die Lebenspunkte des Spielers
        int aktuellePunkte = spieler.getLebenspunkte();
        // Lebenspunkte für die grafische Darstellung berechnen, maximal 100 Punkte
        int punkte = (int)(aktuellePunkte * 848 / 100);
        // Lebenspunkte zeigen
    	Text lebensanzeige = new Text(0, 475, "Lebenspunkte", Grafik.BLACK, 15, "");
        Rechteck platzLebenspunkte = new Rechteck(0, 500, 850, 20, "#006400", Grafik.BLACK, 1, "");
        lebenspunkteHeld = new Rechteck(1, 501, punkte, 18, Grafik.GREEN, Grafik.BLACK, 0, "");
    }
    

    /**
    * Prozedur aktualisiert visuell die Lebenspunkte vom Spieler
    * @param spieler - Spieler Held
    */
    public void aktualisiereLebenspunkte(Spieler spieler) {
        // Variable für die Lebenspunkte des Spielers
        int aktuellePunkte = spieler.getLebenspunkte();
        // Lebenspunkte für die grafische Darstellung berechnen, maximal 100 Punkte
        int punkte = (int)(aktuellePunkte * 848 / 100);
        if(punkte > 848)
        	punkte = 848;
        lebenspunkteHeld.setWidth(punkte);
        // Lebenspunkte darstellen -> nötig?
        //stelleLebenspunkteDar(spieler);
    }

    
    /************************************ Einführung ************************************/
    
    /**
	* Prozedur zur Darstellung des Einführungsmenüs
    */
    public void menueGrafischErzeugen() {
        // OOP1 Option erzeugen
    	optionEinsGrafischErzeugen();
        // OOP2 Option erzeugen
        optionZweiGrafischErzeugen();
        // Button erzeugen
        goButtonGrafischErzeugen();
    }
    

    /**
	* Prozedur zur Darstellung der Option OOP1
    */
    public void optionEinsGrafischErzeugen() {
        // Variablen für die Darstellung der Option OOP1
    	Rechteck rechteckOOP1 = new Rechteck(BREITE/2-250, HOEHE/2-100, 200, 100, Grafik.GREEN, Grafik.BLACK, 1, 20, "oop1");
    	Text textOOP1 = new Text(BREITE/2-250+50, HOEHE/2-100+10, "OOP1", Grafik.BLACK, 40, "");
    }
    

    /**
	* Prozedur zur Darstellung der Option OOP2
    */
    public void optionZweiGrafischErzeugen() { 
        // Variablen für die Darstellung der Option OOP2
        Rechteck rechteckOOP2 = new Rechteck(BREITE/2+50, HOEHE/2-100, 200, 100, Grafik.BLUE, Grafik.BLACK, 1, 20, "oop2");
    	Text textOOP2 = new Text(BREITE/2+50+50, HOEHE/2-100+10, "OOP2", Grafik.BLACK, 40, "");
    }
    

    /**
	* Prozedur zur Darstellung der Auswahl OOP1
    */
    public void optionEinsGrafischAuswaehlen() {
        // Variablen für die Darstellung der Option OOP1 ausgewählt
    	Rechteck rechteckOOP1 = new Rechteck(BREITE/2-250, HOEHE/2-100, 200, 100, Grafik.GREEN, Grafik.YELLOW, 2, 20, "oop1");
        Text textOOP1 = new Text(BREITE/2-250+40, HOEHE/2-100, "OOP1", Grafik.YELLOW, 50, "");
    }
    

    /**
	* Prozedur zur Darstellung der Auswahl OOP2
    */
    public void optionZweiGrafischAuswaehlen() {
        // Variablen für die Darstellung der Option OOP2 ausgewählt
    	Rechteck rechteckOOP2 = new Rechteck(BREITE/2+50, HOEHE/2-100, 200, 100, Grafik.BLUE, Grafik.YELLOW, 2, 20, "oop2");
    	Text textOOP2 = new Text(BREITE/2+50+40, HOEHE/2-100, "OOP2", Grafik.YELLOW, 50, "");
    }
    

    /**
	* Prozedur zur Darstellung des Buttons, noch nicht bereit darauf geklickt zu werden
    */
    public void goButtonGrafischErzeugen() {
        // Variable für die Darstellung des Buttons
    	Button goButton = new Button(BREITE/2-50, HOEHE/2+50, 100, 70, Grafik.GREY, "GO", Grafik.WHITE, 30, 5, "");
    }
    

    /**
	* Prozedur zur Darstellung des Buttons, bereit darauf geklickt zu werden
    */
    public void goButtonGrafischZeigen() {
        // Variable für die Darstellung des Buttons angezeigt
    	Button goButton = new Button(BREITE/2-50, HOEHE/2+50, 100, 70, Grafik.BLACK, "GO", Grafik.WHITE, 30, 5, "auswaehlen");
    }
    

    /**
	* Prozedur zur Darstellung des Buttons, bereits geklickt
    */
    public void goButtonGrafischKlicken() {
        // Variablen für die Darstellung des Buttons geklickt
    	Button goButton = new Button(BREITE/2-50, HOEHE/2+50, 100, 70, Grafik.YELLOW, "GO", Grafik.BLACK, 30, 5, "auswaehlen");
        // Warte 0.5 Sekunden darauf
        goButton.waitFor(500);
    }
 

    /**
     * Funktion zum Darstellen eines grafischen Menüs zur Auswahl des Spielniveaus
     * @return ausgewähltes Spielniveau
     */
    public int menueGrafischAuswaehlen() {
    	// Satz zur Auswahl eines Niveaus darstellen
    	Rechteck aufgabenstellungRechteck = new Rechteck(10, 10, 800, 30, Grafik.GREY, Grafik.WHITE, 0, "");
		Text aufgabenstellungText = new Text(20, 10, "Wählen Sie bitte ein Niveau aus:", Grafik.WHITE, 20, "");    
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

    
    /************************************ Tempel ************************************/

	/**
    * Funktion für die Darstellung der Tempel gibt die Zahl des ausgewählten Tempels zurück
    * @return zahl, die einem Tempel entspricht (1,2,3 oder 4 - je nach Schritt)
    */
    public int tempelSymbolZeigen() {
        // Wasser-Tempel Symbol erzeugen, verstecken und nach 0.3 Sekunden zeigen
    	Rechteck wasserTempel = new Rechteck(BREITE/2-330, HOEHE/2-75, 150, 150, FARBE_BLAU, FARBE_SCHWARZ, 1, 10, "1");
        wasserTempel.hide();
        wasserTempel.waitFor(300);
        wasserTempel.show();
        // Luft-Tempel Symbol erzeugen, verstecken und nach 0.3 Sekunden zeigen
        Rechteck luftTempel = new Rechteck(BREITE/2-160, HOEHE/2-75, 150, 150, FARBE_GELB, Grafik.BLACK, 1, 10, "2");
        luftTempel.hide();
        luftTempel.waitFor(300);
        luftTempel.show();
        // Erde-Tempel Symbol erzeugen, verstecken und nach 0.3 Sekunden zeigen
        Rechteck erdeTempel = new Rechteck(BREITE/2+10, HOEHE/2-75, 150, 150, FARBE_GRUEN, Grafik.BLACK, 1, 10, "3");
        erdeTempel.hide();
        erdeTempel.waitFor(300);
        erdeTempel.show();
        // Feuer-Tempel Symbol erzeugen, verstecken und nach 0.3 Sekunden zeigen
        Rechteck feuerTempel = new Rechteck(BREITE/2+180, HOEHE/2-75, 150, 150, FARBE_ROT, Grafik.BLACK, 1, 10, "4");
        feuerTempel.hide();
        feuerTempel.waitFor(300);
        feuerTempel.show();
        // Auswahl durch die Grafik Konsole auslesen
        int eingabe = 0;
        // Es muss eine Zahl zwischen 1 und 4 ausgelesen werden, d.h. weder 0 noch einen Zeichenkette
        while(eingabe == 0 || Konsole.eingabeString().equals("")) {
        	eingabe = Konsole.eingabeZahl();
        }
        // Auswahl zurückgeben
        return eingabe;
    }


	/**
	* Prozedur zur Darstellung des Begrüßungsnachricht in jedem Tempel
    */
	public void begruessungsnachrichtDarstellen(String[] nachricht) {
        // Variablen für die Darstellung der Nachricht in Zeilen geteilt
        Text textTempelEinfuehrungZeile1 = new Text(BREITE/2-250, HOEHE/2-150, nachricht[0] +"", Grafik.BLACK, 20, "");
        Text textTempelEinfuehrungZeile2 = new Text(BREITE/2-180, HOEHE/2-120, nachricht[1] +"", Grafik.BLACK, 20, "");
        Text textTempelEinfuehrungZeile3 = new Text(BREITE/2-150, HOEHE/2-90, nachricht[2] +"", Grafik.BLACK, 20, "");
        // Button grafisch anzeigen, bereit darauf geklickt zu werden
        goButtonGrafischZeigen();
        // Prüfen, ob die gelesene Zeichenkette dem richtigen Wert entspricht
        if(Konsole.eingabeString().equals("auswaehlen")) {
        	// Button grafisch darauf klicken - hier nur wichtig um weiter zu machen
        	goButtonGrafischKlicken();
        }
    }


	/************************************ Quiz ************************************/

    /**
    * Funktion stellt eine Quizfrage dar und gibt die ausgewählte Antwort zurück
    * @param frage - Frage zum Darstellen
    * @param antwortmoeglichkeiten als Array von String mit Antwortmöglichkeiten zum Darstellen
    * @return ausgewählte Antwort als char
    */
    public char quizDarstellen(String frage, String[] antwortmoeglichkeiten) {
		// Ausgewählte Antwort erstmal leer erzeugen
        
        char ausgewaehlteAntwort = ' ';
        // Aufgabenstellung darstellen
        Rechteck aufgabenstellungRechteck = new Rechteck(10, 10, 800, 30, Grafik.GREY, Grafik.WHITE, 0, "");
		Text aufgabenstellungText = new Text(20, 10, "Wählen Sie bitte die richtige Antwort:", Grafik.WHITE, 20, "");
        
        // Aktuelle Frage darstellen
        Rechteck frageRechteck = new Rechteck(10, 50, 800, 80, Grafik.WHITE, Grafik.WHITE, 0, "");
        // Frage formatieren
        int index = 70;
        // Prüfen, ob Länge der Frage kleiner oder gleich als Index ist
        if(frage.length() <= index) {
            // Frage als Text darstellen
        	Text frageText = new Text(20, 60, frage+"", Grafik.BLACK, 18, "");
        // Länge der Frage ist größer als Index
        } else {
            // Solange der Index die Länge der Frage nicht überschreitet und das Zeichen an der Stelle von Index kein leeres Zeichen ist
            while(index < frage.length() && frage.charAt(index) != ' ') {
                // Index inkrementieren
            	index++;
            }
            // Frage in zwei Zeilen teilen
            String frageTeil1 = frage.substring(0, index);
            String frageTeil2 = frage.substring(index);
            // Frage als Text darstellen
            Text frageTeil1Text = new Text(20, 60, frageTeil1+"", Grafik.BLACK, 18, "");
            Text frageTeil2Text = new Text(20, 80, frageTeil2+"", Grafik.BLACK, 18, "");
        }
        
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
    * @param x - X-Koordinate im Spielbrett
    * @param y - Y-Koordinate im Spielbrett
    */
    public void platzFuerKarten(int x, int y) {
        // Variable für die Darstellung eines Platzes für die Karten
        Rechteck platzFuerKarte = new Rechteck(x, y, 50, 100, FARBE_SPIELFELD, Grafik.GREY, 1, 10, "");
        // Reckteck verstecken und nach 0.2 Sekunden anzeigen
        platzFuerKarte.hide();
        platzFuerKarte.waitFor(200);
        platzFuerKarte.show();
    }


    /**
	* Prozedur zur Darstellung des Buttons, in Abhängigkeit von der Größe des Spielfels, noch nicht bereit darauf geklickt zu werden.
    * @param x - X-Koordinate im Spielbrett
    * @param y - Y-Koordinate im Spielbrett
    */
    public void unoButtonErzeugen(int x, int y) {
        // Variable für die Darstellung des UNO-Buttons
    	Button unoButton = new Button(x+40, y/2 + 135, 130, 70, Grafik.GREY, "UNO", Grafik.WHITE, 30, 5, "");
        // Button verstecken und nach 0.2 Sekunden anzeigen
        unoButton.hide();
        unoButton.waitFor(200);
        unoButton.show();
    }
    

    /**
	* Prozedur zur Darstellung der Buttons, in Abhängigkeit von der Größe des Spielfels.
    * @param x - X-Koordinate im Spielbrett
    * @param y - Y-Koordinate im Spielbrett
    */
    public void linksRechtsButtonsErzeugen(int x, int y) {
        // Variablen für die Darstellung von einem Link-Button und einem Recht-Button
    	Button linksButton = new Button(x-45, y/2 + 135, 30, 30, Grafik.WHITE, "<", Grafik.BLACK, 30, 5, "links");
        Button rechtsButton = new Button(x-45, y/2 + 175, 30, 30, Grafik.WHITE, ">", Grafik.BLACK, 30, 5, "rechts");
        // Variablen verstecken und nach 0.2 Sekunden anzeigen
        linksButton.hide();
        rechtsButton.hide();
        linksButton.waitFor(200);
        rechtsButton.waitFor(200);
        linksButton.show();
        rechtsButton.show();   
    }


    /**
    * Prozedur zum Darstellen eines leeren Spielfelds
    * @param x - X-Koordinate im Spielbrett
    * @param y - Y-Koordinate im Spielbrett
    */
    public void stelleSpielfeldBereit(int x, int y) {
    	// Variable für den Rand vom Spielbrett
     	int rand = 5;
     	
        // Spielfeld leer als Rechteck darstellen    
    	Rechteck spielfeldRechteck = new Rechteck(0+rand, 0+rand, x+rand, y+rand, FARBE_SPIELFELD, Grafik.BLACK, 1, "");
        // Rechteck verstecken und nach 0.3 Sekunden anzeigen
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
     * @param spalte - Koordinate in X-Achse
     * @param zeile - Koordinate in Y-Achse
     */
    public void setzeKarteAufSpielfeld(Karte karte, int spalte, int zeile) {
        // Spielfeldrand auf 5 setzen
        int rand = 5;
        // Variablen für die Darstellung auf dem Spielbrett berechnen
        int x = rand + 10 + 60*spalte;
        int y = rand + 10 + 165*zeile;
        // Fallunterscheidung prüfen
        if(zeile == 0) {
            // DummyKarte für den Gegner einsetzen
            karte.setzeKarteAuf(spalte,zeile,x,y,false);
        } else if(zeile == 1) {
            // Karte auf den Ablagenstapel setzen mit true als Parameter für aktuelle Karte
        	karte.setzeKarteAuf(spalte,zeile,x,y-4,true);
        } else if(zeile == 2) {
            // Karte für den menschlichen Spieler auf Position (x,y) setzen
            karte.setzeKarteAuf(spalte,zeile,x,y,false);
        }

    }


    /**
     * Prozedur zum Darstellen des KartenStapels
     * @param spalte - Koordinate auf X-Achse
     * @param zeile - Koordinate auf Y-Achse
     */
    public void stapelDarstellen(int spalte, int zeile) {
        // Variablen für die Darsellung des Kartenstapels
    	Rechteck grafikRechteckMitRundung = new Rechteck(spalte, zeile, 50, 100, FARBE_GRAU, Grafik.WHITE, 2, 10, "karteZiehen");
        Text uStapelText = new Text(spalte+20, zeile+10, "U", Grafik.WHITE, 20,"karteZiehen");
        Text nStapelText = new Text(spalte+20, zeile+30, "N", Grafik.WHITE, 20,"karteZiehen");
    	Text oStapelText = new Text(spalte+20, zeile+50, "O", Grafik.WHITE, 20,"karteZiehen");
        // Variablen verstecken und nach 0.2 Sekunden anzeigen
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
    public int farbeAuswaehlen() {
    	// Meldung auf die Konsole ausgeben
        System.out.println("Wähle bitte eine neue Farbe");
		// Variablen für die Koordinaten des Menüs auf dem Spielbrett
    	int x = 660;
        int y = 450;
        // Variablen für die Dastellung des Menüs zur Auswahl
        Rechteck rechteckFarbAuswahl = new Rechteck(x + 40, y/2 - 100, 130, 130, FARBE_WEISS, FARBE_SCHWARZ, 1, 10, "");
        Rechteck rechteckBlau = new Rechteck(x + 50, y/2 - 90, 50, 50, FARBE_BLAU, FARBE_SCHWARZ, 1, 10, "0");
        Rechteck rechteckGelb = new Rechteck(x + 110, y/2 - 90, 50, 50, FARBE_GELB, FARBE_SCHWARZ, 1, 10, "1");
        Rechteck rechteckGruen = new Rechteck(x + 50, y/2 - 30, 50, 50, FARBE_GRUEN, FARBE_SCHWARZ, 1, 10, "2");
        Rechteck rechteckRot = new Rechteck(x + 110, y/2 - 30, 50, 50, FARBE_ROT, FARBE_SCHWARZ, 1, 10, "3");
        // Variable farbe definieren
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
        // Ausgewählte Farbe als Zahl zurückgeben
        return farbe;
    }
    
    
    /**
     * Funktion zum Darstellen des UNO-Buttons zum Klicken
     * @param x - X-Koordinate im Spielbrett
    * @param y - Y-Koordinate im Spielbrett 
     * @return durch die Grafik Konsole gelesene String
     */
    public String unoKlicken(int x, int y) {
        // Variable für die Darstellung des UNO-Buttons
        Button unoButton = new Button(x+40, y/2 + 135, 130, 70, Grafik.BLACK, "UNO", Grafik.WHITE, 30, 5, "UNO");
        // Variable für den zu lesenden String
        String uno = "";
        // Solange die Zeichenkette dem gegebenen Wert nicht entspricht
        while(!uno.equals("UNO")) {
            // Durch die Grafik Konsole eine Zeichenkette auslesen
        	uno = Konsole.eingabeString();
        }
        // Button entfernen
        unoButton.delete();
        // Zeichenkette zurückgeben
        return uno;
    }

} // Ende von GUI