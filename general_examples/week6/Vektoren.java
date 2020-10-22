// Unsere Vektorklasse welche definiert,
// wie unsere Vektor-Objekte aussehen sollen:
class Vektor {
	// Attribute:
	double x;
	double y;
	
	// Konstruktor
	Vektor(double xKoord, double yKoord) {
		this.x = xKoord;
		this.y = yKoord;
	}
	
	// Methode:
	double norm() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}
}

// Die "Einstiegsklasse", von Eclipse generiert:
public class Vektoren {

	public static void main(String[] args) {
		// Ein Vektor erstellen:
		Vektor v = new Vektor(2, 3);
		// Methode auf dem Vektor aufrufen:
		double n = v.norm();
	}
}
