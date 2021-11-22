package kartenspiel;

/**
 * Nachdem ein Spieler diese Karte gelegt hat, wird der Gegenspieler „übersprungen“ und derjenige, der die Karte gelegt hat, darf nochmal legen. 
 * Die Karte kann nur auf eine andere mit entsprechender Farbe oder eine andere AussetzenKarte gelegt werden. 
 * Wenn diese Karte zu Beginn des Spiels gezogen wird, dann muss derjenige, der anfängt, aussetzen und der Gegenspieler darf beginnen.   
 */
public class AussetzenKarte extends Karte{

    public AussetzenKarte(String _farbe){
        super(_farbe);
    }
    
}//end of AussetzenKarte
