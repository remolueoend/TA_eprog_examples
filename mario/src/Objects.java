public class Objects {} // Können wir ignorieren

// Unsere Basisklasse aller Figuren in einem Level
class Figure {
	public int x;
	public int y;
	public int lives;
	
	public Figure(int lives) {
		this.lives = lives;
	}
	
	public void recalculatePosition() {
		// Do nothing: Subclasses need to override this method
	}

	public void die() {
		this.lives--;
		if(this.lives == 0) {
		// TODO: remove figure from level
		}
	}
}

class Player extends Figure {
	public String name;
	
	public Player(String name) {
		// super(3) ruft den Konstruktor der Basisklasse (hier: Figure) mit dem Wert 3 (Anzahl Leben) auf.
		// Wenn eine Basisklasse mindestens einen Konstruktor definiert (den Default-Konstruktor überschreibt)
		// Muss eine Subklasse auch immer einen Konstruktor definieren und in diesem *als Erstes* den Basis-Konstruktor aufrufen
		super(3);
		// Nach dem Aufruf des Basiskonstruktors können wir wie normal unser Objekt weiter initialisieren:
		this.name = name;
	}
	
	@Override
	public void recalculatePosition() {
		// TODO: read keyboard input
	}
	
	@Override
	public void die() {
		// Wir überschreiben hier zwar die vererbte Methode `die()`, aber wir wollen trotzdem als Erstes
		// die originale Methode aufrufen, und danach noch weitere Schritte tätigen (i.e. die originale Methode erweitern).
		// Wir können dazu `super.die()` verwenden, um explizit die `die()` Methode in der Basisklasse aufzurufen.
		super.die();

		if(this.lives == 0) {
			// TODO: game over!
		}
	}
}

class Goomba extends Figure {
	public Goomba() {
		super(1);
	}
	
	@Override
	public void recalculatePosition() {
		// TODO: move goomba left and right a few pixels every frame
	}
}


class Piranha extends Figure {
	public Piranha() {
		super(1);
	}
}
