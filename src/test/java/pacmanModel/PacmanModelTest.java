package pacmanModel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PacmanModelTest {
	public PacmanModel model;
	public PacmanModelTest() {
		model = new PacmanModel();
	}
	
	/*manual tests: 
	 * check that the player moves in the same direction as its facing
	 * the player cant walk through walls
	 * the player eats food tiles when it moves over them, turning them into open tiles
	 * the ghosts move slowly towards the corners after the player eats the powerup
	 * the box the ghosts spawn in closes when the player eats the powerUp and opens when the powerUp runs out
	 * 
	 */
	@Test
	public void tunnelTest() {
		model.playerCharacter.setPosition(model.tunnelLeft);
		model.move(model.playerCharacter, 0, 0);
		assertEquals(model.playerCharacter.getPosition(), model.tunnelLeftExit);
		model.playerCharacter.setPosition(model.tunnelRight);
		model.move(model.playerCharacter, 0, 0);
		assertEquals(model.playerCharacter.getPosition(), model.tunnelRightExit);
	}
	
	
}
