package pacmanController;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;

import pacmanModel.Direction;
import pacmanModel.PacmanState;
import pacmanView.PacmanView;

/***
 * A class that takes in keyboard inputs and updates the game accordingly.
 * 
 * @author Thomas
 *
 */
public class PacmanController implements java.awt.event.KeyListener, java.awt.event.ActionListener {
	/***
	 * a {@link PacmanControll.Controllable Controllable} object
	 */
	private Controllable model;
	/***
	 * a {@link pacmanView.PacmanView PacmanView}
	 */
	private PacmanView view;
	private javax.swing.Timer timer;
/***
 * construtor for {@link pacmanController.PacmanController PacmanController}
 * @param model
 * 			The Model that key inputs should manipulate. 
 * @param view
 * 		The display.
 */
	public PacmanController(Controllable model, PacmanView view) {
		this.model = model;
		this.view = view;
		this.timer = new javax.swing.Timer(333, this);
		this.view.addKeyListener(this);
		timer.start();

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (model.getState() != PacmanState.dead && model.getState() != PacmanState.win) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				model.updatePlayerDirection(Direction.right);
				view.repaint();
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				model.updatePlayerDirection(Direction.left);
				view.repaint();
			} else if (e.getKeyCode() == KeyEvent.VK_UP) {
				model.updatePlayerDirection(Direction.up);
				view.repaint();
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				model.updatePlayerDirection(Direction.down);
				view.repaint();
			} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {

			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.clockTick();
		view.repaint();
	}

}
