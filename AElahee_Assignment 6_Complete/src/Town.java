/*
 * Class: CMSC204
 * Instructor: Khandan Monshi   
 * Description: Graph
 * Due: 05/8/2025
 * Platform/compiler:
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: _Amina Elahee_
*/

import java.util.Objects;

public class Town implements Comparable<Town>{
	
	private String Name;
	
	public Town(String name)
	{
		this.Name=name;
		
	}
	
	public Town (Town templateTown)
	{
		
		this.Name=templateTown.Name;
	}
	
	
	public String getName()
	{
		return this.Name;
		
	}
	
	
	

	@Override
	public int compareTo(Town o) {
		// TODO Auto-generated method stub
		return this.Name.compareTo(o.Name);
	}
	
	@Override
	public String toString()
	{
		return Name;
	}
	
	
	public int hashCode()
	{
		return Objects.hash(Name); // not sure about this, fix it later
	}
	
	public boolean equals(Object obj)
	{
		

		
		if(this==obj)
		{
			return true;
			
		}
		
		if(obj ==null || getClass() != obj.getClass())
		{
			return false;
		}
		
		Town o= (Town) obj;
		
		return this.Name.equals(o.Name);
		
	        
	        
		
	}

}

