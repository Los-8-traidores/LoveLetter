package cards;

import model.*;

public abstract class Card {
	protected int strength;
	protected String name;
	protected String effectDesc;
	protected boolean needsTarget;

	public Card(int strength, String name, String effectDesc, boolean needsTarget) {
		this.strength = strength;
		this.name = name;
		this.effectDesc = effectDesc;
		this.needsTarget = needsTarget;
	}

	public int getStrength() {
		return strength;
	}

	public String getName() {
		return name;
	}

	public String getEffectDesc() {
		return effectDesc;
	}

	public String isNeedsTarget() {
		return effectDesc;
	}

	
	public String getImagePath() {
		return "card" + getName();
	}
	
}
