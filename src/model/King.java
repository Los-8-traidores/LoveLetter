package model;

public class King extends Card {
	static final int STRENGHT = 6;
 	static final String NAME = "King";
 	static final String EFFECT_DESCRIPTION = "The player chooses another player and they exchange their hands";
 			
	public King() {
		super(STRENGHT, NAME, EFFECT_DESCRIPTION);
	}

	@Override
	void effect() {

	}

}
