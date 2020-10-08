package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import cards.Card;
import cards.Guard;
import cards.Handmaid;
import cards.King;
import model.Hand;
import model.Player;

class TestKing {

	@Test
	void testCardCreation() {
		Card cardKing = new King();

		assertEquals("Rey", cardKing.getName());
		assertEquals(
				"Elige a otro jugador y cambia la carta de tu mano por la carta de su mano.",
				cardKing.getEffectDescription());
		assertEquals(6, cardKing.getStrenght());
	}

	@Test
	void testTargetCorrect() {
		// Se imprime por consola los ID de los jugadores
		System.out.println();
		System.out.println("testTarget");
		Card cardKing = new King();
		Hand handPlayer = new Hand(cardKing);
		Player player1 = new Player(handPlayer);
		Player player2 = new Player(2, "Jugador 2");
		Player player3 = new Player(3, "Jugador 3");
		ArrayList<Player> listPlayers = new ArrayList<Player>();

		listPlayers.add(player1);
		listPlayers.add(player2);
		listPlayers.add(player3);

		player1.setTurn(true);
		//Guasada begins
		Scanner in = new Scanner(System.in);

		// El test esta pensado para que se elija al 2 por consola.
		assertEquals(player2, cardKing.target(listPlayers, in));
		in.close();

	}
	
	@Test
	void testTargetOnTurn() {
		King cardKing = new King();
		Hand handPlayer = new Hand(cardKing);
		Player player1 = new Player(handPlayer);
		Player player2 = new Player();
		Player player3 = new Player();
		ArrayList<Player> listPlayers = new ArrayList<Player>();
		
		listPlayers.add(player1);
		listPlayers.add(player2);
		listPlayers.add(player3);
		
		player1.setTurn(true);
		
		assertEquals(player1, cardKing.targetOnTurn(listPlayers));
	}

	@Test
	void testExchageCards() {
		// Se imprime por consola los ID de los jugadores
		Card cardGuard = new Guard();
		Card cardHandmaid = new Handmaid();
		King cardKing = new King();
		
		Hand handPlayer = new Hand(cardGuard);
		Hand handPlayer2 = new Hand(cardHandmaid);
		Player player1 = new Player(handPlayer);
		Player player2 = new Player(2, "Jugador 2", handPlayer2);
		
		ArrayList<Player> listPlayers = new ArrayList<Player>();

		listPlayers.add(player1);
		listPlayers.add(player2);

		player1.setTurn(true);
		
		
		cardKing.effect(listPlayers);
		
		assertEquals("Guardia", player2.getHand().getCard1().getName());
		assertEquals("Doncella", player1.getHand().getCard1().getName());
	}

}
