package unotempel.grafikkonsole;

/**<br>
 * Ein Kreis (bzw. eine Ellipse) wird auf der Grafik-Konsole dargestellt.<br>
 * Die Farbe kann nach F&uuml;ll- und Rand-Farbe getrennt dargestell werden.<br>
 <br>*/
public class Kreis extends Grafik {

    /** Breite des Kreises, groesser gleich 0 <br>*/
    protected int width;

	/** H&ouml;he des Kreises, groesser gleich 0 <br>*/
    protected int height;

	/** Farbe des Rands <br>*/
    protected String bordercolor = "#444444";

	/** Breite des Rands, Default = 1 <br>*/
	protected int borderwidth = 1;

    /** <br>
     * Voller Constructor mit allen &auml;nderbaren Eigenschaften.<br>
     * Erzeugt ein Kreis-Grafik-Objekt und stellt es auf der Grafik-Konsole dar<br>
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links<br>
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben<br>
	 * @param _width Breite des Kreises, Werte kleiner 0 werden auf 0 gesetzt<br>
	 * @param _height H&ouml;he des Kreises, Werte kleiner 0 werden auf 0 gesetzt<br>
	 * @param _fillcolor Farbe des Hintergrunds<br>
	 * @param _bordercolor Farbe des Rands<br>
	 * @param _borderwidth Breite des Rands <br>
	 * @param _callbackString der String, der eingelesen wird, wenn auf das Grafik-Objekt geklickt wird<br>
	 <br>*/
    public Kreis(int _x, int _y, int _width, int _height, 
                   String _fillcolor, String _bordercolor, int _borderwidth, String _callbackString) {
        super(_x, _y, _fillcolor, _callbackString);

        /// "Kreis() id = " + id
        this.width = _width;
        this.height = _height;

        this.bordercolor = _bordercolor;
        this.borderwidth = _borderwidth;
        
        this.draw();	// sofort beim Erzeugen des Java-Objekts auch auf der Konsole anzeigen.
        				// das Positioniert den Kreis in SVG mit der Mitte an x und y, so ist es noch implementiert
        this.moveTo(x, y);	// Kompensation für die nicht gewollte Positionierung der Mitte des Kreises, sondern der linken oberen Ecke
        				// wenn auch in 5Code ein Kreis mit x und y und nicht mit cx und cy positioniert wird, kann das moveTo() weg.
    }

    /** <br>
     * Voller Constructor mit allen &auml;nderbaren Eigenschaften.<br>
     * Erzeugt ein Kreis-Grafik-Objekt und stellt es auf der Grafik-Konsole dar<br>
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links<br>
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben<br>
	 * @param _radius Radius des Kreises, Werte kleiner 0 werden auf 0 gesetzt<br>
	 * @param _fillcolor Farbe des Hintergrunds<br>
	 * @param _bordercolor Farbe des Rands<br>
	 * @param _borderwidth Breite des Rands <br>
	 * @param _callbackString der String, der eingelesen wird, wenn auf das Grafik-Objekt geklickt wird<br>
	 <br>*/
    public Kreis(int _x, int _y, int _radius, 
                   String _fillcolor, String _bordercolor, int _borderwidth, String _callbackString) {
        super(_x, _y, _fillcolor, _callbackString);


        this.width  = (_radius >= 0 ? _radius : 0) * 2;
        this.height = (_radius >= 0 ? _radius : 0) * 2;

        this.bordercolor = _bordercolor;
        this.borderwidth = _borderwidth;
        
        this.draw();	// sofort beim Erzeugen des Java-Objekts auch auf der Konsole anzeigen.
        				// das Positioniert den Kreis in SVG mit der Mitte an x und y, so ist es noch implementiert
        this.moveTo(x, y);	// Kompensation für die nicht gewollte Positionierung der Mitte des Kreises, sondern der linken oberen Ecke
        				// wenn auch in 5Code ein Kreis mit x und y und nicht mit cx und cy positioniert wird, kann das moveTo() weg.
    }

    
    // CIRCLE
    // [0] GConsole
    // [1] circle
    // [2] id
    // [3] draw
    // [4] x
    // [5] y
    // [6] width
    // [7] height
    // [8] fill color
    // [9] border color
    // [10] border width
    // [11] callbackString

    /** <br>
     * Stellt den Kreis auf der Grafik-Konsole dar.<br>
     <br>*/
    public void draw() {
        int cx = (this.x+(this.width/2));
        int cy = (this.y+(this.height/2));
         
        ///" draw cx = " + cx + "    cy=" + cy
        System.out.println("GConsole;;circle;;"+this.id+";;draw;;"
            +cx+";;"+cy+";;"+this.width+";;"+this.height
            +";;"+this.fillcolor+";;"+this.bordercolor+";;"+this.borderwidth+";;"+this.callbackString);
    }

    /** <br>
     * Bewegt den Kreis auf die angegebene Position.<br>
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links<br>
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben<br>
     <br>*/
    public void moveTo(int _x, int _y) {
		// zuerst: Objekt-Koordinaten ändern
        /// move to
    	this.x = _x;
        this.y = _y;
		// dann: Kommando an Grafik-Konsole schicken

        // noch: Kompensation, dass nicht mit x und y sondern  mit cx und cy positioniert wird,
    	//    -> wenn das in 5Code korrigiert ist, kann -(this.width/2) weg, ebenso -(this.height/2)

    	int cx = (this.x+(this.width/2));
        int cy = (this.y+(this.height/2));
        ///" moveTo cx = " + cx + "    cy=" + cy

    	System.out.println("GConsole;;circle;;"+this.id+";;move;;"+cx+";;"+cy);
    }

    
    /** <br>
     * Bewegt den Kreis um die angegebene Differenz.<br>
     * @param _dx  &Auml;nderung der x-Koordinate, positive Werte bewegen nach rechts <br>
     * @param _dy  &Auml;nderung der y-Koordinate, positive Werte bewegen nach unten <br>
     <br>*/
    public void moveBy(int _dx, int _dy) {
		// zuerst: Objekt-Koordinaten ändern
		/// move by 
		this.x += _dx;
        this.y += _dy;
		// dann: Kommando an Grafik-Konsole schicken

        int cx = (this.x+(this.width/2));
        int cy = (this.y+(this.height/2));
        ///" moveBy cx = " + cx + "    cy=" + cy

        // noch: Kompensation, dass nicht mit x und y sondern  mit cx und cy positioniert wird,
    	//    -> wenn das in 5Code korrigiert ist, kann -(this.width/2) weg, ebenso -(this.height/2)
    	System.out.println("GConsole;;circle;;"+this.id+";;move;;"+cx+";;"+cy);
    }


    /** <br>
     * Setzt die Breite des Kreises.<br>
     * @param _width, Werte kleiner 0 werden auf 0 gesetzt<br>
     <br>*/
    public void setWidth(int _width) {
		// neue Werte setzen
		this.width = (_width >= 0 ? _width : 0);

		// altes SVG-Element löschen und durch ein neues mit neuen Werten ersetzen
		this.delete();			// - das alte SVG-Element gelöscht
		this.incrementID();		// - eine neue SVG-ID erzeugt
        this.draw();			// neues SVG-Element erzeugen und anzeigen
    }
    
    /** <br>
     * Setzt die H&ouml;he des Kreises.<br>
     * @param _height, Werte kleiner 0 werden auf 0 gesetzt<br>
     <br>*/
    public void setHeight(int _height) {
		// neue Werte setzen
        this.height = (_height >= 0 ? _height : 0);

		// altes SVG-Element löschen und durch ein neues mit neuen Werten ersetzen
		this.delete();			// - das alte SVG-Element gelöscht
		this.incrementID();		// - eine neue SVG-ID erzeugt
        this.draw();			// neues SVG-Element erzeugen und anzeigen
    }

    /** <br>
     * Setzt den Radius des Kreises.<br>
     * @param _radius, Werte kleiner 0 werden auf 0 gesetzt<br>
     <br>*/
    public void setRadius(int _radius) {
		// neue Werte setzen
        this.height = (_radius >= 0 ? _radius : 0) * 2;
        this.width  = (_radius >= 0 ? _radius : 0) * 2;

		// altes SVG-Element löschen und durch ein neues mit neuen Werten ersetzen
		this.delete();			// - das alte SVG-Element gelöscht
		this.incrementID();		// - eine neue SVG-ID erzeugt
        this.draw();			// neues SVG-Element erzeugen und anzeigen
    }
    
} // end class 
