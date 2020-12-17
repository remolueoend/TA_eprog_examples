package week14.bonus;

import java.util.Iterator;

class MyNode<T> implements MyListNode<T> {

	private T nodeValue;
	private MyListNode<T> nextNode;

	public MyNode(T value) {
		this.nodeValue = value;
	}

	@Override
	public T value() {
		return nodeValue;
	}

	@Override
	public void setValue(T value) {
		this.nodeValue = value;

	}

	@Override
	public boolean hasNext() {
		return this.nextNode != null;
	}

	@Override
	public MyListNode<T> next() {
		return this.nextNode;
	}

	@Override
	public void setNext(MyListNode<T> node) {
		this.nextNode = node;
	}

}

class MyListIterator<T> implements Iterator<T> {
	private MyListNode<T> next;

	public MyListIterator(MyListNode<T> first) {
		this.next = first;
	}

	@Override
	public boolean hasNext() {
		return this.next != null;
	}

	@Override
	public T next() {
		T value = this.next.value();
		this.next = this.next.next();
		return value;
	}
}

public class MyListImpl<T> implements MyList<T> {
	private MyListNode<T> first;
	private MyListNode<T> last;
	private int size = 0;

	@Override
	public T get(int index) {
		if (this.first instanceof MyNode) {
			MyNode<T> n = (MyNode<T>) this.first;
		}
		return this.getNode(index).value();
	}

	@Override
	public MyListNode<T> getNode(int index) {
		MyListNode<T> node = this.first;
		for (int i = 0; i < index; i++) {
			node = node.next();
		}
		return node;
	}

	@Override
	public void set(int index, T value) {
		this.getNode(index).setValue(value);
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public void addFirst(T value) {
		MyNode<T> node = new MyNode<T>(value);
		if (this.isEmpty()) {
			this.first = this.last = node;
		} else {
			node.setNext(this.first);
			this.first = node;
		}
		this.size++;
	}

	@Override
	public void addLast(T value) {
		MyNode<T> node = new MyNode<T>(value);
		if (this.isEmpty()) {
			this.first = this.last = node;
		} else {
			this.last.setNext(node);
			this.last = node;
		}
		this.size++;
	}

	@Override
	public void addAll(MyList<T> other) {
		if (other.isEmpty())
			return;

		MyListNode<T> otherFirst = other.getNode(0);
		MyListNode<T> otherLast = other.getNode(other.getSize() - 1); // Laufzeit hängt von Implementation von other ab!

		if (this.isEmpty()) {
			this.first = other.getNode(0);
			this.last = otherLast;
		} else {
			this.last.setNext(otherFirst);
			this.last = otherLast;
		}
		this.size += other.getSize();
	}

	@Override
	public T removeFirst() {
		if (this.isEmpty()) {
			throw new IllegalAccessError("list is empty");
		}
		T value = this.first.value();
		this.first = this.first.next();
		this.size--;
		if (this.isEmpty()) {
			this.last = null;
		}
		return value;
	}

	@Override
	public T removeLast() {
		if (this.isEmpty()) {
			throw new IllegalAccessError("list is empty");
		}
		MyListNode<T> prev = null;
		MyListNode<T> curr = this.first;
		while (curr != this.last) {
			prev = curr;
			curr = curr.next();
		}
		if (prev == null) {
			this.first = this.last = null;
		} else {
			prev.setNext(null);
			this.last = prev;
		}
		this.size--;
		return curr.value();
	}

	@Override
	public void clear() {
		this.first = this.last = null;
		this.size = 0;

	}

	@Override
	public Iterator<T> iterator() {
		return new MyListIterator<T>(this.first);
	}

	public static void main(String[] args) {
		MyListImpl<String> list = new MyListImpl<>();
		Iterator<String> it = list.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
