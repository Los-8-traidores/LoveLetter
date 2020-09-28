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
		hand = new Hand();
		IsTurn = false;
	}
	
	
	
	public int getPoints() {
		return points;
	}
	
//	public Player target() {
//		
//	}
//	
	public String chooseCard(int numberCard){
		
		if(numberCard == 1) {
			return this.hand.getCard1();
		}
		else
		{
			return this.hand.getCard2();
		}
		
		/*
		 * Para hacer pruebas puse que el metodo sea publico, en la version final no sera asi.
		 * Al no tener la clase Card, utilice Strings
		 */
		
	}
	

}
