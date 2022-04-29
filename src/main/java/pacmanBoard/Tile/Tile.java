package pacmanBoard.Tile;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/***
 * A class that contains a Boolean which is used to determine if the Tile can be walked through and an {@link ImageIcon}.
 * @author Thomas
 * 
 */
public class Tile {
	/***
	 * A tile that can be walked through and contains a blank {@link pacmanBoard.Tile.TileImage Image}
	 */
	public static final Tile open = new Tile(TileImage.open.img, true);
	/***
	 * A tile that can be walked through and contains a {@link pacmanBoard.Tile.TileImage Image} with a solid gray circle in the middle
	 */
	public static final Tile food = new Tile(TileImage.food.img, true);
	/***
	 * A tile that can be walked through and contains a {@link pacmanBoard.Tile.TileImage Image} with a blue rhombus in the middle
	 */
	public static final Tile powerUp = new Tile(TileImage.powerUp.img, true);
	/***
	 * A tile that can't be walked through and contains a {@link pacmanBoard.Tile.TileImage Image} with a black vertical line through the middle
	 */
	public static final Tile verticalWall = new Tile(TileImage.verticalWall.img, false);
	/***
	 * A tile that can't be walked through and contains a {@link pacmanBoard.Tile.TileImage Image} with a black horizontal line through the middle
	 */
	public static final Tile horizontalWall = new Tile(TileImage.horizontalWall.img, false);
	/***
	 * A tile that can't be walked through and contains a {@link pacmanBoard.Tile.TileImage Image} with a black line coming in from the right and bottom that ends where they meet in the middle
	 */
	public static final Tile upLeftCorner = new Tile(TileImage.upLeftCorner.img, false);
	/***
	 * A tile that can't be walked through and contains a {@link pacmanBoard.Tile.TileImage Image} with a black line coming in from the left and bottom that ends where they meet in the middle
	 */
	public static final Tile upRightCorner = new Tile(TileImage.upRightCorner.img, false);
	/***
	 * A tile that can't be walked through and contains a {@link pacmanBoard.Tile.TileImage Image} with a black line coming in from the right and top that ends where they meet in the middle
	 */
	public static final Tile downLeftCorner = new Tile(TileImage.downLeftCorner.img, false);
	/***
	 * A tile that can't be walked through and contains a {@link pacmanBoard.Tile.TileImage Image} with a black line coming in from the left and top that ends where they meet in the middle
	 */
	public static final Tile downRightCorner = new Tile(TileImage.downRightCorner.img, false);
	
	/***
	 * the {@link ImageIcon Image} the Tile contains
	 */
	public final ImageIcon img;
	/***
	 * a Boolean that describes if the tile can be walked through.
	 */
	public final boolean permable;
/***
 * 
 * @param img
 *  the {@link ImageIcon} you want the tile to contain.
 * @param permeable
 */
	private Tile( ImageIcon img, boolean permeable) {
		this.img = img;
		this.permable = permeable;
	}
}
