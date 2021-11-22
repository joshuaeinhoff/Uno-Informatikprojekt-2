package kartenspiel;

/**
 * Der Spieler, der diese Karte legt, entscheidet welche Farbe als nächstes gelegt werden soll. WunschKarten kann man immer legen, 
 * das heißt man muss nicht auf die Farbe der vorherigen Karte achten. Wenn eine WunschKarte zu Beginn des Spiels gezogen wird, 
 * entscheidet der Spieler, der anfangen darf, welche Farbe als nächstes gelegt werden soll.
 */
public class WunschKarte extends Karte{

    public WunschKarte(String _farbe){
        super(_farbe);
    }
    
}//end of WunschKarte
