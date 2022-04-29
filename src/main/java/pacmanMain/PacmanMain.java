package pacmanMain;

import javax.swing.JComponent;
import javax.swing.JFrame;

import pacmanBoard.PacmanBoard;
import pacmanController.PacmanController;
import pacmanModel.PacmanModel;
import pacmanView.PacmanView;

public class PacmanMain {
	public static final String WINDOW_TITLE = "Pacman";

	public static void main(String[] args) {
		PacmanModel model = new PacmanModel();
		PacmanView view = new PacmanView(model);
		PacmanController controller = new PacmanController(model,view);
		JFrame frame = new JFrame(WINDOW_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(view);
		frame.pack();
		frame.setVisible(true);
	}

}
