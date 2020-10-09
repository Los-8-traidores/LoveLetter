package cards;

import model.*;

public interface Card {
	
	int getCardStrength();
	String getCardName();
	String getCardEffectDesc();
	boolean isNeedsTraget();
	
	public void effect(Player playerOnTurn, Player playerTarget);
}
