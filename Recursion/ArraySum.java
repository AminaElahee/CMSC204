
public class ArraySum {

	
	
	
	
	
	
	
	public int sumOfArray (Integer[] a,int index)
	{
		
		
		int result;
	
		if(index<0)
			return 0;
		else {
			
			//return a[index]+sumOfArray(a,index+1);
			
			result= a[index]+sumOfArray(a,index-1);
			return result;
		}
		
		
	}
}
