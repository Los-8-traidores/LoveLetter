package cards;

import model.*;
import screen.Screen;

public class Guard extends Card {
	protected final int strength = 1;
	protected final String name = "Guardia";
	protected final String effectDesc = "Elige a otro jugador para adivinar su carta (de tipo no guardia). Si la adivinas correctamente, el jugador queda descalificado";
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
	public boolean isNeedsTarget() {
		return needsTarget;
	}
}

