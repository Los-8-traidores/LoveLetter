package model;

import cards.*;


public class Player {
	protected int id;
	protected String name;
	protected int points;
	protected char state;
	protected Hand hand = new Hand(null, null);
	protected int discards;
	protected boolean isTurn;

	public Player(int id, String name, int points, char state, Hand hand, int discards, boolean isTurn) {
		this.id = id;
		this.name = name;
		this.points = points;
		this.state = state;
		this.hand = hand;
		this.discards = discards;
		this.isTurn = isTurn;
	}
	
	public Player(Hand hand) {
		id = 0;
		name = "NoName";
		points = 0;
		state = 'a';
		this.hand = hand;
		isTurn = false;
	}
	
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
		points = 0;
		state = 'a';
		isTurn = false;
	}

	public Player() {
		id = 0;
		name = "NoName";
		points = 0;
		state = 'a';
		//hand = null;
		isTurn = false;
	}

	public int getPoints() {
		return points;
	}

	
//	public void grabCard(Deck deck){ para la grafica ver
//	this.hand.setCard2(Game.getCard());
//}

	public Card chooseCard(int numberCard) {
		if (numberCard == 1) {
			return this.hand.getCard1();
		} else {
			return this.hand.getCard2();
		}
	}

	public void setState(char state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", points=" + points + ", state=" + state + ", hand="
				+ hand.toString() + ", discards=" + discards + ", isTurn=" + isTurn + "]";
	}

	public char getState() {
		return this.state;
	}

	public void setTurn(boolean b) {
		this.isTurn = b;
	}

	public void setPoints() {
		this.points += 1;
	}

	public Hand getHand() {
		return this.hand;
	}

	public String getName() {
		return this.name;
	}
	
	public void setCard(Card card) {
		if (hand.getCard1() == null) {
			this.hand.setCard1(card);
		} else {
			this.hand.setCard2(card);
		}
	}

	public boolean getIsTurn() {
		return this.isTurn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}