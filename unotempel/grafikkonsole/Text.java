package unotempel.grafikkonsole;

/**
 * Diese Klasse stellt einen Text auf der Grafik-Konsole dar.
 */
public class Text extends Grafik {

    /** Inhalt des Textes */
    String text;

    /** Schriftgröße */
    int fontsize;

    /** 
     * Voller Constructor mit allen änderbaren Eigenschaften.
     * Erzeugt ein Text-Grafik-Objekt und stellt es auf der Grafik-Konsole dar
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben
	 * @param _text dieser Text wird angezeigt
	 * @param _textcolor Farbe des Texts, erlaubte Werte siehe in allgemeiner Beschreibung
	 * @param _fontsize Schriftgröße des Texts in Pixeln.
	 * @param _callbackString der String, der eingelesen wird, wenn auf das Grafik-Objekt geklickt wird
	 */
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

    /** 
     * Stellt den Text auf der Grafik-Konsole dar.
     */
    public void draw() {
        System.out.println("GConsole;;text;;"+this.id+";;draw;;"+this.x+";;"+this.y+";;"+this.text+";;"+this.fillcolor+";;"+this.fontsize+";;"+this.callbackString);
    }

    /** 
     * Bewegt den Text auf die angegebene Position.
	 * @param _x  x-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz links
	 * @param _y  y-Koordinate der oberen linken Ecke des Grafik-Objekts, 0 ist dabei ganz oben
     */
    public void moveTo(int _x, int _y) {
		// zuerst: Objekt-Koordinaten ändern
    	this.x = _x;
        this.y = _y;
		// dann: Kommando an Grafik-Konsole schicken
        System.out.println("GConsole;;text;;"+this.id+";;move;;"+_x+";;"+_y);
    }
 
    /** 
     * Bewegt den Text um die angegebene Differenz
	 * @param _dx  Änderung der x-Koordinate, positive Werte bewegen nach rechts 
	 * @param _dy  Änderung der y-Koordinate, positive Werte bewegen nach unten 
     */
    public void moveBy(int _dx, int _dy) {
		// zuerst: Objekt-Koordinaten ändern
		this.x += _dx;
        this.y += _dy;
		// dann: Kommando an Grafik-Konsole schicken
        System.out.println("GConsole;;text;;"+this.id+";;move;;"+this.x+";;"+this.y);
    }

    /** 
     * Setzt den Text auf dem Text-Element neu.
     * @param _text der neue Text
     */
    public void setText(String _text) {
		// neue Werte setzen
        this.text = _text;		// neue Werte setzen

		// altes SVG-Element löschen und durch ein neues mit neuen Werten ersetzen
		this.delete();			// - das alte SVG-Element gelöscht
		this.incrementID();		// - eine neue SVG-ID erzeugt
        this.draw();			// neues SVG-Element erzeugen und anzeigen
    }
    
    /** 
     * Setzt die Größe des Texts auf dem Text-Element neu.
     * @param _fontsize die neue Größe
     */
    public void setFontsize(int _fontsize) {
		// neue Werte setzen
        this.fontsize = _fontsize;		// neue Werte setzen

		// altes SVG-Element löschen und durch ein neues mit neuen Werten ersetzen
		this.delete();			// - das alte SVG-Element gelöscht
		this.incrementID();		// - eine neue SVG-ID erzeugt
        this.draw();			// neues SVG-Element erzeugen und anzeigen
    }
    

}