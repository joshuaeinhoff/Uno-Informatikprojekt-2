package unotempel;

import unotempel.quiz.Quizfragenpool;
import unotempel.kartenspiel.Kartenspiel;
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
    public Quizfragenpool quizfragenpoolErzeugen(char tempelBuchstabe, int quizNiveau) {
        // Quizniveau 1 bezieht sich auf OOP1, Quizniveau 2 auf OOP2; keine andere Zahl ist möglich
        if(quizNiveau == 1) {
            fragenpoolOOP1 = new Quizfragenpool(1);
            fragenpoolOOP1.quizfragenpoolFuellen(tempelBuchstabe);
            return fragenpoolOOP1;
        } else if(quizNiveau == 2) {
            fragenpoolOOP2 = new Quizfragenpool(2);
            fragenpoolOOP2.quizfragenpoolFuellen(tempelBuchstabe);
            return fragenpoolOOP2;
        } else {
            System.out.println("Kein richtiges Niveau ausgewählt");
            return null;
        }
    }


    /**
     * Prozedur zum Quizlösen
     * @param quizNiveau
     */
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
                zufallsZahl = rand.nextInt(fragenpoolOOP1.getAnzahlQuizfragen());
                antwortIsRichtig = fragenpoolOOP1.quizfrageBeantworten(zufallsZahl);
            } else if(quizNiveau == 2) {
                // Zufallsfrage aus Fragenpool zu OOP2 auswählen und als Variable speichern
                zufallsZahl = rand.nextInt(fragenpoolOOP2.getAnzahlQuizfragen());
                antwortIsRichtig = fragenpoolOOP2.quizfrageBeantworten(zufallsZahl);
            }

            // Darstellungsmöglichkeiten (Grafik_Konsole) --> GUI
        }

    }


    /**
     * Prozedur zum Erzeugen eines Kartenspiels
     * @param y - Spielfeld größe in Y Richtung
     * @param x - Spielfeld größe in X Richtung
     */
    public void kartenspielErzeugen(int y, int x) {
        this.kartenspiel = new Kartenspiel(y, x);
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
        // Spielen
        kartenspiel.spielen();
    }

} // Ende von Tempel