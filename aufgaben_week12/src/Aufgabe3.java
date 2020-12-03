import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
Schreiben Sie eine Methode  intersect die zwei ArrayListen mit ganzen Zahlen als Parameter
akzeptiert und eine neue ArrayList zurückgibt, die nur die Elemente enthält, die in beiden
Listen vorhanden sind.  
*/

public class Aufgabe3 {

	public static void main(String[] args) {
		testSimpleIntersect();
		testAdvancedIntersect();
	}

	/**
	 * Es gibt natürlich viele Wege diese Methode zu implementieren. Wir verwenden hier eine Set-
	 * Datenstruktur, da ihr diese ja gerade im Unterricht behandelt habt. Es erlaubt uns mit der Methode
	 * `contains()` sehr schnell zu überprüfen, ob ein Element im Set vorhanden ist.
	 * Mit einer normalen Liste müsste man über alle Elemente iterieren, was viel langsamer wäre.
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static ArrayList<Integer> intersect_simple(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		// Wir erstellen ein neues HashSet, in dem wir unsere erste Liste für die initialien Elemente
		// des Sets übergeben:
		Set<Integer> list1Items = new HashSet<Integer>(list1);
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		// Wir gehen nun durch alle Elemente der zweiten Liste, und schauen ob jedes Element
		// auch in der ersten Liste vorkommt.
		// 
		// Diese Art von For-Loops kann auch für ArrayLists verwendet werden und ist fast das gleiche wie:
		// for(int i = 0; i < list2.size(); i++) {
		//     Integer list2Item = list2.get(i);
		//     ...
		// }
		for(Integer list2Item : list2) { 
			if(list1Items.contains(list2Item)) { // Eine sehr schnelle Operation auf einem Set
				result.add(list2Item);
			}
		}
		
		return result;
	}

	// Test für die Methode oben
	public static void testSimpleIntersect() {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1); list1.add(2); list1.add(3);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(2); list2.add(4); list2.add(6);
		
		System.out.println("Simple: " + intersect_simple(list1, list2));
	}
	
	
	
	
	
	
	
	/**
	 * !!! Folgender Code benutzt *nicht prüfungsrelevante* Java-Features!!!
	 * 
	 * Heisst: Nur falls es euch interessiert :)
	 * 
	 * Wir wollen die Methode oben verbessern, so dass wir diese auch für Listen von einem anderen Typen als Integer
	 * verwenden können, zB. Listen von Strings. Der Funktion ist es ja eigentlich egal um was für Elemente es sich handelt.
	 * Weiter wäre es natürlich cool, wenn wir der Funktion nicht nur ArrayLists, sondern irgendwelche Listen-ähnliche
	 * Objekte übergeben könnten.
	 * 
	 * Wir verwenden hier einen Syntax, welchen ihr wohl nicht im Unterricht gesehen habt.
	 * Das <T> nach dem `static` erlaubt uns, unsere eigene generische Methode zu schreiben.
	 * Wenn jemand die Methode benutzt (siehe testAdvancedIntercect-Methode), muss definiert werden, was `T` genau für ein Typ ist.
	 * `T` hier ist also nichts anderes als eine Variable, deren Wert ein Typ (zB. String) ist.
	 * Wir können dann in den Parameter-Definitionen und im Code der Methode diese Variable `T` jederzeit verwenden.
	 * 
	 * Weiter ändern wir den Typ der zwei Parameter von ArrayList zu `Iterable<E>`. Dies ist ein Interface von Java selbst
	 * und wird von den meisten Listen-ähnlichen Klassen implementiert. Weiter unten findet ihr eine eigene Klasse welche auch
	 * dieses Interface implementiert. Dieses Interface schreibt vor, dass jedes gegebene Objekt eine Methode `iterator()` haben muss.
	 * Diese muss einen Interator zurückgeben (siehe Implementation unten) und wir zum Beispiel vom For-Loop benutzt, um ein Element
	 * nach dem anderen aus dem Listen-ähnlichen Objekt auslesen zu können.
	 * 
	 * @param <T>
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static <T> ArrayList<T> intersect_advanced(Iterable<T> list1, Iterable<T> list2) {
		// Der Set-Konstruktor akzeptiert leider kein Iterable: wir müssen das Set von Hand füllen.
		// Weiter verwenden wir jetzt die Typen-Variable `T` überall dort wo nötig. Also hier beim Erstsellen des Sets...
		Set<T> list1Items = new HashSet<T>();
		for(T list1Item : list1) {
			list1Items.add(list1Item);
		}
		// ...aber auch hier. Wenn wir diese Methode mit zwei String-Listen aufrufen, wollen wir ja auch eine String-ArrayList
		// zurückerhalten, gleiches gilt für jeden anderen Typ von Liste.
		ArrayList<T> result = new ArrayList<T>();
		
		// Java verwendet automatisch die `iterator()` Methode von `list2`, um mit dem erhaltenen Iterator alle Elemente
		// von `list2` eins nach dem anderen auslesen zu können.
		for(T list2Item : list2) {
			if(list1Items.contains(list2Item)) {
				result.add(list2Item);
			}
		}
		
		return result;
	}
	
	public static void testAdvancedIntersect() {
		/*
		 * Zuerst einmal verwenden wir unsere Methode mit Listen von unseren eigenen Objekt-Typen:
		 */
		ArrayList<Student> students1 = new ArrayList<Student>();
		students1.add(new Student(123));
		students1.add(new Student(987));
		students1.add(new Student(456));

		ArrayList<Student> students2 = new ArrayList<Student>();
		students2.add(new Student(456));
		students2.add(new Student(731));
		students2.add(new Student(987));
		
		// Ihr seht hier: Da wir die Methode mit T=Student verwenden, ist auch der Return-Value eine ArrayList vom typ Student:
		ArrayList<Student> intersection = intersect_advanced(students1, students2);
		
		System.out.println("Students:" + intersection);
		
		
		/*
		 * Jetzt verwenden wir unsere Methode mit eigenen Implementationen von Iterable-Objects (siehe die Klassen weitern unten):
		 * Wir sehen also, dass wir unsere simple Methode nun auf extrem viele verschiedene Arten verwenden können!
		 */
		// Liste mit allen Vielfachen von 2 zwischen 0 und 20:
		MultipleGenerator g2 = new MultipleGenerator(2, 20);
		// Liste mit allen Vielfachen von 3 zwischen 0 und 20:
		MultipleGenerator g3 = new MultipleGenerator(3, 20);
		
		// MultipleGenerator implementiert `Iterable<Integer>` => T=Integer => der Return-Type der Methode ist ArrayList<T> = ArrayList<Integer>
		ArrayList<Integer> multiplesOf2and3 = intersect_advanced(g2, g3);
		System.out.println("Multiples of 2 and 3: " + multiplesOf2and3);

	}
}

/**
 * Klasse welche Studenten-Objekte beschreibt. Zwei Studenten sind "gleich", falls ihre Legi dieselbe ist.
 */
class Student {
	public int legiNumber;
	public String firstName;
	public String lastName;
	
	public Student(int legi) {
		this.legiNumber = legi;
	}
	
	/**
	 * Die `contains`-Methode eines Sets verwendet intern die `hashCode` und `equals`-Methoden der Objekte,
	 * um zwei Objekte miteinander zu vergleichen.
	 * Wir überschreiben diese hier, damit zwei Studenten dann als gleich angesehen werden, wenn beide Objekte die gleiche Legi haben,
	 * auch wenn es zwei separate Objekte sind. 
	 */
	@Override
	public int hashCode() {
		return this.legiNumber;
	}
	@Override
	public boolean equals(Object other) {
		return this.legiNumber == ((Student)other).legiNumber;
	}
	
	/**
	 * Wir überschreiben auch toString, damit Studenten-Objekte korrekt ausgegeben werden mit System.out.println
	 */
	@Override
	public String toString() {
		return String.format("%d", this.legiNumber);
	}
}


/*
 * Eine spezielle Implementation eines `Iterables`. Diese Klasse ist eine Art dynamisch berechnete Liste von Zahlen,
 * und zwar das Vielfache von `number` kleiner als `max`.
 */
class MultipleGenerator implements Iterable<Integer> {
	private int number;
	private int max;
	public MultipleGenerator(int number, int max) {
		this.number = number;
		this.max = max;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		// Wir müssen laut dem `Iterable` Interface hier einen Iterator zurückgeben, welcher ein Element nach dem Andern
		// dieser "Liste" zurückgibt:
		return new MultipleGeneratorIterator(this.number, this.max);
	}
}

/**
 * Dieser Iterator generiert ein Vielfaches von `number` nach dem Andern, bis `max` erreicht wurde
 */
class MultipleGeneratorIterator implements Iterator<Integer> {
	private int number;
	private int max;
	private int current;
	public MultipleGeneratorIterator(int number, int max) {
		this.max = max;
		this.number = number;
		this.current = 0;
	}
	/**
	 * Diese Methode wird zB. vom For-Loop aufgerufen um zu schauen, ob die Liste ein weiteres Element beinhaltet oder bereits
	 * alle gelesen wurden.
	 */
	@Override
	public boolean hasNext() {
		return this.current <= this.max;
	}	

	/**
	 * Diese Methode wird zB. vom For-Loop verwendet, um das nächste Element der Liste zu erhalten.
	 */
	@Override
	public Integer next() {
		int next = this.current;
		this.current += this.number;
		return next;
	}
}
