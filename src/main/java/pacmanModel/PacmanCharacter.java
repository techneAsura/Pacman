package pacmanModel;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;

import grid.Position;
import grid.PositionItem;

/***
 * The character the user moves around on the screen. It contains a
 * {@link grid.Position Position} that describes the current location of the
 * player, {@link ImageIcon ImageIcons} for all the directions of the player can
 * face, a {@link pacmanModel.PacmanState PacmanState} that describes the
 * current state of the game, and an integer that describes how much time
 * there's left of hunting mode.
 * 
 * @author Thomas
 *
 */
public class PacmanCharacter implements Moveable {
	/***
	 * the players {@link grid.Position Position}
	 */
	private Position position;
	/***
	 * The current ImageIcon, changes depending on what direction the player faces
	 */
	private ImageIcon currentImg;
	/***
	 * a {@link ImageIcon} of the Pacman character facing downwards
	 */
	private ImageIcon down;
	/***
	 * a {@link ImageIcon} of the Pacman character facing upwards
	 */
	private ImageIcon up;
	/***
	 * a {@link ImageIcon} of the Pacman character facing left
	 */
	private ImageIcon left;
	/***
	 * a {@link ImageIcon} of the Pacman character facing right
	 */
	private ImageIcon right;
	/***
	 * the {@link pacmanModel.Direction Direction} the player faces.
	 */
	private Direction direction;
	/***
	 * the current {@link pacmanModel.PacmanState PacmanState} of the game.
	 */
	private PacmanState state;
	/***
	 * describes how much time there is left on hunting mode as an integer
	 */
	private int hunterTimer;

	/***
	 * Constructor for the PacmanCharacter
	 */
	PacmanCharacter() {
		position = new Position(14, 23);
		down = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("pacmanDown.png"));
		up = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("pacmanUp.png"));
		left = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("pacmanLeft.png"));
		right = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("pacmanRight.png"));
		currentImg = left;
		direction = Direction.still;
		state = PacmanState.alive;
	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;
	}

	/***
	 * 
	 * @return a {@link grid.PositionItem PositionItem} that contains the current
	 *         {@link grid.Position} of the player character and
	 */
	PositionItem<ImageIcon> getSprite() {
		PositionItem<ImageIcon> sprite = new PositionItem<ImageIcon>(position, currentImg);
		return sprite;
	}

	void updateDirection(Direction dir) {
		switch (dir) {
		case up:
			currentImg = up;
			direction = dir;
			break;
		case down:
			currentImg = down;
			direction = dir;
			break;
		case right:
			currentImg = right;
			direction = dir;
			break;
		case left:
			currentImg = left;
			direction = dir;
			break;
		default:
			break;
		}
	}

	/***
	 * set the {@link pacmanModel.PacmanState} to dead.
	 */
	void killPlayer() {
		state = PacmanState.dead;
	}

	/***
	 * starts the hunting mode.
	 */
	void startHunting() {
		state = PacmanState.hunting;
		hunterTimer = 40;

	}

	/***
	 * decreases the amount of time left on the hunter
	 * {@link pacmanModel.PacmanCharacter#hunterTimer timer} and exits hunting mode
	 * if the timer hits 0.
	 */
	void progressHunterTimer() {
		hunterTimer--;
		if (hunterTimer == 0) {
			state = PacmanState.alive;
		}
	}

	/***
	 * 
	 * @return the {@link pacmanModel.Direction Direction} the player faces
	 */
	public Direction getDirection() {
		return direction;
	}

	/***
	 * 
	 * @return the {@link pacmanModel.PacmanState PacmanState} of the player
	 */
	public PacmanState getState() {
		return state;
	}
}
