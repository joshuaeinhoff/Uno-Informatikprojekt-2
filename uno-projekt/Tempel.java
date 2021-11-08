/**
 * 
 */
class Tempel {

    // Eigenschaften: Farbe bzw. Element, Schwierigkeitsgrad bzw. Stufe (1-4)
    private String farbe;
    private int stufe;     
    private HashMap<Integer,Quizfrage> fragenpool;
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