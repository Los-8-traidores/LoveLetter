package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cards.*;
import context.Context;
import context.ContextKing;
import model.*;


public class TestContextKing {

	@Test
	public void changeCards() {
		// Se reparte mano
		Player player1 = new Player(new Guard());
		Player player2 = new Player(new Baron());
		
		// Levanta del mazo
		player1.setCard2(new King());
		
		// Se crea Conexto
		Context context = new ContextKing(player1, player2, player1.getCard2());
		
		//Verificar la posecion de sus cartas
		Card cardPlayer1 = player1.getCard1();
		Card cardPlayer2 = player2.getCard1();
		assertEquals(cardPlayer1, player1.getCard1());
		assertEquals(cardPlayer2, player2.getCard1());
		
		// Jugar
		player1.playCard(context);
		
		// Test
		assertEquals(cardPlayer1, player2.getCard1());
		assertEquals(cardPlayer2, player1.getCard1());
	}
}
