import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Bitte gib eine ganze Zahl ein: ");
		int entry = s.nextInt();
		System.out.println("Du hast " + entry + " eingegeben");
		s.close();
	}

}
