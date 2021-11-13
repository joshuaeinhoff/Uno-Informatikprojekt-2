/**
 *
 */
public class Quizfrage {

    // Eigenschaften
    private String frage;
    private String[] antwortsmoeglichkeiten;
    private char richtigeAntwort;

    public String getFrage() {
        return frage;
    }

    public String[] getAntwortsmoeglichkeiten() {
        return antwortsmoeglichkeiten;
    }

    public char getRichtigeAntwort() {
        return richtigeAntwort;
    }

    /**
     * Konstruktor 1
     * @param frage
     * @param antwortsmoeglichkeiten
     * @param richtigeAntwort
     */
    public Quizfrage(String frage, String[] antwortsmoeglichkeiten, char richtigeAntwort) {
        this.frage = frage;
        this.antwortsmoeglichkeiten = antwortsmoeglichkeiten;
        this.richtigeAntwort = richtigeAntwort;
    }

    /**
     * Konstruktor 2
     * @param frage
     * @param antwort1
     * @param antwort2
     * @param antwort3
     * @param richtigeAntwort
     */
    public Quizfrage(String frage, String antwort1, String antwort2, String antwort3, char richtigeAntwort) {
        this.frage = frage;
        this.antwortsmoeglichkeiten = new String[] { antwort1, antwort2, antwort3 };
        this.richtigeAntwort = richtigeAntwort;
    }
    

}
