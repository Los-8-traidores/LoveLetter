package cards;

import model.Player;

public class Baron extends Card {
	private static final int STRENGTH = 3;
	private static final String NAME = "Barón";
	private static final String EFFECT_DESC = "Comparas cartas con otro jugador, el que tenga la menor queda descalificado";
	private static final boolean NEED_TARGET = true;

	public Baron() {
		super(STRENGTH, NAME, EFFECT_DESC, NEED_TARGET);
	}
}
