package kartenspiel;
import java.util.*;

/**
 * Abstrakte Superklasse für den menschlichen Spieler und die SpielerKIs(Schwierigkeiten)
 */

 public abstract class Spieler {

    //Jeder Spieler hat eine gewisse Anzahl an Karten auf der Hand, die hier in einem Array gespeichert werden.
    //Liste ist vielleicht doch ein wenig besser, da der Spieler immer unterschiedlich viele Karten auf der Hand
    //hat - muss dann immer ein neues Array gemacht werden? z. B. 10 Karten auf der Hand

	//ArrayList<Karte> hand; //OOP2


    // Hand des Spielers mit Karten die max. 20 Karten beinhalten darf
    protected Karte[] hand; 

    //Jeder Spieler hat Lebensenergie die durch Kämpfe reduziert werden kann
    protected int lebensenergie;
    
    /**
     * Konstruktor
     * setzt die Arraygröße "hand" am Anfang auf 7
     * @param _lebensenergie - int wird am Anfang z. B. für den menschlichen Spieler auf 100 gesetz
     */
    public Spieler(int _lebensenergie){
        //hand = new ArrayList<>(); //OOP2
        lebensenergie = _lebensenergie;
        hand = new Karte[20]; 
    }

    /**
     * zieht sieben Karten aus dem Kartenstapel
     * @param kartenStapel
     */
    public void ersteHand(KartenStapel kartenStapel){
        for(int i = 0; i < 7; i++){
            karteZiehen(kartenStapel);
        }
    }

    /**
     * Methode zum ziehen der Karten
     */
    public void karteZiehen(KartenStapel kartenstapel){
        //OOP2
        //hand.get(kartenstapel.karteZiehen());
        //fügt die aus dem Stapel gezogene Karte der Hand hinzu
        for(int i = 0; 0<hand.length; i++){
            if(hand[i] == null){
                hand[i] = kartenstapel.karteZiehen();
                return;
            }else{
                System.out.println("Hand ist voll!");
            }
        }
    }


    
    public Karte karteSpielen(Karte geclickteKarte){
       /*
        Karte temp = geclickteKarte;
        hand.remove(geclickteKarte);
        return temp;
        */
        
    }

    public int kartenAnzahl(){
        return hand.size();
    }
    
    /**
     * get methoden sind eigentlich eher doof aber muss erstmal so 
     * @param index
     * @return
     */
    public Karte getKarte(int index){
        return hand.get(index);
    }

    /**
     * ist glaube doch eine doofe Methode muss noch gucken wo ich die hin packe
     * @param aktuellerSpieler
     * @return
     */
    public boolean spielbareKarteVorhanden(Karte aktuelleKarte){
        for(int i = 0; i< hand.size(); i++){
            if(hand.get(i).istSpielbar(aktuelleKarte)){
                return true;
            }
        }
        return false;
    }

}//end of Spieler