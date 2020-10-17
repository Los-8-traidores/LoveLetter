package test;

import static org.junit.Assert.assertEquals;

import model.*;
import cards.*;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TestDeck {
		
	@Test
	public void darCartas() {
		Deck deck = new Deck();
		Player player1 = new Player(1 ,"Jugador1");
		deck.fillDeck();
		deck.shuffleDeck();
		for(int i = 0; i<16; i++){
			player1.setCard1(deck.drawCard());
			System.out.println(player1.getCard1().getName());
		}
			
		assertEquals(false, deck.notEmptyDeck());
		
		
	}
}
