package model;

public class Priest extends Card {
	static final int STRENGHT = 2;
 	static final String NAME = "Priest";
 	static final String EFFECT_DESCRIPTION = "The player chooses another player to see the cards in his hand";
 			
	public Priest() {
		super(STRENGHT, NAME, EFFECT_DESCRIPTION);
	}
	
	@Override
	void effect() {

	}
}
