/**
 *  Klasse Spiel
 */
public class Spiel {
    
    /**
     * Main-Methode
     * @param args
     */
    public static void main(String[] args){

        /* Spielvorbereitung */

        System.out.println("Wählen Sie bitte OOP1 oder OOP2"); // weiter...
        int spielNiveau = 1;
        // if OOP2 ausgewählt -> niveau = 2

        // Wasser-Tempel, Luft-Tempel, Erde-Tempel und Feuer-Tempel erzeugen
        Tempel wasserTempel = new Tempel("blau");
        Tempel luftTempel = new Tempel("gelb");
        Tempel erdeTempel = new Tempel("gruen");
        Tempel feuerTempel = new Tempel("rot");

        // Quizfragenpool zu OOP1 im Wasser-Tempel erzeugen
        Quizfragenpool qfp_wt_oop1 = wasserTempel.quizfragenpoolErzeugen('w', 1);
        // Quizfragenpool zu OOP2 im Wasser-Tempel erzeugen
        Quizfragenpool qfp_wt_oop2 = wasserTempel.quizfragenpoolErzeugen('w', 2);
        // Quizfragenpool zu OOP1 im Wasser-Tempel erzeugen
        Quizfragenpool qfp_lt_oop1 = luftTempel.quizfragenpoolErzeugen('l', 1);
        // Quizfragenpool zu OOP2 im Wasser-Tempel erzeugen
        Quizfragenpool qfp_lt_oop2 = luftTempel.quizfragenpoolErzeugen('l', 2);
        // Quizfragenpool zu OOP1 im Wasser-Tempel erzeugen
        Quizfragenpool qfp_et_oop1 = erdeTempel.quizfragenpoolErzeugen('e', 1);
        // Quizfragenpool zu OOP2 im Wasser-Tempel erzeugen
        Quizfragenpool qfp_et_oop2 = erdeTempel.quizfragenpoolErzeugen('e', 2);
        // Quizfragenpool zu OOP1 im Wasser-Tempel erzeugen
        Quizfragenpool qfp_ft_oop1 = feuerTempel.quizfragenpoolErzeugen('f', 1);
        // Quizfragenpool zu OOP2 im Wasser-Tempel erzeugen
        Quizfragenpool qfp_ft_oop2 = feuerTempel.quizfragenpoolErzeugen('f', 2);




        Spieler held = new Held();


        /* Spielablauf */

//        // 1. Tempel: Wasser
//        wasserTempel.tempelBetreten(spielNiveau);
//        // Monster bekämpfen
//
//        // 2. Tempel
//        luftTempel.tempelBetreten(spielNiveau);
//        // Monster bekämpfen
//
//        // 3. Tempel
//        erdeTempel.tempelBetreten(spielNiveau);
//        // Monster bekämpfen
//
//        // 4. Tempel
//        feuerTempel.tempelBetreten(spielNiveau);
//        // Monster bekämpfen
        
    }
	
} // Ende von Spiel
