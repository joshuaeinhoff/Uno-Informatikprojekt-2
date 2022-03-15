package unotempel.quiz;

import unotempel.GUI;
import unotempel.kartenspiel.Spieler;

/**Klasse stellt ein Quiz im Spiel mit den jeweiligen Attributen dar.<br>*/
public class Quiz {

  	/** 3.1 Daten als IV implementieren  <br>*/
    private Quizfragenpool fragenpoolOOP1;
    private Quizfragenpool fragenpoolOOP2;

	
    /** 3.2 Konstruktor erstellen   <br>
     * Konstruktor erzeugt ein Quiz mit zwei Fragenpools mit Fragen gef&uuml;llt<br>
     * @param farbe - Farbe des Tempels<br>
     <br>*/
    public Quiz(String farbe) {
        // Quizfragenpool zu OOP1 erzeugen
        fragenpoolOOP1 = new Quizfragenpool(1);
        // Quizfragenpool zu OOP2 erzeugen
        fragenpoolOOP2 = new Quizfragenpool(2);
        // Quizfragenpool zu OOP1 mit Fragen füllen
        fragenpoolOOP1.quizfragenpoolFuellen(farbe);
        // Quizfragenpool zu OOP2 mit Fragen füllen
        fragenpoolOOP2.quizfragenpoolFuellen(farbe);
    }


    /**<br>
     * Funktion zum Beantworten der zu einem gegebenen Index im Fragenpool gespeicherten Frage<br>
     * @param held - Spieler<br>
     * @param quizNiveau - Niveau von Quiz<br>
     * @param gui - Graphical User Interface<br>
     * @return true, wenn die Frage richtig beantwortet wird - false, sonst<br>
     <br>*/
    public boolean quizGeloest(Spieler held, int quizNiveau, GUI gui) {
        // Lokale Variablen
        boolean antwortIstRichtig = false;
        int zufallsZahl; // Zufallszahl - Index der Frage
        int schaden = 10; // Schadenspunkte

        // Nach QuizNiveau Fragenpool zu OOP1 oder OOP2 auswählen
        if(quizNiveau == 1) {
            // Zufallsfrage aus Fragenpool zu OOP1 auswählen und als Variable speichern
            zufallsZahl = (int)(Math.random() * fragenpoolOOP1.anzahlQuizfragen);
            antwortIstRichtig = fragenpoolOOP1.frageRichtigBeantwortet(zufallsZahl, gui);
        } else {
            // Zufallsfrage aus Fragenpool zu OOP2 auswählen und als Variable speichern
            zufallsZahl = (int)(Math.random() * fragenpoolOOP2.anzahlQuizfragen);
            antwortIstRichtig = fragenpoolOOP2.frageRichtigBeantwortet(zufallsZahl, gui);
        }

        // Bedingung überprüft, ob die Quizfrage falsch beantwortet wurde
        if(!antwortIstRichtig) {
            // Nachricht in der Konsole ausgeben
            System.out.println("Frage falsch beantwortet: \n-Held bekommt "+ schaden + " Schadenspunkte \n-Probier nochmal!");
            // Dem Spieler Schaden zufügen
            int lebenspunkte = held.schadenZufuegen();
            // Lebensenergie des Spielers auf die Konsole ausgeben
            System.out.println("Held hat " + lebenspunkte + " Lebenspunkte.");
            gui.aktualisiereLebenspunkte(held);            
        }
        // Return ob die Antwort richtig ist
        return antwortIstRichtig;

    }

	
} // Ende von Quiz