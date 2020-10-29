/**
 * Klasse welche einzelne Elemente einer Liste beschreibt.
 * Jedes Element in der Liste hat dabei einen Wert (value) dieses Eintrags,
 * und eine Referenz zum nächsten Eintrag/Node in der Liste (next).
 */
class IntNode {
    public int value;
    public IntNode next;

    IntNode(int value) {
        this.value = value;
    }
}

/**
 * Diese Klasse beschreibt eine Liste. Jede Liste sollte uns erlauben, Elemente hinzuzufügen (am Anfang der Liste oder am Ende),
 * Elemente zu entfernen, abzufragen ob die Liste leer ist etc. Diese Methoden werden also alle in dieser Klasse implementiert.
 */
public class LinkedIntList {
    /**
     * Der Wert des Attrbuts `first` jeder Liste ist das erste Element (der erste IntNode) dieser Liste.
     * Wenn die Liste leer ist, dann sollte `this.first == null` sein, also nichts zugewiesen haben.
     */
    public IntNode first;
    /**
     * Ähnlich wie `first` ist der Wert von `last` das letzte Element (der letzte IntNode) dieser Liste.
     * Wenn die Liste leer ist, sollte auch `this.last == null` sein. Falls die Liste nur ein einzigen Element hat,
     * ist dieses zugleich das Erste und das Letzte. Daher gilt dann `this.first == this last`.
     */
    public IntNode last;

    /**
     * Diese Methode fügt ein neues Element (einen neuen IntNode) mit dem gegebenen Wert *zum Beginn* der Liste hinzu.
     *
     * @param value Der Wert, welcher neu zur Liste hinzugefügt werden soll.
     */
    public void addFirst(int value) {
        // wir schauen zuerst, ob die Liste leer ist (`this.first == null`).
        // Falls ja, erstellen wir einen IntNode mit dem gegebenen Wert (`value`) und setzen `this.first` und `this.last`
        // auf diesen Node, da dieser ja nun das einzige und somit das erste *und* letzte Element der Liste ist:
        if(this.first == null) {
            IntNode newNode = new IntNode(value);
            this.first = newNode;
            this.last = newNode;
        } else {
            // Die Liste war nicht leer. Wir erstellen auch hier einen neuen Node und hängen ihn an den Beginn der Liste:
            IntNode newNode = new IntNode(value);

            // Dann setzen wir `next` vom neuen Node auf das aktuell erste Element der Liste (`newNode.next = this.first`):
            // 
            //                           this.first
            //                               |
            //                               v
            // +--------------+ next  +--------------+
            // |    newNode   | ----> |    xxxxx     | ----> ...
            // +--------------+       +--------------+
            newNode.next = this.first;
            // 2. Das erste Element der Liste soll nun unser neuer Node sein (`this.first = newNode`)
            //
            //     this.first
            //         |
            //         v
            // +--------------+ next  +--------------+
            // |    newNode   | ----> |    xxxxx     | ----> ...
            // +--------------+       +--------------+
            this.first = newNode;
        }
    }

    // Diese (static!) main Methode haben wir, damit wir unsere Klasse oben ein wenig testen können.
    public static void main(String[] args) {
        // Wir erstellen ein neues Listen-Objekt und fügen die Werte 3, 2 und 1 an den Beginn der Liste:
        LinkedIntList myList = new LinkedIntList();
        myList.addFirst(3);
        myList.addFirst(2);
        myList.addFirst(1);

        // Wir wollen nun über alle Elemente unsere Liste loopen und den Wert jedes Elements ausgeben.
        // Dazu starten wir mit dem ersten Element/Node (`myList.first`) und loopen solange, wie wir nächste Elemente/Nodes finden:
        IntNode current = myList.first;
        while(current != null) {
            // Wert des aktuellen Elements (IntNode) ausgeben:
            System.out.println(current.value);
            // Wir setzen nun als `current` das Folge-Element des aktuellen Elements und beginnen wieder von vorne.
            // Wenn `current` das letzte Element der Liste ist, wird `current.next == null` sein, und der Loop wird somit
            // abbrechen.
            current = current.next;
        }
    }
}
