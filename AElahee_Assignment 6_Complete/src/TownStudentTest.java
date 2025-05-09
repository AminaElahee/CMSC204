import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TownStudentTest {

	private Town apple;
	private Town banana;
	private Town cherry;
	private Town copyOfApple;

	@BeforeEach
	void setUp() {
		apple = new Town("Apple");
		banana = new Town("Banana");
		cherry = new Town("Cherry");
		copyOfApple = new Town(apple);
	}

	@Test
	void testGetName() 
	{
		assertEquals("Apple", apple.getName());
		assertEquals("Banana", banana.getName());
		assertEquals("Cherry", cherry.getName());
	}

	@Test
	void testEquals() {
		assertTrue(apple.equals(copyOfApple));
		assertFalse(apple.equals(banana));
		assertFalse(apple.equals(cherry));
		assertTrue(apple.equals(new Town("Apple")));
		assertFalse(apple.equals(null));
		assertFalse(apple.equals(new Object()));
	}

	@Test
	void testHashCode() {
		assertEquals(apple.hashCode(), copyOfApple.hashCode());
		assertNotEquals(apple.hashCode(), banana.hashCode());
		assertNotEquals(banana.hashCode(), cherry.hashCode());
	}

	@Test
	void testCompareTo() {
		assertEquals(0, apple.compareTo(copyOfApple)); 
		assertTrue(apple.compareTo(banana) < 0); 
		assertTrue(cherry.compareTo(apple) > 0); 
	}

	@Test
	void testToString() {
		assertEquals("Apple", apple.toString());
		assertEquals("Banana", banana.toString());
		assertEquals("Cherry", cherry.toString());
	}
}
