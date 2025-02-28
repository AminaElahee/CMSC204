import java.util.ArrayList;

public class MyStack <T> implements StackInterface <T>{

	private ArrayList<T>stack;
	private int topIndex;
	private int capacity;

	
	public MyStack() {
		this(20);
	}
	
	
	public MyStack(int size)
	{
		stack = new ArrayList<T> (size);
		topIndex = -1;
		capacity = size;

		
	}
	
	  
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		
		return topIndex==-1;

	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		
		if(topIndex == capacity - 1)
		   return true;
		    
		return false;
	}

	@Override
	public T pop() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new StackUnderflowException("This should have caused an StackUnderflowException");
		

		T TopElement=stack.get(topIndex-1);
		
		stack.remove(topIndex);
		
		topIndex=topIndex-1; //so that it also decrement the size of the queue
		
		return TopElement;

	
	}

	@Override
	public T top() throws StackUnderflowException {
		// TODO Auto-generated method stub
		
		if (isEmpty()) {
			throw new StackUnderflowException("This should have caused an StackUnderflowException");
		}
		return stack.get(topIndex);
		
		
	
	}

	@Override
	public int size() {
		
		int s=topIndex+1;
		 
		
		
		return s;
	}

	@Override
	public boolean push(T e) throws StackOverflowException {
		// TODO Auto-generated method stub
		
		if (isFull())
			throw new StackOverflowException("This should have caused an StackOverflowException");
		else
		{  	
			
			stack.add(e); 
			topIndex++;
			return true;
		
		}
		
		
		
	}

	@Override
	public String toString(String delimiter) 
	{
		// TODO Auto-generated method stub
		String result = "";
	    for (int i = 0; i <= topIndex; i++) {
	        result += stack.get(i);
	        if (i != topIndex) {
	            result += delimiter;
	        }
	    }
	    return result;
			}

	@Override
	public void fill(ArrayList<T> list) 
	{
		// TODO Auto-generated method stub
		
		for (T x : list) 
		{
			try 
			{
				push(x);
			}
			catch (StackOverflowException e)
			{
	                break;
			}
		 }
	}
}
