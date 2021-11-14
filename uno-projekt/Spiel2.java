import java.io.*;
import java.util.*;
/**
 *
 */
public class Spiel2 {

    public static void main(String[] args) {

        /* Spielvorbereitung */

        System.out.println("Wählen Sie bitte OOP1 oder OOP2"); // weiter...
        int niveau = 1;
        // if OOP2 ausgewählt -> niveau = 2

        // Tempel erzeugen
        Tempel2 wasserTempel = new Tempel2("blau");
        Tempel2 luftTempel = new Tempel2("gelb");
        Tempel2 erdeTempel = new Tempel2("gruen");
        Tempel2 feuerTempel = new Tempel2("rot");


        /* Tempel 1: Wasser-Tempel */

        // Quizfragen zu OOP2 vom Tempel 1 lesen
        try {

            // Variablen zum Lesen erzeugen
            int off = 0;
            int len = 300;
            int num = 0;
            String datensatz;
            int fragenZaehler = 0;

            /* Tempel 1: Wasser-Tempel */

            FilterReader fr_t1_oop2 = new FilterReaderDatensatz(
                                      new FilterReaderZeichen(
                                      new BufferedReader(
                                      new FileReader("./quizfragen/fragen_t1_oop2.txt"))));


            // Buffer zum Lesen erzeugen
            char[] buf = new char[len + off];
            // Solange Ende des Streams nicht erreicht
            while (num != -1) {
                // Zeichen lesen
                num = fr_t1_oop2.read(buf, off, len);
                // Nicht Ende des Streams
                if (num != -1) {
                    datensatz = new String(buf, off, num);
                    Quizfrage quizfrage = new Quizfrage(datensatz);
                    wasserTempel.getFragenpoolOOP2().put(++fragenZaehler, quizfrage);
                }
            }


            // Pruefen, dass die Daten richtig gespeichert wurden
            /*
            for(Map.Entry<Integer,Quizfrage> entry : wasserTempel.getFragenpoolOOP2().entrySet()) {
                System.out.print(entry.getKey() + ": ");
                System.out.println(entry.getValue().getFrage());
                for(String antwort : entry.getValue().getAntwortsmoeglichkeiten()) {
                    System.out.println("Antwort: " + antwort);
                }
                System.out.println("Richtige Antwort: " + entry.getValue().getRichtigeAntwort());
            }
             */





            /* Spielablauf */

            Spieler held = new Held();
            wasserTempel.betreten(held, niveau);






        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }
}
