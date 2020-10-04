package model;

public class Handmaid extends Card {
	public Handmaid (int strenght, String name, String effectDescription){
		super(4, "Handmaid", "El jugador está protegido y no puede ser afectado por cartas de otros jugadores hasta su siguiente turno");
	}

	@Override
	void effect(Player player) {
		player.changeState('p', player);
	}
}
