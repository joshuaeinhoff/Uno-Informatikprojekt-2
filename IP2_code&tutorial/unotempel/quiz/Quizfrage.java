package unotempel.quiz;

/**Klasse stellt eine Quizfrage im Spiel mit den jeweiligen Attributen dar.*/
public class Quizfrage {

	/** 3.1 Daten als Instanz-Variablen definieren Δe_vcpbjw Δ */
    String frage; // Frage zu OOP
    String[] antwortmoeglichkeiten; // Zwei oder drei Antwortmöglichkeiten: a), b) und c)
    char richtigeAntwort; // Anfangsbuchstabe der richtigen Antwort: a, b oder c


	/** 3.2 Konstrukoren der Klasse erstellen  Δe_79fvwl Δ
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
    

	/** 3.2 Konstrukor(en) erstellen  Δe_3vijs3 Δ 
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