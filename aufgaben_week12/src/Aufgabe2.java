import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/*
Schreiben Sie ein Programm das eine Datei mit ganzen Zahlen liest und dann die Zahlen als
Liste druckt:

Dann drucken Sie den Durchschnitt der Zahlen.

Geben Sie die groesste und die kleinste Zahl aus.

Filtern (d.h. entfernen) Sie alle geraden Zahlen (Zahlen die durch 2 ohne Rest teilbar
sind).
*/

public class Aufgabe2 {

	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Scanner input = new Scanner(new File("numbers.txt"));
		// Alle Zahlen einlesen:
		while (input.hasNext()) {
			int n = input.nextInt();
			numbers.add(n);
		}
		input.close();

		// Alle Zahlen ausgeben:
		System.out.println(numbers);

		// Durchschnitt berechnen:
		int tmp = 0;
		for (int i = numbers.size() - 1; i >= 0; i--) {
			tmp += numbers.get(i);
		}
		System.out.println("Durchschnitt [int] = " + tmp / numbers.size());
		System.out.println("Durchschnitt [double] = " + (double) tmp / numbers.size());

		// Minimum und Maximum berechnen und ausgeben:
		int min = numbers.get(0);
		int max = min;
		for (int i = 1; i < numbers.size(); i++) {
			if (numbers.get(i) > max) {
				max = numbers.get(i);
			}
			if (numbers.get(i) < min) {
				min = numbers.get(i);
			}
		}
		System.out.println("Min = " + min + " Max = " + max);

		// Diese Methode `filterEvens` entfernt Elemente direkt aus unser gegebenen Liste,
		// wir können als danach einfach wieder unsere Liste ausgeben:
		filterEvens(numbers);
		System.out.println(numbers);

	}

	// Removes all elements w/ even values from the list.
	public static void filterEvens(ArrayList<Integer> list) {
		for (int i = list.size() - 1; i >= 0; i--) {
			int n = list.get(i);
			if (n % 2 == 0) {
				list.remove(i);
			}
		}
	}

}
