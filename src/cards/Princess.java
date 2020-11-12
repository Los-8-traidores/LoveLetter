package cards;

import model.Player;

public class Princess extends Card {
	private static final int STRENGTH = 8;
	private static final String NAME = "Princesa";
	private static final String EFFECT_DESC = "Si descartas esta carta, quedas descalificado";
	private static final boolean NEED_TARGET = true;

	public Princess() {
		super(STRENGTH, NAME, EFFECT_DESC, NEED_TARGET);
	}
}
