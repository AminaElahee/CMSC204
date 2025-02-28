import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface <T>
{
	private ArrayList<T>queue;
	private int front, rear, size, capacity;

	
	public MyQueue(){
		this.capacity=20; //as a default value
		queue = new ArrayList<T>(capacity);
		front = 0;
		rear = -1;
		size = 0;
	}
	
	public MyQueue( int capacity)
	{
		this.capacity  = capacity;
		queue = new ArrayList<T>(capacity);
		front = 0;
		rear = -1;
		size = 0;

	}
	
	
	
	@Override
	public boolean isEmpty() {
		
		if(size==0)
			return true;
		
		return false;
	}

	@Override
	public boolean isFull() {
		
		if(size==capacity)
			return true;
		
		return false;
	}

	@Override
	public T dequeue() throws QueueUnderflowException 
	{
		
		if(isEmpty())
		{
			throw new QueueUnderflowException("This should have caused an QueueUnderflowException");
		}
		else
		{	

			
			T FirstElement=queue.get(front);
			
			queue.remove(front);
			
			size=size-1; //so that it also decrement the size of the queue
			
			return FirstElement;

			
		}
		
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		
//		int count = 0;
//		for (int i=0;i<queue.size();i++)
//		{
//			count++;
//		}
//		return count;
		return size;
	}

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		// TODO Auto-generated method stub
		
		if(isFull())
		{
			throw new QueueOverflowException("This should have caused an QueueOverflowException");
		}
		
			
				
				
		//T newElement=queue.add(e);
		queue.add(e);
		size=size+1; //so that it also increment the size of the queue
		return true;
		
		
	}

	@Override
	public String toString(String delimiter) {
		// TODO Auto-generated method stub
		String result = "";
	    for (int i = 0; i <= front; i++) {
	        result += queue.get(i);
	        if (i != front) {
	            result += delimiter;
	        }
	    }
	    return result;
		
	}

	@Override
	public void fill(ArrayList<T> list) {
		// TODO Auto-generated method stub
		
		ArrayList<T> queueCopy=new ArrayList<T>(list);
		
		queue.addAll(queueCopy); 
		size=queue.size();
		
		
	}
	
	
	
	
}
