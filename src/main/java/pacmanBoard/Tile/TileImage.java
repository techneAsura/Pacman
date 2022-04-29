package pacmanBoard.Tile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/***
 * A class that contains pre loaded ImageIcons
 * @author Thomas
 *
 */
class TileImage {
	ImageIcon img;
	static final TileImage open = new TileImage("open.png");
	static final TileImage food = new TileImage("food.png");
	static final TileImage powerUp = new TileImage("PowerUp.png");
	static final TileImage verticalWall = new TileImage("verticalWall.png");
	static final TileImage horizontalWall = new TileImage("horizontalWall.png");
	static final TileImage upLeftCorner = new TileImage("upperLeft.png");
	static final TileImage upRightCorner = new TileImage("upperRight.png");
	static final TileImage downLeftCorner = new TileImage("bottomLeft.png");
	static final TileImage downRightCorner = new TileImage("bottomRight.png");

	private TileImage(String filePath) {
			img = new ImageIcon(ClassLoader.getSystemClassLoader().getResource(filePath));
		}
	}
