package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cards.*;
import context.Context;
import context.ContextPrincess;
import model.*;
public class TestContextPrincess {
	@Test
	public void adivinaCarta() {
		// Se reparte mano
		Player player1 = new Player(new Guard());
		
		// Levanta del mazo
		player1.setCard2(new Princess());
		
		// Se crea Conexto
		Context context = new ContextPrincess(player1, player1.getCard2());
		
		// Jugar
		player1.playCard(context);
		
		// Test
		assertEquals(false, player1.isAlive());
	}
}
