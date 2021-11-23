package kartenspiel;

/** Der Spieler, der diese Karte legt, entscheidet welche Farbe als nächstes gelegt werden soll.
 * Zudem muss der Gegenspieler vier Karten von dem Kartenstapel ziehen.
 */
public class PlusVierWunschKarte extends Karte{
    
    // Superkonstruktor
    public PlusVierWunschKarte(String _farbe, int _id){
        super(_farbe, _id);
    }


    public boolean istWelcheKarte(String kartenart){
        if(kartenart.equals("PlusVierWunsch")){
            return true;
        }
        return false;
    }
    
    
}//end of PlusVierWunschKarte
