
public interface Stack<T> {

	public void push(T elem);
	public T peek();
	public void pop();
	
	public int getLength();
	public void clear();
	public boolean isEmpty();	
	
	public boolean isDuplicate(T elem);
}
