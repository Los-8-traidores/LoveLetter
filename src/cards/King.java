package cards;

import java.util.List;
import java.util.Scanner;

import model.Player;

public class King extends Card {
	static final int STRENGHT = 6;
 	static final String NAME = "Rey";
 	static final String EFFECT_DESCRIPTION = "Elige a otro jugador y cambia la carta de tu mano por la carta de su mano.";
 			
	public King() {
		super(STRENGHT, NAME, EFFECT_DESCRIPTION);
	}

	public Player target(List<Player> players, Scanner in) {


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

		return null;// No encontro player!!! CAMBIAR
	}
	
	public Player targetOnTurn(List<Player> players) {
		for(Player player : players) {
			if (player.getIsTurn() == true){
				return player;
			}
		}
		return null;//nunca tendria que llegar a este punto.
		//lo dejo para evitar que me tire warnings
	}

	public void effect(List<Player> players) {
		Scanner in = new Scanner(System.in); 
		Player targetPlayer = this.target(players, in);
		Player playerOnTurn = this.targetOnTurn(players);
		
		Card auxCard = targetPlayer.getHand().getCard1();
		targetPlayer.getHand().setCard1(playerOnTurn.getHand().getCard1());
		//targetPlayer.setCard(playerOnTurn.getHand().getCard1());
		playerOnTurn.getHand().setCard1(auxCard);
		in.close();
	}

}
