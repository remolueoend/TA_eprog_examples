package week14;
import java.util.Arrays;

/*
Eingabe: 'hans'
Annahme: Wir haben Zugriff auf alle Teilwörter von 'ans' (ohne h):
''     // der leere String ist auch ein Teilwort!
s
n
ns
a
as
an
ans

Wir kopieren nun diese Liste und fügen jedem Eintrag den Präfix 'h' hinzu:
h
hs
hn
hns
ha
has
han
hans

Ihr könnt euch selber vergewissern, dass diese zwei Listen kombiniert alle Teilwörter von 'hans' enthalten => Lösung gefunden!
Wir müssen jetzt nur noch rausfinden, wir wir diese zuvor als gegebene Liste von Teilwörtern von 'ans' erhalten.
=> Das Problem ist das Gleiche wie das Ursprungsproblem, nun aber für die Eingabe 'ans' statt 'hans'! => Rekursion anwenden:

FindeTeilwörter(eingabe)
	if länge(eingabe) == 0:
		return [""]                        // *Base-Case*: das einzige Teilwort eines leeren Strings ist der leere String selbst

	p <= der erste Buchstabe von 'eingabe' // das ist eine Zuweisung zur Variable p
	tail <= 'eingabe' ohne 'p'
	
	teilwörter <= FindeTeilWörter(tail)    // suche *rekursiv* alle Teilwörter von 'tail', also von der Eingabe ohne den ersten Buchstaben
	                                       // 'teilwörter' für 'ans' wäre also die im Beispiel oben angegebene Liste
	                                       
	for wort in teilwörter:                // Ergänze die Liste mit einer Kopie, wobei wir jedem Teilwort unser Präfix/erster Buchstabe vorne anhängen
		teilwörter.add(p + wort)
		
	return teilwörter
 */

public class Bonus8 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findeTeilworter("hans")));
	}

	public static String[] findeTeilworter(String eingabe) {
		if(eingabe.length() == 0) {
			return new String[] { "" };
		}
		
		char p = eingabe.charAt(0); // erster Buchstabe der Eingabe
		String[] kurze_teilwoerter = findeTeilworter(eingabe.substring(1)); // *rekursiver* Aufruf mit Eingabe ohne erstem Buchstaben
		
		String[] alle_teilwoerter = new String[kurze_teilwoerter.length * 2]; // Die finale Liste beinhaltet doppelt so viele Teilwörter
		// wir kopieren zuerst einmal die kürzeren Teilwörter (1. Liste) in das finale Array:
		System.arraycopy(kurze_teilwoerter, 0, alle_teilwoerter, 0, kurze_teilwoerter.length);
		// Jetzt fügen wir jedes Wort nochmals hinzu, mit dem Präfix 'p':
		for(int i = 0; i < kurze_teilwoerter.length; i++) {
			alle_teilwoerter[kurze_teilwoerter.length + i] = p + kurze_teilwoerter[i];
		}
		
		return alle_teilwoerter;
	}
}
