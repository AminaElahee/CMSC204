import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class MyQueueTestStudent {
	 public MyQueue<String> stringQ;
	    public String p = "p", q = "q", r = "r", s = "s", t = "t", u = "u";
	    public ArrayList<String> fill = new ArrayList<String>();
	    
	    public MyQueue<Double> doubleQ;

	    @BeforeEach
	    public void setUp() throws Exception {
	        stringQ = new MyQueue<String>(5);
	        stringQ.enqueue(p);
	        stringQ.enqueue(q);
	        stringQ.enqueue(r);
	    }

	    @AfterEach
	    public void tearDown() throws Exception {
	        stringQ = null;
	        doubleQ = null;
	    }

	    @Test
	    public void testIsEmpty() throws QueueUnderflowException {
	        assertEquals(false, stringQ.isEmpty());
	        stringQ.dequeue();
	        stringQ.dequeue();
	        stringQ.dequeue();
	        assertEquals(true, stringQ.isEmpty());
	    }

	    @Test
	    public void testDequeue() {
	        try {
	            assertEquals(p, stringQ.dequeue());
	            assertEquals(q, stringQ.dequeue());
	            assertEquals(r, stringQ.dequeue());
	            stringQ.dequeue();
	            assertTrue("This should have caused a QueueUnderflowException", false);
	        } catch (QueueUnderflowException e) {
	            assertTrue("This should have caused a QueueUnderflowException", true);
	        } catch (Exception e) {
	            assertTrue("This should have caused a QueueUnderflowException", false);
	        }
	    }
	    
	    @Test
	    public void testDequeueStudent() {
	        fail("Not yet implemented");
	    }

	    @Test
	    public void testSize() throws QueueOverflowException, QueueUnderflowException {
	        assertEquals(3, stringQ.size());
	        stringQ.enqueue(s);
	        assertEquals(4, stringQ.size());
	        stringQ.dequeue();
	        stringQ.dequeue();
	        assertEquals(2, stringQ.size());
	    }

	    @Test
	    public void testEnqueue() {
	        try {
	            assertEquals(3, stringQ.size());
	            assertEquals(true, stringQ.enqueue(s));
	            assertEquals(4, stringQ.size());
	            assertEquals(true, stringQ.enqueue(t));
	            assertEquals(5, stringQ.size());
	            stringQ.enqueue(u);
	            assertTrue("This should have caused a QueueOverflowException", false);
	        } catch (QueueOverflowException e) {
	            assertTrue("This should have caused a QueueOverflowException", true);
	        } catch (Exception e) {
	            assertTrue("This should have caused a QueueOverflowException", false);
	        }
	    }

	    @Test
	    public void testEnqueueStudent() {
	        fail("Not yet implemented");
	    }

	    @Test
	    public void testIsFull() throws QueueOverflowException {
	        assertEquals(false, stringQ.isFull());
	        stringQ.enqueue(s);
	        stringQ.enqueue(t);
	        assertEquals(true, stringQ.isFull());
	    }

	    @Test
	    public void testToString() throws QueueOverflowException {
	        assertEquals("pqr", stringQ.toString());
	        stringQ.enqueue(s);
	        assertEquals("pqrs", stringQ.toString());
	        stringQ.enqueue(t);
	        assertEquals("pqrst", stringQ.toString());
	    }

	    @Test
	    public void testToStringStudent() {
	        fail("Not yet implemented");
	    }

	    @Test
	    public void testToStringDelimiter() throws QueueOverflowException {
	        assertEquals("p%q%r", stringQ.toString("%"));
	        stringQ.enqueue(s);
	        assertEquals("p&q&r&s", stringQ.toString("&"));
	        stringQ.enqueue(t);
	        assertEquals("p/q/r/s/t", stringQ.toString("/"));
	    }

	    @Test
	    public void testFill() throws QueueUnderflowException {
	        fill.add("apple");
	        fill.add("banana");
	        fill.add("cherry");
	        stringQ = new MyQueue<String>(5);
	        stringQ.fill(fill);
	        assertEquals(3, stringQ.size());
	        assertEquals("apple", stringQ.dequeue());
	        assertEquals("banana", stringQ.dequeue());
	        assertEquals("cherry", stringQ.dequeue());
	    }
}
