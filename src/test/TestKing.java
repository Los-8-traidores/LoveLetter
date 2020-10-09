package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import model.*;
import cards.*;

class TestKing {

	@Test
	void testCardCreation() {
		Card cardKing = new King();

		assertEquals("Rey", cardKing.getCardName());
		assertEquals("Elige otro jugador para intercambiar cartas",cardKing.getCardEffectDesc());
		assertEquals(6, cardKing.getCardStrength());
	}

	@Test
	void testExchageCards() {
		Card cardGuard = new Guard();
		Card cardHandmaid = new Handmaid();
		Card cardKing = new King();
		
		Player player1 = new Player(cardGuard);
		Player player2 = new Player(2, "Jugador 2", cardHandmaid);

		cardKing.effect(player1, player2);
		
		assertEquals("Guardia", player2.getCard1().getCardName());
		assertEquals("Mucama", player1.getCard1().getCardName());
	}

}
