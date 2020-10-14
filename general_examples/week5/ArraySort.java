import java.util.Arrays;

public class ArraySort {

	public static void main(String[] args) {
		int[] some_numbers = {5, 3, 89, 5, 13, 43};
		
		System.out.println("Before: " + Arrays.toString(some_numbers));
		
		Arrays.sort(some_numbers);
		
		System.out.println("After: " + Arrays.toString(some_numbers));
	}

}
