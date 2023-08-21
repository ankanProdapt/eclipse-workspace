package trump;
import java.util.*;

public class Hand {
	private List<Card> hand;
	
	public Hand(Deck deck, int N) {
		hand = new ArrayList<Card>();
		
		for(int i = 0; i < N; i++) {
			hand.add(deck.drawCard());
		}
	}
	
	public int getSize() {
		return hand.size();
	}
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public Card drawCard() {
		if(hand.size() == 0) {
			System.out.println("No Cards Available");
			return null;
		}
		else {
			return hand.remove(0);
		}
	}
	
	@Override
	public String toString() {
		return hand.toString();
	}
}
