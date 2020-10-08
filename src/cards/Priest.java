package cards;

import java.util.List;
import java.util.Scanner;

import model.Player;

public class Priest extends Card {
	static final int STRENGHT = 2;
 	static final String NAME = "Priest";
 	static final String EFFECT_DESCRIPTION = "The player chooses another player to see the cards in his hand";
 			
	public Priest() {
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
