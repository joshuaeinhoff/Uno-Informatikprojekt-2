package quiz;
import java.io.*;

/**
 * Klasse stellt eine Instanz von Quizfragenpool im Spiel mit seinen jeweiligen Attributen dar.
 */
public class Quizfragenpool {

    // Eigenschaften einer Instanz von Quizfragenpool
    private int quizNiveau;
    private Quizfrage[] quizfragen;
    private int anzahlQuizfragen;

    /**
     * Konstruktor erzeugt eine Instanz von Quizfragenpool dem folgenden Attribut:
     * @param quizNiveau - Niveau der Quizfragen (1 für OOP1, 2 für OOP2)
     */
    public Quizfragenpool(int quizNiveau) {
        this.quizNiveau = quizNiveau;
    }

    
    /**
     * Prozedur zum Füllen eines Quizfragenpools von einem bestimmten Tempel
     * Anruf an die private Funktion 'quizfragenAuslesen' und die private Prozedur 'quizfragenBearbeiten'
     * @param tempelBuchstabe - Erster Buchstabe des Namens von einem Tempel
     */
    public void quizfragenpoolFuellen(char tempelBuchstabe) {
        // String-Array zum Speichern den Rückgabe-Wert der Funktion
        String[] datensaetze = quizfragenAuslesen(tempelBuchstabe);
        // und als Parameter der Prozedur übergeben
        quizfragenBearbeiten(datensaetze);
    }


    /**
     * Private Methode liest, speichert und gibt Datensätze aus einer bestimmten Datei als String-Array zurück
     * @param tempelBuchstabe - Erster Buchstabe des Namens von einem Tempel
     * @return Array von String
     */
    private String[] quizfragenAuslesen(char tempelBuchstabe) {
        // Variablen zum Speichern der aus einer Datei gelesenen Datensätze
        String datensatz; // Zum Speichern eines Datensatzes
        String[] datensaetze = new String[50]; // d.h. Speicherplatz für max. 10 Quizfragen
        int anzahlDatensaetze = 0; // Anzahl von Datensätzen speichern und mitzählen

        // try-Block - Es wird versucht, aus einer Datei mithilfe eines FileReaders Datensätze zu lesen
        try {
            // Variable zum Speichern des Dateinamens
            String dateiName = "";

            // Je nach Anfangsbuchstabe und Quizniveau des Tempels wird ein bestimmter Dateipfad gespeichert
            switch(tempelBuchstabe) {
                case 'w': // Wasser-Tempel
                    if(quizNiveau == 1)
                        dateiName = "./quizfragen/fragen_t1_oop1.txt";
                    else if(quizNiveau == 2)
                        dateiName = "./quizfragen/fragen_t1_oop2.txt";
                    break;
                case 'l': // Luft-Tempel
                    if(quizNiveau == 1)
                        dateiName = "./quizfragen/fragen_t2_oop1.txt";
                    else if(quizNiveau == 2)
                        dateiName = "./quizfragen/fragen_t2_oop2.txt";
                    break;
                case 'e': // Erde-Tempel
                    if(quizNiveau == 1)
                        dateiName = "./quizfragen/fragen_t3_oop1.txt";
                    else if(quizNiveau == 2)
                        dateiName = "./quizfragen/fragen_t3_oop2.txt";
                    break;
                case 'f': // Feuer-Tempel
                    if(quizNiveau == 1)
                        dateiName = "./quizfragen/fragen_t4_oop1.txt";
                    else if(quizNiveau == 2)
                        dateiName = "./quizfragen/fragen_t4_oop2.txt";
                    break;
            }

            // Kanonische Erzeugung eines FilterReaders zum Lesen aus einer Datei
            FilterReader fr = new FilterReaderDatensatz(
                              new FilterReaderZeichen(
                              new BufferedReader(
                              new FileReader(dateiName))));

            // Variablen zum Lesen aus einer Datei
            int off = 0; // Anfang-Index für einen Array
            int len = 300; // Max. Länge von Zeichen
            int num = 0; // Anzahl von gelesenen Zeichen

            // Buffer zum Lesen und Daten aus der Datei zwischenzuspeichern
            char[] buf = new char[len + off];
            // Solange Ende des Streams nicht erreicht wird
            while (num != -1) {
                // Zeichen lesen
                num = fr.read(buf, off, len);
                // Wenn nicht Ende des Streams
                if (num != -1) {
                    // String aus dem Buffer erzeugen
                    datensatz = new String(buf, off, num);
                    System.out.println(datensatz); // !!! Zum Testen !!!
                    // Datensatz in den String-Array speichern und Anzahl von Datensätzen inkrementieren
                    datensaetze[anzahlDatensaetze++] = datensatz;
                }
            }
        // catch-Exception - Fall IOException abgefangen wird, wird eine Meldung auf der Konsole ausgegeben
        } catch(IOException ioe) {
            ioe.getMessage();
        }
        // String-Array von Datensätzen zurückgeben
        return datensaetze;
    }


    /**
     * Private Prozedur zum Bearbeiten und zum Speichern der gelesenen Datensätze als Quizfragen
     * @param datensaetze - String Array mit gelesenen Daten
     */
    private void quizfragenBearbeiten(String[] datensaetze) {
        // Anzahl von Quizfragen auf 0 setzen
        this.anzahlQuizfragen = 0;
        // Array von Quizfragen mit einer bestimmten Länge erzeugen, die von der Länge des String-Arrays abhängt
        this.quizfragen = new Quizfrage[datensaetze.length / 5]; // Durch 5 geteilt: Quizfrage kann 5 Attribute besitzen
        // Variablen um den Index im String-Array mitzuzählen
        int datenIndex = 0;

        // Über die Länge des Quizfragen-Arrays iterieren und die Quizfragen richtig erzeugen und speichern
        for(int i = 0; i < this.quizfragen.length; i++) {
            // Quizfrage erzeugen mit den folgenden Attributen: Frage, Antwort1, Antwort2, Antwort3 und richtigeAntwort (als char)
            Quizfrage quizfrage = new Quizfrage(datensaetze[datenIndex], datensaetze[datenIndex+1], datensaetze[datenIndex+2], datensaetze[datenIndex+3], datensaetze[datenIndex+4].charAt(0));
            // Quizfrage in Array von Quizfragen speichern und Anzahl von Quizfragen inkrementieren
            this.quizfragen[this.anzahlQuizfragen++] = quizfrage;
            // Index im String Array inkrementieren
            datenIndex++;
        }
    }


    /**
     * Funktion zum Beantworten der zu einem gegebenen Index im Fragenpool gespeicherten Frage
     * @param zufallsZahl - gegebener Index
     * @return true - wenn die Frage richtig beantwortet wird, false - sonst
     */
    public boolean quizfrageBeantworten(int zufallsZahl) {
        // Quizfrage darstellen
        //GUI.quizDarstellen(quizfragen[zufallsZahl].getFrage(), quizfragen[zufallsZahl].getAntwortmoeglichkeiten(), quizfragen[zufallsZahl].getRichtigeAntwort());
        // if... geklickte Antwort is richtig
        return true;
        // else
        // return false;

    }


} // Ende von Quizfragenpool