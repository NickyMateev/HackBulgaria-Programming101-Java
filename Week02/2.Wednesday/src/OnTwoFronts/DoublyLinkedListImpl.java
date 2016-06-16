package OnTwoFronts;

public class DoublyLinkedListImpl implements DoublyLinkedList {

	private Node headnode;
	private int length;
	
	private class Node{
		
		private int value;
		private Node previous;
		private Node next;
			
		public Node(int value, Node previous){
			this.value = value;
			this.previous = previous;
			next = null;
		}
	}
	
	public DoublyLinkedListImpl() {
	
		headnode = null;
		length = 0;
	}
	
	@Override
	public void add(int element) {
	
		if(headnode == null)
			headnode = new Node(element, null);
		else {
			
			Node node = headnode;
			while(node.next != null)
				node = node.next;
			
			node.next = new Node(element, node);		
		}
		
		length++;
	}

	@Override
	public void remove(int element) {
	
		if(headnode == null)
			return;
		
		if(headnode.value == element)
			headnode = headnode.next;
		else {
		
			Node node = headnode;
			while(node.next.value != element && node.next.next != null)
				node = node.next;
		
			if(node.next.value != element && node.next.next == null)
				return;
		
			node.next = node.next.next;
		}
		
		length--;
	}

	@Override
	public int size() {
		return length;
	}

	@Override
	public int get(int elementIndex) {
	
		if(headnode == null)
			return Integer.MIN_VALUE; // some default value if the list turns out to be empty

		Node node = headnode;
		while(elementIndex != 0 && node.next != null){	
			node = node.next;
			elementIndex--;
		}
		
		if(elementIndex != 0)
			throw new ArrayIndexOutOfBoundsException("ERROR: Invalid index passed!");
		
		return node.value;
	}

	@Override
	public int getHead() {
	
		if(headnode == null)
			return Integer.MIN_VALUE; // some default value if the list turns out to be empty
		
		return headnode.value;
	}

	@Override
	public int getTail() {
	
		if(headnode == null)
			return Integer.MIN_VALUE; // some default value if the list turns out to be empty
		
		Node node = headnode;
		while(node.next != null)
			node = node.next;
		
		return node.value;
	}

}
