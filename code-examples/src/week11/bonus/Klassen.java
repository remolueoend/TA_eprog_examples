package week11.bonus;

import java.io.PrintStream;

// Veraendern Sie diese Datei nicht!

public class Klassen {

	public static void main(String[] args) {
		klassen(System.out);
	}

	public static void klassen(PrintStream output) {

		KlasseZ a = new KlasseA();
		KlasseB b = new KlasseB();
		KlasseB c = new KlasseC();
		KlasseB d = new KlasseD();
		KlasseZ e = new KlasseE();
		KlasseB f = new KlasseF();

		if (((KlasseA) a).foo() && ((KlasseA) e).foo()) {
			output.println("Zuerich");
		} else {
			output.println("Bern");
		}

		output.println(c.foo() + " " + b.foo());
		output.println(f.foo() + " " + c.foo());
		if ((f instanceof KlasseD) || (d instanceof KlasseF)) {
			output.println("Related");
		} else {
			output.println("Unrelated");
		}
		output.println(d.foo() + " " + c.foo());
	}
}
