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
		int i = 0;
		//5 guards
        for(; i<5; i++)
        	cards[i] = new Guard();

        //2 priests
        for(; i<7; i++)
        	cards[i] = new Priest();

        //2 Barons
        for(; i<9; i++)
            cards[i] = new Baron();

        //2 Handmaids
        for(; i<11; i++)
            cards[i] = new Handmaid();

        //2 princes
        for(; i<13; i++)
            cards[i] = new Prince();

        //1 King, Countess and Princess
        cards[13] = new King();
        cards[14] = new Countess();
        cards[15] = new Princess();
    }
	
	
	public void resetDeck() {
		fillDeck();
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