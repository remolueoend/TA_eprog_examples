package week3;

public class LogicExamples {

	public static void main(String[] args) {
		int x = 5;
		int y = 6;

		if (x > 5 && y++ > 7) {
			System.out.println("hit");
		}
		System.out.println("Nach 1. IF: y: " + y);

		if (y++ > 7 && x > 0) {
			System.out.println("hit again");
		}
		System.out.println("Nach 2. IF: y: " + y);
	}

}
