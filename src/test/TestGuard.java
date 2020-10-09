package test;

import model.*;
import cards.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class TestGuard {

	@Test
	void testCardCreation() {
		Card cardGuard = new Guard();

		assertEquals("Guardia", cardGuard.getCardName());
		assertEquals("Elige a otro jugador para adivinar su carta (de tipo no guardia). Si la adivinas correctamente, el jugador queda descalificado",
				cardGuard.getCardEffectDesc());
		assertEquals(1, cardGuard.getCardStrength());
	}

	@Test
	void testTargetCorrect() {
		// Se imprime por consola los ID de los jugadores
		System.out.println();
		System.out.println("testTarget");
		Card cardGuard = new Guard();
		Hand handPlayer = new Hand(cardGuard);
		Player player1 = new Player(handPlayer);
		Player player2 = new Player(2, "Jugador 2");
		Player player3 = new Player(3, "Jugador 3");
		ArrayList<Player> listPlayers = new ArrayList<Player>();

		listPlayers.add(player1);
		listPlayers.add(player2);
		listPlayers.add(player3);

		player1.setTurn(true);
		//No soy un estado, soy un MOUNSTRO!!! CAMBIAR!
		Scanner in = new Scanner(System.in);

		// El test esta pensado para que se elija al 2 por consola.
		assertEquals(player2, cardGuard.target(listPlayers, in));
		in.close();

	}

	@Test
	void testTargetNotPlayerOnTurn() {
		// Se imprime por consola los ID de los jugadores
		System.out.println();
		System.out.println("testTarget");
		Card cardGuard = new Guard();
		Hand handPlayer = new Hand(cardGuard);
		Player player1 = new Player(handPlayer);
		Player player2 = new Player(2, "Jugador 2");
		Player player3 = new Player(3, "Jugador 3");
		ArrayList<Player> listPlayers = new ArrayList<Player>();

		listPlayers.add(player1);
		listPlayers.add(player2);
		listPlayers.add(player3);

		player1.setTurn(true);
		//No soy un estado, soy un MOUNSTRO!!! CAMBIAR!
		Scanner in = new Scanner(System.in);

		assertNotEquals(player1, cardGuard.target(listPlayers, in));
		in.close();
	}

	@Test
	void testEffectAssertCard() {
		System.out.println();
		System.out.println("testEffectAssertCard -- Primero escribir 2 (targetId) y luego escribir 4 (cardStrength)");
		Card cardGuard = new Guard();
		Card cardHandmaid = new Handmaid();
		Hand handPlayer = new Hand(cardGuard);
		Hand handPlayer2 = new Hand(cardHandmaid);
		Player player1 = new Player(handPlayer);
		Player player2 = new Player(2, "Jugador 2", handPlayer2);

		ArrayList<Player> listPlayers = new ArrayList<Player>();

		listPlayers.add(player1);
		listPlayers.add(player2);
		
		player1.setTurn(true);

		// Por consola elegir el '4' o valor de la carta que se cree
		cardGuard.effect(listPlayers);

		assertEquals('d', player2.getState());
	}

	@Test
	void testEffectNotAssertCard() {
		System.out.println();
		System.out.println("testEffectNotAssertCard -- Primero escribir 2 (targetId) y luego escribir !4 (cardStrength)");
		Card cardGuard = new Guard();
		Card cardHandmaid = new Handmaid();
		Hand handPlayer = new Hand(cardGuard);
		Hand handPlayer2 = new Hand(cardHandmaid);
		Player player1 = new Player(handPlayer);
		Player player2 = new Player(2, "Jugador 2", handPlayer2);

		ArrayList<Player> listPlayers = new ArrayList<Player>();

		listPlayers.add(player1);
		listPlayers.add(player2);
		
		player1.setTurn(true);

		// Por consola elegir un numero distinto a 4 o valor de la carta que se cree
		cardGuard.effect(listPlayers);

		assertNotEquals('d', player2.getState());
	}

}
