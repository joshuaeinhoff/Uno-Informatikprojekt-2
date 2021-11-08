/**
 * 
 */
class Tempel {

    // Eigenschaften: Farbe bzw. Element, Schwierigkeitsgrad bzw. Stufe (1-4)
    private String farbe;
    private int stufe; //Stufe? - für die Schwierigkeit im Tempel oder für den Fortschritt im Tempel?
    private Quizfrage quizfrage; //Quizfrage als Variable die beim erzeugen gesetzt wird?
                              /*
                              * Ist es vielleicht sinnvoll einen Fragenpool pro Temple zu haben, dass es
                              * einen höheren Ansporn zum erneuten spielen gibt?
                              */
    private Fragenpool fragenpool;
    private UnoKartenspiel unoKartenspiel;

    /**
     * Konstruktor zum Erzeugen einer Instanz der Klasse Tempel
     * @param farbe
     * @param stufe
     */
    public Tempel(String farbe, int stufe) {
        this.farbe = farbe;
        this.stufe = stufe;
        this.fragenpool = new Fragenpool();
        this.unoKartenspiel = new UnoKartenspiel();
    }
    
    // Rätsel -> Quizz
    public void betreten() {
        // -> Quizz
        // fragenpool -> Frage wählen
    }
    
    // Boss -> Uno Spiel
    public void monsterKaempfen() {
        // -> UNO
        // unoKartenspiel -> spielen



    }
    
	
}