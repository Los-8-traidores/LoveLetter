package cards;

import model.Player;

public class Prince extends Card{
	protected final int strength = 5;
	protected final String name = "Príncipe";
	protected final String effectDesc = "Elige a otro jugador a o ti mismo para descartar la carta y levantar otra. Si la princesa es descartada, queda descalificado el jugador";
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