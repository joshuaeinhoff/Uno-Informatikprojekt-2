package unotempel.grafikkonsole;

/**<br>
 * Mutter aller Grafik-Klassen, die auf der Grafik-Konsole dargestellt werden.<br>
 <br>*/
public abstract class Grafik {

    public static int idCounter = 1;

    /** Konstanten f&uuml;r Standard-Farben <br>*/
    public static final String WHITE    = "#ffffff";
    public static final String BLACK    = "#000000";
    public static final String GREY     = "#c9c9c9";
    public static final String RED      = "#ff4f42";
    public static final String GREEN    = "#63f04f";
    public static final String BLUE     = "#63a1ff";
    public static final String CYAN     = "#75fff8";
    public static final String MAGENTA  = "#f36bff";
    public static final String YELLOW   = "#ffe642";

    /** Variable f&uuml;r Default-Haupt-Farbe<br>
     * Je nach Subklasse ist das z.B. Hintergrund- oder Textfarbe  <br>*/
    public static String defaultFillcolor = "#cccccc";

    /** ID des Grafik-Objekts, zur Identifizierung auf der Konsole <br>*/
    protected int id = 0;

	/** x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links <br>*/
    protected int x;

	/** y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben <br>*/
	protected int y;

    /** Haupt-Farbe, je nach Subklasse ist das z.B. Hintergrund- oder Textfarbe  <br>*/
    protected String fillcolor = defaultFillcolor;

	/** Der String, der eingelesen wird, wenn auf das Grafik-Objekt geklickt wird <br>*/
	protected String callbackString;

	/** Gibt an, ob das Grafik-Objekt auf der Grafik-Konsole verborgen ist. Default = false<br>*/
	protected boolean hidden = false;
    

    /** <br>
     * Voller Constructor mit allen &auml;nderbaren Eigenschaften. <br>
     * Erzeugt ein Grafik-Objekt und stellt es auf der Grafik-Konsole dar<br>
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links<br>
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben<br>
	 * @param _fillcolor Haupt-Farbe des Grafik-Objekts, erlaubte Werte siehe in allgemeiner Beschreibung<br>
	 * @param _callbackString der String, der eingelesen wird, wenn auf das Grafik-Objekt geklickt wird<br>
	 <br>*/
    protected Grafik(int _x, int _y, String _fillcolor, String _callbackString) {
        this.x = _x;
        this.y = _y;
        this.fillcolor = _fillcolor;
        if(_callbackString == null) {
            this.callbackString = ""+idCounter;
        } else {
            this.callbackString = _callbackString;
        }
        incrementID();
    }

    /** <br>
     * Erzeugt ein Grafik-Objekt und stellt es auf der Grafik-Konsole dar<br>
     * Farbe = default-Farbe defaultFillcolor<br>
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links<br>
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben<br>
	 * @param _callbackString der String, der eingelesen wird, wenn auf das Grafik-Objekt geklickt wird<br>
	 <br>*/
    protected Grafik(int _x, int _y, String _callbackString) {
        this(_x, _y, defaultFillcolor, _callbackString);
    }

    /** <br>
     * Erzeugt eine neue ID (intern f&uuml;r die Grafik-Konsole) <br>
     * und setzt die id des Zielobjekts.<br>
     <br>*/
    protected void incrementID() {
        this.id = idCounter++;
    }

    /** <br>
     * Zeichnet das Grafik-Objekt auf die Grafik-Konsole.<br>
     <br>*/
    public abstract void draw();

    /** <br>
     * Zeigt Grafik auf der Grafik-Konsole an.<br>
     * Das ist das Gegenst&uuml;ck zu hide().<br>
     <br>*/
    public void show() {
        System.out.println("GConsole;;element;;"+this.id+";;show");
        hidden = false;
    }

    /** <br>
     * Verbirgt die Grafik auf der Grafik-Konsole.<br>
	 * Die Grafik wird dabei aber nicht gel&ouml;scht.<br>
	 * Das ist das Gegenst&uuml;ck zu show().<br>
     <br>*/
    public void hide() {
        System.out.println("GConsole;;element;;"+this.id+";;hide");
        hidden = true;
    }

    /** <br>
     * Entfernt die Grafik von der Grafik-Konsole.<br>
     * Ihre Bestandteile werden von der Grafik-Konsole gel&ouml;scht.<br>
     <br>*/
    public void delete() {
        System.out.println("GConsole;;element;;"+this.id+";;delete");
    }

    /** <br>
     * Bewegt das Grafik-Objekt auf die angegebene Position.<br>
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links<br>
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben<br>
     <br>*/
    public void moveTo(int _x, int _y) {
		// zuerst: Objekt-Koordinaten ändern
    	this.x = _x;
        this.y = _y;
		// dann: Kommando an Grafik-Konsole schicken
    	System.out.println("GConsole;;rect;;"+this.id+";;move;;"+this.x+";;"+this.y);
        // Später kann dann ;;rect;; durch ;;element;; ersetzt werden, und auf 5Code Seite angepasst werden
    }

    /** <br>
     * Bewegt as Grafik-Objekt um die angegebene Differenz<br>
	 * @param _dx  &Auml;nderung der x-Koordinate, positive Werte bewegen nach rechts <br>
	 * @param _dy  &Auml;nderung der y-Koordinate, positive Werte bewegen nach unten <br>
     <br>*/
    public void moveBy(int _dx, int _dy) {
		// zuerst: Objekt-Koordinaten ändern
		this.x += _dx;
        this.y += _dy;
		// dann: Kommando an Grafik-Konsole schicken
        System.out.println("GConsole;;rect;;"+this.id+";;move;;"+this.x+";;"+this.y);
        // Später kann dann ;;rect;; durch ;;element;; ersetzt werden, und auf 5Code Seite angepasst werden
    }

    /** <br>
     * Setzt die Hauptfarbe.<br>
   	 * @param _fillcolor Haupt-Farbe des Grafik-Objekts, erlaubte Werte siehe in allgemeiner Beschreibung<br>
	 <br>*/
    public void setFillcolor(String _fillcolor) {
		// neue Werte setzen
        this.fillcolor = _fillcolor;		// neue Werte setzen

		// altes SVG-Element löschen und durch ein neues mit neuen Werten ersetzen
		this.delete();			// - das alte SVG-Element gelöscht
		this.incrementID();		// - eine neue SVG-ID erzeugt
        this.draw();			// neues SVG-Element erzeugen und anzeigen
    }
    
    /** <br>
     * Setzt den Callback-String der Grafik.<br>
     * @param _callback Dieser String wird beim Klick von System.in eingelesen <br>
     <br>*/
    public void setCallback(String _callback) {
		// neue Werte setzen
        this.callbackString = _callback;		// neue Werte setzen

		// altes SVG-Element löschen und durch ein neues mit neuen Werten ersetzen
		this.delete();			// - das alte SVG-Element gelöscht
		this.incrementID();		// - eine neue SVG-ID erzeugt
        this.draw();			// neues SVG-Element erzeugen und anzeigen
    }


    /**<br>
     * Erzeugt aus den angegebene Werten r,g,b  <br>
     * einen String im &uuml;blichen Hex-Format.<br>
     * Der String wird in allen Farb-Angaben der Grafik-Konsole gebraucht.<br>
     * Wenn r,g,b au&szlig;erhalb von 0-255 liegt, wird 0 angenommen.<br>
     * @param r Wert f&uuml;r Rot von 0-255<br>
     * @param g Wert f&uuml;r Grün von 0-255<br>
     * @param b Wert f&uuml;r Blau von 0-255<br>
     * @return Hex-String z.B. 34,67,165 ergibt "#2143A5"<br>
     <br>*/
    public static String rgbColor(int r, int g, int b) {
        if(r>255 || r<0) {
            r=0;
        }
        if(g>255 || g<0) {
             g=0;
        }
        if(b>255 || b<0) {
            b=0;
        }
    	System.out.println("r="+4+"  g="+g+ "  b="+b);
    	String rgb= String.format("#%02X%02X%02X", r,g,b);
        return rgb;
    }
    
    /**<br>
     * Wartet die angegebene Zeit.<br>
     * @param millis die Wartezeit in Millisekunden<br>
     <br>*/
    public static void waitFor(int millis) {
    	try { 
            Thread.sleep(millis); 
        } catch (Exception e) { }
    }


    // nur für Test lokal, nicht in Library:
    /*
    public static void main(String[] args) {
    	System.out.println(Grafik.rgbColor(532,4,1));
    }
    */

}
