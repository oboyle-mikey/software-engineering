package LCA_PACKAGE;

public class BST <Key extends Comparable<Key>>{
	
	//Private class representing the nodes in the binary tree, the ancestry will be 
	//based off the parameters passed representing keys

	private class Node{
		Node left, right;
		Key key;
		
		public Node(Key key){
			this.key = key;
		}
	}
	
	//Root node that will be referenced in the tree as the node with no parent
	
	private Node root;
	
	//Default constructor - NB *** possible default to test data in construct???
	
	public BST(){
		
	}
	
	
	
	
	
	
}
