import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoadStudentTest {

	private Road road1;
	private Road road2;
	private Town redTown;
	private Town blueTown;

	@BeforeEach
	void setUp() {
		redTown = new Town("Red");
		blueTown = new Town("Blue");

		road1 = new Road(redTown, blueTown, 5, "Red-Blue Road");
		road2 = new Road(redTown, blueTown, 5, "Red-Blue Road");
	}

	@Test
	void testGetName() {
		assertEquals("Red-Blue Road", road1.getName());
	}

	@Test
	void testGetDistance() {
		assertEquals(5, road1.getDistance());
	}

	@Test
	void testGetSourceAndDestination() {
		assertEquals(redTown, road1.getSource());
		assertEquals(blueTown, road1.getDestinitaion());
	}

	@Test
	void testContains() {
		assertTrue(road1.contains(redTown));
		assertTrue(road1.contains(blueTown));
	}

	@Test
	void testToString() {
		assertEquals("Red-Blue Road,5miles, Red,Blue", road1.toString());
	}

	@Test
	void testEquals() {
		assertTrue(road1.equals(road2));
		assertFalse(road1.equals(null));
		assertFalse(road1.equals(new Object()));
	}

	@Test
	void testCompareTo() {
		assertEquals(0, road1.compareTo(road2));
	}

}
