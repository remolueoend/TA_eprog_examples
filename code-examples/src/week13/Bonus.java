package week13;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * ACHTUNG!! Dieser Code ist (noch) keine vollständige Lösung! Es geht hier nur
 * mal darum, die grössten Knackpunkte zu lösen
 */

public class Bonus {
	public static void main(String[] args) {
		School hogwarts = new School();

		House hufflepuff = hogwarts.createHouse("Hufflepuff");
		House ravenclaw = hogwarts.createHouse("Ravenclaw");

		Student hannah = new Student("Hannah", "Abbott");

		hufflepuff.assign(hannah);

		hannah.givePoints(10);
	}
}

/**
 * Konzept:
 * 1. Die Schule verwaltet die Zuweisungen von Schülern zu Häusern.
 * 2. Jedes Haus kennt seine Schule
 * 3. Jeder Student kennt seine Schule (und kann da nachfragen, zu welchem Haus sie/er zugewiesen ist) 
 */
class School {
	// Speichert die Liste aller erstellten Häuser
	private ArrayList<House> houses;
	// Speichert das Mapping von Studenten zum jeweiligen Haus, dem sie zugewiesen
	// wurden
	private HashMap<Student, House> studentAssignments;

	public School() {
		this.houses = new ArrayList<House>();
		this.studentAssignments = new HashMap<Student, House>();
	}

	public House createHouse(String name) {
		for (House house : this.houses) {
			if (house.name() == name) {
				// Wir können hier abbrechen, sobald wir ein Haus mit dem gleichen Namen gefunden haben:
				throw new IllegalArgumentException("Es existiert bereits ein Haus mit dem Namen " + name);
			}
		}

		House newHouse = new House(name, this);
		this.houses.add(newHouse);

		return newHouse;
	}

	public House winner() {
		House winner = null;

		if (this.houses.isEmpty()) {
			throw new IllegalArgumentException("Es wurde kein Haus erstellt");
		}

		for (House house : this.houses) {
			if (winner == null || winner.points() < house.points()) {
				winner = house;
			}
		}

		return winner;
	}

	/**
	 * Gibt das Haus zurück, zu dem der gegebene Student assigned wurde. Wenn der
	 * Student noch nirgends assigned wurde, gibt die Methode null zurück.
	 * 
	 * @param student
	 * @return
	 */
	public House getHouseOfStudent(Student student) {
		if (this.studentAssignments.containsKey(student)) {
			return this.studentAssignments.get(student);
		} else {
			return null;
		}
	}

	/**
	 * Fügt den gegebenen Studenten dem gegebenen Haus hinzu. Schmeisst einen
	 * Fehler, falls der Student bereits bei einem Haus zugeteilt ist.
	 * 
	 * @param house
	 * @param student
	 */
	public void assignStudent(House house, Student student) {
		if (this.studentAssignments.containsKey(student)) {
			throw new IllegalArgumentException("Student " + student.toString() + "wurde bereits einem Haus zugewiesen");
		}

		this.studentAssignments.put(student, house);
	}
}

class House {
	private String _name;
	private School school;
	// Attribut ist privat und kann von ausserhalb der Klasse weder gelesen noch geschrieben werden.
	// Stattdessen muss der Getter 'points()' und der Setter 'addPoints(int)' verwendet werden:
	private int _points;

	public House(String name) {
		// wir rufen hier den Konstruktor weiter unten auf, mit house=null
		// dieser Konstruktor wird zwar hier nicht verwendet, ist aber vorgegeben und darf nicht einfach gelöscht werden.
		this(name, null);
	}

	/**
	 * Erweiterter Konstruktor, welcher auch die Schule dieses Hauses erwartet.
	 */
	public House(String name, School school) {
		this._name = name;
		this.school = school;
		this._points = 0;
	}

	public String name() {
		return this._name;
	}

	// Getter für Attribut '_points'
	public int points() {
		return this._points;
	}

	// Setter für Attribut '_points'. Stellt sicher, dass keine ungültige Anzahl Punkte geschrieben werden kann:
	public void addPoints(int points) {
		// minimale Anzahl Punkte eines Hauses ist 0:
		this._points = Math.max(0, this._points + points);
	}

	public void assign(Student student) {
		student.setSchool(school);
		this.school.assignStudent(this, student);
	}
}

class Student {
	private String _firstName;
	private String _lastName;

	// aktuelle Schule des Studenten
	private School school;

	public Student(String firstName, String lastName) {
		this._firstName = firstName;
		this._lastName = lastName;
		// nicht nötig, aber zur Klarifikation: der Student hat initial keine Schule:
		this.school = null;
	}

	public String firstName() {
		return this._firstName;
	}

	public String lastName() {
		return this._lastName;
	}

	public void givePoints(int points) {
		// wir müssen zuerst schauen, ob der aktuelle Student auch Teil einer Schule/eines Hauses ist.
		// Falls ja, fügen wir die Punkte dem Haus des aktuellen Studenten zu:
		if (this.school != null) {
			House currentHouse = this.school.getHouseOfStudent(this);
			if (currentHouse != null) {
				currentHouse.addPoints(points);
			}
		}
	}

	/**
	 * Setzt die Schule dieses Studierenden
	 * 
	 * @param house
	 */
	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return this.firstName() + " " + this.lastName();
	}
}