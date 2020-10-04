package model;

abstract class Card {
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

	public int compare(Card o) {
		return this.strenght - o.strenght;
	}

	abstract void effect(); //VER, para mi se le tiene que pasar una varible Player
}
