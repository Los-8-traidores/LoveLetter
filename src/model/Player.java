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
		super();
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
		Hand = new Hand();
		IsTurn = false;
	}
	
	
	
	public int getPoints() {
		return points;
	}
	
	public Player target() {
		
	}
	
	private Card chooseCard() {
		
	}
	

}
