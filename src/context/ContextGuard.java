package context;

import cards.Card;
import model.Player;

public class ContextGuard extends Context{

//	private Player playerTurn;
	private Player playerTarget;
//	private Card card;
	private String guess;
	
	public ContextGuard(Player playerTurn, Player playerTarget, Card card, String guess) {
//	    this.playerTurn = playerTurn;
	    this.playerTarget = playerTarget;
//	    this.card = card;
	    this.guess = guess;
	}
	
	@Override
	public void apply() {
		if (needApply()) {
			applyTo(this.playerTarget);;
		}
	}

	@Override
	public boolean needApply() {
		// Ver de CARD sea abtracta y crear metodo para comparar CARD con STRING
		return this.guess.equals(playerTarget.getCard1().getCardName());
	}
	
	private void applyTo(Player player) {
	    player.setAlive(false);
	}

}
