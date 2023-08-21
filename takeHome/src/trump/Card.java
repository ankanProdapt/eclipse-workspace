package trump;

import java.util.*;

public class Card {
	
	private String playerName;
	private Map<Category, Integer> categories;
	
	
	public Card(String playerName) {
		this.playerName = playerName;
		categories = new HashMap<Category, Integer>();
	}
	
	public void addCategory(Category category, int score) {
		categories.put(category, score);
	}
	
	
	
	
	public int trumps(Card other, Category category) {
		return category.compare(this.categories.get(category),
							other.categories.get(category));
	}
	
	
	
	@Override
	public String toString() {
		String result = playerName + ": ";
		result += categories.toString();
		
		return result;
	}
}
