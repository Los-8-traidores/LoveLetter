package cards;

import java.util.List;
import java.util.Scanner;

import model.Player;

public class Countess extends Card{
	static final int STRENGHT = 7;
 	static final String NAME = "Countess";
 	static final String EFFECT_DESCRIPTION = "If a player has this card and the King or Prince, "
 			+ "this card must be played immediately";
 			
	public Countess() {
		super(STRENGHT, NAME, EFFECT_DESCRIPTION);
	}

	public Player target(List<Player> players, Scanner in) {
		//implement method
		return null;
	}
	

	public void effect(List<Player> players) {
		//Scanner in = new Scanner(System.in);
		//Player targetPlayer = this.target(players, in);
		//implement method
		//in.close();
	}
}
