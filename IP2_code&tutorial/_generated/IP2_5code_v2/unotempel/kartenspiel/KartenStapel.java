package unotempel.kartenspiel;

/**<br>
 * Kartenstapel enth&auml;lt alle Uno-Karten. Das sind insgesamt 108 Karten.<br>
 <br>*/
public class KartenStapel {

    // Eigenschaften  
    private Karte[] karten; //private ArrayList<Karte> karten; //OOP2
    // Boolean-Array zum Speichern ob die Karten noch vorhanden oder abgelegt sind
    private boolean[] vorhandeneKarten;
    private boolean[] abgelegteKarten;
    // Mögliche Farben der Karten
    private String farben[] = { "blau", "gelb", "gruen", "rot" };


    /**<br>
     * Konstruktor erzeugt einen Array mit 108 Karten <br>
     <br>*/
    public KartenStapel() {
        karten = new Karte[108]; //karten = new ArrayList<>(); //OOP2
        vorhandeneKarten = new boolean[108];
        abgelegteKarten = new boolean[108];
    }
	

    /**<br>
     * Prozedur zum F&uuml;llen eines KartenStapels<br>
     <br>*/
    public void fuelleMitKarten() {
        // index
        int farbeIndex = 0;
        // 4x Farbkarten von 0 bis 9 erzeugen
        for (int i = 0; i < 40; i++) {
            karten[i] = new FarbKarte(farben[farbeIndex % 4], i / 4);
            vorhandeneKarten[i] = true;
            karten[i].erzeugeVisuelleKarte(farben[farbeIndex % 4]);
            farbeIndex++;
        }
        // 4x Farbkarten von 1 bis 9 erzeugen
        for (int i = 40; i < 76; i++) {
            karten[i] = new FarbKarte(farben[farbeIndex % 4], ((i / 4) % 10) + 1);
            vorhandeneKarten[i] = true;
            karten[i].erzeugeVisuelleKarte(farben[farbeIndex % 4]);
            farbeIndex++;
        }
        // 2x AussetzenKarten jeder Farbe erzeugen
        for (int i = 76; i < 84; i++) {
            karten[i] = new AussetzenKarte(farben[farbeIndex % 4]);
            vorhandeneKarten[i] = true;
            karten[i].erzeugeVisuelleKarte(farben[farbeIndex % 4]);
            farbeIndex++;
        }
        // 2x RetourKarten jeder Farbe erzeugen
        for (int i = 84; i < 92; i++) {
            karten[i] = new RetourKarte(farben[farbeIndex % 4]);
            vorhandeneKarten[i] = true;
            karten[i].erzeugeVisuelleKarte(farben[farbeIndex % 4]);
            farbeIndex++;
        }
        // 2x PlusZweiKarten jeder Farbe erzeugen
        for (int i = 92; i < 100; i++) {
            karten[i] = new PlusZweiKarte(farben[farbeIndex % 4]);
            vorhandeneKarten[i] = true;
            karten[i].erzeugeVisuelleKarte(farben[farbeIndex % 4]);
            farbeIndex++;
        }
        // 4x WunschKarten erzeugen
        for (int i = 100; i < 104; i++) {
            karten[i] = new WunschKarte();
            vorhandeneKarten[i] = true;
            karten[i].erzeugeVisuelleKarte("schwarz");
        }
        // 4x PlusVierWunschKarten erzeugen
        for (int i = 104; i < 108; i++) {
            karten[i] = new PlusVierWunschKarte();
            vorhandeneKarten[i] = true;
            karten[i].erzeugeVisuelleKarte("schwarz");
        }
    }


    /**<br>
     * Funktion gibt die Anzahl der vorhandenen im KartenStapel zur&uuml;ck<br>
     * @return Anzahl von Karten im Stapel<br>
     <br>*/
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


    /**<br>
     * Prozedur zum Setzen der aktuellen Karte im AblageStapel<br>
     * @param aktuelleKarte - Aktuelle Karte im Spiel<br>
     <br>*/
    public void setzeKarteAblageStapel(Karte aktuelleKarte) {
        // Über den KartenStapel iterieren
        for(int i = 0; i < karten.length; i++) {
            // Wenn die aktuelle Karte gefunden wird
            if(aktuelleKarte.equals(karten[i]))
                // Wird als abgelegte Karte gespeichert
                abgelegteKarten[i] = true;
        }
    }
   

    /**<br>
     * Funktion zum Ziehen einer Karte aus dem Stapel<br>
     * @param aktuelleKarte - Aktuelle Karte im Spiel<br>
     * @return eine Karte aus Stapel<br>
     <br>*/
    public Karte karteZiehen(Karte aktuelleKarte){
        // Prüfen, ob es vorhandene Karten im Stapel gibt
        if(anzahlVorhandeneKarten() < 1)
            // Falls nicht: Karten Mischen und wieder als vorhanden setzen
            kartenMischen(aktuelleKarte);
        // Zufällige Kartenposition zwischen 0 und karten.length-1
        int randomKartenPosition = (int)(Math.random() * karten.length);
        
        // Bedingung: Karte kann nur gezogen werden, wenn diese im KartenStapel vorhanden ist
        while(!vorhandeneKarten[randomKartenPosition]) {
            randomKartenPosition = (int)(Math.random() * karten.length);
        }
        // Vorhandene Karte kann gezogen werden und steht nicht mehr im Stapel zur Verfügung
        vorhandeneKarten[randomKartenPosition] = false;
        // Vorhandene Karte im KartenStapel zurückgeben
        return karten[randomKartenPosition];
    }


    /**<br>
     * Prozedur zum Mischen der Karten und wieder als vorhanden setzen<br>
     * Die aktuelle Karte darf nicht im Stapel gesetzt werden<br>
     * @param aktuelleKarte - Aktuelle Karte im Spiel<br>
     <br>*/
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