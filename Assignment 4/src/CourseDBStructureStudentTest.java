
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager which is implemented from the
 * CourseDBManagerInterface
 * 
 */
public class CourseDBStructureStudentTest {
	 CourseDBStructure cds, testStructure;

	    @Before
	    public void setUp() throws Exception {
	        cds = new CourseDBStructure(20);
	        testStructure = new CourseDBStructure("Testing", 20);
	    }

	    @After
	    public void tearDown() throws Exception {
	        cds = testStructure = null;
	    }

	    @Test
	    public void testGetTableSize() {
	        assertEquals(19, cds.getTableSize());
	        assertEquals(20, testStructure.getTableSize());
	    }

	    @Test
	    public void testHashTable() {
	        CourseDBElement cde1 = new CourseDBElement("CMSC500", 39999, 4, "SC100", "Apple Red");
	        
	        cds.add(cde1);
	        cds.add(cde1);
	        ArrayList<String> courseList = cds.showAll();
	        assertTrue(courseList.size() == 1);

	        CourseDBElement cde2 = new CourseDBElement("CMSC600", 4000, 4, "SC100", "Banana Yellow");

	        try {
	            assertEquals(39999, cds.get(cde1.getCRN()).getCRN());
	            cds.get(cde2.getCRN()).getCRN();
	        } catch (IOException e) {
	            assertTrue(true);
	        }

	        cds.add(cde2);
	        courseList = cds.showAll();
	        assertTrue(courseList.size() == 2);

	        try {
	            assertEquals(4000, cds.get(cde2.getCRN()).getCRN());
	        } catch (IOException e) {
	            fail("Should not throw exception");
	        }

	        CourseDBElement cde1Update = new CourseDBElement("CMSC500-updated", 39999, 4, "SC100", "Cherry Red");
	        cds.add(cde1Update);
	        courseList = cds.showAll();
	        assertTrue(courseList.size() == 2);

	        try {
	            assertEquals(39999, cds.get(cde1Update.getCRN()).getCRN());
	            assertEquals("CMSC500-updated", cds.get(cde1Update.getCRN()).getID());
	        } catch (IOException e) {
	            fail("Should not throw exception");
	        }

	        testStructure.add(cde1);
	        courseList = testStructure.showAll();
	        assertTrue(courseList.size() == 1);
	    }
}
