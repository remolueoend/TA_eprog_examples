package week9;
public class RekursionZusatz {

	public static void main(String[] args) {

		System.out.println(faclt(5));
		System.out.println(fib(5));
		System.out.println(gcd(18, 81));
		int[] array = { 1, 2, 3, 4, 5 };
		System.out.println(binarySearch(array, 0, 4, 4));
	}

	public static int faclt(int n) {
		if (n == 0) {
			return 1;
		}

		return n * faclt(n - 1);
	}

	public static int fib(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}

		return fib(n - 1) + fib(n - 2);
	}

	public static int gcd(int x, int y) {
		if (x >= y && x % y == 0) {
			return y;
		}

		return gcd(y, x % y);
	}

	public static boolean binarySearch(int[] array, int left, int right, int n) {
		int mid = (left + right) / 2;
		if (array[mid] == n) {
			return true;
		} else if (left == right) {
			return false;
		}
		return binarySearch(array, left, mid, n) || binarySearch(array, mid + 1, right, n);
	}

}
