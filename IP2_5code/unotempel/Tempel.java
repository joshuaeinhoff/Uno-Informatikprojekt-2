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
     * @param spieler
     */
    public void quizLoesen(int quizNiveau, Spieler spieler) {
    
    	// Einführungsdarstellung des Tempels aufrufen
        tempelEinfuehrung();
      	
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
                istRichtig = fragenpoolOOP1.quizfrageRichtigBeantwortet(zufallsZahl);
            } else if(quizNiveau == 2) {
                // Zufallsfrage aus Fragenpool zu OOP2 auswählen und als Variable speichern
                zufallsZahl = rand.nextInt(fragenpoolOOP2.anzahlQuizfragen());
                istRichtig = fragenpoolOOP2.quizfrageRichtigBeantwortet(zufallsZahl);
            }
			// Bedingung überprüft, ob die Quizfrage falsch beantwortet wurde
            if(!istRichtig) {
                // Nachricht in der Konsole ausgeben
                System.out.println("Frage falsch beantwortet: \n Held bekommt "+ schaden + " Schadenspunkte \n Probier nochmal!");
                // Dem Spieler Schaden zufügen
                int lebensenergie = spieler.schadenZufuegen(schaden);
                // Lebensenergie des Spielers auf die Konsole ausgeben
                System.out.println("Lebensenergie: " + lebensenergie);
                // Bedingung überprüft, ob der Spieler noch Lebensenergie hat
                if(lebensenergie <= 0) {
                	// Hat der Spieler keine Lebenspunkte mehr, ist das Spiel zu ende
                	System.out.println("Game Over \n");
                    return;
                }
            }
        }
        // Nachricht in der Konsole ausgeben
        System.out.println("Frage richtig beantwortet: Glückwunsch!\n");
    }
    
    
    /**
     * Prozedur bereitet die Darstellung zur Einführung in den Tempel vor
     */
	private void tempelEinfuehrung() {
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
        GUI.begruessungsnachrichtDarstellen(begruessungsNachricht);
    }


    /**
     * Prozedur zum Erzeugen eines Kartenspiels
     * @param y - Spielfeld größe in Y Richtung
     * @param x - Spielfeld größe in X Richtung
     */
    public void kartenspielErzeugen() {
        this.kartenspiel = new Kartenspiel();
    }
    

    /**
     * Prozedur zum Kämpfen des Monsters im Tempel
     * @param sp
     */
    public void monsterKaempfen(Spieler sp) {
        // Fallunterscheidung: Nach dem Tempel-Niveau fragen
        switch(farbe) {
            case "blau":
                // Kartenspiel vorbereiten
                kartenspiel.spielVorbereiten(sp, 1);
                break;
            case "gelb":
                // Kartenspiel vorbereiten
                kartenspiel.spielVorbereiten(sp, 2);
                break;
            case "gruen":
                // Kartenspiel vorbereiten
                kartenspiel.spielVorbereiten(sp, 3);
                break;
            case "rot":
                // Kartenspiel vorbereiten
                kartenspiel.spielVorbereiten(sp, 4);
                break;
        }
        System.out.println("Kartenspiel ist bereit!");
        // Spielen
        System.out.println("Spielen aufrufen");
        //kartenspiel.spielen();
    }

} // Ende von Tempel