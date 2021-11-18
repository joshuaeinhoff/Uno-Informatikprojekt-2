/**
 * Klasse stellt eine Quizfrage (bzw. Rätsel) im Spiel mit ihren (bzw. seinen) jeweiligen Attributen dar.
 */
public class Quizfrage {

    // Eigenschaften einer Instanz von Quizfrage
    private String frage; // Frage zu OOP
    private String[] antwortmoeglichkeiten; // Zwei oder drei Antwortmöglichkeiten: a), b) und c)
    private char richtigeAntwort; // Anfangsbuchstabe der richtigen Antwort: a, b oder c

    /**
     * Konstruktor erzeugt eine Instanz von Quizfrage mit den folgenden Parametern:
     * @param frage - Frage
     * @param antwort1 - Antwort a)
     * @param antwort2 - Antwort b)
     * @param antwort3 - Antwort c) (optional)
     * @param richtigeAntwort - Richtige Antwort
     */
    public Quizfrage(String frage, String antwort1, String antwort2, String antwort3, char richtigeAntwort) {
        this.frage = frage;
        if(antwort3.compareTo("") == 0)
            this.antwortmoeglichkeiten = new String[] { antwort1, antwort2 };
        else
            this.antwortmoeglichkeiten = new String[] { antwort1, antwort2, antwort3 };
        this.richtigeAntwort = richtigeAntwort;
    }

} // Ende von Quizfrage