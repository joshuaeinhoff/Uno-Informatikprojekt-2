/**
 * 
 */
class Tempel {

    // Eigenschaften: Farbe bzw. Element, Schwierigkeitsgrad bzw. Stufe (1-4)
    private String farbe;
    private int stufe; //Stufe? - für die Schwierigkeit im Tempel oder für den Fortschritt im Tempel?
    private String quizfrage; //Quizfrage als Variable die beim erzeugen gesetzt wird?
                              /*
                              * Ist es vielleicht sinnvoll einen Fragenpool pro Temple zu haben, dass es
                              * einen höheren Ansporn zum erneuten spielen gibt?
                              */
    
    // Konstruktor -> Tempel einer bestimmten Farbe wird erzeugt
    public Tempel(String farbe, int stufe) {
        this.farbe = farbe;
        this.stufe = stufe;
    }
    
    // Rätsel -> Quizz
    public void betreten() {
        // -> Quizz
    }
    
    // Boss -> Uno Spiel
    public void finalBoss() {
        // -> UNO
    }
    
	
}