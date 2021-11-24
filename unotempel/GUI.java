package unotempel;

/**
 * Vielleicht ist es sinnvoll eine Klasse zu erstellen die allgemeine Dinge anzeigt wie zum Beispiel Lebensenergie
 * in welchem Tempel man sich befindet 
 * Hier könnte man vllt auch den UnoKnopf einbauen k.p. ist nur so eine Idee
 */
public class GUI {
    //code...


    // Darstellung einer Quizfrage: Hier oder lieber in der Klasse Quizfrage?
    public static void quizDarstellen(String frage, String[] antwortmoeglichkeiten, char richtigeAntwort) {

        // Grafik-Konsole einmal initialisieren
        GrafikKonsole.clearGrafik();

        String tempelBegruessungsText = "Solltest du den Tempel betreten möchten, musst du deine Weisheit zeigen, indem du ein Rätsel löst.";
        Rechteck grafikRechteckTempelEinfuehrung = new Rechteck(10, 10, 990, 50, Grafik.WHITE, Grafik.BLACK, 1, "2");
        Text grafikTextTempelEinfuehrung = new Text(20, 20, tempelBegruessungsText +"", Grafik.BLACK, 15, "1");

        Rechteck grafikRechteckFrage = new Rechteck(10, 70, 990, 80, Grafik.CYAN, Grafik.BLACK, 1, "2");
        Text grafikTextFrage = new Text(20, 80, frage +"", Grafik.BLACK, 20, "1");

        if(ant3.compareTo("") == 0) {

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

    /**
     * Die vier Farben zur Auswahl werden angezeigt: Blau, gelb, grün, rot
     */
    public static String farbeAuswaehlen() {
        // Farbe auswählen
        Rechteck rechteckBlau = new Rechteck(10, 10, 50, 50, Grafik.BLUE, Grafik.BLACK, 1, "blauWählen");
        Rechteck rechteckGelb = new Rechteck(60, 10, 50, 50, Grafik.YELLOW, Grafik.BLACK, 1, "gelbWählen");
        Rechteck rechteckGruen = new Rechteck(10, 60, 50, 50, Grafik.GREEN, Grafik.BLACK, 1, "grünWählen");
        Rechteck rechteckRot = new Rechteck(60, 60, 50, 50, Grafik.RED, Grafik.BLACK, 1, "rotWählen");
        // Reaktion
        return Konsole.eingabeString();

    }


}//end of GUI
