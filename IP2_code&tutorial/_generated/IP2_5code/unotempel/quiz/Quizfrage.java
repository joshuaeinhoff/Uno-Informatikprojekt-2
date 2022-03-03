package unotempel.quiz;

/**<br>
 * Klasse stellt eine Quizfrage (bzw. R&auml;tsel) im Spiel mit den jeweiligen Attributen dar.<br>
 <br>*/
public class Quizfrage {

    // Eigenschaften einer Instanz von Quizfrage
    private String frage; // Frage zu OOP
    private String[] antwortmoeglichkeiten; // Zwei oder drei Antwortmöglichkeiten: a), b) und c)
    private char richtigeAntwort; // Anfangsbuchstabe der richtigen Antwort: a, b oder c

    /**<br>
     * Konstruktor f&uuml;r drei Antwortm&ouml;glichkeiten, erzeugt eine Instanz von Quizfrage mit den folgenden Parametern:<br>
     * @param frage - Frage<br>
     * @param antwort1 - Antwort a)<br>
     * @param antwort2 - Antwort b)<br>
     * @param antwort3 - Antwort c)<br>
     * @param richtigeAntwort - Richtige Antwort<br>
     <br>*/
    public Quizfrage(String frage, String antwort1, String antwort2, String antwort3, char richtigeAntwort) {
        this.frage = frage;
        this.antwortmoeglichkeiten = new String[] { antwort1, antwort2, antwort3 };
        this.richtigeAntwort = richtigeAntwort;
    }
    
    /**<br>
     * Konstruktor f&uuml;r zwei Antwortm&ouml;glichkeiten, erzeugt eine Instanz von Quizfrage mit den folgenden Parametern:<br>
     * @param frage - Frage<br>
     * @param antwort1 - Antwort a)<br>
     * @param antwort2 - Antwort b)<br>
     * @param richtigeAntwort - Richtige Antwort<br>
     <br>*/
    public Quizfrage(String frage, String antwort1, String antwort2, char richtigeAntwort) {
        this.frage = frage;
        this.antwortmoeglichkeiten = new String[] { antwort1, antwort2 };
        this.richtigeAntwort = richtigeAntwort;
    }

     /**<br>
     * Getter-Methode gibt eine Eigenschaft der Klasse zur&uuml;ck<br>
     * @return Frage als String<br>
     <br>*/
    public String getFrage() {
        return frage;
    }

    /**<br>
     * Getter-Methode gibt eine Eigenschaft der Klasse zur&uuml;ck<br>
     * @return Antwortm&ouml;glichkeiten als Array von Strings<br>
     <br>*/
    public String[] getAntwortmoeglichkeiten() {
        return antwortmoeglichkeiten;
    }

    /**<br>
     * Getter-Methode gibt eine Eigenschaft der Klasse zur&uuml;ck<br>
     * @return richtige Antwort<br>
     <br>*/
    public char getRichtigeAntwort() {
        return richtigeAntwort;
    }

} // Ende von Quizfrage