

import java.io.*;

/**
 * Klasse zum Lesen von einzelnen Zeichen.
 */
public class FilterReaderZeichen extends FilterReader {

    /**
     * Konstruktor von FilterReader vererbt
     * @param in - Variable vom Typ Reader
     */
    protected FilterReaderZeichen(Reader in) {
        super(in);
    }

    /**
     * Überschriebene Funktion liest einzelne Zeichen aus einer Datei
     * @return c - Zeichen, falls nicht End of Stream
     * @throws IOException - Exception wird geworfen
     */
    public int read() throws IOException {
        // try-Block - Es wird versucht, einzelne Zeichen aus einer Datei zu lesen
        try {
            // Ein Zeichen vom Vorgänger im Datenstrom lesen
            int i = in.read();
            char c = (char) i;
            // Wenn nicht -1 (EOS), d.h. End of Stream wird nicht erreicht
            if(i != -1)
                // Zeichen zurückgeben
                return c;
            else
                // -1 zurückgeben
                return -1;
        // catch-Block - IOException wird auf der Konsole angemeldet und weiter geworfen
        } catch (IOException ioe) {
            System.err.println("Stream-Fehler in der Klasse FilterReaderZeichen: " + ioe.getMessage());
            throw ioe;
        }
    }
    
} // Ende von FilterReaderZeichen