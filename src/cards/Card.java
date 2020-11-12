package cards;

 public abstract class Card {

		public abstract int getStrength();
		public abstract String getName();
		public abstract String getEffectDesc();
		public abstract boolean isNeedsTarget();

		
		public String getImagePath() {
			return "card" + getName();
		
		}
		
	
}
