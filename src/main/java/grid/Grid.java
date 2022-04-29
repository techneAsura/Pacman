package grid;

import java.util.ArrayList;
import java.util.Iterator;
/***
 * A grid consisting of a 2d ArrayList
 * @author Thomas
 *
 * @param <E>
 */
public interface Grid<E> {
	/***
	 * 
	 * @param positionItem the object you want to put into the grid, will override
	 *                     objects already in the grid.
	 * @return true if the {@link grid.Position position} is within the grid. false
	 *         if the its outside the grid. Uses
	 *         {@link grid.Grid#withinGrid(Position) withinGrid} to validate the
	 *         position
	 */
	public void setItem(PositionItem<E> positionItem);

	/***
	 * 
	 * @param position the position you want validate is within the board
	 * @return 
	 * true if it is within the board
	 * @throws
	 * {@link grid.PositionOutOfGridException}
	 * 
	 */
	public boolean withinGrid(Position position);

	/***
	 * 
	 * @param position the position within the grid you want to get the element of.
	 * @return the element stored at in the grid at the position
	 *         <p>
	 *         Uses {@link grid.Grid#withinGrid(Position) withinGrid} to validate
	 *         that the position is within the grid. Throws an exception if its
	 *         outside.
	 * @throws  
	 * RuntimeException "position is not within grid"
	 */
	public E getPosition(Position position);
	/***
	 * 
	 * @return
	 * the size of the grid in the x direction
	 */
	public int getCols();
	/***
	 * 
	 * @return
	 * the size of the grid in the y direction
	 */
	public int getRows();
}
