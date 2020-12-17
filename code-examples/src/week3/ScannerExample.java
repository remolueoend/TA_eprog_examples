package week3;
import java.util.Scanner;

public class ScannerExample {
	public static void main(String[] args) {
		// hier findet ihr ein paar weitere Beispiele für Scanner:
		// https://www.w3schools.com/java/java_user_input.asp
		Scanner s = new Scanner(System.in);
		System.out.print("Bitte gib eine ganze Zahl ein: ");
		int entry = s.nextInt();
		System.out.println("Du hast " + entry + " eingegeben");
		s.close();
	}

}