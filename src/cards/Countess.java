package cards;

import model.Player;

public class Countess extends Card {
	protected final int strength = 7;
	protected final String name = "Condesa";
	protected final String effectDesc = "Descarta esta carta si tenes en tu mano al Rey o al Principe";
	protected final boolean needsTarget = false;

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