/**
 *  Klasse Spiel -> besser benennen 
 */
class Spiel {
    
    /**
     * main
     * @param args
     */
    public static void main(String[] args){

        /* Spielkonzept */

        System.out.println("Wählen Sie bitte OOP1 oder OOP2"); // weiter...
        int niveau = 1;
        // if OOP2 ausgewählt -> niveau = 2

        // Tempel erzeugen
        Tempel wasserTempel = new Tempel("blau");
        Tempel luftTempel = new Tempel("gelb");
        Tempel erdeTempel = new Tempel("gruen");
        Tempel feuerTempel = new Tempel("rot");

        // Fragen erzeugen oder aus einer Datei lesen
        Quizfrage qf1_oop1_t1 = new Quizfrage(0, "Welcher dieser Datentypen ist nicht primitiv?", "String", "int", "boolean");

        // Fragen in Pool
        for(int i=0; i<5;i++) {
            if(niveau == 1)
                wasserTempel.getFragenpoolOOP1().put(i, qf1_oop1_t1);
            else
                wasserTempel.getFragenpoolOOP2().put(i, qf1_oop1_t1);
        }



        /* Spielablauf */

        Spieler held = new Held();
        wasserTempel.betreten(held, niveau);
    }
	
}