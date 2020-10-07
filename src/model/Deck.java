  
package model;

import java.util.Random;

public class Deck {
	//private List<Card> gameCards; //new ArrayList<Card>(){{add(new Prince());new Prince();new Baron();new Baron();new Countess();new King();new Priest();new Priest();}};
	public int cartasDadas = 0;
	public Card[] cards; 
	
	
	public Deck() {
		DeckFactory factory = new DeckFactory();
		this.cards = factory.createDeck();
	}


	public Card[] getGameCards() {
		return cards;				//Probablemente solo necesario para pruebas
	}
	
	public void resetDeck() {
		//Mezcla del mazo
		cartasDadas = 0;
		Random r = new Random();
		for (int i=0; i<cards.length; i++) {
            int posAleatoria = r.nextInt(cards.length);
            Card cardTemp = cards[i];
            cards[i] = cards[posAleatoria];
            cards[posAleatoria] = cardTemp;
        }
	}
		
	public boolean hayCartas(){
		return cartasDadas <= cards.length;
	}
	
	public Card sacarCarta(){
		cartasDadas++;
		return cards[cartasDadas-1];
	}

}