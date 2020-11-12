package cards;

import model.Player;

public class Priest extends Card {
	private static final int STRENGTH = 2;
	private static final String NAME = "Sacerdote";
	private static final String EFFECT_DESC = "Elige a otro jugador para ver su carta";
	private static final boolean NEED_TARGET = true;

	public Priest() {
		super(STRENGTH, NAME, EFFECT_DESC, NEED_TARGET);
	}
}
