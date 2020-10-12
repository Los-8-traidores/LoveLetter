package test;

import static org.junit.Assert.assertEquals;
import cards;
import model;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;

import cards.*;
import context.Context;
import context.ContextGuard;
import model.*;

import org.junit.jupiter.api.Test;

public class TestContextPrince {
	@Test
	public void discartedPrincess() {
		Player player1 = new Player(new Prince());
		Player player2 = new Player(new Princess());
		Deck gameDeck = new Deck();
		gameDeck.resetDeck();
		
		player1.setCard2(new Guard());
		
		Context context = new ContextPrince(player1, player2, player1.getCard1(), gameDeck);
		player1.playCard(context);
		
		assertEquals(false, player2.isAlive());
			
	}
	@Test
	public void playPrince() {
		Player player1 = new Player(new Prince());
		Player player2 = new Player(new Guard());
		Deck gameDeck = new Deck();
		gameDeck.resetDeck();
		
		player1.setCard2(new Baron());
		
		Card cardPlayer2 = player2.getCard1();
		Context context = new ContextPrince(player1, player2, player1.getCard1(), gameDeck);
		player1.playCard(context);
		
		assertEquals(false, player2.getCard1() == cardPlayer2);
	}
}
