package test;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cards.*;
import context.Context;
import context.ContextBaron;
import model.*;

class TestContextBaron {

	@Test
	public void casoEmpate() {
		// Se reparte mano
		Player player1 = new Player(new Guard());
		Player player2 = new Player(new Guard());
		
		// Levanta del mazo
		player1.setCard2(new Baron());
		
		// Se crea Contexto
		Context context = new ContextBaron(player1, player2, player1.getCard2());
		
		// Jugar
		player1.playCard(context);
		
		// Test
		assertEquals(true, player2.isAlive());
		assertEquals(true, player1.isAlive());
	}	
	
	@Test
	public void casoGanaMano() {
		// Se reparte mano
		Player player1 = new Player(new Princess());
		Player player2 = new Player(new Guard());
		
		// Levanta del mazo
		player1.setCard2(new Baron());
		
		// Se crea Contexto
		Context context = new ContextBaron(player1, player2, player1.getCard2());
		
		// Jugar
		player1.playCard(context);
		
		// Test
		assertEquals(false, player2.isAlive());		
		assertEquals(true, player1.isAlive());		
	}
	
	@Test
	public void casoPierdeMano() {
		// Se reparte mano
		Player player1 = new Player(new Guard());
		Player player2 = new Player(new Prince());
		
		// Levanta del mazo
		player1.setCard2(new Baron());
		
		// Se crea Contexto
		Context context = new ContextBaron(player1, player2, player1.getCard2());
		
		// Jugar
		player1.playCard(context);
		
		// Test
		assertEquals(true, player2.isAlive());		
		assertEquals(false, player1.isAlive());		
	}
	
	@Test
	public void casoProtected() {
		// Se reparte mano
		Player player2 = new Player(new Guard());
		Player player1 = new Player(new Prince());
		
		player2.setProtected(true);
		
		// Levanta del mazo
		player1.setCard2(new Baron());
		
		// Se crea Contexto
		Context context = new ContextBaron(player1, player2, player1.getCard2());
		
		// Jugar
		player1.playCard(context);
		
		// Test
		assertEquals(true, player2.isAlive());		
		assertEquals(true, player1.isAlive());		
	}

}
