package week5;
public class AnzahlGerade {

	public static int anzahl_gerade(int[] input) {
		// hier kommt deine Lösung:
		// Gib die Anzahl gerader Einträge in `input` zurück
		return 0;
	}

	public static int anzahl_duplikate(int[] input) {
		// Hier kommt deine Lösung;
		// Gib die Anzahl Duplikate in `input` zurück.
		// Zähle dabei alle ausser das erste Vorkommen einen Duplikats:
		// [1, 5, 1, 5, 2, 1] => (2[1] + 1[5]) = 3 duplikate Einträge
		return 0;
	}

	public static void main(String[] args) {
		// Beispiel-Aufruf:
		int[] zahlen = { 4, 5, 7, 2, 9, 67, 44 };
		System.out.println(anzahl_gerade(zahlen)); // sollte 3 ausgeben
	}
}
