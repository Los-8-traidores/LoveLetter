package cards;

import model.*;
import java.util.List;

public class Handmaid extends Card {
	static final int STRENGHT = 4;
	static final String NAME = "Doncella";
	static final String EFFECT_DESCRIPTION = "Los demás jugadores no pueden elegirte para los efectos de sus cartas hasta tu próximo turno.";
	
	public Handmaid() {
		super(STRENGHT, NAME, EFFECT_DESCRIPTION);
	}
	
	public Player target(List<Player> players) {
		for(Player player : players) {
			if (player.getIsTurn() == true){
				return player;
			}
		}
		return null;//nunca tendria que llegar a este punto.
		//lo dejo para evitar que me tire warnings
	}
	
	@Override
	public void effect(Player player) {
		player.setState('p');
	}
}