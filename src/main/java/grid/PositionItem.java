package grid;

/***
 * Contains a {@link grid.Position position} object and a generic &ltE> item.
 * 
 * @author Thomas
 *
 * @param <E> the type of object the PositionItem should hold.
 * 
 */
public class PositionItem<E> {
	/***
	 * a {@link grid.Position position} object
	 */
	private Position pos;
	/***
	 * the object that is stored.
	 */
	private E item;

	/***
	 * Constructor for {@link PositionItem}
	 * 
	 * @param pos  a {@link grid.Position position} object
	 * @param item a generic object of type E
	 */
	public PositionItem(Position pos, E item) {
		this.item = item;
		this.pos = pos;
	}
	/***
	 * returns the {@link grid.PositionItem#item item} that is stored.
	 * @return
	 * 		{@link grid.PositionItem#item item}
	 */
	public E getItem() {
		return item;
	}
/***
 * 
 *  returns the {@link grid.PositionItem#pos position} that is stored.
	 * @return
	 * {@link grid.PositionItem#pos position}
 */
	public Position getPos() {
		return pos;
	}

}
