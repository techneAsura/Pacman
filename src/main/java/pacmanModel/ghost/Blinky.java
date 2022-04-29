package pacmanModel.ghost;

import java.util.Random;

import javax.swing.ImageIcon;

import grid.Position;
import pacmanBoard.PacmanBoard;
import pacmanModel.PacmanCharacter;
import pacmanModel.PacmanState;

/***
 * a subclass of {@link pacmanModel.ghost.Ghost Ghost}
 * 
 * @author Thomas
 *
 */
public class Blinky extends Ghost {
	public Blinky(PacmanBoard pacmanBoard, Position position) {
		super(pacmanBoard, position, new ImageIcon(ClassLoader.getSystemClassLoader().getResource("Blinky.png")));
	}
	/***
	 * Blinky's getDestination tries to move directly to where the player is. During hunting mode he moves to the upper left corner
	 */
	@Override
	public Position getDestination(PacmanCharacter pacman) {
		if (pacman.getState() == PacmanState.hunting) {
			Random random = new Random();
			int i = random.nextInt(15);
			if (i<5) {
				return new Position(random.nextInt(26),random.nextInt(29));
			}
			return(new Position(26,1));
		}
		return pacman.getPosition();
	}
}
