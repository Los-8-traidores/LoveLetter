package cards;

import model.Player;

public class Countess implements Card{
	protected final int strength = 7;
	protected final String name = "Condesa";
	protected final String effectDesc = "Descarta esta carta si tenes en tu mano al Rey o al Principe";
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

	public void effect(Player playerOnTurn, Player playerTarget) {
		//Coming soon...
	}
}
