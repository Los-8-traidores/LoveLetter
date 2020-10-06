package model;

import java.util.*;

public  class Deck {
	
	private ArrayList<Card>gameCards= new ArrayList<Card>();
	private ArrayList<Card>discardedCards= new ArrayList<Card>();
	
	
	public Deck() {
		DeckFactory factory = new DeckFactory();
		this.gameCards = factory.createDeck();
	}

	public void mixDeck(){
		//Mezclar el mazo de manera aleatoria
	}
	
	public void resetDeck(){
		//Analizar si es necesario
	}
	
	

	public List<Card> getGameCards() {
		return gameCards;				//Probablemente solo necesario para pruebas
	}

	public void discardedCard() {
		//Implemntar un metodo que mueva una carta del mazo jugable a un mazo de descartadas
	}
	
	public Card repartir(){
//		Un metodo para repartir de a una carta
		return null; //MODIFICAR EL NULL!!!
	}

}
