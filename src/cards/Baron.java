package cards;

import model.Player;

public class Baron implements Card {
	protected final int strength = 3;
	protected final String name = "Barón";
	protected final String effectDesc = "Comparas cartas con otro jugador, el que tenga la menor queda descalificado";
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

	public void effect(Player playerOnTurn, Player playerTarget) {
		//Coming soon...
	}
}
