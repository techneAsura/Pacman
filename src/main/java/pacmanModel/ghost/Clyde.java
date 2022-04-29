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
public class Clyde extends Ghost {

	public Clyde(PacmanBoard pacmanBoard, Position position) {
		super(pacmanBoard, position, new ImageIcon(ClassLoader.getSystemClassLoader().getResource("Clyde.png")));
	}
	/***
	 * Clyde's getDestination tries to move to a random place within a 2 tile area
	 * around where the player is. During hunting mode he moves to the lower right
	 * corner
	 */
	@Override
	public Position getDestination(PacmanCharacter pacman) {
		Random random = new Random();
		if (pacman.getState() == PacmanState.hunting) {
			int i = random.nextInt(15);
			if (i < 5) {
				return new Position(random.nextInt(26), random.nextInt(29));
			}
			return (new Position(26, 29));
		}
		Position pos = pacman.getPosition();
		pos = new Position(pos.col + (random.nextInt(5) - 2), pos.row + random.nextInt(5) - 2);
		return pos;
	}
}
