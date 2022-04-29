package pacmanModel.ghost;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.swing.ImageIcon;

import org.w3c.dom.Node;

import java.lang.Math;

import grid.GridImpl;
import grid.Position;
import grid.PositionItem;
import pacmanBoard.PacmanBoard;
import pacmanModel.Direction;
import pacmanModel.Moveable;
import pacmanModel.PacmanCharacter;
import pacmanModel.PacmanState;
import pacmanView.Viewable;

/***
 * an abstract class that contains all the info and logic for a ghost.
 * 
 * @author Thomas
 *
 */
public abstract class Ghost implements Moveable {
	/***
	 * the {@link grid.position Position} the ghost spawned in.
	 */
	private Position spawnPosition;
	/***
	 * the current {@link grid.position Position} of the ghost.
	 */
	private Position position;
	/***
	 * the current {@link ImageIcon} of the ghost.
	 */
	private ImageIcon img;
	/***
	 * the regular {@link ImageIcon} of the ghost
	 */
	private ImageIcon normalImg;
	/***
	 * the {@link ImageIcon} for when the game is in hunting mode
	 */
	private ImageIcon huntedImg;
	/***
	 * the {@link pacmanBoard.PacmanBoard game board}. Used for pathfinding.
	 */
	private PacmanBoard pacmanBoard;

	/***
	 * Constructor for a ghost.
	 * 
	 * @param pacmanBoard the game board
	 * @param position    where you want the ghost to spawn in
	 * @param img         the {@link ImageIcon} for the ghost
	 */
	Ghost(PacmanBoard pacmanBoard, Position position, ImageIcon img) {
		spawnPosition = position;
		this.pacmanBoard = pacmanBoard;
		this.position = position;
		normalImg = img;
		this.img = img;
		huntedImg = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("huntedGhost.png"));
	}

	/***
	 * 
	 * @return the current {@link ImageIcon} of the ghost
	 */
	public PositionItem<ImageIcon> getSprite() {
		PositionItem<ImageIcon> sprite = (new PositionItem<ImageIcon>(position, img));
		return sprite;
	}

	/***
	 * Checks around a given {@link grid.Position Position} and returns the all
	 * neighbours in the cardinal directions that can be walked through.
	 * 
	 * @param position the {@link grid.Position Position} you want to look around.
	 * @return an {@link ArrayList} of all the valid neighbouring
	 *         {@link grid.Position Positions}
	 */
	private ArrayList<Position> getValidNeighbours(Position position) {
		int col = position.col;
		int row = position.row;
		Position aboveNeighbour = new Position(col, row - 1);
		Position belowNeighbour = new Position(col, row + 1);
		Position leftNeighbour = new Position(col + 1, row);
		Position rightNeighbour = new Position(col - 1, row);
		ArrayList<Position> neighbours = new ArrayList<Position>(0);
		neighbours.add(aboveNeighbour);
		neighbours.add(belowNeighbour);
		neighbours.add(rightNeighbour);
		neighbours.add(leftNeighbour);

		ArrayList<Position> validNeighbours = new ArrayList<Position>(0);
		for (Position pos : neighbours) {
			if (pacmanBoard.withinGrid(pos)) {
				if (pacmanBoard.getPosition(pos).permable) {
					validNeighbours.add(pos);
				}
			}
		}
		return validNeighbours;
	}

	/***
	 * generates the next {@link grid.Position Position} the ghost should move to
	 * determined by the info regarding the player's character.
	 * 
	 * @param player the player's character
	 * @return the next {@link grid.Position Position} to move to
	 */
	public Position nextMove(PacmanCharacter player) {
		Position destination = getDestination(player);
		ArrayList<Position> path = findShortestPathBFS(position, destination);
		if (path.size() == 1) {
			return path.get(0);
		} else
			return path.get(1);
	}

	/***
	 * An implementation of breadth first search. Inspiration and code snippets
	 * gotten from:
	 * https://stackoverflow.com/questions/61113331/bfs-search-in-2d-grid-java-shortest-path
	 * 27/04/2022.
	 * 
	 * @param start       the start Position
	 * @param destination the destination
	 * @return the shortes path from one {@link grid.Position Position} to another
	 *         {@link grid.Position Position} through the game board as an
	 *         {@link ArrayList} of {@link grid.Position Positions}
	 */
	private ArrayList<Position> findShortestPathBFS(Position start, Position destination) {
		Queue<Position> toSearch = new LinkedList<Position>();
		Map<Position, Position> parentMap = new HashMap<>();
		ArrayList<Position> path = new ArrayList<Position>(0);
		Map<Integer, Boolean> searched = new HashMap<>();

		parentMap.put(start, null);
		toSearch.add(start);
		Position i = start;
		while (!toSearch.isEmpty()) {
			i = toSearch.remove();
			if (i.equals(destination)) {
				break;
			}
			searched.put(i.hashCode(), true);
			ArrayList<Position> neighbours = getValidNeighbours(i);
			for (Position j : neighbours) {
				if (!searched.containsKey(j.hashCode())) {
					toSearch.add(j);
					parentMap.put(j, i);
				}
			}
		}

		Position curr = i;
		while (curr != null) {
			path.add(0, curr);
			curr = parentMap.get(curr);
		}
		return path;
	}

	/***
	 * The method in the abstract class Ghost should not be used, all ghosts should
	 * be subclasses of the Ghost abstract class and need to have their own
	 * getDestination method
	 * 
	 * @param pacman
	 * the player's character
	 * @return
	 * a {@link grid.Position Position} that the ghost should try to move to.
	 */
	public Position getDestination(PacmanCharacter pacman) {
		return null;
	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;

	}
/***
 * kills the ghosts and sets it back to {@link pacmanModel.ghost.Ghost#spawnPosition spawn position}
 */
	public void killGhost() {
		setPosition(spawnPosition);
	}
/***
 * determines if the game is in hunting mode and updates variables thereafter.
 * @param state
 */
	public void isHunted(PacmanState state) {
		if (state == PacmanState.hunting) {
			img = huntedImg;
		}
			else img = normalImg;
	}
}
