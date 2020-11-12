package cards;

import model.*;
import screen.Screen;

public class Guard extends Card {
	private static final int STRENGTH = 1;
	private static final String NAME = "Guardia";
	private static final String EFFECT_DESC = "Elige a otro jugador para adivinar su carta (de tipo no guardia). Si la adivinas correctamente, el jugador queda descalificado";
	private static final boolean NEED_TARGET = true;

	public Guard() {
		super(STRENGTH, NAME, EFFECT_DESC, NEED_TARGET);
	}
}

