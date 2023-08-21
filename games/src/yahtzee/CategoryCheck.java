package yahtzee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CategoryCheck {
	
	public static int ones(List<Die> dice) {
		int count = 0;
		for(Die die: dice) {
			if(die.getValue() == 1) {
				count ++;
			}
		}
		
		return count * 1; 
	}
	
	public static int twos(List<Die> dice) {
		int count = 0;
		for(Die die: dice) {
			if(die.getValue() == 2) {
				count ++;
			}
		}
		
		return count * 2; 
	}
	
	public static int threes(List<Die> dice) {
		int count = 0;
		for(Die die: dice) {
			if(die.getValue() == 3) {
				count ++;
			}
		}
		
		return count * 3; 
	}
	
	public static int fours(List<Die> dice) {
		int count = 0;
		for(Die die: dice) {
			if(die.getValue() == 4) {
				count ++;
			}
		}
		
		return count * 4; 
	}
	
	public static int fives(List<Die> dice) {
		int count = 0;
		for(Die die: dice) {
			if(die.getValue() == 5) {
				count ++;
			}
		}
		
		return count * 5; 
	}
	
	public static int sixes(List<Die> dice) {
		int count = 0;
		for(Die die: dice) {
			if(die.getValue() == 6) {
				count ++;
			}
		}
		
		return count * 6; 
	}
	
	
	public static int threeOfAKind(List<Die> dice) {
		int score = 0, sum = 0;
		
		List<Integer> values = new ArrayList<>();
		for(Die die: dice) {
			values.add(die.getValue());
			sum += die.getValue();
		}
		
		for(int i: values) {
			if(Collections.frequency(values, i) >= 3) {
				score = sum;
				break;
			}
		}
		
		return score;
	}
	
	public static int fourOfAKind(List<Die> dice) {
		int score = 0, sum = 0;
		
		List<Integer> values = new ArrayList<>();
		for(Die die: dice) {
			values.add(die.getValue());
			sum += die.getValue();
		}
		
		for(int i: values) {
			if(Collections.frequency(values, i) >= 4) {
				score = sum;
				break;
			}
		}
		
		return score;
	}
	
	public static int fullHouse(List<Die> dice) {
		int score = 0;
		
		List<Integer> values = new ArrayList<>();
		for(Die die: dice) {
			values.add(die.getValue());
		}
		
		Set<Integer> set = new HashSet<Integer>(values);
		
		if((set.size() == 2) && 
		(Collections.frequency(values, values.get(0)) == 2 || Collections.frequency(values, values.get(0)) == 3)) {
			score = 25;
		}
		
		return score;
	}
	
	public static int smallStraight(List<Die> dice) {
		int score = 0;
		
		List<Integer> values = new ArrayList<>();
		for(Die die: dice) {
			values.add(die.getValue());
		}
		
		Collections.sort(values);
		
		List<Integer> newList = new ArrayList<>();
		
		for(int i: values) {
			if(newList.contains(i) == false) {
				newList.add(i);
			}
		}
		
		int count = 1;
		
		for(int i = 1; i < newList.size(); i++) {
			if(newList.get(i) - newList.get(i-1) == 1) {
				count++;
				if(count == 4) {
					score = 30;
					break;
				}
			}
			else {
				count = 1;
			}
		}
		
		return score;
		
	}
	
	public static int largeStraight(List<Die> dice) {
		int score = 0;
		
		List<Integer> values = new ArrayList<>();
		for(Die die: dice) {
			values.add(die.getValue());
		}
		
		Collections.sort(values);
		
		int count = 1;
		
		for(int i = 1; i < 5; i++) {
			if(values.get(i) - values.get(i-1) == 1) {
				count ++;
			}
		}
		
		if(count == 5) {
			score = 40;
		}
		
		return score;
	}
	
	public static int yahtzee(List<Die> dice) {
		List<Integer> values = new ArrayList<>();
		for(Die die: dice) {
			values.add(die.getValue());
		}
		
		if(Collections.frequency(values, values.get(0)) == 5) {
			return 50;
		}
		
		return 0;
	}
	
	public static int chance(List<Die> dice) {
		int score = 0;
		for(Die die: dice) {
			score += die.getValue();
		}
		
		return score;
	}
}
