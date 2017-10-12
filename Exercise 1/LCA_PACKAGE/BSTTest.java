package LCA_PACKAGE;

import static org.junit.Assert.*;

import org.junit.Test;

public class BSTTest {
	
	//Test constructor
	@Test
	public void testConstruct(){
		BST test = new BST();
	}
	
	//Testing put method

	@Test
	public void testPut() {
		BST test = new BST();
		test.put(10);
		test.put(2);
		test.put(3);
		test.put(41);
		test.put(12);
		test.put(10);
		assertEquals(test.root.key, 10);
		assertEquals(test.root.right.key, 41);
		assertEquals(test.root.left.key, 2);
		assertEquals(test.root.right.left.key, 12);
		assertEquals(test.root.left.right.key, 3);
		
	}

}
