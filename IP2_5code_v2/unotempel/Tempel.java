package unotempel;

import unotempel.quiz.*;
import unotempel.kartenspiel.*;
import java.util.Random;

/**
 * Klasse stellt eine Instanz von Tempel im Spiel mit seinen jeweiligen Attributen dar.
 */
public class Tempel {

    // Eigenschaften einer Instanz von Tempel
    private String farbe;
    private Quizfragenpool fragenpoolOOP1;
    private Quizfragenpool fragenpoolOOP2;
    private Kartenspiel kartenspiel;
    private Spieler monster;

    /**
     * Konstruktor zum Erzeugen einer Instanz der Klasse Tempel
     * @param farbe - Farbe des Tempels (blau für Wasser, gelb für Luft, grün für Erde, rot für Feuer)
     */
    public Tempel(String farbe) {
        this.farbe = farbe;
    }


    /**
     * Funktion gibt eine Instanz von Quizfragenpool für Quizfragen zu OOP zurück
     * @param quizNiveau - Niveau der Quizfragen (1 für OOP1, 2 für OOP2)
     * @return eine Instanz von Quizfragenpool
     */
    public Quizfragenpool quizfragenpoolErzeugen(int quizNiveau) {
        // Quizniveau 1 bezieht sich auf OOP1, Quizniveau 2 auf OOP2; keine andere Zahl ist möglich
        if(quizNiveau == 1) {
            fragenpoolOOP1 = new Quizfragenpool(1);
            fragenpoolOOP1.quizfragenpoolFuellen(this.farbe);
            return fragenpoolOOP1;
        } else if(quizNiveau == 2) {
            fragenpoolOOP2 = new Quizfragenpool(2);
            fragenpoolOOP2.quizfragenpoolFuellen(this.farbe);
            return fragenpoolOOP2;
        } else {
            System.out.println("Kein richtiges Niveau ausgewählt");
            return null;
        }
    }


    /**
     * Prozedur zum Quizlösen
     * @param quizNiveau
     * @param held
     */
    public void quizLoesen(int quizNiveau, Spieler held, GUI gui) {
    
    	// Einführungsdarstellung des Tempels aufrufen
        tempelEinfuehrung(gui);
      	
        // Rätsel lösen
        boolean istRichtig = false;
        Random rand = new Random();
        int zufallsZahl;
        int schaden = 10;

        // Solange keine richtige Frage beantwortet wird
        while(!istRichtig) {
            // Nach QuizNiveau Fragenpool zu OOP1 oder OOP2 auswählen
            if(quizNiveau == 1) {
                // Zufallsfrage aus Fragenpool zu OOP1 auswählen und als Variable speichern
                zufallsZahl = rand.nextInt(fragenpoolOOP1.anzahlQuizfragen());
                istRichtig = fragenpoolOOP1.quizfrageRichtigBeantwortet(zufallsZahl, gui);
            } else if(quizNiveau == 2) {
                // Zufallsfrage aus Fragenpool zu OOP2 auswählen und als Variable speichern
                zufallsZahl = rand.nextInt(fragenpoolOOP2.anzahlQuizfragen());
                istRichtig = fragenpoolOOP2.quizfrageRichtigBeantwortet(zufallsZahl, gui);
            }
			// Bedingung überprüft, ob die Quizfrage falsch beantwortet wurde
            if(!istRichtig) {
                // Nachricht in der Konsole ausgeben
                System.out.println("Frage falsch beantwortet: \n Held bekommt "+ schaden + " Schadenspunkte \n Probier nochmal!");
                // Dem Spieler Schaden zufügen
                held.schadenZufuegen(schaden);
                // Lebensenergie des Spielers auf die Konsole ausgeben
                System.out.println("Held hat " + held.getLebenspunkte() + " Lebenspunkte.");
                gui.zeigeAktualisierteLebenspunkte(held);
                // Bedingung überprüft, ob der Held noch Lebensenergie hat
                if(held.getLebenspunkte() <= 0) {
                	// Hat der Held keine Lebenspunkte mehr, ist das Spiel zu ende
                	System.out.println("Game Over \n");
                    return;
                }
            }
        }
        // Nachricht in der Konsole ausgeben
        System.out.println("Frage richtig beantwortet: Glückwunsch!");
        System.out.println("Held hat " + held.getLebenspunkte() + " Lebenspunkte.\n");
    }
    
    
    /**
     * Private Prozedur bereitet die Darstellung zur Einführung in den Tempel vor
     */
	private void tempelEinfuehrung(GUI gui) {
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
     * Prozedur zum Erzeugen eines Kartenspiels
     */
    public void kartenspielErzeugen() {
        this.kartenspiel = new Kartenspiel();
    }
    
    

    /**
     * Prozedur zum Kämpfen des Monsters im Tempel
     * @param held - Menschlicher Spieler als Parameter
     */
    public boolean monsterKaempfen(Spieler held, GUI gui) {
        kampfVorbereiten(held, gui);
        return heldHatMonsterBesiegt(held,false,gui);
    }
    
    
    /**
     * Prozedur zum Kämpfen des Monsters im Tempel
     * @param held - Menschlicher Spieler als Parameter
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
     * Prozedur zum Kämpfen des Monsters im Tempel
     * @param held - Menschlicher Spieler als Parameter
     */
    public boolean heldHatMonsterBesiegt(Spieler held, boolean heldHatGewonnen,GUI gui) {
        // Spielen
        System.out.println("Spielen!\n");
        heldHatGewonnen = kartenspiel.spielen(held, monster,gui);
        // Solange der Held noch lebt und das Monster nicht besiegt hat
        if(!heldHatGewonnen && held.getLebenspunkte() > 0) {
        	return heldHatMonsterBesiegt(held, false,gui);
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