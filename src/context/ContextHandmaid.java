package context;

import model.Player;

public class ContextHandmaid extends Context{

	private Player playerTurn;

	public ContextHandmaid(Player playerTurn) {
	    this.playerTurn = playerTurn;

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
