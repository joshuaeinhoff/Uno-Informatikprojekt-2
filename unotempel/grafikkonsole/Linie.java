package unotempel.grafikkonsole;

/**
 *  Diese Klasse stellt eine Linie auf der Grafik-Konsole dar.
 */
public class Linie extends Grafik {

    /** x-Koordinate des Endpunkts der Linie */
    protected int x2;

	/** x-Koordinate des Endpunkts der Linie */
	protected int y2;

    /** Breite der Linie groesser gleich 0 */
	protected int width = 1;

    /** 
     * Voller Constructor mit allen änderbaren Eigenschaften.
     * Erzeugt ein Linien-Grafik-Objekt und stellt es auf der Grafik-Konsole dar.
	 * @param _x1  x-Koordinate des Startpunkts der Linie, 0 ist dabei ganz links
	 * @param _y1  y-Koordinate des Startpunkts der Linie, 0 ist dabei ganz oben
	 * @param _x2  x-Koordinate des Endpunkts der Linie, 0 ist dabei ganz links
	 * @param _y2  y-Koordinate des Endpunkts der Linie, 0 ist dabei ganz oben
	 * @param _fillcolor Farbe der Linie
	 * @param _width Linienbreite
	 * @param _callbackString der String, der eingelesen wird, wenn auf das Grafik-Objekt geklickt wird
	 */
    public Linie(int _x1, int _y1, int _x2, int _y2, String _fillcolor, int _width, String _callbackString) {
        super(_x1, _y1, _fillcolor, _callbackString);

        this.x2 = _x2;
        this.y2 = _y2;
        this.width = _width;
        
        // sofort beim Erzeugen des Java-Objekts auch auf der Konsole anzeigen
        this.draw();	

    }

    // LINE
    // [0] GConsole
    // [1] line
    // [2] id
    // [3] draw
    // [4] x1
    // [5] y1
    // [6] x2
    // [7] y2
    // [8] border color
    // [9] border width
    // [10] callbackString

    /** 
     * Die Linie wird auf der Grafik-Konsole dargestellt 
    */
    public void draw() {
 		System.out.println("GConsole;;line;;"+this.id+";;draw;;"+this.x+";;"+this.y+";;"+this.x2+";;"+this.y2+";;"+this.fillcolor+";;"+this.width+";;"+this.callbackString);
    }

    /** 
     * Setzt die Breite der Linie.
     * @param _width, Werte kleiner 0 werden auf 0 gesetzt
     */
    public void setWidth(int _width) {
		// neue Werte setzen
        this.width = (_width >= 0 ? _width : 0);

		// altes SVG-Element löschen und durch ein neues mit neuen Werten ersetzen
		this.delete();			// - das alte SVG-Element gelöscht
		this.incrementID();		// - eine neue SVG-ID erzeugt
        this.draw();			// neues SVG-Element erzeugen und anzeigen
    }

    /** 
    * Bewegt die Linie auf die angegebene Position
	* @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links
	* @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben
    */
    public void moveTo(int _x, int _y) {
		// zuerst: Objekt-Koordinaten ändern

		int oldx = x;
        int oldy = y;
        
		this.x = _x;
        this.y = _y;
         
        this.x2 += (_x-oldx);	// auch den Endpunkt verschieben
        this.y2 += (_y-oldy);
        
		// dann: Kommando an Grafik-Konsole schicken

    	System.out.println("GConsole;;rect;;"+this.id+";;move;;"+this.x+";;"+this.y);
    }

    
	/** 
     * Bewegt die Linie um die angegebene Differenz
	 * @param _dx  Änderung der x-Koordinate, positive Werte bewegen nach rechts 
	 * @param _dy  Änderung der y-Koordinate, positive Werte bewegen nach unten 
     */
    public void moveBy(int _dx, int _dy) {
		// zuerst: Objekt-Koordinaten ändern
		/// move by 
		this.x += _dx;
        this.y += _dy;
		this.x2 += _dx;
        this.y2 += _dy;
		// dann: Kommando an Grafik-Konsole schicken
    	System.out.println("GConsole;;rect;;"+this.id+";;move;;"+this.x+";;"+this.y);
    }

} // end class
