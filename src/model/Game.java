package model;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import context.Context;


public class Game {

//	private final int cantPlayerMax = 4;
//	private final int cantPlayerMin = 2;
	private int pointToWin;
	private boolean gameEnabled;
	private Player playerOnTurn;
	private List<Player> playerList = new ArrayList<Player>();
	private Deck deck = new Deck();

	public Game(Player player1, Player player2) {
		playerList.add(player1);
		playerList.add(player2);

		this.gameEnabled = true;
		this.pointToWin = 7;

		setRound();

		player1.setTurn(true);
		playerOnTurn = player1;
	}

	public Game(Player player1, Player player2, Player player3) {
		playerList.add(player1);
		playerList.add(player2);
		playerList.add(player3);
		this.gameEnabled = true;
		this.pointToWin = 5;
		setRound();
		player1.setTurn(true);
		playerOnTurn = player1;
	}
	public Game(Player player1, Player player2, Player player3, Player player4) {
		playerList.add(player1);
		playerList.add(player2);
		playerList.add(player3);
		playerList.add(player4);
		this.gameEnabled = true;
		this.pointToWin = 4;
		setRound();
		player1.setTurn(true);
		playerOnTurn = player1;
	}
	
	public List<Player> getPlayerList() {
		return this.playerList;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}
	
	public void setTurn(Player playerOnTurn) {
		boolean flag = false;
		int cont = 0;

		for (Player player : playerList) {
			if(flag){
				if(player.isAlive()){
					player.setTurn(true);
					return;
				}
			}
			cont++;
			if(player == playerOnTurn){
				flag = true;
				if(cont == playerList.size()){
					for (int i = 0; i < cont; i++) {
						if (playerList.get(i).isAlive()) {
							playerList.get(i).setTurn(true);
							return;
						}
					}
				}
			
			}
		}
	}

	public void endRoud() {
		int cantAct = cantActDeActivos();

		for (Player player : playerList) {
			if (cantAct == 1 && player.isAlive()) {
				setPoints(player);
				if (player.getPoints() >= this.pointToWin) {
					this.endGame(player);
					return;
				}
				player.setTurn(true);
			}
			if (cantAct != 1 && player.isAlive()) {
				setPoints(player);
				if (player.getPoints() >= this.pointToWin) {
					this.endGame(player);
					return;
				}
				player.setTurn(true);
			}
			player.setCard1(null);
			player.setCard2(null);
		}

		setRound();
	}

	public void checkRound() {
		int cantAct = cantActDeActivos();
		if (cantAct == 1) {
			endRoud();
			return;
		}
		if(this.deck.notEmptyDeck())
			return;
		endRoud();
	}

	private int cantActDeActivos() {
		int cantAct = 0;
		for (Player player : playerList) {
			if (player.isAlive() == true)
				cantAct += 1;
		}

		return cantAct;
	}

	private void setPoints(Player player) {
		player.addPoint();
	}
	
	public void setRound() {
		this.deck.resetDeck();
		Iterator<Player> iterator = playerList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setCard1(this.deck.drawCard());
		}
	}

	private void endGame(Player player) {
		gameEnabled = false;
		System.out.println("Partida finalizada, ganó: " + player.getName());
	}
	
	public void grabCard(Player player) {
		player.setCard2(deck.drawCard());
	}

	public boolean activeGame(){
		return gameEnabled;
	}

	public void playCard(Player player, Context context) {		
		player.setCard1(player.getCard2());
		player.setCard2(null);
		
		player.playCard(context);
		
		this.checkRound();
		setTurn(player);
	}

	public Player getPlayerOnTurn() {
		return playerOnTurn;
	}
}
