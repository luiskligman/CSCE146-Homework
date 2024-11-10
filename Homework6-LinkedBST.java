public class LinkedBST <T extends Comparable<T>> extends Shape {
	
	class Node {
		T data;
		Node leftChild;
		Node rightChild;
		public Node(T aData) {
			data = aData;
			leftChild = rightChild = null;
		}
	}
	
	public Node root; //Head
	
	public LinkedBST() {
		root = null;
	}
	
	public void add(T aData) {
		if(root == null) //Means tree is not made
			root = new Node(aData);
		else
			add(root,aData);
	}
	
	private Node add(Node aNode, T aData) {
		if(aNode == null) //Recursively calling method until next null value "leaf" is found
			aNode = new Node(aData);
		else if(aData.compareTo(aNode.data) < 0 ) //GO LEFT
			aNode.leftChild = add(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data) > 0) //Go RIGHT
			aNode.rightChild = add(aNode.rightChild,aData);
		return aNode;
	}
	
	public void printPreorder() {
		printPreorder(root);
	}
	
	private void printPreorder(Node aNode) {
		if(aNode == null)
			return;
		System.out.println(aNode.data); //PROCESS
		printPreorder(aNode.leftChild); //LEFT
		printPreorder(aNode.rightChild); //RIGHT
	}
	
	public void printInorder() {
		printInorder(root);
	}
	
	private void printInorder(Node aNode) {
		if(aNode == null) 
			return;
		printInorder(aNode.leftChild); //LEFT
		System.out.println(aNode.data); //PROCESS
		printInorder(aNode.rightChild); //RIGHT
	}
	
	public void printPostorder() {
		printPostorder(root);
	}
	
	private void printPostorder(Node aNode ) {
		if(aNode == null)
			return;
		printPostorder(aNode.leftChild); //LEFT
		printPostorder(aNode.rightChild); //RIGHT
		System.out.println(aNode.data); //PROCESS
	}
	
	public boolean search(T aData) {
		return search(root, aData);
	}
	
	private boolean search(Node aNode, T aData) {
		if(aNode == null)
			return false;
		else if(aData.compareTo(aNode.data) < 0 ) //GO LEFT
			return search(aNode.leftChild, aData);
		else if(aData.compareTo(aNode.data) > 0 ) //GO RIGHT
			return search(aNode.rightChild, aData);
		else 
			return true;
	}
	
	public void remove(Node aNode) {
		root = remove(root, aNode.data);
	}
	
	public void remove(T aData) {
		root = remove(root, aData);
	}
	
	private Node remove(Node aNode, T aData) {
		//Find the node
		if(aNode == null)
			return null;
		else if(aData.compareTo(aNode.data) < 0)
			aNode.leftChild = remove(aNode.leftChild, aData);
		else if(aData.compareTo(aNode.data) > 0) 
			aNode.rightChild = remove(aNode.rightChild, aData);
		else { //Found it
			if(aNode.rightChild == null) 
				return aNode.leftChild;
			else if(aNode.leftChild == null)
				return aNode.rightChild;
			Node temp = findMinInTree(aNode.rightChild);
			aNode.data = temp.data;
			aNode.rightChild = remove(aNode.rightChild, temp.data);
		}
		return aNode;
	}
	
	private Node findMinInTree(Node aNode) {
		if(aNode == null) 
			return null;
		else if(aNode.leftChild == null)
			return aNode;
		else
			return findMinInTree(aNode.leftChild);
	}
	
	public void findMax() {
		//return findMaxInTree(root);
		System.out.println("The shape with the max area: "+findMaxInTree(root).data);
	}
	
	private Node findMaxInTree(Node aNode) {
		if(aNode == null) 
			return null;
		else if(aNode.rightChild == null)
			return aNode;
		else
			return findMaxInTree(aNode.rightChild);
	}
	
	public void removeGreatherThan(int aMax) {
		root = removeGreaterThan(root, aMax);
	}
	
	public Node removeGreaterThan(Node aNode, int aMax) {
		if(aNode == null)
			return null;

		System.out.println(((Shape) aNode.data).getArea());
		
//FYI I tried to use a while loop instead of 3 ifs and it just caused a infinite loop, no clue why but it would get stuck removing my last value 254
		// If the current shape's area is greater than specified area, remove it
		if(((Shape) aNode.data).getArea() > aMax) {
			// If the node's data is greater than aMax, remove it
			remove(aNode);
			if(((Shape) aNode.data).getArea() > aMax) {
				// If the node's data is greater than aMax, remove it
				remove(aNode);
				if(((Shape) aNode.data).getArea() > aMax) {
					// If the node's data is greater than aMax, remove it
					remove(aNode);
				}
			}
		}
		
		//Recursively check right & left child 
		removeGreaterThan(aNode.leftChild, aMax);
		removeGreaterThan(aNode.rightChild, aMax);
		return aNode;
	}
}
