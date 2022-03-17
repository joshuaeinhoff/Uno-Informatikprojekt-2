package unotempel;

import unotempel.quiz.*;
import unotempel.kartenspiel.*;

/**<br>
 * Klasse stellt eine Instanz von Tempel im Spiel mit seinen jeweiligen Attributen dar.<br>
 <br>*/
public class Tempel {

	/** 1.1 Daten als IV definieren  <br>*/
    private String farbe; // Farbe des Tempels
    private Quiz quiz; // Quiz
    private Kartenspiel kartenspiel; // Kartenspiel
    private Spieler monster; // Spieler KI


    /** 1.2 Konstruktor erstellen  <br>
     * Konstruktor zum Erzeugen einer Instanz der Klasse Tempel, mit einem Quiz und einem Kartenspiel<br>
     * @param farbe - Farbe des Tempels (blau f&uuml;r Wasser, gelb für Luft, grün für Erde, rot für Feuer)<br>
     <br>*/
    public Tempel(String farbe) {
        this.farbe = farbe;
        this.quiz = new Quiz(farbe);
        this.kartenspiel = new Kartenspiel();
        monsterErzeugen();
    }
    
    
    /** 1.3 Methode zum Erzeugen eines Monsters  <br>
     * Prozedur erzeugt ein Monster je nach Tempel Niveau bzw. Farbe<br>
     <br>*/
    private void monsterErzeugen() {
    	// Fallunterscheidung: Nach dem Tempel-Niveau fragen
        switch(farbe) {
            case "blau":
            	// KIZufall erzeugen
                this.monster = new KIZufall(5);
                break;
            case "gelb":
            	// KIZufall erzeugen
                this.monster = new KIZufall(10);
                break;
            case "gruen":
            	// KISchlau erzeugen
                this.monster = new KISchlau(15);
                break;
            case "rot":
            	// KISchlau erzeugen
                this.monster = new KISchlau(20);
                break;
        }
    }
    
    
    /** 1.4 Methode zur Einf&uuml;hrung in den Tempel <br>
     * Prozedur bereitet die Darstellung zur Einf&uuml;hrung in den Tempel vor<br>
     * @param gui - Graphical User Interface<br>
     <br>*/
	public void tempelEinfuehrung(GUI gui) {
    	// Element als String für den Namen des Tempels erzeugen
        String element = "";
        // Fallunterscheidung
        switch(farbe) {
        	case "blau":
            	element = "Wasser";
                break;
            case "gelb":
            	element = "Luft";
                break;
            case "gruen":
            	element = "Erde";
                break;
            case "rot":
            	element = "Feuer";
                break;
        }
        // Begrüßungsnachricht für den Held, wenn er versucht, den Tempel zu betreten
        String begruessungsNachricht[] = {"Solltest du den " + element + "-Tempel betreten möchten,", "musst du deine Weisheit zeigen,", "indem du ein Rätsel löst."};
        // Aufruf zum Darstellen der Begrüßungsnachricht 
        gui.begruessungsnachrichtDarstellen(begruessungsNachricht);
    }


    /** 1.5 Methode zum L&ouml;sen des Quizes   <br>
     * Funktion zum L&ouml;sen des Quizes im Tempel<br>
     * @param held - Menschlicher Spieler<br>
     * @param niveau - Niveau von Quiz<br>
     * @param gui - Graphical User Interface<br>
     * @return true, wenn Quiz gel&ouml;st wird - false, sonst<br>
     <br>*/
    public boolean heldHatQuizGeloest(Spieler held, int niveau, GUI gui) {
        // Meldung auf die Konsole ausgeben
        System.out.println("Quiz lösen!\n");
        gui.spielbrettDarstellen(held);
        // Funktion in Quiz aufrufen, um das Quiz zu lösen
        boolean geloest = quiz.quizGeloest(held, niveau, gui);
        // Solange der Held noch lebt und das Quiz nicht gelöst hat
        if(!geloest && held.getLebenspunkte() > 0) {
            // Funktion zum Quizlösen rekursiv aufrufen
        	return heldHatQuizGeloest(held, niveau, gui);
        }
        // Bedingung überprüft, ob der Spieler noch Lebensenergie hat
        if(held.getLebenspunkte() <= 0) {
        	// Hat der Spieler keine Lebenspunkte mehr, ist das Spiel zu ende
            System.out.println("Game Over\n");
            return false;
        }
        // Gibt true zurück, wenn der Held das Quiz gelöst hat
        return true;
    }


	/** 1.6 Methode heldHatMonsterBesiegt() <br>
     * Funktion zum K&auml;mpfen des Monsters im Tempel<br>
     * @param held - Menschlicher Spieler als Parameter<br>
     * @param gui - Graphical User Interface<br>
     * @return true, wenn das Monster besiegt wurde - false, sonst<br>
     <br>*/
    public boolean heldHatMonsterBesiegt(Spieler held, GUI gui) {
        // Solange der Held noch lebt und das Monster nicht besiegt hat ( => hat 0 Lebenspunkte)
        if(held.getLebenspunkte() > 0 && monster.getLebenspunkte() > 0) {
        	System.out.println("Held muss das Monster besiegen, indem er UNO spielt.");
        	
        	// Kartenspiel vorbereiten
        	kartenspiel.spielVorbereiten(held, monster, gui);
        	// Meldung auf die Konsole ausgeben
        	System.out.println("Das Monster wartet darauf... Kartenspiel ist bereit!");
        	
            // Karten spielen
            System.out.println("Spielen!\n");
            kartenspiel.spielen(held, monster, gui);
            
            // Funktion zum Kämpfen des Monsters rekursiv aufrufen
            return heldHatMonsterBesiegt(held, gui);
        }
        // Bedingung überprüft, ob der Spieler keine Lebensenergie mehr hat
        if(held.getLebenspunkte() <= 0) {
        	// Hat der Spieler keine Lebenspunkte mehr, ist das Spiel zu ende
            System.out.println("Game Over\n");
            return false;
        }
        // Keine weitere Bedingungen, dann hat der Held gewonnen
        System.out.println("Held hat das Monster besiegt!\n");
        // Gibt true zurück, wenn der Held das Monster besiegt hat
        return true;   
    }
		
} // Ende von Tempel