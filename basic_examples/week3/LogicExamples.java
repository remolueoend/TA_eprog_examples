
public class LogicExamples {

	public static void main(String[] args) {
		int x = 5;
		int y = 6;
		
		if(x > 5 && y++ > 7) {
			System.out.println("hit");
		}
		System.out.println("y: " + y);
		
		if(y++ > 7 && x > 0) {
			System.out.println("hit again");
		}
		System.out.println("y: " + y);
	}

}
