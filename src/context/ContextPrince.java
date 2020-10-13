package context;

import cards.*;
import model.*;
public class ContextPrince extends Context{
	Card card;
	Player playerTarget;
	Deck gameDeck;
	
	public ContextPrince(Player playerOnTurn, Player playerTarget, Card card, Deck gameDeck){
		if(playerOnTurn == playerTarget)
			this.card = playerTarget.getCard2();
		else
			this.card = playerTarget.getCard1();
		this.playerTarget = playerTarget;
		this.gameDeck = gameDeck;
	}
	@Override
	public void apply() {
		if(needApply())
			applyTo(playerTarget);
		
	}

	@Override
	public boolean needApply() {
		return true;
	}
	
	private void applyTo(Player player) {
	    if(card.getCardName() == "Princesa"){
	    	player.setAlive(false);
	    }else{
	    	player.setCard1(gameDeck.drawCard());
	    }
	}

}
