package cards;

import java.util.List;

import model.Player;

public class Baron extends Card {
	static final int STRENGHT = 3;
	static final String NAME = "Baron";
	static final String EFFECT_DESCRIPTION = "The player chooses another player and the cards are "
			+ "revealed privately. The player with the least power card is eliminated from the round";

	public Baron() {
		super(STRENGHT, NAME, EFFECT_DESCRIPTION);
	}

	public Player target(List<Player> players) {
		//implement method
		return null;
	}
	

	public void effect(Player player) {
		//implement method
	}
}
