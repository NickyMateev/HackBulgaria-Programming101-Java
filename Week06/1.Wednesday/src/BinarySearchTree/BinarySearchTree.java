
public class BinarySearchTree<T extends Comparable<T>> {

	private Node headNode = new Node();

	private class Node {

		private T value;
		private Node leftChild = null;
		private Node rightChild = null;

		public Node() {
			value = null;
		}

		public Node(T value) {
			this.value = value;
		}

	}

	public void add(T value) {

		if (headNode.value == null) {
			headNode.value = value;
			return;
		}

		Node node = headNode;

		while (true) {

			if (value.compareTo(node.value) < 0) {
				if (node.leftChild == null) {
					node.leftChild = new Node(value);
					return;
				} else {
					node = node.leftChild;
				}
			} else if (value.compareTo(node.value) > 0) {
				if (node.rightChild == null) {
					node.rightChild = new Node(value);
					return;
				} else {
					node = node.rightChild;
				}
			} else {
				return; // the value is already in the tree
			}
		}
	}

	public boolean search(T value) {

		if (headNode.value == null) {
			return false;
		}

		Node node = headNode;

		while (true) {

			if (value.compareTo(node.value) < 0) {
				if (node.leftChild == null) {
					return false;
				} else {
					node = node.leftChild;
				}
			} else if (value.compareTo(node.value) > 0) {
				if (node.rightChild == null) {
					return false;
				} else {
					node = node.rightChild;
				}
			} else {
				return true;
			}
		}
	}

	// this method needs to be shortened in the future:
	public void remove(T value) {

		if (headNode.value == null) {
			return;
		}

		Node curNode = headNode;
		Node curLeftChild = headNode.leftChild;
		Node curRightChild = headNode.rightChild;

		while (true) {

			// if the value to be deleted is in the left subtree:
			if (value.compareTo(curNode.value) < 0) {

				if (curLeftChild == null) {
					return;
				}

				if (value.compareTo(curLeftChild.value) == 0) {
					if (curLeftChild.leftChild == null && curLeftChild.rightChild == null) {
						curNode.leftChild = null;
						return;
					} else if (curLeftChild.leftChild == null) {
						curNode.leftChild = curLeftChild.rightChild;
						return;
					} else if (curLeftChild.rightChild == null) {
						curNode.leftChild = curLeftChild.leftChild;
						return;
					} else { // curLeftChild.leftChild != null &&
								// curLeftChild.rightChild != null

						// Traversing the right subtree to find the smallest value to replace the one to be deleted
						Node tempNode = curLeftChild.rightChild;
						while (tempNode.leftChild == null) {

							if (tempNode.rightChild == null) {
								curNode.leftChild = curLeftChild.rightChild;
								curNode.leftChild.leftChild = curLeftChild.leftChild;
								return;
							}
							tempNode = tempNode.rightChild;
						}

						while (tempNode.leftChild.leftChild != null) {
							tempNode = tempNode.leftChild;
						}

						curLeftChild.value = tempNode.leftChild.value;
						tempNode.leftChild = null;

						return;
					}

				} else {
					curNode = curLeftChild;
					curLeftChild = curNode.leftChild;
					curRightChild = curNode.rightChild;
				}

			// if the value to be deleted is in the right subtree:
			} else if (value.compareTo(curNode.value) > 0) {

				if (curRightChild == null) {
					return;
				}

				if (value.compareTo(curRightChild.value) == 0) {
					if (curRightChild.leftChild == null && curRightChild.rightChild == null) {
						curNode.rightChild = null;
						return;
					} else if (curRightChild.leftChild == null) {
						curNode.rightChild = curRightChild.rightChild;
						return;
					} else if (curRightChild.rightChild == null) {
						curNode.rightChild = curRightChild.leftChild;
						return;
					} else { // curRightChild.leftChild != null &&
								// curRightChild.rightChild != null

						// Traversing the right subtree to find the smallest value to replace the one to be deleted
						Node tempNode = curRightChild.rightChild;
						while (tempNode.leftChild == null) {

							if (tempNode.rightChild == null) {
								
								curNode.rightChild = curRightChild.rightChild;
								curNode.rightChild.leftChild = curRightChild.leftChild;
								return;
							}
							tempNode = tempNode.rightChild;
						}

						while (tempNode.leftChild.leftChild != null) {
							tempNode = tempNode.leftChild;
						}

						curRightChild.value = tempNode.leftChild.value;
						tempNode.leftChild = null;

						return;
					}

				} else {
					curNode = curRightChild;
					curLeftChild = curNode.leftChild;
					curRightChild = curNode.rightChild;
				}

			// realistically, this case will be selected only in the beginning,
			// if the headnode's value turns out to be the one to be deleted:
			} else {
				if (headNode.leftChild == null && headNode.rightChild == null) {
					headNode.value = null;
					return;
				} else if (headNode.leftChild != null && headNode.rightChild == null) {
					headNode = headNode.leftChild;
					return;
				} else if (headNode.leftChild == null && headNode.rightChild != null) {
					headNode = headNode.rightChild;
					return;
				} else { // headNode.leftChild != null && headNode.rightChild != null

					// finding the smallest node value in the right subtree to replace the headnode
					Node tempNode = headNode.rightChild;
					
					while(tempNode.leftChild == null){
						
						if(tempNode.rightChild == null){
							
							headNode.rightChild.leftChild = headNode.leftChild;
							headNode = headNode.rightChild;
							return;
						}
						tempNode = tempNode.rightChild;
					}
					
					while(tempNode.leftChild.leftChild != null){
						tempNode = tempNode.leftChild;
					}
					
					headNode.value = tempNode.leftChild.value;
					tempNode.leftChild = null;

					return;
				}
			}
		}
	}
	
	public int calculateDepth(T nodeValue) throws NodeAbsentException{
		
		if (headNode.value == null) {
			throw new NodeAbsentException("ERROR: The tree does not contain this node.");
		}

		Node node = headNode;
		int depth = 0;

		while (true) {

			if (nodeValue.compareTo(node.value) < 0) {
				if (node.leftChild == null) {
					break;
				} else {
					depth++;
					node = node.leftChild;
				}
			} else if (nodeValue.compareTo(node.value) > 0) {
				if (node.rightChild == null) {
					break;
				} else {
					depth++;
					node = node.rightChild;
				}
			} else {
				return depth;
			}
		}
		
		
		throw new NodeAbsentException("ERROR: The tree does not contain this node.");
	}
	
	public int calculateHeight(T nodeValue) throws NodeAbsentException{
		
		
		if (headNode.value == null) {
			throw new NodeAbsentException("ERROR: The tree does not contain this node.");
		}

		Node node = headNode;

		while (true) {

			if (nodeValue.compareTo(node.value) < 0) {
				if (node.leftChild == null) {
					break;
				} else {
					node = node.leftChild;
				}
			} else if (nodeValue.compareTo(node.value) > 0) {
				if (node.rightChild == null) {
					break;
				} else {
					node = node.rightChild;
				}
			} else {
				return getHeight(node, 0);
			}
		}
		
		
		throw new NodeAbsentException("ERROR: The tree does not contain this node.");
	}
	
	private int getHeight(Node node, int height){
		
		int leftHeight = height, rightHeight = height;
		
		if(node.leftChild != null){
			leftHeight = getHeight(node.leftChild, height + 1);
		}
		if(node.rightChild != null){
			rightHeight = getHeight(node.rightChild, height + 1);
		}
		
		return leftHeight > rightHeight ? leftHeight : rightHeight;
	}
	
}
