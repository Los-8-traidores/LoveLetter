package test;

import model.*;
import cards.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestHandmaid {

	@Test
	void testCambioState() {
		Game game = new Game();
		Player player1 = new Player();
		
		assert.assertEquals('p', game.playCard(player1));
	}

}
