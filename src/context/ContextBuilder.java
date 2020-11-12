package context;

import cards.Card;
import model.Deck;
import model.Player;

public class ContextBuilder {
	
	private Context context;
	
	public ContextBuilder(Player playerOnTurn, Player playerTarget, Card card, String guess, Deck gameDeck) {
		
		if(card.getName().equals("Guardia")) {
			context = new ContextGuard(playerOnTurn, playerTarget, card, guess);
			return;
		}
		
		if(card.getName().equals("Princesa")) {
			context = new ContextPrincess(playerOnTurn, card);
			return;
		}
		
		if(card.getName().equals("Mucama")) {
			context = new ContextHandmaid(playerOnTurn, playerTarget, card, guess);
			return;
		}
		
		if(card.getName().equals("Baron")) {
			context = new ContextBaron(playerOnTurn, playerTarget, card);
			return;
		}
		
		if(card.getName().equals("Principe")) {
			context = new ContextPrince(playerOnTurn, playerTarget, card, gameDeck);
			return;
		}
		
		if(card.getName().equals("Rey")) {
			context = new ContextKing(playerOnTurn, playerTarget, card);
			return;
		}
		
		if(card.getName().equals("Condesa")) {
			context = new ContextCountess(playerOnTurn, card);
			return;
		}
		
		if(card.getName().equals("Sacerdote")) {
			context = new ContextPriest(playerTarget);
			return;
		}
			
	}
	
	public Context getContext() {
		return context;
	}
}
