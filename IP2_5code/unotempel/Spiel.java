package unotempel;

import unotempel.quiz.*;
import unotempel.kartenspiel.*;
import unotempel.grafikkonsole.*;
import unotempel.konsole.*;

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
        GUI.leererCanvasDarstellen();
        
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

        // Kartenspiel in jedem Tempel erzeugen
        wasserTempel.kartenspielErzeugen();
        luftTempel.kartenspielErzeugen();
        erdeTempel.kartenspielErzeugen();
        feuerTempel.kartenspielErzeugen();

		// Niveau durch die GrafikKonsole auswählen
		System.out.println("Wählen Sie bitte OOP1 oder OOP2"); 
        GUI.menueGrafischErzeugen();
        int spielNiveau = GUI.menueGrafischAuswaehlen();
        System.out.println("Niveau ausgewählt: " + spielNiveau);
		GrafikKonsole.clearGrafik();
        GUI.leererCanvasDarstellen();

		// Held bzw. Spieler erzeugen
        Spieler held = new Held();

		


        /* ------------ Spielablauf ------------ */

		int naechsterTempel = 0;
        
        // 1. Tempel: Wasser
        System.out.println("Als erstes musst du den Wasser-Tempel besuchen.");
        
        // Solange den Tempel-Wasser nicht ausgewählt wird
        while(naechsterTempel != 1) {
        	naechsterTempel = GUI.tempelSymbolZeigen();
        }
        GrafikKonsole.clearGrafik();
        GUI.leererCanvasDarstellen();
                
		// Rätsel lösen
        wasserTempel.quizLoesen(spielNiveau, held);
        GrafikKonsole.clearGrafik();
        GUI.leererCanvasDarstellen();
        // Monster Kämpfen
        wasserTempel.monsterKaempfen(held);
        

        
        

        // 2. Tempel: Luft
        System.out.println("Als nächstes musst du den Luft-Tempel besuchen.");
        
        // Solange den Luft-Wasser nicht ausgewählt wird
        while(naechsterTempel != 2) {
        	naechsterTempel = GUI.tempelSymbolZeigen();
        }
        GrafikKonsole.clearGrafik();
        GUI.leererCanvasDarstellen();
        
        luftTempel.quizLoesen(spielNiveau,held);
        GrafikKonsole.clearGrafik();
        GUI.leererCanvasDarstellen();
//        luftTempel.monsterKaempfen(held);

        // 3. Tempel: Erde
        System.out.println("Als nächstes musst du den Erde-Tempel besuchen.");
        
        // Solange den Erde-Wasser nicht ausgewählt wird
        while(naechsterTempel != 3) {
        	naechsterTempel = GUI.tempelSymbolZeigen();
        }
        GrafikKonsole.clearGrafik();
        GUI.leererCanvasDarstellen();
        
        erdeTempel.quizLoesen(spielNiveau,held);
        GrafikKonsole.clearGrafik();
        GUI.leererCanvasDarstellen();
//        erdeTempel.monsterKaempfen(held);

        // 4. Tempel: Feuer
        System.out.println("Als letztes musst du den Feuer-Tempel besuchen.");
        
        // Solange den Feuer-Wasser nicht ausgewählt wird
        while(naechsterTempel != 4) {
        	naechsterTempel = GUI.tempelSymbolZeigen();
        }
        GrafikKonsole.clearGrafik();
        GUI.leererCanvasDarstellen();
        
        feuerTempel.quizLoesen(spielNiveau,held);
        GrafikKonsole.clearGrafik();
        GUI.leererCanvasDarstellen();
//        feuerTempel.monsterKaempfen(held);
        
    }
	
} // Ende von Spiel