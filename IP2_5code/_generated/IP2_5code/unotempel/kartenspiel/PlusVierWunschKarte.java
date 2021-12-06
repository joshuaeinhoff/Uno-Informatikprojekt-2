package unotempel.kartenspiel;

/** Der Spieler, der diese Karte legt, entscheidet welche Farbe als n&auml;chstes gelegt werden soll.<br>
 * Zudem muss der Gegenspieler vier Karten von dem Kartenstapel ziehen.<br>
 <br>*/
public class PlusVierWunschKarte extends Karte{
    
    /**<br>
     * Konstruktor mit default-Werten: Farbe schwarz und Nummer 14<br>
     <br>*/
    public PlusVierWunschKarte(){
        super("schwarz", 14);
    }


    /**<br>
     * Konstruktor zum Erzeugen einer PlusVierWunschKarte mit einer bestimmten Farbe<br>
     * @param neueFarbe - Neue Farbe (nur nachdem eine PlusVierWunschKarte gespielt wird)<br>
     <br>*/
    public PlusVierWunschKarte(String neueFarbe){
        super(neueFarbe, 14);
    }


    /**<br>
     * Funktion gibt zur&uuml;ck, ob die Karte eine PlusVierWunschKarte ist<br>
     * @param kartenart - Art der Karte<br>
     * @return true - falls die KartenArt passt, false - sonst<br>
     <br>*/
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("PlusVierWunsch");
    }


    /**<br>
     * Funktion zum Durchf&uuml;hren der Aktion einer speziellen Karte<br>
     * @return int - Code f&uuml;r die Aktion<br>
     <br>*/
    @Override
    public int aktionDurchfuehren() {
        // Code 4: Vier Karte Ziehen
        return 4;
    }
    
} // Ende von PlusVierWunschKarte