package unotempel.quiz;

import unotempel.GUI;
import unotempel.kartenspiel.Spieler;

/**Klasse stellt ein Quiz im Spiel mit den jeweiligen Attributen dar.*/
public class Quiz {

  	/** 5.1 Daten als Instanz-Variablen definieren Δe_gm1kws Δ */
    private Quizfragenpool fragenpoolOOP1;
    private Quizfragenpool fragenpoolOOP2;

	
    /** 5.2 Konstruktor erstellen  Δe_7ds5tx Δ
     * Konstruktor erzeugt ein Quiz mit zwei Fragenpools mit Fragen gefüllt
     * @param farbe - Farbe des Tempels
     */
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


    /** 5.3 Quiz lösen  Δe_6l1dmp Δ
     * Funktion zum Beantworten der zu einem gegebenen Index im Fragenpool gespeicherten Frage
     * @param held - Spieler
     * @param quizNiveau - Niveau von Quiz
     * @param gui - Graphical User Interface
     * @return true, wenn die Frage richtig beantwortet wird - false, sonst
     */
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
            int schadenspunkte = held.schadenZufuegen();
            // Lebensenergie des Spielers auf die Konsole ausgeben
            System.out.println("Held hat " + held.getLebenspunkte() + " Lebenspunkte.");
            gui.aktualisiereLebenspunkte(held);            
        }
        // Return ob die Antwort richtig ist
        return antwortIstRichtig;

    }
	
	
} // Ende von Quiz