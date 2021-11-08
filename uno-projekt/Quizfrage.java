/**
 *
 */
public class Quizfrage implements Comparable<Quizfrage> {

    // Eigenschaften
    private String frageID; // kann sein OOP-Tempel-Nummer -> 1-2-01
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
    public Quizfrage(String frageID, String frage, String richtigeAntwort, String falscheAntwort1, String falscheAntwort2) {
        this.frageID = frageID;
        this.frage = frage;
        this.richtigeAntwort = richtigeAntwort;
        this.falscheAntwort1 = falscheAntwort1;
        this.falscheAntwort2 = falscheAntwort2;
    }

    public String getFrageID() {
        return frageID;
    }

    public String getFrage() {
        return frage;
    }

    public String getRichtigeAntwort() {
        return richtigeAntwort;
    }

    public String getFalscheAntwort1() {
        return falscheAntwort1;
    }

    public String getFalscheAntwort2() {
        return falscheAntwort2;
    }

    @Override
    public int compareTo(Quizfrage o) {
        return this.frageID.compareTo(o.frageID);
    }
}
