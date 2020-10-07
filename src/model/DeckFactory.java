package model;

import java.util.ArrayList;

import cards.Baron;
import cards.Card;
import cards.Countess;
import cards.Guard;
import cards.Handmaid;
import cards.King;
import cards.Priest;
import cards.Prince;
import cards.Princess;


public class DeckFactory {
	public Card[] createDeck() {
		
		Card[] newDeck=  new Card[16];
		
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
			newDeck[i] = new Guard();
		
		//Sacerdotes
		
		newDeck[5]=new Priest();
		newDeck[6]=new Priest();
		
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
