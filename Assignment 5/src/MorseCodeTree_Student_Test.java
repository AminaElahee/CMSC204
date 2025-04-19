import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTree_Student_Test {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	
	private MorseCodeTree tree;

	@BeforeEach
	public void setUp() 
	{
		tree = new MorseCodeTree(); 
	}

	@Test
	public void testFetch() 
	{
		assertEquals("z", tree.fetch("--.."));
		assertEquals("e", tree.fetch("."));
		assertEquals("a", tree.fetch(".-"));
	       
	}

	@Test
	public void testToArrayList()
	{
		ArrayList<String> list = tree.toArrayList();
		assertTrue(list.contains("h"));
		assertTrue(list.contains("b"));
		assertTrue(list.contains("m"));
	    }

	@Test
	public void testGetRoot()
	{
		assertNotNull(tree.getRoot());
		assertEquals("", tree.getRoot().getData());
	}

	@Test
	public void testSetRoot() 
	{
		TreeNode<String> newRoot = new TreeNode<>("ROOT");
		tree.setRoot(newRoot);
		assertEquals("ROOT", tree.getRoot().getData());
	}


	
	@Test
	public void testInsert() 
	{
		String morseCode = "....-";
	    String value = "4";
	    tree.insert(morseCode, value);
	}

	
	@Test
	public void testFetchNode() 
	{
	    tree.insert("....-", "4");
	    String result = tree.fetchNode(tree.getRoot(), "....-");
	    assertEquals("4", result);
	}
	@Test
	public void testAddNode() 
	{
		TreeNode<String> customRoot = new TreeNode<>("");
		tree.addNode(customRoot, ".", "X");
		assertEquals("X", customRoot.getLeftChild().getData());

		tree.addNode(customRoot, "-", "Y");
		assertEquals("Y", customRoot.getRightChild().getData());
	}
	
}
