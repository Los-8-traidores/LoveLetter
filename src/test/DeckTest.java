package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import cards.Card;
import model.Deck;

class DeckTest {

	@Test
	void createTest() {
		
		Deck deck1 = new Deck();
		
		List<Card> aux = deck1.getGameCards();
		
		assertEquals(16, aux.size());
	}

}
