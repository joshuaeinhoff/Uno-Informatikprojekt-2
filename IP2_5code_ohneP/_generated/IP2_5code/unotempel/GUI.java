package unotempel;

import unotempel.grafikkonsole.*;

/**<br>
 * Vielleicht ist es sinnvoll eine Klasse zu erstellen die allgemeine Dinge anzeigt wie zum Beispiel Lebensenergie<br>
 * in welchem Tempel man sich befindet <br>
 * Hier k&ouml;nnte man vllt auch den UnoKnopf einbauen k.p. ist nur so eine Idee<br>
 <br>*/
public class GUI {
    //code...
    
    // Auswahl Menü erzeugen
    public static void grafischAuswahlMenueErzeugen() {
    	grafischMenueOOP1Erzeugen();
        grafischMenueOOP2Erzeugen();
        grafischButtonErzeugen();
    }
    
    // Auswahl Menü: Darstellung von OOP1 erzeugen
    public static void grafischMenueOOP1Erzeugen() {
    	Rechteck rechteckOOP1 = new Rechteck(50, 50, 200, 100, Grafik.GREEN, Grafik.BLACK, 2, 20, "oop1");
    	Text textOOP1 = new Text(40+50, 2+50, "OOP1", Grafik.BLACK, 50, "oop1");
    }
    
    // Auswahl Menü: Darstellung von OOP2 erzeugen
    public static void grafischMenueOOP2Erzeugen() { 
        Rechteck rechteckOOP2 = new Rechteck(300, 50, 200, 100, Grafik.BLUE, Grafik.BLACK, 2, 20, "oop2");
    	Text textOOP2 = new Text(40+300, 2+50, "OOP2", Grafik.BLACK, 50, "oop2");
    }
    
    // Auswahl Menü: Auswahl OOP1
    public static void grafischMenueOOP1Auswaehlen() {
    	Rechteck rechteckOOP1 = new Rechteck(50, 50, 200, 100, Grafik.GREEN, Grafik.YELLOW, 3, 20, "oop1");
        Text textOOP1 = new Text(40+50, 2+50, "OOP1", Grafik.YELLOW, 50, "oop1");
    }
    
    // Auswahl Menü: Auswahl OOP2
    public static void grafischMenueOOP2Auswaehlen() {
    	Rechteck rechteckOOP2 = new Rechteck(300, 50, 200, 100, Grafik.BLUE, Grafik.YELLOW, 3, 20, "oop2");
    	Text textOOP2 = new Text(40+300, 2+50, "OOP2", Grafik.YELLOW, 50, "oop2");
    }
    
    // Auswahl Menü: Darstellung von Button erzeugen
    public static void grafischButtonErzeugen() {
    	Button but = new Button(230, 200, 100, 70, Grafik.GREY, "OK", Grafik.WHITE, 30, 5, "");
    }
    
    // Auswahl Menü: Darstellung von Button zeigen
    public static void grafischButtonZeigen() {
    	Button but = new Button(230, 200, 100, 70, Grafik.BLACK, "OK", Grafik.WHITE, 30, 5, "auswaehlen");
    }
    
    // Auswahl Menü: Button klicken
    public static void grafischButtonKlicken() {
    	Button but = new Button(230, 200, 100, 70, Grafik.YELLOW, "OK", Grafik.BLACK, 30, 5, "auswaehlen");
    }
    
/*
    // Grafische Darstellung vom Auswahl-Menü für das Spielniveau
    public static int grafischMenueAuswaehlen() {
    	String spielNiveau = "";
        while(Konsole.eingabeString().compareTo("auswaehlen") != 0) {
        
        	spielNiveau = Konsole.eingabeString();
        
            if(spielNiveau.compareTo("oop1") == 0) {
                grafischMenueOOP1Auswaehlen();       
                grafischMenueOOP2Erzeugen();
                grafischButtonZeigen();
            } 
            if(spielNiveau.compareTo("oop2") == 0) {
				grafischMenueOOP2Auswaehlen();       
                grafischMenueOOP1Erzeugen();
                grafischButtonZeigen();   
            } 
        }
        grafischButtonKlicken();
        return Character.getNumericValue(spielNiveau.charAt(3));
    }
*/
    // Darstellung einer Quizfrage: Hier oder lieber in der Klasse Quizfrage?
    public static void quizDarstellen(String frage, String[] antwortmoeglichkeiten, char richtigeAntwort) {

        // Grafik-Konsole einmal initialisieren
        GrafikKonsole.clearGrafik();

        String tempelBegruessungsText = "Solltest du den Tempel betreten möchten, musst du deine Weisheit zeigen, indem du ein Rätsel löst.";
        Rechteck grafikRechteckTempelEinfuehrung = new Rechteck(10, 10, 990, 50, Grafik.WHITE, Grafik.BLACK, 1, "2");
        Text grafikTextTempelEinfuehrung = new Text(20, 20, tempelBegruessungsText +"", Grafik.BLACK, 15, "1");

        Rechteck grafikRechteckFrage = new Rechteck(10, 70, 990, 80, Grafik.CYAN, Grafik.BLACK, 1, "2");
        Text grafikTextFrage = new Text(20, 80, frage +"", Grafik.BLACK, 20, "1");

        if(antwortmoeglichkeiten[2].compareTo("") == 0) {

            Rechteck grafikRechteckAnt1 = new Rechteck(10, 160, 490, 80, Grafik.WHITE, Grafik.BLACK, 1, "2");
            Text grafikTextAnt1 = new Text(20, 170, antwortmoeglichkeiten[0] +"", Grafik.BLACK, 18, "1");

            Rechteck grafikRechteckAnt2 = new Rechteck(510, 160, 490, 80, Grafik.WHITE, Grafik.BLACK, 1, "4");
            Text grafikTextAnt2 = new Text(520, 170, antwortmoeglichkeiten[1] +"", Grafik.BLACK, 18, "1");



        } else {

            Rechteck grafikRechteckAnt1 = new Rechteck(10, 160, 320, 80, Grafik.WHITE, Grafik.BLACK, 1, "2");
            Text grafikTextAnt1 = new Text(20, 170, antwortmoeglichkeiten[0] +"", Grafik.BLACK, 18, "1");

            Rechteck grafikRechteckAnt2 = new Rechteck(345, 160, 320, 80, Grafik.WHITE, Grafik.BLACK, 1, "2");
            Text grafikTextAnt2 = new Text(355, 170, antwortmoeglichkeiten[1] +"", Grafik.BLACK, 18, "1");

            Rechteck grafikRechteckAnt3 = new Rechteck(680, 160, 320, 80, Grafik.WHITE, Grafik.BLACK, 1, "2");
            Text grafikTextAnt3 = new Text(690, 170, antwortmoeglichkeiten[2] +"", Grafik.BLACK, 18, "1");

        }

        // if geklickte Antwort == richtigeAntwort...



    }

    /**<br>
     * Die vier Farben zur Auswahl werden angezeigt: Blau, gelb, gr&uuml;n, rot<br>
     <br>*/
    public static String farbeAuswaehlen() {
        // Farbe auswählen
        Rechteck rechteckBlau = new Rechteck(10, 10, 50, 50, Grafik.BLUE, Grafik.BLACK, 1, "blauWählen");
        Rechteck rechteckGelb = new Rechteck(60, 10, 50, 50, Grafik.YELLOW, Grafik.BLACK, 1, "gelbWählen");
        Rechteck rechteckGruen = new Rechteck(10, 60, 50, 50, Grafik.GREEN, Grafik.BLACK, 1, "grünWählen");
        Rechteck rechteckRot = new Rechteck(60, 60, 50, 50, Grafik.RED, Grafik.BLACK, 1, "rotWählen");
        // Reaktion
        //return Konsole.eingabeString();
        return "";

    }


    /**<br>
     * <br>
     * @return<br>
     <br>*/
    public static String unoKlicken() {
        //Button unoButton = new Button(..., "uno");
        return "";
    }

} // Ende von GUI