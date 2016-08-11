import java.util.List;

public abstract class FunnyArraySorter <T extends Comparable<T>> {
	
	private static Integer pivot;

	public FunnyArraySorter(Integer pivot) {
		FunnyArraySorter.pivot = pivot;
	}
	
	public abstract void reverseSort(List<T> list);		

	public abstract void pivotSubstractionSort(List<T> list);		

	public abstract void pivotDivisionSort(List<T> list);
	
}
