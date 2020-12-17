package week14.bonus;


import java.util.Iterator;

public interface MyList<T> {

	/** 
	 * Return the value at position 'index'. 
	 * Throws a NoSuchElementException if the argument exceeds the list size.
	 * */
	public T get(int index);
	
	/** 
	 * Return the list node at position 'index'. 
	 * Throws a NoSuchElementException if the argument exceeds the list size.
	 * */
	public MyListNode<T> getNode(int index);

	/** Set the value at position 'index' to 'value'. */
	public void set(int index, T value);

	/** Returns whether the list is empty (has no values). */
	public boolean isEmpty();

	/** Returns the size of the list. */
	public int getSize();

	/** Inserts 'value' at position 0 in the list. */
	public void addFirst(T value);

	/** Appends 'value' at the end of the list. */
	public void addLast(T value);
	
	/** Appends the 'other' list to the end of the list. */
	public void addAll(MyList<T> other);

	/** 
	 * Removes and returns the first value of the list. 
	 * Throws a NoSuchElementException if the List is empty.
	 * */
	public T removeFirst();

	/** 
	 * Removes and returns the last value of the list. 
	 * Throws a NoSuchElementException if the List is empty.
	 * */
	public T removeLast();

	/** Removes all values from the list, making the list empty. */
	public void clear();
	
	/** Returns an iterator to the data structure. */
	public Iterator<T> iterator();
}
