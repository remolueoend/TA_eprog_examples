package week7;

public class Names {

	public static String[] toGerman(String name) {

		return toGermanIt(name);
		// return toGermanRec(name, "", "");
	}

	public static String[] toGermanIt(String name) {
		String germanName = "";
		String summary = "";
		String curString = "";

		// Case 1: name.length() ist laenger als 6
		while (name.length() > 6) {
			curString = name.substring(0, 3);
			name = name.substring(3);

			if (curString.equals("mor")) {
				summary = "w" + summary;
			} else {
				summary = "m" + summary;
			}

			germanName += "ur";
		}

		// case 2: name.elngth() > 3 und <= 6
		if (name.length() > 3) {

			curString = name.substring(0, 3);
			name = name.substring(3);

			if (curString.equals("mor")) {
				summary = "w" + summary;
			} else {
				summary = "m" + summary;
			}

			germanName += "gross";

		}

		// case 3: name.length() <= 3
		curString = name.substring(0, 3);

		if (curString.equals("mor")) {
			summary = "w" + summary;
			germanName += "mutter";
		} else {
			summary = "m" + summary;
			germanName += "vater";
		}

		// Kapitalisierung vom 1. Character
		germanName = germanName.substring(0, 1).toUpperCase() + germanName.substring(1);

		return new String[] { germanName, summary };
	}

	public static String[] toGermanRec(String name, String germanName, String summary) {
		String[] res; // Resultat Zwischenspeicher

		if (name.substring(0, 3).equals("mor")) {
			summary = "w" + summary;
		} else {
			summary = "m" + summary;
		}

		// Case 1: name.length() ist laenger als 6
		if (name.length() > 6) {
			germanName = "ur" + germanName;
			res = toGermanRec(name.substring(3), germanName, summary);

			// case 2: name.elngth() > 3 und <= 6
		} else if (name.length() > 3) {
			germanName += "gross";
			res = toGermanRec(name.substring(3), germanName, summary);

			// case 3: name.length() <= 3
		} else {

			if (name.substring(0, 3).equals("mor")) {
				germanName += "mutter";
			} else {
				germanName += "vater";
			}

			// Kapitalisierung vom 1. Character
			germanName = germanName.substring(0, 1).toUpperCase() + germanName.substring(1);
			res = new String[] { germanName, summary };
		}

		return res;
	}

}
