/**
 *
 */
public class Quizfrage {

    // Eigenschaften
    private int frageID;
    private String frage;
    private String richtigeAntwort;
    private String falscheAntwort1;
    private String falscheAntwort2;

    /**
     * Konstruktor zum Erzeugen einer Instanz der Klasse QuizzFrage
     *
     * @param frageID
     * @param frage
     * @param richtigeAntwort
     * @param falscheAntwort1
     * @param falscheAntwort2
     */
    public Quizfrage(int frageID, String frage, String richtigeAntwort, String falscheAntwort1, String falscheAntwort2) {
        this.frageID = frageID;
        this.frage = frage;
        this.richtigeAntwort = richtigeAntwort;
        this.falscheAntwort1 = falscheAntwort1;
        this.falscheAntwort2 = falscheAntwort2;
    }

}
