package test;

import model.*;
import cards.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestGuard {

	
	@Test
	void testCardCreation() {
		Card cardGuard = new Guard();

		assertEquals("Guardia", cardGuard.getName());
		assertEquals("Elige a otro jugador y nombra un personaje que no sea otra Guardia. Si el jugador elegido tiene esa carta en la mano queda eliminado de la ronda.", cardGuard.getEffectDescription());
		assertEquals(1, cardGuard.getStrenght());
	}

	
	@Test
	void testTarget() {
		//Se imprime por consola los ID de los jugadores
		Card cardGuard = new Guard();
		Hand handPlayer = new Hand(cardGuard);
		Player player1 = new Player(handPlayer);
		Player player2 = new Player(2, "Jugador 2");
		Player player3 = new Player(3, "Jugador 3");
		ArrayList<Player> listPlayers = new ArrayList<Player>();
		
		listPlayers.add(player1);
		listPlayers.add(player2);
		listPlayers.add(player3);
		
		player1.setTurn(true);
		
		assertNotEquals(player1, cardGuard.target(listPlayers));
		//El test esta pensado para que se elija al 2 por consola.
		assertEquals(player2, cardGuard.target(listPlayers));
	
	}

	@Test
	void testEffectAssertCard() {
		Card cardGuard = new Guard();
		Card cardHandmaid = new Handmaid();
		Hand handPlayer2 = new Hand(cardHandmaid);
		Player player2 = new Player(handPlayer2);
		
		
		
		//Por consola elegir el '4' o valor de la carta que se cree
		cardGuard.effect(player2);

		assertEquals('d', player2.getState());
	}
	
	@Test
	void testEffectNotAssertCard() {
		Card cardGuard = new Guard();
		Card cardHandmaid = new Handmaid();
		Hand handPlayer2 = new Hand(cardHandmaid);
		Player player2 = new Player(handPlayer2);
		
		
		
		//Por consola elegir un numero distinto a 4 o valor de la carta que se cree
		cardGuard.effect(player2);

		assertNotEquals('d', player2.getState());
	}
	

}
