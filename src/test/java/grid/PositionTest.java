package grid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PositionTest {
	@Test
	public void hashTestUnequal() {
		Position pos1 = new Position(1, 2);
		Position pos2 = new Position(2, 1);
		assertTrue(!(pos1.hashCode() == pos2.hashCode()));
	}

	@Test
	public void hashTestEqual() {
		Position pos1 = new Position(1, 1);
		Position pos2 = new Position(1, 1);
		assertTrue(pos1.hashCode() == pos2.hashCode());
	}
}
