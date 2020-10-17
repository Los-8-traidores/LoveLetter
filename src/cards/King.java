package cards;

import model.Player;

public class King extends Card {
	private static final int STRENGTH = 6;
	private static final String NAME = "Rey";
	private static final String EFFECT_DESC = "Elige otro jugador para intercambiar cartas";
	private static final boolean NEED_TARGET = true;

	public King() {
		super(STRENGTH, NAME, EFFECT_DESC, NEED_TARGET);
	}
}
