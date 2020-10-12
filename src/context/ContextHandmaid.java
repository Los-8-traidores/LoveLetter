package context;

import cards.Card;
import model.Player;

public class ContextHandmaid extends Context{

	private Player playerTurn;
//	private Player playerTarget;
//	private Card card;
//	private String guess;
	
	public ContextHandmaid(Player playerTurn, Player playerTarget, Card card, String guess) {
	    this.playerTurn = playerTurn;
//	    this.playerTarget = playerTarget;
//	    this.card = card;
//	    this.guess = gu
	}
	
	@Override
	public void apply() {
		if(needApply())
			applyTo(playerTurn);
		
	}

	@Override
	public boolean needApply() {
		return true;
	}
	
	private void applyTo(Player player) {
	    player.setProtected(true);
	}

}
