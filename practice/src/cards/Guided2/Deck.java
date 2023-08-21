package cards;
import java.util.*;

public class Deck{
	private List<Card> cards = new ArrayList<Card>();
	
	private static final int MAX_RANK = 13;
	private static final int MAX_SUIT = 4;
	
	
	public Deck() {
		for(int rank = 1; rank <= Card.MAX_RANK; rank++) {
			for(int suit = 1; suit <= Card.MAX_SUIT; suit++) {
				cards.add(new Card(rank, suit));
			}
		}
	}
	
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card drawTop() {
		if(cards.size() == 0) {
			return new Card(0,0);
		}
		else {
			return cards.remove(cards.size()-1);
		}
	}
	
	public Card drawBottom() {
		if(cards.size() == 0) {
			return new Card(0,0);
		}
		else {
			return cards.remove(0);
		}
	}
	
	public Card drawRandom() {
		if(cards.size() == 0) {
			return new Card(0, 0);
		}
		else {
			Random random = new Random();
			return cards.remove(random.nextInt(0, cards.size()-1));
		}
	}
	
	public void returnTop(Card card) {
		cards.add(card);
	}
	
	public void returnBottom(Card card) {
		cards.add(0, card);
	}
	
	
	@Override
	public String toString() {
		return cards.toString();
	}
	
}
