package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import cards.*;
import context.*;
import model.*;


public class TestContextCountess {

	@Test
	public void countessHandWithPrince() {
		Player player1 = new Player(1, "Jugador 1");
		Player player2 = new Player(2, "Jugador 2");
		Card descarted;
		
		Game practiceGame = new Game(player1, player2);
		practiceGame.grabCard(player1);
		
		player1.setCard1(new Countess());
		player1.setCard2(new Prince());
		player2.setCard1(new Princess());
		
		descarted = player1.getCard1();
		
		Context context = new ContextCountess(player1, player1.getCard1());
		practiceGame.playCard(player1, context, player1.getCard1());//Juega la carta de la Condeza
		assertEquals(true, player2.isTurn());
		
		assertEquals("Principe", player1.getCard1().getName()); //descarta la condesa y queda con el rey
		assertEquals("Condesa", descarted.getName());
	} 
}
