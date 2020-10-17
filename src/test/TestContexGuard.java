package test;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;

import cards.*;
import context.Context;
import context.ContextGuard;
import model.*;

import org.junit.jupiter.api.Test;

class TestContexGuard {

	@Test
	public void adivinaCarta() {
		// Se reparte mano
		Player player1 = new Player(new Guard());
		Player player2 = new Player(new Baron());
		
		// Levanta del mazo
		player1.setCard2(new Guard());
		
		// Se crea Conexto
		Context context = new ContextGuard(player1, player2, player1.getCard2(), "Barón");
		
		// Jugar
		player1.playCard(context);
		
		// Test
		assertEquals(false, player2.isAlive());		
	}
	
	@Test
	public void noAdivinaCarta() {
		// Se reparte mano
		Player player1 = new Player(new Guard());
		Player player2 = new Player(new Baron());
		
		// Levanta del mazo
		player1.setCard2(new Guard());
		
		// Se crea Conexto
		Context context = new ContextGuard(player1, player2, player1.getCard2(), "Princesaaaaa");
		
		// Jugar
		player1.playCard(context);
		
		// Test
		assertEquals(true, player2.isAlive());		
	}

}
