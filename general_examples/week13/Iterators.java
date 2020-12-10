import java.util.ArrayList;
import java.util.Iterator;

/**
 * Nodes unserer LinkedList.
 * 
 * @author remo
 *
 * @param <T> Beschreibt den Typ des Values eines Nodes
 */
class Node<T> {
	T value;
	Node<T> next;

	public Node(T value) {
		this.value = value;
	}
}

/**
 * Unsere simple Beispiel-LinkedList
 * Implementiert das Interface `Iterable<T>`, womit man auf jedem Listen-Objekt
 * die Methode `iterator()` aufrufen kann, um über die Elemente der Liste zu iterieren.
 * 
 * @author remo
 *
 * @param <T> Beschreibt den Typ der Elemente/Values in der Liste
 */
class LinkedList<T> implements Iterable<T> {
	public Node<T> first;
	public Node<T> last;

	public void add(T value) {
		Node<T> n = new Node<T>(value);

		if (this.first == null) {
			this.first = n;
			this.last = n;
		} else {
			this.first.next = n;
			this.first = n;
		}
	}

	/**
	 * Gibt einen Iterator für die aktuelle Liste zurück.
	 */
	@Override
	public Iterator<T> iterator() {
		// Bei jedem Aufruf dieser Methode geben wir einen *neuen* Iterator zurück,
		// welcher immer am Beginn der Liste startet:
		return new LinkedListIterator<T>(this.last);
	}
}

/**
 * Unsere Iterator-Klasse, mit welcher man über unsere LinkedList iterieren kann.
 * Diese Klasse implementiert das `Iterator<T>` Interface. Dadurch können wir auf
 * einem Interator-Objekt `hasNext` und `next` aufrufen (siehe while-Schlaufe weiter unten)
 * @author remo
 *
 * @param <T> Der Typ der Elemente in der Liste, über welche wir iterieren.
 */
class LinkedListIterator<T> implements Iterator<T> {

	// Speichert den am nächsten auszugebenden Node/Value:
	private Node<T> _next;

	public LinkedListIterator(Node<T> first) {
		// Der initial nächste Node ist der erste Node der Liste:
		this._next = first;
	}

	/**
	 * Gibt true zurück, falls die Liste noch Nodes/Values hat,
	 * welche noch nicht iteriert wurden
	 */
	@Override
	public boolean hasNext() {
		return this._next != null;
	}

	/**
	 * Gibt den nächsten noch nicht iterierten Value in der Liste zurück.
	 * Wirft einen Fehler (NullPointerException), falls der Iterator bereits am Ende der Liste ist.
	 * Es wird erwartet, dass zuerst mit `hasNext` überprüft wird!
	 */
	@Override
	public T next() {
		// nächster Value:
		T value = this._next.value;
		// einen Node weiterspringen:
		this._next = this._next.next;

		return value;
	}

}

public class Iterators {
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(5);
		linkedList.add(8);

		// wir können nun hier unsere Liste übergeben, weil sie das `Iterable<T>` Interface implementiert:
		print_list(linkedList);

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(30);
		arrayList.add(50);
		arrayList.add(80);

		// ArrayList (und viele andere Java-Collections) implementieren `Iterable<T>` auch!:
		print_list(arrayList);
	}

	// Diese Methode kann nun für alle Objekte verwendet werden,
	// welche iterierbar sind, heisst: das `Iterable<T>` Interface implementieren:
	// Von welcher Klasse das gegebene Objekt `list` wirklich stammt, interessiert unsere Methode hier gar nicht.
	// Das ist die Stärke von Interfaces!
	public static void print_list(Iterable<Integer> list) {
		// Wichtig! wir erstellen nur einen Iterator.
		// Häufiger Fehler: Pro Loop-Durchlauf einen neuen Iterator erstellen => Jeder neue Iterator startet immer wieder
		// am Beginn der Liste (nicht was wir hier wollen):
		Iterator<Integer> iterator = list.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		// der "for(Type item : list) {}" - Syntax von Java basiert sogar auf dem Interable-Interface.
		// das heisst: statt dem while-Loop oben können wir auch schreiben:
		for(Integer value : list) {
			System.out.println(value);
		}
	}
}
