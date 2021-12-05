

/**
 *  Klasse Spiel
 */
public class Spiel {
    
    /**
     * Main-Methode
     * @param args
     */
    public static void main(String[] args){

        /* ------------ Spielvorbereitung ------------ */
        
        // GrafikKonsole erstmal 
		GrafikKonsole.clearGrafik();
        
        /* --- Tempel, Quizfragen und Kartenspiel erzeugen --- */

        // Wasser-Tempel, Luft-Tempel, Erde-Tempel und Feuer-Tempel erzeugen
        Tempel wasserTempel = new Tempel("blau");
        Tempel luftTempel = new Tempel("gelb");
        Tempel erdeTempel = new Tempel("gruen");
        Tempel feuerTempel = new Tempel("rot");

        // Quizfragenpool zu OOP1 im Wasser-Tempel erzeugen
        Quizfragenpool qfp_wt_oop1 = wasserTempel.quizfragenpoolErzeugen(1);
        // Quizfragenpool zu OOP2 im Wasser-Tempel erzeugen
        Quizfragenpool qfp_wt_oop2 = wasserTempel.quizfragenpoolErzeugen(2);
        // Quizfragenpool zu OOP1 im Wasser-Tempel erzeugen
        Quizfragenpool qfp_lt_oop1 = luftTempel.quizfragenpoolErzeugen(1);
        // Quizfragenpool zu OOP2 im Wasser-Tempel erzeugen
        Quizfragenpool qfp_lt_oop2 = luftTempel.quizfragenpoolErzeugen(2);
        // Quizfragenpool zu OOP1 im Wasser-Tempel erzeugen
        Quizfragenpool qfp_et_oop1 = erdeTempel.quizfragenpoolErzeugen(1);
        // Quizfragenpool zu OOP2 im Wasser-Tempel erzeugen
        Quizfragenpool qfp_et_oop2 = erdeTempel.quizfragenpoolErzeugen(2);
        // Quizfragenpool zu OOP1 im Wasser-Tempel erzeugen
        Quizfragenpool qfp_ft_oop1 = feuerTempel.quizfragenpoolErzeugen(1);
        // Quizfragenpool zu OOP2 im Wasser-Tempel erzeugen
        Quizfragenpool qfp_ft_oop2 = feuerTempel.quizfragenpoolErzeugen(2);

        // Bsp
        wasserTempel.kartenspielErzeugen(10,10);
        luftTempel.kartenspielErzeugen(10,10);
        erdeTempel.kartenspielErzeugen(10,10);
        feuerTempel.kartenspielErzeugen(10,10);

		// Niveau durch die GrafikKonsole auswählen
		System.out.println("Wählen Sie bitte OOP1 oder OOP2"); 
        GUI.menueGrafischErzeugen();
        int spielNiveau = GUI.menueGrafischAuswaehlen();
        System.out.println("Niveau ausgewählt: " + spielNiveau);
		GrafikKonsole.clearGrafik();
        
		// Held bzw. Spieler erzeugen
        Spieler held = new Held();


        /* ------------ Spielablauf ------------ */

        // 1. Tempel: Wasser
        wasserTempel.quizLoesen(spielNiveau, held);
        GrafikKonsole.clearGrafik();
        wasserTempel.monsterKaempfen(held);
/*
        // 2. Tempel
        luftTempel.quizLoesen(spielNiveau);
        luftTempel.monsterKaempfen(held);

        // 3. Tempel
        erdeTempel.quizLoesen(spielNiveau);
        erdeTempel.monsterKaempfen(held);

        // 4. Tempel
        feuerTempel.quizLoesen(spielNiveau);
        feuerTempel.monsterKaempfen(held);
*/        
    }
	
} // Ende von Spiel