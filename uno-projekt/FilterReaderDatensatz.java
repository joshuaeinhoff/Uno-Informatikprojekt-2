import java.io.*;

/**
 * Klasse zum Lesen einzelner Zeilen
 */
public class FilterReaderDatensatz extends FilterReader {

    /**
     * @param in
     */
    protected FilterReaderDatensatz(Reader in) {
        super(in);
    }

    /**
     * Funktion liest Zeilen aus einer Datei und speichert sie im Puffer
     * @param buf
     * @param off
     * @param len
     * @return - Anzahl der gelesenen Zeichen
     * @throws IOException
     */
    public int read (char buf[], int off, int len) throws IOException {
        // try-Block
        try {
            // Bedingungen pruefen: Laenge mind. 1 und ausreichend Platz im Puffer
            if(len > 0 && off+len <= buf.length ) {
                // Zeichen lesen
                int n = in.read();
                // Solange es keine neue Zeile gibt, wird das naechste Zeichen gelesen
                while(n == '\n') {
                    n = in.read();
                }
                // Wenn -1 (= EOS) gelesen wird, wird an Aufrufer zurückgegeben
                if (n == -1)
                    return -1;
                // Variable als Index einsetzen
                int index = off;
                // Solange es noch Zeichen in der Zeile gibt
                while(n != '\n' && n != -1) {
                    // Bedingung pruefen: Index darf nicht die Laenge ueberschreiten
                    if(index <= off+len) {
                        // Zeichen wird im Buffer gespeichert
                        buf[index] = (char)n;
                        // Index wird inkrementiert
                        index++;
                    }
                    // Naechstes Zeichen wird gelesen
                    n = in.read();
                }
                // Anzahl der gelesenen Zeichen wird zurueckgegeben
                return (index - off);
            }
        // catch-Block
        } catch (IOException ioe) {
            System.err.println("Stream-Fehler in der Klasse FilterReaderDatensatz: " + ioe.getMessage());
            throw ioe;
        }
        return -1;
    }

}
