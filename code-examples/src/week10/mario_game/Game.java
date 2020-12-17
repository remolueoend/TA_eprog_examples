package week10.mario_game;

public class Game {
	public boolean isRunning;

	public void start() {
		// Beispiel-Figuren in unserem Level:
		Player player1 = new Player("hans");
		Goomba g1 = new Goomba();
		Goomba g2= new Goomba();
		Piranha p1 = new Piranha();
		Piranha p2 = new Piranha();
		
		// Wir fügen alle Figuren in ein einzelnes Array
		// => Der Typ des Arrays ist Figure[], da es Objekte von verschiedenen Klassen
		// beinhaltet, welche aber alle von Figure erben => Alle Objekte sind deshalb
		// auch Figure-Objekte!
		Figure[] figuren = new Figure[] {
				player1, g1, g2, p1, p2
		};
		
		this.isRunning = true;
		while(this.isRunning) {

			// Wir gehen über alle Figuren unseres Levels und aktualisieren deren Position:
			for(int i = 0; i < figuren.length; i++) {
				Figure current = figuren[i];
				// Der Typ von current ist Figure. Da die Methode `recalculatePosition` in der Klasse
				// Figure definiert ist, wird diese auf alle Subklassen vererbt. Somit existiert diese Methode
				// auf jedem Objekt einer Subklasse von Figure.
				// Wir können also hier `recalculatePosition` auf `current` aufrufen, egal von welcher Subklasse
				// `current` ist (Player, Goomba, etc.).
				// Da jedoch verschiedene Subklassen `recalculatePosition` überschreiben, wissen wir hier erst
				// während der Ausführung des Programms welche Methode wirklich ausgeführt wird:
				// die originale Implementation in der Basisklasse Figure oder eine Überschreibung davon in der Subklasse von `current`.
				// Dieses Konzept/Problem nennen wir dynamische Bindung oder auch Polymorphismus. 
				current.recalculatePosition();
			}
			
			
			// sleep 100 after each frame:
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
}
