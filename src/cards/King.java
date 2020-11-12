package cards;

import model.Player;

public class King extends Card {
	protected final int strength = 6;
	protected final String name = "Rey";
	protected final String effectDesc = "Elige otro jugador para intercambiar cartas";
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