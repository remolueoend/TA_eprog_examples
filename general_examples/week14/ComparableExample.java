import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Das Comparable-Interface wird verwendet, um Objekte untereinander "vergleichbar" zu machen, heisst:
 * um von einer Liste von Objekten (folgend als Beispiel Studenten) eine totale Ordnung bilden zu können.
 * Das ist zB. praktisch, wenn Objekte sortiert werden sollen und somit klar sein muss, welches Objekt
 * vor oder nach welchem anderen Objekt in der Ordnung auftreten soll.
 * Dazu implementieren wir in unserer Klasse das Interface `Comparable<UnsereKlasse>` und fügen die Methode
 * `int compareTo(UnsereKlasse other)` hinzu, welche folgenden Wert zurückgeben muss:
 * -1 falls unser aktuelles Objekt (`this`) "kleiner" ist als `other`, heisst: In der Ordnung vor `other` kommt.
 *  1 falls unser aktuelles Objekt (`this`) "grösser" ist als `other`, heisst: In der Ordnung nach `other` kommt.
 *  0 falls die Objekte "gleich gross" sind, heisst: In der Ordnung am selben Platz erscheinen sollen
 */

/**
 * In anderen Situationen wollen wir stattdessen definieren, wann zwei Objekte
 * als "gleich" gelten. Das brauchen wir zB. wenn wir Objekte zu einem Set
 * hinzufügen und das Set feststellen muss, ob bereits ein "gleiches" Objekt im
 * Set vorhanden ist. Dazu überschreiben wir die Methoden `equals` und
 * `hashCode`, welche wir von der Klasse `Object` vererbt bekommen (merke: Jede
 * Klasse erbt standardmässig von Object!). `boolean equals(Object other)` gibt
 * dabei `true` zurück, falls unser aktuelles Objekt (`this`) gleich dem
 * gegebenen Objekt `other` ist. Wir müssen normalerweise das Objekt `other`
 * noch in unsere Klasse casten (siehe Beispiel unten).
 * 
 * `int hashCode()` gibt den sogenannten Hash-Wert dieses Objektes zurück.
 * Details sind hier nicht so wichtig, aber wer interessiert ist, hier noch eine
 * detailliertere Beschreibung:
 * https://www.journaldev.com/21095/java-equals-hashcode
 * Der zurückgegebene Hash für zwei "gleiche" Objekte sollte jedenfalls der Gleiche sein.
 */

class Student1 implements Comparable<Student1> {
	String name;

	Student1(String name) {
		this.name = name;
	}

	/**
	 * Diese Methode wird zB. von Collections.sort() verwendet, um eine Liste von Studenten
	 * richtig sortieren zu können.
	 */
	@Override
	public int compareTo(Student1 other) {
		// Strings implementieren auch `Comparable`. Da wir Studenten bei ihrem Namen sortieren wollen,
		// geben wir hier einfach die Ordnung der beiden Namen (this.name, other.name) zurück:
		return this.name.compareTo(other.name);
	}

	/**
	 * Wird zB. verwendet, um beim Einfügen in ein Set festzustellen, ob bereits ein
	 * anderes "gleiches" Objekt im Set vorhanden ist.
	 */
	@Override
	public boolean equals(Object other) {
		// falls `other` (gegeben als Object) kein Student ist, ist `other` sicher nicht
		// gleich
		// dem aktuellen Studenten (`this`). Ansonsten vergleichen wir die Namen der
		// beiden Studenten
		// (und müssen dazu `other` in einen Student casten)
		if (other instanceof Student1) {
			return this.name.equals(((Student1) other).name);
		} else {
			return false;
		}
	}

	/**
	 * Sehr ähnliche Anwendung wie `equals`. Wir müssen hier einen Hash (eine Zahl)
	 * zurückgeben, so dass zwei gleiche Studenten den gleichen Hash haben. Wir
	 * geben hier einfach den Hash vom `name`-Attribut zurück (Strings sind ja auch
	 * Objekte und haben deshalb auch eine `hashCode` Methode, welche für zwei
	 * Strings mit dem gleichen Inhalt den gleichen Hash zurückgibt.)
	 */
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	public String toString() {
		return this.name;
	}
}

public class ComparableExample {

	public static void main(String[] args) {
		Student1 s1 = new Student1("hannah");
		Student1 s2 = new Student1("amelie");

		// Collections.sort() stellt automatisch fest, dass die Objekte in der `list`
		// das Comparable-Interface implementieren,
		// und kann daher unsere `compareTo`-Methode verwenden:
		ArrayList<Student1> list = new ArrayList<Student1>();
		list.add(s1);
		list.add(s2);
		Collections.sort(list);
		System.out.println("geordnete Liste: " + list);

		HashSet<Student1> set = new HashSet<Student1>();
		set.add(s1);
		set.add(s2);
		// Hier wird das Set dank unserem Override von equals/hashCode feststellen, dass
		// bereits ein "gleiches" Objekt hinzugefügt wurde,
		// obwohl wir hier ein neues Objekt erstellen (aber halt mit gleichem Namen):
		set.add(new Student1("hannah"));
		System.out.println("Set von Studenten: " + set);
	}

}
