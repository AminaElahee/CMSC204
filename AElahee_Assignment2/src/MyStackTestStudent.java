import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class MyStackTestStudent {
	public MyStack<String> stringS;
    public String x = "x", y = "y", z = "z", w = "w", v = "v", u = "u";
    public ArrayList<String> fill = new ArrayList<String>();
    
    public MyStack<Double> doubleS;

    @BeforeEach
    public void setUp() throws Exception {
        stringS = new MyStack<String>(5);
        stringS.push(x);
        stringS.push(y);
        stringS.push(z);
    }

    @AfterEach
    public void tearDown() throws Exception {
        stringS = null;
        doubleS = null;
    }

    @Test
    public void testIsEmpty() throws StackUnderflowException {
        assertEquals(false, stringS.isEmpty());
        stringS.pop();
        stringS.pop();
        assertEquals(true, stringS.isEmpty());
    }

    @Test
    public void testIsFull() throws StackOverflowException {
        assertEquals(false, stringS.isFull());
        stringS.push(w);
        stringS.push(v);
        assertEquals(true, stringS.isFull());
    }

    @Test
    public void testPop() {
        try {
            assertEquals(z, stringS.pop());
            assertEquals(y, stringS.pop());
            assertEquals(x, stringS.pop());
            stringS.pop();
            assertTrue("This should have caused a StackUnderflowException", false);
        } catch (StackUnderflowException e) {
            assertTrue("This should have caused a StackUnderflowException", true);
        } catch (Exception e) {
            assertTrue("This should have caused a StackUnderflowException", false);
        }
    }

    @Test
    public void testPopStudent() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testTop() throws StackUnderflowException, StackOverflowException {
        assertEquals(z, stringS.top());
        stringS.push(w);
        assertEquals(w, stringS.top());
        stringS.pop();
        stringS.pop();
        assertEquals(y, stringS.top());
    }

    @Test
    public void testSize() throws StackOverflowException, StackUnderflowException {
        assertEquals(3, stringS.size());
        stringS.push(w);
        assertEquals(4, stringS.size());
        stringS.pop();
        stringS.pop();
        assertEquals(2, stringS.size());
    }

    @Test
    public void testPush() {
        try {
            assertEquals(3, stringS.size());
            assertEquals(true, stringS.push(w));
            assertEquals(4, stringS.size());
            assertEquals(true, stringS.push(v));
            assertEquals(5, stringS.size());
            stringS.push(u);
            assertTrue("This should have caused a StackOverflowException", false);
        } catch (StackOverflowException e) {
            assertTrue("This should have caused a StackOverflowException", true);
        } catch (Exception e) {
            assertTrue("This should have caused a StackOverflowException", false);
        }
    }

    @Test
    public void testPushStudent() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testToString() throws StackOverflowException {
        assertEquals("xyz", stringS.toString());
        stringS.push(w);
        assertEquals("xyzw", stringS.toString());
        stringS.push(v);
        assertEquals("xyzwv", stringS.toString());
    }

    @Test
    public void testToStringStudent() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testToStringDelimiter() throws StackOverflowException {
        assertEquals("x%y%z", stringS.toString("%"));
        stringS.push(w);
        assertEquals("x&w&y&z&w", stringS.toString("&"));
        stringS.push(v);
        assertEquals("x/w/y/z/w/v", stringS.toString("/"));
    }

    @Test
    public void testFill() throws StackUnderflowException {
        fill.add("apple");
        fill.add("banana");
        fill.add("cherry");
        stringS = new MyStack<String>(5);
        stringS.fill(fill);
        assertEquals(3, stringS.size());
        assertEquals("cherry", stringS.pop());
        assertEquals("banana", stringS.pop());
        assertEquals("apple", stringS.pop());
    }
}
