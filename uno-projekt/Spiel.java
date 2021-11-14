/**
 *  Klasse Spiel 
 */
class Spiel {
    
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

        // Quizfragen zu OOP2 vom Tempel 1 manuell erzeugen
        int index_t1_oop2 = 0;
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



        // Pruefen, dass die Daten richtig gespeichert wurden
        /*
        for(Quizfrage qf : wasserTempel.getFragenpoolOOP2()) {
            System.out.println("Frage: " + qf.getFrage());
            for(String antwort : qf.getAntwortsmoeglichkeiten()) {
                System.out.println("Antwort: " + antwort);
            }
            System.out.println("Richtige Antwort: " + qf.getRichtigeAntwort());
        }

         */



        /* Spielablauf */

        Spieler held = new Held();
        wasserTempel.betreten(held, niveau);
    }
	
}