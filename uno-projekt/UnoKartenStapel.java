import java.util.*;
/**
 * 
 */
class UnoKartenStapel {

    // Eigenschaften: Uno-Karten und Anzahl der Karten
    //private UnoKarte[] karten;
    private ArrayList<UnoKarte> karten;
    private int anzahlUnoKarten;
    
    // Konstruktor -> Erzeugt einen Array mit 108 Karten 
    // bis jetzt nur einen Array der Platz für 108 Karten hat
    private UnoKartenStapel() {
        // karten = new UnoKarte[108];
        karten = new ArrayList<>();
        updateKartenAnzahl();
    }
	
    // factory method -> ??
    // muss den Kartenstapel mit allen 108 Karteninstanzen füllen
    public static UnoKartenStapel kartenStapelErzeugen() {
        return new UnoKartenStapel();
    }

    /**
     * helper method for generating a random int in a range
     * @param min - inclusive
     * @param max - exclusive
     * @return - random int 
     */
    public int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    
    public void updateKartenAnzahl(){
        anzahlUnoKarten = this.karten.size();
    }
    
    public UnoKarte karteZiehen(){
        int randKartenPosition = getRandomInt(0,anzahlUnoKarten);
        UnoKarte temp = karten.get(randKartenPosition);
        karten.remove(randKartenPosition);
        updateKartenAnzahl();
        return temp;
    }
    
    public void fuelleKartendeck(UnoKartenStapel stapel){
        //code
    }
}