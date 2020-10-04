package model;

public class Handmaid extends Card {
	static final int STRENGHT = 4;
	static final String NAME = "Handmaid";
	static final String EFFECT_DESCRIPTION = "The player is protected and cannot be affected by other players "
			+ "cards until his next turn";
	
	public Handmaid() {
		super(STRENGHT, NAME, EFFECT_DESCRIPTION);
	}
	
	@Override
	void effect() {
		
	}
}