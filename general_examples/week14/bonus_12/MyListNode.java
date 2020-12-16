package bonus_12;


public interface MyListNode<T> {
	
	/** Returns the value stored in the node. */
	public T value(); 
	
	/** Sets the value stored in the node. */
	public void setValue(T value);
	
	/** Returns false iff this is the last node of the list. */
	public boolean hasNext();
	
	/** Returns next node. */
	public MyListNode<T> next();
	
	/** Sets the next node. */
	public void setNext(MyListNode<T> node);
}
