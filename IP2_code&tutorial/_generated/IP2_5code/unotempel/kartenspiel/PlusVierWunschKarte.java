package unotempel.kartenspiel;

/** Der Spieler, der diese Karte legt, entscheidet welche Farbe als n&auml;chstes gelegt werden soll.
 * Zudem muss der Gegenspieler vier Karten von dem Kartenstapel ziehen.
 <br>*/
public class PlusVierWunschKarte extends Karte{
    
    /**
     * Konstruktor mit default-Werten: Farbe schwarz und Nummer 14
     <br>*/
    public PlusVierWunschKarte(){
        super("schwarz", 14);
    }


    /**
     * Konstruktor zum Erzeugen einer PlusVierWunschKarte mit einer bestimmten Farbe
     * @param neueFarbe - Neue Farbe (nur nachdem eine PlusVierWunschKarte gespielt wird)
     <br>*/
    public PlusVierWunschKarte(String neueFarbe){
        super(neueFarbe, 14);
    }


    /**
     * Funktion gibt zur&uuml;ck, ob die Karte eine PlusVierWunschKarte ist
     * @param kartenart - Art der Karte
     * @return true - falls die KartenArt passt, false - sonst
     <br>*/
    public boolean istWelcheKarte(String kartenart){
        return kartenart.equals("PlusVierWunsch");
    }


    /**
     * Funktion zum Durchf&uuml;hren der Aktion einer speziellen Karte
     * @return int - Code f&uuml;r die Aktion
     <br>*/
    @Override
    public int aktionDurchfuehren() {
        // Code 4: Vier Karte Ziehen
        return 4;
    }
    
    public String toString(){
        return "PlusVierWunschKarte";
    }
    
} // Ende von PlusVierWunschKarte