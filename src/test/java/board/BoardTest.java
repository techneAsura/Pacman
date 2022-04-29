package board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import grid.Position;
import pacmanBoard.PacmanBoard;
import pacmanBoard.Tile.Tile;

public class BoardTest {
	private PacmanBoard pacmanBoard;
	
	public BoardTest(){
		pacmanBoard = new PacmanBoard();
	}
	@Test
	public void boardSanityTest() {
		assertEquals(Tile.upLeftCorner, pacmanBoard.getPosition(new Position(0, 0)));
		assertEquals(Tile.upRightCorner, pacmanBoard.getPosition(new Position(pacmanBoard.getCols()-1, 0)));
		assertEquals(Tile.downRightCorner, pacmanBoard.getPosition(new Position(pacmanBoard.getCols()-1, pacmanBoard.getRows()-1)));
		assertEquals(Tile.downLeftCorner, pacmanBoard.getPosition(new Position(0,pacmanBoard.getRows()-1)));
	}
	@Test 
	public void countFoodTest() {
		// the current map should have 284 food tiles
		assertTrue(pacmanBoard.getNumberOf(Tile.food) == 284);
	}
	
}
