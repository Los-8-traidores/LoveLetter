package context;

import cards.Card;
import model.Player;

public class ContextBaron extends Context{
	Player playerOnTurn;
	Player playerTarget;
	
	public ContextBaron(Player playerOnTurn, Player playerTarget, Card card){
		this.playerOnTurn = playerOnTurn;
		this.playerTarget = playerTarget;
	}
	
	@Override
	public void apply() {
		if(needApply() && (playerTarget.getCard1().getCardStrength() > playerOnTurn.getCard1().getCardStrength()))
			applyTo(playerOnTurn);
		else if (needApply())
			applyTo(playerTarget);
		
	}

	@Override
	public boolean needApply() {
		// Es mejor que carta se sepa comparar con otra carta y que player tenga un metodo que invoque a ese metodo
		return !(playerTarget.getCard1().getCardStrength() == playerOnTurn.getCard1().getCardStrength()) && !playerTarget.isProtected();
	}
	
	private void applyTo(Player player) {
		player.setAlive(false);
	}
}
