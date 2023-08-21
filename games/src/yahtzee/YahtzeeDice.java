package yahtzee;

import java.util.ArrayList;
import java.util.List;

public class YahtzeeDice {
	
	private List<Die> dice;
	
	public YahtzeeDice() {
		dice = new ArrayList<Die>();
		
		for(int i = 0; i < 5; i++) {
			dice.add(new Die());
		}
	}
	
	public List<Die> yahtzeeRoll() {
		for(Die die: dice) {
			die.roll();
		}
		
		return dice;
	}
	
	@Override
	public String toString() {
		return dice.toString();
	}
}