package cards;

import model.*;
import java.util.List;

import java.util.Scanner;

public class Guard extends Card {
	static final int STRENGHT = 1;
	static final String NAME = "Guard";
	static final String EFFECT_DESCRIPTION = "Choose another player and name a character who is not another Guard. If that player has the named character in their hand, they are eliminated from the round.";

	public Guard() {
		super(STRENGHT, NAME, EFFECT_DESCRIPTION);
	}

	public Player target(List<Player> players) {
		Scanner in = new Scanner(System.in);

		System.out.println("Mostrando lista de jugadores disponibles");
		for (Player player : players) {
			if (player.getState() == 'a') {
				System.out.println(player.getId());
			}
		}
		int choosedId = in.nextInt();
		for (Player player : players) {
			if (player.getId() == choosedId) {
				in.close();
				return player;
			}
		}
		in.close();

		return null;// No encontro player!!! CAMBIAR
	}

	public void effect(Player playerObjective) {
		if (playerObjective == null) {
			return;
		}
		Scanner in = new Scanner(System.in);
		// mostrarCartas(); NO MOSTRAR GUARDIA
		int cardNumber = in.nextInt();
		if (cardNumber == playerObjective.getHand().getCard1().getStrenght()) {
			playerObjective.setState('d');
			System.out.println("Lo funaste");
		}
		System.out.println("Le pifiaste capo.");
		in.close();
	}

}
