package unotempel.quiz;

/**Klasse stellt eine Quizfrage im Spiel mit den jeweiligen Attributen dar.<br>*/
public class Quizfrage {

	/** 3.1 Daten als Instanz-Variablen definieren  <br>*/
    String frage; // Frage zu OOP
    String[] antwortmoeglichkeiten; // Zwei oder drei Antwortmöglichkeiten: a), b) und c)
    char richtigeAntwort; // Anfangsbuchstabe der richtigen Antwort: a, b oder c


	/** 3.2 Konstrukoren der Klasse erstellen  <br>
     * Konstruktor f&uuml;r drei Antwortm&ouml;glichkeiten, erzeugt eine Instanz von Quizfrage mit den folgenden Parametern:<br>
     * @param frage - Frage<br>
     * @param antwortA - Antwort a)<br>
     * @param antwortB - Antwort b)<br>
     * @param antwortC - Antwort c)<br>
     * @param richtigeAntwort - Richtige Antwort<br>
     <br>*/
    public Quizfrage(String frage, String antwortA, String antwortB, String antwortC, char richtigeAntwort) {
        this.frage = frage;
        this.antwortmoeglichkeiten = new String[] { antwortA, antwortB, antwortC };
        this.richtigeAntwort = richtigeAntwort;
    }
    

	/** 3.2 Konstrukor(en) erstellen   <br>
     * Konstruktor f&uuml;r zwei Antwortm&ouml;glichkeiten, erzeugt eine Instanz von Quizfrage mit den folgenden Parametern:<br>
     * @param frage - Frage<br>
     * @param antwortA - Antwort a)<br>
     * @param antwortB - Antwort b)<br>
     * @param richtigeAntwort - Richtige Antwort<br>
     <br>*/
    public Quizfrage(String frage, String antwortA, String antwortB, char richtigeAntwort) {
        this.frage = frage;
        this.antwortmoeglichkeiten = new String[] { antwortA, antwortB };
        this.richtigeAntwort = richtigeAntwort;
    }
	
} // Ende von Quizfrage