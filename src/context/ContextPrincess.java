package context;

import cards.Card;
import model.Player;

public class ContextPrincess extends Context {
	Player playerOnTurn;
	
	public ContextPrincess(Player playerOnTurn, Card card){
		this.playerOnTurn= playerOnTurn;		
	}
	
	@Override
	public void apply() {
		if(needApply())
			applyTo(playerOnTurn);
		
	}

	@Override
	public boolean needApply() {
		return true;
	}

	private void applyTo(Player player) {
	    player.setAlive(false);
	}
}
