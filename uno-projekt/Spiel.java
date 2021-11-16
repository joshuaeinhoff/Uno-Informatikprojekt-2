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
        int spielNiveau = 1;
        // if OOP2 ausgewählt -> niveau = 2

        // Tempel erzeugen
        Tempel wasserTempel = new Tempel("blau");
        Tempel luftTempel = new Tempel("gelb");
        Tempel erdeTempel = new Tempel("gruen");
        Tempel feuerTempel = new Tempel("rot");

        //Fragenpool erstellen
        
        Quizfrage.wasserTempelOOP1Fragen(wasserTempel);
        Quizfrage.wasserTempelOOP2Fragen(wasserTempel);

      
        Quizfrage.luftTempelOOP1Fragen(luftTempel);
        Quizfrage.luftTempelOOP2Fragen(luftTempel);

        Quizfrage.erdeTempelOOP1Fragen(erdeTempel);
        Quizfrage.erdeTempelOOP2Fragen(erdeTempel);
        
        
        Quizfrage.feuerTempelOOP1Fragen(feuerTempel);
        Quizfrage.feuerTempelOOP2Fragen(feuerTempel);


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
	
}//end of Spiel
