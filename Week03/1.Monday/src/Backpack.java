
public class Backpack<T> {
	
	private T item;
	
	public Backpack(T item){
		this.item = item;
	}
	
	public T get(){
		return item;
	}
	
	public void set(T item){
		this.item = item;
	}
	
}
