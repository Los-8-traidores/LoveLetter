package model;

public class Guard extends Card{
	static final int STRENGHT = 1;
	static final String NAME = "Guard";
	static final String EFFECT_DESCRIPTION = "Choose another player and name a character who is not another Guard. If that player has the named character in their hand, they are eliminated from the round.";
	
	public Guard() {
		super(STRENGHT, NAME, EFFECT_DESCRIPTION);
	}
	

	@Override
	void effect() {
		// TODO Auto-generated method stub
	}

}
