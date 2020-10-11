package model;

import cards.*;
import screen.Screen;

public class Player {
	protected int id; // Pensar forma de elegir un numero random y que no se repitan entre si
	protected String name;
	protected int points = 0;
	protected boolean isProtected = false;
	protected boolean isAlive = true;
	protected Card card1 = null;
	protected Card card2 = null;
	protected int discards = 0;
	protected boolean isTurn; // ver si hace falta o no

	public Player(Card card1) {
		this.card1 = card1;
	}

	public Player(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Player(int id, String name, Card card1) {
		this.id = id;
		this.name = name;
		this.card1 = card1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public boolean isProtected() {
		return isProtected;
	}

	public void setProtected(boolean isProtected) {
		this.isProtected = isProtected;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public Card getCard1() {
		return card1;
	}

	public void setCard1(Card card1) {
		this.card1 = card1;
	}

	public Card getCard2() {
		return card2;
	}

	public void setCard2(Card card2) {
		this.card2 = card2;
	}

	public int getDiscards() {
		return discards;
	}

	public void setDiscards(int discards) {
		this.discards = discards;
	}

	public boolean isTurn() {
		return isTurn;
	}

	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}

	public Card chooseCard() {
		Screen.showCards(card1, card2);
		Card chosenCard;

		if (card1.getCardName() == Screen.enterChosenCard()) {
			chosenCard = card1;
			card1 = card2;
			card2 = null;
		} else
			chosenCard = card2;

		return chosenCard;
	}

	public void addPoint() {
		this.points++;
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////
	
	public void playCard(Context contex) {
		contex.apply();
		
	}
	
	@Override
	public String toString() {
		return this.name + ": Esta vivo? " + this.isAlive;
	}
	
}