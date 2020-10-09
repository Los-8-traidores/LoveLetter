package cards;

import model.Player;

public class King implements Card {
	protected final int strength = 6;
	protected final String name = "Rey";
	protected final String effectDesc = "Elige otro jugador para intercambiar cartas";
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
		Card auxCard = playerTarget.getCard1();
		playerTarget.setCard1(playerOnTurn.getCard1());
		playerOnTurn.setCard1(auxCard);
	}

}
