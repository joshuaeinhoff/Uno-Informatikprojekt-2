package kartenspiel;

/**
 * Bei dieser Karte ändert sich die Spielrichtung. Die Karte kann nur auf eine entsprechende Farbe oder eine andere RetourKarte 
 * gelegt werden. Wenn diese Karte zu Beginn des Spiels gezogen wird, muss der Spieler, der anfangen darf, aussetzten und sein 
 * Gegenspieler darf anfangen.   
 */
public class RetourKarte extends Karte{

    public RetourKarte(String _farbe){
        super(_farbe);
    }
    
}//end of RetourKarte
