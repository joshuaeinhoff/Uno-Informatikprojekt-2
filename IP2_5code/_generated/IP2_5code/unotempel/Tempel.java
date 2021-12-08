package unotempel;

import unotempel.quiz.*;
import unotempel.kartenspiel.*;
import java.util.Random;

/**<br>
 * Klasse stellt eine Instanz von Tempel im Spiel mit seinen jeweiligen Attributen dar.<br>
 <br>*/
public class Tempel {

    // Eigenschaften einer Instanz von Tempel
    private String farbe;
    private Quizfragenpool fragenpoolOOP1;
    private Quizfragenpool fragenpoolOOP2;
    private Kartenspiel kartenspiel;

    /**<br>
     * Konstruktor zum Erzeugen einer Instanz der Klasse Tempel<br>
     * @param farbe - Farbe des Tempels (blau f&uuml;r Wasser, gelb für Luft, grün für Erde, rot für Feuer)<br>
     <br>*/
    public Tempel(String farbe) {
        this.farbe = farbe;
    }


    /**<br>
     * Funktion gibt eine Instanz von Quizfragenpool f&uuml;r Quizfragen zu OOP zurück<br>
     * @param quizNiveau - Niveau der Quizfragen (1 f&uuml;r OOP1, 2 für OOP2)<br>
     * @return eine Instanz von Quizfragenpool<br>
     <br>*/
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


    /**<br>
     * Prozedur zum Quizl&ouml;sen<br>
     * @param quizNiveau<br>
     * @param spieler<br>
     <br>*/
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
    
    
    /**<br>
     * Prozedur bereitet die Darstellung zur Einf&uuml;hrung in den Tempel vor<br>
     <br>*/
	private void tempelEinfuehrung() {
    	// Element als String für den Namen des Tempels erzeugen
        String element = "";
        // Fallunterscheidung
        switch(farbe) {
        	case "blau":
            	System.out.println(farbe);
            	element = "Wasser";
                break;
            case "gelb":
            	System.out.println(farbe);
            	element = "Luft";
                break;
            case "gruen":
            	System.out.println(farbe);
            	element = "Erde";
                break;
            case "rot":
            	System.out.println(farbe);
            	element = "Feuer";
                break;
        }
        // Begrüßungsnachricht für den Held, wenn er versucht, den Tempel zu betreten
        String begruessungsNachricht[] = {"Solltest du den " + element + "-Tempel betreten möchten,", "musst du deine Weisheit zeigen,", "indem du ein Rätsel löst."};
        // Aufruf zum Darstellen der Begrüßungsnachricht 
        GUI.begruessungsnachrichtDarstellen(begruessungsNachricht);
    }


    /**<br>
     * Prozedur zum Erzeugen eines Kartenspiels<br>
     * @param y - Spielfeld gr&ouml;&szlig;e in Y Richtung<br>
     * @param x - Spielfeld gr&ouml;&szlig;e in X Richtung<br>
     <br>*/
    public void kartenspielErzeugen() {
        this.kartenspiel = new Kartenspiel();
    }
    

    /**<br>
     * Prozedur zum K&auml;mpfen des Monsters im Tempel<br>
     * @param sp<br>
     <br>*/
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