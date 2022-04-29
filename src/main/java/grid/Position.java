package grid;

import java.util.Objects;

/***
 * Contains 2 integers, describes {@link #col col} and {@link #row row} of an
 * object.
 * 
 * @author Thomas
 *
 */
public class Position {
	/***
	 * the x component.
	 */
	public int col;
	/***
	 * the y component
	 */
	public int row;

	/***
	 * 
	 * @param col the x component
	 * @param row the y component
	 */

	public Position(int col, int row) {
		this.col = col;
		this.row = row;
	}

	@Override
	public int hashCode() {
		return Objects.hash(col, row);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		return col == other.col && row == other.row;
	}
}
