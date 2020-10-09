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

		assertEquals("Mucama", cardHandmaid.getCardName());
		assertEquals("Hasta tu próximo turno, los demás jugadores no pueden aplicar los efectos de susc cartas sobre vos", cardHandmaid.getCardEffectDesc());
		assertEquals(4, cardHandmaid.getCardStrength());
	}


	@Test
	void testChangeToProtected() {
		Card cardHandmaid = new Handmaid();
		Player player1 = new Player(cardHandmaid);
		ArrayList<Player> listPlayers = new ArrayList<Player>();
		
		player1.setTurn(true);
		listPlayers.add(player1);
		
		
		assertEquals(false, player1.isProtected());
		
		cardHandmaid.effect(player1, null);

		assertEquals(true, player1.isProtected());
	}
	
}
