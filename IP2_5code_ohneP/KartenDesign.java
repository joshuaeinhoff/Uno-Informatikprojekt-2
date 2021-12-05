/**
 * 
 */
class KartenDesign {

	public final static String farbeGruenSpielfeld = "#9CAF88";

	public final static String farbeGruen = "#465726";
    public final static String farbeRot = "#F57461";
    public final static String farbeBlau = "#64A5BB";
    public final static String farbeSchwarz = "#232B2B";
    public final static String farbeGelb = "#FDD782";
    public final static String farbeWeiss = "#F7F9EF";
    public final static String farbeGrau = "#3B444B";
    



	public static void farbKarte(int positionX, int positionY, String farbe, String nummer){
    
    
    	Rechteck grafikRechteckMitRundung =
        new Rechteck(positionX, positionY, 50, 100, farbe, farbeWeiss, 2, 10, "callback");
        Text grafikText =
        new Text(10+positionX, 2+positionY, nummer, farbeWeiss, 50, "1");
    }
    
    public static void wunschKarte(int positionX, int positionY){
    
    	Rechteck karte =
        new Rechteck(positionX, positionY, 50, 100, farbeSchwarz, farbeWeiss, 2, 10, "callback");
        //------------------------------------------------------------------------------------------
        Rechteck gruen =
        new Rechteck(positionX+8, positionY+33, 15, 15, farbeGruen, farbeGruen, 0, 2, "callback");
        
        Rechteck rot =
        new Rechteck(positionX+26, positionY+35, 15, 15, farbeRot, farbeWeiss, 0, 2, "callback");
        
        Rechteck blau =
        new Rechteck(positionX+10, positionY+50, 15, 15, farbeBlau, farbeWeiss, 0, 2, "callback");
        
        Rechteck gelb =
        new Rechteck(positionX+28, positionY+52, 15, 15, farbeGelb, farbeWeiss, 0, 2, "callback");
        
        
    
    }
    
    public static void plusVierWunschKarte(int positionX, int positionY){
    
    	Rechteck karte =
        new Rechteck(positionX, positionY, 50, 100, farbeSchwarz, farbeWeiss, 2, 10, "callback");
        //------------------------------------------------------------------------------------------
        Rechteck gruen =
        new Rechteck(positionX+8, positionY+33, 15, 15, farbeGruen, farbeGruen, 0, 2, "callback");
        
        Rechteck rot =
        new Rechteck(positionX+26, positionY+35, 15, 15, farbeRot, farbeWeiss, 0, 2, "callback");
        
        Rechteck blau =
        new Rechteck(positionX+10, positionY+50, 15, 15, farbeBlau, farbeWeiss, 0, 2, "callback");
        
        Rechteck gelb =
        new Rechteck(positionX+28, positionY+52, 15, 15, farbeGelb, farbeWeiss, 0, 2, "callback");
        //Text--------------------------------------------------------------------------------------
        
    	Text grafikText =
        new Text(5+positionX, positionY-5, "+4", farbeWeiss, 25, "1");
        Text grafikText2 =
        new Text(15+positionX, 55+positionY, "+4", farbeWeiss, 25, "1");
    }
    
    public static void plusZwei(int positionX, int positionY, String farbe){
    
    	Rechteck grafikRechteckMitRundung =
        new Rechteck(positionX, positionY, 50, 100, farbe, farbeWeiss, 2, 10, "callback");
        Text grafikText =
        new Text(5+positionX, positionY-5, "+2", farbeWeiss, 25, "1");
        Text grafikText2 =
        new Text(15+positionX, 55+positionY, "+2", farbeWeiss, 25, "1");
    
    }
    
    public static void aussetzenKarte(int positionX, int positionY, String farbe){
    
    	Rechteck grafikRechteckMitRundung =
        new Rechteck(positionX, positionY, 50, 100, farbe, farbeWeiss, 2, 10, "callback");
        Kreis grafikKreis =
        new Kreis(10+positionX, 35+positionY, 30, 30, farbe, farbeWeiss, 3, "3");
        Linie grafikLinie =
        new Linie(5+positionX, 35+positionY, 45+positionX, 65+positionY, farbeWeiss, 3, "4");
    
    }
    
    public static void retourKarte(int positionX, int positionY, String farbe){
    
    	
    	Rechteck grafikRechteckMitRundung =
        new Rechteck(positionX, positionY, 50, 100, farbe, farbeWeiss, 2, 10, "callback");
        Kreis grafikKreis =
        new Kreis(10+positionX, 35+positionY, 30, 30, farbe, farbeWeiss, 3, "3");
        Linie grafikLinie =
        new Linie(5+positionX, 50+positionY, 45+positionX, 50+positionY, farbe, 10, "4");
        
        //Pfeil 1
        Linie grafikLinie2 =
        new Linie(5+positionX, 35+positionY, 11+positionX, 45+positionY, farbeWeiss, 3, "4");
        Linie grafikLinie3 =
        new Linie(10+positionX, 45+positionY, 22+positionX, 42+positionY, farbeWeiss, 3, "4");
        
        //Pfeil 2
        Linie grafikLinie4 =
        new Linie(40+positionX, 55+positionY, 28+positionX, 58+positionY, farbeWeiss, 3, "4");
        Linie grafikLinie5 =
        new Linie(45+positionX, 65+positionY, 39+positionX, 55+positionY, farbeWeiss, 3, "4");
    
    }
    
    public static void dummyKarte(int positionX, int positionY){
    
    	Rechteck grafikRechteckMitRundung =
        new Rechteck(positionX, positionY, 50, 100, farbeGrau, farbeWeiss, 2, 10, "callback");
        
    
    }
    
    public static void leereKarte(int positionX, int positionY){
    
    	Rechteck grafikRechteckMitRundung =
        new Rechteck(positionX, positionY, 50, 100, farbeGruenSpielfeld, farbeGrau, 1, 10, "callback");
        
    }
    
    public static void stapelDarstellen(int positionX, int positionY) {
    	Rechteck grafikRechteckMitRundung =
        new Rechteck(positionX, positionY, 50, 100, farbeSchwarz, farbeWeiss, 2, 10, "callback");
        Text uStapelText = new Text(positionX+20, positionY+10, "U", farbeWeiss, 20,"karteZiehen");
        Text nStapelText = new Text(positionX+20, positionY+30, "N", farbeWeiss, 20,"karteZiehen");
    	Text oStapelText = new Text(positionX+20, positionY+50, "O", farbeWeiss, 20,"karteZiehen");
    }
    
    
    

	
    // Mögliches Feature (Automatische Klammer zu)
    
    public static void main(String[] args){
    	
        GrafikKonsole.clearGrafik();
        
        
        //Koordinaten im Abstand von 60
        //Farbkarten
        Text farbKartenText = new Text(20,5,"Farbkarten: ",farbeWeiss,20,"1");
        
        KartenDesign.farbKarte(20,40,farbeGruen,"0");
        KartenDesign.farbKarte(80,40,farbeBlau, "9");
        KartenDesign.farbKarte(140,40,farbeGelb, "7");
        KartenDesign.farbKarte(200,40,farbeRot, "3");
        
        
        //Dummykarte
        Text dummyKarteText = new Text(270,5,"Dummykarte: ",farbeWeiss,20,"1");
        KartenDesign.dummyKarte(450,40);
        
        //PlusZweiKarte
        Text plusZweiText = new Text(20,160,"PlusZweiKarte: ",farbeWeiss,20,"1");
        
        KartenDesign.plusZwei(20,200,farbeGruen);
        KartenDesign.plusZwei(80,200,farbeBlau);
        KartenDesign.plusZwei(140,200,farbeGelb);
        KartenDesign.plusZwei(200,200,farbeRot);
        
        //AussetzenKarte
        
        Text aussetzenText = new Text(270,160,"AussetzenKarte: ",farbeWeiss,20,"1");
        KartenDesign.aussetzenKarte(270,200,farbeGruen);
        KartenDesign.aussetzenKarte(330,200,farbeBlau);
        KartenDesign.aussetzenKarte(390,200,farbeGelb);
        KartenDesign.aussetzenKarte(450,200,farbeRot);
        
        //RetourKarte
        Text retoutText = new Text(20,320,"RetourKarte: ",farbeWeiss,20,"1");
        KartenDesign.retourKarte(20,360,farbeGruen);
        KartenDesign.retourKarte(80,360,farbeBlau);
        KartenDesign.retourKarte(140,360,farbeGelb);
        KartenDesign.retourKarte(200,360,farbeRot);
        
    	//Wunschkarten
        Text wunschText = new Text (270,320,"SonderKarte: ",farbeWeiss,20,"1");
        KartenDesign.wunschKarte(450,360);
        KartenDesign.plusVierWunschKarte(510,360);
        
    }//end of main()
    
}