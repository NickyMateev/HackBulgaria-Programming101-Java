package MrListStack;

import OnTwoFronts.DoublyLinkedListImpl;
import StackEm.Stack;

public class ListStack implements Stack{

	private DoublyLinkedListImpl stack;
	
	public ListStack(){
		
		stack = new DoublyLinkedListImpl();
	}

	@Override
	public void push(int element) {
	
		if(!isDuplicate(element))
			stack.add(element);
		else
			System.out.println(element + " is already in the stack. Cannot push the same element again!");
	}

	@Override
	public int peek() {
		
		if(isEmpty())
			return Integer.MIN_VALUE; // in case the list is empty return this(exception is also an option)
		
		return stack.get(stack.size() - 1);
	}

	@Override
	public void pop() {
	
		if(isEmpty())
			return;
		
		stack.remove(peek());
	}

	@Override
	public int getLength() {
			
		return stack.size();
	}

	@Override
	public void clear() {
		while(!isEmpty())
			stack.remove(peek());
	}

	@Override
	public boolean isEmpty() {
		return getLength() == 0;
	}

	@Override
	public boolean isDuplicate(int element) {
			
		for (int i = 0; i < getLength(); i++)
			if(stack.get(i) == element)
				return true;
		
		return false;
	}

}
