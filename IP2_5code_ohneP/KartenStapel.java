import java.util.*;

/**
 * Kartenstapel enthält alle Uno-Karten. Das sind insgesamt 108 Karten.
 */
public class KartenStapel {

    // Eigenschaften: Uno-Karten und Anzahl der Karten

    //private ArrayList<Karte> karten; //OOP2

    private Karte[] karten;
    
    private boolean[] vorhandeneKarten;
    private boolean[] abgelegteKarten;

    private int anzahlKarten;

    private String farben[] = { "blau", "gelb", "grün", "rot" };

    

    /**
     * Konstruktor erzeugt einen Array mit 108 Karten 
     */
    public KartenStapel() {
        //karten = new ArrayList<>(); //OOP2
        karten = new Karte[108];
        vorhandeneKarten = new boolean[108];
        abgelegteKarten = new boolean[108];
        updateKartenAnzahl();
    }
	

    /**
     * Prozedur zum Füllen eines KartenStapels
     */
    public void fuelleMitKarten() {
        // index
        int farbeIndex = 0;
        // 4x Farbkarten von 0 bis 9 erzeugen
        for (int i = 0; i < 40; i++) {
            karten[i] = new FarbKarte(farben[farbeIndex % 4], i / 4);
            vorhandeneKarten[i] = true;
        }
        // 4x Farbkarten von 1 bis 9 erzeugen
        for (int i = 40; i < 76; i++) {
            karten[i] = new FarbKarte(farben[farbeIndex % 4], ((i / 4) % 10) + 1);
            vorhandeneKarten[i] = true;
        }
        // 2x AussetzenKarten jeder Farbe erzeugen
        for (int i = 76; i < 84; i++) {
            karten[i] = new AussetzenKarte(farben[farbeIndex % 4]);
            farbeIndex++;
            vorhandeneKarten[i] = true;
        }
        // 2x RetourKarten jeder Farbe erzeugen
        for (int i = 84; i < 92; i++) {
            karten[i] = new RetourKarte(farben[farbeIndex % 4]);
            farbeIndex++;
            vorhandeneKarten[i] = true;
        }
        // 2x PlusZweiKarten jeder Farbe erzeugen
        for (int i = 92; i < 100; i++) {
            karten[i] = new PlusZweiKarte(farben[farbeIndex % 4]);
            farbeIndex++;
            vorhandeneKarten[i] = true;
        }
        // 4x WunschKarten erzeugen
        for (int i = 100; i < 104; i++) {
            karten[i] = new WunschKarte();
            vorhandeneKarten[i] = true;
        }
        // 4x PlusVierWunschKarten erzeugen
        for (int i = 104; i < 108; i++) {
            karten[i] = new PlusVierWunschKarte();
            vorhandeneKarten[i] = true;
        }
    }


    /**
     * Funktion gibt die Anzahl der vorhandenen im KartenStapel zurück
     * @return Anzahl von Karten im Stapel
     */
    public int anzahlVorhandeneKarten() {
        // Zähler auf 0 setzen
        int zaehler = 0;
        // Über die Karten im Stapel iterieren
        for(int i = 0; i < karten.length; i++) {
            // Wenn Karte auf Index i noch vorhanden ist
            if(vorhandeneKarten[i])
                // Zähler inkrementieren
                zaehler++;
        }
        // Anzahl von Karten im Stapel zurückgeben
        return zaehler;
    }


    /**
     * Prozedur zum Setzen der aktuellen Karte im AblageStapel
     * @param aktuelleKarte - Aktuelle Karte im Spiel
     */
    public void setzeKarteAblageStapel(Karte aktuelleKarte) {
        // Über den KartenStapel iterieren
        for(int i = 0; i < karten.length; i++) {
            // Wenn die aktuelle Karte gefunden wird
            if(aktuelleKarte.equals(karten[i]))
                // Wird als abgelegte Karte gespeichert
                abgelegteKarten[i] = true;
        }
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
     * Funktion zum Ziehen einer Karte aus dem Stapel
     * @param aktuelleKarte - Aktuelle Karte im Spiel
     * @return eine Karte aus Stapel
     */
    public Karte karteZiehen(Karte aktuelleKarte){
        /*
        int randKartenPosition = getRandomInt(0,anzahlKarten);
        Karte temp = karten.get(randKartenPosition);
        karten.remove(randKartenPosition);
        updateKartenAnzahl();
        return temp;
        */

        // Prüfen, ob es vorhandene Karten im Stapel gibt
        if(anzahlVorhandeneKarten() < 1)
            // Falls nicht: Karten Mischen und wieder als vorhanden setzen
            kartenMischen(aktuelleKarte);
        // Zufällige Kartenposition zwischen 0 und karten.length-1
        int randomKartenPosition = getRandomInt(0, karten.length);
        // Bedingung: Karte kann nur gezogen werden, wenn diese im KartenStapel vorhanden ist
        while(!vorhandeneKarten[randomKartenPosition]) {
            randomKartenPosition = getRandomInt(0, karten.length);
        }
        // Vorhandene Karte kann gezogen werden und steht nicht mehr im Stapel zur Verfügung
        vorhandeneKarten[randomKartenPosition] = false;
        // Vorhandene Karte im KartenStapel zurückgeben
        return karten[randomKartenPosition];
    }


    /**
     * Prozedur zum Mischen der Karten und wieder als vorhanden setzen
     * Die aktuelle Karte darf nicht im Stapel gesetzt werden
     * @param aktuelleKarte - Aktuelle Karte im Spiel
     */
    public void kartenMischen(Karte aktuelleKarte) {
        // Index der aktuellen Karte im Stapel finden:
        // Index der aktuellen Karten auf einen unmöglichen Wert setzen
        int indexAktuelleKarte = -1;
        // Über den KartenStapel iterieren
        for(int i = 0; i < karten.length; i++) {
            // Wenn die aktuelle Karte im Spiel gefunden wird
            if(karten[i] == aktuelleKarte) {
                // Index der aktuellen Karte speichern
                indexAktuelleKarte = i;
                // Schleife unterbrechen
                break;
            }
        }
        // Karten als vorhanden setzen:
        // Über den KartenStapel iterieren, aktuelle Karte kann nicht als vorhanden gesetzt werden
        for(int i = 0; i < karten.length; i++) {
            // Wenn die Karte im AblageStapel ist und ist nicht die aktuelle Karte im Spiel
            if(abgelegteKarten[i] && i != indexAktuelleKarte) {
                // Als vorhandene Karte zur Verfügung stellen
                vorhandeneKarten[i] = true;
                // Aus dem AblageStapel ziehen
                abgelegteKarten[i] = false;
            }
        }

    }

} // Ende von KartenStapel