package unotempel.grafikkonsole;

/**<br>
 * Die Klasse Button stellt ein interaktives Element zur Verf&uuml;gung<br>
 * das aus einem Rechteck und einem darauf zentrierten Text besteht.<br>
 * Die Constructoren bieten sehr einfache bis immer detailliertere Erzeugung<br>
 * F&uuml;r einige Eigenschaften werden Default-Werte als Klassen-Variablen definiert,<br>
 * die somit auch im Programm noch angepasst werden k&ouml;nnen.<br>
 <br>*/
public class Button extends Grafik {

    /** Default-Textfarbe <br>*/
    public static String defaultTextcolor = "#000000";

	/** Default-Radius der Ecken des Hintergrunds <br>*/
	public static int defaultBorderradius = 5;

	/** Default-Schriftgr&ouml;&szlig;e <br>*/
	public static int defaultFontsize = 20;  

    /* Verhältnis eines monospace-Textzeichens (zum Zentrieren des Button-Textes) */
    private static double widthToHeightRatio = 0.6; 
    
    /** Gesamt-H&ouml;he des Buttons <br>*/
    protected int height;
 
    /** Gesamt-Breite des Buttons <br>*/
 	protected int width;

	/** Text, der auf dem Button dargestellt wird <br>*/
    protected String text;

	/** Farbe, in der der Text auf dem Button dargestellt wird <br>*/
	protected String textcolor;

	/** Gr&ouml;&szlig;e, in der der Text auf dem Button dargestellt wird <br>*/
	protected int fontsize;

    /** Ecken-Radius des Hintergrund-Rechtecs <br>*/
    protected int borderradius;
    
    /* x-Offset zum Platzieren des Textes im Button */ 
    private int xOffset;

    /* y-Offset zum Platzieren des Textes im Button */ 
    private int yOffset;

    /** Grafik-Element f&uuml;r den Hintergrund - Rechteck <br>*/
    protected Rechteck hintergrund;
    
	/** Grafik-Element f&uuml;r den Inhalt - Text <br>*/
    protected Text label;


    /** Voller Constructor mit allen &auml;nderbaren Eigenschaften.<br>
     * Erzeugt ein Button-Grafik-Objekt und stellt es auf der Grafik-Konsole dar.<br>
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links<br>
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben<br>
	 * @param _width Breite des Knopfes<br>
	 * @param _height H&ouml;he des Knopfes<br>
	 * @param _fillcolor Farbe des Hintergrunds<br>
	 * @param _text dieser Text wird angezeigt<br>
	 * @param _textcolor Farbe des Texts, erlaubte Werte siehe in allgemeiner Beschreibung<br>
	 * @param _fontsize Schriftgr&ouml;&szlig;e des Texts in Pixeln.<br>
     * @param _borderradius Ecken-Radius des Hintergrund-Rechecks<br>
	 * @param _callbackString der String, der eingelesen wird, wenn auf das Grafik-Objekt geklickt wird<br>
	 <br>*/
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

    /** <br>
     * Erzeugt ein Button-Grafik-Objekt und stellt es auf der Grafik-Konsole dar.<br>
     * H&ouml;he und Breite werden automatisch an den Text angepasst, <br>
     * Callback-String = Text, wenn Text==null.<br>
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links<br>
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben<br>
	 * @param _fillcolor Farbe des Hintergrunds<br>
	 * @param _text dieser Text wird angezeigt<br>
	 * @param _textcolor Farbe des Texts, erlaubte Werte siehe in allgemeiner Beschreibung<br>
	 * @param _fontsize Schriftgr&ouml;&szlig;e des Texts in Pixeln.<br>
     * @param _borderradius Ecken-Radius des Hintergrund-Rechecks<br>
	 * @param _callbackString der String, der eingelesen wird, wenn auf das Grafik-Objekt geklickt wird, wenn null wird _text verwendet<br>
	 <br>*/
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

    /** <br>
     * Erzeugt ein Button-Grafik-Objekt und stellt es auf der Grafik-Konsole dar.<br>
     * H&ouml;he und Breite automatisch an Text anpassen, <br>
     * Default Fontsize und Radius werden verwendet.<br>
     * Callback-String = Text, wenn Text==null<br>
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links<br>
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben<br>
	 * @param _fillcolor Farbe des Hintergrunds<br>
	 * @param _text dieser Text wird angezeigt<br>
	 * @param _textcolor Farbe des Texts, erlaubte Werte siehe in allgemeiner Beschreibung<br>
	 * @param _callbackString der String, der eingelesen wird, wenn auf das Grafik-Objekt geklickt wird, wenn null wird _text verwendet<br>
	 <br>*/
    public Button(int _x, int _y, String _fillcolor, String _text, String _textcolor, String _callbackString) {
        this(_x, _y, _fillcolor, _text, _textcolor , defaultFontsize, defaultBorderradius, _callbackString);
	}

    /** <br>
     * Erzeugt ein Button-Grafik-Objekt und stellt es auf der Grafik-Konsole dar.<br>
     * H&ouml;he und Breite automatisch an Text anpassen, <br>
     * Default Fontsize, Farben und Radius werden verwendet.<br>
     * Callback-String = Text.<br>
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links<br>
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben<br>
	 * @param _text dieser Text wird angezeigt<br>
	 <br>*/
    public Button(int _x, int _y, String _text) {
        this(_x, _y, defaultFillcolor, _text, defaultTextcolor, null);
	}


    /**  <br>
     * Zeichnet den Button auf der Grafik-Konsole.<br>
     * Daf&uuml;r werden die untergeordneten  Grafik-Objekte Text und Rechteck neu erzeugt.<br>
     <br>*/
    public void draw() {
        this.hintergrund = new Rechteck(this.x, this.y, this.width, this.height, this.fillcolor, this.fillcolor, 0, this.borderradius, this.callbackString);
        this.yOffset = this.height / 2 - this.fontsize;
        this.xOffset =(int)((this.width - (this.fontsize * Button.widthToHeightRatio * this.text.trim().length())) / 2);
        this.label = new Text(this.x + this.xOffset, this.y + yOffset, this.text, this.textcolor, this.fontsize, this.callbackString);
    }

    /** <br>
     * Setzt den Text des Buttons<br>
     * Der Button beh&auml;lt die H&ouml;he und Breite<br>
	 * Der Text wird zentriert<br>
     * @param _text Der Text auf dem Button<br>
     <br>*/
    public void setText(String _text) {
        this.text = _text;
		this.label.setText(_text);
        
        // altes SVG-Element löschen und durch ein neues mit neuen Werten ersetzen
		this.delete();			// - das alte SVG-Element gelöscht
		this.incrementID();		// - eine neue SVG-ID erzeugt
        this.draw();			// neues SVG-Element erzeugen und anzeigen
    }

    /** <br>
     * Bewegt den Button auf die angegebene Position.<br>
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links<br>
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben<br>
     <br>*/
    public void moveTo(int _x, int _y) {
        this.x = _x;
        this.y = _y;
		this.hintergrund.moveTo(_x, _y);
		this.label.moveTo(_x  + this.xOffset, _y + this.yOffset);
    }
 
    /** <br>
     * Bewegt den Button um die angegebene Differenz.<br>
	 * @param _dx  &Auml;nderung der x-Koordinate, positive Werte bewegen nach rechts <br>
	 * @param _dy  &Auml;nderung der y-Koordinate, positive Werte bewegen nach unten <br>
     <br>*/
    public void moveBy(int _dx, int _dy) {
        this.x += _dx;
        this.y += _dy;
        this.hintergrund.moveBy(_dx, _dy);
		this.label.moveBy(_dx, _dy);
    }

    /** <br>
     * Entfernt den Button von der Grafik-Konsole.<br>
     * Seine Bestandteile werden von der Grafik-Konsole gel&ouml;scht.<br>
     <br>*/
    public void delete() {
        this.label.delete();
        this.hintergrund.delete();
    }

    /** <br>
     * Zeigt Button auf der Grafik-Konsole an.<br>
     * Das ist das Gegenst&uuml;ck zu hide().<br>
     <br>*/
    public void show() {
        this.hidden = false;
        this.label.show();
        this.hintergrund.show();
    }

    /** <br>
     * Verbirgt den Button auf der Grafik-Konsole.<br>
	 * Der Button wird aber nicht gel&ouml;scht.<br>
	 * Das ist das Gegenst&uuml;ck zu show().<br>
     <br>*/
    public void hide() {
        this.hidden = true;
        this.label.hide();
        this.hintergrund.hide();
    }

    /** <br>
     * Setzt den Callback-String des Buttons.<br>
     * @param _callback Dieser String wird beim Klick von System.in eingelesen <br>
     <br>*/
    public void setCallback(String _callback) {
        this.callbackString = _callback;
        this.label.setCallback(_callback);
        this.hintergrund.setCallback(_callback);
    }

}