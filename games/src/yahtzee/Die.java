package yahtzee;

import java.util.Random;

public class Die {
	
	private int value;
	private boolean isFrozen = false;
	
	public int roll() {
		if(isFrozen)
			return value;
		Random r = new Random();
		value = r.nextInt(1, 7);
		return value;
	}
	
	public void freeze() {
		isFrozen = true;
	}
	
	public void unfreeze() {
		isFrozen = false;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		String result = String.valueOf(value);
		if(isFrozen) {
			result += "(FROZEN)";
		}
		return result;
	}
}
