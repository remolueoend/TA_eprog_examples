package week7;
import java.util.Arrays;

class Vector {
	int x;
	int y;
	int z;

	Vector(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class ValueVsReference {

	public static void main(String[] args) {
		int integer = 5;
		int[] array = { 1, 2, 3 };
		String string = "hello";
		Vector vector = new Vector(1, 2, 3);

		updateInteger(integer);
		updateArray(array);
		updateString(string);
		updateVector(vector);

		System.out.println("integer: " + integer);
		System.out.println("array: " + Arrays.toString(array));
		System.out.println("string: " + string);
		System.out.println("vector: " + vector.x + ", " + vector.y + ", " + vector.z);
	}

	public static void updateInteger(int i) {
		i = i + 1;
	}

	public static void updateArray(int[] arr) {
		arr[1] = 100;
	}

	public static void updateString(String str) {
		str = "world";
	}

	public static void updateVector(Vector v) {
		v.x = 100;
	}
}
