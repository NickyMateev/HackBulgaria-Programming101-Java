import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FunnyArraySorterMain {
	
public static void main(String[] args) {
		
		Integer testPivot = new Integer(2);
		FunnyArraySorter<Integer> sorter = new FunnyArraySorter<Integer>(testPivot){

			@Override
			public void reverseSort(List<Integer> list) {
				Collections.reverse(list);
			}

			@Override
			public void pivotSubstractionSort(List<Integer> list) {
				
				Collections.sort(list, new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						Integer difference = o1 - testPivot;
						if(difference > o2){
							return 1;
						} else if (difference == o2){
							return 0;
						} else {
							return -1;
						}
					}
				});
			}

			@Override
			public void pivotDivisionSort(List<Integer> list) {
				
				Collections.sort(list, new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						Integer division =  o1 / testPivot;
						if(division > o2){
							return 1;
						} else if (division == o2){
							return 0;
						} else {
							return -1;
						}
					}
				});
			}
		};
		
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		sorter.reverseSort(list);
		System.out.println("Reverse sort: " + list);

		sorter.pivotSubstractionSort(list);
		System.out.println("Pivot(" + testPivot + ") substraction sort:" + list);
		
		sorter.pivotDivisionSort(list);
		System.out.println("Pivot(" + testPivot + ") division sort:" + list);

	}

}
