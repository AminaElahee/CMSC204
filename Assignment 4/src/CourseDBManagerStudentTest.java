

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 */
public class CourseDBManagerStudentTest {
	 private CourseDBManagerInterface dataMgr = new CourseDBManager();

	    @Before
	    public void setUp() throws Exception {
	        dataMgr = new CourseDBManager();
	    }

	    @After
	    public void tearDown() throws Exception {
	        dataMgr = null;
	    }

	    @Test
	    public void testAddToDB() {
	        try {
	            dataMgr.add("CMSC305", 40504, 3, "SC350", "AAA bbb");
	            assertNotNull(dataMgr.get(40504));
	        }
	        catch(Exception e) {
	            fail("This should not have caused an Exception");
	        }
	    }

	    @Test
	    public void testShowAll() {
	        dataMgr.add("CMSC305", 40504, 3, "SC350", "AAA bbb");
	        dataMgr.add("CMSC400", 40505, 3, "SC350", "XXX yyy");
	        dataMgr.add("CMSC500", 50504, 4, "SC360", "EEE fff");

	        ArrayList<String> list = dataMgr.showAll();

	        assertEquals("\nCourse:CMSC400 CRN:40505 Credits:3 Instructor:XXX yyy Room:SC350", list.get(0));
	        assertEquals("\nCourse:CMSC305 CRN:40504 Credits:3 Instructor:AAA bbb Room:SC350", list.get(1));
	        assertEquals("\nCourse:CMSC500 CRN:50504 Credits:4 Instructor:EEE fff Room:SC360", list.get(2));
	    }

	    @Test
	    public void testRead() {
	        try {
	            File inputFile = new File("Test1.txt");
	            PrintWriter inFile = new PrintWriter(inputFile);
	            inFile.println("CMSC305 40504 3 SC350 AAA bbb");
	            inFile.println("CMSC400 40505 3 SC350 XXX yyy");
	            inFile.println("CMSC500 50504 4 SC360 EEE fff");
	            inFile.close();
	            
	            dataMgr.readFile(inputFile);
	            
	            assertEquals("CMSC305", dataMgr.get(40504).getID());
	            assertEquals("CMSC400", dataMgr.get(40505).getID());
	            assertEquals("SC350", dataMgr.get(40505).getRoomNum());
	        } catch (Exception e) {
	            fail("Should not have thrown an exception");
	        }
	    }

	    @Test
	    public void testGetValidCRN() {
	        dataMgr.add("CMSC505", 50505, 4, "SC400", "Dr. Alice");
	        CourseDBElement course = dataMgr.get(50505);
	        assertNotNull(course);
	        assertEquals("CMSC505", course.getID());
	        assertEquals(50505, course.getCRN());
	    }

	   
	    
	   }
