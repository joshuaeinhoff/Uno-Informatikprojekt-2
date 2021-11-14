import java.util.*;
/**
 * 
 */
class Tempel {

    // Eigenschaften
    private String farbe;
    private Quizfrage[] fragenpoolOOP1;
    private Quizfrage[] fragenpoolOOP2;
    private Kartenspiel kartenspiel;

    /**
     * Konstruktor zum Erzeugen einer Instanz der Klasse Tempel
     * @param farbe
     */
    public Tempel(String farbe) {
        this.farbe = farbe;
        this.kartenspiel = new Kartenspiel();
    }

    public Quizfrage[] getFragenpoolOOP1() {
        return fragenpoolOOP1;
    }

    public Quizfrage[] getFragenpoolOOP2() {
        return fragenpoolOOP2;
    }

    public void setFragenpoolOOP1(Quizfrage[] fragenpoolOOP1) {
        this.fragenpoolOOP1 = fragenpoolOOP1;
    }

    public void setFragenpoolOOP2(Quizfrage[] fragenpoolOOP2) {
        this.fragenpoolOOP2 = fragenpoolOOP2;
    }

    
    /**
     * Prozedur zum Quizlösen
     * @param niveau
     */
    public void quizLoesen(int niveau) {

        boolean isRichtig = false;
        Random rand = new Random();
        int zufallIndex;

        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(System.in));
        String eingabe = null;

        try {

            if(niveau == 1) {
                // Select question from fragenpoolOOP1
                System.out.println("Solltest du den Tempel betreten möchten, musst du deine Weisheit zeigen, indem du ein Rätsel löst." + "\n");

                while(!isRichtig) {
                    zufallIndex = rand.nextInt(fragenpoolOOP1.length);
                    System.out.println("Rätsel: " + fragenpoolOOP1[zufallIndex].getFrage());
                    for(String antworte : fragenpoolOOP1[zufallIndex].getAntwortsmoeglichkeiten()) {
                        if(antworte.compareTo("") != 0)
                            System.out.println(antworte);
                    }
                    System.out.print("Gib den Buchstaben der richtigen Antwort ein: ");
                    eingabe = reader.readLine();
                    if(eingabe.charAt(0) == fragenpoolOOP1[zufallIndex].getRichtigeAntwort()) {
                        System.out.println("Richtig!" + "\n");
                        isRichtig = true;
                    } else {
                        System.out.println("Falsch!" + "\n");
                        // Lebenspunkte abziehen
                    }
                }

            } else {
                // Select question from fragenpoolOOP2
                System.out.println("Solltest du den Tempel betreten möchten, musst du deine Weisheit zeigen, indem du ein Rätsel löst." + "\n");

                while(!isRichtig) {
                    zufallIndex = rand.nextInt(fragenpoolOOP2.length);
                    System.out.println("Rätsel: " + fragenpoolOOP2[zufallIndex].getFrage());
                    for(String antworte : fragenpoolOOP2[zufallIndex].getAntwortsmoeglichkeiten()) {
                        if(antworte.compareTo("") != 0)
                            System.out.println(antworte);
                    }
                    System.out.print("Gib den Buchstaben der richtigen Antwort ein: ");
                    eingabe = reader.readLine();
                    if(eingabe.charAt(0) == fragenpoolOOP2[zufallIndex].getRichtigeAntwort()) {
                        System.out.println("Richtig!" + "\n");
                        isRichtig = true;
                    } else {
                        System.out.println("Falsch!" + "\n");
                        // Lebenspunkte abziehen
                    }
                }

            }

        } catch (IOException ioe) {
            System.out.println("Stream-Fehler: " + ioe.getMessage());
        }

    }
    
    // Boss -> Uno Spiel
    public void monsterKaempfen() {
        // -> UNO
        // unoKartenspiel -> spielen



    }
    
	
}