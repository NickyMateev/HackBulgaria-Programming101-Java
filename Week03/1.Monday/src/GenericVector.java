import java.util.ArrayList;

public class GenericVector<E> {
	
	private ArrayList<E> list;
	
	public GenericVector(){
		list = new ArrayList<>();
	}
	
	public int length(){
		return list.size();
	}
	
	public boolean contains(E elem){
		return list.contains(elem);
	}
	
	public int indexOf(E elem){
		return list.indexOf(elem);
	}
	
	public void add(E elem){
		list.add(elem);
	}
	
	public void insertAt(int index, E elem){
		list.add(index, elem);
	}
	
	public void remove(E elem){
		list.remove(elem);
	}
	
	public void removeAt(int index){
		list.remove(index);
	}
	
	public void clear(){
		list.clear();
	}
	
	public E get(int index){
		if(index < 0 || index >= list.size())
			return null;
		else
			return list.get(index);
	}
	
	public void set(int index, E elem){
		if(index < 0 || index >= list.size())
			return;
		else
			list.set(index, elem);
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (int i = 0; i < list.size(); i++) {
			if(i == list.size() - 1)
				sb.append(list.get(i) + "]");
			else
				sb.append(list.get(i) + ", ");
		}
	
		return sb.toString();
	}

}