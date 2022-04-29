package pacmanModel;

import grid.Position;
/***
 * an interface that describes something that can be moved.
 * @author Thomas
 *
 */
public interface Moveable {
	/***
	 * Gets the position of the object
	 * @return
	 * the position
	 */
	Position getPosition(); 
	
/***
 * sets the position of the object
 * 
 * @param position the new position
 */
	void setPosition(Position position);
}
