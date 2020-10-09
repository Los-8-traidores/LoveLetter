package test;

import model.*;
import cards.*;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestGuard {

	@Test
	void testCardCreation() {
		Card cardGuard = new Guard();

		assertEquals("Guardia", cardGuard.getCardName());
		assertEquals(
				"Elige a otro jugador para adivinar su carta (de tipo no guardia). Si la adivinas correctamente, el jugador queda descalificado",
				cardGuard.getCardEffectDesc());
		assertEquals(1, cardGuard.getCardStrength());
	}

	@Test
	void testTargetCorrect() {
		System.out.println();
		System.out.println("testTargetCorrect -- Escribir 2");
		Card cardGuard = new Guard();
		Player player1 = new Player(cardGuard);
		Player player2 = new Player(2, "Jugador 2");
		Player player3 = new Player(3, "Jugador 3");
		ArrayList<Player> listPlayers = new ArrayList<Player>();

		listPlayers.add(player1);
		listPlayers.add(player2);
		listPlayers.add(player3);

		player1.setTurn(true);

		Game game = new Game();

		assertEquals(player2, game.target(listPlayers));
	}

	@Test
	void testEffectAssertCard() {
		System.out.println();
		System.out.println("testEffectAssertCard -- Escribir Mucama");
		Card cardGuard = new Guard();
		Card cardHandmaid = new Handmaid();
		Player player1 = new Player(cardGuard);
		Player player2 = new Player(2, "Jugador 2", cardHandmaid);

		cardGuard.effect(player1, player2);

		assertEquals(false, player2.isAlive());
	}

	@Test
	void testEffectNotAssertCard() {
		System.out.println();
		System.out.println("testEffectNotAssertCard -- Escribir !Mucama");
		Card cardGuard = new Guard();
		Card cardHandmaid = new Handmaid();
		Player player1 = new Player(cardGuard);
		Player player2 = new Player(2, "Jugador 2", cardHandmaid);

		cardGuard.effect(player1, player2);

		assertEquals(true, player2.isAlive());
	}

}
