import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FirstUnique {

	public static <E> E getFirstUnique(Collection<E> collection) {

		HashMap<E, Integer> map = new HashMap<>();
		Iterator<E> iter = collection.iterator();

		while (iter.hasNext()) {

			E curElem = iter.next();
			if (!map.containsKey(curElem))
				map.put(curElem, 1);
			else
				map.put(curElem, map.get(curElem) + 1);
		}

		for (Map.Entry<E, Integer> entry : map.entrySet())
			if (entry.getValue() == 1)
				return entry.getKey();

		return null;
	}

	public static void main(String[] args) {

		Collection<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 5, 4, 3, 1);
		System.out.println(getFirstUnique(ints)); // 2
	}

}
