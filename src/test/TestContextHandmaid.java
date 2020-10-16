package test;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cards.*;
import context.Context;
import context.ContextHandmaid;
import model.*;

class TestContextHandmaid {

	@Test
	public void jugarHandmaind() {
		// Se reparte mano
		Player player1 = new Player(new Guard());
		Player player2 = new Player(new Baron());
		
		// Levanta del mazo
		player1.setCard2(new Handmaid());
		
		// Se crea Conexto
		Context context = new ContextHandmaid(player1, player2, player1.getCard2(), "");
		
		// Test
		assertEquals(false, player1.isProtected());
		
		// Jugar
		player1.playCard(context);
		
		// Test
		assertEquals(true, player1.isProtected());		
	}

}
