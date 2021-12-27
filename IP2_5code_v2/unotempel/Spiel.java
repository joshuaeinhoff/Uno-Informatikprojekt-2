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
        GUI gui = new GUI();
        gui.leererCanvasDarstellen();
        
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
        gui.menueGrafischErzeugen();
        int spielNiveau = gui.menueGrafischAuswaehlen();
        System.out.println("Niveau ausgewählt: " + spielNiveau);
		GrafikKonsole.clearGrafik();
        gui.leererCanvasDarstellen();

		// Held bzw. Spieler erzeugen
        Spieler held = new Held();
        
        // Lebenspunkte darstellen
        gui.stelleLebenspunkteDar(held);
		


        /* ------------ Spielablauf ------------ */

		int naechsterTempel = 0;
        
        // 1. Tempel: Wasser
        boolean heldHatGewonnen = false;
        
        // Solange den Tempel-Wasser nicht ausgewählt wird
        while(naechsterTempel != 1) {
        	System.out.println("Als erstes musst du den Wasser-Tempel besuchen.");
        	naechsterTempel = gui.tempelSymbolZeigen();
        }
        System.out.println("Viel Erfolg!");
        GrafikKonsole.clearGrafik();
        gui.leererCanvasDarstellen();
        gui.stelleLebenspunkteDar(held);
                
		// Rätsel lösen
        wasserTempel.quizLoesen(spielNiveau, held,gui);
        GrafikKonsole.clearGrafik();
        gui.leererCanvasDarstellen();
        gui.stelleLebenspunkteDar(held);
     
        // Monster Kämpfen
        
        heldHatGewonnen = wasserTempel.monsterKaempfen(held,gui);
        GrafikKonsole.clearGrafik();
        gui.leererCanvasDarstellen();
        gui.stelleLebenspunkteDar(held);
        if(!heldHatGewonnen)
       		return;
        heldHatGewonnen = !heldHatGewonnen;
        

        // 2. Tempel: Luft
        heldHatGewonnen = false;
        
        // Solange den Luft-Wasser nicht ausgewählt wird
        while(naechsterTempel != 2) {
        	System.out.println("Als nächstes musst du den Luft-Tempel besuchen.");
        	naechsterTempel = gui.tempelSymbolZeigen();
        }
        System.out.println("Viel Erfolg!");
        GrafikKonsole.clearGrafik();
        gui.leererCanvasDarstellen();
        gui.stelleLebenspunkteDar(held);
        
        // Rätsel lösen
        luftTempel.quizLoesen(spielNiveau,held,gui);
        GrafikKonsole.clearGrafik();
        gui.leererCanvasDarstellen();
        gui.stelleLebenspunkteDar(held);
        
        // Monster Kämpfen
        heldHatGewonnen = luftTempel.monsterKaempfen(held,gui);
        GrafikKonsole.clearGrafik();
        gui.leererCanvasDarstellen();
        gui.stelleLebenspunkteDar(held);
		if(!heldHatGewonnen)
       		return;
        heldHatGewonnen = !heldHatGewonnen;


        // 3. Tempel: Erde
        heldHatGewonnen = false;
        
        // Solange den Erde-Wasser nicht ausgewählt wird
        while(naechsterTempel != 3) {
        	System.out.println("Als nächstes musst du den Erde-Tempel besuchen.");
        	naechsterTempel = gui.tempelSymbolZeigen();
        }
        System.out.println("Viel Erfolg!");
        GrafikKonsole.clearGrafik();
        gui.leererCanvasDarstellen();
        gui.stelleLebenspunkteDar(held);
        
        erdeTempel.quizLoesen(spielNiveau,held,gui);
        GrafikKonsole.clearGrafik();
        gui.leererCanvasDarstellen();
        heldHatGewonnen = erdeTempel.monsterKaempfen(held,gui);
        GrafikKonsole.clearGrafik();
        gui.leererCanvasDarstellen();
        gui.stelleLebenspunkteDar(held);
		if(!heldHatGewonnen)
       		return;
        heldHatGewonnen = !heldHatGewonnen;
            

        // 4. Tempel: Feuer
        heldHatGewonnen = false;
        
        // Solange den Feuer-Wasser nicht ausgewählt wird
        while(naechsterTempel != 4) {
        	System.out.println("Als letztes musst du den Feuer-Tempel besuchen.");
        	naechsterTempel = gui.tempelSymbolZeigen();
        }
        System.out.println("Viel Erfolg!");
        GrafikKonsole.clearGrafik();
        gui.leererCanvasDarstellen();
        gui.stelleLebenspunkteDar(held);
        //
        feuerTempel.quizLoesen(spielNiveau,held,gui);
        GrafikKonsole.clearGrafik();
        gui.leererCanvasDarstellen();
        gui.stelleLebenspunkteDar(held);
        //
        heldHatGewonnen = feuerTempel.monsterKaempfen(held,gui);
        GrafikKonsole.clearGrafik();
        gui.leererCanvasDarstellen();
        gui.stelleLebenspunkteDar(held);
        if(!heldHatGewonnen)
       		return;
        heldHatGewonnen = !heldHatGewonnen;
            
    }
	
} // Ende von Spiel