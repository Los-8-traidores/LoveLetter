package model;

import java.util.LinkedList;
import java.util.List;

public class DeckFactory {
	public List<Card> createDeck() {
		
		List<Card> newDeck = new LinkedList<Card>();
		
		/*
		 * Cantidad de cartas a crear
		 * 
		 * Guardias(5)
		 * Sacerdotes(2)
		 * Baron(2)
		 * Mucama(2)
		 * Principe(2)
		 * Rey(1)
		 * Condesa(1)
		 * Princesa(1)
		 * 
		 */
		
		// Guardias
		
		for(int i=0; i<5; i++) 
			newDeck.add(new Guard());
		
		//Sacerdotes
		
		newDeck.add(new Priest());
		newDeck.add(new Priest());
		
		//Baron
		
		newDeck.add(new Baron());
		newDeck.add(new Baron());
		
		//Doncella
		
		newDeck.add(new Handmaid());
		newDeck.add(new Handmaid());
		
		//Principe
		
		newDeck.add(new Prince());
		newDeck.add(new Prince());
		
		//King
		
		newDeck.add(new King());
		
		//Countess
		
		newDeck.add(new Countess());
		
		//Princess
		
		newDeck.add(new Princess());
		
		
		
		return newDeck;
	}
}
