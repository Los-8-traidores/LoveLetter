package model;

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

	@Override
	void effect() {
		
	}
}
