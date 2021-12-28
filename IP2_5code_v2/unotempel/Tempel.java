package unotempel;

import unotempel.quiz.*;
import unotempel.kartenspiel.*;

/**
 * Klasse stellt eine Instanz von Tempel im Spiel mit seinen jeweiligen Attributen dar.
 */
public class Tempel {

    // Eigenschaften einer Instanz von Tempel
    private String farbe; // Farbe des Tempels
    private Quiz quiz; // Quiz
    private Kartenspiel kartenspiel; // Kartenspiel
    private Spieler monster; // Spieler KI

    /**
     * Konstruktor zum Erzeugen einer Instanz der Klasse Tempel, mit einem Quiz und einem Kartenspiel
     * @param farbe - Farbe des Tempels (blau für Wasser, gelb für Luft, grün für Erde, rot für Feuer)
     */
    public Tempel(String farbe) {
        this.farbe = farbe;
        this.quiz = new Quiz(farbe);
        this.kartenspiel = new Kartenspiel();
    }
    
    
    /**
     * Prozedur bereitet die Darstellung zur Einführung in den Tempel vor
     * @param gui - Graphical User Interface
     */
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


    /**
     * Funktion zum Lösen des Quizes im Tempel
     * @param held - Menschlicher Spieler
     * @param niveau - Niveau von Quiz
     * @param gui - Graphical User Interface
     * @return true, wenn Quiz gelöst wird - false, sonst
     */
    public boolean quizLoesen(Spieler held, int niveau, GUI gui) {
        // Meldung auf die Konsole ausgeben
        System.out.println("Quiz Lösen!\n");
        gui.spielbrettDarstellen(held);
        // Funktion in Quiz aufrufen, um das Quiz zu lösen
        boolean quizGeloest = quiz.quizGeloest(held, niveau, gui);
        // Solange der Held noch lebt und das Quiz nicht gelöst hat
        if(!quizGeloest && held.getLebenspunkte() > 0) {
            // Funktion zum Quizlösen rekursiv aufrufen
        	return quizLoesen(held, niveau, gui);
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


    /**
     * Funktion zum Kämpfen des Monsters im Tempel
     * @param held - Menschlicher Spieler als Parameter
     * @param monsterBesiegt - Boolean true, wenn Monster besiegt wird - false, sonst
     * @param gui - Graphical User Interface
     * @return true, wenn das Monster besiegt wurde - false, sonst
     */
    public boolean monsterKaempfen(Spieler held, boolean monsterBesiegt, GUI gui) {
    	// Solange der Held noch lebt und das Monster nicht besiegt hat
        if(held.getLebenspunkte() > 0 && !monsterBesiegt) {
        	// Prozedur zum Vorbereiten des Spieles aufrufen
        	kampfVorbereiten(held, gui);
            // Speichern ob das Monster besiegt wurde
            monsterBesiegt = heldHatMonsterBesiegt(held, gui);
            // Funktion zum Kämpfen des Monsters aufrufen
            return monsterKaempfen(held, monsterBesiegt, gui);
        }
        // Bedingung überprüft, ob der Spieler noch Lebensenergie hat
        if(held.getLebenspunkte() <= 0) {
        	// Hat der Spieler keine Lebenspunkte mehr, ist das Spiel zu ende
            System.out.println("Game Over\n");
            return false;
        }
        // Gibt true zurück, wenn der Held das Monster besiegt hat
        return monsterBesiegt;      
    }
    
    
    /**
     * Prozedur bereitet den Kampf im Tempel vor
     * @param held - Menschlicher Spieler als Parameter
     * @param gui - Graphical User Interface
     */
    private void kampfVorbereiten(Spieler held, GUI gui) {
        // Fallunterscheidung: Nach dem Tempel-Niveau fragen
        switch(farbe) {
            case "blau":
            	// KIZufall erzeugen
                this.monster = new KIZufall(50);
                break;
            case "gelb":
            	// KIZufall erzeugen
                this.monster = new KIZufall(75);
                break;
            case "gruen":
            	// KISchlau erzeugen
                this.monster = new KISchlau(50);
                break;
            case "rot":
            	// KISchlau erzeugen
                this.monster = new KISchlau(75);
                break;
        }
        // Kartenspiel vorbereiten
        kartenspiel.spielVorbereiten(held, monster, gui);
        // Meldung auf die Konsole ausgeben
        System.out.println("Das Monster wartet darauf... Kartenspiel ist bereit!");
    }
    

    /**
     * Funktion gibt zurück, ob der Held das Monster besiegt hat
     * @param held - Menschlicher Spieler als Parameter
     * @param gui - Graphical User Interface
     * @return true, wenn der Held das Monster besiegt hat - false, sonst 
     */
    private boolean heldHatMonsterBesiegt(Spieler held, GUI gui) {
        // Meldung auf die Konsole ausgeben
        System.out.println("Spielen!\n");
        // Funktion in Kartenspiel zum Spielen aufrufen
        return kartenspiel.spielen(held, monster, gui);
    }

} // Ende von Tempel