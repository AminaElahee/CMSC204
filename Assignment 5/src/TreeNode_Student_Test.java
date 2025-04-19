import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TreeNode_Student_Test {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	
	@Test
	public void testGetData()
	{
		TreeNode<String> node= new TreeNode<>("Node");
		
		assertEquals("Node",node.getData());
		
	}
	
	
	@Test
	public void testSetLeftChild()
	{
		TreeNode<String> parent= new TreeNode<>("parent");
		
		TreeNode<String> leftChild= new TreeNode<>("leftchild");
		parent.setLeftChild(leftChild);
		
		
		assertEquals("leftchild",parent.getLeftChild().getData());
	}
	
	@Test
	public void testGetLeftChild()
	{
		
		TreeNode<String> parent= new TreeNode<>("parent2");
		
		TreeNode<String> left= new TreeNode<>("leftchild2");
		parent.setLeftChild(left);
		
		TreeNode<String> result=parent.getLeftChild();
		
		assertNotNull(result);
		assertEquals("leftchild2",result.getData());

		
		
	}
	
	
	
	
	
	
	@Test
	public void testSetRightChild()
	{
		
		TreeNode<String> parent= new TreeNode<>("parent3");
		
		TreeNode<String> RightChild= new TreeNode<>("rightchild3");
		parent.setRightChild(RightChild);
		
		
		assertEquals("rightchild3",parent.getRightChild().getData());
		
	}
	
	@Test
	public void testGetRightChild()
	{

		TreeNode<String> parent= new TreeNode<>("parent4");
		
		TreeNode<String> right= new TreeNode<>("rightchild4");
		parent.setRightChild(right);
		
		TreeNode<String> result=parent.getRightChild();
		
		assertNotNull(result);
		assertEquals("rightchild4",result.getData());

	}
}
