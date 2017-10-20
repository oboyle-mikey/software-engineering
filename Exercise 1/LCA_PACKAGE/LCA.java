package LCA_PACKAGE;

import java.util.ArrayList;

import LCA_PACKAGE.BST.Node;

public class LCA <Key extends Comparable<Key>>{

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
	//Lists to store paths for a given query of two keys

	public Node root;
	public ArrayList<Key> p1 = new ArrayList<>();
	public ArrayList<Key> p2 = new ArrayList<>();

	//Default constructor - NB *** possible default to test data in construct???

	public LCA(){

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

	//Get method to search a tree for a given key value
	
	public boolean get(Key key) { return get(root, key); }

	private boolean get(Node x, Key key) {
		if (x == null) return false;
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) return get(x.left, key);
		else if (cmp > 0) return get(x.right, key);
		else              return true;
	}


	public int lowestCommonAncestor(Key key1, Key key2){
		
		
		//Add path of nodes to each key to allow for comparison of common ancestor
		
		boolean keyOnePresent = findPath(root, key1, p1);
		boolean keyTwoPresent = findPath(root, key2, p2);
		
		//Return -1 for non present keys
		if(!keyOnePresent || !keyTwoPresent){
			return -1;
		}
		
		for(int i = 0; i<p1.size() && i<p2.size(); i++){
			// If there is a common ancestor element in both lists return it
			if(p1.get(i).equals(p2.get(i))){
				return (int)p1.get(i);
			}
		}
		
		//Return -1 if no ancestor
		return -1;
	}
	
	
	//Method to return the list, returns true if node found and populates global lists
	public boolean findPath(Node x, Key key1, ArrayList<Key>path){
		
		//Case tree empty or leaf found != search
		if(x==null){
			return false;
		}
		
		//Case key found
		if(x.key.equals(key1)){
			path.add(x.key);
			return true;
		}
		
		//Recurse left && right paths, adding nodes to list until above cases hold
		
		return false;
		
	}
}
