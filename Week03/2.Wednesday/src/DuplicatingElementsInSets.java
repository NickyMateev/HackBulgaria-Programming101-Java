import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class DuplicatingElementsInSets {

	public static <T> Set<T> duplicates(ArrayList<Set<T>> sets) {

		Set<T> resultSet = new TreeSet<>();

		int indexOfShortestSet = 0;
		for (int i = 1; i < sets.size(); i++) {
			if (sets.get(i).size() < sets.get(indexOfShortestSet).size())
				indexOfShortestSet = i;
		}

		Iterator<T> iter = sets.get(indexOfShortestSet).iterator();

		boolean foundDuplicate;
		while (iter.hasNext()) {
			foundDuplicate = true;
			T curElem = iter.next();

			for (Set<T> set : sets) {
				if (!set.contains(curElem)) {
					foundDuplicate = false;
					break;
				}
			}

			if (foundDuplicate)
				resultSet.add(curElem);
		}

		return resultSet;
	}

	public static void main(String[] args) {

		Set<Integer> set1 = new TreeSet<>();
		set1.addAll(Arrays.asList(1, 2, 3, 4, 5));

		Set<Integer> set2 = new TreeSet<>();
		set2.addAll(Arrays.asList(4, 5, 6));

		Set<Integer> set3 = new TreeSet<>();
		set3.addAll(Arrays.asList(5, 6, 7));

		ArrayList<Set<Integer>> sets = new ArrayList<>();
		sets.add(set1);
		sets.add(set2);
		sets.add(set3);

		Set<Integer> result = duplicates(sets);
		System.out.println(result); // [5]
	}

}
