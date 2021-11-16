/**
 *
 */
public class Quizfrage {

    // Eigenschaften
    private String frage;
    private String[] antwortsmoeglichkeiten;
    private char richtigeAntwort;

    public String getFrage() {
        return frage;
    }

    public String[] getAntwortsmoeglichkeiten() {
        return antwortsmoeglichkeiten;
    }

    public char getRichtigeAntwort() {
        return richtigeAntwort;
    }

    
    /**
     * Konstruktor 1
     * @param frage
     * @param antwort1
     * @param antwort2
     * @param antwort3
     * @param richtigeAntwort
     */
    public Quizfrage(String frage, String antwort1, String antwort2, String antwort3, char richtigeAntwort) {
        this.frage = frage;
        this.antwortsmoeglichkeiten = new String[] { antwort1, antwort2, antwort3 };
        this.richtigeAntwort = richtigeAntwort;
    }

    /**
     * Konstruktor 2
     * @param datensatz
     */
    public Quizfrage(String datensatz) {
        // Datensatz nach Semikolon teilen
        String[] strings = datensatz.split(";");
        frage = strings[0];
        antwortsmoeglichkeiten = new String[]{ strings[1], strings[2], strings[3] };
        richtigeAntwort = strings[4].charAt(0);
    }

    public static void wasserTempelOOP1Fragen(Tempel wasserTempel){
        Quizfrage qf1_t1_oop1 = new Quizfrage("Was ist der Default-Datentyp für ganze Zahlenwerte?", "a) int", "b) short", "c) byte", 'a');
        Quizfrage qf2_t1_oop1 = new Quizfrage("Was gibt die EXCLUSIV-ODER-Operation aus, wenn beide Operanden true sind?", "a) true", "b) false", "",'b');
        Quizfrage qf3_t1_oop1 = new Quizfrage("Welche Datentypen passen zueinander?", "a) Zahlen und Wahrheitswerte", "b) Alle Datentypen, bei denen der Wertebereich passt", "c) Alle Zahlen-Datentypen", 'b');
        Quizfrage qf4_t1_oop1 = new Quizfrage("Variablennamen...", "a) beginnen immer mit Kleinbuchstaben", "b) sind reservierte Wörter", "c) beginnen mit einer Ziffer", 'a');
        Quizfrage qf5_t1_oop1 = new Quizfrage("Worauf bezieht sich eine Referenz im Speicher?", "a) eine Operation", "b) eine Adresse", "c) eine Zeichenkette", 'b');

        wasserTempel.setFragenpoolOOP1(new Quizfrage[]{ qf1_t1_oop1, qf2_t1_oop1, qf3_t1_oop1, qf4_t1_oop1, qf5_t1_oop1 });
    }

    public static void wasserTempelOOP2Fragen(Tempel wasserTempel){
        Quizfrage qf1_t1_oop2 = new Quizfrage("In einer Liste stehen miteinander verkettete…", "a) Nutzlasten", "b) Knoten", "c) abstrakte Datentypen", 'b');
        Quizfrage qf2_t1_oop2 = new Quizfrage("Wie viele Elemente umfasst die Suche in einer Liste der Länge n?", "a) n", "b) n/2", "c) log(n)", 'c');
        Quizfrage qf3_t1_oop2 = new Quizfrage("Welchen Sichtbarzeitbegriff muss die Klasse Knoten beinhalten?", "a) public", "b) protected", "c) private", 'c');
        Quizfrage qf4_t1_oop2 = new Quizfrage("Wie kann eine Liste in beide Richtungen iteriert werden?", "a) Mit einem ListIterator", "b) Mit zwei Instanzen von Iterator", "c) Das ist nicht möglich", 'a');
        Quizfrage qf5_t1_oop2 = new Quizfrage("Wird es über die einzelnen Nutzlasten einer Liste iteriert?", "a) Nein", "b) Ja", "", 'a');
        Quizfrage qf6_t1_oop2 = new Quizfrage("Welcher Aufruf gibt die nächste Nutzlast zurück?", "a) hasNext()", "b) next()", "c) next.next()", 'b');
        Quizfrage qf7_t1_oop2 = new Quizfrage("Wie viele Nachfolger kann ein Knoten in einem Binärbaum haben?", "a) Zwei", "b) Keine", "c) a und b sind richtig", 'c');
        Quizfrage qf8_t1_oop2 = new Quizfrage("Besitzen die Knoten eine Referenz zum Elternelement?", "a) Ja", "b) Nein", "", 'b');

        // Quizfragen zu OOP2 vom Tempel 1 in Fragenpool vom Tempel 1 speichern
        wasserTempel.setFragenpoolOOP2(new Quizfrage[]{ qf1_t1_oop2, qf2_t1_oop2, qf3_t1_oop2, qf4_t1_oop2, qf5_t1_oop2, qf6_t1_oop2, qf7_t1_oop2, qf8_t1_oop2 });
    }

    public static void luftTempelOOP1Fragen(Tempel luftTempel){

        Quizfrage qf1_t2_oop1 = new Quizfrage("Was für eine Art Schleife ist die while-Schleife?", "a) eine fußgesteuerte-Schleife", "b) eine kopfgesteuerte-Schleife","",'b');
        Quizfrage qf2_t2_oop1 = new Quizfrage("Aus welchen steuernden Elementen besteht eine for-Schleife?", "a) Definition, Abbruch-Bedingung, Weitermach-Bedingung", "b) Initialisierung, Abbruch-Bedingung, Weitermach-Bedingung", "c) Initialisierung, Weitermach-Bedingung, Weitermach-Anweisung", 'c');
        Quizfrage qf3_t2_oop1 = new Quizfrage("Was sind Arrays?", "a) primitive Datentypen", "b) Referenz-Datentypen", "c) Zeichenketten", 'b');
        Quizfrage qf4_t2_oop1 = new Quizfrage("Was benutzt man, wenn man aus einem Array etwas lesen möchte?", "a) do-while-Schleife", "b) eine if-Anweisung", "c) for-each-Schleife", 'c');
        Quizfrage qf5_t2_oop1 = new Quizfrage("Welchen Datentypen besitzt eine Prozedur?", "a) void", "b) String", "c) float", 'a');

        luftTempel.setFragenpoolOOP1(new Quizfrage[]{ qf1_t2_oop1, qf2_t2_oop1, qf3_t2_oop1, qf4_t2_oop1, qf5_t2_oop1 });

    }

    public static void luftTempelOOP2Fragen(Tempel luftTempel){
        Quizfrage qf1_t2_oop2 = new Quizfrage("Wie werden die Knoten beim Traversieren im Post-Order betrachtet?","a) Links – Wurzel – Rechts","b) Links – Rechts – Wurzel","c) Wurzel – Links – Rechts",'b');
        Quizfrage qf2_t2_oop2 = new Quizfrage("Welche Klasse muss die Methode compareTo() implementieren","a) GenCompBaum-Klasse","b) Knoten-Klasse","c) Nutzlast-Klasse",'c');
        Quizfrage qf3_t2_oop2 = new Quizfrage("Wie viele Fälle muss man beim Löschen eines Knotens aus dem Binärbaum beachten?","a) Drei","b) Zweieinhalb","c) Zwei",'a');
        Quizfrage qf4_t2_oop2 = new Quizfrage("Wie wird der Speicher von nicht mehr verwendeten Objekten in Java freigegeben?","a) Manuell","b) Durch eine Garbage Collector","",'b');
        Quizfrage qf5_t2_oop2 = new Quizfrage("Ein Upper Typebound lässt sich mit … definieren.","a) implements","b) extends","c) type",'b');
        Quizfrage qf6_t2_oop2 = new Quizfrage("Welcher der folgenden Typen ist nicht iterierbar?","a) Set","b) Map","c) List",'b');
        Quizfrage qf7_t2_oop2 = new Quizfrage("Wie lassen sich mehrere formale Typ-Parameter anführen?","a) Durch Komma separiert","b) Durch & separiert","c) Durch den <>-Operator",'a');
        Quizfrage qf8_t2_oop2 = new Quizfrage("Wie lassen sich mehrere formale Upper Typebounds anführen?","a) Durch Komma separiert","b) Durch & separiert","c) Durch den <>-Operator",'b');

        luftTempel.setFragenpoolOOP2(new Quizfrage[]{ qf1_t2_oop2, qf2_t2_oop2, qf3_t2_oop2, qf4_t2_oop2, qf5_t2_oop2, qf6_t2_oop2, qf7_t2_oop2, qf8_t2_oop2 });

    }

    public static void erdeTempelOOP1Fragen(Tempel erdeTempel){
        // Quizfragen zu OOP1 vom Tempel 3 erzeugen
        Quizfrage qf1_t3_oop1 = new Quizfrage("Was drückt der Name einer Prozedur aus?", "a) eine Aussage", "b) einen Befehl", "c) ein Ergebnis", 'b');
        Quizfrage qf2_t3_oop1 = new Quizfrage("Welchen Datentypen besitzt eine Prozedur?", "a) void", "b) String", "c) float", 'a');
        Quizfrage qf3_t3_oop1 = new Quizfrage("Was drückt eine Funktion aus?", "a) was getan wird", "b) was das Ergebnis ist","", 'b');
        Quizfrage qf4_t3_oop1 = new Quizfrage("Was ist ein Objekt?", "a) ein Refernz-Datentyp", "b) eine Instanz einer Klasse", "c) eine Einheit aus Funktionen und Prozeduren", 'b');
        Quizfrage qf5_t3_oop1 = new Quizfrage("Welche Aussage stimmt?", "a) Eine Klasse ist in sich selbst gekapselt", "b) Eine Methode ist in sich selbst gekapselt", "c) Ein Objekt ist in sich selbst gekapselt",'c');


        // Quizfragen zu OOP1 vom Tempel 3 in Fragenpool vom Tempel 3 speichern
        erdeTempel.setFragenpoolOOP1(new Quizfrage[]{ qf1_t3_oop1, qf2_t3_oop1, qf3_t3_oop1, qf4_t3_oop1, qf5_t3_oop1 });
    }

    public static void erdeTempelOOP2Fragen(Tempel erdeTempel){
         // Quizfragen zu OOP2 vom Tempel 3 erzeugen
         Quizfrage qf1_t3_oop2 = new Quizfrage("Das Löschen von Typ-Informationen für die Laufzeit in Java heißt…","a) Type inference","b) Type removal","c) Type erasure",'c');
         Quizfrage qf2_t3_oop2 = new Quizfrage("Das Symbol <?> steht für…","a) Wildcard","b) Raw type","c) Diamond-Operator",'a');
         Quizfrage qf3_t3_oop2 = new Quizfrage("Welche Exceptions müssen im Programm nicht angemeldet werden?","a) IOExceptions","b) RuntimeExceptions","c) InterruptedExceptions",'b');
         Quizfrage qf4_t3_oop2 = new Quizfrage("Wann wird der finally-Block ausgeführt?","a) Wenn Exceptions geworfen sind","b) Wenn keine Exceptions geworfen sind","c) Immer",'c');
         Quizfrage qf5_t3_oop2 = new Quizfrage("Was ist die Funktion von Filter-Klassen?","a) Daten werden aus einer Datei gelesen bzw. in eine Datei geschrieben.","b) Daten werden in einem Pufferspeicher gesammelt.","c) Daten werden in Methoden modifiziert.",'c');
         Quizfrage qf6_t3_oop2 = new Quizfrage("Was gibt der Aufruf von read(buf,off,len) zurück?","a) Die Größe des Buffers","b) Die Anzahl der gelesenen Zeichen","c) 1, 0 oder -1",'b');
         Quizfrage qf7_t3_oop2 = new Quizfrage("Wie wird ein Datenstrom geöffnet und initialisiert?","a) im Constructor","b) mit open()","c) mit read() oder write()",'a');
 
         // Quizfragen zu OOP2 vom Tempel 3 in Fragenpool vom Tempel 3 speichern
         erdeTempel.setFragenpoolOOP2(new Quizfrage[]{ qf1_t3_oop2, qf2_t3_oop2, qf3_t3_oop2, qf4_t3_oop2, qf5_t3_oop2, qf6_t3_oop2, qf7_t3_oop2 });
 
    }

    public static void feuerTempelOOP1Fragen(Tempel feuerTempel){
        // Quizfragen zu OOP1 vom Tempel 4 erzeugen
        Quizfrage qf1_t4_oop1 = new Quizfrage("Bei Vererbung...", "a) werden nur spezielle Eigenschaften der Superklasse geerbt", "b) werden immer alle Eigenschaften der Superklasse geerbt", "c) werden immer alle Eigenschaften der Subklasse geerbt", 'b');
        Quizfrage qf2_t4_oop1 = new Quizfrage("Eine (Sub)Klasse kann...", "a) von mehreren Superklassen erben", "b) von mindestens einer Superklasse erben", "c) von genau einer Superklasse erben", 'c');
        Quizfrage qf3_t4_oop1 = new Quizfrage("Eine Superklasse...", "a) kennt ihre Subklassen", "b) kennt nur die wichtigsten Subklassen", "c) kennt ihre Subklassen nicht", 'c');
        Quizfrage qf4_t4_oop1 = new Quizfrage("Welcher Access Modifier macht eine Eigenschaft sichtbar innerhalb der Klasse und in allen Subklassen?", "a) protected", "b) private", "c) public", 'a');
        Quizfrage qf5_t4_oop1 = new Quizfrage("Was versteht man unter Polymorphismus?", "a) zur Laufzeit wird immer die passende Methode gefunden und aufgerufen", "b) zur Compilezeit wird immer die passende Methode gefunden und aufgerufen","", 'a');


        // Quizfragen zu OOP1 vom Tempel 4 in Fragenpool vom Tempel 4 speichern
        feuerTempel.setFragenpoolOOP2(new Quizfrage[]{ qf1_t4_oop1, qf2_t4_oop1, qf3_t4_oop1, qf4_t4_oop1, qf5_t4_oop1 });

    }

    public static void feuerTempelOOP2Fragen(Tempel feuerTempel){

        // Quizfragen zu OOP2 vom Tempel 4 erzeugen
        Quizfrage qf1_t4_oop2 = new Quizfrage("… sind eigenständige Programme mit eigenen Ressourcen","a) Threads","b) Prozesse","",'b');
        Quizfrage qf2_t4_oop2 = new Quizfrage("Welcher Aufruf erlaubt einen Thread, nebenläufig zu laufen?","a) run()","b) open()","c) start()",'c');
        Quizfrage qf3_t4_oop2 = new Quizfrage("Welcher Aufruf wird bevorzugt, um den Zustand des Flags abzufragen?","a) interrupted()","b) isInterrupted()","c) interrupt()",'a');
        Quizfrage qf4_t4_oop2 = new Quizfrage("Wie können Code-Blöcke bzw. Methoden als nicht unterbrechbar markiert werden?","a) mit synchronize","b) mit synchronized","c) mit synchronise",'b');
        Quizfrage qf5_t4_oop2 = new Quizfrage("Welche Kategorien von Entwurfsmustern bestehen je nach Zweck?","a) Struktur-, Klassen- und Verhaltensmuster","b) Erzeugungs-, Struktur- und Verhaltensmuster","c) Objekt- und Klassenmuster",'b');
        Quizfrage qf6_t4_oop2 = new Quizfrage("Welche Kategorien von Entwurfsmustern bestehen je nach Wirkungsbereich?","a) Struktur-, Klassen- und Verhaltensmuster","b) Erzeugungs-, Struktur- und Verhaltensmuster","c) Objekt- und Klassenmuster",'c');
        Quizfrage qf7_t4_oop2 = new Quizfrage("Zu welchen Kategorien gehört ein Singleton?","a) Erzeugungs- und Objektmuster","b) Struktur- und Objektmuster","c) Verhaltens- und Klassenmuster",'a');

        // Quizfragen zu OOP2 vom Tempel 4 in Fragenpool vom Tempel 4 speichern
        feuerTempel.setFragenpoolOOP2(new Quizfrage[]{ qf1_t4_oop2, qf2_t4_oop2, qf3_t4_oop2, qf4_t4_oop2, qf5_t4_oop2, qf6_t4_oop2, qf7_t4_oop2 });
    }

}//end of Quizfrage
