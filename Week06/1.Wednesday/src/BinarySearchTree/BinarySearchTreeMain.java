
public class BinarySearchTreeMain {
	
	public static void main(String[] args) {
		
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		
		tree.add(10);
		tree.add(6);
		tree.add(20);
		tree.add(2);
		tree.add(8);
		tree.add(14);
		tree.add(32);
		tree.add(12);
		
		System.out.println(tree.search(32)); // true
		tree.remove(32);
		System.out.println(tree.search(32)); // false 
		
		try {
			System.out.println("Root node's depth: " + tree.calculateDepth(10));
			System.out.println("Root node's height: " + tree.calculateHeight(10));
		} catch (NodeAbsentException e) {
			// do nothing
		}
	}
}
