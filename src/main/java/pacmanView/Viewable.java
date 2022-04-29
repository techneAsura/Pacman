package pacmanView;

import java.awt.Image;
import java.util.Iterator;

import javax.swing.ImageIcon;

import grid.PositionItem;
import pacmanModel.PacmanState;
/***
 * an interface used for abstraction
 * @author Thomas
 *
 */
public interface Viewable {
	/***
	 * @return
	 * an iterator over {@link grid.PositionItem} of all the {@link ImageIcon ImageIcon's} to be displayed.
	 */
	public Iterator<PositionItem<ImageIcon>> getSpriteIterator();
	
	/***
	 * 
	 * @return
	 * the current (@link pacmanModel.PacmanState state} of the game;
	 */
	public PacmanState getState();
}
