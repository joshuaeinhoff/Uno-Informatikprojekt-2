package unotempel.grafikkonsole;

/**
 * Mutter aller Grafik-Klassen, die auf der Grafik-Konsole dargestellt werden.
 */
public abstract class Grafik {

    public static int idCounter = 1;

    /** Konstanten für Standard-Farben */
    public static final String WHITE    = "#ffffff";
    public static final String BLACK    = "#000000";
    public static final String GREY     = "#c9c9c9";
    public static final String RED      = "#ff4f42";
    public static final String GREEN    = "#63f04f";
    public static final String BLUE     = "#63a1ff";
    public static final String CYAN     = "#75fff8";
    public static final String MAGENTA  = "#f36bff";
    public static final String YELLOW   = "#ffe642";

    /** Variable für Default-Haupt-Farbe
     * Je nach Subklasse ist das z.B. Hintergrund- oder Textfarbe  */
    public static String defaultFillcolor = "#cccccc";

    /** ID des Grafik-Objekts, zur Identifizierung auf der Konsole */
    protected int id = 0;

	/** x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links */
    protected int x;

	/** y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben */
	protected int y;

    /** Haupt-Farbe, je nach Subklasse ist das z.B. Hintergrund- oder Textfarbe  */
    protected String fillcolor = defaultFillcolor;

	/** Der String, der eingelesen wird, wenn auf das Grafik-Objekt geklickt wird */
	protected String callbackString;

	/** Gibt an, ob das Grafik-Objekt auf der Grafik-Konsole verborgen ist. Default = false*/
	protected boolean hidden = false;
    

    /** 
     * Voller Constructor mit allen änderbaren Eigenschaften. 
     * Erzeugt ein Grafik-Objekt und stellt es auf der Grafik-Konsole dar
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben
	 * @param _fillcolor Haupt-Farbe des Grafik-Objekts, erlaubte Werte siehe in allgemeiner Beschreibung
	 * @param _callbackString der String, der eingelesen wird, wenn auf das Grafik-Objekt geklickt wird
	 */
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

    /** 
     * Erzeugt ein Grafik-Objekt und stellt es auf der Grafik-Konsole dar
     * Farbe = default-Farbe defaultFillcolor
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben
	 * @param _callbackString der String, der eingelesen wird, wenn auf das Grafik-Objekt geklickt wird
	 */
    protected Grafik(int _x, int _y, String _callbackString) {
        this(_x, _y, defaultFillcolor, _callbackString);
    }

    /** 
     * Erzeugt eine neue ID (intern für die Grafik-Konsole) 
     * und setzt die id des Zielobjekts.
     */
    protected void incrementID() {
        this.id = idCounter++;
    }

    /** 
     * Zeichnet das Grafik-Objekt auf die Grafik-Konsole.
     */
    public abstract void draw();

    /** 
     * Zeigt Grafik auf der Grafik-Konsole an.
     * Das ist das Gegenstück zu hide().
     */
    public void show() {
        System.out.println("GConsole;;element;;"+this.id+";;show");
        hidden = false;
    }

    /** 
     * Verbirgt die Grafik auf der Grafik-Konsole.
	 * Die Grafik wird dabei aber nicht gelöscht.
	 * Das ist das Gegenstück zu show().
     */
    public void hide() {
        System.out.println("GConsole;;element;;"+this.id+";;hide");
        hidden = true;
    }

    /** 
     * Entfernt die Grafik von der Grafik-Konsole.
     * Ihre Bestandteile werden von der Grafik-Konsole gelöscht.
     */
    public void delete() {
        System.out.println("GConsole;;element;;"+this.id+";;delete");
    }

    /** 
     * Bewegt das Grafik-Objekt auf die angegebene Position.
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben
     */
    public void moveTo(int _x, int _y) {
		// zuerst: Objekt-Koordinaten ändern
    	this.x = _x;
        this.y = _y;
		// dann: Kommando an Grafik-Konsole schicken
    	System.out.println("GConsole;;rect;;"+this.id+";;move;;"+this.x+";;"+this.y);
        // Später kann dann ;;rect;; durch ;;element;; ersetzt werden, und auf 5Code Seite angepasst werden
    }

    /** 
     * Bewegt as Grafik-Objekt um die angegebene Differenz
	 * @param _dx  Änderung der x-Koordinate, positive Werte bewegen nach rechts 
	 * @param _dy  Änderung der y-Koordinate, positive Werte bewegen nach unten 
     */
    public void moveBy(int _dx, int _dy) {
		// zuerst: Objekt-Koordinaten ändern
		this.x += _dx;
        this.y += _dy;
		// dann: Kommando an Grafik-Konsole schicken
        System.out.println("GConsole;;rect;;"+this.id+";;move;;"+this.x+";;"+this.y);
        // Später kann dann ;;rect;; durch ;;element;; ersetzt werden, und auf 5Code Seite angepasst werden
    }

    /** 
     * Setzt die Hauptfarbe.
   	 * @param _fillcolor Haupt-Farbe des Grafik-Objekts, erlaubte Werte siehe in allgemeiner Beschreibung
	 */
    public void setFillcolor(String _fillcolor) {
		// neue Werte setzen
        this.fillcolor = _fillcolor;		// neue Werte setzen

		// altes SVG-Element löschen und durch ein neues mit neuen Werten ersetzen
		this.delete();			// - das alte SVG-Element gelöscht
		this.incrementID();		// - eine neue SVG-ID erzeugt
        this.draw();			// neues SVG-Element erzeugen und anzeigen
    }
    
    /** 
     * Setzt den Callback-String der Grafik.
     * @param _callback Dieser String wird beim Klick von System.in eingelesen 
     */
    public void setCallback(String _callback) {
		// neue Werte setzen
        this.callbackString = _callback;		// neue Werte setzen

		// altes SVG-Element löschen und durch ein neues mit neuen Werten ersetzen
		this.delete();			// - das alte SVG-Element gelöscht
		this.incrementID();		// - eine neue SVG-ID erzeugt
        this.draw();			// neues SVG-Element erzeugen und anzeigen
    }


    /**
     * Erzeugt aus den angegebene Werten r,g,b  
     * einen String im üblichen Hex-Format.
     * Der String wird in allen Farb-Angaben der Grafik-Konsole gebraucht.
     * Wenn r,g,b außerhalb von 0-255 liegt, wird 0 angenommen.
     * @param r Wert für Rot von 0-255
     * @param g Wert für Grün von 0-255
     * @param b Wert für Blau von 0-255
     * @return Hex-String z.B. 34,67,165 ergibt "#2143A5"
     */
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
    
    /**
     * Wartet die angegebene Zeit.
     * @param millis die Wartezeit in Millisekunden
     */
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
