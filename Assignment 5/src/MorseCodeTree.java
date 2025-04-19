import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{

	
	private TreeNode<String> root; 
	
	public MorseCodeTree()
	{
		//root= new TreeNode<>("");
		buildTree();
	}
	
		
	@Override
	public TreeNode<String> getRoot() {
		
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		 
		root= newNode;
	}

	@Override
	public void insert(String code, String result) {
		 
		addNode(root,code,result);
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) 
	{
		 
		 if(code.length()==1)
		 {
			 
			 if(code.charAt(0)=='.')
			 {
				 root.setLeftChild(new TreeNode<>(letter));
			 }
			 else if (code.charAt(0)=='-')
			 {
				 root.setRightChild(new TreeNode<>(letter));
			 }
		 }
		 else 
		 {
			 char firstval=code.charAt(0);
		 
			 String restOfCode=code.substring(1);
		 
			 if(firstval=='-')
			 {
				 if(root.getRightChild()==null)
				 {
					 root.setRightChild(new TreeNode<>(null));
				 }
			 
				 addNode(root.getRightChild(),restOfCode,letter);
			 }
			 else if(firstval=='.')
			 {
				 if(root.getLeftChild()==null)
				 {
					 root.setLeftChild(new TreeNode<>(null));
				 }
				 addNode(root.getLeftChild(),restOfCode,letter);
			 
			 }
			 
			 
			 
		 }
	}

	@Override
	public String fetch(String code) {
		 
		return fetchNode(root,code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		 
		if(root==null)
		{
			return null;
		}
		
		if(code.length()==0)
		{
			return root.getData();
		}
		
		char path= code.charAt(0);
		String restOfCode=code.substring(1);
		
		if(path=='-')
		{
			return fetchNode(root.getRightChild(),restOfCode);
		}
		else if(path=='.')
		{
			return fetchNode(root.getLeftChild(),restOfCode);
		}
		
		return null;
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		 
		return null;
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		 
		return null;
	}

	@Override
	public void buildTree() 
	{
		root=new TreeNode<>("");
		
	    insert(".", "e"); //ordering based on the level
	    insert("-", "t");

	   
	    insert("..", "i");
	    insert(".-", "a");
	    insert("-.", "n");
	    insert("--", "m");

	 
	    insert("...", "s");
	    insert("..-", "u");
	    insert(".-.", "r");
	    insert(".--", "w");
	    insert("-..", "d");
	    insert("-.-", "k");
	    insert("--.", "g");
	    insert("---", "o");

	
	    insert("....", "h");
	    insert("...-", "v");
	    insert("..-.", "f");
	    insert(".-..", "l");
	    insert(".--.", "p");
	    insert(".---", "j");
	    insert("-...", "b");
	    insert("-..-", "x");
	    insert("-.-.", "c");
	    insert("-.--", "y");
	    insert("--..", "z");
	    insert("--.-", "q");
		
	}

	@Override
	public ArrayList<String> toArrayList() {
		 
		ArrayList<String> list=new ArrayList<>();
		
		LNRoutputTraversal(root, list);
		
		return list;
		
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list)
	{
		if(root!=null)
		{
			LNRoutputTraversal(root.getLeftChild(),list);
			
			if(root.getData()!= null)
			{
				list.add(root.getData());
			}
			
			LNRoutputTraversal(root.getRightChild(),list);
			
		}
		
	}

}