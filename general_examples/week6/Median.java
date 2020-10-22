import java.util.Arrays;

public class Median {

	public static void main(String[] args) {
			int[] beispiel = {3, 25, 13, 2, 33, 12, 11};
			
			double median = median(beispiel);
			
			System.out.println(median);
	}
	
	public static double median(int[] input) {
		//zuerst müssen wir den Array sortieren
		Arrays.sort(input);
		
		//Wir speichern die Länge des input arrays in "len"
		int len = input.length;
		
		//Falls die Anzhal der Elemente (also die Länge) eine gerade Zahl ist.
		if(len%2 == 0) {
			
			int middleLeft = len/2; 
			int middleRight = len/2 + 1;
			
			//gebe den arithmetischen Mittelwert der beiden mittleren Elemente zurück.
			return (input[middleLeft] + input[middleRight]) / 2.0; 
																	
		
		//Andernfalls ist die Anzahl der Elemente ungerade
		} else {
			
			int middle = len/2;
			
			//gebe das mittlere Element zurück;
			return input[middle];
		}
		
	}

}