package context;

import cards.Card;
import model.Deck;
import model.Player;

public class ContextBuilder {
	
	private Context context;
	
	public ContextBuilder(Player playerOnTurn, Player playerTarget, Card card, String guess, Deck gameDeck) {
		
		if(card.isName("Guardia")) {
			context = new ContextGuard(playerOnTurn, playerTarget, card, guess);
			return;
		}
		
		if(card.isName("Princesa")) {
			context = new ContextPrincess(playerOnTurn, card);
			return;
		}
		
		if(card.isName("Mucama")) {
			context = new ContextHandmaid(playerOnTurn);
			return;
		}
		
		if(card.isName("Baron")) {
			context = new ContextBaron(playerOnTurn, playerTarget, card);
			return;
		}
		
		if(card.isName("Principe")) {
			context = new ContextPrince(playerOnTurn, playerTarget, card, gameDeck);
			return;
		}
		
		if(card.isName("Rey")) {
			context = new ContextKing(playerOnTurn, playerTarget, card);
			return;
		}
		
		if(card.isName("Condesa")) {
			context = new ContextCountess(playerOnTurn, card);
			return;
		}
		
		if(card.isName("Sacerdote")) {
			context = new ContextPriest(playerTarget);
			return;
		}
			
	}
	
	public Context getContext() {
		return context;
	}
}
