package cards;

import model.*;
import java.util.List;

import java.util.Scanner;

public class Guard extends Card {
	static final int STRENGHT = 1;
	static final String NAME = "Guardia";
	static final String EFFECT_DESCRIPTION = "Elige a otro jugador y nombra un personaje que no sea otra Guardia. Si el jugador elegido tiene esa carta en la mano queda eliminado de la ronda.";

	public Guard() {
		super(STRENGHT, NAME, EFFECT_DESCRIPTION);
	}

	public Player target(List<Player> players) {
		Scanner in = new Scanner(System.in);

		System.out.println("Mostrando lista de jugadores disponibles");
		for (Player player : players) {
			if (player.getState() == 'a' && player.getIsTurn() == false) {
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
		System.out.println("Elegime el numerito amigo.");
		int cardNumber = in.nextInt();
		if (cardNumber == playerObjective.getHand().getCard1().getStrenght()) {
			playerObjective.setState('d');
			System.out.println("Lo funaste");
		}
		else 
			System.out.println("Le pifiaste capo.");
		
		in.close();
	}

}

