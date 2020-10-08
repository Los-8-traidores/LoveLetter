package cards;

import java.util.List;

import model.Player;

public class Prince extends Card{
	static final int STRENGHT = 5;
	static final String NAME = "Prince";
	static final String EFFECT_DESCRIPTION = "The player chooses another player (including himself) to"
			+ " discard his hand and draw a new card. "
			+ "If the Princess is discarded in this way, the player who discarded her is eliminated "
			+ "from the round.";

	public Prince() {
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
