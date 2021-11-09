import java.util.*;
/**
 * 
 */
class KartenStapel {

    // Eigenschaften: Uno-Karten und Anzahl der Karten
    private ArrayList<Karte> karten;
    private int anzahlKarten;
    
    // Konstruktor -> Erzeugt einen Array mit 108 Karten 
    public KartenStapel() {
        karten = new ArrayList<>();
        updateKartenAnzahl();
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
        anzahlKarten = this.karten.size();
    }
    
    public Karte karteZiehen(){
        int randKartenPosition = getRandomInt(0,anzahlKarten);
        Karte temp = karten.get(randKartenPosition);
        karten.remove(randKartenPosition);
        updateKartenAnzahl();
        return temp;
    }
    
    public void fuelleKartendeck(UnoKartenStapel stapel){
        //code
    }
}