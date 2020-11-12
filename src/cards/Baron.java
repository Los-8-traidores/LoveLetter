package cards;

import model.Player;

public class Baron extends Card {
	protected final int strength = 3;
	protected final String name = "Barón";
	protected final String effectDesc = "Comparas cartas con otro jugador, el que tenga la menor queda descalificado";
	protected final boolean needsTarget = true;


	@Override
	public int getStrength() {
		return strength;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getEffectDesc() {
		return effectDesc;
	}

	@Override
	public boolean isNeedsTarget() {
		return needsTarget;
	}
}