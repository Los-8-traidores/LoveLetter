package cards;

import model.Player;

public class Priest extends Card {
	protected final int strength = 2;
	protected final String name = "Sacerdote";
	protected final String effectDesc = "Elige a otro jugador para ver su carta";
	protected final boolean needsTarget = true;
 			
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
