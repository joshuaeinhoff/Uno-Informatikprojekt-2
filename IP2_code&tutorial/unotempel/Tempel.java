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

    /** 1.2 Konstruktor erstellen Δe_4j1v50 Δ 
     * Konstruktor zum Erzeugen einer Instanz der Klasse Tempel, mit einem Quiz und einem Kartenspiel
     * @param farbe - Farbe des Tempels (blau für Wasser, gelb für Luft, grün für Erde, rot für Feuer)
     */
    public Tempel(String farbe) {
        this.farbe = farbe;
        this.quiz = new Quiz(farbe);
        this.kartenspiel = new Kartenspiel();
        monsterErzeugen();
    }
    
    
    /** 1.3.1 Methode zum Erzeugen eines Monsters Δe_aoqvv1 Δ 
     * Prozedur erzeugt ein Monster je nach Tempel Niveau bzw. Farbe
     */
    private void monsterErzeugen() {
    	// Fallunterscheidung: Nach dem Tempel-Niveau fragen
        switch(farbe) {
            case "blau":
            	// KIZufall erzeugen
                this.monster = new KIZufall(10);
                break;
            case "gelb":
            	// KIZufall erzeugen
                this.monster = new KIZufall(20);
                break;
            case "gruen":
            	// KISchlau erzeugen
                this.monster = new KISchlau(30);
                break;
            case "rot":
            	// KISchlau erzeugen
                this.monster = new KISchlau(40);
                break;
        }
    }
    
    
    /** 1.3.2 Methode zur Einführung in den Tempel Δe_suyqe3 Δ
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


    /** 1.3.3 Methode zum Lösen des Quizes  Δe_xuszin Δ 
     * Funktion zum Lösen des Quizes im Tempel
     * @param held - Menschlicher Spieler
     * @param niveau - Niveau von Quiz
     * @param gui - Graphical User Interface
     * @return true, wenn Quiz gelöst wird - false, sonst
     */
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

    
    /** 1.3.4 Methode zum Vorbereiten des Kampfes Δe_p6vf02 Δ
     * Prozedur bereitet den Kampf im Tempel vor
     * @param held - Menschlicher Spieler als Parameter
     * @param gui - Graphical User Interface
     */
    private void kampfVorbereiten(Spieler held, GUI gui) {
        // Kartenspiel vorbereiten
        kartenspiel.spielVorbereiten(held, monster, gui);
        // Meldung auf die Konsole ausgeben
        System.out.println("Das Monster wartet... Kartenspiel ist bereit!");
    }
    

    /** 1.3.5 Methode heldHatSpielGewonnen() Δe_z1x89s Δ 
     * Funktion gibt zurück, ob der Held das Spiel gewonnen hat
     * @param held - Menschlicher Spieler als Parameter
     * @param gui - Graphical User Interface
     * @return true, wenn der Held das Spiel gewonnen hat - false, sonst 
     */
    private boolean heldHatSpielGewonnen(Spieler held, GUI gui) {
        // Meldung auf die Konsole ausgeben
        System.out.println("Spielen!\n");        
        // Funktion in Kartenspiel zum Spielen aufrufen
        return kartenspiel.spielen(held, monster, gui);
    }


	/** 1.3.6 Methode heldHatMonsterBesiegt() Δe_ivzxg8 Δ
     * Funktion zum Kämpfen des Monsters im Tempel
     * @param held - Menschlicher Spieler als Parameter
     * @param monsterBesiegt - Boolean true, wenn Monster besiegt wird - false, sonst
     * @param gui - Graphical User Interface
     * @return true, wenn das Monster besiegt wurde - false, sonst
     */
    public boolean heldHatMonsterBesiegt(Spieler held, boolean hatSpielGewonnen, GUI gui) {
        // Solange der Held noch lebt und das Monster nicht besiegt hat ( => hat 0 Lebenspunkte)
        if(held.getLebenspunkte() > 0 && monster.getLebenspunkte() > 0) {
        	System.out.println("Held muss das Monster besiegen, indem er UNO spielt.");
        	// Prozedur zum Vorbereiten des Spieles aufrufen
        	kampfVorbereiten(held, gui);
            // Speichern ob das Monster besiegt wurde
            hatSpielGewonnen = heldHatSpielGewonnen(held, gui);
            // Funktion zum Kämpfen des Monsters aufrufen
            return heldHatMonsterBesiegt(held, hatSpielGewonnen, gui);
        }
        // Bedingung überprüft, ob der Spieler noch Lebensenergie hat
        if(held.getLebenspunkte() <= 0) {
        	// Hat der Spieler keine Lebenspunkte mehr, ist das Spiel zu ende
            System.out.println("Game Over\n");
            return false;
        }
        // Gibt true zurück, wenn der Held das Monster besiegt hat
        return true;      
    }
		
} // Ende von Tempel