package StackEm;

public interface Stack {

	public void push(int element);
	public int peek();
	public void pop();
	
	public int getLength();
	public void clear();
	public boolean isEmpty();
	
	public boolean isDuplicate(int element);  // needed for the invariant
}
