package pacmanModel;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;

import grid.Position;
import grid.PositionItem;
import pacmanBoard.PacmanBoard;
import pacmanBoard.Tile.Tile;
import pacmanController.Controllable;
import pacmanModel.ghost.Blinky;
import pacmanModel.ghost.Clyde;
import pacmanModel.ghost.Ghost;
import pacmanModel.ghost.Inky;
import pacmanModel.ghost.Pinky;
import pacmanView.Viewable;

/***
 * The class that handles most of the game logic and recieves calls from the
 * controller.
 * 
 * @author Thomas
 *
 */
public class PacmanModel implements Controllable, Viewable {
	/***
	 * the {@link pacmanBoard.PacmanBoard game board}. Contains all the
	 * {@link pacmanBoard.Tile.Tile Tiles} that describe the current map
	 */
	private PacmanBoard pacmanBoard;
	/***
	 * the {@link pacmanModel.PacmanCharacter player character}
	 */
	PacmanCharacter playerCharacter;
	/***
	 * an integer that keeps track of how many {@link pacmanBoard.Tile.Tile#food
	 * food tiles} has been consumed.
	 */
	private int foodEaten;
	/***
	 * an integer that keeps track of how many {@link pacmanBoard.Tile.Tile#food
	 * food tiles} that has to be consumed to win the game. It is determined by
	 * {@link pacmanBoard.PacmanBoard#getNumberOf(Tile) getNumberOf} method
	 */
	private int totalFood;
	/***
	 * a special {@link grid.Position Position} that brings you to another location
	 * determined by {@link pacmanModel.PacmanModel#tunnelLeftExit tunnelLeftExit}
	 */
	Position tunnelLeft;
	/***
	 * the exit {@link grid.Position Position} for
	 * {@link pacmanModel.PacmanModel#tunnelLeft tunnelLeft}
	 */
	Position tunnelLeftExit;
	/***
	 * a special {@link grid.Position Position} that brings you to another location
	 * determined by {@link pacmanModel.PacmanModel#tunnelRightExit tunnelRightExit}
	 */
	Position tunnelRight;
	/***
	 * the exit {@link grid.Position Position} for
	 * {@link pacmanModel.PacmanModel#tunnelRight tunnelRight}
	 */
	Position tunnelRightExit;
	/***
	 * the {@link pacmanModel.ghost.Ghost Ghosts} that chase the player.
	 */
	private Ghost[] ghosts;
	/***
	 * the current {@link pacmanModel.PacmanState PacmanState} of the game.
	 */
	private PacmanState state;

	/***
	 * the constructor for the {@link pacmanModel.PacmanModel PacmanModel}
	 */
	public PacmanModel() {
		foodEaten = 0;
		tunnelLeft = new Position(0, 14);
		tunnelLeftExit = new Position(26, 14);
		tunnelRight = new Position(27, 14);
		tunnelRightExit = new Position(1, 14);
		this.pacmanBoard = new PacmanBoard();
		this.playerCharacter = new PacmanCharacter();
		this.ghosts = new Ghost[] { new Inky(pacmanBoard, new Position(12, 14)),
				new Blinky(pacmanBoard, new Position(13, 14)), new Clyde(pacmanBoard, new Position(14, 14)),
				new Pinky(pacmanBoard, new Position(15, 14)) };
		totalFood = pacmanBoard.getNumberOf(Tile.food);
	}

	/***
	 * 
	 * @return {@link pacmanModel.PacmanModel#pacmanBoard pacmanBoard}
	 */
	PacmanBoard getBoard() {
		return pacmanBoard;
	}

	@Override
	public Iterator<PositionItem<ImageIcon>> getSpriteIterator() {
		ArrayList<PositionItem<ImageIcon>> spriteList = new ArrayList<PositionItem<ImageIcon>>(0);
		for (PositionItem<ImageIcon> sprite : pacmanBoard.getSpriteList())
			spriteList.add(sprite);
		for (Ghost g : ghosts) {
			spriteList.add(g.getSprite());
		}
		spriteList.add(playerCharacter.getSprite());
		return spriteList.iterator();

	}

	/***
	 * A method that takes in a {@link grid.Position Position} and checks if the
	 * location is a valid place for the player to move to
	 * 
	 * @param pos the position you want to figure out if is valid
	 * @return a boolean, true if the position can be moved to, false if not.
	 */
	private boolean validatePosition(Position pos) {
		return pacmanBoard.getPosition(pos).permable;
	}

	@Override
	public void move(Moveable obj, int delX, int delY) {
		Position pos = obj.getPosition();
		Position newPos = new Position(pos.col + delX, pos.row + delY);
		if (newPos.equals(tunnelLeft)) {
			obj.setPosition(tunnelLeftExit);
			playerEat(tunnelLeftExit);
			return;
		}
		if (newPos.equals(tunnelRight)) {
			obj.setPosition(tunnelRightExit);
			playerEat(tunnelRightExit);
			return;
		}
		if (validatePosition(newPos)) {
			obj.setPosition(newPos);
			playerEat(newPos);
		}
	}

	/***
	 * The method responsible for eating the {@link pacmanBoard.Tile.Tile Tiles} and
	 * incrementing the number of food tiles eaten
	 * 
	 * @param pos the position to eat
	 */
	private void playerEat(Position pos) {
		if (pacmanBoard.getPosition(pos).equals(Tile.food)) {
			foodEaten++;
		}
		if (pacmanBoard.getPosition(pos).equals(Tile.powerUp)) {
			playerCharacter.startHunting();
		}
		pacmanBoard.setItem(new PositionItem<Tile>(pos, Tile.open));
	}

	@Override
	public void updatePlayerDirection(Direction dir) {
		playerCharacter.updateDirection(dir);
	}

	/***
	 * fires off all the methods neccesary to progress the Ghosts each tick
	 */
	private void clockTickGhosts() {
		for (Ghost g : ghosts) {
			g.isHunted(state);
			// the check to kill the player or kill the ghost is triggered before and after
			// the ghosts move to stop the player from being able to move through the ghosts if they walk
			// towards each other
			if (g.getPosition().equals(playerCharacter.getPosition())) {
				if (state == PacmanState.alive) {
					playerCharacter.killPlayer();
				}
				if (state == PacmanState.hunting) {
					g.killGhost();
				}
			}
			g.setPosition(g.nextMove(playerCharacter));
			if (g.getPosition().equals(playerCharacter.getPosition())) {
				if (state == PacmanState.alive) {
					playerCharacter.killPlayer();
				}
				if (state == PacmanState.hunting) {
					g.killGhost();
				}
			}
		}
	}

	@Override
	public void clockTick() {
		state = playerCharacter.getState();
		if (foodEaten >= totalFood) {
			state = PacmanState.win;
			return;
		}
		if (state == PacmanState.hunting) {
			closeGhostPen();
		}
		if (state == PacmanState.alive) {
			openGhostPen();
		}
		if (state != PacmanState.dead) {
			clockTickPlayer();
			clockTickGhosts();
		}

	}

	/***
	 * fires off all the methods neccesary to progress the player each tick
	 */
	private void clockTickPlayer() {
		Direction direction = playerCharacter.getDirection();
		if (state == PacmanState.hunting) {
			playerCharacter.progressHunterTimer();
		}
		switch (direction) {
		case down:
			move(playerCharacter, 0, 1);
			break;
		case left:
			move(playerCharacter, -1, 0);
			break;
		case right:
			move(playerCharacter, 1, 0);
			break;
		case still:
			break;
		case up:
			move(playerCharacter, 0, -1);
			break;
		default:
			break;
		}
	}

	/***
	 * closes off the pen the ghosts spawn in in the center of the board
	 */
	private void closeGhostPen() {
		pacmanBoard.setItem(new PositionItem<Tile>(new Position(13, 12), Tile.horizontalWall));
		pacmanBoard.setItem(new PositionItem<Tile>(new Position(14, 12), Tile.horizontalWall));
	}

	/***
	 * opens the pen the ghosts spawn in in the center of the board
	 */
	private void openGhostPen() {
		pacmanBoard.setItem(new PositionItem<Tile>(new Position(13, 12), Tile.open));
		pacmanBoard.setItem(new PositionItem<Tile>(new Position(14, 12), Tile.open));
	}

	@Override
	public PacmanState getState() {
		return state;
	}
}
