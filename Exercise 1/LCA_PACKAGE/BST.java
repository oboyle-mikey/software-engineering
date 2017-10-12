package LCA_PACKAGE;

public class BST <Key extends Comparable<Key>>{
	
	//Private class representing the nodes in the binary tree, the ancestry will be 
	//based off the parameters passed representing keys

	public class Node{
		Node left, right;
		Key key;
		
		public Node(Key key){
			this.key = key;
		}
	}
	
	//Root node that will be referenced in the tree as the node with no parent
	
	public Node root;
	
	//Default constructor - NB *** possible default to test data in construct???
	
	public BST(){
		
	}
	
	//Put method for inserting nodes into the tree, recursive using compare to implement 
	// an ordered binary search tree
	
	public void put(Key key){
		root = put(root, key);
	}

	private Node put(Node x, Key key){
		if(x==null){
			return new Node(key);
		}
		int cmp = key.compareTo(x.key);
		if(cmp<0){
			x.left = put(x.left, key);
		}else if(cmp>0){
			x.right = put(x.right, key);
		}
		return x;
	}
	
	
	
	
}
