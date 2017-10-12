package LCA_PACKAGE;

import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {
	
	//Test 1: Empty Tree Case
	@Test 
	public void test1() {
		BST test = initializeData();
	}
	
	//Test 2: Two nodes with separate node as common ancestor
	@Test
	public void test2(){
		BST test = initializeData();
	}
	
	//Test 3: Two nodes with one node as the common ancestor
	@Test 
	public void test3(){
		BST test = initializeData();
	}
	
	//Test 4: Tree without two key references contained in the data
	@Test
	public void test4(){
		BST test = initializeData();
	}
	
	//Method to standardise initialisation of BST
	public static BST initializeData(){
		BST test = new BST();
		test.put(10);
		test.put(2);
		test.put(3);
		test.put(41);
		test.put(12);
		return test;
	}
	//Test Other Cases

}
