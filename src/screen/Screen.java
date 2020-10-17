package screen;

import java.util.List;
import java.io.PrintStream;
import java.util.Scanner;

import cards.Card;
import model.*;

public class Screen {
	protected static Scanner in = new Scanner(System.in);
	protected static PrintStream out = new PrintStream(System.out);

	public static void showPlayerList(List<Player> players) {
		out.println("Lista de jugadores disponibles para elegir:");
		for (Player player : players) {
			if (player.isAlive() && player.isProtected() == false && player.isTurn() == false)
				out.println(player.getId());
		}
	}

	public static int enterChosenPlayer() {
		out.print("Elegir numero de jugador:");
		// Preguntar si es necesario validar que se elija a un jugador correcto o se
		// asume que esta ok
		return in.nextInt();
	}

	public static void showCards(Card card1, Card card2) {
		out.println("Cartas disponibles:");
		out.println(card1.getName() + card1.getEffectDesc());
		out.println(card2.getName() + card2.getEffectDesc());
	}

	public static String enterChosenCard() {
		out.println("Escribir nombre de carta:");
		return in.nextLine();
	}

	public static void showAllCardsExceptGuard() {
		out.println("Cartas disponibles:");
		out.println("Sacerdote");
		out.println("Bar�n");
		out.println("Mucama");
		out.println("Pr�ncipe");
		out.println("Rey");
		out.println("Condesa");
		out.println("Princesa");
	}

	// Esto graficamente va a ser para un solo jugador
	public static void showPlayerCard(Player player) {
		out.println("La carta del jugador: " + player.getName() + " es: ");
		out.println(player.getCard1().getName() + ": " + player.getCard1().getEffectDesc());

	}

}