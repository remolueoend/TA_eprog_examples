
public class SiebDesEratosthenes {
	public static void sieb(int limit) {

		//Initialisiere das Array sieb und setze alle Werte auf true 
		boolean[] sieb = new boolean[limit + 1];
		for (int i = 2; i < sieb.length; i++) {
			sieb[i] = true;
		}
		//Markiere die Vielfachen der Primzahlen als false
		for (int i = 2; i < limit; i++) {
			if (sieb[i]) {
				for (int vielfaches = 2 * i; vielfaches <= limit; vielfaches += i) {
					sieb[vielfaches] = false;
				}
			}
		}
		//Zähle die Primzahlen und gebe sie aus
		int primzahlen = 0;
		for (int i = 2; i < sieb.length; i++) {
			if (sieb[i]) {
				primzahlen++;
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		sieb(100);
	}
}
