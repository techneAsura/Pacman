package pacmanView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

import grid.PositionItem;
import pacmanModel.PacmanState;

/***
 * the class responsible for displaying the game.
 * 
 * @author Thomas
 *
 */
public class PacmanView extends JComponent {
	{
		this.setFocusable(true);
	}
	/***
	 * the model to be displayed.
	 */
	private Viewable model;

	/***
	 * constructor for {@link pacmanView.PacmanView PacmanView}
	 * 
	 * @param model the model to be displayed
	 */
	public PacmanView(Viewable model) {
		this.model = model;
	}

	public void paint(Graphics g) {
		super.paint(g);

	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		drawSprites(g2d, model.getSpriteIterator());
		drawState(g2d);
	}

	/***
	 * Draws an overlay depending on what the {@link pacmanModel.PacmanState game
	 * state} is.
	 * 
	 * @param g the graphics object to draw on
	 */
	private void drawState(Graphics2D g) {
		if (model.getState() == PacmanState.dead) {
			g.setColor(Color.BLACK);
			g.fillRect(0, (int) (this.getHeight() * (2.0 / 5)), this.getWidth(), (int) (this.getHeight() * (1.0 / 5)));
			Font comic_sans = new Font("Comic-Sans", Font.ITALIC, 64);
			g.setFont(comic_sans);
			g.setColor(Color.RED);
			g.drawString("Game over", this.getWidth() / 5, (int) (this.getHeight() / 2));
		}

		if (model.getState() == PacmanState.win) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			Font comic_sans = new Font("Comic-Sans", Font.ITALIC, 64);
			g.setFont(comic_sans);
			g.setColor(Color.GREEN);
			g.drawString("Victory", this.getWidth() / 5, (int) (this.getHeight() / 2));
		}
	}

	/***
	 * Draws all the sprites in the model.
	 * 
	 * @param g2d     the graphics object to drawn on
	 * @param Sprites an Iterator over the sprites to be drawn
	 */
	private void drawSprites(Graphics2D g2d, Iterator<PositionItem<ImageIcon>> Sprites) {
		while (Sprites.hasNext()) {
			PositionItem<ImageIcon> currentSprite = Sprites.next();
			int spriteX = currentSprite.getPos().col;
			int spriteY = currentSprite.getPos().row;
			Image spriteImage = currentSprite.getItem().getImage();
			drawSprite(g2d, spriteX, spriteY, spriteImage);
		}

	}

	/***
	 * Draws a singular {@link ImageIcon} 
	 * @param g2d         the graphics object to draw on
	 * @param spriteX     the x position of where to draw the sprite
	 * @param spriteY     the y position of where to draw the sprite
	 * @param spriteImage the {@link ImageIcon} to display.
	 */
	private void drawSprite(Graphics2D g2d, int spriteX, int spriteY, Image spriteImage) {
		g2d.drawImage(spriteImage, spriteX * 16, spriteY * 16, this);
	}

	@Override
	public Dimension getPreferredSize() {
		int preferredWidth = 16 * 28;
		int preferredHeight = 16 * 31;
		return new Dimension(preferredWidth, preferredHeight);
	}

}
