package cards;

import model.Player;

public class Prince extends Card{
	private static final int STRENGTH = 5;
	private static final String NAME = "Principe";
	private static final String EFFECT_DESC = "Elige a otro jugador a o ti mismo para descartar la carta y levantar otra. Si la princesa es descartada, queda descalificado el jugador";
	private static final boolean NEED_TARGET = true;

	public Prince() {
		super(STRENGTH, NAME, EFFECT_DESC, NEED_TARGET);
	}
}
