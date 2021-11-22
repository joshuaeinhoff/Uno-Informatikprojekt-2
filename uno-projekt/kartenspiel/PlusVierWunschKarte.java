package kartenspiel;

/** Der Spieler, der diese Karte legt, entscheidet welche Farbe als nächstes gelegt werden soll.
 * Zudem muss der Gegenspieler vier Karten von dem Kartenstapel ziehen.
 *
 */
public class PlusVierWunschKarte extends Karte{
    
    // Superkonstruktor
    public PlusVierWunschKarte(String _farbe){
        super(_farbe);
    }
    
}//end of PlusVierWunschKarte
