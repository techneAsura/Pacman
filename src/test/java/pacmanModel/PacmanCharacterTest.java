package pacmanModel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PacmanCharacterTest {
	PacmanCharacter pacmanCharacter;
	public PacmanCharacterTest() {
		pacmanCharacter = new PacmanCharacter();
	}
	
	@Test
	public void killTest(){
		pacmanCharacter.killPlayer();
		assertEquals(pacmanCharacter.getState(),PacmanState.dead);
	}
	@Test
	public void huntTest() {
		pacmanCharacter.startHunting();
		for (int i = 0; i < 40; i++) {
			pacmanCharacter.progressHunterTimer();
		}
		assertEquals(pacmanCharacter.getState(),PacmanState.alive);
	}
	

}
