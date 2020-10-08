package test;

import model.*;
import cards.*;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestHandmaid {
	
	@Test
	void testCardCreation() {
		Card cardHandmaid = new Handmaid();

		assertEquals("Doncella", cardHandmaid.getName());
		assertEquals("Los dem�s jugadores no pueden elegirte para los efectos de sus cartas hasta tu pr�ximo turno.", cardHandmaid.getEffectDescription());
		assertEquals(4, cardHandmaid.getStrenght());
	}

	
	@Test
	void testTarget() {
		Card cardHandmaid = new Handmaid();
		Hand handPlayer = new Hand(cardHandmaid);
		Player player1 = new Player(handPlayer);
		Player player2 = new Player();
		Player player3 = new Player();
		ArrayList<Player> listPlayers = new ArrayList<Player>();
		
		listPlayers.add(player1);
		listPlayers.add(player2);
		listPlayers.add(player3);
		
		player1.setTurn(true);
		
		assertEquals(player1, cardHandmaid.target(listPlayers));
	
	}

	@Test
	void testChangeToProtected() {
		Card cardHandmaid = new Handmaid();
		Hand handPlayer = new Hand(cardHandmaid);
		Player player1 = new Player(handPlayer);
		
		assertEquals('a', player1.getState());
		
		cardHandmaid.effect(player1);

		assertEquals('p', player1.getState());
	}
}