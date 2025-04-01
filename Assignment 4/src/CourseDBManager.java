/*
 * Class: CMSC204
 * Instructor: Khandan Monshi   
 * Description: Hashing
 * Due: 03/31/2025
 * Platform/compiler:
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: _Amina Elahee_
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface  {

	private CourseDBStructure CDS = new CourseDBStructure(10);

   
    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) 
    
    {
        CourseDBElement newElement = new CourseDBElement(id, crn, credits, roomNum, instructor);
        CDS.add(newElement);
    }

   
    @Override
    public CourseDBElement get(int crn) 
    {
    	try 
    	{
    		return CDS.get(crn);  
    	}
    	catch (IOException e) 
    	{
    		System.out.println("Course not found");
    		return null;  
    	}
    }

  
    @Override
    public void readFile(File input) throws FileNotFoundException 
    {
    	try 
    	{
			Scanner s = new Scanner(input);
			
			
			while(s.hasNext()) 
			{
				String id = s.next();
				int crn = s.nextInt();
				int numCredits = s.nextInt();
				String roomNum = s.next();
				String instructor = s.nextLine();
				add(id, crn, numCredits, roomNum, instructor);
			}
			
			s.close();
		}
		catch(FileNotFoundException e)
    	{
			System.out.print("File not found");
			
			e.getMessage();
		}
    }

   
    @Override
    public ArrayList<String> showAll() 
    {
    	ArrayList<String> list = new ArrayList<String>();
    	
		for (int i = 0; i < CDS.HashTable.length; i++) 
		{ 
			
			
			LinkedList<CourseDBElement> temp = CDS.HashTable[i];
			
			if(temp != null) 
			{
				for(int j = 0; j < temp.size(); j++) 
				{ 
					CourseDBElement element = temp.get(j);
					list.add(element.toString());
				}
			}
		}
		return list;
	}

    
}
