public class TestExamples {
	
	public static double norm(double x, double y) {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	public static void main(String[] args) {
		System.out.println("die Norm von (3, 4) ist: " + norm(3, 4));
	}

}
