package unotempel.grafikkonsole;

/**
 * Die Klasse Button stellt ein interaktives Element zur Verfügung
 * das aus einem Rechteck und einem darauf zentrierten Text besteht.
 * Die Constructoren bieten sehr einfache bis immer detailliertere Erzeugung
 * Für einige Eigenschaften werden Default-Werte als Klassen-Variablen definiert,
 * die somit auch im Programm noch angepasst werden können.
 */
public class Button extends Grafik {

    /** Default-Textfarbe */
    public static String defaultTextcolor = "#000000";

	/** Default-Radius der Ecken des Hintergrunds */
	public static int defaultBorderradius = 5;

	/** Default-Schriftgröße */
	public static int defaultFontsize = 20;  

    /* Verhältnis eines monospace-Textzeichens (zum Zentrieren des Button-Textes) */
    private static double widthToHeightRatio = 0.6; 
    
    /** Gesamt-Höhe des Buttons */
    protected int height;
 
    /** Gesamt-Breite des Buttons */
 	protected int width;

	/** Text, der auf dem Button dargestellt wird */
    protected String text;

	/** Farbe, in der der Text auf dem Button dargestellt wird */
	protected String textcolor;

	/** Größe, in der der Text auf dem Button dargestellt wird */
	protected int fontsize;

    /** Ecken-Radius des Hintergrund-Rechtecs */
    protected int borderradius;
    
    /* x-Offset zum Platzieren des Textes im Button */ 
    private int xOffset;

    /* y-Offset zum Platzieren des Textes im Button */ 
    private int yOffset;

    /** Grafik-Element für den Hintergrund - Rechteck */
    protected Rechteck hintergrund;
    
	/** Grafik-Element für den Inhalt - Text */
    protected Text label;


    /** Voller Constructor mit allen änderbaren Eigenschaften.
     * Erzeugt ein Button-Grafik-Objekt und stellt es auf der Grafik-Konsole dar.
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben
	 * @param _width Breite des Knopfes
	 * @param _height Höhe des Knopfes
	 * @param _fillcolor Farbe des Hintergrunds
	 * @param _text dieser Text wird angezeigt
	 * @param _textcolor Farbe des Texts, erlaubte Werte siehe in allgemeiner Beschreibung
	 * @param _fontsize Schriftgröße des Texts in Pixeln.
     * @param _borderradius Ecken-Radius des Hintergrund-Rechecks
	 * @param _callbackString der String, der eingelesen wird, wenn auf das Grafik-Objekt geklickt wird
	 */
    public Button(int _x, int _y, int _width, int _height, String _fillcolor, String _text, String _textcolor, int _fontsize, int _borderradius, String _callbackString) {
        super(_x, _y, _fillcolor, _callbackString);

        this.width = _width;
        this.height = _height;

        this.text = _text;
        this.textcolor = _textcolor;
        this.fontsize = _fontsize;

        this.borderradius = _borderradius;
        
        this.draw();		// direkt nach dem Erzeugen auch anzeigen, weil: draw() erzeugt ein SVG-Element. 
    }

    /** 
     * Erzeugt ein Button-Grafik-Objekt und stellt es auf der Grafik-Konsole dar.
     * Höhe und Breite werden automatisch an den Text angepasst, 
     * Callback-String = Text, wenn Text==null.
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben
	 * @param _fillcolor Farbe des Hintergrunds
	 * @param _text dieser Text wird angezeigt
	 * @param _textcolor Farbe des Texts, erlaubte Werte siehe in allgemeiner Beschreibung
	 * @param _fontsize Schriftgröße des Texts in Pixeln.
     * @param _borderradius Ecken-Radius des Hintergrund-Rechecks
	 * @param _callbackString der String, der eingelesen wird, wenn auf das Grafik-Objekt geklickt wird, wenn null wird _text verwendet
	 */
    public Button(int _x, int _y, String _fillcolor, String _text, String _textcolor, int _fontsize, int _borderradius, String _callbackString) {
        this(
            _x, 
            _y, 
            ((int) (_fontsize * Button.widthToHeightRatio * _text.trim().length()) + 10), // width
            (_fontsize + 10),                                                             // height
            _fillcolor, 
            _text, 
            _textcolor, 
            _fontsize, 
            _borderradius, 
            ((_callbackString == null) ? _text : _callbackString));                       // callback string
	}

    /** 
     * Erzeugt ein Button-Grafik-Objekt und stellt es auf der Grafik-Konsole dar.
     * Höhe und Breite automatisch an Text anpassen, 
     * Default Fontsize und Radius werden verwendet.
     * Callback-String = Text, wenn Text==null
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben
	 * @param _fillcolor Farbe des Hintergrunds
	 * @param _text dieser Text wird angezeigt
	 * @param _textcolor Farbe des Texts, erlaubte Werte siehe in allgemeiner Beschreibung
	 * @param _callbackString der String, der eingelesen wird, wenn auf das Grafik-Objekt geklickt wird, wenn null wird _text verwendet
	 */
    public Button(int _x, int _y, String _fillcolor, String _text, String _textcolor, String _callbackString) {
        this(_x, _y, _fillcolor, _text, _textcolor , defaultFontsize, defaultBorderradius, _callbackString);
	}

    /** 
     * Erzeugt ein Button-Grafik-Objekt und stellt es auf der Grafik-Konsole dar.
     * Höhe und Breite automatisch an Text anpassen, 
     * Default Fontsize, Farben und Radius werden verwendet.
     * Callback-String = Text.
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben
	 * @param _text dieser Text wird angezeigt
	 */
    public Button(int _x, int _y, String _text) {
        this(_x, _y, defaultFillcolor, _text, defaultTextcolor, null);
	}


    /**  
     * Zeichnet den Button auf der Grafik-Konsole.
     * Dafür werden die untergeordneten  Grafik-Objekte Text und Rechteck neu erzeugt.
     */
    public void draw() {
        this.hintergrund = new Rechteck(this.x, this.y, this.width, this.height, this.fillcolor, this.fillcolor, 0, this.borderradius, this.callbackString);
        this.yOffset = this.height / 2 - this.fontsize;
        this.xOffset =(int)((this.width - (this.fontsize * Button.widthToHeightRatio * this.text.trim().length())) / 2);
        this.label = new Text(this.x + this.xOffset, this.y + yOffset, this.text, this.textcolor, this.fontsize, this.callbackString);
    }

    /** 
     * Setzt den Text des Buttons
     * Der Button behält die Höhe und Breite
	 * Der Text wird zentriert
     * @param _text Der Text auf dem Button
     */
    public void setText(String _text) {
        this.text = _text;
		this.label.setText(_text);
        
        // altes SVG-Element löschen und durch ein neues mit neuen Werten ersetzen
		this.delete();			// - das alte SVG-Element gelöscht
		this.incrementID();		// - eine neue SVG-ID erzeugt
        this.draw();			// neues SVG-Element erzeugen und anzeigen
    }

    /** 
     * Bewegt den Button auf die angegebene Position.
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben
     */
    public void moveTo(int _x, int _y) {
        this.x = _x;
        this.y = _y;
		this.hintergrund.moveTo(_x, _y);
		this.label.moveTo(_x  + this.xOffset, _y + this.yOffset);
    }
 
    /** 
     * Bewegt den Button um die angegebene Differenz.
	 * @param _dx  Änderung der x-Koordinate, positive Werte bewegen nach rechts 
	 * @param _dy  Änderung der y-Koordinate, positive Werte bewegen nach unten 
     */
    public void moveBy(int _dx, int _dy) {
        this.x += _dx;
        this.y += _dy;
        this.hintergrund.moveBy(_dx, _dy);
		this.label.moveBy(_dx, _dy);
    }

    /** 
     * Entfernt den Button von der Grafik-Konsole.
     * Seine Bestandteile werden von der Grafik-Konsole gelöscht.
     */
    public void delete() {
        this.label.delete();
        this.hintergrund.delete();
    }

    /** 
     * Zeigt Button auf der Grafik-Konsole an.
     * Das ist das Gegenstück zu hide().
     */
    public void show() {
        this.hidden = false;
        this.label.show();
        this.hintergrund.show();
    }

    /** 
     * Verbirgt den Button auf der Grafik-Konsole.
	 * Der Button wird aber nicht gelöscht.
	 * Das ist das Gegenstück zu show().
     */
    public void hide() {
        this.hidden = true;
        this.label.hide();
        this.hintergrund.hide();
    }

    /** 
     * Setzt den Callback-String des Buttons.
     * @param _callback Dieser String wird beim Klick von System.in eingelesen 
     */
    public void setCallback(String _callback) {
        this.callbackString = _callback;
        this.label.setCallback(_callback);
        this.hintergrund.setCallback(_callback);
    }

}