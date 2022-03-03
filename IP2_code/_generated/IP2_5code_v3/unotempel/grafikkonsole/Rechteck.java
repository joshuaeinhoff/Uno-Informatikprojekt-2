package unotempel.grafikkonsole;

/**<br>
 * Ein Rechteck wird auf der Grafik-Konsole dargestellt.<br>
 * Die Farbe kann nach F&uuml;ll- und Rand-Farbe getrennt dargestell werden.<br>
 <br>*/
public class Rechteck extends Grafik {

    /** Breite des Rechtecks, groesser gleich 0 <br>*/
    protected int width;

	/** H&ouml;he des Rechtecks, groesser gleich 0 <br>*/
    protected int height;

	/** Farbe des Rands  <br>*/
    protected String bordercolor = "#444444";

	/** Breite des Rands, Default = 1 <br>*/
	protected int borderwidth = 1;

	/** Radius an den Ecken <br>*/
    protected int borderradius;

    /** Default-Wert f&uuml;r den Ecken-Radius <br>*/
    public static int defaultBorderradius = 0;


    /** <br>
     * Voller Constructor mit allen &auml;nderbaren Eigenschaften.<br>
     * Erzeugt ein Rechteck-Grafik-Objekt und stellt es auf der Grafik-Konsole dar<br>
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links<br>
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben<br>
	 * @param _width Breite des Rechtecks<br>
	 * @param _height H&ouml;he des Rechtecks<br>
	 * @param _fillcolor Farbe des Hintergrunds<br>
	 * @param _bordercolor Farbe des Rands<br>
	 * @param _borderwidth Breite des Rands <br>
     * @param _borderradius Ecken-Radius des Hintergrund-Rechecks<br>
	 * @param _callbackString der String, der eingelesen wird, wenn auf das Grafik-Objekt geklickt wird<br>
	 <br>*/
    public Rechteck(int _x, int _y, int _width, int _height, String _fillcolor, String _bordercolor, int _borderwidth, int _borderradius, String _callbackString) {
        super(_x, _y, _fillcolor, _callbackString);

        this.width  = (_width  >= 0 ? _width : 0);
        this.height = (_height >= 0 ? _height : 0);

        this.bordercolor = _bordercolor;
        this.borderwidth = _borderwidth;
        this.borderradius = _borderradius;
        
        this.draw();
    }

    // default border radius (backwards compatibility)
    /** <br>
    * Erzeugt ein Rechteck Grafik-Objekt und stellt es auf der Grafik-Konsole dar.<br>
    * Default Eckenradius = 0 wird verwendet.<br>
	* @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links<br>
	* @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben<br>
	* @param _width Breite des Rechtecks<br>
	* @param _height H&ouml;he des Rechtecks<br>
	* @param _fillcolor Farbe des Hintergrunds<br>
	* @param _bordercolor Farbe des Rands<br>
	* @param _borderwidth Breite des Rands <br>
	* @param _callbackString der String, der eingelesen wird, wenn auf das Grafik-Objekt geklickt wird<br>
	<br>*/
    public Rechteck(int _x, int _y, int _width, int _height, String _fillcolor, String _bordercolor, int _borderwidth, String _callbackString) {
        this(_x, _y, _width, _height, _fillcolor, _bordercolor, _borderwidth, defaultBorderradius, _callbackString); 
    }


    // RECT
    // [0] GConsole
    // [1] rect
    // [2] id
    // [3] CMD (draw, move)
    // [4] x
    // [5] y
    // [6] width
    // [7] height
    // [8] fill color
    // [9] border color
    // [10] border width
    // [11] border radius
    // [12] callbackString

    /** <br>
     * Stellt das Rechteck auf der Grafik-Konsole dar.<br>
     <br>*/
    public void draw() {
  		System.out.println("GConsole;;rect;;"+this.id+";;draw;;"+this.x+";;"+this.y+";;"+ 	
        this.width+";;"+this.height+";;"+this.fillcolor+";;"+this.bordercolor+";;"+this.borderwidth+";;"+this.borderradius+";;"+this.callbackString);
    }

    /** <br>
     * Setzt die Breite des Rechtecks.<br>
     * @param _width, Werte kleiner 0 werden auf 0 gesetzt<br>
     <br>*/
    public void setWidth(int _width) {
		// neue Werte setzen
		///" neue Breite" + _width
        this.width = _width;		// neue Werte setzen

		// altes SVG-Element löschen und durch ein neues mit neuen Werten ersetzen
		this.delete();			// - das alte SVG-Element gelöscht
		this.incrementID();		// - eine neue SVG-ID erzeugt
        this.draw();			// neues SVG-Element erzeugen und anzeigen
    }

    /** <br>
     * Setzt die H&ouml;he des Rechtecks.<br>
     * @param _height, Werte kleiner 0 werden auf 0 gesetzt<br>
     <br>*/
    public void setHeight(int _height) {
		// neue Werte setzen
		///" neue Höhe" + _height
        this.height = _height;		// neue Werte setzen

		// altes SVG-Element löschen und durch ein neues mit neuen Werten ersetzen
		this.delete();			// - das alte SVG-Element gelöscht
		this.incrementID();		// - eine neue SVG-ID erzeugt
        this.draw();			// neues SVG-Element erzeugen und anzeigen
    }


}