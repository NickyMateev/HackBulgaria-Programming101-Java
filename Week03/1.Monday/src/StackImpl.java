import java.util.ArrayList;

public class StackImpl<T> implements Stack<T> {

	private ArrayList<T> stack;
	
	public StackImpl(){
		stack = new ArrayList<>();
	}

	@Override
	public void push(T elem){
		if(!isDuplicate(elem))
			stack.add(elem);
		else
			System.out.println(elem + " is already in the stack. Cannot push the same element again!");
	}
	
	@Override
	public T peek(){
		return stack.get(stack.size() - 1);
	}
	
	@Override
	public void pop(){
		stack.remove(stack.size() - 1);
	}
	
	@Override
	public int getLength(){
		return stack.size();
	}
	
	@Override
	public void clear(){
		stack.clear();
	}
	
	@Override
	public boolean isEmpty(){
		return stack.size() == 0;
	}
	
	@Override
	public boolean isDuplicate(T elem){
		return stack.contains(elem);
	}	
}