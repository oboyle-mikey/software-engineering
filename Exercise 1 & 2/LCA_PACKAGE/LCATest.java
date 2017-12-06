package LCA_PACKAGE;

import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest{

	//Test 1: Empty Tree Case
	@Test 
	public void test1() {
		Digraph g = new Digraph(0);
		LCA test = new LCA(g);
		int LCAtest = test.lowestCommonAncestor(1, 2);
		assertEquals(LCAtest, -1);

	}

	//Test 2: Two nodes with one node being the common ancestor
	@Test 
	public void test2(){
		LCA test = initializeData();
		int LCATest = test.lowestCommonAncestor(6, 1);
		assertEquals(LCATest, 1);
		
	}

	//Test 3: Tree without two key references contained in the data
	@Test
	public void test3(){
		LCA test = initializeData();
		int LCATest = test.lowestCommonAncestor(60, 50);
		assertEquals(LCATest, -1);
		
	}
	
	//Test 4: Tree with two nodes contained and one common ancestor
	@Test
	public void test4(){
		LCA test = initializeData();
		int LCATest = test.lowestCommonAncestor(6, 5);
		assertEquals(LCATest, 1);
	}
	
	//Test 5: Tree has cycle case
	@Test
	public void test5(){
		LCA test = initializeDataCycle();
		int LCATest = test.lowestCommonAncestor(4, 5);
		assertEquals(LCATest, -1);
	}
	
	//Test 6: Tree with two nodes contained and more then one common ancestor
	@Test
	public void test6(){
		LCA test = initializeData();
		//Initialise new data
	}
	


	//Test Other Cases

	//Method to standardise initialisation of BST
	
//					1
//				/	|	\
//			   2	4	 3
//					|	 |	
//					5	 6	
//					\	/
//					  7
//					  |
//					  8

	public static LCA initializeData(){
		Digraph g = new Digraph(10);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(3, 6);
		g.addEdge(4, 5);
		g.addEdge(5, 7);
		g.addEdge(6, 7);
		g.addEdge(7, 8);
		LCA test = new LCA(g);
		return test;
	}
	
	public static LCA initializeDataCycle(){
		Digraph g = new Digraph(10);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(3, 6);
		g.addEdge(4, 5);
		g.addEdge(5, 7);
		g.addEdge(6, 7);
		g.addEdge(7, 8);
		g.addEdge(8, 1);
		LCA test = new LCA(g);
		return test;
	}

	//Test Data Structure Methods 

	//Test constructor
	@Test
	public void testConstruct(){
		LCA test = initializeData();
	}

	// Testing put method

	@Test
	public void testPut() {
		LCA test = initializeData();
		

	}
	
	@Test 
	public void testGet(){
		LCA test = initializeData();
		
	}



}
