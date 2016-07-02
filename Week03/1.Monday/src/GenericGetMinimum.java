
public class GenericGetMinimum {

	public <T extends Comparable<T>> T getMin(T[] arr){
	
		if(arr.length == 0)
			return null;
		
		T min = arr[0];
		
		for(T elem : arr)
			if(elem.compareTo(min) < 0)
				min = elem;
		
		return min;
	}
}

