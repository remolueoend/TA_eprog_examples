package week7;

/*
 * Author: Samuel Bohl <bohls@student.ethz.ch>
 * 
 * Beispiel für Nutzung von Klassen - Einführung in die Programmierung HS2020
 */
public class VectorStaticBeispiel {

	public static void main(String[] args) {
		//Zuerst erstellen wir 2 Vektoren
		Vektor v1 = new Vektor(1, 1);
		Vektor v2 = new Vektor(2, 3);
		
		//die add() Funktion haben wir als static deklariert. Also müssen wir kein Objekt erstellen um
		//diese Funktion zu nutzen.
		Vektor v3 = Vektor.add(v1,  v2);
		
		//die norm() Funktion ist nicht als static deklariert, deshalb müssen wir diese Funktion von einem
		//deklarierten Objekt (in diesem Fall v1) aufrufen.
		double normv1 = v1.norm();
		
		
		//Ausgaben der Beispiele oben
		System.out.println("Norm von : " + v1 + " = "+ normv1);
		System.out.println("Summe von " +  v1 + " + " + v2 + " = " + v3);
		System.out.println("Norm von : " + v3 + " = " + v3.norm());
		
		//Java weiss nicht, wie man 2 Objekte vergleicht. Java wird bei "==" versuchen die Referenzen der beiden
		//Objekte zu vergleichen. Uns interessiert jedoch nur obe die Werte gleich sind. Deswegen schreiben
		//wir eine eigene equals() Funktion. (Ist im Prinzip wie bei den Strings)
		System.out.println("v3 == new Vektor(v3.x, v3.y) : " + (v3 == new Vektor(v3.x, v3.y) ));
		System.out.println("v3.equals(new Vektor(v3.x, v3.y)) : " + v3.equals(new Vektor(v3.x, v3.y)) );
		
	}
}

/*
 * Vector Klasse
 */
class Vektor {
	int x;
	int y;
	
	/*
	 * Konstruktor der Vektor Klasse
	 */
	Vektor(int x, int y){
		this.x = x;
		this.y = y;
		
	}
	
	/*
	 * Gibt true zurück falls der Vektor, der diese Funktion aufruft dem Vektor vec gleicht.
	 */
	public boolean equals(Vektor vec) {
		
		return this.x == vec.x && this.y == vec.y;
	}
	
	/*
	 * Gibt einen String zurück um das Vektor Object schön auszugeben (Optional - müsst ihr noch nicht verstehen)
	 */
	public String toString() {
		
		return "[" + this.x + " , " + this.y + "]";
		
	}
	
	/*
	 * Gibt neuen Vektor zurück, der die Summe beider gegebenen Vektoren ist.
	 * Das ist eine statische Funktion, also wir brauchen kein Objekt zu erstellen um auf diese Funktion
	 * zuzugreifen. (Siehe Beispiel)
	 */
	public static Vektor add(Vektor one, Vektor two) {

		return new Vektor(one.x + two.x, one.y + two.y);
	}
	
	/*
	 * Gibt die Norm des Vektor Objekts zurück, dass diese Funktion aufgerufen hat. (siehe Beispiel)
	 */
	public double norm() {
		
		return Math.sqrt(this.x*this.x + this.y*this.y);
	}
	
}
