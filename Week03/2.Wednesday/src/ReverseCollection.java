import java.util.ArrayList;

public class ReverseCollection {
	
	public static <T> void reverse(ArrayList<T> list){
	
		int size = list.size();
		T temp;
		
		for (int i = 0; i < size / 2; i++){
			temp = list.get(i);
			list.set(i, list.get(size - 1 - i));
			list.set(size - 1 - i, temp);
		}
	}

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		reverse(list);
		System.out.println(list);
	}

}
