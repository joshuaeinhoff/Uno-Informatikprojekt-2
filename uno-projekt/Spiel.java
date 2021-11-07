/**
 *  Klasse Spiel -> besser benennen 
 */
class Spiel {
    
    // Eigenschaften: 4 Instanzen von der Klasse Tempel, Held(in)
    private Tempel wasserTempel;
    private Tempel feuerTempel;
    private Tempel luftTempel;
    private Tempel erdeTempel;
    
    private Spieler held;
    private Spieler ki; // wie viele KIs? -> mehr als 1 (?) 
    
    // private Quizz ...
    private UnoKartenspiel uno;
    
    // spiel brauch glaube ich keinen Konstruktor
    // Konstruktor -> Spiel erzeugen...
    public Spiel() {
    
        // alle 4 Tempel erzeugen -> Bsp:
        wasserTempel = new Tempel("blau", 1);
        luftTempel = new Tempel("gelb", 2);
        erdeTempel = new Tempel("gruen", 3); 
        feuerTempel = new Tempel("rot", 4);
        
        // Spieler ist abstrakt also: Held,KI etc.
        // KartenStapel
        
        
    }

    /**
     * main
     * @param args
     */
    public static void main(String[] args){

    }
	
}