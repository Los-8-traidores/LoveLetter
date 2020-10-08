package cards;

import java.util.List;

import model.Player;

public class Princess extends Card {
	static final int STRENGHT = 9;
 	static final String NAME = "Princess";
 	static final String EFFECT_DESCRIPTION = "If, for any reason, you play or discard the Princess, you are eliminated from the round.";
 			
	public Princess() {
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
