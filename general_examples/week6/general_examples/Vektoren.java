package general_examples;

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

public class Vektoren {

	public static void main(String[] args) {
		Vektor v = new Vektor(2, 3);
		double n = v.norm();
	}
}
