package model;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import cards.Card;

public class Game {
	
	// Atributos
	private final int cantPlayerMax = 4;
	private final int cantPlayerMin = 2;
	private int pointToWin;
	private boolean gameEnabled;
	private List<Player> playerList = new ArrayList<Player>();
	private Deck deck = new Deck();
	//private HashMap<Integer, Card> playedCard = new HashMap<Integer, Card>(); // Esto o queda aca o se guarda en cada player
	
	// Ctor con 2 jugadores VER QUE ONDA ESTO
	public Game(Player player1, Player player2) {
		playerList.add(player1);
		playerList.add(player2);
		
		this.gameEnabled = true;
		this.pointToWin = 7;
		
		setRound();
		
		player1.setTurn(true);
	}
	
	// Ctor por defecto
	public Game() {
		this.gameEnabled = false;
	}
	
	public Card getCard() {
		return this.deck.sacarCarta();
	}
	
	// Agregar jugadores a la partida
	public void newPlayer(Player player) {
		
		if (playerList.size() < cantPlayerMax) {
			playerList.add(player);
			
			switch (playerList.size()) {
			case 2:
				this.pointToWin = 7;
				break;
			case 3:
				this.pointToWin = 5;
				break;
			case 4:
				this.pointToWin = 4;
				break;

			default:
				break;
			}
		}
		
		else if (playerList.size() > cantPlayerMax)
			// TODO aca iria la exeption
		
		if (playerList.size() >= cantPlayerMin && playerList.size() <= cantPlayerMax)
			this.gameEnabled = true;
	}
	
	// Quitar jugadores de la partida
		public void deletePlayer(Player player) {
			
			if (playerList.remove(player)) {;
				
				switch (playerList.size()) {
				case 2:
					this.pointToWin = 7;
					break;
				case 3:
					this.pointToWin = 5;
					break;
				case 4:
					this.pointToWin = 4;
					break;

				default:
					break;
				}
			}
			
			if (playerList.size() < cantPlayerMin)
				this.gameEnabled = false;
		}
	
	// Obterner listado de jugadores
	public List<Player> getPlayerList() {
		return this.playerList;
	}
	
	// Para modificar la lista.
	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}
	
	// Para guardar las cartas jugadas
//	public void setPlayedCard(Player player) {
//		this.playedCard.put(player.getId(), player.playedCard());
//	}
	
	// Asignar turno
	public void firstPlayer(Player player) {
		player.setTurn(true);
	}
	
	public void setTurn() {
		boolean flag = false;
		int cont = 0;
		
		for (Player player : playerList) {
			if (flag) {
				player.setTurn(true);
				this.playCard(player);
				return;
			}
			
			if (player.getIsTurn() && !flag) {
				flag = true;
				player.setTurn(false);
			}
			
			cont++;
			
			if (cont == playerList.size()) {
				for (int i = 0; i < cont; i++) {
					if (playerList.get(i).getState() == 'a') {
						playerList.get(i).setTurn(true);
						//this.playCard(player);
						return;
					}
				}

				playerList.get(0).setTurn(true);
			}
		}
	}
	
	public void grabCard(Player player){
		
		player.setCard(deck.sacarCarta());
	}
	
	public void endRoud() {
		//Player winPlayer = new Player();
		int cantAct = cantActDeActivos();
		
		// Si hay 1 activo le asigno un pto
		for (Player player : playerList) {
			if (cantAct == 1 && player.getState() == 'a') {
				setPoints(player);
				firstPlayer(player);
			}
			player.getHand().resetHand();
		}
		
		// Gana el de la carta mas alta
		// TODO me parece que lo mejor es que cada player tenga una lista con sus cartas jugadas o la sumatoria de los puntos
		// Asi comparamos la ult y gana la de mayor valor o en caso de empate gana la suma de todas las jugadas			
		
		// si alguno alcanzo la cant max, gana el juego
		for (Player player : playerList) {	
			if (player.getPoints() >= this.pointToWin) {
				this.endGame(player);
				return;
			}
		}
			
		setRound();
	}
	
	public void checkRound() {
		int cantAct = cantActDeActivos();
		if (cantAct == 1) {
			endRoud();
			return;
		}
	}
	
	private int cantActDeActivos() {
		int cantAct = 0;
		for (Player player : playerList) {
			if (player.getState() == 'a')
				cantAct += 1;
		}
		
		return cantAct;
	}
	
	private void setPoints(Player player) {
		player.setPoints();
	}
	
	public void setRound() {
		this.deck.resetDeck();
		int i = 0;
		Iterator<Player> iterator = playerList.iterator();

		while (iterator.hasNext()) {
			iterator.next().setCard(this.deck.cards[i]);
			i++;
		}

    }
	
	private void playCard(Player player) {
		
		Card inGameCard = player.chooseCard(1);//CAMBIAR! PARAMETRO
		inGameCard.effect(inGameCard.target(this.playerList));
		
		this.checkRound();
	}
	
	private void endGame(Player player) {
		// TODO Despues vemos que se hace aca
		System.out.println("Partida finalizada, ganó: " + player.getName());
	}
	
	
}