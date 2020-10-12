package cards;

import model.*;

public abstract class Card {
	
	public abstract int getCardStrength();
	public abstract String getCardName();
	public abstract String getCardEffectDesc();
	public abstract boolean isNeedsTraget();
	
}
