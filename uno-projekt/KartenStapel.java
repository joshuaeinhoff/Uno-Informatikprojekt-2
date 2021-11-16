import java.util.*;
/**
 * 
 */
class KartenStapel {

    // Eigenschaften: Uno-Karten und Anzahl der Karten

    //private ArrayList<Karte> karten; //OOP2

    private Karte[] karten;
    private int anzahlKarten;
    
    // Konstruktor -> Erzeugt einen Array mit 108 Karten 
    public KartenStapel() {
        //karten = new ArrayList<>(); //OOP2
        karten = new Karte[108];
        updateKartenAnzahl();
    }
	
    
    /**
     * helper method for generating a random int in a range
     * @param min - inclusive
     * @param max - exclusive
     * @return - random int 
     */
    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    
    public void updateKartenAnzahl(){

        //anzahlKarten = this.karten.size(); //OOP2

        anzahlKarten = this.karten.length;

    }
    
    public Karte karteZiehen(){
        /*
        int randKartenPosition = getRandomInt(0,anzahlKarten);
        Karte temp = karten.get(randKartenPosition);
        karten.remove(randKartenPosition);
        updateKartenAnzahl();
        return temp;
        */
        int randomKartenPosition = getRandomInt(0, karten.length);
        return karten[randomKartenPosition];
    }
    
    public void fuelleKartendeck(){
        //Nur vorläufig
        for(int i = 0; i < 76; i++)
        {
            karten[i] = new FarbKarte(); // muss später geändert werden da es unteschiedliche Farbkarten gibt
        }
        for(int i = 76; i < 84; i++){
            karten[i] = new AussetzenKarte();
        }
        for(int i = 84; i < 92; i++){
            karten[i] = new RetourKarte();
        }
        for(int i = 92; i < 100; i++){
            karten[i] = new PlusZweiKarte();
        }
        for(int i = 100; i < 104; i++){
            karten[i] = new WunschKarte();
        }
        for(int i = 104; i < 108; i++){
            karten[i] = new PlusVierWunschKarte();
        }
    }
}//end of KartenStapel