package test;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cards.*;
import context.Context;
import context.ContextHandmaid;
import context.ContextPriest;
import model.*;

public class TestContextPriest {
		@Test
		
		public void ShowCardNoHandMaid() {
			// Creo los jugadores
			Player playerOne = new Player(new Priest());
			Player playerTwo = new Player(new Guard());
			
			// Levanta del mazo
			
			playerOne.setCard2(new Prince());
			
			//Contexto
			
			Context contexto = new ContextPriest(playerTwo);
			
			// Juego
			
			playerOne.playCard(contexto);
		}
		
		@Test
		public void ShowCardHandMaid() {
			
			//Jugadores
			Player playerOne = new Player(new Handmaid());
			Player playerTwo = new Player(new Priest());
			
			
			// Levanto
			playerOne.setCard2(new Guard());
			
			//contexto
			Context contexto1 = new ContextHandmaid(playerOne, playerTwo, playerOne.getCard1(), "Handmaid");
			
			// juego carta
			playerOne.playCard(contexto1);
			
			// contexto priest
			
			Context contexto2 = new ContextPriest(playerTwo);
			
			// juego carta
			playerTwo.playCard(contexto2);
		}
		
}
