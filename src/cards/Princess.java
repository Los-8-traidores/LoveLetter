package cards;

import model.Player;

public class Princess extends Card {
	protected final int strength = 8;
	protected final String name = "Princesa";
	protected final String effectDesc = "Si descartas esta carta, quedas descalificado";
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