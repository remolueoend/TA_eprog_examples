/**
 * Schreibt jeder Klasse welche dieses Interface implementiert vor,
 * eine Methode `String nextChar()` auf ihren Objekten zu implementieren.
 */
interface DataSource {
	String nextChar();
}

public class InterfaceExample {
	public static void main(String[] args) {
		// Beide dieser Objekte file and network sind von Klassen, welche
		// das Interface DataSource implementieren. Es ist deshalb garantiert,
		// das file und network beide eine Methode `String nextChar()` besitzen.
		FileSource file = new FileSource("/opt/var/etc/bin");
		NetworkSource network = new NetworkSource("proto://server.ethz.ch");
		
		// Deshalb können wir diese Objekte hier übergeben:
		readFirstInt(file);
		readFirstInt(network);
	}

	/**
	 * Diese Methode erwartet eine Data-Source und liest von dieser die ersten Zeichen bis zu einem Leerschlag oder Zeilenumbruch.
	 * Danach gibt sie diese Zeichen als Integer interpretiert wieder zurück.
	 * 
	 * Diese Methode interessiert sich nicht, von welcher Klasse ein gegebenes dataSource-Objekt stammt.
	 * Diese Funktion erwartet nur, dass die auf dem gegebenen Objekt die Methode `String nextChar()` aufrufen kann.
	 */
	public static int readFirstInt(DataSource dataSource) {
		// dataSource.nextChar() kann hier aufgerufen werden, da wir den Typ des Parameters dataSource als `DataSource` deklariert haben.
		// Das heisst, jedes gegebene dataSource-Objekt muss von einer Klasse stammen, welche das `DataSource` Interface implementiert,
		// und somit für jedes ihrer Objekte eine `nextChar` Methode definieren muss.
		String currChar = dataSource.nextChar();
		while(currChar != " " && currChar != "\n") {
			// TODO: parse integer
			currChar = dataSource.nextChar();
		}
		
		return 0; // fix this!
	}
}

// Beide folgenden Klassen deklarieren hier, dass sie das Interface `DataSource` implementieren.
// Dies zwingt sie dazu, die Methode `String nextChar` wie vom Interface vorgeschrieben zu definieren/implementieren.
class NetworkSource implements DataSource {
	NetworkSource(String address) {}
	public String nextChar() {
		// TODO: read next char from server
		return "";
	}
}

class FileSource implements DataSource {
	FileSource(String filePath) {}
	
	public String nextChar() {
		// TODO: read next char from our file
		return "";
	}
}