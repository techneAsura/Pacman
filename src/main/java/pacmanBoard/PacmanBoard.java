package pacmanBoard;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;

import grid.GridImpl;
import grid.Position;
import grid.PositionItem;
import pacmanBoard.Tile.Tile;

/***
 * A subclass of {@link grid.GridImpl GridImpl}. Contains all the tiles that
 * make up the game board.
 * 
 * @author Thomas
 *
 */
public class PacmanBoard extends GridImpl<Tile> {
	/***
	 * An array of arrays of {@link pacmanBoard.Tile.Tile Tiles} which describes the
	 * contents of the Board.
	 */
	private Tile[][] boardTiles = { { Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
			Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
			Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.upRightCorner,
			Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
			Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
			Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.upRightCorner },
			{ Tile.verticalWall, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food,
					Tile.food, Tile.food, Tile.food, Tile.food, Tile.verticalWall, Tile.verticalWall, Tile.food,
					Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food,
					Tile.food, Tile.food, Tile.verticalWall },
			{ Tile.verticalWall, Tile.food, Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.upRightCorner, Tile.food, Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.upRightCorner, Tile.food, Tile.verticalWall, Tile.verticalWall, Tile.food,
					Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.upRightCorner, Tile.food, Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.upRightCorner, Tile.food, Tile.verticalWall },
			{ Tile.verticalWall, Tile.powerUp, Tile.verticalWall, Tile.open, Tile.open, Tile.verticalWall, Tile.food,
					Tile.verticalWall, Tile.open, Tile.open, Tile.open, Tile.verticalWall, Tile.food, Tile.verticalWall,
					Tile.verticalWall, Tile.food, Tile.verticalWall, Tile.open, Tile.open, Tile.open, Tile.verticalWall,
					Tile.food, Tile.verticalWall, Tile.open, Tile.open, Tile.verticalWall, Tile.powerUp,
					Tile.verticalWall },
			{ Tile.verticalWall, Tile.food, Tile.downLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.downRightCorner, Tile.food, Tile.downLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.downRightCorner, Tile.food, Tile.downLeftCorner, Tile.downRightCorner,
					Tile.food, Tile.downLeftCorner, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.downRightCorner, Tile.food, Tile.downLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.downRightCorner, Tile.food, Tile.verticalWall },
			{ Tile.verticalWall, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food,
					Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food,
					Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food,
					Tile.verticalWall },
			{ Tile.verticalWall, Tile.food, Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.upRightCorner, Tile.food, Tile.upLeftCorner, Tile.upRightCorner, Tile.food, Tile.upLeftCorner,
					Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.horizontalWall, Tile.upRightCorner, Tile.food, Tile.upLeftCorner,
					Tile.upRightCorner, Tile.food, Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.upRightCorner, Tile.food, Tile.verticalWall },
			{ Tile.verticalWall, Tile.food, Tile.downLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.downRightCorner, Tile.food, Tile.verticalWall, Tile.verticalWall, Tile.food,
					Tile.downLeftCorner, Tile.horizontalWall, Tile.horizontalWall, Tile.upRightCorner,
					Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall, Tile.downRightCorner, Tile.food,
					Tile.verticalWall, Tile.verticalWall, Tile.food, Tile.downLeftCorner, Tile.horizontalWall,
					Tile.horizontalWall, Tile.downRightCorner, Tile.food, Tile.verticalWall },
			{ Tile.verticalWall, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.verticalWall,
					Tile.verticalWall, Tile.food, Tile.food, Tile.food, Tile.food, Tile.verticalWall, Tile.verticalWall,
					Tile.food, Tile.food, Tile.food, Tile.food, Tile.verticalWall, Tile.verticalWall, Tile.food,
					Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.verticalWall },
			{ Tile.downLeftCorner, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.upRightCorner, Tile.food, Tile.verticalWall, Tile.downLeftCorner, Tile.horizontalWall,
					Tile.horizontalWall, Tile.upRightCorner, Tile.food, Tile.verticalWall, Tile.verticalWall, Tile.food,
					Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall, Tile.downRightCorner,
					Tile.verticalWall, Tile.food, Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.horizontalWall, Tile.downRightCorner },
			{ Tile.open, Tile.open, Tile.open, Tile.open, Tile.open, Tile.verticalWall, Tile.food, Tile.verticalWall,
					Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall, Tile.downRightCorner, Tile.food,
					Tile.downLeftCorner, Tile.downRightCorner, Tile.food, Tile.downLeftCorner, Tile.horizontalWall,
					Tile.horizontalWall, Tile.upRightCorner, Tile.verticalWall, Tile.food, Tile.verticalWall, Tile.open,
					Tile.open, Tile.open, Tile.open, Tile.open },
			{ Tile.open, Tile.open, Tile.open, Tile.open, Tile.open, Tile.verticalWall, Tile.food, Tile.verticalWall,
					Tile.verticalWall, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food,
					Tile.food, Tile.food, Tile.food, Tile.verticalWall, Tile.verticalWall, Tile.food, Tile.verticalWall,
					Tile.open, Tile.open, Tile.open, Tile.open, Tile.open },
			{ Tile.open, Tile.open, Tile.open, Tile.open, Tile.open, Tile.verticalWall, Tile.food, Tile.verticalWall,
					Tile.verticalWall, Tile.food, Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.open, Tile.open, Tile.horizontalWall, Tile.horizontalWall, Tile.upRightCorner, Tile.food,
					Tile.verticalWall, Tile.verticalWall, Tile.food, Tile.verticalWall, Tile.open, Tile.open, Tile.open,
					Tile.open, Tile.open },
			{ Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.downRightCorner, Tile.food, Tile.downLeftCorner, Tile.downRightCorner, Tile.food,
					Tile.verticalWall, Tile.open, Tile.open, Tile.open, Tile.open, Tile.open, Tile.open,
					Tile.verticalWall, Tile.food, Tile.downLeftCorner, Tile.downRightCorner, Tile.food,
					Tile.downLeftCorner, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.horizontalWall },
			{ Tile.open, Tile.open, Tile.open, Tile.open, Tile.open, Tile.open, Tile.food, Tile.food, Tile.food,
					Tile.food, Tile.verticalWall, Tile.open, Tile.open, Tile.open, Tile.open, Tile.open, Tile.open,
					Tile.verticalWall, Tile.food, Tile.food, Tile.food, Tile.food, Tile.open, Tile.open, Tile.open,
					Tile.open, Tile.open, Tile.open },
			{ Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.upRightCorner, Tile.food, Tile.upLeftCorner, Tile.upRightCorner, Tile.food, Tile.verticalWall,
					Tile.open, Tile.open, Tile.open, Tile.open, Tile.open, Tile.open, Tile.verticalWall, Tile.food,
					Tile.upLeftCorner, Tile.upRightCorner, Tile.food, Tile.upLeftCorner, Tile.horizontalWall,
					Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall },
			{ Tile.open, Tile.open, Tile.open, Tile.open, Tile.open, Tile.verticalWall, Tile.food, Tile.verticalWall,
					Tile.verticalWall, Tile.food, Tile.downLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.downRightCorner, Tile.food, Tile.verticalWall, Tile.verticalWall, Tile.food, Tile.verticalWall,
					Tile.open, Tile.open, Tile.open, Tile.open, Tile.open },
			{ Tile.open, Tile.open, Tile.open, Tile.open, Tile.open, Tile.verticalWall, Tile.food, Tile.verticalWall,
					Tile.verticalWall, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food,
					Tile.food, Tile.food, Tile.food, Tile.verticalWall, Tile.verticalWall, Tile.food, Tile.verticalWall,
					Tile.open, Tile.open, Tile.open, Tile.open, Tile.open },
			{ Tile.open, Tile.open, Tile.open, Tile.open, Tile.open, Tile.verticalWall, Tile.food, Tile.verticalWall,
					Tile.verticalWall, Tile.food, Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.upRightCorner, Tile.food, Tile.verticalWall, Tile.verticalWall, Tile.food, Tile.verticalWall,
					Tile.open, Tile.open, Tile.open, Tile.open, Tile.open },
			{ Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.downRightCorner, Tile.food, Tile.downLeftCorner, Tile.downRightCorner, Tile.food,
					Tile.downLeftCorner, Tile.horizontalWall, Tile.horizontalWall, Tile.upRightCorner,
					Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall, Tile.downRightCorner, Tile.food,
					Tile.downLeftCorner, Tile.downRightCorner, Tile.food, Tile.downLeftCorner, Tile.horizontalWall,
					Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.upRightCorner },
			{ Tile.verticalWall, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food,
					Tile.food, Tile.food, Tile.food, Tile.food, Tile.verticalWall, Tile.verticalWall, Tile.food,
					Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food,
					Tile.food, Tile.food, Tile.verticalWall },
			{ Tile.verticalWall, Tile.food, Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.upRightCorner, Tile.food, Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.upRightCorner, Tile.food, Tile.verticalWall, Tile.verticalWall, Tile.food,
					Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.upRightCorner, Tile.food, Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.upRightCorner, Tile.food, Tile.verticalWall },
			{ Tile.verticalWall, Tile.food, Tile.downLeftCorner, Tile.horizontalWall, Tile.upRightCorner,
					Tile.verticalWall, Tile.food, Tile.downLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.downRightCorner, Tile.food, Tile.downLeftCorner, Tile.downRightCorner,
					Tile.food, Tile.downLeftCorner, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.downRightCorner, Tile.food, Tile.verticalWall, Tile.upLeftCorner, Tile.horizontalWall,
					Tile.downRightCorner, Tile.food, Tile.verticalWall },
			{ Tile.verticalWall, Tile.powerUp, Tile.food, Tile.food, Tile.verticalWall, Tile.verticalWall, Tile.food,
					Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food,
					Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.verticalWall,
					Tile.verticalWall, Tile.food, Tile.food, Tile.powerUp, Tile.verticalWall },
			{ Tile.downLeftCorner, Tile.horizontalWall, Tile.upRightCorner, Tile.food, Tile.verticalWall,
					Tile.verticalWall, Tile.food, Tile.upLeftCorner, Tile.upRightCorner, Tile.food, Tile.upLeftCorner,
					Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.horizontalWall, Tile.upRightCorner, Tile.food, Tile.upLeftCorner,
					Tile.upRightCorner, Tile.food, Tile.verticalWall, Tile.verticalWall, Tile.food, Tile.upLeftCorner,
					Tile.horizontalWall, Tile.downRightCorner },
			{ Tile.upLeftCorner, Tile.horizontalWall, Tile.downRightCorner, Tile.food, Tile.downLeftCorner,
					Tile.downRightCorner, Tile.food, Tile.verticalWall, Tile.verticalWall, Tile.food,
					Tile.downLeftCorner, Tile.horizontalWall, Tile.horizontalWall, Tile.upRightCorner,
					Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall, Tile.downRightCorner, Tile.food,
					Tile.verticalWall, Tile.verticalWall, Tile.food, Tile.downLeftCorner, Tile.downRightCorner,
					Tile.food, Tile.downLeftCorner, Tile.horizontalWall, Tile.upRightCorner },
			{ Tile.verticalWall, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.verticalWall,
					Tile.verticalWall, Tile.food, Tile.food, Tile.food, Tile.food, Tile.verticalWall, Tile.verticalWall,
					Tile.food, Tile.food, Tile.food, Tile.food, Tile.verticalWall, Tile.verticalWall, Tile.food,
					Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.verticalWall },
			{ Tile.verticalWall, Tile.food, Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.horizontalWall, Tile.downRightCorner, Tile.downLeftCorner,
					Tile.horizontalWall, Tile.horizontalWall, Tile.upRightCorner, Tile.food, Tile.verticalWall,
					Tile.verticalWall, Tile.food, Tile.upLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.downRightCorner, Tile.downLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.horizontalWall, Tile.upRightCorner, Tile.food, Tile.verticalWall },
			{ Tile.verticalWall, Tile.food, Tile.downLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.horizontalWall, Tile.downRightCorner, Tile.food, Tile.downLeftCorner,
					Tile.downRightCorner, Tile.food, Tile.downLeftCorner, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.horizontalWall, Tile.downRightCorner, Tile.food, Tile.verticalWall },
			{ Tile.verticalWall, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food,
					Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food,
					Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food, Tile.food,
					Tile.verticalWall },
			{ Tile.downLeftCorner, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall, Tile.horizontalWall,
					Tile.horizontalWall, Tile.horizontalWall, Tile.downRightCorner } };

	/***
	 * Constructor for {@link pacmanBoard.PacmanBoard PacmanBoard}
	 */
	public PacmanBoard() {
		super(28, 31, Tile.open);
		fillBoard();
	}

	/***
	 * Fills the board with the elements from
	 * {@link pacmanBoard.PacmanBoard#boardTiles boardTiles}
	 */
	private void fillBoard() {
		for (int i = 0; i < getCols(); i++) {
			for (int j = 0; j < getRows(); j++) {
				setItem(new PositionItem<Tile>(new Position(i, j), boardTiles[j][i]));
			}
		}
	}

	/***
	 * method for getting a list of {@link grid.PositionItem PositionItems} of
	 * images from the {@link pacmanBoard.Tile.Tile Tiles} in the board.
	 * 
	 * @return {@link ArrayList} of {@link ImageIcon ImageIcons}
	 */
	public ArrayList<PositionItem<ImageIcon>> getSpriteList() {
		ArrayList<PositionItem<ImageIcon>> spriteList = new ArrayList<PositionItem<ImageIcon>>(0);
		for (int i = 0; i < getCols(); i++) {
			for (int j = 0; j < getRows(); j++) {
				Position pos = new Position(i, j);
				ImageIcon item = getPosition(pos).img;
				PositionItem<ImageIcon> sprite = new PositionItem<ImageIcon>(pos, item);
				spriteList.add(sprite);
			}
		}
		return spriteList;
	}

	/***
	 * 
	 * @param tile the type of {@link pacmanBoard.Tile.Tile Tile} you want to count
	 * @return the number of times that tile occurs in the board
	 */
	public int getNumberOf(Tile tile) {
		int count = 0;
		for (int i = 0; i < getCols(); i++) {
			for (int j = 0; j < getRows(); j++) {
				Position pos = new Position(i, j);
				if (tile.equals(getPosition(pos))) {
					count++;
				}
			}
		}
		return count;
	}

}
