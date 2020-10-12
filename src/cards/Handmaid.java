package cards;

import model.*;

public class Handmaid extends Card {
	protected final int strength = 4;
	protected final String name = "Mucama";
	protected final String effectDesc = "Hasta tu próximo turno, los demás jugadores no pueden aplicar los efectos de susc cartas sobre vos";
	protected final boolean needsTarget = false;

	@Override
	public int getCardStrength() {
		return strength;
	}

	@Override
	public String getCardName() {
		return name;
	}

	@Override
	public String getCardEffectDesc() {
		return effectDesc;
	}

	@Override
	public boolean isNeedsTraget() {
		return needsTarget;
	}
}