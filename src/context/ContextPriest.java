package context;

import model.Player;

public class ContextPriest extends Context {
	
	private Player playerTarget;
	
	public ContextPriest(Player playerTarget) {
		this.playerTarget = playerTarget;
	}
	

	@Override
	public void apply() {
		
//		if(playerTarget.isProtected()) {
//			System.out.println("No se puede targetear a este jugador");
//		}
//		else
//		{
//			System.out.println(playerTarget.getCard1());
//		}
		
		System.out.println(playerTarget.getCard1());
		
	}

	@Override
	public boolean needApply() {
		return true;
	}

}
