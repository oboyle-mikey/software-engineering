package LCA_PACKAGE;

import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest{

	//Test 1: Empty Tree Case
	@Test 
	public void test1() {
		LCA test = new LCA();

	}

	//Test 2: Two nodes with separate node as common ancestor
	@Test
	public void test2(){
		LCA test = initializeData();
		int t = test.lowestCommonAncestor(3, 12);
		assertEquals(t, 10);

	}

	//Test 3: Two nodes with one node being the common ancestor
	@Test 
	public void test3(){
		LCA test = initializeData();
		int t = test.lowestCommonAncestor(2, 3);
		assertEquals(t, 2);
	}

	//Test 4: Tree without two key references contained in the data
	@Test
	public void test4(){
		LCA test = initializeData();
		int t = test.lowestCommonAncestor(13, 120);
		assertEquals(t, -1);
	}

	//Test Other Cases

	//Method to standardise initialisation of BST
	public static LCA initializeData(){
		LCA test = new LCA();
		test.put(10);
		test.put(2);
		test.put(3);
		test.put(41);
		test.put(12);
		return test;
	}

	//Test Data Structure Methods 

	//Test constructor
	@Test
	public void testConstruct(){
		LCA test = new LCA();
	}

	//Testing put method

	@Test
	public void testPut() {
		LCA test = new LCA();
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
	
	@Test 
	public void testGet(){
		LCA test = initializeData();
		boolean t1 = test.get(10);
		boolean t2 = test.get(123);
		assertEquals(t1, true);
		assertEquals(t2, false);
	}



}
