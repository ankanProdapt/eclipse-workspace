package trump;
import java.util.*;

public class Deck {
	private List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<Card>();
	}
	
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public Card drawCard() {
		if(cards.size() == 0) {
			System.out.println("No Cards Available");
			return null;
		}
		else {
			return cards.remove(0);
		}
	}
	
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	
	
	@Override
	public String toString() {
		return cards.toString();
	}
}
