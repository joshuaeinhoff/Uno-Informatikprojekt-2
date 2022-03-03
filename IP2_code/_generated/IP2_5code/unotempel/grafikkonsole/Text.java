package unotempel.grafikkonsole;

/**<br>
 * Diese Klasse stellt einen Text auf der Grafik-Konsole dar.<br>
 <br>*/
public class Text extends Grafik {

    /** Inhalt des Textes <br>*/
    String text;

    /** Schriftgr&ouml;&szlig;e <br>*/
    int fontsize;

    /** <br>
     * Voller Constructor mit allen &auml;nderbaren Eigenschaften.<br>
     * Erzeugt ein Text-Grafik-Objekt und stellt es auf der Grafik-Konsole dar<br>
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links<br>
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben<br>
	 * @param _text dieser Text wird angezeigt<br>
	 * @param _textcolor Farbe des Texts, erlaubte Werte siehe in allgemeiner Beschreibung<br>
	 * @param _fontsize Schriftgr&ouml;&szlig;e des Texts in Pixeln.<br>
	 * @param _callbackString der String, der eingelesen wird, wenn auf das Grafik-Objekt geklickt wird<br>
	 <br>*/
    public Text(int _x, int _y, String _text, String _textcolor, int _fontsize, String _callbackString) {
        super(_x, _y, _textcolor, _callbackString);

        this.text = _text;
        this.fontsize = _fontsize;
        
        draw();  // sofort beim Erzeugen des Java-Objekts auch auf der Konsole anzeigen.
  
    }

    // TEXT
    // [0] GConsole
    // [1] text
    // [2] id
    // [3] CMD (draw, move)
    // [4] x
    // [5] y
    // [6] text
    // [7] fill color
    // [8] font size
    // [9] callbackString

    /** <br>
     * Stellt den Text auf der Grafik-Konsole dar.<br>
     <br>*/
    public void draw() {
        System.out.println("GConsole;;text;;"+this.id+";;draw;;"+this.x+";;"+this.y+";;"+this.text+";;"+this.fillcolor+";;"+this.fontsize+";;"+this.callbackString);
    }

    /** <br>
     * Bewegt den Text auf die angegebene Position.<br>
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links<br>
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben<br>
     <br>*/
    public void moveTo(int _x, int _y) {
		// zuerst: Objekt-Koordinaten ändern
    	this.x = _x;
        this.y = _y;
		// dann: Kommando an Grafik-Konsole schicken
        System.out.println("GConsole;;text;;"+this.id+";;move;;"+_x+";;"+_y);
    }
 
    /** <br>
     * Bewegt den Text um die angegebene Differenz<br>
	 * @param _dx  &Auml;nderung der x-Koordinate, positive Werte bewegen nach rechts <br>
	 * @param _dy  &Auml;nderung der y-Koordinate, positive Werte bewegen nach unten <br>
     <br>*/
    public void moveBy(int _dx, int _dy) {
		// zuerst: Objekt-Koordinaten ändern
		this.x += _dx;
        this.y += _dy;
		// dann: Kommando an Grafik-Konsole schicken
        System.out.println("GConsole;;text;;"+this.id+";;move;;"+this.x+";;"+this.y);
    }

    /** <br>
     * Setzt den Text auf dem Text-Element neu.<br>
     * @param _text der neue Text<br>
     <br>*/
    public void setText(String _text) {
		// neue Werte setzen
        this.text = _text;		// neue Werte setzen

		// altes SVG-Element löschen und durch ein neues mit neuen Werten ersetzen
		this.delete();			// - das alte SVG-Element gelöscht
		this.incrementID();		// - eine neue SVG-ID erzeugt
        this.draw();			// neues SVG-Element erzeugen und anzeigen
    }
    
    /** <br>
     * Setzt die Gr&ouml;&szlig;e des Texts auf dem Text-Element neu.<br>
     * @param _fontsize die neue Gr&ouml;&szlig;e<br>
     <br>*/
    public void setFontsize(int _fontsize) {
		// neue Werte setzen
        this.fontsize = _fontsize;		// neue Werte setzen

		// altes SVG-Element löschen und durch ein neues mit neuen Werten ersetzen
		this.delete();			// - das alte SVG-Element gelöscht
		this.incrementID();		// - eine neue SVG-ID erzeugt
        this.draw();			// neues SVG-Element erzeugen und anzeigen
    }
    

}