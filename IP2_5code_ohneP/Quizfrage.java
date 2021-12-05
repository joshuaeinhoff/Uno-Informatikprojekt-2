

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
        // Fehler beheben
        if(antwort3 == null || antwort3.compareTo("") == 0)
            this.antwortmoeglichkeiten = new String[] { antwort1, antwort2 };
        else
            this.antwortmoeglichkeiten = new String[] { antwort1, antwort2, antwort3 };
        this.richtigeAntwort = richtigeAntwort;
    }

     /**
     * Getter-Methode gibt eine Eigenschaft der Klasse zurück
     * @return Frage als String
     */
    public String getFrage() {
        return frage;
    }

    /**
     * Getter-Methode gibt eine Eigenschaft der Klasse zurück
     * @return Antwortmöglichkeiten als Array von Strings
     */
    public String[] getAntwortmoeglichkeiten() {
        return antwortmoeglichkeiten;
    }

    /**
     * Getter-Methode gibt eine Eigenschaft der Klasse zurück
     * @return richtige Antwort
     */
    public char getRichtigeAntwort() {
        return richtigeAntwort;
    }

} // Ende von Quizfrage