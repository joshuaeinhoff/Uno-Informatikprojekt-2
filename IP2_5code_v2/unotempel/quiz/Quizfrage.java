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
     * @param antwort1 - Antwort a)
     * @param antwort2 - Antwort b)
     * @param antwort3 - Antwort c)
     * @param richtigeAntwort - Richtige Antwort
     */
    public Quizfrage(String frage, String antwort1, String antwort2, String antwort3, char richtigeAntwort) {
        this.frage = frage;
        this.antwortmoeglichkeiten = new String[] { antwort1, antwort2, antwort3 };
        this.richtigeAntwort = richtigeAntwort;
    }
    

    /**
     * Konstruktor für zwei Antwortmöglichkeiten, erzeugt eine Instanz von Quizfrage mit den folgenden Parametern:
     * @param frage - Frage
     * @param antwort1 - Antwort a)
     * @param antwort2 - Antwort b)
     * @param richtigeAntwort - Richtige Antwort
     */
    public Quizfrage(String frage, String antwort1, String antwort2, char richtigeAntwort) {
        this.frage = frage;
        this.antwortmoeglichkeiten = new String[] { antwort1, antwort2 };
        this.richtigeAntwort = richtigeAntwort;
    }


} // Ende von Quizfrage