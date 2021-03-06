package test;

import static org.junit.Assert.assertEquals;


import model.*;
import cards.*;
import context.*;

//import static org.junit.Assert.assertEquals;

//import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TestGame {
	@Test
	public void testGame() {
		
		Player player1 = new Player(1, "Jugador 1");
		Player player2 = new Player(2, "Jugador 2");
		Game practiceGame = new Game(player1, player2);
		
		System.out.println(player1.getCard1().getName());
		System.out.println(player2.getCard1().getName());
		practiceGame.grabCard(player1);
		System.out.println(player1.getCard2().getName());
		
		player1.setCard1(new King());
		player1.setCard2(new Guard());
		player2.setCard1(new Princess());
		
		Context context = new ContextKing(player1, player2, player1.getCard1());
		practiceGame.playCard(player1, context);
		practiceGame.grabCard(player2);
		
		player2.setPoints(6);
		Context context2 = new ContextGuard(player2, player1, player2.getCard1(), "Princesa");
		practiceGame.playCard(player2, context2);
		
		assertEquals(false, practiceGame.activeGame());
	}
	
	@Test
	public void isTrun(){
		Player player1 = new Player(1, "Jugador 1");
		Player player2 = new Player(2, "Jugador 2");
		
		Game practiceGame = new Game(player1, player2);
		practiceGame.grabCard(player1);
		
		player1.setCard1(new King());
		player1.setCard2(new Handmaid());
		player2.setCard1(new Princess());
		
		Context context = new ContextKing(player1, player2, player1.getCard1());
		practiceGame.playCard(player1, context);
		assertEquals(true, player2.isTurn());
		
		practiceGame.grabCard(player2);
		Context context2 = new ContextHandmaid(player2, player1, player2.getCard2(), "");
		practiceGame.playCard(player2, context2);
		assertEquals(true, player2.isProtected());
		assertEquals(true, player1.isTurn());
				
	}
	
	@Test
	public void countessHandWithKing() {
		Player player1 = new Player(1, "Jugador 1");
		Player player2 = new Player(2, "Jugador 2");
		
		Game practiceGame = new Game(player1, player2);
		practiceGame.grabCard(player1);
		
		player1.setCard1(new Countess());
		player1.setCard2(new King());
		player2.setCard1(new Princess());
		
		Context context = new ContextCountess(player1, player1.getCard1());
		practiceGame.playCard(player1, context);//Juega la carta de la Condeza
		assertEquals(true, player2.isTurn());
		
		assertEquals("Rey", player1.getCard1().getName()); //descarta la condesa y queda con el rey
	} 
	
}