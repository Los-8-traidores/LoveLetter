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
		assertEquals("Los demás jugadores no pueden elegirte para los efectos de sus cartas hasta tu próximo turno.", cardHandmaid.getEffectDescription());
		assertEquals(4, cardHandmaid.getStrenght());
	}

	
	@Test
	void testTarget() {
		//Guasada alert
		Handmaid cardHandmaid = new Handmaid();
		//Guasada ALERT! Fin
		
		Hand handPlayer = new Hand(cardHandmaid);
		Player player1 = new Player(handPlayer);
		Player player2 = new Player();
		Player player3 = new Player();
		ArrayList<Player> listPlayers = new ArrayList<Player>();
		
		listPlayers.add(player1);
		listPlayers.add(player2);
		listPlayers.add(player3);
		
		player1.setTurn(true);
		
		assertEquals(player1, cardHandmaid.targetOnTurn(listPlayers));
	}

	@Test
	void testChangeToProtected() {
		Card cardHandmaid = new Handmaid();
		Hand handPlayer = new Hand(cardHandmaid);
		Player player1 = new Player(handPlayer);
		ArrayList<Player> listPlayers = new ArrayList<Player>();
		
		player1.setTurn(true);
		listPlayers.add(player1);
		
		
		assertEquals('a', player1.getState());
		
		cardHandmaid.effect(listPlayers);

		assertEquals('p', player1.getState());
	}
}
