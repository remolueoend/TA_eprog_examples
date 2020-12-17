package week6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class DateienLesen {

	// 'throws FileNotFoundException' einfach noch ignorieren, kommt später dran...
	public static void main(String[] args) throws FileNotFoundException {
		Scanner reader = new Scanner(new File("text_week6.txt"));

		int ersteZahl = reader.nextInt();
		System.out.println(ersteZahl);
		int zweiteZahl = reader.nextInt();
		System.out.println(zweiteZahl);
//		int dritteZahl = reader.nextInt(); System.out.println(dritteZahl);

		// wir lesen solange es etwas zum lesen gibt:
		while (reader.hasNext()) {
			System.out.println(reader.nextLine());
		}

		int zahlen[] = new int[] { ersteZahl, zweiteZahl, 42, 44, 46 };

		Random rand = new Random();
		// bei Random.nextInt(int max) ist `max` immer *exclusive*:
		int zufallsZahl = zahlen[rand.nextInt(zahlen.length)];

		System.out.println(zufallsZahl);
	}

}
