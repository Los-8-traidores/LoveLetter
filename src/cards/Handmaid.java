package cards;

import model.*;

public class Handmaid extends Card {
	private static final int STRENGTH = 4;
	private static final String NAME = "Mucama";
	private static final String EFFECT_DESC = "Hasta tu próximo turno, los demás jugadores no pueden aplicar los efectos de sus cartas sobre vos";
	private static final boolean NEED_TARGET = false;

	public Handmaid() {
		super(STRENGTH, NAME, EFFECT_DESC, NEED_TARGET);
	}
}