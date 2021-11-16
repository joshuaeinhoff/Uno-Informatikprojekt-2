/**
 *  Klasse Spiel 
 */
public class Spiel {
    
    /**
     * main
     * @param args
     */
    public static void main(String[] args){

        /* Spielvorbereitung */

        System.out.println("Wählen Sie bitte OOP1 oder OOP2"); // weiter...
        int niveau = 1;
        // if OOP2 ausgewählt -> niveau = 2

        // Tempel erzeugen
        Tempel wasserTempel = new Tempel("blau");
        Tempel luftTempel = new Tempel("gelb");
        Tempel erdeTempel = new Tempel("gruen");
        Tempel feuerTempel = new Tempel("rot");


        /* Tempel 1: Wasser-Tempel */

        // Quizfragen zu OOP1 vom Tempel 1 erzeugen
        Quizfrage qf1_t1_oop1 = new Quizfrage("Was ist der Default-Datentyp für ganze Zahlenwerte?", "a) int", "b) short", "c) byte", 'a');
        Quizfrage qf2_t1_oop1 = new Quizfrage("Was gibt die EXCLUSIV-ODER-Operation aus, wenn beide Operanden true sind?", "a) true", "b) false", 'b');
        Quizfrage qf3_t1_oop1 = new Quizfrage("Welche Datentypen passen zueinander?", "a) Zahlen und Wahrheitswerte", "b) Alle Datentypen, bei denen der Wertebereich passt", "c) Alle Zahlen-Datentypen", 'b');
        Quizfrage qf4_t1_oop1 = new Quizfrage("Variablennamen...", "a) beginnen immer mit Kleinbuchstaben", "b) sind reservierte Wörter", "c) beginnen mit einer Ziffer", 'a');
        Quizfrage qf5_t1_oop1 = new Quizfrage("Worauf bezieht sich eine Referenz im Speicher?", "a) eine Operation", "b) eine Adresse", "c) eine Zeichenkette", 'b');

        // Quizfragen zu OOP1 vom Tempel 1 in Fragenpool vom Tempel 1 speichern
        wasserTempel.setFragenpoolOOP2(new Quizfrage[]{ qf1_t1_oop1, qf2_t1_oop1, qf3_t1_oop1, qf4_t1_oop1, qf5_t1_oop1 });

        // Quizfragen zu OOP2 vom Tempel 1 erzeugen
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


        /* Tempel 2: Luft-Tempel */

        // Quizfragen zu OOP1 vom Tempel 2 erzeugen
        Quizfrage qf1_t2_oop1 = new Quizfrage("");
        Quizfrage qf2_t2_oop1 = new Quizfrage("");
        Quizfrage qf3_t2_oop1 = new Quizfrage("");
        Quizfrage qf4_t2_oop1 = new Quizfrage("");
        Quizfrage qf5_t2_oop1 = new Quizfrage("");

        // Quizfragen zu OOP1 vom Tempel 2 in Fragenpool vom Tempel 2 speichern
        luftTempel.setFragenpoolOOP2(new Quizfrage[]{ qf1_t2_oop1, qf2_t2_oop1, qf3_t2_oop1, qf4_t2_oop1, qf5_t2_oop1 });

        // Quizfragen zu OOP2 vom Tempel 2 erzeugen
        Quizfrage qf1_t2_oop2 = new Quizfrage("Wie werden die Knoten beim Traversieren im Post-Order betrachtet?","a) Links – Wurzel – Rechts","b) Links – Rechts – Wurzel","c) Wurzel – Links – Rechts",'b');
        Quizfrage qf2_t2_oop2 = new Quizfrage("Welche Klasse muss die Methode compareTo() implementieren","a) GenCompBaum-Klasse","b) Knoten-Klasse","c) Nutzlast-Klasse",'c');
        Quizfrage qf3_t2_oop2 = new Quizfrage("Wie viele Fälle muss man beim Löschen eines Knotens aus dem Binärbaum beachten?","a) Drei","b) Zweieinhalb","c) Zwei",'a');
        Quizfrage qf4_t2_oop2 = new Quizfrage("Wie wird der Speicher von nicht mehr verwendeten Objekten in Java freigegeben?","a) Manuell","b) Durch eine Garbage Collector","",'b');
        Quizfrage qf5_t2_oop2 = new Quizfrage("Ein Upper Typebound lässt sich mit … definieren.","a) implements","b) extends","c) type",'b');
        Quizfrage qf6_t2_oop2 = new Quizfrage("Welcher der folgenden Typen ist nicht iterierbar?","a) Set","b) Map","c) List",'b');
        Quizfrage qf7_t2_oop2 = new Quizfrage("Wie lassen sich mehrere formale Typ-Parameter anführen?","a) Durch Komma separiert","b) Durch & separiert","c) Durch den <>-Operator",'a');
        Quizfrage qf8_t2_oop2 = new Quizfrage("Wie lassen sich mehrere formale Upper Typebounds anführen?","a) Durch Komma separiert","b) Durch & separiert","c) Durch den <>-Operator",'b');

        // Quizfragen zu OOP2 vom Tempel 2 in Fragenpool vom Tempel 2 speichern
        luftTempel.setFragenpoolOOP2(new Quizfrage[]{ qf1_t2_oop2, qf2_t2_oop2, qf3_t2_oop2, qf4_t2_oop2, qf5_t2_oop2, qf6_t2_oop2, qf7_t2_oop2, qf8_t2_oop2 });


        /* Tempel 3: Erde-Tempel */

        // Quizfragen zu OOP1 vom Tempel 3 erzeugen
        Quizfrage qf1_t3_oop1 = new Quizfrage("");
        Quizfrage qf2_t3_oop1 = new Quizfrage("");
        Quizfrage qf3_t3_oop1 = new Quizfrage("");
        Quizfrage qf4_t3_oop1 = new Quizfrage("");
        Quizfrage qf5_t3_oop1 = new Quizfrage("");

        // Quizfragen zu OOP1 vom Tempel 3 in Fragenpool vom Tempel 3 speichern
        erdeTempel.setFragenpoolOOP2(new Quizfrage[]{ qf1_t3_oop1, qf2_t3_oop1, qf3_t3_oop1, qf4_t3_oop1, qf5_t3_oop1 });

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

        
        /* Tempel 4: Feuer-Tempel */

        // Quizfragen zu OOP1 vom Tempel 4 erzeugen
        Quizfrage qf1_t4_oop1 = new Quizfrage("");
        Quizfrage qf2_t4_oop1 = new Quizfrage("");
        Quizfrage qf3_t4_oop1 = new Quizfrage("");
        Quizfrage qf4_t4_oop1 = new Quizfrage("");
        Quizfrage qf5_t4_oop1 = new Quizfrage("");

        // Quizfragen zu OOP1 vom Tempel 4 in Fragenpool vom Tempel 4 speichern
        feuerTempel.setFragenpoolOOP2(new Quizfrage[]{ qf1_t4_oop1, qf2_t4_oop1, qf3_t4_oop1, qf4_t4_oop1, qf5_t4_oop1 });

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



        Spieler held = new Held();


        /* Spielablauf */

        // 1. Tempel: Wasser
        wasserTempel.tempelBetreten(spielNiveau);
        // Monster bekämpfen

        // 2. Tempel
        luftTempel.tempelBetreten(spielNiveau);
        // Monster bekämpfen

        // 3. Tempel
        erdeTempel.tempelBetreten(spielNiveau);
        // Monster bekämpfen

        // 4. Tempel
        feuerTempel.tempelBetreten(spielNiveau);
        // Monster bekämpfen
        
    }
	
}
