import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/*
schreiben Sie ein Programm das eine Datei Word fuer Word einliest und die Woerter der Datei
als Liste speichert.  

zuerst sollen Sie alle eingelesenen Woerter ausgeben.

dann sollen Sie alle Woerter in der umgekehrten Reihenfolge ausgeben.

dann geben Sie alle Substantive (fangen mit Grossbuchstaben an) in Grossbuchstaben aus.

     Also Haus ->  HAUS

Dann geben Sie die Woerter ohne Substantive aus
*/

public class Aufgabe1 {
	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<String> allWords = new ArrayList<String>();
		Scanner input = new Scanner(new File("aufgabentext1.txt"));
		// Wörter einlesen:
		while (input.hasNext()) {
			String word = input.next();
			System.out.println(".." + word);
			allWords.add(word);
		}
		input.close();

		// Alle Wörter ausgeben:
		System.out.println(allWords);

		// Wörter in umgekehrter Reihenfolge ausgeben:
		for (int i = allWords.size() - 1; i >= 0; i--) {
			System.out.println(allWords.get(i));
		}

		// alle Substantive in Grossbuchstaben ausgeben:
		for (int i = 0; i < allWords.size(); i++) {
			String s = allWords.get(i);
			if (Character.isUpperCase(s.charAt(0)))
				System.out.println(s.toUpperCase());
		}

		// wir löschen nun alle Substantive aus der Liste und geben die Liste nochmals aus:
		for (int i = 0; i < allWords.size(); i++) {
			String s = allWords.get(i);
			if (Character.isUpperCase(s.charAt(0))) {
				allWords.remove(i);
				i--;
			}
		}

		System.out.println(allWords);
	}
}
