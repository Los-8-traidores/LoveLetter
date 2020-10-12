
public class ContextKing extends Context{
	Player playerOnTurn;
	Player playerTarget;
	public ContextKing(Player playerOnTurn, Player playerTarget, Card card){
		this.playerOnTurn = playerOnTurn;
		this.playerTarget = playerTarget;
	}
	
	@Override
	public void apply() {
		if(needApply())
			applyTo(playerOnTurn, playerTarget);
		
	}

	@Override
	public boolean needApply() {
		return true;
	}
	
	private void applyTo(Player playerOnTurn, Player playerTarget) {
		Card auxCard = playerTarget.getCard1();
		playerTarget.setCard1(playerOnTurn.getCard1());
		playerOnTurn.setCard1(auxCard);
	}
}
