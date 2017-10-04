
public class LCA <Key extends Comparable<Key>, Value>{

	private Node root;

	private class Node {
		private Key key;
		private Value val;
		private Node left, right;
		private int N;

		public Node(Key key, Value val, int N){
			this.val = val;
			this.key = key;
			this.N = N;
		}
	}	

}
