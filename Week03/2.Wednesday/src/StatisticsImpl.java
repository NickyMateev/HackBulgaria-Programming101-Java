import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StatisticsImpl<E extends Number & Comparable<E>> implements Statistics {

	private ArrayList<E> elements = new ArrayList<>();

	public void add(E number) {
		elements.add(number);
	}

	public void remove(int index) {
		if (index < 0 || index >= size())
			return;
		else
			elements.remove(index);
	}

	@Override
	public String toString() {
		return elements.toString();
	}

	public int size() {
		return elements.size();
	}

	@Override
	public double getMean() {

		double sum = 0;
		for (E e : elements)
			sum += e.doubleValue();

		return sum / size();
	}

	@Override
	public double getMedian() {

		ArrayList<E> temp = new ArrayList<>();
		temp.addAll(elements);
		Collections.sort(temp);

		if (size() % 2 != 0)
			return temp.get(size() / 2).doubleValue();
		else
			return (temp.get(size() / 2).doubleValue() + temp.get(size() / 2 - 1).doubleValue()) / 2;
	}

	@Override
	public double getMode() {

		if (size() == 0)
			return Double.MIN_VALUE; // return some weird value if the list is
										// empty
		else if (size() == 1)
			return elements.get(0).doubleValue();

		HashMap<E, Integer> map = new HashMap<>();

		for (int i = 0; i < size(); i++) {

			E curElem = elements.get(i);

			if (map.containsKey(curElem))
				map.put(curElem, map.get(curElem) + 1);
			else
				map.put(curElem, 1);
		}

		E mode = null;
		int modeCount = Integer.MIN_VALUE;

		int pastCount = Integer.MIN_VALUE;
		boolean modeExists = false;

		for (Map.Entry<E, Integer> e : map.entrySet()) {

			if (pastCount != Integer.MIN_VALUE) // this means this isn't the
												// first iteration
				if (pastCount != e.getValue()) // comparing pastCount and
												// curCount to determine if a
												// mode exists at all
					modeExists = true;

			if (e.getValue() > modeCount) {
				modeCount = e.getValue();
				mode = e.getKey();
			}

			pastCount = e.getValue();
		}

		if (modeExists)
			return mode.doubleValue();
		else
			return Double.MIN_VALUE;
	}

	@Override
	public double getRange() {

		if (size() == 0)
			return 0;

		E min = elements.get(0), max = elements.get(0);
		for (int i = 1; i < size(); i++) {

			E curElem = elements.get(i);

			if (curElem.compareTo(min) < 0)
				min = curElem;

			if (curElem.compareTo(max) > 0)
				max = curElem;
		}

		return max.doubleValue() - min.doubleValue();
	}

}
