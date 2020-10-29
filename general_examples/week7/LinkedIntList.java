class IntNode {
	public int value;
	public IntNode next;
	
	IntNode(int value) {
		this.value = value;
	}
}

public class LinkedIntList {
	// listen methoden
	public IntNode first;
	public IntNode last;
	
	public void addFirst(int value) {
		if(this.first == null) {
			IntNode newNode = new IntNode(value);
			this.first = newNode;
			this.last = newNode;
		} else {
			IntNode newNode = new IntNode(value);
			newNode.next = this.first;
			this.first = newNode;
		}
	}
}

class Program {
	public static void main() {
		LinkedIntList myList = new LinkedIntList();
		myList.addFirst(3);
	}
}
