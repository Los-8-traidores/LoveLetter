package context;

import model.Player;
import screen.Screen;

public class ContextPriest extends Context {

	private Player playerTarget;

	public ContextPriest(Player playerTarget) {
		this.playerTarget = playerTarget;
	}

	@Override
	public void apply() {
		if (needApply())
			applyTo(playerTarget);
	}

	@Override
	public boolean needApply() {
		return true;
	}

	private void applyTo(Player player) {
		Screen.showPlayerCard(player);
	}

}
