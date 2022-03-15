package unotempel;

import unotempel.quiz.*;
import unotempel.kartenspiel.*;
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
        
        // Graphical User Interface erzeugen 
        GUI gui = new GUI();
        
        // Held bzw. Spieler erzeugen
        Spieler held = new Held();
        
        // Spielbrett darstellen
        gui.spielbrettDarstellen(held);
        
        /* --- Tempel, Quizfragen und Kartenspiel erzeugen --- */

        // Wasser-Tempel, Luft-Tempel, Erde-Tempel und Feuer-Tempel erzeugen
        Tempel wasserTempel = new Tempel("blau");
        Tempel luftTempel = new Tempel("gelb");
        Tempel erdeTempel = new Tempel("gruen");
        Tempel feuerTempel = new Tempel("rot");

		// Niveau durch die GrafikKonsole auswählen
		System.out.println("Wählen Sie bitte OOP1 oder OOP2"); 
        gui.menueGrafischErzeugen();
        int spielNiveau = gui.menueGrafischAuswaehlen();
        System.out.println("Niveau ausgewählt: " + spielNiveau);
        gui.spielbrettDarstellen(held);
        		

        /* ------------ Spielablauf ------------ */

		// darstellen
		gui.spielbrettDarstellen(held);
        // Variable für den nächsten Tempel erzeugen
		int naechsterTempel = 0;
        // Variable zum Speichern, ob der Spieler bei jedem Test gewonnen hat
        boolean heldHatAufgabeErledigt = false;
        
        /* 1. Schritt: Wasser-Tempel */
        
        // Solange den Tempel-Wasser nicht ausgewählt wird
        while(naechsterTempel != 1) {
        	System.out.println("Als erstes musst du den Wasser-Tempel besuchen.");
        	naechsterTempel = gui.tempelSymbolZeigen();
        }
        gui.spielbrettDarstellen(held);
        
        // Einführung in den Tempel darstellen
        wasserTempel.tempelEinfuehrung(gui);
        gui.spielbrettDarstellen(held);
		
        // Spiel im Tempel starten
        System.out.println("Viel Erfolg!");
                
		// Rätsel lösen
        heldHatAufgabeErledigt = wasserTempel.heldHatQuizGeloest(held, spielNiveau, gui);
        gui.spielbrettDarstellen(held);
        if(!heldHatAufgabeErledigt)
       		return;
        heldHatAufgabeErledigt = !heldHatAufgabeErledigt;
     
        // Monster Kämpfen
        heldHatAufgabeErledigt = wasserTempel.heldHatMonsterBesiegt(held, gui);
		gui.spielbrettDarstellen(held);        
        if(!heldHatAufgabeErledigt)
       		return;
        heldHatAufgabeErledigt = !heldHatAufgabeErledigt;
        

        /* 2. Schritt: Luft-Tempel */
        
        // Solange den Luft-Wasser nicht ausgewählt wird
        while(naechsterTempel != 2) {
        	System.out.println("Als nächstes musst du den Luft-Tempel besuchen.");
        	naechsterTempel = gui.tempelSymbolZeigen();
        }
        gui.spielbrettDarstellen(held);
        
        // Einführung in den Tempel darstellen
        luftTempel.tempelEinfuehrung(gui);
        gui.spielbrettDarstellen(held);

        // Spiel im Tempel starten
        System.out.println("Viel Erfolg!");

        // Rätsel lösen
        heldHatAufgabeErledigt = luftTempel.heldHatQuizGeloest(held, spielNiveau, gui);
        gui.spielbrettDarstellen(held);
        if(!heldHatAufgabeErledigt)
            return;
        heldHatAufgabeErledigt = !heldHatAufgabeErledigt;

        // Monster Kämpfen
        heldHatAufgabeErledigt = luftTempel.heldHatMonsterBesiegt(held, gui);
        gui.spielbrettDarstellen(held);
		if(!heldHatAufgabeErledigt)
       		return;
        heldHatAufgabeErledigt = !heldHatAufgabeErledigt;


        /* 3. Schritt: Erde-Tempel */
        
        // Solange den Erde-Wasser nicht ausgewählt wird
        while(naechsterTempel != 3) {
        	System.out.println("Als nächstes musst du den Erde-Tempel besuchen.");
        	naechsterTempel = gui.tempelSymbolZeigen();
        }
        gui.spielbrettDarstellen(held);
        
        // Einführung in den Tempel darstellen
        erdeTempel.tempelEinfuehrung(gui);
        gui.spielbrettDarstellen(held);
		
        // Spiel im Tempel starten
        System.out.println("Viel Erfolg!");

        // Rätsel lösen
        heldHatAufgabeErledigt = erdeTempel.heldHatQuizGeloest(held, spielNiveau, gui);
        gui.spielbrettDarstellen(held);
        if(!heldHatAufgabeErledigt)
            return;
        heldHatAufgabeErledigt = !heldHatAufgabeErledigt;

        // Monster Kämpfen
        heldHatAufgabeErledigt = erdeTempel.heldHatMonsterBesiegt(held, gui);
        gui.spielbrettDarstellen(held);
		if(!heldHatAufgabeErledigt)
       		return;
        heldHatAufgabeErledigt = !heldHatAufgabeErledigt;
            

        /* 4. Schritt: Feuer-Tempel */
        
        // Solange den Feuer-Wasser nicht ausgewählt wird
        while(naechsterTempel != 4) {
        	System.out.println("Als letztes musst du den Feuer-Tempel besuchen.");
        	naechsterTempel = gui.tempelSymbolZeigen();
        }
        gui.spielbrettDarstellen(held);
        
        // Einführung in den Tempel darstellen
        feuerTempel.tempelEinfuehrung(gui);
        gui.spielbrettDarstellen(held);
		
        // Spiel im Tempel starten
        System.out.println("Viel Erfolg!");
                
		// Rätsel lösen
        heldHatAufgabeErledigt = feuerTempel.heldHatQuizGeloest(held, spielNiveau, gui);
        gui.spielbrettDarstellen(held);
        if(!heldHatAufgabeErledigt)
       		return;
        heldHatAufgabeErledigt = !heldHatAufgabeErledigt;

        // Monster Kämpfen
        heldHatAufgabeErledigt = feuerTempel.heldHatMonsterBesiegt(held, gui);
        gui.spielbrettDarstellen(held);
        if(!heldHatAufgabeErledigt)
       		return;
        heldHatAufgabeErledigt = !heldHatAufgabeErledigt;
           
    }
	

	
} // Ende von Spiel