package unotempel.quiz;

/**
 * Klasse stellt eine Quizfrage (bzw. Rätsel) im Spiel mit den jeweiligen Attributen dar.
 */
public class Quizfrage {

    // Eigenschaften einer Instanz von Quizfrage
    String frage; // Frage zu OOP
    String[] antwortmoeglichkeiten; // Zwei oder drei Antwortmöglichkeiten: a), b) und c)
    char richtigeAntwort; // Anfangsbuchstabe der richtigen Antwort: a, b oder c


    /**
     * Konstruktor für drei Antwortmöglichkeiten, erzeugt eine Instanz von Quizfrage mit den folgenden Parametern:
     * @param frage - Frage
     * @param antwortA - Antwort a)
     * @param antwortB - Antwort b)
     * @param antwortC - Antwort c)
     * @param richtigeAntwort - Richtige Antwort
     */
    public Quizfrage(String frage, String antwortA, String antwortB, String antwortC, char richtigeAntwort) {
        this.frage = frage;
        this.antwortmoeglichkeiten = new String[] { antwortA, antwortB, antwortC };
        this.richtigeAntwort = richtigeAntwort;
    }
    

    /**
     * Konstruktor für zwei Antwortmöglichkeiten, erzeugt eine Instanz von Quizfrage mit den folgenden Parametern:
     * @param frage - Frage
     * @param antwortA - Antwort a)
     * @param antwortB - Antwort b)
     * @param richtigeAntwort - Richtige Antwort
     */
    public Quizfrage(String frage, String antwortA, String antwortB, char richtigeAntwort) {
        this.frage = frage;
        this.antwortmoeglichkeiten = new String[] { antwortA, antwortB };
        this.richtigeAntwort = richtigeAntwort;
    }

} // Ende von Quizfrage