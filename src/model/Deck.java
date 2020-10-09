  
package model;

import cards.*;

public class Deck {
	public int dealtCards = 0;
	public Card[] cards = new Card[16];
	
	
	public void shuffleDeck(){
        for(int i=0; i < cards.length; i++){
            int randomNum = (int) (Math.random() * cards.length);
            
            Card temp;
            temp = cards[i];
            cards[i] = cards[randomNum];
            cards[randomNum] = temp;
        }
    }

	public void fillDeck(){
		//5 guards
        for(int i=0; i<5; i++)
        	cards[i] = new Guard();

        //2 priests
        for(int i=5; i<7; i++)
        	cards[i] = new Priest();

        //2 Barons
        for(int i=7; i<9; i++)
            cards[i] = new Baron();

        //2 Handmaids
        for(int i=9; i<11; i++)
            cards[i] = new Handmaid();

        //2 princes
        for(int i=11; i<13; i++)
            cards[i] = new Prince();

        //1 King, Countess and Princess
        cards[13] = new King();
        cards[14] = new Countess();
        cards[15] = new Princess();
    }
	
	
	public void resetDeck() {
		shuffleDeck();
		dealtCards = 0;
	}
		
	public boolean notEmptyDeck(){
		return dealtCards < cards.length;
	}
	
	public Card drawCard(){
		return cards[dealtCards++];
	}

}