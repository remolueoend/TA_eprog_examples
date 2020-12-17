package week3;
public class IncDecExamples {

	public static void Ex1() {
		int x = 1, y = 1;
		x = x + 1;
		y++;

		System.out.println("x: " + x + ", y: " + y);
	}

	public static void Ex2() {
		int x = 1;
		int y = x++;
		int z = ++x;
		System.out.println("x: " + x + ", y: " + y + ", z: " + z);
	}

	public static void Ex3() {
		int x = 1;
		System.out.println(x++);
		System.out.println(++x);
		System.out.println(x);
	}

	public static void Ex4() {
		int x = 1, y = 0, z = 0;
		y = x++;
		z = x++ + x++;
		System.out.println("x: " + x + ", y: " + y + ", z: " + z);
	}

	public static void Ex5() {
		int a = 1;
		a = a++;
		System.out.println("a: " + a);
	}

	public static void main(String[] args) {
		// Entfernt die Kommentar-Zeichen ('//') von der jeweiligen
		// Ziele der Funktion die ihr ausführen möchtet:
		Ex1();
//		Ex2();
//		Ex3();
//		Ex4();
//		Ex5();
	}
}
