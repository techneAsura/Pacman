package grid;

import java.util.ArrayList;
import java.util.Iterator;

/***
 * A grid consisting of a 2d ArrayList. Implements the {@link grid.Grid Grid}
 * interface.
 * 
 * @author Thomas
 *
 * @param <E> What type of objects the grid should hold.
 */
public class GridImpl<E> implements Grid<E> {
	private ArrayList<ArrayList<E>> grid;
	private int cols;
	private int rows;

	/***
	 * Constructor for grid with defaultValue which all elements will start as
	 * 
	 * @param rows
	 * @param cols
	 * @param defaultValue
	 */
	@SuppressWarnings("unchecked")
	public GridImpl(int cols, int rows, E defaultValue) {
		this.cols = cols;
		this.rows = rows;
		this.grid = new ArrayList<ArrayList<E>>(0);

		for (int i = 0; i < cols; i++) {
			grid.add((ArrayList<E>) new ArrayList<>(0));
			for (int j = 0; j < rows; j++) {
				grid.get(i).add(defaultValue);
			}
		}
	}

	@Override
	public int getCols() {
		return cols;
	}

	@Override
	public int getRows() {
		return rows;
	}

	@Override
	public boolean withinGrid(Position position) {
		int col = position.col;
		int row = position.row;
		if (col < 0) {
			return false;
		}
		if (col >= cols) {
			return false;
		}
		if (row < 0) {
			return false;
		}
		if (row >= rows) {
			return false;
		}

		return true;
	}

	@Override
	public E getPosition(Position position) {

		if (withinGrid(position)) {
			int col = position.col;
			int row = position.row;
			return grid.get(col).get(row);
		}
		return null;
	}

	@Override
	public void setItem(PositionItem<E> positionItem) {
		Position pos = positionItem.getPos();
		if (withinGrid(pos)) {
			int col = pos.col;
			int row = pos.row;
			E item = positionItem.getItem();
			grid.get(col).set(row, item);
		}
	}
}
