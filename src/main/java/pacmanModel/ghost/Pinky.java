package pacmanModel.ghost;

import java.util.Random;

import javax.swing.ImageIcon;

import grid.Position;
import pacmanBoard.PacmanBoard;
import pacmanModel.Direction;
import pacmanModel.PacmanCharacter;
import pacmanModel.PacmanState;

/***
 * a subclass of {@link pacmanModel.ghost.Ghost Ghost}
 * 
 * @author Thomas
 *
 */

public class Pinky extends Ghost {
	public Pinky(PacmanBoard pacmanBoard, Position position) {
		super(pacmanBoard, position, new ImageIcon(ClassLoader.getSystemClassLoader().getResource("Pinky.png")));
	}

	/***
	 * Pinky's getDestination tries to the side of where player is depending on which direction the player is facing. During
	 * hunting mode she moves to the lower left corner
	 */
	@Override
	public Position getDestination(PacmanCharacter pacman) {
		if (pacman.getState() == PacmanState.hunting) {
			Random random = new Random();
			int i = random.nextInt(15);
			if (i < 5) {
				return new Position(random.nextInt(26), random.nextInt(29));
			}
			return (new Position(1, 29));
		}
		Position pos = pacman.getPosition();
		Direction dir = pacman.getDirection();
		switch (dir) {
		case down:
			pos = new Position(pos.col + 3, pos.row);
			break;
		case left:
			pos = new Position(pos.col, pos.row - 3);
			break;
		case right:
			pos = new Position(pos.col, pos.row + 3);
			break;
		case still:
			pos = new Position(pos.col, pos.row);
			break;
		case up:
			pos = new Position(pos.col - 3, pos.row);
			break;
		default:
			break;
		}
		return pos;
	}
}