import java.util.ArrayList;

public class OnOffCollection <E> {

	private ArrayList<E> collection;
	
	public OnOffCollection(){
		collection = new ArrayList<E>();
	}
	
	public int size(){
		return collection.size();
	}
	
	public E get(int index){
		if(index >= collection.size())
			return null;
		
		return collection.get(index);
	}
	
	public void set(int index, E value){
		if(index > collection.size() || value == null)
			return;
		
		if(index == collection.size())
			
		
		collection.set(index, value);
	}
	
	public void add(E element){
		
		if(element == null)
			return;
		
		if(collection.contains(element)){
			collection.remove(element);
			return;
		}
			
		collection.add(collection.size(), element);
	}
	
	public E remove(int index){
		return collection.remove(index);
	}
	
	public boolean remove(E object){
		return collection.remove(object);
	}

	@Override
	public String toString() {
		return collection.toString(); 
	}
	
}