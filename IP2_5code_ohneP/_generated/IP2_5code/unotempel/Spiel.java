package unotempel;

import unotempel.quiz.*;
import unotempel.kartenspiel.*;
import unotempel.grafikkonsole.*;

/**<br>
 *  Klasse Spiel<br>
 <br>*/
public class Spiel {
    
    /**<br>
     * Main-Methode<br>
     * @param args<br>
     <br>*/
    public static void main(String[] args){

        /* ------------ Spielvorbereitung ------------ */
        
        /* Tempel + Quizfragen + Kartenspiel erzeugen */

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
        wasserTempel.kartenspielErzeugen(60,80);
        luftTempel.kartenspielErzeugen(60,80);
        erdeTempel.kartenspielErzeugen(60,80);
        feuerTempel.kartenspielErzeugen(60,80);

		// Niveau auswählen - GrafikKonsole
		System.out.println("Wählen Sie bitte OOP1 oder OOP2"); 
		GrafikKonsole.clearGrafik();
        //GUI.grafischAuswahlMenueErzeugen();
        //int spielNiveau = GUI.grafischMenueAuswaehlen();
        //System.out.println("Niveau ausgewählt: " + spielNiveau);
        GrafikKonsole.clearGrafik();

		// Held bzw. Spieler erzeugen
        Spieler held = new Held();


        /* ------------ Spielablauf ------------ */
/*
        // 1. Tempel: Wasser
        wasserTempel.quizLoesen(spielNiveau);
        wasserTempel.monsterKaempfen(held);

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