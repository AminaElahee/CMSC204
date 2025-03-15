import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T>
{

	 protected Node head;
	 protected Node tail;
	 protected int size;

	
	 
	 public BasicDoubleLinkedList()
	 {
			head=null;
			tail=null;
			size=0;
			
	 }
	 
	 
	 
	 
	 
	 
	public class Node
	{
		T data;
		Node next;
		Node prev;
		
		
		Node(T data) 
		{
			this.data = data;
			this.next = null;
			this.prev=null;
		}

		
	}
	
	
	
	public class DoubleLinkedListIterator implements ListIterator<T>
	{
		private Node current=head;
		
		
		@Override
		public boolean hasNext() 
		{
//			if( current!= null)
//				return true;
//			
//			return false;
			return current != null;
		}
		
		@Override
		public T next() throws NoSuchElementException 
		{
			if(!hasNext())
			{
				throw new NoSuchElementException("Successfully threw a NoSuchElementException");
			}
			
			
			T data=current.data;
			current=current.next;
			return data;
			
		}
		
		@Override
		public boolean hasPrevious()
		{
			//return current!= null;
			//return current.prev!= null;
			
			
//			return current!= null && current.prev!= null;
			
			if(current==head)
			{
				return false;
			}
			
			return true;
		}
		
		
		@Override
		public T previous() throws NoSuchElementException
		{
			if(!hasPrevious())
			{
				throw new NoSuchElementException("Successfully threw a NoSuchElementException");
			}
			
	
			current=current.prev;
			return current.data;
			
		}

		@Override
		public int nextIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void set(T e) throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void add(T e) throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
			
		}
	
	
	}
	
	
	
	public int getSize()
	{
		return size;
	}
	
	
	
	public void addToFront(T data)
	{
		Node newNode=new Node(data);
		
		
		if(head==null)
		{
			head=newNode;
			tail=newNode;
		}
		else
		{
			
			newNode.next=head;
			head.prev=newNode;
			head=newNode;
		}
		
		
		size++;
	}
	
	public  void addToEnd(T data)
	{
		Node newNode=new Node(data);
		
		
		if(tail==null)
		{
			head=tail;
			tail=newNode;
		}
		else
		{
			
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
			
			
//			newNode.prev=tail;
//			tail.next=newNode;
//			tail=newNode;
		}
			
		size++;
	}
	

	
	public T getFirst()  
	{
		if(head==null) //(size==0)
		{
			return null;
		}
		
		return head.data;
		
		
	}
	
	public T getLast()
	{
		if(tail==null)
		{
			return null;
		}
		else 
		{
			return tail.data;
		}
		
	}
	
	
	
	@Override 
	public ListIterator<T> iterator() 
	{
		
		return new DoubleLinkedListIterator();
	}
	
	
	
	
	
	
	
	public T retrieveFirstElement()
	{
		if (head == null)
		{
			return null;  
		}
		
		

	    T data = head.data;  
	    head = head.next;  

	    if (head != null) 
	    {  
	    	head.prev = null;  
	    }
	    else 
	    {  
	        tail = null;  
	    }  

	    size--;  
	    return data;  
		
	}
	
	public T retrieveLastElement()
	{
		if (size == 0)
		{
			return null;  
		}
		T data = tail.data;  
		tail = tail.prev;  

		if (tail != null)
		{  
			tail.next = null;  
		} 
		else 
		{  
			head = null;  
		}  

		size--;  
		return data;  
	}
	
	
	public ArrayList<T> toArrayList()
	{
		ArrayList<T> temp =new ArrayList<>();
		
	

		Node current = head;
		    
		
		while (current != null) 
		{
			temp.add(current.data);
			current = current.next;
		}

		return temp;
		
	}

	
	

	
	
	
	
	
	
	
	
	
	
	
	

}
