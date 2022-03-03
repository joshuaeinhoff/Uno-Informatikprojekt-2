package unotempel.quiz;

import java.io.*;
import unotempel.*;

/**<br>
 * Klasse stellt eine Instanz von Quizfragenpool im Spiel mit seinen jeweiligen Attributen dar.<br>
 <br>*/
public class Quizfragenpool {

    // Eigenschaften einer Instanz von Quizfragenpool
    private int quizNiveau;
    private Quizfrage[] quizfragen;
    private int anzahlQuizfragen;
 

    /**<br>
     * Konstruktor erzeugt eine Instanz von Quizfragenpool mit dem folgenden Attribut:<br>
     * @param quizNiveau - Niveau der Quizfragen (1 f&uuml;r OOP1, 2 für OOP2)<br>
     <br>*/
    public Quizfragenpool(int quizNiveau) {
        this.quizNiveau = quizNiveau;
    }


    /**<br>
     * Funktion gibt die Anzahl von Quizfragen zur&uuml;ck<br>
     * @return Anzahl von Quizfragen im Quizfragenpool<br>
     <br>*/
    public int anzahlQuizfragen() {
        return anzahlQuizfragen;
    }


    /**<br>
     * Prozedur zum F&uuml;llen eines Quizfragenpools von einem bestimmten Tempel<br>
     * Anruf an die private Funktion 'quizfragenAuslesen' und die private Prozedur 'quizfragenBearbeiten'<br>
     * @param tempelFarbe - String mit der Farbe des Tempels<br>
     <br>*/
    public void quizfragenpoolFuellen(String tempelFarbe) {
        // String-Array zum Speichern den Rückgabe-Wert der Funktion
        String[] datensaetze = quizfragenAuslesen(tempelFarbe);
        // und als Parameter der Prozedur übergeben
        quizfragenBearbeiten(datensaetze);
    }


    /**<br>
     * Private Funktion liest, speichert und gibt Datens&auml;tze aus einer bestimmten Datei als String-Array zur&uuml;ck<br>
     * @param tempelFarbe - String mit der Farbe des Tempels<br>
     * @return Array von String<br>
     <br>*/
    private String[] quizfragenAuslesen(String tempelFarbe) {
        // Variablen zum Speichern der aus einer Datei gelesenen Datensätze
        String datensatz; // Zum Speichern eines Datensatzes
        String[] datensaetze = new String[50]; // d.h. Speicherplatz für max. 10 Quizfragen
        int anzahlDatensaetze = 0; // Anzahl von Datensätzen speichern und mitzählen

        // try-Block - Es wird versucht, aus einer Datei mithilfe eines FileReaders Datensätze zu lesen
        try {
            // Variable zum Speichern des Dateinamens
            String dateiName = "";
            // Je nach Farbe und Quizniveau des Tempels wird ein bestimmter Dateipfad gespeichert
            switch(tempelFarbe) {
                case "blau": // Wasser-Tempel
                    if(quizNiveau == 1)
                        dateiName = "../../quizfragen/fragen_t1_oop1.txt";
                    else if(quizNiveau == 2)
                        dateiName = "../../quizfragen/fragen_t1_oop2.txt";
                    break;
                case "gelb": // Luft-Tempel
                    if(quizNiveau == 1)
                        dateiName = "../../quizfragen/fragen_t2_oop1.txt";
                    else if(quizNiveau == 2)
                        dateiName = "../../quizfragen/fragen_t2_oop2.txt";
                    break;
                case "gruen": // Erde-Tempel
                    if(quizNiveau == 1)
                        dateiName = "../../quizfragen/fragen_t3_oop1.txt";
                    else if(quizNiveau == 2)
                        dateiName = "../../quizfragen/fragen_t3_oop2.txt";
                    break;
                case "rot": // Feuer-Tempel
                    if(quizNiveau == 1)
                        dateiName = "../../quizfragen/fragen_t4_oop1.txt";
                    else if(quizNiveau == 2)
                        dateiName = "../../quizfragen/fragen_t4_oop2.txt";
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
                    //System.out.println(datensatz); // !!! Zum Testen !!!
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


    /**<br>
     * Private Prozedur zum Bearbeiten und zum Speichern der gelesenen Datens&auml;tze als Quizfragen<br>
     * @param datensaetze - String Array mit gelesenen Daten<br>
     <br>*/
    private void quizfragenBearbeiten(String[] datensaetze) {
        // Variable für die Anzahl von Datensätzen auf 0 setzen
        int anzahlDatensaetze = 0;
        
        // Über die Länge des Datensätze-Arrays iterieren
        for(int i = 0; i < datensaetze.length; i++) {
        	// Prüfen, ob ein Wert ungleich null im gegebenen Index gespeichert wurde
        	if(datensaetze[i] != null) {
            	// Falls ja: Anzahl von Datensätzen inkrementieren
            	anzahlDatensaetze++;
            }
        }
        
        // Anzahl von Datensätzen für Quizfragen mit nur zwei Antwortmöglichkeiten anpassen
        while(anzahlDatensaetze % 5 != 0) {
        	anzahlDatensaetze++;
        }
        
        // Anzahl von Quizfragen einen bestimmten Wert zuweisen, der von der Anzahl der Datensätzen abhängt
        this.anzahlQuizfragen = anzahlDatensaetze / 5;
        // Array von Quizfragen mit einer bestimmten Länge erzeugen, die der Anzahl von Quizfragen entspricht
        this.quizfragen = new Quizfrage[this.anzahlQuizfragen]; // Durch 5 geteilt: Quizfrage kann 5 Attribute besitzen
        // Variable erzeugen, um den Index im String-Array mitzuzählen
        int datenIndex = 0;

        // Variablen einer Quizfragen erstmal definieren, um Quizfragen-Attribute zwischenzuspeichern
        char richtigeAntwort;
        String frage;
        // Array von Strings für bis zu drei Antwortmöglichkeiten erzeugen
        String[] antwortmoeglichkeiten = new String[3];

        // Über die Länge des Quizfragen-Arrays iterieren und die Quizfragen richtig erzeugen und speichern
        for(int i = 0; i < this.anzahlQuizfragen; i++) {
            // Den Variablen einer Quizfragen entsprechende Werte zuweisen und datenIndex inkrementieren  
            frage = datensaetze[datenIndex++];
            antwortmoeglichkeiten[0] = datensaetze[datenIndex++]; 
            antwortmoeglichkeiten[1] = datensaetze[datenIndex++];
            
            // Prüfen, ob Quizfrage nur zwei Antwortmöglichkeiten hat
        	if(datensaetze[datenIndex].charAt(1) != ')') {
                // Der richtigen Antwort den entsprechenden Wert zuweisen und datenIndex inkrementieren
            	richtigeAntwort = datensaetze[datenIndex++].charAt(0);
                // Einen bestimmten Konstruktor von Quizfrage aufrufen und Quizfrage im entsprechenden Index des Quizfrage-Arrays speichern
            	this.quizfragen[i] = new Quizfrage(frage, antwortmoeglichkeiten[0], antwortmoeglichkeiten[1], richtigeAntwort);
            // Quizfrage hat drei Antwortmöglichkeiten
            } else {
            	// Der dritte Antwortmöglichkeit den entsprechenden Wert zuweisen und datenIndex inkrementieren 
            	antwortmoeglichkeiten[2] = datensaetze[datenIndex++];
				// Der richtigen Antwort den entsprechenden Wert zuweisen und datenIndex inkrementieren
                richtigeAntwort = datensaetze[datenIndex++].charAt(0);
                // Einen bestimmten Konstruktor von Quizfrage aufrufen und Quizfrage im entsprechenden Index des Quizfrage-Arrays speichern
            	this.quizfragen[i] = new Quizfrage(frage, antwortmoeglichkeiten[0], antwortmoeglichkeiten[1], antwortmoeglichkeiten[2], richtigeAntwort);
            }
        }
        
        // -------------> Code NUR zum Testen
        /*
        for(int i = 0; i < anzahlQuizfragen; i++) {
        	System.out.println(quizfragen[i].getFrage());
            for(int k = 0; k < quizfragen[i].getAntwortmoeglichkeiten().length; k++) {
            	System.out.println(quizfragen[i].getAntwortmoeglichkeiten()[k]);
            }
            System.out.println(quizfragen[i].getRichtigeAntwort());
        }
        */
    }


    /**<br>
     * Funktion zum Beantworten der zu einem gegebenen Index im Fragenpool gespeicherten Frage<br>
     * @param zufallsZahl - gegebener Index<br>
     * @return true, wenn die Frage richtig beantwortet wird - false, sonst<br>
     <br>*/
    public boolean quizfrageRichtigBeantwortet(int zufallsZahl) {
        // Quizfrage darstellen, Funktion in GUI aufrufen und Rückgabeparameter als char-Variable speichern
        char ausgewaehlteAntwort = GUI.quizDarstellen(quizfragen[zufallsZahl].getFrage(), quizfragen[zufallsZahl].getAntwortmoeglichkeiten());
        
        // Bedingung prüft, ob die ausgewählte Antwort richtig ist
        if(ausgewaehlteAntwort == quizfragen[zufallsZahl].getRichtigeAntwort())
        	return true;
        return false;
    }


} // Ende von Quizfragenpool