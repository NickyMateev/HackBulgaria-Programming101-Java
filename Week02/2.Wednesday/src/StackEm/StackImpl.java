package StackEm;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class StackImpl implements Stack{

	private ArrayList<Integer> stack;
	private int length;
	
	public StackImpl(){
		
		stack = new ArrayList<Integer>();
		length = 0;
	}
	
	@Override
	public void push(int element) {
		
		if(!isDuplicate(element)){
			stack.add(element);
			length++;
		} else
			System.out.println(element + " is already in the stack. Cannot push the same element again!");
	}
	@Override
	public int peek() {
		
		if(length == 0)
			throw new InvalidParameterException("ERROR: The stack is empty.");
		
		return stack.get(length - 1);
	}
	@Override
	public void pop() {
		
		if(length == 0)
			return;
			
		stack.remove(length - 1);
		length--;
	}
	@Override
	public int getLength() {
		return length;
	}
	@Override
	public void clear() {
		stack.clear();
		length = 0;
	}
	@Override
	public boolean isEmpty() {
		return length == 0;
	}

	@Override
	public boolean isDuplicate(int element) {
	
		if(stack.contains(element))
			return true;
		else
			return false;
	}	

}
