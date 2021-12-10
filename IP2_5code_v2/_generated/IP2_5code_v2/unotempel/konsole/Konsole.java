package unotempel.konsole;

/** Klasse, um einfach Eingaben von der Konsole zu holen <br>
* @author Dahm, Markus<br>
<br>*/
public class Konsole {

    /** String Eingabe von der Tastatur holen <br>
     * L&auml;sst die Konsole blinken als Eingabeaufforderung<br>
     * Wartet bis Return gedr&uuml;ckt wird und <br>
     * gibt dann den in der Konsole eingegebenen String zur&uuml;ck.<br>
     * @author Dahm, Markus<br>
     * @return Der eingegebene String.<br>
     <br>*/
    public static String eingabeStringBlink() {
        System.out.println("Console;;blink");
        String input = "";
        try { input = bufferedReader.readLine();
            } catch (Exception e) { }
        return input;
    }

    /** Zahl als Eingabe von der Tastatur holen <br>
     * L&auml;sst die Konsole blinken als Eingabeaufforderung<br>
     * Wartet bis Return gedr&uuml;ckt wird und <br>
     * gibt dann die in der Konsole eingegebene Zahl zur&uuml;ck.<br>
     * oder -1, wenn es keine g&uuml;ltige int-Zahl war.<br>
     * @author Dahm, Markus<br>
     * @return die eingegebene Zahl.<br>
     <br>*/
    public static int eingabeZahlBlink() {
        String input = "-1";
        int zahl = -1;
        System.out.println("Console;;blink");
        try { input = bufferedReader.readLine();
        	   zahl = Integer.parseInt(input); 
        } catch (Exception e) { }
		return zahl;
    }

    /** String Eingabe von der Tastatur holen <br>
     * Wartet bis Return gedr&uuml;ckt wird und <br>
     * gibt dann den in der Konsole eingegebenen String zur&uuml;ck.<br>
     * @author Dahm, Markus<br>
     * @return Der eingegebene String.<br>
     <br>*/
    public static String eingabeString() {
        String input = "";
        try { input = bufferedReader.readLine();
            } catch (Exception e) { }
        return input;
    }

    /** Zahl als Eingabe von der Tastatur holen <br>
     * Wartet bis Return gedr&uuml;ckt wird und <br>
     * gibt dann die in der Konsole eingegebene Zahl zur&uuml;ck.<br>
     * oder -1, wenn es keine g&uuml;ltige int-Zahl war.<br>
     * @author Dahm, Markus<br>
     * @return die eingegebene Zahl.<br>
     <br>*/
    public static int eingabeZahl() {
        String input = "-1";
        int zahl = -1;
        try { input = bufferedReader.readLine();
        	   zahl = Integer.parseInt(input); 
        } catch (Exception e) { }
		return zahl;
    }

    /** Vorgegebene Variable f&uuml;r die Eingabe, <strong>nicht &auml;ndern!</strong> <br>*/
    static java.io.BufferedReader bufferedReader = 
	      new java.io.BufferedReader(new java.io.InputStreamReader(System.in));


    /** Haupt-Prozedur zum testen, <br>
       wird beim Programmstart aufgerufen, nicht aber in .jar-Datei<br>
    <br>*/
	/*
    public static void main(String[] args) { 
       
       String s = Konsole.eingabeStringBlink();
	   System.out.println("s = " + s);
            
       //int z = Konsole.eingabeZahl();
	   //System.out.println("z = " + z);
    }
	*/
   
}
