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
     <br>*/
    public void quizLoesen(int quizNiveau) {
        //
        boolean antwortIsRichtig = false;
        Random rand = new Random();
        int zufallsZahl;

        // Solange keine richtige Frage beantwortet
        while(!antwortIsRichtig) {
            // Nach QuizNiveau Fragenpool zu OOP1 oder OOP2 auswählen
            if(quizNiveau == 1) {
                // Zufallsfrage aus Fragenpool zu OOP1 auswählen und als Variable speichern
                zufallsZahl = rand.nextInt(fragenpoolOOP1.anzahlQuizfragen());
                antwortIsRichtig = fragenpoolOOP1.quizfrageBeantwortet(zufallsZahl);
            } else if(quizNiveau == 2) {
                // Zufallsfrage aus Fragenpool zu OOP2 auswählen und als Variable speichern
                zufallsZahl = rand.nextInt(fragenpoolOOP2.anzahlQuizfragen());
                antwortIsRichtig = fragenpoolOOP2.quizfrageBeantwortet(zufallsZahl);
            }

            // Darstellungsmöglichkeiten (Grafik_Konsole) --> GUI
        }

    }


    /**<br>
     * Prozedur zum Erzeugen eines Kartenspiels<br>
     * @param y - Spielfeld gr&ouml;&szlig;e in Y Richtung<br>
     * @param x - Spielfeld gr&ouml;&szlig;e in X Richtung<br>
     <br>*/
    public void kartenspielErzeugen(int y, int x) {
        this.kartenspiel = new Kartenspiel(y, x);
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
        // Spielen
        kartenspiel.spielen();
    }

} // Ende von Tempel