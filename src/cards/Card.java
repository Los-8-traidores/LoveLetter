package cards;

import model.*;
import java.util.List;
import java.util.Scanner;

public abstract class Card {
	private int strenght;
	private String name;
	private String effectDescription;

	public Card(int strenght, String name, String effectDescription) {
		this.strenght = strenght;
		this.name = name;
		this.effectDescription = effectDescription;
	}
	

	public int getStrenght() {
		return strenght;
	}

	public String getName() {
		return name;
	}

	public String getEffectDescription() {
		return effectDescription;
	}

	public int compare(Card card) {
		return this.strenght - card.strenght;
	}

	public abstract void effect(List<Player> players);
	
	public abstract Player target(List<Player> players, Scanner in);
}
