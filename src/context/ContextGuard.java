package context;

import cards.Card;
import model.Player;

public class ContextGuard extends Context{

//	private Player playerTurn;
	private Player playerTarget;
//	private Card card;
	private String guess;
	private boolean acierto;
	
	public ContextGuard(Player playerTurn, Player playerTarget, Card card, String guess) {
//	    this.playerTurn = playerTurn;
	    this.playerTarget = playerTarget;
//	    this.card = card;
	    this.guess = guess;
	}
	
	@Override
	public void apply() {
		if (needApply()) {
			applyTo(this.playerTarget);
			acierto = true;
		}else {acierto = false;}
		
	}

	@Override
	public boolean needApply() {
		// Ver de CARD sea abtracta y crear metodo para comparar CARD con STRING
		return this.guess.equals(playerTarget.getCard1().getName());
	}
	
	private void applyTo(Player player) {
	    player.setAlive(false);
	    
	}
	
	public boolean getAcierto(){
		return acierto;
	}

}
