package pacmanController;

import pacmanModel.Direction;
import pacmanModel.Moveable;
import pacmanModel.PacmanState;

public interface Controllable {
	/***
	 * 
	 * @param obj  the object to be moved
	 * @param delX the change in its x position
	 * @param delY the change in its y position
	 */
	public void move(Moveable obj, int delX, int delY);

	/***
	 * changes the {@link pacmanModel.Direction Direction} the player points in
	 * 
	 * @param direction the new direction the player should point in
	 */
	public void updatePlayerDirection(Direction direction);

	/***
	 * 
	 * @return the {@link pacmanModel.PacmanState PacmanState} of the board
	 */
	public PacmanState getState();

	/***
	 * each time this method is called the game ticks 1 step forward
	 */
	public void clockTick();
}
