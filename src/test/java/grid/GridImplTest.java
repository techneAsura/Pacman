package grid;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import grid.Grid;
import grid.GridImpl;

public class GridImplTest {

	@Test
	public void gridTestGetRowsAndCols() {
		Grid<Integer> grid = new GridImpl<Integer>(3, 2, null);
		assertEquals(2, grid.getRows());
		assertEquals(3, grid.getCols());
	}

	@Test
	public void gridSanityTest() {
		String defaultValue = "x";
		Grid<String> grid = new GridImpl<>(3, 2, defaultValue);
		assertEquals("x", grid.getPosition(new Position(0, 0)));
		assertEquals("x", grid.getPosition(new Position(2, 1)));

		grid.setItem(new PositionItem<String>(new Position(0, 1), "y"));

		assertEquals("y", grid.getPosition(new Position(0, 1)));
		assertEquals("x", grid.getPosition(new Position(1, 1)));
		assertEquals("x", grid.getPosition(new Position(1, 0)));
		assertEquals("x", grid.getPosition(new Position(2, 1)));
	}
}
