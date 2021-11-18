/**
 * Klasse stellt eine Instanz von Tempel im Spiel mit seinen jeweiligen Attributen dar.
 */
public class Tempel {

    // Eigenschaften einer Instanz von Tempel
    private String farbe;
    private Quizfragenpool fragenpoolOOP1;
    private Quizfragenpool fragenpoolOOP2;
    private Kartenspiel kartenspiel;

    /**
     * Konstruktor zum Erzeugen einer Instanz der Klasse Tempel
     * @param farbe - Farbe des Tempels (blau für Wasser, gelb für Luft, grün für Erde, rot für Feuer)
     */
    public Tempel(String farbe) {
        this.farbe = farbe;
        this.kartenspiel = new Kartenspiel();
    }

    /**
     * Funktion gibt eine Instanz von Quizfragenpool für Quizfragen zu OOP zurück
     * @param quizNiveau - Niveau der Quizfragen (1 für OOP1, 2 für OOP2)
     * @return eine Instanz von Quizfragenpool
     */
    public Quizfragenpool quizfragenpoolErzeugen(char tempelBuchstabe, int quizNiveau) {
        // Quizniveau 1 bezieht sich auf OOP1, Quizniveau 2 auf OOP2; keine andere Zahl ist möglich
        if(quizNiveau == 1) {
            fragenpoolOOP1 = new Quizfragenpool(1);
            fragenpoolOOP1.quizfragenpoolFuellen(tempelBuchstabe);
            return fragenpoolOOP1;
        } else if(quizNiveau == 2) {
            fragenpoolOOP2 = new Quizfragenpool(2);
            fragenpoolOOP2.quizfragenpoolFuellen(tempelBuchstabe);
            return fragenpoolOOP2;
        } else {
            System.out.println("Kein richtiges Niveau ausgewählt");
            return null;
        }
    }




//     --> Nur als Hilfe --> mit der Grafik Konsole
    /**
     * Prozedur zum Quizlösen
     * @param fragenpool
     */
    public void quizLoesen(Quizfragenpool fragenpool) {
//        boolean isRichtig = false;
//        Random rand = new Random();
//        int zufallIndex;
//
//        BufferedReader reader = new BufferedReader(
//                                new InputStreamReader(System.in));
//        String eingabe = null;
//
//        try {
//            // Select question from fragenpool
//            System.out.println("Solltest du den Tempel betreten möchten, musst du deine Weisheit zeigen, indem du ein Rätsel löst." + "\n");
//            // Solange keine richtige Frage beantwortet
//            while(!isRichtig) {
//                zufallIndex = rand.nextInt(fragenpool.length);
//                System.out.println("Rätsel: " + fragenpool[zufallIndex].getFrage());
//                for(String antworte : fragenpool[zufallIndex].getAntwortsmoeglichkeiten()) {
//                    if(antworte.compareTo("") != 0)
//                        System.out.println(antworte);
//                }
//                System.out.print("Gib den Buchstaben der richtigen Antwort ein: ");
//                eingabe = reader.readLine();
//                if(eingabe.charAt(0) == fragenpool[zufallIndex].getRichtigeAntwort()) {
//                    System.out.println("Richtig!" + "\n");
//                    isRichtig = true;
//                } else {
//                    System.out.println("Falsch!" + "\n");
//                    // Lebenspunkte abziehen
//                    //...
//                }
//            }
//        } catch (IOException ioe) {
//            System.out.println("Stream-Fehler: " + ioe.getMessage());
//        }

    }

    
    // Boss -> Uno Spiel
    public void monsterKaempfen() {
        // -> UNO
        // unoKartenspiel -> spielen
    }

} // Ende von Tempel