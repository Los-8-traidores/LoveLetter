package model;

public class Countess extends Card{
	static final int STRENGHT = 7;
 	static final String NAME = "Countess";
 	static final String EFFECT_DESCRIPTION = "If a player has this card and the King or Prince, "
 			+ "this card must be played immediately";
 			
	public Countess() {
		super(STRENGHT, NAME, EFFECT_DESCRIPTION);
	}

	@Override
	void effect() {

	}
}
