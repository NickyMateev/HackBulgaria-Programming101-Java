import java.util.ArrayList;
import java.util.Arrays;

public class RotateCollection {
	
	public static <T> void rotate(ArrayList<T> collection, int rotateStep){
		
		if(rotateStep == 0 || collection.size() == 0)
			return;
		
		T tempVar1 = null, tempVar2 = null;
		
		while(rotateStep != 0){

			if(rotateStep > 0){
				for (int i = 0; i < collection.size(); i++) {
				
					if(i == 0){
						tempVar1 = collection.get(i);
						collection.set(i, collection.get(collection.size() - 1));
					} else {
						tempVar2 = collection.get(i);
						collection.set(i, tempVar1);
						tempVar1 = tempVar2;
					}
				}
				
				rotateStep--;
			} else {
				
				for (int i = collection.size() - 1; i >= 0; i--) {
					if(i == collection.size() - 1){
						tempVar1 = collection.get(i);
						collection.set(i, collection.get(0));
					} else {
						tempVar2 = collection.get(i);
						collection.set(i, tempVar1);
						tempVar1 = tempVar2;
					}
				}
				
				rotateStep++;
			}
		}
	}

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(1,2,3,4,5));
		
		rotate(list, 1);
		rotate(list, -2);

		System.out.println(list); // [2,3,4,5,1]
	}

}
