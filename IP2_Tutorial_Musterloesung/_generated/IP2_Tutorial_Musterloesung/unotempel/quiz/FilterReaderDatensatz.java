package unotempel.quiz;

import java.io.*;

/**<br>
 * Klasse zum Lesen von durch Semikolon getrennten Datens&auml;tzen.<br>
 <br>*/
public class FilterReaderDatensatz extends FilterReader {

    /** 2.1 Konstruktor erstellen <br>
     * Konstruktor von FilterReader vererbt<br>
     * @param in - Variable vom Typ Reader<br>
     <br>*/
    protected FilterReaderDatensatz(Reader in) {
        super(in);
    }

    
    /** 2.2 Instanz-Methode <br>
     * &Uuml;berschriebene Funktion liest Datens&auml;tze aus einer Datei und speichert sie im Puffer<br>
     * @param buf - Buffer<br>
     * @param off - AnfangIndex im Buffer<br>
     * @param len - Anzahl der gelesenen Zeichen im Buffer<br>
     * @return - Anzahl der gelesenen Zeichen<br>
     * @throws IOException - Exception wird geworfen<br>
     <br>*/
    public int read (char[] buf, int off, int len) throws IOException {
        // try-Block - Es wird versucht, Datensätze aus einer Datei zu lesen und im Puffer zu speichern
        try {
            // Bedingungen prüfen: Länge mind. 1 und ausreichend Platz im Puffer
            if(len > 0 && off+len <= buf.length ) {
                // Zeichen lesen
                int n = in.read();
                // Solange Semikolon oder eine neue Zeile gelesen wird, wird das nächste Zeichen gelesen
                while(n == ';' || n == '\n') {
                    n = in.read();
                }
                // Wenn -1 (= EOS) gelesen wird, wird an Aufrufer zurückgegeben
                if (n == -1)
                    return -1;
                // Variable als Index einsetzen
                int index = off;
                // Solange es noch Zeichen (außer Semikolon) in der Zeile gibt
                while(n != ';' && n != '\n' && n != -1) {
                    // Bedingung prüfen: Index darf nicht die Länge überschreiten
                    if(index <= off+len) {
                        // Zeichen wird im Buffer gespeichert
                        buf[index] = (char)n;
                        // Index wird inkrementiert
                        index++;
                    }
                    // Nächstes Zeichen wird gelesen
                    n = in.read();
                }
                // Anzahl der gelesenen Zeichen zurückgeben
                return (index - off);
            }
        // catch-Block - IOException wird auf der Konsole angemeldet und weiter geworfen
        } catch (IOException ioe) {
            System.err.println("Stream-Fehler in der Klasse FilterReaderDatensatz: " + ioe.getMessage());
            throw ioe;
        }
        // Falls End of Stream -1 zurückgeben
        return -1;
    }

	
} // Ende von FilterReaderDatensatz