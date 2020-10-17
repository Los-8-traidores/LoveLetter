package cards;

import model.Player;

public class Countess extends Card {
	private static final int STRENGTH = 7;
	private static final String NAME = "Condesa";
	private static final String EFFECT_DESC = "Descarta esta carta si tenes en tu mano al Rey o al Principe";
	private static final boolean NEED_TARGET = false;

	public Countess() {
		super(STRENGTH, NAME, EFFECT_DESC, NEED_TARGET);
	}
}
