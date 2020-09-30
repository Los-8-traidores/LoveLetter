package model;

public class Player {

	protected int id;
	private String name;
	private int points;
	private char state;
	private Hand hand;
	private int discards;
	private boolean IsTurn;

	public Player(int id, String name, int points, char state, Hand hand, int discards, boolean isTurn) {
		this.id = id;
		this.name = name;
		this.points = points;
		this.state = state;
		this.hand = hand;
		this.discards = discards;
		IsTurn = isTurn;
	}

	public Player() {
		id = 0;
		name = "NoName";
		points = 0;
		state = 'p';
		IsTurn = false;
		hand = null;
	}

	public int getPoints() {
		return points;
	}

	public String target(int cardNumber, Player p) {
		/*
		 * cambie el retorno (Player es el original) por un void. Necesito la class Card
		 * para una implementacion
		 */
		return ("El jugador " + this.name + " utilizo la carta " + this.chooseCard(cardNumber) + " sobre " + p.name);

	}

	private Card chooseCard(int numberCard) {

		if (numberCard == 1)
			return this.hand.getCard1();

		else
			return this.hand.getCard2();
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", points=" + points + ", state=" + state + ", hand="
				+ hand.toString() + ", discards=" + discards + ", IsTurn=" + IsTurn + "]";
	}
}
