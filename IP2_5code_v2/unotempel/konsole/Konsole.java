package unotempel.konsole;

/** Klasse, um einfach Eingaben von der Konsole zu holen 
* @author Dahm, Markus
*/
public class Konsole {

    /** String Eingabe von der Tastatur holen 
     * Lässt die Konsole blinken als Eingabeaufforderung
     * Wartet bis Return gedrückt wird und 
     * gibt dann den in der Konsole eingegebenen String zurück.
     * @author Dahm, Markus
     * @return Der eingegebene String.
     */
    public static String eingabeStringBlink() {
        System.out.println("Console;;blink");
        String input = "";
        try { input = bufferedReader.readLine();
            } catch (Exception e) { }
        return input;
    }

    /** Zahl als Eingabe von der Tastatur holen 
     * Lässt die Konsole blinken als Eingabeaufforderung
     * Wartet bis Return gedrückt wird und 
     * gibt dann die in der Konsole eingegebene Zahl zurück.
     * oder -1, wenn es keine gültige int-Zahl war.
     * @author Dahm, Markus
     * @return die eingegebene Zahl.
     */
    public static int eingabeZahlBlink() {
        String input = "-1";
        int zahl = -1;
        System.out.println("Console;;blink");
        try { input = bufferedReader.readLine();
        	   zahl = Integer.parseInt(input); 
        } catch (Exception e) { }
		return zahl;
    }

    /** String Eingabe von der Tastatur holen 
     * Wartet bis Return gedrückt wird und 
     * gibt dann den in der Konsole eingegebenen String zurück.
     * @author Dahm, Markus
     * @return Der eingegebene String.
     */
    public static String eingabeString() {
        String input = "";
        try { input = bufferedReader.readLine();
            } catch (Exception e) { }
        return input;
    }

    /** Zahl als Eingabe von der Tastatur holen 
     * Wartet bis Return gedrückt wird und 
     * gibt dann die in der Konsole eingegebene Zahl zurück.
     * oder -1, wenn es keine gültige int-Zahl war.
     * @author Dahm, Markus
     * @return die eingegebene Zahl.
     */
    public static int eingabeZahl() {
        String input = "-1";
        int zahl = -1;
        try { input = bufferedReader.readLine();
        	   zahl = Integer.parseInt(input); 
        } catch (Exception e) { }
		return zahl;
    }

    /** Vorgegebene Variable für die Eingabe, **nicht ändern!** */
    static java.io.BufferedReader bufferedReader = 
	      new java.io.BufferedReader(new java.io.InputStreamReader(System.in));


    /** Haupt-Prozedur zum testen, 
       wird beim Programmstart aufgerufen, nicht aber in .jar-Datei
    */
	/*
    public static void main(String[] args) { 
       
       String s = Konsole.eingabeStringBlink();
	   System.out.println("s = " + s);
            
       //int z = Konsole.eingabeZahl();
	   //System.out.println("z = " + z);
    }
	*/
   
}
