import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{

	public static final double LOAD_FACTOR=1.5;
	private int size=0;
	protected LinkedList<CourseDBElement>[] HashTable;
	
	public CourseDBStructure(int numOfCourses)
	{
		int estimatedSize= (int) Math.ceil(numOfCourses / LOAD_FACTOR);
		
		this.size=fourKPlus3(estimatedSize,10);
		
		HashTable= new LinkedList[this.size];
		
	}
	
	public CourseDBStructure (String testing, int hashTableSize)
	{
		size=hashTableSize;
		
		HashTable= new LinkedList[size];
		
		
	}
	
	
//	private int getHashIndex(CourseDBStructure key)
//	{
//	   int hashIndex = key.hashCode() % HashTable.length;
//	   
//	   if (hashIndex < 0)
//	      hashIndex = hashIndex + HashTable.length;
//	    
//	   return hashIndex;
//	} 

	
	@Override
	public void add(CourseDBElement element) 
	{
		int i = hashCode(element.getCRN());
		if (HashTable[i] == null)
		{
		        HashTable[i] = new LinkedList<CourseDBElement>();
		}
		  
		for (CourseDBElement e : HashTable[i])
		{
			if (e.getCRN() == element.getCRN())
			{
		         
				HashTable[i].remove(e);
				break;
			}
		}
		HashTable[i].add(element);
		
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		 
		String Scrn= crn+"";
		int i=Scrn.hashCode()%size;
	//	LinkedList<CourseDBElement> val= HashTable[i];
		
		if(HashTable[i]==null)
		{
			//HashTable[i]= new LinkedList<CourseDBElement>();
			throw new IOException("threw Exception successfuly for the course not found");
		}	
		else
		{
			for(int x=0;x<size;x++)
			{
				CourseDBElement e =HashTable[i].get(x);
				if(e.getCRN()==crn) 
				{
					return e;
				
				}
			}
		}
		
		throw new IOException("threw Exception successfuly for the course not found");
	}

	@Override
	public ArrayList<String> showAll() {
		// TODO Auto-generated method stub
		
		
		ArrayList<String> c = new ArrayList<>();
		
		    
		for (int i = 0; i < size; i++) 
		{
			if (HashTable[i] != null) 
			{
				for (int j = 0; j < HashTable[i].size(); j++)
				{
					CourseDBElement e = HashTable[i].get(j);
					
					
					c.add("\n" + e.toString());
				}
			}
		}

		 
		    c.sort(null);
		    
		    return c;
	}

	@Override
	public int getTableSize() {
		// TODO Auto-generated method stub
		
		return size;
	
	}
	
	public static int fourKPlus3(int n, int pct) //This method is copied from the lecture notes with permission from the instructor.
	{  boolean fkp3 = false;
	   boolean aPrime = false;
	   int prime, highDivisor, d;
	   double pctd = pct;

	   prime = (int)(n * (1.0 + (pctd / 100.0)));  
	   if(prime % 2 == 0) // if even make odd
	      prime = prime +1;
	   
	   while(fkp3 == false) // not a 4k+3 prime
	   {  while(aPrime == false) // not a prime
	      {  highDivisor = (int)(Math.sqrt(prime) + 0.5);
	         for(d = highDivisor; d > 1; d--)
	         {  if(prime % d == 0)
	               break; // not a prime
	         }
	         if(d != 1) // prime not found
	            prime = prime + 2;
	         else
	            aPrime = true;
	      } // end of the prime search loop
	      if((prime - 3) % 4 == 0)
	         fkp3 = true;
	      else
	      {  prime = prime + 2;
	         aPrime = false;
	      }
	   } // end of 4k+3 prime search loop
	   return prime;
	}
	
	private int hashCode(int crn) 
	{
        return Math.abs(String.valueOf(crn).hashCode() % HashTable.length);
    }
	
	 
	
	
}
