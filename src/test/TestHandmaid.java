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
		player1.setCard(card);
		game.playCard(player1);
		
		assert.assertEquals('p', player1.getState());
	}

}
