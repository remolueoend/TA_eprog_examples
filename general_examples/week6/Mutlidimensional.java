
public class Mutlidimensional {

	public static void main(String[] args) {
		/*
		 * -       -
		 * | 1 2 3 |
		 * | 4 5 6 |
		 * | 7 8 9 |
		 * -       -
		 */
		int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		// Tipp: Kann statt als eine Tabelle auch als ein Arrays von Arrays gesehen werden
	
		// einzelner Eintrag auslesen: 2. Zeile, 2. Zeichen (beides 0-indexiert!):
		System.out.println("Mitte: " + matrix[1][1]);
		
		System.exit(0);
		
		// durch alle Elemente durchgehen:
		System.out.println("Alle Einträge von `matrix`:");
		for(int zeile = 0; zeile < matrix.length; zeile++) {
			for(int spalte = 0; spalte < matrix[zeile].length; spalte++) {
				System.out.println(matrix[zeile][spalte]);
			}
		}
		
		
		// Ist für n Dimensionen generalisierbar:
		double[][][] wuerfel = new double[3][4][5];
	}

}
