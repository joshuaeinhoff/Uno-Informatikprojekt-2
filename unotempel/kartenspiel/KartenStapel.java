package unotempel.kartenspiel;

import java.util.*;

/**
 * Kartenstapel enthält alle Uno-Karten. Das sind insgesamt 108 Karten.
 */
public class KartenStapel {

    // Eigenschaften: Uno-Karten und Anzahl der Karten

    //private ArrayList<Karte> karten; //OOP2

    private Karte[] karten;
    private int anzahlKarten;

    private String farben[] = { "blau", "gelb", "grün", "rot" };

    

    /**
     * Konstruktor erzeugt einen Array mit 108 Karten 
     */
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
    
    /**
     * Aktualisiert die Anzahl der Karten im Kartenstapel
     */
    public void updateKartenAnzahl(){

        //anzahlKarten = this.karten.size(); //OOP2

        anzahlKarten = this.karten.length;

    }
    

    /**
     * 
     * @return
     */
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
    

    /**
     * Prozedur zum Füllen eines KartenStapels
     */
    public void fuelleKartenStapel(){
        // index 
        int farbeIndex = 0;
        // 4x Farbkarten von 0 bis 9 erzeugen
        for(int i = 0; i < 40; i++) {
            karten[i] = new FarbKarte(farben[farbeIndex%4],i/4);
        }
        // 4x Farbkarten von 1 bis 9 erzeugen
        for(int i = 40; i < 76; i++) {
            karten[i] = new FarbKarte(farben[farbeIndex%4],((i/4)%10)+1);
        }
        // 2x AussetzenKarten jeder Farbe erzeugen
        for(int i = 76; i < 84; i++){
            karten[i] = new AussetzenKarte(farben[farbeIndex%4]);
            farbeIndex++;
        }
        // 2x RetourKarten jeder Farbe erzeugen
        for(int i = 84; i < 92; i++){
            karten[i] = new RetourKarte(farben[farbeIndex%4]);
            farbeIndex++;
        }
        // 2x PlusZweiKarten jeder Farbe erzeugen
        for(int i = 92; i < 100; i++){
            karten[i] = new PlusZweiKarte(farben[farbeIndex%4]);
            farbeIndex++;
        }
        // 4x WunschKarten erzeugen
        for(int i = 100; i < 104; i++){
            karten[i] = new WunschKarte();
        }
        // 4x PlusVierWunschKarten erzeugen
        for(int i = 104; i < 108; i++){
            karten[i] = new PlusVierWunschKarte();
        }

    }

}//end of KartenStapel