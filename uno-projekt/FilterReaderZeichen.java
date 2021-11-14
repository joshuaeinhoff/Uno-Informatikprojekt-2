import java.io.*;

/**
 * Klasse zum Lesen vom einzelnen Zeichen
 */
public class FilterReaderZeichen extends FilterReader {

    /**
     * @param in
     */
    protected FilterReaderZeichen(Reader in) {
        super(in);
    }

    /**
     * Funktion liest einzelne Zeichen aus einer Datei
     * @return c - Zeichen, falls nicht End of Stream
     * @throws IOException
     */
    public int read() throws IOException {
        // try-Block
        try {
            // Ein Zeichen vom Vorgaenger im Datenstrom lesen
            int i = in.read();
            char c = (char) i;
            // Wenn nicht -1 (EOS), wird das Zeichen zurückgegeben
            if(i != -1)
                return c;
            else
                return -1;
        // catch-Block
        } catch (IOException ioe) {
            System.err.println("Stream-Fehler in der Klasse FilterReaderZeichen: " + ioe.getMessage());
            throw ioe;
        }
    }
    
}
