/*
 * Class: CMSC204
 * Instructor: Khandan Monshi   
 * Description: Morse code conversion
 * Due: 04/19/2025
 * Platform/compiler:
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: _Amina Elahee_
*/


public class TreeNode<T> {
	
	private T data;
	private TreeNode<T> leftChild; 
	private TreeNode<T> rightChild; 
	
	public TreeNode(T dataNode)
	{
		this.data=dataNode;
	}
	
	
	public TreeNode(TreeNode<T> node)
	{
		this.data=node.data;
		
		this.leftChild=node.leftChild;
		this.rightChild=node.rightChild;
		
	}
	
	
	public T getData()
	{
		
		return data;
		
	}

	public TreeNode<T>getLeftChild()
	{
		return leftChild;
	}
	
	public TreeNode<T>getRightChild()
	{
		return rightChild;
	}
	
	
	public void setLeftChild(TreeNode<T> left) //not sure , fix later
	{
		this.leftChild=left;
		
	}


	public void setRightChild(TreeNode<T> right)
	{
		this.rightChild=right;
		
	}
	
	
	
	
	
}
