package context;

import cards.Card;
import model.Player;

public class ContextCountess extends Context {
	
	private Player playerOnTurn;

	public ContextCountess(Player playerOnTurn, Card card){
		this.playerOnTurn= playerOnTurn;		
	}
	
	@Override
	public void apply() {
		return;	
	}

	@Override
	public boolean needApply() {
		return true;
	}

}
