package week10;

public class AtLeastSubsequence {

	public static String wanted;
	public static int count;

	public static boolean subsequence(String s, String t, int n) {
		// Gibt true zurück genau dann wenn der String 't' mindestens 'n' mal
		// als Teilfolge in 's' vorkommt.
		wanted = t;
		count = 0;
		generateSubSequences("", s, t.length());

		if (count >= n) {
			return true;
		}

		// Alternative Loesung ohne static attribute (100% rekursiv)
		/*
		 * if(generateSubSequencesWithOutStaticVariables("", s, t, t.length()) >= n) {
		 * return true; }
		 */

		return false;
	}

	public static void generateSubSequences(String prefix, String str, int n) {
		if (n == 0 || str.length() == 0) {
			if (prefix.equals(wanted)) {
				count++;
			}
			// System.out.println(prefix);
			return;

		}

		generateSubSequences(prefix + str.charAt(0), str.substring(1), n - 1);
		generateSubSequences(prefix, str.substring(1), n);

	}

	// Alternative Loesung ohne static attribute (100% rekursiv)
	public static int generateSubSequencesWithOutStaticVariables(String prefix, String str, String t, int n) {
		if (n == 0 || str.length() == 0) {
			if (prefix.equals(t)) {
				return 1;
			}
			// System.out.println(prefix);
			return 0;

		}

		int one = generateSubSequencesWithOutStaticVariables(prefix + str.charAt(0), str.substring(1), t, n - 1);
		int two = generateSubSequencesWithOutStaticVariables(prefix, str.substring(1), t, n);
		return one + two;
	}

}
